package com.wilson.elston.babycare;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, DiscussionsFragment.OnFragmentInteractionListener,ExperiencesFragment.OnFragmentInteractionListener , VaccinationFragment.OnFragmentInteractionListener{

    private TextView mTextMessage;
    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth.AuthStateListener mauthStateListener;
    private FirebaseAuth mauth;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                  setTitle("Home");
                    HomeFragment homeFragment=new HomeFragment();
                    FragmentTransaction fragmentTransaction1= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame,homeFragment,"Home");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_discussion:
                    setTitle("Birth Club");
                    DiscussionsFragment discussionsFragment=new DiscussionsFragment();
                    FragmentTransaction fragmentTransaction2= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame,discussionsFragment,"Home");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_experiences:
                    setTitle("Memories");
                    ExperiencesFragment experiencesFragment =new ExperiencesFragment();
                    FragmentTransaction fragmentTransaction3= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.frame, experiencesFragment,"Home");
                    fragmentTransaction3.commit();
                    return true;
                case R.id.navigation_vaccination:
                    setTitle("Vaccination");
                    VaccinationFragment vaccinationFragment =new VaccinationFragment();
                    FragmentTransaction fragmentTransaction4=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.frame,vaccinationFragment,"Vaccination");
                    fragmentTransaction4.commit();
                    return true;

            }
            //these cases contain the fragments which are present in the bottom navigation bar
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mauth = FirebaseAuth.getInstance();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Home");
        HomeFragment homeFragment=new HomeFragment();
        FragmentTransaction fragmentTransaction1= getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame,homeFragment,"Home");
        fragmentTransaction1.commit();


        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        mauthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(networkInfo!=null && networkInfo.isConnected())
                {
                    if (firebaseAuth.getCurrentUser() == null) {
                        startActivityForResult(
                                AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setAvailableProviders(Arrays.asList(
                                                new AuthUI.IdpConfig.GoogleBuilder().build(),
                                                new AuthUI.IdpConfig.EmailBuilder().build())
                                        ).setTheme(R.style.AppTheme)
                                        .setLogo(R.drawable.icon_big)
                                        .setIsSmartLockEnabled(false)
                                        .build(),
                                RC_SIGN_IN);
                    }
                }
                //the main if condition checks if the network connectin is switched on
                //if the internet connection is on it will then check if the user is logged in via the second
                //if condition.
                else
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("No Internet Connection");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog=alertDialogBuilder.create();
                    alertDialog.show();
                }
                //else condition will execute only if the internet connection is not switched on
                //it will generate an alert dialog and exit the app when the user clicks EXIT.

            }
        };

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String email=FirebaseAuth.getInstance().getCurrentUser().getEmail();
                String name=FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                String id=FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase.getInstance().getReference().child("Users").child(id).child("Name").setValue(name);
                FirebaseDatabase.getInstance().getReference().child("Users").child(id).child("Email").setValue(email);
                FirebaseDatabase.getInstance().getReference().child("Users").child(id).setValue(id);
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
    //this method is used to check if the user has signed in or not
    //if the user is signed in the if condition will be executed and the users data will be added to the database
    //or else the a toast message will be displayed

    @Override
    protected void onResume() {
        super.onResume();
        mauth.addAuthStateListener(mauthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mauth.removeAuthStateListener(mauthStateListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package com.wilson.elston.babycare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class third extends AppCompatActivity {

    ListView day_care;
    FirebaseListAdapter<Day_Care> adapter;
    DatabaseReference data;
    TextView cname;
    ImageButton website;
    ProgressBar pb4;
    ImageButton location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        day_care=(ListView) findViewById(R.id.day_care);
        pb4=(ProgressBar) findViewById(R.id.pb4);


        Toast.makeText(third.this,"Second Activity",Toast.LENGTH_LONG).show();


        pb4.setVisibility(View.VISIBLE);
        displaydaycare();





    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
    private void displaydaycare()
    {
        adapter=new FirebaseListAdapter<Day_Care>(third.this,Day_Care.class,R.layout.day_care_layout,
                FirebaseDatabase.getInstance().getReference().child("DayCare")) {
            @Override
            protected void populateView(View v, Day_Care model, final int position) {
                pb4.setVisibility(View.INVISIBLE);
                cname=v.findViewById(R.id.cname);
                website=v.findViewById(R.id.website);
                location=v.findViewById(R.id.location);
                final Uri url= Uri.parse(adapter.getItem(position).getWebsite_url());

                cname.setText(model.getCenter_Name());
                website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(url);
                        startActivity(i);
                    }
                });
                location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse(adapter.getItem(position).getLocation()));
                        startActivity(intent);
                    }
                });


            }
        };
        day_care.setAdapter(adapter);
    }
}

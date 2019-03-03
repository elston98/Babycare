package com.wilson.elston.babycare;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class second extends AppCompatActivity {


    DatabaseReference data;
    EditText input;

    private FirebaseListAdapter<Posts> adapter;

    ProgressDialog progressDialog;

    ListView faq_list;
    TextView postsText;
    TextView postsUser;

    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        fab=(FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = (EditText) findViewById(R.id.input);

                String text=input.getText().toString();
                if(text.equals("")|| text.length()==0)
                {
                    Toast.makeText(second.this,"Enter the text",Toast.LENGTH_LONG).show();
                }
                else
                {

                    FirebaseDatabase.getInstance()
                            .getReference()
                            .child("Posts")
                            .push()
                            .setValue(new Posts(input.getText().toString(),
                                    FirebaseAuth.getInstance()
                                            .getCurrentUser()
                                            .getDisplayName())
                            );


                    // Clear the input
                    input.setText("");

                }


            }
        });
        faq_list=(ListView) findViewById(R.id.faq_list);

        displayfaq();





    }
    @SuppressLint("NewApi")
    private void displayfaq() {

        adapter=new FirebaseListAdapter<Posts>(second.this,Posts.class,R.layout.post,FirebaseDatabase.getInstance().getReference().child("Posts")) {
            @Override
            protected void populateView(View v, Posts model, int position) {
                postsText=v.findViewById(R.id.posts_text);
                postsUser=v.findViewById(R.id.posts_user);

                postsUser.setText(model.getPostUser());
                postsText.setText(model.getPostText());

            }
        };
        faq_list.setAdapter(adapter);
        faq_list.smoothScrollToPosition(adapter.getCount()-1);
        faq_list.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}

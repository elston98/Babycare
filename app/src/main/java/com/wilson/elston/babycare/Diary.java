package com.wilson.elston.babycare;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Diary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);




        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et1=(EditText) findViewById(R.id.et1);
                EditText et2=(EditText) findViewById(R.id.et2);

                FirebaseDatabase data=FirebaseDatabase.getInstance();
                String id=FirebaseAuth.getInstance().getUid();
                data.getReference().child("Diary").child(id).push().setValue(new note_content(et1.getText().toString(),et2.getText().toString()));
                //content and the title of the note is saved to the database
                Toast.makeText(Diary.this,"Your Note is successfully added",Toast.LENGTH_LONG).show();
                Diary.super.onBackPressed(); //To go the previous activity once the note is saved.


            }
        });
    }
}

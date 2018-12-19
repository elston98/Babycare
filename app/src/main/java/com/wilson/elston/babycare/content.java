package com.wilson.elston.babycare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String id=FirebaseAuth.getInstance().getUid();

        Intent intent=getIntent();
        String cont=intent.getStringExtra("content");
        TextView tv=(TextView) findViewById(R.id.tvcon);
        tv.setText(cont);

    }
}

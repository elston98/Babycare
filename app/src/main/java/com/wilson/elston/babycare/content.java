package com.wilson.elston.babycare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.images.ImageRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent=getIntent();
        String content=intent.getStringExtra("content");

        TextView tvcon=(TextView) findViewById(R.id.tvcon);
        Toast.makeText(content.this,content,Toast.LENGTH_LONG).show();
        tvcon.setText(content);
    }
}

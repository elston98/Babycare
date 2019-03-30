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
        String content=intent.getStringExtra("content"); //gettting the content of the note from the previous
                                                                //activity.

        TextView tvcon=(TextView) findViewById(R.id.tvcon);
        tvcon.setText(content);     //displaying the content of the respective note.
    }
}

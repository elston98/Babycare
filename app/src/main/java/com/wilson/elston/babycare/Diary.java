package com.wilson.elston.babycare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Diary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        Toast.makeText(Diary.this,"This is where you type the text",Toast.LENGTH_LONG).show();

    }
}

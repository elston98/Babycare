package com.wilson.elston.babycare;

import android.content.Intent;
import android.drm.DrmInfoRequest;
import android.drm.DrmStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class baby_guide extends AppCompatActivity {
    int tb1count=1;
    int tb2count=1;
    int tb3count=1;
    int tb4count=1;
    int tb5count=1;
    int tb6count=1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby_guide);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Button b1=(Button) findViewById(R.id.btn1);
        Button b2=(Button) findViewById(R.id.btn2);
        Button b3=(Button) findViewById(R.id.btn3);
        Button b4=(Button) findViewById(R.id.btn4);


        final Intent intent=new Intent(baby_guide.this,Information.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("val","Handling a new born");
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("val","Bonding & Soothing");
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("val","Bathing Basics");
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("val","Feeding Baby");
                startActivity(intent);
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                onBackPressed();
                return true;
            }
        }
        return true;

    }

}

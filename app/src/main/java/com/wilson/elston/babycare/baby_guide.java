package com.wilson.elston.babycare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


        Button b1=(Button) findViewById(R.id.b1);
        Button b2=(Button) findViewById(R.id.b2);
        Button b3=(Button) findViewById(R.id.save);
        Button b4=(Button) findViewById(R.id.b4);
        Button b5=(Button) findViewById(R.id.b5);
        Button b6=(Button) findViewById(R.id.b6);
        final TextView t2=(TextView) findViewById(R.id.tb2);
        final TextView t1=(TextView) findViewById(R.id.tb1);
        final TextView t3=(TextView) findViewById(R.id.tb3);
        final TextView t4=(TextView) findViewById(R.id.tb4);
        final TextView t5=(TextView) findViewById(R.id.tb5);
        final TextView t6=(TextView) findViewById(R.id.tb6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               tb1count =tb1count +1;
               if(tb1count%2==0)
               {
                   t1.setVisibility(View.VISIBLE);
               }

               else
               {
                   t1.setVisibility(View.GONE);
               }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tb2count=tb2count+1;
                if(tb2count%2==0)
                {
                    t2.setVisibility(View.VISIBLE);
                }
                else {
                    t2.setVisibility(View.GONE);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tb3count=tb3count+1;
                if(tb3count%2==0)
                {
                    t3.setVisibility(View.VISIBLE);
                }
                else {
                    t3.setVisibility(View.GONE);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tb4count=tb4count+1;
                if(tb4count%2==0)
                {
                    t4.setVisibility(View.VISIBLE);
                }
                else {
                    t4.setVisibility(View.GONE);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tb5count=tb5count+1;
                if(tb5count%2==0)
                {
                    t5.setVisibility(View.VISIBLE);
                }
                else {
                    t5.setVisibility(View.GONE);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tb6count=tb6count+1;
                if(tb6count%2==0)
                {
                    t6.setVisibility(View.VISIBLE);
                }
                else {
                    t6.setVisibility(View.GONE);
                }
            }
        });
    }

}

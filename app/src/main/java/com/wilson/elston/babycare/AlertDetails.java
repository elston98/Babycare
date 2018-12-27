package com.wilson.elston.babycare;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

class AlertDetails extends AppCompatActivity {
    public void main(String args[])
    {
        display();
    }
    public void display()
    {
        Toast.makeText(AlertDetails.this,"This is the notificaiton",Toast.LENGTH_LONG).show();
    }
}

package com.wilson.elston.babycare;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Details extends AppCompatActivity {

    int myear;
    int mmonth;
    String id;
    String nm;
    int mday;
    int mhour=10;
    int mmin=45;
    EditText name;
    EditText et;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageButton date=(ImageButton) findViewById(R.id.date);
        et=(EditText) findViewById(R.id.et);


       name=(EditText) findViewById(R.id.name);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c=Calendar.getInstance();

                myear = c.get(Calendar.YEAR);
                mmonth = c.get(Calendar.MONTH);
                mday = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog  =new DatePickerDialog(Details.this, new DatePickerDialog.OnDateSetListener() {


                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        et.setText(i2+"-"+(i1+1)+"-"+i);
                        mday=i2;
                        mmonth=i1+1;
                        myear=i;
                    }
                },myear,mmonth,mday);
                datePickerDialog.show();


            }
        });

        Button b3=(Button) findViewById(R.id.save);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id= FirebaseAuth.getInstance().getCurrentUser().getUid();
                nm=name.getText().toString();
                Calendar myAlarmDate = Calendar.getInstance();
                myAlarmDate.setTimeInMillis(System.currentTimeMillis());
                myAlarmDate.set(myear,mmonth-1 ,mday,mhour, mmin, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent intent = new Intent(Details.this, AlarmReceiver.class);
                intent.putExtra("Name", nm);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(Details.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, myAlarmDate.getTimeInMillis(), pendingIntent);

                String date=""+mday+"-"+mmonth+"-"+myear;
                FirebaseDatabase.getInstance().getReference().child("Vaccination").child(id).push().setValue(new Vaccine(nm,date));

            }
        });

    }

}

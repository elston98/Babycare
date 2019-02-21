package com.wilson.elston.babycare;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Appointment extends AppCompatActivity {

    EditText baby_name;
    EditText reason;
    EditText date;
    TextView name_doc;
    ImageButton app_date;

    int myear;
    int mmonth;
    int mday;
    int mhour;
    int mmin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        baby_name=(EditText) findViewById(R.id.baby_name);
        reason=(EditText) findViewById(R.id.app_reason );
        date=(EditText) findViewById(R.id.appointment_date);
        app_date=(ImageButton) findViewById(R.id.app_date);
        name_doc=(TextView) findViewById(R.id.Name_doc);

        Intent main_intent=getIntent();
        String name_of_doc=main_intent.getStringExtra("Doc_Name");
        name_doc.setText(name_of_doc);

        app_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c=Calendar.getInstance();

                myear = c.get(Calendar.YEAR);
                mmonth = c.get(Calendar.MONTH);
                mday = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog  =new DatePickerDialog(Appointment.this, new DatePickerDialog.OnDateSetListener() {


                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        date.setText(i2+"-"+(i1+1)+"-"+i);
                        mday=i2;
                        mmonth=i1+1;
                        myear=i;
                        timePicker();
                    }
                },myear,mmonth,mday);
                datePickerDialog.show();


            }

        });


    }
    public  void timePicker()
    {
        final  Calendar c=Calendar.getInstance();

        mhour = c.get(Calendar.HOUR_OF_DAY);
        mmin = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(Appointment.this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                mhour=i;
                mmin=i1;

            }
        },mhour,mmin,false);
        timePickerDialog.show();

    }
}

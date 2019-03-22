package com.wilson.elston.babycare;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Appointment extends AppCompatActivity {

    EditText baby_name;
    EditText reason;
    EditText date;
    EditText contact_no;
    TextView name_doc;
    ImageButton app_date;
    Button save_app;
    String id;

    String bname;
    String breason;
    String bdate;
    String bdoc;


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
        contact_no=(EditText) findViewById(R.id.contact_no);
        app_date=(ImageButton) findViewById(R.id.app_date);
        name_doc=(TextView) findViewById(R.id.Name_doc);
        save_app=(Button) findViewById(R.id.save_appointment);







        Intent main_intent=getIntent();
        final String name_of_doc=main_intent.getStringExtra("Doc_Name");
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

                    }
                },myear,mmonth,mday);
                datePickerDialog.show();


            }

        });



        save_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id= FirebaseAuth.getInstance().getUid();
                FirebaseDatabase.getInstance().getReference().child("Appointments").child(name_of_doc).push().setValue(new Doc_Appointment(baby_name.getText().toString(),reason.getText().toString(),date.getText().toString(),name_of_doc,contact_no.getText().toString()));
                Toast.makeText(Appointment.this, "The time will be notified to you by the doctor itself", Toast.LENGTH_LONG).show();
                Appointment.super.onBackPressed();


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

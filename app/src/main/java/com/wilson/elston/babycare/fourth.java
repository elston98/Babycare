package com.wilson.elston.babycare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class fourth extends AppCompatActivity {

    Spinner spinner;
    ListView doclist;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);


        doclist=(ListView) findViewById(R.id.doc_list);
        String[] mobileArray = {"Prajwal","Simran","Ralph","Abaan"};
        display_list(mobileArray);


    }
    public void display_list(String[] mobarr)
    {
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(fourth.this,R.layout.list_doc,R.id.doc_name,mobarr);
        doclist.setAdapter(adapter);

        doclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapter.getItem(i);
                switch (value)
                {
                    case "Prajwal":
                    {
                        Intent intent1=new Intent(fourth.this,Appointment.class);
                        intent1.putExtra("Doc_Name",value);
                        startActivity(intent1);
                        break;
                    }
                    case "Simran":
                    {
                        Intent intent2=new Intent(fourth.this,Appointment.class);
                        intent2.putExtra("Doc_Name",value);
                        startActivity(intent2);
                        break;
                    }
                    case "Ralph":
                    {
                        Toast.makeText(fourth.this,"Dermatologist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Abaan":
                    {
                        Toast.makeText(fourth.this,"Allergist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Darwin":
                    {
                        Intent intent5=new Intent(fourth.this,Appointment.class);
                        intent5.putExtra("Doc_Name",value);
                        startActivity(intent5);
                        break;
                    }
                    case "Aaron":{
                        Toast.makeText(fourth.this,"Allergist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Krishna":
                    {
                        Toast.makeText(fourth.this,"Allergist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Jibin":
                    {
                        Toast.makeText(fourth.this,"Allergist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    default:
                        Toast.makeText(fourth.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.location, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Mumbai: {

                String[] mobileArray = {"Prajwal","Simran","Ralph","Abaan"};
                display_list(mobileArray);


                break;
            }
            case R.id.Pune:{
                String[] mobileArray = {"Darwin","Aaron","Krishna","Jibin"};
                display_list(mobileArray);

            }
            default:
                break;
        }
        return true;
    }





}

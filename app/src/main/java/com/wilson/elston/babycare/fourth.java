package com.wilson.elston.babycare;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);



        String[] mobileArray = {"Pediatrician","Pediatric Dentist","Dermatologist","Allergist"};

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(fourth.this,R.layout.list_doc,R.id.doc_name,mobileArray);



        ListView doclist=(ListView) findViewById(R.id.doc_list);
        doclist.setAdapter(adapter);



        doclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapter.getItem(i);
                switch (value)
                {
                    case "Pediatrician":
                    {
                        Toast.makeText(fourth.this,"Pediatrician activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Pediatric Dentist":
                    {
                        Toast.makeText(fourth.this,"Pediatric Dentist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Dermatologist":
                    {
                        Toast.makeText(fourth.this,"Dermatologist activity will be opened on click",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "Allergist":
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

 /*   @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setPopupBackgroundResource(R.color.pink);
        spinner.setBackgroundResource(R.color.theme);
        spinner.setDropDownWidth(200);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(fourth.this,R.array.spinner_item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return true;

    }*/


}

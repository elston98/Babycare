package com.wilson.elston.babycare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class fourth extends AppCompatActivity {

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

}

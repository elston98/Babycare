package com.wilson.elston.babycare;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fourth extends AppCompatActivity {

    Spinner spinner;
    ListView doclist;
    DatabaseReference data;
    TextView doc_name;
    TextView doc_qualification;
    ProgressDialog progressDialog;




    private FirebaseListAdapter<Doc_Details> adapter;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        doclist=(ListView) findViewById(R.id.doc_list);


        progressDialog=new ProgressDialog(fourth.this);
        progressDialog.setMessage("Fetching Doctors");
        progressDialog.show();
        display_list();


        doclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapter.getItem(i).getDoc_Name();
                Intent intent=new Intent(fourth.this,Appointment.class);
                intent.putExtra("Doc_Name",value);
                startActivity(intent);
            }
        });

    }
    public void display_list()
    {

        adapter=new FirebaseListAdapter<Doc_Details>(fourth.this,Doc_Details.class,R.layout.list_doc,
                FirebaseDatabase.getInstance().getReference().child("Doc_Details").child("Location").child("Mumbai")) {
            @Override
            protected void populateView(View v, Doc_Details model, int position) {
                progressDialog.dismiss();
                doc_name=v.findViewById(R.id.doc_name);
                doc_qualification=v.findViewById(R.id.doc_qualification);

                doc_name.setText(model.getDoc_Name());
                doc_qualification.setText(model.getDoc_Qualification());




            }
        };
        doclist.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.location, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Mumbai: {

                adapter=new FirebaseListAdapter<Doc_Details>(fourth.this,Doc_Details.class,R.layout.list_doc,
                        FirebaseDatabase.getInstance().getReference().child("Doc_Details").child("Location").child("Mumbai")) {
                    @Override
                    protected void populateView(View v, Doc_Details model, int position) {
                        doc_name=v.findViewById(R.id.doc_name);
                        doc_qualification=v.findViewById(R.id.doc_qualification);

                        doc_name.setText(model.getDoc_Name());
                        doc_qualification.setText(model.getDoc_Qualification());




                    }
                };
                doclist.setAdapter(adapter);


                break;
            }
            case R.id.Pune:{
                adapter=new FirebaseListAdapter<Doc_Details>(fourth.this,Doc_Details.class,R.layout.list_doc,
                        FirebaseDatabase.getInstance().getReference().child("Doc_Details").child("Location").child("Pune")) {
                    @Override
                    protected void populateView(View v, Doc_Details model, int position) {
                        doc_name=v.findViewById(R.id.doc_name);
                        doc_qualification=v.findViewById(R.id.doc_qualification);

                        doc_name.setText(model.getDoc_Name());
                        doc_qualification.setText(model.getDoc_Qualification());



                    }
                };
                doclist.setAdapter(adapter);

            }
            default: {

                break;
            }
        }
        return true;
    }





}

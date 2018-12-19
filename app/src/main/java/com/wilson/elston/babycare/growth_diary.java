package com.wilson.elston.babycare;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class growth_diary extends AppCompatActivity {


    ListView list;
    TextView title;
    TextView cont;

    String id=FirebaseAuth.getInstance().getUid();
    FirebaseListAdapter<note_content> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growth_diary);

         list=(ListView)findViewById(R.id.lv1);


        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(growth_diary.this,Diary.class);
                startActivity(intent);
            }
        });

        displaynotes();



    }
    public void displaynotes()
    {



        adapter=new FirebaseListAdapter<note_content>(growth_diary.this,note_content.class,R.layout.note_display, FirebaseDatabase.getInstance().getReference().child("Diary").child(id)) {
            @Override
            protected void populateView(View v, final note_content model, int position)
            {

                    title=v.findViewById(R.id.header);
               cont=v.findViewById(R.id.cont);
                title.setText(model.getTitle());
                cont.setText(model.getContent());

            }

        };
        list.setAdapter(adapter);

    }
}


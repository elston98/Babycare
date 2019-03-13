package com.wilson.elston.babycare;

import android.app.ActionBar;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class growth_diary extends AppCompatActivity {


    ListView list;
    TextView title;
    TextView cont;
    String item;
    ProgressBar pb6;

    String id=FirebaseAuth.getInstance().getUid();
    FirebaseListAdapter<note_content> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growth_diary);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

         list=(ListView)findViewById(R.id.lv1);
         pb6=(ProgressBar) findViewById(R.id.pb6);


         pb6.setVisibility(View.VISIBLE);
        displaynotes();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item=adapter.getItem(i).getContent();
                Intent intent=new Intent(growth_diary.this,content.class);
                intent.putExtra("content",item);
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vaccination, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        // Handle item selection
        switch (item.getItemId()) {
            case R.id.vaccination: {

                Intent intent1 = new Intent(growth_diary.this, Diary.class);
                startActivity(intent1);
                break;
            }
            case android.R.id.home:
            {
                onBackPressed();
                break;
            }
            default:
                break;
        }
        return true;
    }
    public void displaynotes()
    {



        adapter=new FirebaseListAdapter<note_content>(growth_diary.this,note_content.class,R.layout.note_display, FirebaseDatabase.getInstance().getReference().child("Diary").child(id)) {
            @Override
            protected void populateView(View v, final note_content model, int position)
            {
                    pb6.setVisibility(View.INVISIBLE);
                    title=v.findViewById(R.id.header);
               //cont=v.findViewById(R.id.cont);
                title.setText(model.getTitle());



               // cont.setText(model.getContent());

            }

        };
        list.setAdapter(adapter);

    }
}


package com.wilson.elston.babycare;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class fifth extends AppCompatActivity {

    ListView product_list;
    DatabaseReference data;



    private FirebaseListAdapter<Product_details> adapter;



    ProgressBar pb1;
    TextView product_name;
   ImageView product_image;
   TextView product_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        pb1=(ProgressBar) findViewById(R.id.pb1);



        product_list=(ListView) findViewById(R.id.product_list);

        pb1.setVisibility(View.VISIBLE);
        display_list();



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                onBackPressed();
                return true;
            }
        }
        return true;
    }
    public void display_list()
    {
        adapter=new FirebaseListAdapter<Product_details>(fifth.this,Product_details.class,R.layout.products,
                FirebaseDatabase.getInstance().getReference().child("Products")) {
            @Override
            protected void populateView(View v, Product_details model, int position) {
                pb1.setVisibility(View.INVISIBLE);
                product_name=v.findViewById(R.id.product_name);
                product_image=v.findViewById(R.id.product_image);
                product_price=v.findViewById(R.id.prod_price);





                product_name.setText(model.getProduct_Name());
                product_price.setText(model.getProduct_Price());
                Glide.with(fifth.this).load(model.getImage_url()).into(product_image);
             //   glide is used to display the image from the database in the imageview of the xml file.



            }


        };

        product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value= String.valueOf(adapter.getItem(i).getProduct_Name());

                Uri url=Uri.parse(adapter.getItem(i).getApp_Url());
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(browserIntent);
                //This opens the link of the item clicked in the browser or in the app is the app is present.

            }

        });


        product_list.setAdapter(adapter);
        product_list.smoothScrollToPosition(adapter.getCount()-1);
        product_list.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);



    }//Display the list of the products that are already present in the firebase database

}

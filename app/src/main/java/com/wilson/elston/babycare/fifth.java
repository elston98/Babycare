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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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

    ProgressDialog progressDialog;


    TextView product_name;
   ImageView product_image;
   TextView product_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);



        product_list=(ListView) findViewById(R.id.product_list);
       // String[] mobarr={"P1","P2","P3","P4"};
    //    Integer[] linkarr={R.drawable.product1,R.drawable.product2,R.drawable.product3,R.drawable.product4};


        display_list();



    }
    public void display_list()
    {
        adapter=new FirebaseListAdapter<Product_details>(fifth.this,Product_details.class,R.layout.products,
                FirebaseDatabase.getInstance().getReference().child("Products")) {
            @Override
            protected void populateView(View v, Product_details model, int position) {
                product_name=v.findViewById(R.id.product_name);
                product_image=v.findViewById(R.id.product_image);
                product_price=v.findViewById(R.id.prod_price);





                product_name.setText(model.getProduct_Name());
                product_price.setText(model.getProduct_Price());
                Glide.with(fifth.this).load(model.getImage_url()).into(product_image);
             //   Toast.makeText(mActivity, ""+model.getProduct_Name(), Toast.LENGTH_SHORT).show();



            }


        };

        product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value= String.valueOf(adapter.getItem(i).getProduct_Name());

                Uri url=Uri.parse(adapter.getItem(i).getApp_Url());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(browserIntent);

            }

        });


        product_list.setAdapter(adapter);
        product_list.smoothScrollToPosition(adapter.getCount()-1);
        product_list.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);



    }

}

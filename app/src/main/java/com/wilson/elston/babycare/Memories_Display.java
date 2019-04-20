package com.wilson.elston.babycare;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Memories_Display extends AppCompatActivity {

    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;
    public ImageView iv;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories__display);

        iv=(ImageView) findViewById(R.id.iv);

        Intent intent=getIntent();
         uri=Uri.parse(intent.getStringExtra("Url").toString());
        Glide.with(Memories_Display.this).load(uri).into(iv);




        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mem_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.download)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private ImageView map;
    ImageView insta;
    ImageView fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        map = (ImageView) findViewById(R.id.map);
        insta=findViewById(R.id.insta);
        fb=findViewById(R.id.fb);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://instagram.com/ipec_acm_chapter?igshid=5r007wn3i8rd");
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://www.facebook.com/IpecACM");
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item .getItemId())
                {
                    case R.id.mitem2:
                        Intent i= new Intent(MainActivity.this,Notices.class);
                        startActivity(i);
                       // Toast.makeText(MainActivity.this, " Item2", Toast.LENGTH_SHORT).show();

                        return  true;
                }

                switch (item .getItemId())
                {
                    case R.id.mitem3:
                        Intent i = new Intent(MainActivity.this,Gallery.class);
                        startActivity(i);
                        return  true;
                }

                switch (item .getItemId())
                {
                    case R.id.mitem4:
                        Intent i = new Intent(MainActivity.this,teamPage.class);
                        startActivity(i);
                        return  true;
                }

                switch (item .getItemId())
                {
                    case R.id.mitem5:
                        Intent i = new Intent(MainActivity.this,Login.class);
                        startActivity(i);
                        return  true;
                }

                return true;
            }

        });
        actionBarDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void gotourl(String s) {
        Uri uri =Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void openmap()
    {
        Uri uri=Uri.parse("geo:0, 0?q=Inderprastha Engineering College");
        Intent i= new Intent(Intent.ACTION_VIEW,uri);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}

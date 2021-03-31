package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class about_us extends AppCompatActivity {

    ImageView insta;
    ImageView fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ImageView map = (ImageView) findViewById(R.id.map);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
        });

        insta=findViewById(R.id.insta);
        fb=findViewById(R.id.fb);
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
}
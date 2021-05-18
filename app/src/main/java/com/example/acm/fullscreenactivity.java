package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static java.sql.Types.NULL;

public class fullscreenactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreenactivity);


        ImageView fullscreen=(ImageView) findViewById(R.id.fullscreen);
//        fullscreen.setImageResource(getIntent().getIntExtra("Image",R.drawable.acm));
        String image= getIntent().getStringExtra("Image");
        Glide.with(getApplicationContext()).load(image).into(fullscreen);


    }
}
package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static java.sql.Types.NULL;

public class fullscreenactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreenactivity);

        ImageView fullscreen=(ImageView) findViewById(R.id.fullscreen);

        Intent callingactivity=getIntent();
        if(callingactivity!=null)
        {
            Uri imageuri=callingactivity.getData();
            Glide.with(this).load(imageuri).into(fullscreen);
        }
    }
}
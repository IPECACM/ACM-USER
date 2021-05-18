package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static java.sql.Types.NULL;

public class fullscreenactivity extends AppCompatActivity {

    private Animator currentAnimator;
    private int shortAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreenactivity);


        ImageView fullscreen = (ImageView) findViewById(R.id.fullscreen);
//        fullscreen.setImageResource(getIntent().getIntExtra("Image",R.drawable.acm));
        String image = getIntent().getStringExtra("Image");
        Glide.with(getApplicationContext()).load(image).into(fullscreen);
    }
}
package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.splash_screen);
        setContentView(R.layout.animation);
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent intent = new Intent(animation.this , MainActivity2.class);

                startActivity(intent);

            }

        }, 3000);
    }
}
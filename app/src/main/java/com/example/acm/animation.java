package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;

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


                if(FirebaseAuth.getInstance().getCurrentUser() == null){
                    startActivity(new Intent(animation.this, MainActivity2.class));
                }else {
                    startActivity(new Intent(animation.this, MainActivity2.class));
                }

                finish();

            }

        }, 3000);
    }
}
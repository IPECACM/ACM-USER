package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Check extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

       String get=getIntent().getExtras().get("current").toString();
        Log.i("sjfdfkkf",get);
        Toast.makeText(Check.this, get, Toast.LENGTH_SHORT).show();
    }
}
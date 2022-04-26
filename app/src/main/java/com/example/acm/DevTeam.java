package com.example.acm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DevTeam extends AppCompatActivity {
    ImageButton i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_team);
        i1 = findViewById(R.id.iv);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DevTeam.this,student_dashbord.class));
            }
        });
    }
}
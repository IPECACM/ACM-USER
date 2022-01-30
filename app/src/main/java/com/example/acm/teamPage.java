package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class teamPage extends AppCompatActivity {
    private CardView Faculty,Prime,Core;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_page);

        getSupportActionBar().setTitle("ACM TEAM");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Faculty=findViewById(R.id.faculty);
        Prime=findViewById(R.id.prime);
        Core=findViewById(R.id.core);
        Faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(teamPage.this,AddFaculty.class);
                startActivity(i);
            }
        });
        Prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(teamPage.this,primeCore.class);
                startActivity(i);
            }
        });
        Core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(teamPage.this,CoreMembers.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
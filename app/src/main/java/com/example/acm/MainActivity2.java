package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity  implements View.OnClickListener{

    public CardView card1,card2,card3,card4,card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         card1=(CardView)findViewById(R.id.card_1);
         card2=(CardView) findViewById(R.id.card_2);
        card3=(CardView) findViewById(R.id.card_3);
        card4=(CardView) findViewById(R.id.card_4);
        card5=(CardView)findViewById(R.id.card_5);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.card_2 :
                i=new Intent(this,AddFaculty.class);
                startActivity(i);
                break;
            case R.id.card_4 :
                i=new Intent(this,Notices.class);
                startActivity(i);
                break;

            case R.id.card_5 :
                i=new Intent(this,Gallery.class);
                startActivity(i);
                break;

        }
    }
}
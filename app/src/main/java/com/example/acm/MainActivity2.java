package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity2 extends AppCompatActivity  implements View.OnClickListener{

    public CardView card1,card2,card3,card4,card5,card6;
    CardView card;
    private ImageView map;
    ImageView insta;
    ImageView fb;
    FirebaseAuth fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int startColor = getWindow().getStatusBarColor();
            int endColor = ContextCompat.getColor(this,R.color.darker_blue);
            ObjectAnimator.ofArgb(getWindow(), "statusBarColor", startColor, endColor).start();
        }

fauth= FirebaseAuth.getInstance();
FirebaseUser fuser= fauth.getCurrentUser();
         card1=(CardView)findViewById(R.id.card_1);
         card2=(CardView) findViewById(R.id.card_2);
        card3=(CardView) findViewById(R.id.card_3);
        card4=(CardView) findViewById(R.id.card_4);
        card5=(CardView)findViewById(R.id.card_5);
        card6=(CardView)findViewById(R.id.card_6);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card=findViewById(R.id.card);
        map = (ImageView) findViewById(R.id.map);
        insta=findViewById(R.id.insta);
        fb=findViewById(R.id.fb);


        if(fuser!=null)
        {
            Intent i= new Intent(MainActivity2.this, student_dashbord.class);
            startActivity(i);
        }
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://www.facebook.com/IpecACM");
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://instagram.com/ipec_acm_chapter?igshid=5r007wn3i8rd");
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openmap();
            }
        });
    }

    private void openmap() {

            Uri uri=Uri.parse("geo:0, 0?q=Inderprastha Engineering College");
            Intent i= new Intent(Intent.ACTION_VIEW,uri);
            i.setPackage("com.google.android.apps.maps");
            startActivity(i);
        }



    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.card_1:
            {
           gotoUrl("https://acm.ipec.org.in/");
            }
            break;
            case R.id.card_2:
                i = new Intent(this, Login.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.card_4:
                i = new Intent(this, Notices.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.card_5:
                i = new Intent(this, Gallery.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.card_6:
            {
                gotoUrl("https://acm.ipec.org.in/prism.pdf");
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            break;
            case R.id.card_3:
                i = new Intent(this, teamPage.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

        }
    }

    private void gotoUrl(String s) {
      Uri uri= Uri.parse(s);
      startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
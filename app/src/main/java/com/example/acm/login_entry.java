package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class login_entry extends AppCompatActivity {

    TextView name;
    ImageView profileImageView;
    Animation topanim,bottomanim,fadein;
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_entry);

       // getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int startColor = getWindow().getStatusBarColor();
            int endColor = ContextCompat.getColor(this,R.color.white);
            ObjectAnimator.ofArgb(getWindow(), "statusBarColor", startColor, endColor).start();
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.splash_screen);
        fb = FirebaseAuth.getInstance();
        profileImageView=findViewById(R.id.profile_image);
        name=findViewById(R.id.name);

        //topanim= AnimationUtils.loadAnimation(this,R.anim.top_annimation);
        //bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_annimation);
        fadein= AnimationUtils.loadAnimation(this,R.anim.fadein);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot datasnapshot) {

                Log.d("ADebug", "Value: " + (datasnapshot.child("Name").getValue().toString()));
            //    name.setText("Hello "+datasnapshot.child("Name").getValue().toString());

//                if (datasnapshot.hasChild("image"))
//                {
//                    String image = datasnapshot.child("image").getValue().toString();
//                    Picasso.get().load(image).into(profileImageView);
//                }
//                else {
//                    //Toast.makeText(login_entry.this, "Please Upload a profile Pic", Toast.LENGTH_SHORT).show();
//                }
            }
            @Override
            public void onCancelled(@NotNull DatabaseError error) {

            }
        });
        //profileImageView.setAnimation(fadein);
        name.setAnimation(fadein);
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent intent = new Intent(login_entry.this , student_dashbord.class);

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }

        }, 3000);

    }
}
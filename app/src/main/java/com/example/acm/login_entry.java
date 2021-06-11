package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    Animation topanim,bottomanim;
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_entry);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.splash_screen);
        fb = FirebaseAuth.getInstance();
        profileImageView=findViewById(R.id.profile_image);
        name=findViewById(R.id.name);

        topanim= AnimationUtils.loadAnimation(this,R.anim.top_annimation);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_annimation);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot datasnapshot) {

                Log.d("ADebug", "Value: " + (datasnapshot.child("Name").getValue().toString()));
                name.setText("Welcome "+datasnapshot.child("Name").getValue().toString());

                if (datasnapshot.hasChild("image"))
                {
                    String image = datasnapshot.child("image").getValue().toString();
                    Picasso.get().load(image).into(profileImageView);
                }
                else {
                    Toast.makeText(login_entry.this, "Please Upload a profile Pic", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NotNull DatabaseError error) {

            }
        });
        profileImageView.setAnimation(topanim);
        name.setAnimation(bottomanim);
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent intent = new Intent(login_entry.this , student_dashbord.class);

                startActivity(intent);

            }

        }, 3000);

    }
}
package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class student_dashbord extends AppCompatActivity {

    FirebaseAuth fb;
    Dialog dialogue;
    private CircleImageView profileImageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashbord);
        fb = FirebaseAuth.getInstance();

       // profileImageView = findViewById(R.id.profile_image);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot datasnapshot) {

                Log.d("ADebug", "Value: " + (datasnapshot.child("Name").getValue().toString()));
                getSupportActionBar().setTitle("Welcome to your dashbord "+datasnapshot.child("Name").getValue().toString());

//                if (datasnapshot.hasChild("image"))
//                {
//                    String image = datasnapshot.child("image").getValue().toString();
//                    Picasso.get().load(image).into(profileImageView);
//                }
//                else {
//                    Toast.makeText(student_dashbord.this, "Please Upload a profile Pic", Toast.LENGTH_SHORT).show();
//                }
            }
            @Override
            public void onCancelled(@NotNull DatabaseError error) {

            }
        });
        dialogue=new Dialog(student_dashbord.this);
        dialogue.setContentView(R.layout.dialogue_popup);
        dialogue.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialogue));
        dialogue.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogue.getWindow().getAttributes().windowAnimations=R.style.dailogue;
        CardView edit_profile=findViewById(R.id.edit_profile);
        EditText edit_phone=dialogue.findViewById(R.id.edit_phone);
        EditText edit_email=dialogue.findViewById(R.id.edit_email);
        EditText edit_password=dialogue.findViewById(R.id.edit_password);
        Button update=dialogue.findViewById(R.id.update);
        Button cancel=dialogue.findViewById(R.id.cancel);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogue.show();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NotNull DataSnapshot datasnapshot) {

                        //Log.d("ADebug", "Value: " + (datasnapshot.child("Phone").getValue().toString()));
                        edit_phone.setText(datasnapshot.child("Phone").getValue().toString());
                        edit_email.setText(datasnapshot.child("Email").getValue().toString());
                       edit_password.setText(datasnapshot.child("Password").getValue().toString());
                        }
                    @Override
                    public void onCancelled(@NotNull DatabaseError error) {
                    }
                });

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone=edit_phone.getText().toString();
                String email=edit_email.getText().toString();
                String password=edit_password.getText().toString();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                reference.child("Phone").setValue(phone);
                reference.child("Email").setValue(email);
                reference.child("Password").setValue(password);
                dialogue.dismiss();
                Toast.makeText(student_dashbord.this,"Information updated",Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogue.dismiss();
            }
        });

        CardView photo=findViewById(R.id.edit_photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(student_dashbord.this,profile_picture.class);
                startActivity(i);
                
            }
        });
    }
    }

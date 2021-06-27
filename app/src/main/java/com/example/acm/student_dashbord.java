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

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class student_dashbord extends AppCompatActivity {

    FirebaseAuth fb;
    Dialog dialogue;
    CardView button;

    //Button log;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
         inflater.inflate(R.menu.student_setting,menu);
        return true;
  }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout:
                fb.signOut();
                Intent i= new Intent(student_dashbord.this,MainActivity2.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashbord);
        fb = FirebaseAuth.getInstance();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot datasnapshot) {

                Log.d("ADebug", "Value: " + (datasnapshot.child("Name").getValue().toString()));
                getSupportActionBar().setTitle("Welcome to your dashbord "+datasnapshot.child("Name").getValue().toString());
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
        CardView sig=findViewById(R.id.card_4);
        button= findViewById(R.id.butonform);
        EditText edit_phone=dialogue.findViewById(R.id.edit_phone);
        EditText edit_email=dialogue.findViewById(R.id.edit_email);
        EditText edit_password=dialogue.findViewById(R.id.edit_password);
        Button update=dialogue.findViewById(R.id.update);
        Button cancel=dialogue.findViewById(R.id.cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(student_dashbord.this, sig_selection.class);
                startActivity(i);
            }
        });
        //log=findViewById(R.id.logout);

//        log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fb.signOut();
//                Intent i= new Intent(student_dashbord.this,Login.class);
////                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(i);
//            }
//        });

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(student_dashbord.this,DisplayTask.class);
                startActivity(i);
            }
        });

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Student Details").child(fb.getCurrentUser().getUid());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String status = Objects.requireNonNull(dataSnapshot.child("hasChoosen").getValue()).toString();
                if(status.equals("false"))
                {
                   // button.setEnabled(false);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(student_dashbord.this,"Registrations are Closed",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    if(status.equals("true"))
                       // button.setEnabled(true);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i= new Intent(student_dashbord.this,sig_selection.class);
                            startActivity(i);
                        }
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
                       edit_password.setText(datasnapshot.child("password").getValue().toString());
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
                Toast.makeText(student_dashbord.this,"Info updated",Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogue.dismiss();
            }
        });

        CardView profile_photo=findViewById(R.id.profile_photo);
        profile_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student_dashbord.this , profile_picture.class);

                startActivity(intent);
            }
        });




    }
}
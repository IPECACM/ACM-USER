package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ChooseSig extends AppCompatActivity {
private Button Test;
DatabaseReference databaseReference;
FirebaseAuth Fauth;
TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sig);
        Test=findViewById(R.id.test);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        Fauth=FirebaseAuth.getInstance();
        test=findViewById(R.id.text);
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Student Details").child(Fauth.getUid());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String status = Objects.requireNonNull(dataSnapshot.child("hasChoosen").getValue()).toString();
                if(status.equals("false"))
                {
                    Test.setEnabled(false);

                }
                }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
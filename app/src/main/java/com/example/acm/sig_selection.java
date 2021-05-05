package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;

public class sig_selection extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioGroup radioGroup1;
    private RadioButton soft;
    private RadioButton python;
    private RadioButton foundation;
    private RadioButton web;
    private RadioButton soft1;
    private RadioButton python1;
    private RadioButton web1;
    private RadioButton found1;
    private Button Submit;
    DatabaseReference databaseReference;
    FirebaseAuth Fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_selection);
        Fauth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup1=findViewById(R.id.radioGroup2);
        soft=findViewById(R.id.rb1);
        python=findViewById(R.id.rb2);
        web=findViewById(R.id.rb3);
        foundation=findViewById(R.id.rb4);
        soft1=findViewById(R.id.r1);
        python1=findViewById(R.id.r2);
        web1=findViewById(R.id.r3);
        found1=findViewById(R.id.r4);
        Submit=findViewById(R.id.submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();

            }
        });
    }

    private void Validation() {
//        if(web.isChecked()|| web1.isChecked())
//        {
//            Toast.makeText(sig_selection.this, "You can select only one sig with WEB+Graph", Toast.LENGTH_SHORT).show();
//            radioGroup1.clearCheck();
//            radioGroup.clearCheck();

            int radioid1=radioGroup.getCheckedRadioButtonId();
            int radioid2=radioGroup1.getCheckedRadioButtonId();

            if(radioid1==-1 && radioid2==-1)
            {
                Toast.makeText(sig_selection.this, "Please choose", Toast.LENGTH_SHORT).show();

            }
       else if ((web.isChecked()) && (soft1.isChecked()||python1.isChecked()||found1.isChecked())||web1.isChecked()) {
            Toast.makeText(sig_selection.this, "You can select only one sig with WEB+Graph", Toast.LENGTH_SHORT).show();
            radioGroup1.clearCheck();

        }
        else if  (web1.isChecked() && (soft.isChecked()||python.isChecked()||foundation.isChecked())||web.isChecked()) {
            Toast.makeText(sig_selection.this, "You can select only one sig with WEB+Graph", Toast.LENGTH_SHORT).show();
            radioGroup1.clearCheck();

        } else {
            storeInDb();
                Intent i = new Intent(sig_selection.this,DisplayTask.class);
                startActivity(i);
        }


    }
    private void storeInDb() {
        HashMap<String, Object> studentMap = new HashMap<>();

        if (python.isChecked())
            studentMap.put("Choice1",python.getText().toString());
        if (soft.isChecked())
            studentMap.put("Choice1",soft.getText().toString());
        if (web.isChecked())
            studentMap.put("Choice1",web.getText().toString());
        if (foundation.isChecked())
            studentMap.put("Choice1",foundation.getText().toString());
        else
            studentMap.put("Choice1"," ");

        databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                radioGroup.clearCheck();
            }
        });

        HashMap<String, Object> studentMapnew = new HashMap<>();

        if (python1.isChecked())
            studentMapnew.put("Choice2",python1.getText().toString());
        if (soft1.isChecked())
            studentMapnew.put("Choice2",soft1.getText().toString());
        if (web1.isChecked())
            studentMapnew.put("Choice2",web1.getText().toString());
        if (found1.isChecked())
            studentMapnew.put("Choice2",found1.getText().toString());
        else
        studentMap.put("Choice2","  ");


        databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMapnew).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(sig_selection.this, "Done2", Toast.LENGTH_SHORT).show();
               radioGroup1.clearCheck();
            }
        });

    }

}
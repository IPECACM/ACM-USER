package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    private CheckBox soft;
    private CheckBox python;
    private CheckBox foundation;
    private CheckBox web;

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

        soft=findViewById(R.id.rb1);
        python=findViewById(R.id.rb2);
        web=findViewById(R.id.rb3);
        foundation=findViewById(R.id.rb4);
        Submit=findViewById(R.id.submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();

            }
        });
    }

    private void Validation() {




//            int radioid1=radioGroup.getCheckedRadioButtonId();
//
////            if(radioid1== -1 )
////            {
////                Toast.makeText(sig_selection.this, "Please choose", Toast.LENGTH_SHORT).show();
////
////            }
        if ((web.isChecked())) {

            if ((soft.isChecked() || python.isChecked() || foundation.isChecked())) {
                Toast.makeText(sig_selection.this, "You can't select any other sig with WEB+Graph", Toast.LENGTH_SHORT).show();

            }
            else
            {
                storeInDb();
                Intent i = new Intent(sig_selection.this, DisplayTask.class);
                startActivity(i);
            }
        }

        else if(soft.isChecked() && python.isChecked()  && foundation.isChecked()) {
            Toast.makeText(sig_selection.this,"You cannot select more than 2",Toast.LENGTH_SHORT).show();
            foundation.setChecked(false);
            soft.setChecked(false);
            python.setChecked(false);
        }


        else if((soft.isChecked() && python.isChecked()) || (soft.isChecked()&& foundation.isChecked()) || (python.isChecked()&& foundation.isChecked()))

        {
            if(soft.isChecked() && python.isChecked())
            {
                HashMap<String, Object> studentMap = new HashMap<>();

                    studentMap.put("Choice1",python.getText().toString());
                    studentMap.put("Choice2",soft.getText().toString());

                databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(sig_selection.this,DisplayTask.class);
                        startActivity(i);

                    }
                });
            }
            if(soft.isChecked()&& foundation.isChecked())
            {
                HashMap<String, Object> studentMap = new HashMap<>();

                studentMap.put("Choice1",foundation.getText().toString());
                studentMap.put("Choice2",soft.getText().toString());

                databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(sig_selection.this,DisplayTask.class);
                        startActivity(i);

                    }
                });
            }

            if(python.isChecked()&& foundation.isChecked())
            {
                HashMap<String, Object> studentMap = new HashMap<>();

                studentMap.put("Choice1",python.getText().toString());
                studentMap.put("Choice2",foundation.getText().toString());

                databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(sig_selection.this,DisplayTask.class);
                        startActivity(i);

                    }
                });
            }



        }

        else if( (soft.isChecked() || python.isChecked()  || foundation.isChecked()) )
        {
            if(soft.isChecked())
            {
                HashMap<String, Object> studentMap = new HashMap<>();

                    studentMap.put("Choice1",soft.getText().toString());

                databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(sig_selection.this,DisplayTask.class);
                        startActivity(i);

                    }
                });
            }

            if(foundation.isChecked())
            {
                HashMap<String, Object> studentMap = new HashMap<>();

                studentMap.put("Choice1",foundation.getText().toString());

                databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(sig_selection.this,DisplayTask.class);
                        startActivity(i);

                    }
                });
            }
            if(python.isChecked())
            {
                HashMap<String, Object> studentMap = new HashMap<>();

                studentMap.put("Choice1",python.getText().toString());

                databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(sig_selection.this,DisplayTask.class);
                        startActivity(i);

                    }
                });
            }
        }
        else {
               Toast.makeText(sig_selection.this,"Please select atleast one SIG",Toast.LENGTH_SHORT).show();
        }
        }
    private void storeInDb() {
        HashMap<String, Object> studentMap = new HashMap<>();

//        if (python.isChecked())
//            studentMap.put("Choice1",python.getText().toString());
//        if (soft.isChecked())
//            studentMap.put("Choice1",soft.getText().toString());
        if (web.isChecked())
            studentMap.put("Choice1",web.getText().toString());

        databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(sig_selection.this, "Done", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(sig_selection.this,DisplayTask.class);
                startActivity(i);
            }
        });

//        HashMap<String, Object> studentMapnew = new HashMap<>();
//
//        if (python.isChecked())
//            studentMapnew.put("Choice2",python.getText().toString());
//        if (soft.isChecked())
//            studentMapnew.put("Choice2",soft.getText().toString());
//        if (web.isChecked())
//            studentMapnew.put("Choice2",web.getText().toString());
//        if (foundation.isChecked())
//            studentMapnew.put("Choice2",foundation.getText().toString());
//        else
//        studentMap.put("Choice2","  ");

//
//        databaseReference.child("Student Details").child(Fauth.getCurrentUser().getUid()).updateChildren(studentMapnew).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                Toast.makeText(sig_selection.this, "Done2", Toast.LENGTH_SHORT).show();
//                foundation.setChecked(false);
//                soft.setChecked(false);
//                web.setChecked(false);
//                python.setChecked(false);
//
//
//
//
//            }
//        });

    }

}
package com.example.acm;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

       FirebaseAuth FAuth= FirebaseAuth.getInstance();
       FirebaseUser firebaseUser=FAuth.getCurrentUser();
       if(firebaseUser!=null)
       {
Intent i= new Intent(Home.this,student_dashbord.class);
           i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(i);
       }
    }
}

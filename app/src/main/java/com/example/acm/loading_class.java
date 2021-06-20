package com.example.acm;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class loading_class {

    private Activity activity;
    private AlertDialog AD;
    loading_class(Activity myactivity){
    activity=myactivity;
    }

    void startLoading(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);

        LayoutInflater inflator=activity.getLayoutInflater();
        builder.setView(inflator.inflate(R.layout.custom_loading,null));
        builder.setCancelable(true);
        AD= builder.create();
        AD.show();
    }

    void dismiss(){
        AD.dismiss();
    }
}

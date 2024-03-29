package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Gallery extends AppCompatActivity {
    DatabaseReference OData;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    galleryAdapter adapter ;
    String currentuser="";


    // Creating List of ImageUploadInfo class.
    List<gallerymodel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getSupportActionBar().setTitle("MEMORIES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final loading_class loading_class=new loading_class(Gallery.this);
        loading_class.startLoading();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(Gallery.this,3));

        OData = FirebaseDatabase.getInstance().getReference("Gallery");
        OData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    gallerymodel imageUploadInfo = postSnapshot.getValue(gallerymodel.class);

                    list.add(imageUploadInfo);
                }

                adapter = new galleryAdapter(getApplicationContext(), list);

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Gallery.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading_class.dismiss();
            }
        },2000);

//        OData.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                list.clear();
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//
//                    gallerymodel imageUploadInfo = postSnapshot.getValue(gallerymodel.class);
//
//                    list.add(imageUploadInfo);
//                }
//
//                adapter = new galleryAdapter(getApplicationContext(), list);
//
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(Gallery.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

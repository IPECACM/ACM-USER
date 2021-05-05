package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Test extends AppCompatActivity {
    String get;
    DatabaseReference OData;
    RecyclerView recyclerView;
    DisplayTaskRecycler adapter;


//    // Creating List of ImageUploadInfo class.
//    List<choicemodel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        get=getIntent().getExtras().get("current").toString();
        Log.i("sjfdfkkf",get);
        Toast.makeText(Test.this, get, Toast.LENGTH_SHORT).show();


        recyclerView = (RecyclerView) findViewById(R.id.rv10);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Test.this));

        OData = FirebaseDatabase.getInstance().getReference().child("Tasks");

        Query query = OData.orderByChild("SIG").equalTo(get);
        FirebaseRecyclerOptions<choicemodel> options =

                new FirebaseRecyclerOptions.Builder<choicemodel>()
                        .setQuery(query, choicemodel.class)
                        .build();

        adapter = new DisplayTaskRecycler(options, Test.this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}

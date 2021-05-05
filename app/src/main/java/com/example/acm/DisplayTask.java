package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DisplayTask extends AppCompatActivity {
    DatabaseReference OData;
    RecyclerView recyclerView;
    //  DisplayTaskRecycler adapter;
    FirebaseAuth FAuth;
    List<String> list;
    ListView listView;
    ArrayAdapter<String> adapter;
    private Button Choose;
//    private TextView choice0;
//    private TextView choice1;
//    private TextView choice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_task);

        listView =findViewById(R.id.listview);
//        recyclerView = (RecyclerView) findViewById(R.id.rv9);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        Choose=findViewById(R.id.choose);
        FAuth = FirebaseAuth.getInstance();

        OData = FirebaseDatabase.getInstance().getReference().child("Student Details");



//        Choose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i= new Intent(DisplayTask.this,sig_selection.class);
//                startActivity(i);
//            }
//        });

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Student Details").child(FAuth.getCurrentUser().getUid());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String status = Objects.requireNonNull(dataSnapshot.child("hasChoosen").getValue()).toString();
                if(status.equals("false"))
                {
                    Choose.setEnabled(false);

                }
                else {
                    Choose.setEnabled(true);
                    Choose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i= new Intent(DisplayTask.this,sig_selection.class);
                            startActivity(i);
                        }
                    });


                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        OData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                String Choice0=snapshot.child(FAuth.getCurrentUser().getUid()).child("Choice0").getValue().toString();
                list.add(Choice0);
                String Choice1=snapshot.child(FAuth.getCurrentUser().getUid()).child("Choice1").getValue().toString();
                list.add(Choice1);
                String Choice2=snapshot.child(FAuth.getCurrentUser().getUid()).child("Choice2").getValue().toString();
                list.add(Choice2);
                Log.i("skfksjdkfskv",Choice1);

                adapter=new ArrayAdapter<>(DisplayTask.this, android.R.layout.simple_list_item_1,list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String currentobj = adapterView.getItemAtPosition(position).toString();
                Intent i = new Intent(getApplicationContext(), Test.class);
                i.putExtra("current", currentobj);
                startActivity(i);

            }
        });
    }
}
package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Studentlist extends AppCompatActivity {

    DbHandler dbHandler;
    List<Student> friendsList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DbHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        friendsList = dbHandler.selectAllStudents();
        recyclerView = findViewById(R.id.recyclerview);


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(Studentlist.this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new StudentRecyclerViewAdapter(friendsList) ;
        recyclerView.setAdapter(adapter);
    }

}
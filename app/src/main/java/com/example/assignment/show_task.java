package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class show_task extends AppCompatActivity {
    TaskDBHelper dbHelper;
    List<Task> tasksList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);
        dbHelper = new TaskDBHelper(this);

        Button searchTaskBtn = findViewById(R.id.search_task_by_rollno_btn);
        TextView rollNoEntryView = findViewById(R.id.edit_search_task_by_rollno);
        searchTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = rollNoEntryView.getText().toString();
                System.out.println("rollno: " + rollNo);

                tasksList = dbHelper.selectAllTasks(rollNo);
                System.out.println("tasks ===== ");
                System.out.println(tasksList);
                recyclerView = findViewById(R.id.show_tasks_recycler_view);


                recyclerView.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(show_task.this);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new TaskRecyclerViewAdapter(tasksList) ;
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
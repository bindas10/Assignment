package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TaskDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        db = new TaskDBHelper(this);
        Button insertStudentTask = findViewById(R.id.button7);
        TextView sabaqView = findViewById(R.id.editTextTextPersonName4);
        TextView sabaqiView = findViewById(R.id.editTextTextPersonName5);
        TextView manzalView = findViewById(R.id.editTextTextPersonName6);
        TextView rollNoView = findViewById(R.id.editTextTextPersonName0);
        insertStudentTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNo = rollNoView.getText().toString();
                String sabaq = sabaqView.getText().toString();
                String sabaqi = sabaqiView.getText().toString();
                String manzal = manzalView.getText().toString();
                String currentDate = db.getCurrentDate();
                Task task = new Task(rollNo, sabaq, sabaqi, manzal, currentDate);
                System.out.println("TASK");
                db.insertTask(task);

                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    }

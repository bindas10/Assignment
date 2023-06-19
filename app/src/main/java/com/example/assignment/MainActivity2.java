package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        db = new DbHandler(this);

        Button addStudentAction = findViewById(R.id.button);
        TextView rollNo = findViewById(R.id.editTextTextPersonName2);
        TextView name = findViewById(R.id.editTextTextPersonName);
        TextView age = findViewById(R.id.editTextTextPersonName3);
        addStudentAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue, rollNoValue;
                int ageValue = 0;
                rollNoValue = rollNo.getText().toString();
                nameValue = name.getText().toString();

                ageValue = Integer.parseInt(age.getText().toString());
                Student student = new Student(nameValue, ageValue, rollNoValue);
                db.insertStudent(student);
            }

        });
    }
}


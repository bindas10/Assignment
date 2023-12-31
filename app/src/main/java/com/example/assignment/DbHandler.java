package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ROLLNO = "rollno";
    private static final String COLUMN_AGE = "age";

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLLNO + " TEXT UNIQUE,"
                + COLUMN_AGE + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;

        db.execSQL(sql);
        onCreate(db);
    }
    public void insertStudent(Student student)throws SQLiteConstraintException {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ROLLNO + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{student.getRollno()});
        if (cursor.getCount() > 0) {
            cursor.close();
            db.close();
            throw new SQLiteConstraintException("Student with roll number " + student.getRollno() + " already exists");
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNO, student.getRollno());
        values.put(COLUMN_AGE, student.getAge());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
System.out.println("adding");
        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String rollNo = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE));
                students.add(new Student(name,rollNo,age));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }

    }

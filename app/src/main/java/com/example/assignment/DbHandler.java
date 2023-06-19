package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLLNO + " TEXT,"
                + COLUMN_AGE + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNO, student.getRollno());
        values.put(COLUMN_AGE, student.getAge());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int newVersion, int oldVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;

        db.execSQL(sql);
        onCreate(db);
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

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

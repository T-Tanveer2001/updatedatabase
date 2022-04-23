package com.example.lab7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.spec.MGF1ParameterSpec;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="student.db";
    public static  final String TABLE_NAME="student_table";
    public static  final String COL_1="ID";
    public static  final String COL_2="NAME";
    public static  final String COL_3 ="SURNAME";
    public static  final String COL_4="MARKS";
    public static  final String COL_5="SEMESTER";
    public static  final String COL_6="GPA";
    public static  final String COL_7="DEPARTMENT";

    public DatabaseHelper( Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table "+ TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"NAME TEXT, SURNAME TEXT, MARKS INTEGER,SEMESTER INTEGER,GPA INTEGER,DEPARTMENT TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
onCreate(db);
    }

    public boolean insertData(String name,String surname,String marks,String semester,String gpa,String department)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        contentValues.put(COL_5,semester);
        contentValues.put(COL_6,gpa);
        contentValues.put(COL_7,department);
        long result =db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)

            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;

    }
}

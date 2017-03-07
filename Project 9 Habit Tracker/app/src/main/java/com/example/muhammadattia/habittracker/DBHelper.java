package com.example.muhammadattia.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.muhammadattia.habittracker.HabitContract.HabitEntry;

/**
 * Created by Muhammad Attia on 06/03/2017.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "habittracker.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_CATEGORY + " TEXT NOT NULL,"
                + HabitEntry.COLUMN_COUNTER + " TEXT NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {

    }

    public boolean addHabit (String name, String category,String counter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitEntry.COLUMN_NAME, name);
        contentValues.put(HabitEntry.COLUMN_CATEGORY, category);
        contentValues.put(HabitEntry.COLUMN_COUNTER, counter);
        db.insert(HabitEntry.TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor readAllHabits(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_NAME,
                HabitEntry.COLUMN_CATEGORY,
                HabitEntry.COLUMN_COUNTER
        };
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME ,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Integer deleteHabit (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(HabitEntry.TABLE_NAME ,
                HabitEntry.ID+" = ? ",
                new String[] { Integer.toString(id) });
    }

}

package com.example.muhammadattia.habittracker;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAddHabit(View view) {

        Intent add = new Intent(this, AddHabitActivity.class);
        startActivity(add);
    }

    public void toDeleteHabits(View view) {
        Intent delete = new Intent(this, DeleteHabitActivity.class);
        startActivity(delete);

    }

    public void PreviewHabit(View view) {
        mydb = new DBHelper(this);
        Cursor cursor = mydb.readAllHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG,"habit: " + cursor.getString(0) + " " + cursor.getString(1) +
                    " " + cursor.getString(2) + " " + cursor.getString(3));
        }
    }
}

package com.example.muhammadattia.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddHabitActivity extends AppCompatActivity {

    private DBHelper mydb ;

    EditText nameEditText, categoryEditText, countertEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        nameEditText = (EditText) findViewById(R.id.habitName);
        categoryEditText = (EditText) findViewById(R.id.habitCategory);
        countertEditText = (EditText) findViewById(R.id.habitCounter);
        mydb =new DBHelper(this);

        Button save =(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String habitName = nameEditText.getText().toString();
                String category = categoryEditText.getText().toString();
                String num = countertEditText.getText().toString();

                mydb.addHabit(habitName,category,num);
                Toast.makeText(AddHabitActivity.this,"Habit has been Added Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
}

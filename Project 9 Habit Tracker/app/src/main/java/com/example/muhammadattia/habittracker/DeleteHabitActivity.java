package com.example.muhammadattia.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteHabitActivity extends AppCompatActivity {

    private DBHelper mydb ;

     EditText idEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_habit);

        idEditText =(EditText)findViewById(R.id.idToDelete);
        mydb =new DBHelper(this);

        Button delet =(Button)findViewById(R.id.deleteHabit);
        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                Integer integer=Integer.parseInt(id);
                mydb.deleteHabit(integer);
                Toast.makeText(DeleteHabitActivity.this,"Habits has been Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }

}

package com.example.android.nadamathquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    int score6 = 0;
    int score7 = 0;
    EditText q1;
    EditText q2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void question_one() {
        q1 = (EditText) findViewById(R.id.question1);
        String ans = q1.getText().toString();
        int num = Integer.parseInt(ans);
        if (num == 108) {
            score1 = 1;
        } else {
            score1 = 0;
        }

    }

    public void question_two() {
        q2 = (EditText) findViewById(R.id.question2);
        String ans2 = q2.getText().toString();
        int num2 = Integer.parseInt(ans2);
        if (num2 == 11) {
            score2 = 1;
        } else {
            score2 = 0;
        }
    }

    public void question_three(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.question3A:
                if (checked) {
                    score3 = 0;
                    break;
                }
            case R.id.question3B:
                if (checked) {
                    score3 = 0;
                    break;
                }
            case R.id.question3C:
                if (checked) {
                    score3 = 1;
                    break;
                }
            case R.id.question3D:
                if (checked) {
                    score3 = 0;
                    break;
                }
        }
    }

    public void question_four(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.question4A:
                if (checked) {
                    score4 = 0;
                    break;
                }
            case R.id.question4B:
                if (checked) {
                    score4 = 1;
                    break;
                }
            case R.id.question4C:
                if (checked) {
                    score4 = 0;
                    break;
                }
            case R.id.question4D:
                if (checked) {
                    score4 = 0;
                    break;
                }
        }
    }

    public void question_five(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.question5A:
                if (checked) {
                    score5 = 0;
                    break;
                }
            case R.id.question5B:
                if (checked) {
                    score5 = 0;
                    break;
                }
            case R.id.question5C:
                if (checked) {
                    score5 = 1;
                    break;
                }
            case R.id.question5D:
                if (checked) {
                    score5 = 0;
                    break;
                }
        }
    }

    public void question_six(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question6A:
                if (checked) {
                    score6 = 0;
                    break;
                }
            case R.id.question6B:
                if (checked) {
                    score6 = 0;
                    break;
                }
            case R.id.question6C:
                if (checked) {
                    score6 = 1;
                    break;
                }
            case R.id.question6D:
                if (checked) {
                    score6 = 0;
                    break;
                }
        }
    }
    public void question_seven(View view) {
        CheckBox c1 = (CheckBox) findViewById(R.id.question7B);
        CheckBox c2 = (CheckBox) findViewById(R.id.question7C);
        CheckBox c3 = (CheckBox) findViewById(R.id.question7D);
        if (c1.isChecked() && c2.isChecked() && c3.isChecked()) {
            score7 = 1;
        } else {
            score7 = 0;
        }
    }

    public void result(View view) {
        question_one();
        question_two();
        int total = score1 + score2 + score3 + score4 + score5 + score6 + score7;
        Toast.makeText(this, " The result = " + total + "/7" + " answers right", Toast.LENGTH_LONG).show();
    }
}

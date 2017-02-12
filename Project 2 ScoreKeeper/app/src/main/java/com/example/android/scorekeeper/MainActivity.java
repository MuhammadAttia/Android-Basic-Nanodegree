package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score_a = 0;
    int score_b = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teamA(View v) {
        Button clickedButton = (Button) v;
        switch (clickedButton.getId()) {
            case R.id.six_PointA:
                score_a = score_a + 6;
                displayTeamA(score_a);
                break;

            case R.id.three_pointA:
                score_a = score_a + 3;
                displayTeamA(score_a);
                break;

            case R.id.two_pointA:
                score_a = score_a + 2;
                displayTeamA(score_a);
                break;

            case R.id.one_pointA:
                score_a = score_a + 1;
                displayTeamA(score_a);
                break;
        }
    }

    public void teamB(View v) {
        Button clickedButton = (Button) v;
        switch (clickedButton.getId()) {
            case R.id.six_PointB:
                score_b = score_b + 6;
                displayteamB(score_b);
                break;

            case R.id.three_pointB:
                score_b = score_b + 3;
                displayteamB(score_b);
                break;

            case R.id.two_pointB:
                score_b = score_b + 2;
                displayteamB(score_b);
                break;

            case R.id.one_pointB:
                score_b = score_b + 1;
                displayteamB(score_b);
                break;
        }
    }

    public void reset(View view) {
        score_a = 0;
        score_b = 0;
        displayTeamA(score_a);
        displayteamB(score_b);

    }

    public void displayTeamA(int s1) {
        TextView t1 = (TextView) findViewById(R.id.updateScoreA);
        t1.setText(String.valueOf(s1));
    }

    public void displayteamB(int s2) {
        TextView t1 = (TextView) findViewById(R.id.updateScoreB);
        t1.setText(String.valueOf(s2));
    }

}

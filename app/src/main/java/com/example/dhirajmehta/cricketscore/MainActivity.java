package com.example.dhirajmehta.cricketscore;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int runs = 0,runsA,runsB;
    int flag = 0; //for overs
    int counter = 0; //for balls
    int balls = 0;
    //Context context = getApplicationContext();
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Balls Increase
     */
    public void incrementBall(View view ){
        if(balls==6){
            balls = 0;
            runs = 0;
            flag = 1;
            counter = 0;
            displayBalls(balls);
        }else{
            counter = 1;
            balls++;
            displayBalls(balls);
        }
    }

    /**
     * Function when four is scored
     */
    public int fourRuns() {
            if (counter == 1) {
                runs += 4;
                counter = 0;
            } else Toast.makeText(getApplicationContext(), "Please ball first", duration).show();
        return 0;
    }

    /**
     * Function when six is scored
     */
    public int sixRuns() {
        if (counter == 1) {
            runs += 6;
            counter = 0;
        } else Toast.makeText(getApplicationContext(), "Please ball first", duration).show();
        return 0;
    }

    /**
     * four of team A
     */
    public void fourA(View view){

        if(flag==0){
            fourRuns();
            runsA = runs;
            displayForTeamA(runsA);
        }else{
            Toast.makeText(getApplicationContext(),"Team A is bowling",duration).show();
        }
    }

    /**
     * four of team B
     */
    public void fourB(View view){

        if(flag==1){
            fourRuns();
            runsB = runs;
            displayForTeamB(runsB);
        }else{
            Toast.makeText(getApplicationContext(),"Team B is bowling",duration).show();
        }
    }

    /**
     * six of team A
     */
    public void sixA(View view){

        if(flag==0){
            sixRuns();
            runsA = runs;
            displayForTeamA(runsA);
        }else{
            Toast.makeText(getApplicationContext(),"Team A is bowling",duration).show();
        }
    }

    /**
     * six of team B
     */
    public void sixB(View view){

        if(flag==1){
            sixRuns();
            runsB = runs;
            displayForTeamB(runsB);
        }else{
            Toast.makeText(getApplicationContext(),"Team B is bowling",duration).show();
        }
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.teamAScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.teamBScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display balls
     */
    public void displayBalls(int balls){
        TextView ballsView =  findViewById(R.id.noOfBalls);
        if(flag == 1 && balls == 6){
            if(runsA > runsB)
                ballsView.setText("Team A wins");
            else {
                if(runsB > runsA) {
                    ballsView.setText("Team B wins");
                }else ballsView.setText("Match Tie !!");
            }
        }else ballsView.setText(String.valueOf(balls));
    }

}

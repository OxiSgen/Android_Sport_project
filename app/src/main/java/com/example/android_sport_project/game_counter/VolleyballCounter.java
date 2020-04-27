package com.example.android_sport_project.game_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_sport_project.R;

public class VolleyballCounter extends AppCompatActivity {
    private TextView counterFirstTeam;
    private TextView counterSecondTeam;
    private TextView matchNameView;
    private TextView firstTeamNameView;
    private TextView secondTeamNameView;
    public static String matchName;
    public static String firstTeamName;
    public static String secondTeamName;
    private int firstTeamCounter;
    private int secondTeamCounter;
    private int LIMIT;
    private int MIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_counter);
        firstTeamCounter = 0;
        secondTeamCounter = 0;
        LIMIT = 25;
        MIN = 0;
        counterFirstTeam = (TextView) findViewById(R.id.FirstTeamCounter);
        counterSecondTeam = (TextView) findViewById(R.id.SecondTeamCounter);
        matchNameView = (TextView) findViewById(R.id.MatchName);
        firstTeamNameView = (TextView) findViewById(R.id.TeamOneName);
        secondTeamNameView = (TextView) findViewById(R.id.TeamTwoName);

        matchNameView.setText(matchName);
        firstTeamNameView.setText(firstTeamName);
        secondTeamNameView.setText(secondTeamName);

        Button addOnePointToFirstTeam = (Button) findViewById(R.id.AddOnePointToFirstTeam);
        addOnePointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter < LIMIT) {
                    firstTeamCounter++;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        Button removeOnePointFromFirstTeam = (Button) findViewById(R.id.RemoveOnePointFromFirstTeam);
        removeOnePointFromFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter > MIN) {
                    firstTeamCounter--;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        Button addOnePointToSecondTeam = (Button) findViewById(R.id.AddOnePointToSecondTeam);
        addOnePointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secondTeamCounter < LIMIT) {
                    secondTeamCounter++;
                    counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                }
            }
        });

        Button removeOnePointFromSecondTeam = (Button) findViewById(R.id.RemoveOnePointFromSecondTeam);
        removeOnePointFromSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secondTeamCounter > MIN) {
                    secondTeamCounter--;
                    counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                }
            }
        });

        Button endGame = (Button) findViewById(R.id.EndMatch);
        endGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }

    public void OnClick(View view) {

    }
}

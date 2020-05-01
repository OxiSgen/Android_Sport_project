package com.example.android_sport_project.game_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_sport_project.R;
import com.example.android_sport_project.model.SportGame;

public class VolleyballCounter extends AppCompatActivity {
    private TextView counterFirstTeam;
    private TextView counterSecondTeam;
    private TextView matchNameView;
    private TextView firstTeamNameView;
    private TextView secondTeamNameView;
    private TextView gameTimer;
    private int firstTeamCounter;
    private int secondTeamCounter;
    private int LIMIT;
    private int MIN;
    private String time;
    private int seconds;
    private boolean running;

    public static SportGame volleyballGame = new SportGame();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_counter);
        firstTeamCounter = 0;
        secondTeamCounter = 0;
        LIMIT = 25;
        MIN = 0;
        running = true;

        counterFirstTeam = (TextView) findViewById(R.id.FirstTeamCounter);
        counterSecondTeam = (TextView) findViewById(R.id.SecondTeamCounter);
        matchNameView = (TextView) findViewById(R.id.MatchName);
        firstTeamNameView = (TextView) findViewById(R.id.TeamOneName);
        secondTeamNameView = (TextView) findViewById(R.id.TeamTwoName);
        gameTimer = (TextView) findViewById(R.id.GameTimer);


        matchNameView.setText(volleyballGame.getMatchName());
        firstTeamNameView.setText(volleyballGame.getFirstTeamName());
        secondTeamNameView.setText(volleyballGame.getSecondTeamName());

        timerGameRun();
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

        Button pauseGame = (Button) findViewById(R.id.PauseGame);
        pauseGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                running=!running;
            }
        });

        Button endGame = (Button) findViewById(R.id.EndMatch);
        endGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                running=false;
            }
        });


    }

    private void timerGameRun(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secon = seconds%60;

                time = String.format("%d:%02d:%02d", hours, minutes, secon);
                gameTimer.setText(time);
                if(running){
                    seconds++;
                }
                 handler.postDelayed(this, 1000);
            }
        });
    }

    private void saveGame(){
        VolleyballCounter.volleyballGame.setFirstTeamCount(firstTeamCounter);
        VolleyballCounter.volleyballGame.setSecondTeamCount(secondTeamCounter);
        VolleyballCounter.volleyballGame.setGameType(1);//Для волейболла тип 1
        VolleyballCounter.volleyballGame.setGameTime(time);
        //Тут будет кусок про пихание в JSON
    }

}

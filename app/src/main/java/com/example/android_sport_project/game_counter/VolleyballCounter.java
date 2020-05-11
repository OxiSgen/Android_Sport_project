package com.example.android_sport_project.game_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_sport_project.Menu;
import com.example.android_sport_project.R;
import com.example.android_sport_project.dialog.EndGameDialog;
import com.example.android_sport_project.game_start.BasketballStarter;
import com.example.android_sport_project.helpers.JsonHelper;
import com.example.android_sport_project.model.SportGame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class VolleyballCounter extends AppCompatActivity implements Counter {
    private TextView counterFirstTeam;
    private TextView counterSecondTeam;
    private TextView matchNameView;
    private TextView firstTeamNameView;
    private TextView secondTeamNameView;
    private TextView gameTimer;
    private int firstTeamCounter;
    private int secondTeamCounter;
    private final int LIMIT = 25;
    private final int MIN = 0;
    private String time;
    private int seconds;
    private boolean running;

    public static SportGame volleyballGame = new SportGame();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_counter);
        firstTeamCounter = 0;
        secondTeamCounter = 0;
        running = true;

        counterFirstTeam = (TextView) findViewById(R.id.FirstVolleyballTeamCounter);
        counterSecondTeam = (TextView) findViewById(R.id.SecondVolleyballTeamCounter);
        matchNameView = (TextView) findViewById(R.id.VolleyballMatchName);
        firstTeamNameView = (TextView) findViewById(R.id.VolleyballTeamOneName);
        secondTeamNameView = (TextView) findViewById(R.id.VolleyballTeamTwoName);
        gameTimer = (TextView) findViewById(R.id.VolleyballGameTimer);


        matchNameView.setText(volleyballGame.getMatchName());
        firstTeamNameView.setText(volleyballGame.getFirstTeamName());
        secondTeamNameView.setText(volleyballGame.getSecondTeamName());

        timerGameRun();
        final Button addOnePointToFirstTeam = (Button) findViewById(R.id.VolleyballAddOnePointToFirstTeam);
        addOnePointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter < LIMIT) {
                    firstTeamCounter++;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        final Button removeOnePointFromFirstTeam = (Button) findViewById(R.id.VolleyballRemoveOnePointFromFirstTeam);
        removeOnePointFromFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter > MIN) {
                    firstTeamCounter--;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        final Button addOnePointToSecondTeam = (Button) findViewById(R.id.VolleyballAddOnePointToSecondTeam);
        addOnePointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secondTeamCounter < LIMIT) {
                    secondTeamCounter++;
                    counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                }
            }
        });

        final Button removeOnePointFromSecondTeam = (Button) findViewById(R.id.VolleyballRemoveOnePointFromSecondTeam);
        removeOnePointFromSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secondTeamCounter > MIN) {
                    secondTeamCounter--;
                    counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                }
            }
        });

        final Button endGame = (Button) findViewById(R.id.VolleyballEndMatch);
        endGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                running = false;
               // saveGame();
                EndGameDialog dialog = new EndGameDialog(VolleyballCounter.this, view.getContext());
                dialog.show(getSupportFragmentManager(), "custom");
                dialog.setCancelable(false);
            }
        });

        final ImageButton pauseGame = (ImageButton) findViewById(R.id.VolleyballPauseGame);
        pauseGame.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View view) {
                                             stopStartTime();
                                             if (running) {
                                                 pauseGame.setImageResource(R.drawable.ic_stop_black_24dp);
                                                 addOnePointToFirstTeam.setEnabled(true);
                                                 addOnePointToSecondTeam.setEnabled(true);
                                                 removeOnePointFromFirstTeam.setEnabled(true);
                                                 removeOnePointFromSecondTeam.setEnabled(true);
                                                 endGame.setEnabled(true);
                                             } else {
                                                 pauseGame.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                                                 addOnePointToFirstTeam.setEnabled(false);
                                                 addOnePointToSecondTeam.setEnabled(false);
                                                 removeOnePointFromFirstTeam.setEnabled(false);
                                                 removeOnePointFromSecondTeam.setEnabled(false);
                                                 endGame.setEnabled(false);
                                             }
                                         }
                                     }
        );
    }

    private void timerGameRun() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secon = seconds % 60;

                time = String.format("%d:%02d:%02d", hours, minutes, secon);
                gameTimer.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void saveGame() {
        VolleyballCounter.volleyballGame.setFirstTeamCount(firstTeamCounter);
        VolleyballCounter.volleyballGame.setSecondTeamCount(secondTeamCounter);
        VolleyballCounter.volleyballGame.setGameType(1);//Для волейболла тип 1
        VolleyballCounter.volleyballGame.setGameTime(time);

        // Текущее время
        Date currentDate = new Date();
        volleyballGame.setGameDate(currentDate);

        boolean result = JsonHelper.addToJsonFile(volleyballGame, this);
        if (result) {
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
    }

    public void stopStartTime(){
        running = !running;
    }

}

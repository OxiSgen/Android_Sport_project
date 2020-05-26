package com.example.android_sport_project.game_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_sport_project.R;
import com.example.android_sport_project.dialog.EndGameDialog;
import com.example.android_sport_project.helpers.JsonHelper;
import com.example.android_sport_project.model.SportGame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FootballCounter extends AppCompatActivity implements Counter{
    private TextView counterFirstTeam;
    private TextView counterSecondTeam;
    private TextView matchNameView;
    private TextView firstTeamNameView;
    private TextView secondTeamNameView;
    private TextView gameTimer;
    private int firstTeamCounter;
    private int secondTeamCounter;
    // private int LIMIT;
    private final int MIN = 0;
    private String time;
    private int seconds;
    private boolean running;

    public static SportGame footballGame = new SportGame();

    @Override
    public SportGame getSportGame() {
        return footballGame;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_counter);

        firstTeamCounter = 0;
        secondTeamCounter = 0;
        running = true;

        counterFirstTeam = (TextView) findViewById(R.id.FootballFirstTeamCounter);
        counterSecondTeam = (TextView) findViewById(R.id.FootballSecondTeamCounter);
        matchNameView = (TextView) findViewById(R.id.FootballMatchName);
        firstTeamNameView = (TextView) findViewById(R.id.FirstFootballTeamName);
        secondTeamNameView = (TextView) findViewById(R.id.SecondFootballTeamName);
        gameTimer = (TextView) findViewById(R.id.FootballGameTimer);


               matchNameView.setText(footballGame.getMatchName());
               firstTeamNameView.setText(footballGame.getFirstTeamName());
               secondTeamNameView.setText(footballGame.getSecondTeamName());

        timerGameRun();
        final ImageButton addOnePointToFirstTeam = (ImageButton) findViewById(R.id.FootballAddOnePointToFirstTeam);
        addOnePointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                firstTeamCounter++;
                counterFirstTeam.setText(String.valueOf(firstTeamCounter));
            }
        });

        final ImageButton removeOnePointFromFirstTeam = (ImageButton) findViewById(R.id.FootballRemoveOnePointFromFirstTeam);
        removeOnePointFromFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter > MIN) {
                    firstTeamCounter--;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        final ImageButton addOnePointToSecondTeam = (ImageButton) findViewById(R.id.FootballAddOnePointToSecondTeam);
        addOnePointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                secondTeamCounter++;
                counterSecondTeam.setText(String.valueOf(secondTeamCounter));
            }
        });

        final ImageButton removeOnePointFromSecondTeam = (ImageButton) findViewById(R.id.FootballRemoveOnePointFromSecondTeam);
        removeOnePointFromSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secondTeamCounter > MIN) {
                    secondTeamCounter--;
                    counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                }
            }
        });

        final Button endGame = (Button) findViewById(R.id.FootballEndMatch);
        endGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                running = false;
                EndGameDialog dialog = new EndGameDialog(FootballCounter.this, view.getContext());
                dialog.show(getSupportFragmentManager(), "custom");
                dialog.setCancelable(false);
            }
        });

        final ImageButton pauseGame = (ImageButton) findViewById(R.id.FootballPauseGame);
        pauseGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopStartTime();
                if (running) {
                    pauseGame.setImageResource(R.drawable.ic_stop_black_24dp);
                   /* addOnePointToFirstTeam.setEnabled(true);
                    addOnePointToSecondTeam.setEnabled(true);
                    removeOnePointFromFirstTeam.setEnabled(true);
                    removeOnePointFromSecondTeam.setEnabled(true);
                    endGame.setEnabled(true); */
                } else {
                    pauseGame.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    /* addOnePointToFirstTeam.setEnabled(false);
                    addOnePointToSecondTeam.setEnabled(false);
                    removeOnePointFromFirstTeam.setEnabled(false);
                    removeOnePointFromSecondTeam.setEnabled(false);
                    endGame.setEnabled(false); */
                }
            }
        });
    }

    private void timerGameRun() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes = (seconds) / 60;
                int secon = seconds % 60;

                time = String.format("%02d:%02d", minutes, secon);
                gameTimer.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
    @Override
    public void stopStartTime(){
        running = !running;
    }

    @Override
    public void saveGame() {
        FootballCounter.footballGame.setFirstTeamCount(firstTeamCounter);
        FootballCounter.footballGame.setSecondTeamCount(secondTeamCounter);
        FootballCounter.footballGame.setGameType(2);//Для футболла тип 2
        FootballCounter.footballGame.setGameTime(time);

        // Текущее время
        Date currentDate = new Date();
        footballGame.setGameDate(currentDate);

        boolean result = JsonHelper.addToJsonFile(footballGame, this);
        if (result) {
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Покинуть матч?")
                .setMessage("Вы действительно хотите покинуть матч?" + "\n" + "Текущие результаты не будут сохранены.")
                .setNegativeButton("Нет", null)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        FootballCounter.super.onBackPressed();
                    }
                }).create().show();
    }



}

package com.example.android_sport_project.game_counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_sport_project.FinalScreen;
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
    private int firstTeamCounter;
    private int secondTeamCounter;
    private int firstTeamPartyCounter;
    private int secondTeamPartyCounter;
    private TextView firstTeamPartyResultView;
    private TextView secondTeamPartyResultView;
    private TextView gameTimer;
    private final int LIMIT = 25;
    private final int MIN = 0;
    private String time;
    private int seconds;
    private boolean running;


    public static SportGame volleyballGame = new SportGame();

    @Override
    public SportGame getSportGame() {
        return volleyballGame;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_counter);
        firstTeamCounter = 0;
        secondTeamCounter = 0;
        firstTeamPartyCounter = 0;
        secondTeamPartyCounter = 0;
        running = true;

        counterFirstTeam = (TextView) findViewById(R.id.FirstVolleyballTeamCounter);
        counterSecondTeam = (TextView) findViewById(R.id.SecondVolleyballTeamCounter);
        matchNameView = (TextView) findViewById(R.id.VolleyballMatchName);
        firstTeamNameView = (TextView) findViewById(R.id.VolleyballTeamOneName);
        secondTeamNameView = (TextView) findViewById(R.id.VolleyballTeamTwoName);
        gameTimer = (TextView) findViewById(R.id.VolleyballGameTimer);
        firstTeamPartyResultView = (TextView) findViewById(R.id.FirstVolleyballTeamGameCounter);
        secondTeamPartyResultView = (TextView) findViewById(R.id.SecondVolleyballTeamGameCounter);

        matchNameView.setText(volleyballGame.getMatchName());
        firstTeamNameView.setText(volleyballGame.getFirstTeamName());
        secondTeamNameView.setText(volleyballGame.getSecondTeamName());

        timerGameRun();
        final ImageButton addOnePointToFirstTeam = (ImageButton) findViewById(R.id.VolleyballAddOnePointToFirstTeam);

        addOnePointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                firstTeamCounter++;
                counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                checkVolleyballGameCounter();
            }
        });

        final ImageButton removeOnePointFromFirstTeam = (ImageButton) findViewById(R.id.VolleyballRemoveOnePointFromFirstTeam);
        removeOnePointFromFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter > MIN) {
                    firstTeamCounter--;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        final ImageButton addOnePointToSecondTeam = (ImageButton) findViewById(R.id.VolleyballAddOnePointToSecondTeam);
        addOnePointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                secondTeamCounter++;
                counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                checkVolleyballGameCounter();
            }
        });

        final ImageButton removeOnePointFromSecondTeam = (ImageButton) findViewById(R.id.VolleyballRemoveOnePointFromSecondTeam);
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
                                                 /* addOnePointToFirstTeam.setEnabled(true);
                                                 addOnePointToSecondTeam.setEnabled(true);
                                                 removeOnePointFromFirstTeam.setEnabled(true);
                                                 removeOnePointFromSecondTeam.setEnabled(true);
                                                 endGame.setEnabled(true); */
                                             } else {
                                                 pauseGame.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                                               /*   addOnePointToFirstTeam.setEnabled(false);
                                                 addOnePointToSecondTeam.setEnabled(false);
                                                 removeOnePointFromFirstTeam.setEnabled(false);
                                                 removeOnePointFromSecondTeam.setEnabled(false);
                                                 endGame.setEnabled(false); */
                                             }
                                         }
                                     }
        );
    }

    private void checkVolleyballGameCounter() {
        if (firstTeamCounter >= LIMIT & (firstTeamCounter - secondTeamCounter) >= 2) {
            if (firstTeamPartyCounter < 5) {
                firstTeamPartyCounter++;
            }
            firstTeamPartyResultView.setText(String.valueOf(firstTeamPartyCounter));

            firstTeamCounter = 0;
            secondTeamCounter = 0;
            counterFirstTeam.setText(String.valueOf(firstTeamCounter));
            counterSecondTeam.setText(String.valueOf(secondTeamCounter));
        }
        if (secondTeamCounter >= LIMIT & (secondTeamCounter - firstTeamCounter) >= 2) {
            if (secondTeamPartyCounter < 5) {
                secondTeamPartyCounter++;
            }
            secondTeamPartyResultView.setText(String.valueOf(secondTeamPartyCounter));

            firstTeamCounter = 0;
            secondTeamCounter = 0;
            counterFirstTeam.setText(String.valueOf(firstTeamCounter));
            counterSecondTeam.setText(String.valueOf(secondTeamCounter));
        }

        if(firstTeamPartyCounter ==3 || secondTeamPartyCounter==3){
            saveGame();
            FinalScreen.sportGameFinalScreen = volleyballGame;
            Intent myIntent = new Intent(this, FinalScreen.class);
            startActivityForResult(myIntent, 0);
        }
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
    public void saveGame() {
        VolleyballCounter.volleyballGame.setFirstTeamCount(firstTeamPartyCounter);
        VolleyballCounter.volleyballGame.setSecondTeamCount(secondTeamPartyCounter);
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

    public void stopStartTime() {
        running = !running;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Покинуть матч?")
                .setMessage("Вы действительно хотите покинуть матч?" + "\n" + "Текущие результаты не будут сохранены.")
                .setNegativeButton("Нет", null)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                       VolleyballCounter.super.onBackPressed();
                    }
                }).create().show();
    }

}

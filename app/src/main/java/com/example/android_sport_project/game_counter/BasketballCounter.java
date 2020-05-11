package com.example.android_sport_project.game_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_sport_project.R;
import com.example.android_sport_project.helpers.JsonHelper;
import com.example.android_sport_project.model.SportGame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BasketballCounter extends AppCompatActivity implements Counter{
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

    public static SportGame basketballGame = new SportGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_counter);

        firstTeamCounter = 0;
        secondTeamCounter = 0;
        running = true;

        counterFirstTeam = (TextView) findViewById(R.id.BasketballFirstTeamCounter);
        counterSecondTeam = (TextView) findViewById(R.id.BasketballSecondTeamCounter);
        matchNameView = (TextView) findViewById(R.id.BasketballMatchName);
        firstTeamNameView = (TextView) findViewById(R.id.FirstBasketballTeamName);
        secondTeamNameView = (TextView) findViewById(R.id.SecondBasketballTeamName);
        gameTimer = (TextView) findViewById(R.id.BasketballGameTimer);

        //       matchNameView.setText(basketballGame.getMatchName());
        //       firstTeamNameView.setText(basketballGame.getFirstTeamName());
        //        secondTeamNameView.setText(basketballGame.getSecondTeamName());

        timerGameRun();

        final Button addOnePointToFirstTeam = (Button) findViewById(R.id.BasketballAddOnePointToFirstTeam);
        addOnePointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                firstTeamCounter++;
                counterFirstTeam.setText(String.valueOf(firstTeamCounter));
            }
        });

        final Button addTwoPointToFirstTeam = (Button) findViewById(R.id.BasketballAddTwoPointToFirstTeam);
        addTwoPointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                firstTeamCounter=firstTeamCounter+2;
                counterFirstTeam.setText(String.valueOf(firstTeamCounter));
            }
        });

        final Button addThreePointToFirstTeam = (Button) findViewById(R.id.BasketballAddThreePointToFirstTeam);
        addThreePointToFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                firstTeamCounter=firstTeamCounter+3;
                counterFirstTeam.setText(String.valueOf(firstTeamCounter));
            }
        });

        final Button removeOnePointFromFirstTeam = (Button) findViewById(R.id.BasketballRemoveOnePointFromFirstTeam);
        removeOnePointFromFirstTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (firstTeamCounter > MIN) {
                    firstTeamCounter--;
                    counterFirstTeam.setText(String.valueOf(firstTeamCounter));
                }
            }
        });

        final Button addOnePointToSecondTeam = (Button) findViewById(R.id.BasketballAddOnePointToSecondTeam);
        addOnePointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                secondTeamCounter++;
                counterSecondTeam.setText(String.valueOf(secondTeamCounter));
            }
        });

        final Button addTwoPointToSecondTeam = (Button) findViewById(R.id.BasketballAddTwoPointToSecondTeam);
        addTwoPointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                secondTeamCounter=secondTeamCounter+2;
                counterSecondTeam.setText(String.valueOf(secondTeamCounter));
            }
        });

        final Button addThreePointToSecondTeam = (Button) findViewById(R.id.BasketballAddThreePointToSecondTeam);
        addThreePointToSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                secondTeamCounter=secondTeamCounter+3;
                counterSecondTeam.setText(String.valueOf(secondTeamCounter));
            }
        });

        final Button removeOnePointFromSecondTeam = (Button) findViewById(R.id.BasketballRemoveOnePointFromSecondTeam);
        removeOnePointFromSecondTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (secondTeamCounter > MIN) {
                    secondTeamCounter--;
                    counterSecondTeam.setText(String.valueOf(secondTeamCounter));
                }
            }
        });

        final Button endGame = (Button) findViewById(R.id.BasketballEndMatch);
        endGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                running = false;
                saveGame();
            }
        });

        final Button pauseGame = (Button) findViewById(R.id.BasketballPauseGame);
        pauseGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopStartTime();
                if (running) {
                    pauseGame.setText("Пауза");
                    addOnePointToFirstTeam.setEnabled(true);
                    addTwoPointToFirstTeam.setEnabled(true);
                    addThreePointToFirstTeam.setEnabled(true);
                    addOnePointToSecondTeam.setEnabled(true);
                    addTwoPointToSecondTeam.setEnabled(true);
                    addThreePointToSecondTeam.setEnabled(true);
                    removeOnePointFromFirstTeam.setEnabled(true);
                    removeOnePointFromSecondTeam.setEnabled(true);
                    endGame.setEnabled(true);
                } else {
                    pauseGame.setText("Продолжить");
                    addOnePointToFirstTeam.setEnabled(false);
                    addTwoPointToFirstTeam.setEnabled(false);
                    addThreePointToFirstTeam.setEnabled(false);
                    addOnePointToSecondTeam.setEnabled(false);
                    addTwoPointToSecondTeam.setEnabled(false);
                    addThreePointToSecondTeam.setEnabled(false);
                    removeOnePointFromFirstTeam.setEnabled(false);
                    removeOnePointFromSecondTeam.setEnabled(false);
                    endGame.setEnabled(false);
                }
            }
        });
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
    public void stopStartTime(){
        running = !running;
    }

    @Override
    public void saveGame() {
        BasketballCounter.basketballGame.setFirstTeamCount(firstTeamCounter);
        BasketballCounter.basketballGame.setSecondTeamCount(secondTeamCounter);
        BasketballCounter.basketballGame.setGameType(3);//Для баскетболла тип 3
        BasketballCounter.basketballGame.setGameTime(time);

        // Текущее время
        Date currentDate = new Date();
        basketballGame.setGameDate(currentDate);

        boolean result = JsonHelper.addToJsonFile(basketballGame, this);
        if (result) {
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.android_sport_project.game_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_counter.BasketballCounter;
import com.example.android_sport_project.game_counter.FootballCounter;

public class BasketballStarter extends AppCompatActivity {
    EditText startMatchName;
    EditText startFirstTeamName;
    EditText startSecondTeamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_starter);
         startMatchName = (EditText) findViewById(R.id.BasketballMatchNameStart);
         startFirstTeamName = (EditText) findViewById(R.id.BasketballFirstTeamStart);
         startSecondTeamName = (EditText) findViewById(R.id.BasketballSecondTeamStart);

        Button bBCounter = (Button) findViewById(R.id.BbCounter);
                bBCounter.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                BasketballCounter.basketballGame.setFirstTeamName( String.valueOf(startFirstTeamName.getText()));
                BasketballCounter.basketballGame.setSecondTeamName(String.valueOf(startSecondTeamName.getText()));
                BasketballCounter.basketballGame.setMatchName(String.valueOf(startMatchName.getText()));

                Intent myIntent = new Intent(view.getContext(), BasketballCounter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

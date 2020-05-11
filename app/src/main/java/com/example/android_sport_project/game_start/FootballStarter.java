package com.example.android_sport_project.game_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_counter.FootballCounter;

public class FootballStarter extends AppCompatActivity {
    EditText startMatchName;
    EditText startFirstTeamName;
    EditText startSecondTeamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_starter);
        startMatchName = (EditText) findViewById(R.id.FootballMatchNameStart);
        startFirstTeamName = (EditText) findViewById(R.id.FootballFirstTeamStart);
        startSecondTeamName = (EditText) findViewById(R.id.FootballSecondTeamStart);

        Button fbCounter = (Button) findViewById(R.id.FbCounter);
        fbCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FootballCounter.footballGame.setFirstTeamName(String.valueOf(startFirstTeamName.getText()));
                FootballCounter.footballGame.setSecondTeamName(String.valueOf(startSecondTeamName.getText()));
                FootballCounter.footballGame.setMatchName(String.valueOf(startMatchName.getText()));

                Intent myIntent = new Intent(view.getContext(), FootballCounter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

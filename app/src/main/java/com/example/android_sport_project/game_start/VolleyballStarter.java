package com.example.android_sport_project.game_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_counter.VolleyballCounter;

public class VolleyballStarter extends AppCompatActivity {
    EditText startMatchName;
    EditText startFirstTeamName;
    EditText startSecondTeamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_starter);
        startMatchName = (EditText) findViewById(R.id.VolleyballMatchNameStart);
        startFirstTeamName = (EditText) findViewById(R.id.VolleyballFirstTeamStart);
        startSecondTeamName = (EditText) findViewById(R.id.VolleyballSecondTeamStart);

        Button vbCounter = (Button) findViewById(R.id.VbCounter);
        vbCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VolleyballCounter.volleyballGame.setFirstTeamName( String.valueOf(startFirstTeamName.getText()));
                VolleyballCounter.volleyballGame.setSecondTeamName(String.valueOf(startSecondTeamName.getText()));
                VolleyballCounter.volleyballGame.setMatchName(String.valueOf(startMatchName.getText()));

                Intent myIntent = new Intent(view.getContext(), VolleyballCounter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}


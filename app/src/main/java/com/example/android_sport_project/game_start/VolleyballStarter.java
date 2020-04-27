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
        startMatchName = (EditText) findViewById(R.id.MatchNameStart);
        startFirstTeamName = (EditText) findViewById(R.id.FirstTeamStart);
        startSecondTeamName = (EditText) findViewById(R.id.SecondTeamStart);

        Button vbCounter = (Button) findViewById(R.id.VbCounter);
        vbCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VolleyballCounter.matchName =  String.valueOf(startMatchName.getText());
                VolleyballCounter.firstTeamName =  String.valueOf(startFirstTeamName.getText());
                VolleyballCounter.secondTeamName = String.valueOf(startSecondTeamName.getText());
                Intent myIntent = new Intent(view.getContext(), VolleyballCounter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}


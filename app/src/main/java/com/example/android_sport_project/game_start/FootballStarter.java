package com.example.android_sport_project.game_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_counter.FootballCounter;

public class FootballStarter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_starter);

        Button fbCounter = (Button) findViewById(R.id.FbCounter);
        fbCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FootballCounter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

package com.example.android_sport_project.rules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_start.FootballStarter;

public class FootballRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_rules);

        Button fbStarter = (Button) findViewById(R.id.FbStartGame);
        fbStarter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FootballStarter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}

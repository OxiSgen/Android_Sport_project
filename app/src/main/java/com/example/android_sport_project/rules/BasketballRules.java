package com.example.android_sport_project.rules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_start.BasketballStarter;


public class BasketballRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_rules);

        Button bBStarter = (Button) findViewById(R.id.BbStarter);
        bBStarter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BasketballStarter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

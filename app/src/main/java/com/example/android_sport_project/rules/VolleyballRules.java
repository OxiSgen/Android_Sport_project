package com.example.android_sport_project.rules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_sport_project.R;
import com.example.android_sport_project.game_start.VolleyballStarter;

public class VolleyballRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball_rules);

        Button vBStarter = (Button) findViewById(R.id.VbStarter);
        vBStarter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), VolleyballStarter.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

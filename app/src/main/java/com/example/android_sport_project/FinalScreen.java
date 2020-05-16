package com.example.android_sport_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_sport_project.Menu;
import com.example.android_sport_project.game_counter.Counter;
import com.example.android_sport_project.model.SportGame;

public class FinalScreen extends AppCompatActivity {
    public static SportGame sportGameFinalScreen;
    private TextView teamOneNameView;
    private TextView teamTwoNameView;
    private TextView teamOneScoreView;
    private TextView teamTwoScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.final_fcreen);

        teamOneNameView = (TextView) findViewById(R.id.FinalScreenTeamOne);
        teamTwoNameView = (TextView) findViewById(R.id.FinalScreenTeamTwo);
        teamOneScoreView = (TextView) findViewById(R.id.FinalScreenScoreTeamOne);
        teamTwoScoreView = (TextView) findViewById(R.id.FinalScreenScoreTeamTwo);

        teamOneNameView.setText(sportGameFinalScreen.getFirstTeamName());
        teamTwoNameView.setText(sportGameFinalScreen.getSecondTeamName());
        teamOneScoreView.setText(String.valueOf(sportGameFinalScreen.getFirstTeamCount()));
        teamTwoScoreView.setText(String.valueOf(sportGameFinalScreen.getSecondTeamCount()));

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        getWindow().setBackgroundDrawableResource(R.drawable.kruglie_ugli);
        getWindow().setLayout((int) (screenWidth / 1.45), (int) (screenHeight / 1.55));

        Button Bmain = (Button) findViewById(R.id.button_na_main_screen);
        Bmain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
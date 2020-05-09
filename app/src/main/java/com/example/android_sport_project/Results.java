package com.example.android_sport_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.android_sport_project.helpers.DataHelperSave;
import com.example.android_sport_project.helpers.JsonHelper;
import com.example.android_sport_project.model.SportGame;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Results extends AppCompatActivity {
    //TextView result;
    private RecyclerView recyclerView;
    private ScoreAdapter adapter = new ScoreAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result_table);
        // ConstraintLayout v = (ConstraintLayout) findViewById(R.id.result);
        //result = findViewById(R.id.ResultView);
       // String jsonResult = DataHelperSave.read(this);
       // result.setText(jsonResult);

        // данных из JSON для парсинга --For Danya

        recyclerView = findViewById(R.id.rvMain);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        getWindow().setBackgroundDrawableResource(R.drawable.kruglie_ugli);
        getWindow().setLayout((int) (screenWidth / 1.15), (int) (screenHeight / 1.15));


        initData();
    }
    private void initData() {
        Gson gson = new Gson();
        JsonHelper.DataItem dataItem = gson.fromJson(DataHelperSave.read(this), JsonHelper.DataItem.class);
        List<SportGame> sportGames = dataItem.getSportGames();
        for(int i = 0; i < sportGames.size(); i++) {
            String Score = (sportGames.get(i).getFirstTeamCount()) + ":" + (sportGames.get(i).getSecondTeamCount());
            adapter.addScore(new Score(sportGames.get(i).getGameType(), sportGames.get(i).getFirstTeamName(), Score , sportGames.get(i).getSecondTeamName(), sportGames.get(i).getGameDate()));
        }

    }
}


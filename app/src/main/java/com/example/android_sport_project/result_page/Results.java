package com.example.android_sport_project.result_page;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.android_sport_project.R;
import com.example.android_sport_project.helpers.DataHelperSave;
import com.example.android_sport_project.helpers.JsonHelper;
import com.example.android_sport_project.model.SportGame;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Results extends AppCompatActivity {
    //TextView result;
    private RecyclerView recyclerView;
    private SportGameResultAdapter adapter = new SportGameResultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result_table);

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
        if (dataItem != null) {
            List<SportGame> sportGameList = dataItem.getSportGames();

            for (SportGame sportGame : sportGameList) {
                adapter.addScore(sportGame);
            }
        }
    }
}


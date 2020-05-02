package com.example.android_sport_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_sport_project.helpers.DataHelperSave;
import com.example.android_sport_project.helpers.JsonHelper;
import com.example.android_sport_project.model.SportGame;
import com.google.gson.Gson;

import java.util.List;

public class Results extends AppCompatActivity {
private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_table);
        result = findViewById(R.id.ResultView);
        String jsonResult = DataHelperSave.read(this);
        result.setText(jsonResult);

/*      Получение данных из JSON для парсинга --For Danya
        Gson gson = new Gson();
        JsonHelper.DataItem dataItem = gson.fromJson(DataHelperSave.read(this), JsonHelper.DataItem.class);
        List<SportGame> sportGames = dataItem.getSportGames();*/
    }
}

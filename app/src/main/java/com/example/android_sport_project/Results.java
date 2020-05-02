package com.example.android_sport_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.android_sport_project.helpers.DataHelperSave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Results extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result_table);
        // ConstraintLayout v = (ConstraintLayout) findViewById(R.id.result);
        /*   result = findViewById(R.id.ResultView);
        String jsonResult = DataHelperSave.read(this);
        result.setText(jsonResult);

        Получение данных из JSON для парсинга --For Danya
        Gson gson = new Gson();
        JsonHelper.DataItem dataItem = gson.fromJson(DataHelperSave.read(this), JsonHelper.DataItem.class);
        List<SportGame> sportGames = dataItem.getSportGames();*/
        

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        getWindow().setBackgroundDrawableResource(R.drawable.kruglie_ugli);
        getWindow().setLayout((int)(screenWidth/1.15),(int)(screenHeight/1.15));
    }
}

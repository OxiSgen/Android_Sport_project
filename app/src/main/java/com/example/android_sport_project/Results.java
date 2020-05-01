package com.example.android_sport_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Results extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result_table);
        // ConstraintLayout v = (ConstraintLayout) findViewById(R.id.result);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        getWindow().setBackgroundDrawableResource(R.drawable.kruglie_ugli);
        getWindow().setLayout((int)(screenWidth/1.15),(int)(screenHeight/1.15));
    }
}

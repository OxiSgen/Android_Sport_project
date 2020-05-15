package com.example.android_sport_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android_sport_project.Menu;

public class FinalScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.final_fcreen);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        getWindow().setBackgroundDrawableResource(R.drawable.kruglie_ugli);
        getWindow().setLayout((int) (screenWidth / 1.45), (int) (screenHeight / 1.55));




        Button Bmain = (Button)findViewById(R.id.button_na_main_screen);
        Bmain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Menu.class );
                startActivityForResult(myIntent, 0);
            }
        });

    }

}
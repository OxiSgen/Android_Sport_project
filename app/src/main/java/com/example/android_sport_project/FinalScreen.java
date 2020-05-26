package com.example.android_sport_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FinalScreen.this.setFinishOnTouchOutside(false);
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.final_fcreen);

        teamOneNameView = (TextView) findViewById(R.id.FinalScreenTeamOne);
        teamTwoNameView = (TextView) findViewById(R.id.FinalScreenTeamTwo);
        teamOneScoreView = (TextView) findViewById(R.id.FinalScreenScoreTeamOne);
        image = (ImageView) findViewById(R.id.imageView3);
       // teamTwoScoreView = (TextView) findViewById(R.id.FinalScreenScoreTeamTwo);

        teamOneNameView.setText(sportGameFinalScreen.getFirstTeamName());
        teamTwoNameView.setText(sportGameFinalScreen.getSecondTeamName());
        teamOneScoreView.setText(String.format("%s : %s", sportGameFinalScreen.getFirstTeamCount(), sportGameFinalScreen.getSecondTeamCount()));
       // teamTwoScoreView.setText(String.valueOf(sportGameFinalScreen.getSecondTeamCount()));

        final float scale = getResources().getDisplayMetrics().density;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        getWindow().setBackgroundDrawableResource(R.drawable.kruglie_ugli);
        getWindow().setLayout((int) (screenWidth / 1.35), (int) (426 * scale + 0.5f));



       // image.setImageResource(R.drawable.emoji_events);

        Button Bmain = (Button) findViewById(R.id.button_na_main_screen);
        Bmain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
    @Override
    public void onBackPressed() {}

}
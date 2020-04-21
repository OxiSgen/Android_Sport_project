package com.example.android_sport_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);


        Thread splash_time = new Thread() {
            public void run() {
                try {
                    //Целое значение время отображения картинки:
                    int SplashTimer = 0;
                    //Запускаем цикл длиной в 3 секунды:
                    while (SplashTimer < 3000) {
                        sleep(50);
                        SplashTimer = SplashTimer + 100;
                    }
                    ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //Закрываем activity:
                    finish();
                    startActivity(new Intent(MainActivity.this, Menu.class));
                }
            }
        };
        splash_time.start();

    }

}

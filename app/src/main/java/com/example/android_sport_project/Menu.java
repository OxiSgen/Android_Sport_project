package com.example.android_sport_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.android_sport_project.result_page.Results;
import com.example.android_sport_project.rules.BasketballRules;
import com.example.android_sport_project.rules.FootballRules;
import com.example.android_sport_project.rules.VolleyballRules;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Menu extends AppCompatActivity {

    Dialog exitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        Button fbRules = (Button) findViewById(R.id.FRbutton);
        fbRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FootballRules.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button bbRules = (Button) findViewById(R.id.BRbutton);
        bbRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BasketballRules.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button VbRules = (Button) findViewById(R.id.VRbutton);
        VbRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), VolleyballRules.class);
                startActivityForResult(myIntent, 0);
            }
        });

        FloatingActionButton fabb =  findViewById(R.id.fab);
        fabb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Results.class);
                startActivityForResult(myIntent, 0);

            }

        });


    }

    @Override
    public void onBackPressed() {}
}

package com.example.android_sport_project.dialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.android_sport_project.FinalScreen;
import com.example.android_sport_project.Menu;
import com.example.android_sport_project.R;
import com.example.android_sport_project.game_counter.BasketballCounter;
import com.example.android_sport_project.game_counter.Counter;

public class EndGameDialog extends DialogFragment {
    private final Counter gameCounter;
    private final Context context;


    public EndGameDialog(Counter counter, Context context) {
        this.gameCounter = counter;
        this.context = context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("Вы действительно хотите завершить игру ?")
                .setPositiveButton("Да",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                gameCounter.saveGame();
                                dialog.cancel();

                                FinalScreen.sportGameFinalScreen = gameCounter.getSportGame();
                                Intent myIntent = new Intent(context, FinalScreen.class);
                                startActivityForResult(myIntent, 0);
                            }
                        })
                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                                gameCounter.stopStartTime();
                            }
                        })
                .create();
    }
}
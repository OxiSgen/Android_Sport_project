package com.example.android_sport_project.helpers;

import android.content.Context;

import com.example.android_sport_project.model.SportGame;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public class JsonHelper {
    private static Gson gson = new Gson();

    public static boolean addToJsonFile(SportGame sportGame, Context context) {
        if (DataHelperSave.isFilePresent(context)) {
            //DataItem dataItem = gson.fromJson(DataHelperSave.read(context),DataItem.class);

            try {
               // DataItem dataItem = fromJsonFile(context);
               /// dataItem.getSportGames().add(sportGame);
                String jsonResult = gson.toJson(sportGame);
                DataHelperSave.create(context, jsonResult);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
        return false;
    }

    public static DataItem fromJsonFile(Context context) {
        String jsonStringFromFile = DataHelperSave.read(context);
        DataItem dataItem = gson.fromJson(DataHelperSave.read(context), DataItem.class);

        return dataItem;
    }

    private static class DataItem {
        List<SportGame> sportGames;

        public List<SportGame> getSportGames() {
            return sportGames;
        }

        public void setSportGames(List<SportGame> sportGames) {
            this.sportGames = sportGames;
        }
    }
}



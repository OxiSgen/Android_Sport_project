package com.example.android_sport_project.helpers;

import android.content.Context;

import com.example.android_sport_project.model.SportGame;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private static Gson gson = new Gson();

    public static boolean addToJsonFile(SportGame sportGame, Context context) {
        try {
            DataItem dataItem = fromJsonFile(context);
            if (dataItem == null) {
                dataItem = new DataItem();
                dataItem.getSportGames().add(sportGame);
            } else {
                dataItem.getSportGames().add(sportGame);
            }
            String jsonResult = gson.toJson(dataItem);
            DataHelperSave.create(context, jsonResult);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static DataItem fromJsonFile(Context context) {
        String jsonStringFromFile = DataHelperSave.read(context);
        DataItem dataItem = new DataItem();
        if (jsonStringFromFile != null) {
            dataItem = gson.fromJson(DataHelperSave.read(context), DataItem.class);
        }
        return dataItem;
    }

    public static class DataItem {
        List<SportGame> sportGames;

        public DataItem() {
            this.sportGames = new ArrayList<>();
        }

        public List<SportGame> getSportGames() {
            if (sportGames != null) {
                return sportGames;
            } else {
                return new ArrayList<>();
            }

        }

        public void setSportGames(List<SportGame> sportGames) {
            this.sportGames = sportGames;
        }
    }
}



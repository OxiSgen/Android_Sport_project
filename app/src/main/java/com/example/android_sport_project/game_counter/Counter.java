package com.example.android_sport_project.game_counter;

import com.example.android_sport_project.model.SportGame;

public interface Counter {
    void saveGame();
    void stopStartTime();
    SportGame getSportGame();
}

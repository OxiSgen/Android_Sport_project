package com.example.android_sport_project.model;

import androidx.annotation.NonNull;

public class SportGame {
    private String firstTeamName;
    private String secondTeamName;
    private String matchName;
    private int gameType; //1-воллейболл, 2-футболл, 3-баскетболл
    private int firstTeamCount;
    private int secondTeamCount;
    private String gameTime;
    private String gameDate;

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public int getFirstTeamCount() {
        return firstTeamCount;
    }

    public void setFirstTeamCount(int firstTeamCount) {
        this.firstTeamCount = firstTeamCount;
    }

    public int getSecondTeamCount() {
        return secondTeamCount;
    }

    public void setSecondTeamCount(int secondTeamCount) {
        this.secondTeamCount = secondTeamCount;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    @Override
    public String toString() {
        return "SportGame{" +
                "firstTeamName='" + firstTeamName + '\'' +
                ", secondTeamName='" + secondTeamName + '\'' +
                ", matchName='" + matchName + '\'' +
                ", gameType=" + gameType +
                ", firstTeamCount=" + firstTeamCount +
                ", secondTeamCount=" + secondTeamCount +
                ", gameTime='" + gameTime + '\'' +
                ", gameDate='" + gameDate + '\'' +
                '}';
    }
}

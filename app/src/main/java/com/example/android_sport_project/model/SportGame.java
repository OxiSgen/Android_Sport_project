package com.example.android_sport_project.model;

public class SportGame {
    private String firstTeamName;
    private String secondTeamName;
    private String MatchName;
    private int gameType; //1-воллейболл, 2-футболл, 3-баскетболл
    private int firstTeamCount;
    private int secondTeamCount;
    private String gameTime;

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
        return MatchName;
    }

    public void setMatchName(String matchName) {
        MatchName = matchName;
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
}

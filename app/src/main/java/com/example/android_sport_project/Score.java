package com.example.android_sport_project;

public class Score {
    private int type;
    private String firstTeam;
    private String score;
    private String secondTeam;
    private String date;

    public Score(int type, String firstTeam, String score, String secondTeam, String date) {
        this.type = type;
        this.firstTeam = firstTeam;
        this.score = score;
        this.secondTeam = secondTeam;
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getScore() {
        return score;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public String getDate() {
        return date;
    }
}

package com.alvaro.movieparty.views;

import java.util.ArrayList;

/**
 * Created by Alvaro on 08/04/2017.
 */

public class Team {
    ArrayList<String> playerList;
    int score;

    public Team() {
        this.score = 0;
    }

    public ArrayList<String> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<String> playerList) {
        this.playerList = playerList;
    }

    public int getScore() {
        return score;
    }
    public void scorePoint(){
        this.score++;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

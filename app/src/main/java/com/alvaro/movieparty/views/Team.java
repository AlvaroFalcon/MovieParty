package com.alvaro.movieparty.views;

import java.util.ArrayList;

/**
 * Created by Alvaro on 08/04/2017.
 */

public class Team {
    ArrayList<String> playerList;
    String name;
    int score;

    public Team(String name) {
        this.score = 0;
        this.name = name;
        playerList = new ArrayList<>();
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
    public void addPlayer(String player){
        this.playerList.add(player);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

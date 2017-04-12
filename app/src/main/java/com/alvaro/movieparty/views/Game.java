package com.alvaro.movieparty.views;

import java.util.ArrayList;

/**
 * Created by Alvaro on 12/04/2017.
 */

public class Game {
    private ArrayList<Team> teamList;
    private int round;
    private int numberOfMovies;

    public Game() {
        teamList = new ArrayList<>();
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }
}

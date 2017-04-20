package com.alvaro.movieparty.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alvaro.movieparty.R;
import com.alvaro.movieparty.views.AppCommon;
import com.alvaro.movieparty.views.Team;
import com.alvaro.movieparty.views.activities.GameActivity;
import com.alvaro.movieparty.views.activities.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomTeamsFragment extends Fragment {

    View view;
    private EditText players,numberOfTeams;
    private Button nextButton;
    List<String> playerList;
    ArrayList<Team> teamList;
    int totalTeams;

    public RandomTeamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_random_teams, container, false);
        init();
        return view;
    }

    private void init() {
        initElements();
        initActions();
        playerList = new ArrayList<>();
        teamList = new ArrayList<>();
        totalTeams = 0;
    }


    private void initElements() {
        players = (EditText) view.findViewById(R.id.random_participants_container);
        numberOfTeams = (EditText) view.findViewById(R.id.number_of_random_teams);
        nextButton = (Button) view.findViewById(R.id.random_next_button);
    }

    private void initActions() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPlayers();
                initTotalTeams();
                if (moreTeamsThanPlayers()){
                    AppCommon.getInstance().makeToast(getContext(),"Debe haber al menos un jugador por cada equipo");
                }else{
                    formTeams();
                    saveTeamList();
                    startMoviesPerTeamFragment();
                }
            }
        });
    }

    private void saveTeamList() {
        AppCommon.getInstance().getGame().setTeamList(teamList);
    }

    private void initTotalTeams() {
        totalTeams = getNumberOfTeams();
    }

    private void formTeams() {
        initTeams();
        ArrayList<String> playersCopy = new ArrayList<>(playerList);
        Collections.shuffle(playersCopy);
        while(existPlayers(playersCopy)){
            addPlayer(playersCopy);
        }
    }
    private void startMoviesPerTeamFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("RandomTeams");
        transaction.replace(R.id.game_container, new MoviesPerTeamFragment());
        transaction.commit();
    }

    private void addPlayer(ArrayList<String> playersCopy) {
        for (int i = 0; i < teamList.size(); i++) {
            if (playersCopy.isEmpty()) break;
            addPlayerToTeam(playersCopy, i);
        }
    }

    private void addPlayerToTeam(ArrayList<String> playersCopy, int i) {
        teamList.get(i).addPlayer(playersCopy.get(0));
        playersCopy.remove(0);
    }

    private boolean existPlayers(ArrayList<String> playersCopy) {
        return !playersCopy.isEmpty();
    }

    private void initTeams() {
        for (int i = 0; i < totalTeams; i++) {
            teamList.add(new Team("Equipo"+i+1));
        }
    }

    private boolean moreTeamsThanPlayers() {
        return playerList.size() < totalTeams;
    }

    private int getNumberOfTeams() {
        return Integer.parseInt(numberOfTeams.getText().toString());
    }

    private void getPlayers() {
        playerList = fromEditToList();
    }

    @NonNull
    private List<String> fromEditToList() {
        return Arrays.asList(removeSpaces().split(","));
    }

    @NonNull
    private String removeSpaces() {
        return players.getText().toString().trim();
    }

}

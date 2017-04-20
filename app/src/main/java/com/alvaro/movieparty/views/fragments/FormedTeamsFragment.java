package com.alvaro.movieparty.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alvaro.movieparty.R;
import com.alvaro.movieparty.views.AppCommon;
import com.alvaro.movieparty.views.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormedTeamsFragment extends Fragment {


    private View view;
    private TextView teamNumberTextView;
    private EditText players;
    private ArrayList<String> playerList;
    private ArrayList<Team> teamList;
    private Button nextTeamButton, readyButton;
    private int currentTeam;

    public FormedTeamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_formed_teams, container, false);
        init();
        return view;
    }

    private void init() {
        initElements();
        playerList = new ArrayList<>();
        teamList = new ArrayList<>();
        initActions();
        initCurrentTeam();
    }

    private void getPlayerList() {
        fromEditToList();
    }

    private void initElements() {
        teamNumberTextView = (TextView) view.findViewById(R.id.team_number);
        players = (EditText) view.findViewById(R.id.participants_container);
        nextTeamButton = (Button) view.findViewById(R.id.next_team_button);
        readyButton = (Button) view.findViewById(R.id.ready_button);

    }

    private void initActions() {
        nextTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getPlayerList();
                if (moreThanOnePlayer()){
                    addTeam(playerList);
                    refresh();
                }else{
                    AppCommon.getInstance().makeToast(getContext(),"Debe haber al menos un jugador por cada equipo");
                }
            }
        });
        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noEnoughTeams()){
                    AppCommon.getInstance().makeToast(getContext(),"Debe haber al menos dos equipos");
                }else{
                    saveTeams();
                    startMoviesPerTeamFragment();
                }
            }
        });
    }

    private void startMoviesPerTeamFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("FormedTeams");
        transaction.replace(R.id.game_container, new MoviesPerTeamFragment());
        transaction.commit();
    }

    private void saveTeams() {
        AppCommon.getInstance().getGame().setTeamList(teamList);
    }

    private boolean noEnoughTeams() {
        return teamList.size() < 2;
    }

    private boolean moreThanOnePlayer() {
        return !playerList.isEmpty();
    }

    private void refresh() {
        currentTeam++;
        playerList.clear();
        teamNumberTextView.setText("Equipo "+currentTeam);
        players.setText("");

    }

    private void addTeam(List<String> playerList) {
        Team team = new Team("Equipo "+currentTeam);
        team.addAllPlayers(playerList);
        teamList.add(team);
    }

    @NonNull
    private void fromEditToList() {
        if (!players.getText().toString().equals("")){
            playerList.addAll(Arrays.asList(removeSpaces().split(",")));
        }
    }

    @NonNull
    private String removeSpaces() {
        return players.getText().toString().trim();
    }


    private void initCurrentTeam() {
        this.currentTeam = 1;
    }


}

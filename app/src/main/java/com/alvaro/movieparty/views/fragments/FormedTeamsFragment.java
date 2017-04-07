package com.alvaro.movieparty.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alvaro.movieparty.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormedTeamsFragment extends Fragment {


    private View view;
    private TextView teamNumberTextView;
    private EditText players;
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
        initActions();
        initCurrentTeam();
    }

    private void initElements() {
        teamNumberTextView = (TextView) view.findViewById(R.id.team_number);
        players = (EditText) view.findViewById(R.id.participants_container);
        nextTeamButton = (Button) view.findViewById(R.id.next_team_button);
        readyButton = (Button) view.findViewById(R.id.ready_button);

    }

    private void initActions() {
    }

    private void initCurrentTeam() {
        this.currentTeam = 1;
    }


}

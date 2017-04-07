package com.alvaro.movieparty.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alvaro.movieparty.R;
import com.alvaro.movieparty.views.activities.GameActivity;
import com.alvaro.movieparty.views.activities.MainActivity;

public class RandomTeamsFragment extends Fragment {

    View view;
    private EditText players,numberOfTeams;
    private Button nextButton;

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
    }


    private void initElements() {
        players = (EditText) view.findViewById(R.id.random_participants_container);
        numberOfTeams = (EditText) view.findViewById(R.id.number_of_random_teams);
        nextButton = (Button) view.findViewById(R.id.random_next_button);
    }

    private void initActions() {
    }

}

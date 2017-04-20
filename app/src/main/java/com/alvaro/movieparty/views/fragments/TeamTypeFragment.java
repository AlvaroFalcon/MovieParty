package com.alvaro.movieparty.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alvaro.movieparty.R;

public class TeamTypeFragment extends Fragment {
    Button randomTeamsButton, formedTeamButton;

    public TeamTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_type, container, false);
        readBundle(getArguments());
        initialize(view);
        return view;
    }


    private void readBundle(Bundle bundle) {

        if (bundle != null) {
            //TODO Get values from bundle...
        }
    }

    private void initialize(View view) {
        initElements(view);
        initActions();
    }

    private void initElements(View view) {
        randomTeamsButton       = (Button)      view.findViewById(R.id.random_team_button);
        formedTeamButton        = (Button)      view.findViewById(R.id.formed_team_button);
    }
    private void initActions() {
        randomTeamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRandomTeamsFragment();
            }
        });
        formedTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFormedTeamsFragment();
            }
        });
    }

    private void startFormedTeamsFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("TeamTypeSelection");
        transaction.replace(R.id.game_container, new FormedTeamsFragment());
        transaction.commit();
    }

    private void startRandomTeamsFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("TeamTypeSelection");
        transaction.replace(R.id.game_container, new RandomTeamsFragment());
        transaction.commit();
    }
}

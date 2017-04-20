package com.alvaro.movieparty.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alvaro.movieparty.R;
import com.alvaro.movieparty.views.AppCommon;

public class MoviesPerTeamFragment extends Fragment {
    private View view;
    private Button nextButton;
    private EditText moviesPerTeam;

    public MoviesPerTeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_movies_per_team, container, false);
        init();
        return view;
    }

    private void init() {
        initElements();
        initActions();
    }


    private void initElements() {
        nextButton      = (Button)      view.findViewById(R.id.create_game_button);
        moviesPerTeam   = (EditText)    view.findViewById(R.id.movies_per_team);
    }

    private void initActions() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCommon.getInstance().getGame().setNumberOfMovies(getNumberOfMovies());
            }
        });
    }

    private int getNumberOfMovies() {
        return Integer.parseInt(moviesPerTeam.getText().toString());
    }
}

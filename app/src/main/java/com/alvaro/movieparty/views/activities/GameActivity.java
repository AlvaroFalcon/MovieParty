package com.alvaro.movieparty.views.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alvaro.movieparty.R;
import com.alvaro.movieparty.views.fragments.FormedTeamsFragment;
import com.alvaro.movieparty.views.fragments.RandomTeamsFragment;
import com.alvaro.movieparty.views.fragments.TeamTypeFragment;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        startSelectionFragment();
    }

    private void startSelectionFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.game_container, new TeamTypeFragment());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}

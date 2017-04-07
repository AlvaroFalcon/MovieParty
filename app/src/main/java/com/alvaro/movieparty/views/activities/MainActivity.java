package com.alvaro.movieparty.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alvaro.movieparty.R;

public class MainActivity extends AppCompatActivity {
    Button startButton, configButton;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.view = findViewById(android.R.id.content);
        init();
    }

    private void init() {
        initElements(view);
        initActions();
    }


    private void initElements(View view) {
        startButton     = (Button)      view.findViewById(R.id.start_game_button);
        configButton    = (Button)      view.findViewById(R.id.configuration_button);
    }

    private void initActions() {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }

}

package com.alvaro.movieparty.views;

import android.content.Context;
import android.widget.Toast;

public class AppCommon {
    private static AppCommon mInstance = null;

    private String mString;
    private Game game;

    private AppCommon() {
        this.game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static AppCommon getInstance() {
        if (mInstance == null) {
            mInstance = new AppCommon();
        }
        return mInstance;
    }
    public void makeToast(Context context, String toastMessage) {
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
    public String getString() {
        return this.mString;
    }

    public void setString(String value) {
        mString = value;
    }
}
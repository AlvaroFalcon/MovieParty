package com.alvaro.movieparty.views;

public class AppCommon {
    private static AppCommon mInstance = null;

    private String mString;

    private AppCommon() {
        mString = "Hello";
    }

    public static AppCommon getInstance() {
        if (mInstance == null) {
            mInstance = new AppCommon();
        }
        return mInstance;
    }

    public String getString() {
        return this.mString;
    }

    public void setString(String value) {
        mString = value;
    }
}
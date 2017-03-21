package com.example.android.miwok;

/**
 * Created by Muhammad Attia on 25/02/2017.
 */

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

}
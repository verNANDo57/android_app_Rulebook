package com.verNANDo57.rulebook_educational;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

public class AppRulebookClass extends Application {
    RulebookApplicationSharedPreferences preferences;

    public void onCreate() {
        super.onCreate();

        preferences = new RulebookApplicationSharedPreferences(getApplicationContext());

        if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        } else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}

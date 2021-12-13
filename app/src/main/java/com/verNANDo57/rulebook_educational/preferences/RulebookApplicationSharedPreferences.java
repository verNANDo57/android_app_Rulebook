package com.verNANDo57.rulebook_educational.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class RulebookApplicationSharedPreferences {
    SharedPreferences RulebookSharedPreferences;

    public static String PREFS_FILE_NAME = "rulebookprefs";
    public static String DARK_MODE = "dark_mode";
    public static String STATUS_BAR_STATE_BOOLEAN = "status_bar";

    public RulebookApplicationSharedPreferences(Context context) {
        RulebookSharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    //These methods will save
    public void setRulebookDarkModeBooleanState(int state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putInt(DARK_MODE, state);
        editor.apply();
    }
    public void setRulebookStatusBarBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean(STATUS_BAR_STATE_BOOLEAN, state);
        editor.apply();
    }

    //These methods will load
    public int loadRulebookDarkModeBooleanState (){
        return RulebookSharedPreferences.getInt(DARK_MODE, AppCompatDelegate.MODE_NIGHT_NO);
    }
    public Boolean loadRulebookStatusBarBooleanState (){
        return RulebookSharedPreferences.getBoolean(STATUS_BAR_STATE_BOOLEAN, true);
    }
}

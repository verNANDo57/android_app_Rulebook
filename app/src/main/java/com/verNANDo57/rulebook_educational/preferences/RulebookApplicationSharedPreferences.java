/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class RulebookApplicationSharedPreferences {
    private final SharedPreferences RulebookSharedPreferences;

    private static final String PREFS_FILE_NAME = "rulebookprefs";
    private static final String DARK_MODE = "dark_mode";
    private static final String STATUS_BAR_STATE_BOOLEAN = "status_bar";
    private static final String RULEBOOK_LAUNCHED_FOR_THE_FIRST_TIME_STATE_BOOLEAN = "launched_for_the_first_time";
    private static final String USE_SDCARD = "use_sdcard";

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
    public void setRulebookIsLaunchedForTheFirstTimeBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean(RULEBOOK_LAUNCHED_FOR_THE_FIRST_TIME_STATE_BOOLEAN, state);
        editor.apply();
    }
    public void setRulebookUseSDCardBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean(USE_SDCARD, state);
        editor.apply();
    }

    //These methods will load
    public int loadRulebookDarkModeBooleanState (){
        return RulebookSharedPreferences.getInt(DARK_MODE, AppCompatDelegate.MODE_NIGHT_NO);
    }
    public Boolean loadRulebookStatusBarBooleanState (){
        return RulebookSharedPreferences.getBoolean(STATUS_BAR_STATE_BOOLEAN, true);
    }
    public Boolean loadRulebookIsLaunchedForTheFirstTimeBooleanState (){
        return RulebookSharedPreferences.getBoolean(RULEBOOK_LAUNCHED_FOR_THE_FIRST_TIME_STATE_BOOLEAN, true);
    }
    public Boolean loadRulebookUseSDCardBooleanState (){
        return RulebookSharedPreferences.getBoolean(USE_SDCARD, false);
    }
}

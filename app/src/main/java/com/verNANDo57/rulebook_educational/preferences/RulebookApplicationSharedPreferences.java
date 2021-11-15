package com.verNANDo57.rulebook_educational.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class RulebookApplicationSharedPreferences {
    SharedPreferences RulebookSharedPreferences;
    public RulebookApplicationSharedPreferences(Context context) {
        RulebookSharedPreferences = context.getSharedPreferences("rulebookprefs", Context.MODE_PRIVATE);
    }

    //This method will save statusbar boolean state
    public void setRulebookStatusBarBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("StatusBarBoolean", state);
        editor.apply();
    }
    //This method will load statusbar boolean state
    public Boolean loadRulebookStatusBarBooleanState (){
        return RulebookSharedPreferences.getBoolean("StatusBarBoolean", true);
    }

    //This method will save AppPermissionsAreGranted boolean state
    public void setAppPermissionsAreGrantedBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("AppPermissionsAreGranted", state);
        editor.apply();
    }
    //This method will load AppPermissionsAreGranted boolean state
    public Boolean loadAppPermissionsAreGrantedBooleanState (){
        return RulebookSharedPreferences.getBoolean("AppPermissionsAreGranted", false);
    }
}

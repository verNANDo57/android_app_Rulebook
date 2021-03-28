package com.verNANDo57.rulebook_educational.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class RulebookApplicationSharedPreferences {
    SharedPreferences RulebookSharedPreferences;
    public RulebookApplicationSharedPreferences(Context context) {
        RulebookSharedPreferences = context.getSharedPreferences("rulebookprefs", Context.MODE_PRIVATE);
    }

    //This method will save animations_disable boolean state
    public void setRulebookAnimationsDisableState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("AnimationsDisable", state);
        editor.apply();
    }
    //This method will load animations_disableboolean state
    public Boolean loadRulebookAnimationsDisableState (){
        return RulebookSharedPreferences.getBoolean("AnimationsDisable", false);
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

    //This method will save locale state
    public void setRulebookLocaleState(String state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putString("RulebookLocale", state);
        editor.apply();
    }
    //This method will load locale state
    public String loadRulebookLocaleState (){
        return RulebookSharedPreferences.getString("RulebookLocale", "ru");
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

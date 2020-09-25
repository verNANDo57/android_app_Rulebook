package com.verNANDo57.rulebook_educational.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class RulebookApplicationSharedPreferences {
    SharedPreferences RulebookSharedPreferences;
    public RulebookApplicationSharedPreferences(Context context) {
        RulebookSharedPreferences = context.getSharedPreferences("rulebookprefs", Context.MODE_PRIVATE);
    }
    //This method will save voicesearch_disable boolean state
    public void setRulebookVoiceSearchDisableState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("VoiceSearchDisable", state);
        editor.apply();
    }
    //This method will load voicesearch_disable boolean state
    public Boolean loadRulebookVoiceSearchDisableState (){
        return RulebookSharedPreferences.getBoolean("VoiceSearchDisable", false);
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

    //This method will save status_page boolean state
    public void setRulebookStatusPageBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("StatusPageBoolean", state);
        editor.apply();
    }
    //This method will load status_page boolean state
    public Boolean loadRulebookStatusPageBooleanState (){
        return RulebookSharedPreferences.getBoolean("StatusPageBoolean", false);
    }

    //This method will save statusbar boolean state
    public void setRulebookStatusBarBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("StatusBarBoolean", state);
        editor.apply();
    }
    //This method will load statusbar boolean state
    public Boolean loadRulebookStatusBarBooleanState (){
        return RulebookSharedPreferences.getBoolean("StatusBarBoolean", false);
    }


    //This method will save bottomappbar_autohide boolean state
    public void setRulebookBottomAppBarAutoHideBooleanState(Boolean state){
        SharedPreferences.Editor editor= RulebookSharedPreferences.edit();
        editor.putBoolean("BottomAppBarAutoHide", state);
        editor.apply();
    }
    //This method will load bottomappbar_autohide boolean state
    public Boolean loadRulebookBottomAppBarAutoHideBooleanState (){
        return RulebookSharedPreferences.getBoolean("BottomAppBarAutoHide", true);
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
}

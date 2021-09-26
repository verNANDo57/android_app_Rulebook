package com.verNANDo57.rulebook_educational.rules;

import android.content.Context;
import android.content.SharedPreferences;

public class AppExtraBooleans {
    SharedPreferences RulebookBooleansInMainRules;

    public AppExtraBooleans(Context context) {
        RulebookBooleansInMainRules = context.getSharedPreferences("rulebookBooleansInMainRules", Context.MODE_PRIVATE);
    }

    //These methods will save boolean states
    public void setRulebookMainRulesFragmentOpenBoolean(String state){
        SharedPreferences.Editor editor= RulebookBooleansInMainRules.edit();
        editor.putString("MainRulesFragmentOpenedBoolean", state);
        editor.apply();
    }

    public void setAppBarPageSelected(String state){
        SharedPreferences.Editor editor= RulebookBooleansInMainRules.edit();
        editor.putString("AppBarPageSelected", state);
        editor.apply();
    }

    //These methods will load boolean states
    public String loadRulebookMainRulesFragmentOpenBoolean(){
        return RulebookBooleansInMainRules.getString("MainRulesFragmentOpenedBoolean", "null");
    }

    public String loadAppBarPageSelected (){
        return RulebookBooleansInMainRules.getString("AppBarPageSelected", "info_container");
    }
}

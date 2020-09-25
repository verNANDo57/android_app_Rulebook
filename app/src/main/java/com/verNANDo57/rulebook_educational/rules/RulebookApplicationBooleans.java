package com.verNANDo57.rulebook_educational.rules;

import android.content.Context;
import android.content.SharedPreferences;

public class RulebookApplicationBooleans {
    SharedPreferences RulebookBooleansInMainRules;

    public RulebookApplicationBooleans(Context context) {
        RulebookBooleansInMainRules = context.getSharedPreferences("rulebookBooleansInMainRules", Context.MODE_PRIVATE);
    }

    //This method will save boolean state
    public void setRulebookMainRulesFragmentOpenedBoolean(String state){
        SharedPreferences.Editor editor= RulebookBooleansInMainRules.edit();
        editor.putString("MainRulesFragmentOpenedBoolean", state);
        editor.apply();
    }
    //This method will load boolean state
    public String loadRulebookMainRulesFragmentOpenedBoolean (){
        return RulebookBooleansInMainRules.getString("MainRulesFragmentOpenedBoolean", "null");
    }

    /*
    //This method will save AppBarLayout_expanded boolean state
    public void setAppBarLayoutExpanded(Boolean state){
        SharedPreferences.Editor editor= RulebookBooleansInMainRules.edit();
        editor.putBoolean("AppBarLayout_expanded", state);
        editor.apply();
    }
    //This method will load AppBarLayout_expanded boolean state
    public Boolean loadAppBarLayoutExpanded (){
        return RulebookBooleansInMainRules.getBoolean("AppBarLayout_expanded", false);
    }
    */

    //This method will save boolean state
    public void setAppBarPageSelected(String state){
        SharedPreferences.Editor editor= RulebookBooleansInMainRules.edit();
        editor.putString("AppBarPageSelected", state);
        editor.apply();
    }
    //This method will load boolean state
    public String loadAppBarPageSelected (){
        return RulebookBooleansInMainRules.getString("AppBarPageSelected", "info_container");
    }
}

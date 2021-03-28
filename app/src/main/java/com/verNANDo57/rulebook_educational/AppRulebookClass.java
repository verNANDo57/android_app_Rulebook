package com.verNANDo57.rulebook_educational;

import android.app.Application;

import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.RulebookBooleans;

public class AppRulebookClass extends Application {

    RulebookApplicationSharedPreferences preferences;
    RulebookBooleans booleansInMainRules;

    private static AppRulebookClass rulebookClass = null;

    public static AppRulebookClass getInstance() {

        if(rulebookClass == null)
        {
            rulebookClass = new AppRulebookClass();
        }
        return rulebookClass;
    }
        public void onCreate() {

            //CustomThemeEngine.init
            CustomThemeEngine.init(this, getResources());

            //Load Preferences
            preferences =  new RulebookApplicationSharedPreferences(this);
            booleansInMainRules = new RulebookBooleans(this);

            //TODO: Crash fix
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("null");

            super.onCreate();

    }
}

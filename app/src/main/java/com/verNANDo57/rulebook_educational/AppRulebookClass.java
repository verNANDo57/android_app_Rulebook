package com.verNANDo57.rulebook_educational;

import android.app.Application;

import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.AppExtraBooleans;

public class AppRulebookClass extends Application {

    RulebookApplicationSharedPreferences preferences;
    AppExtraBooleans booleansInMainRules;

        public void onCreate() {
            //Initialize CustomThemeEngine
            CustomThemeEngine.init(this, getResources());

            //Load Preferences
            preferences =  new RulebookApplicationSharedPreferences(this);
            booleansInMainRules = new AppExtraBooleans(this);

            //Crash fix
            booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("null");
            super.onCreate();
    }
}

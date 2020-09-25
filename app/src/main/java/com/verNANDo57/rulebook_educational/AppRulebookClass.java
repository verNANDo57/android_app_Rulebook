package com.verNANDo57.rulebook_educational;

import android.app.Application;

import com.verNANDo57.rulebook_educational.customlocaleengine.CustomLocaleEngine;
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine;
import com.verNANDo57.rulebook_educational.rules.RulebookApplicationBooleans;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

import com.verNANDo57.rulebook_educational.customlocaleengine.store.PreferenceLocaleStore;
import java.util.Locale;

public class AppRulebookClass extends Application {

    RulebookApplicationSharedPreferences preferences;
    RulebookApplicationBooleans booleansInMainRules;

    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_ENGLISH_COUNTRY = "US";
    //public static final String LANGUAGE_UKRAINIAN = "uk";
    //public static final String LANGUAGE_UKRAINIAN_COUNTRY = "UA";
    public static final String LANGUAGE_RUSSIAN = "ru";
    public static final String LANGUAGE_RUSSIAN_COUNTRY = "RU";

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
            CustomLocaleEngine.init(this, new PreferenceLocaleStore(this, new Locale(LANGUAGE_RUSSIAN)));

            //Load Preferences
            preferences =  new RulebookApplicationSharedPreferences(this);
            booleansInMainRules = new RulebookApplicationBooleans(this);

            //TODO: Crash fix
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("null");

            super.onCreate();

    }
}

package com.verNANDo57.rulebook_educational;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

public class AppChooseYourDestiny extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;

    public void onCreate(Bundle savedInstanceState){
        preferences =  new RulebookApplicationSharedPreferences(this);

        super.onCreate(savedInstanceState);

        //Activity Content as LAYOUT
        setContentView(R.layout.app_choose_your_destiny);

        Toolbar toolbar = findViewById(R.id.toolbar_in_chooseyourdestiny_layout);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavBetweenActivitiesFragment BottomNavBetweenActivities = new BottomNavBetweenActivitiesFragment();
                BottomNavBetweenActivities.show(getSupportFragmentManager(), "TAG");
            }
        });

        ScrollView choose_destiny_scrollview = findViewById(R.id.choose_destiny_scrollview);

        Button app_main_rules = findViewById(R.id.main_rules);
        app_main_rules.setEnabled(true);
        //Antimation when activity starts------------------------------------------------
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            TranslateAnimation animate = new TranslateAnimation(
                    -250, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            app_main_rules.startAnimation(animate);
        }
        //End of Animation---------------------------------------------------------------
        app_main_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppMainRulesActivity = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity.class);
                startActivity(AppMainRulesActivity);
            }
        });

        Button app_lexicon_rules = findViewById(R.id.lexicon_rules);
        app_lexicon_rules.setEnabled(true);
        //Antimation when activity starts------------------------------------------------
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            TranslateAnimation animate = new TranslateAnimation(
                    250, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            app_lexicon_rules.startAnimation(animate);
        }
        //End of Animation---------------------------------------------------------------
        app_lexicon_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppLexiconRules = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.AppLexiconActivity.class);
                startActivity(AppLexiconRules);
            }
        });

        Button app_schemes_and_tables = findViewById(R.id.schemes_and_tables);
        app_schemes_and_tables.setEnabled(true);
        //Antimation when activity starts------------------------------------------------
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            TranslateAnimation animate = new TranslateAnimation(
                    -250, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            app_schemes_and_tables.startAnimation(animate);
        }
        //End of Animation---------------------------------------------------------------
        app_schemes_and_tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppRulesInSchemesAndTablesActivity = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity.class);
                startActivity(AppRulesInSchemesAndTablesActivity);
            }
        });

        Button app_analyze_methods = findViewById(R.id.analyze_methods);
        app_analyze_methods.setEnabled(true);
        //Antimation when activity starts------------------------------------------------
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            TranslateAnimation animate = new TranslateAnimation(
                    250, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            app_analyze_methods.startAnimation(animate);
        }
        //End of Animation---------------------------------------------------------------
        app_analyze_methods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppAnalyzeMethods = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.analyze_methods.AppAnalyzeMethods.class);
                startActivity(AppAnalyzeMethods);
            }
        });
    }

    //system navigationbar
    public boolean onKeyDown(int keyCode, KeyEvent event) {     switch (keyCode) {     case KeyEvent.KEYCODE_BACK:
        if (android.os.Build.VERSION.SDK_INT <android.os.Build.VERSION_CODES.ECLAIR     && event.getRepeatCount() == 0) {     onBackPressed();     }     }
        return super.onKeyDown(keyCode, event); }
    public void onBackPressed(){ finish();}

}

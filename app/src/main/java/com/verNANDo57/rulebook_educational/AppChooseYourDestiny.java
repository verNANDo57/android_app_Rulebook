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
import com.verNANDo57.rulebook_educational.usefulclasses.AppSomeUtils;

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
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            AppSomeUtils.setAnimatorToAnyView(app_main_rules, "to_left", (float) 250);
        }
        app_main_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppMainRulesActivity = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity.class);
                startActivity(AppMainRulesActivity);
            }
        });

        Button app_lexicon_rules = findViewById(R.id.lexicon_rules);
        app_lexicon_rules.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            AppSomeUtils.setAnimatorToAnyView(app_lexicon_rules, "to_right", (float) 250);
        }
        app_lexicon_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppLexiconRules = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.AppLexiconActivity.class);
                startActivity(AppLexiconRules);
            }
        });

        Button app_schemes_and_tables = findViewById(R.id.schemes_and_tables);
        app_schemes_and_tables.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            AppSomeUtils.setAnimatorToAnyView(app_schemes_and_tables, "to_left", (float) 250);
        }
        app_schemes_and_tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppRulesInSchemesAndTablesActivity = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity.class);
                startActivity(AppRulesInSchemesAndTablesActivity);
            }
        });

        Button app_analyze_methods = findViewById(R.id.analyze_methods);
        app_analyze_methods.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            AppSomeUtils.setAnimatorToAnyView(app_analyze_methods, "to_right", (float) 250);
        }
        app_analyze_methods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppAnalyzeMethods = new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.rules.analyze_methods.AppAnalyzeMethods.class);
                startActivity(AppAnalyzeMethods);
            }
        });
    }
}

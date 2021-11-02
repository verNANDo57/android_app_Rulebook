package com.verNANDo57.rulebook_educational;

import static com.verNANDo57.rulebook_educational.tools.Utils.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.AppLexiconActivity;
import com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity;
import com.verNANDo57.rulebook_educational.rules.analyze_methods.AppAnalyzeMethods;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity;
import com.verNANDo57.rulebook_educational.search.AppSearchActivity;
import com.verNANDo57.rulebook_educational.tools.Utils;

public class AppChooseYourDestiny extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;

    public void onCreate(Bundle savedInstanceState){
        preferences =  new RulebookApplicationSharedPreferences(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_choose_your_destiny);

        Toolbar toolbar = findViewById(R.id.toolbar_in_chooseyourdestiny_layout);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongActivitiesFragment BottomNavBetweenActivities = new BottomNavAmongActivitiesFragment();
                BottomNavBetweenActivities.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        Button app_main_rules = findViewById(R.id.main_rules);
        app_main_rules.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            Utils.setAnimatorToAnyView(app_main_rules, "to_left", (float) 250);
        }
        app_main_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppMainRulesActivity.class));
            }
        });

        Button app_lexicon_rules = findViewById(R.id.lexicon_rules);
        app_lexicon_rules.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            Utils.setAnimatorToAnyView(app_lexicon_rules, "to_right", (float) 250);
        }
        app_lexicon_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppLexiconActivity.class));
            }
        });

        Button app_schemes_and_tables = findViewById(R.id.schemes_and_tables);
        app_schemes_and_tables.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            Utils.setAnimatorToAnyView(app_schemes_and_tables, "to_left", (float) 250);
        }
        app_schemes_and_tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppRulesInSchemesAndTablesActivity.class));
            }
        });

        Button app_analyze_methods = findViewById(R.id.analyze_methods);
        app_analyze_methods.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            Utils.setAnimatorToAnyView(app_analyze_methods, "to_right", (float) 250);
        }
        app_analyze_methods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppAnalyzeMethods.class));
            }
        });

        Button search_function = findViewById(R.id.search_function);
        search_function.setEnabled(true);
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            Utils.setAnimatorToAnyView(search_function, "to_left", (float) 250);
        }
        search_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppSearchActivity.class));
            }
        });
    }
}

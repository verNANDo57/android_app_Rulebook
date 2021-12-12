package com.verNANDo57.rulebook_educational;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.AppAnalyzeMethods;
import com.verNANDo57.rulebook_educational.rules.AppLexiconActivity;
import com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity;

public class AppSectionSelectionActivity extends CustomThemeEngineAppCompatActivity {

    public void onCreate(Bundle savedInstanceState){

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
        app_main_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppMainRulesActivity.class));
            }
        });

        Button app_lexicon_rules = findViewById(R.id.lexicon_rules);
        app_lexicon_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppLexiconActivity.class));
            }
        });

        Button app_schemes_and_tables = findViewById(R.id.schemes_and_tables);
        app_schemes_and_tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppRulesInSchemesAndTablesActivity.class));
            }
        });

        Button app_analyze_methods = findViewById(R.id.analyze_methods);
        app_analyze_methods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AppAnalyzeMethods.class));
            }
        });
    }
}

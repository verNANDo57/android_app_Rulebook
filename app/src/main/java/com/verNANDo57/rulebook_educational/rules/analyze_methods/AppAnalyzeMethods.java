package com.verNANDo57.rulebook_educational.rules.analyze_methods;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavBetweenLessonsFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.RulebookApplicationBooleans;

@SuppressLint("InflateParams")
public class AppAnalyzeMethods extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;
    private RulebookApplicationBooleans booleansInAnalyzeMethods;

    private Intent scrollableactivity_in_analyzemethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        preferences = new RulebookApplicationSharedPreferences(this);
        booleansInAnalyzeMethods = new RulebookApplicationBooleans(this);

        scrollableactivity_in_analyzemethods = new Intent(this, AppAnalyzeMethodsScrollableActivity.class);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_analyze_methods);

        Toolbar toolbar = findViewById(R.id.toolbar_in_analyze_methods_layout);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavBetweenLessonsFragment BottomNavBetweenLessons = new BottomNavBetweenLessonsFragment();
                BottomNavBetweenLessons.show(getSupportFragmentManager(), "TAG");
            }
        });
    }

    public void phonetic_analyze_method_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("phonetic_analyze_method");
        startActivity(scrollableactivity_in_analyzemethods);
    }


    public void morphemic_analyze_method_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphemic_analyze_method");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_noun_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_noun");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_verb_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_verb");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_adjective_btn(View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_adjective");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_numeral_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_numeral");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_adverb_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_adverb");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_participle_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_participle");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_participle2_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_participle2");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_pretext_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_pretext");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_union_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_union");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void morphological_analyze_method_for_particle_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_particle");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void syntactic_analyze_method_for_simple_sentence_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("syntactic_analyze_method_for_simple_sentence");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void syntactic_analyze_method_for_difficult_sentence_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("syntactic_analyze_method_for_difficult_sentence");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void lexical_analyze_method_for_everyword_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("lexical_analyze_method_for_everyword");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    public void orthographic_analyze_method_for_everyword_btn (View v) {
        booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenedBoolean("orthographic_analyze_method_for_everyword");
        startActivity(scrollableactivity_in_analyzemethods);
    }

    //system navigationbar
    public boolean onKeyDown(int keyCode, KeyEvent event) {     switch (keyCode) {     case KeyEvent.KEYCODE_BACK:
        if (android.os.Build.VERSION.SDK_INT <android.os.Build.VERSION_CODES.ECLAIR     && event.getRepeatCount() == 0) {     onBackPressed();     }     }
        return super.onKeyDown(keyCode, event); }
    public void onBackPressed(){ finish();}
}

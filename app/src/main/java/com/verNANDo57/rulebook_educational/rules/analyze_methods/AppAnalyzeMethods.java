package com.verNANDo57.rulebook_educational.rules.analyze_methods;

import static com.verNANDo57.rulebook_educational.tools.Utils.LOG_TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.AppExtraBooleans;

@SuppressLint("InflateParams")
public class AppAnalyzeMethods extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;
    private AppExtraBooleans booleansInAnalyzeMethods;
    private Intent scrollableactivity_in_analyzemethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        preferences = new RulebookApplicationSharedPreferences(this);
        booleansInAnalyzeMethods = new AppExtraBooleans(this);

        scrollableactivity_in_analyzemethods = new Intent(this, AppAnalyzeMethodsScrollableActivity.class);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_analyze_methods);

        Toolbar toolbar = findViewById(R.id.toolbar_in_analyze_methods_layout);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongLessonsFragment BottomNavBetweenLessons = new BottomNavAmongLessonsFragment();
                BottomNavBetweenLessons.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        Button phonetic_analyze_method_btn = findViewById(R.id.phonetic_analyze_method_btn);
        phonetic_analyze_method_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("phonetic_analyze_method");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphemic_analyze_method_btn = findViewById(R.id.morphemic_analyze_method_btn);
        morphemic_analyze_method_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphemic_analyze_method");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_noun_btn = findViewById(R.id.morphological_analyze_method_for_noun_btn);
        morphological_analyze_method_for_noun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_noun");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_verb_btn = findViewById(R.id.morphological_analyze_method_for_verb_btn);
        morphological_analyze_method_for_verb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_verb");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_adjective_btn = findViewById(R.id.morphological_analyze_method_for_adjective_btn);
        morphological_analyze_method_for_adjective_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_adjective");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_numeral_btn = findViewById(R.id.morphological_analyze_method_for_numeral_btn);
        morphological_analyze_method_for_numeral_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_numeral");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_adverb_btn = findViewById(R.id.morphological_analyze_method_for_adverb_btn);
        morphological_analyze_method_for_adverb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_adverb");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_participle_btn = findViewById(R.id.morphological_analyze_method_for_participle_btn);
        morphological_analyze_method_for_participle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_participle");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_participle2_btn = findViewById(R.id.morphological_analyze_method_for_participle2_btn);
        morphological_analyze_method_for_participle2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_participle2");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_pretext_btn = findViewById(R.id.morphological_analyze_method_for_pretext_btn);
        morphological_analyze_method_for_pretext_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_pretext");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_union_btn = findViewById(R.id.morphological_analyze_method_for_union_btn);
        morphological_analyze_method_for_union_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_union");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button morphological_analyze_method_for_particle_btn = findViewById(R.id.morphological_analyze_method_for_particle_btn);
        morphological_analyze_method_for_particle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("morphological_analyze_method_for_particle");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button syntactic_analyze_method_for_simple_sentence_btn = findViewById(R.id.syntactic_analyze_method_for_simple_sentence_btn);
        syntactic_analyze_method_for_simple_sentence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("syntactic_analyze_method_for_simple_sentence");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button syntactic_analyze_method_for_difficult_sentence_btn = findViewById(R.id.syntactic_analyze_method_for_difficult_sentence_btn);
        syntactic_analyze_method_for_difficult_sentence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("syntactic_analyze_method_for_difficult_sentence");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button lexical_analyze_method_for_everyword_btn = findViewById(R.id.lexical_analyze_method_for_everyword_btn);
        lexical_analyze_method_for_everyword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("lexical_analyze_method_for_everyword");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });

        Button orthographic_analyze_method_for_everyword_btn = findViewById(R.id.orthographic_analyze_method_for_everyword_btn);
        orthographic_analyze_method_for_everyword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInAnalyzeMethods.setRulebookMainRulesFragmentOpenBoolean("orthographic_analyze_method_for_everyword");
                startActivity(scrollableactivity_in_analyzemethods);
            }
        });
    }
}

package com.verNANDo57.rulebook_educational.rules;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.utils.AppUtils;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;

public class AppAnalyzeMethods extends CustomThemeEngineAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent scrollableactivity = new Intent(this, AppBaseScrollableActivity.class);

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
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "phonetic_analyze_method");
                startActivity(scrollableactivity);
            }
        });

        Button morphemic_analyze_method_btn = findViewById(R.id.morphemic_analyze_method_btn);
        morphemic_analyze_method_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphemic_analyze_method");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_noun_btn = findViewById(R.id.morphological_analyze_method_for_noun_btn);
        morphological_analyze_method_for_noun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_noun");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_verb_btn = findViewById(R.id.morphological_analyze_method_for_verb_btn);
        morphological_analyze_method_for_verb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_verb");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_adjective_btn = findViewById(R.id.morphological_analyze_method_for_adjective_btn);
        morphological_analyze_method_for_adjective_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_adjective");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_numeral_btn = findViewById(R.id.morphological_analyze_method_for_numeral_btn);
        morphological_analyze_method_for_numeral_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_numeral");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_adverb_btn = findViewById(R.id.morphological_analyze_method_for_adverb_btn);
        morphological_analyze_method_for_adverb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_adverb");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_participle_btn = findViewById(R.id.morphological_analyze_method_for_participle_btn);
        morphological_analyze_method_for_participle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_participle");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_participle2_btn = findViewById(R.id.morphological_analyze_method_for_participle2_btn);
        morphological_analyze_method_for_participle2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_participle2");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_pretext_btn = findViewById(R.id.morphological_analyze_method_for_pretext_btn);
        morphological_analyze_method_for_pretext_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_pretext");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_union_btn = findViewById(R.id.morphological_analyze_method_for_union_btn);
        morphological_analyze_method_for_union_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_union");
                startActivity(scrollableactivity);
            }
        });

        Button morphological_analyze_method_for_particle_btn = findViewById(R.id.morphological_analyze_method_for_particle_btn);
        morphological_analyze_method_for_particle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "morphological_analyze_method_for_particle");
                startActivity(scrollableactivity);
            }
        });

        Button syntactic_analyze_method_for_simple_sentence_btn = findViewById(R.id.syntactic_analyze_method_for_simple_sentence_btn);
        syntactic_analyze_method_for_simple_sentence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "syntactic_analyze_method_for_simple_sentence");
                startActivity(scrollableactivity);
            }
        });

        Button syntactic_analyze_method_for_difficult_sentence_btn = findViewById(R.id.syntactic_analyze_method_for_difficult_sentence_btn);
        syntactic_analyze_method_for_difficult_sentence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "syntactic_analyze_method_for_difficult_sentence");
                startActivity(scrollableactivity);
            }
        });

        Button lexical_analyze_method_for_everyword_btn = findViewById(R.id.lexical_analyze_method_for_everyword_btn);
        lexical_analyze_method_for_everyword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "lexical_analyze_method_for_everyword");
                startActivity(scrollableactivity);
            }
        });

        Button orthographic_analyze_method_for_everyword_btn = findViewById(R.id.orthographic_analyze_method_for_everyword_btn);
        orthographic_analyze_method_for_everyword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, "orthographic_analyze_method_for_everyword");
                startActivity(scrollableactivity);
            }
        });
    }
}

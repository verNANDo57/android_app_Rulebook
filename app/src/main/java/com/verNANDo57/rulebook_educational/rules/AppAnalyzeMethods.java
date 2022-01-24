/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

public class AppAnalyzeMethods extends CustomThemeEngineAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent scrollable_activity = new Intent(this, AppBaseScrollableActivity.class);

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
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PHONETIC_ANALYZE_METHOD);
                startActivity(scrollable_activity);
            }
        });

        Button morphemic_analyze_method_btn = findViewById(R.id.morphemic_analyze_method_btn);
        morphemic_analyze_method_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHEMIC_ANALYZE_METHOD);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_noun_btn = findViewById(R.id.morphological_analyze_method_for_noun_btn);
        morphological_analyze_method_for_noun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NOUN);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_verb_btn = findViewById(R.id.morphological_analyze_method_for_verb_btn);
        morphological_analyze_method_for_verb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_VERB);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_adjective_btn = findViewById(R.id.morphological_analyze_method_for_adjective_btn);
        morphological_analyze_method_for_adjective_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADJECTIVE);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_numeral_btn = findViewById(R.id.morphological_analyze_method_for_numeral_btn);
        morphological_analyze_method_for_numeral_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NUMERAL);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_adverb_btn = findViewById(R.id.morphological_analyze_method_for_adverb_btn);
        morphological_analyze_method_for_adverb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADVERB);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_participle_btn = findViewById(R.id.morphological_analyze_method_for_participle_btn);
        morphological_analyze_method_for_participle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_participle2_btn = findViewById(R.id.morphological_analyze_method_for_participle2_btn);
        morphological_analyze_method_for_participle2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE2);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_pretext_btn = findViewById(R.id.morphological_analyze_method_for_pretext_btn);
        morphological_analyze_method_for_pretext_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PRETEXT);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_conjunctions_btn = findViewById(R.id.morphological_analyze_method_for_conjunctions_btn);
        morphological_analyze_method_for_conjunctions_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_CONJUNCTIONS);
                startActivity(scrollable_activity);
            }
        });

        Button morphological_analyze_method_for_particle_btn = findViewById(R.id.morphological_analyze_method_for_particle_btn);
        morphological_analyze_method_for_particle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICLE);
                startActivity(scrollable_activity);
            }
        });

        Button syntactic_analyze_method_for_simple_sentence_btn = findViewById(R.id.syntactic_analyze_method_for_simple_sentence_btn);
        syntactic_analyze_method_for_simple_sentence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.SYNTACTIC_ANALYZE_METHOD_FOR_SIMPLE_SENTENCE);
                startActivity(scrollable_activity);
            }
        });

        Button syntactic_analyze_method_for_difficult_sentence_btn = findViewById(R.id.syntactic_analyze_method_for_difficult_sentence_btn);
        syntactic_analyze_method_for_difficult_sentence_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.SYNTACTIC_ANALYZE_METHOD_FOR_DIFFICULT_SENTENCE);
                startActivity(scrollable_activity);
            }
        });

        Button lexical_analyze_method_btn = findViewById(R.id.lexical_analyze_method_btn);
        lexical_analyze_method_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.LEXICAL_ANALYZE_METHOD);
                startActivity(scrollable_activity);
            }
        });

        Button orthographic_analyze_method_btn = findViewById(R.id.orthographic_analyze_method_btn);
        orthographic_analyze_method_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHIC_ANALYZE_METHOD);
                startActivity(scrollable_activity);
            }
        });
    }
}

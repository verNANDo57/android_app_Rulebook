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
import com.verNANDo57.rulebook_educational.BottomNavAmongActivitiesFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

public class AppDictionaries extends CustomThemeEngineAppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_dictionaries);

        Toolbar toolbar = findViewById(R.id.toolbar_in_dictionaries);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongActivitiesFragment BottomNavBetweenActivities = new BottomNavAmongActivitiesFragment();
                BottomNavBetweenActivities.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        Intent scrollable_activity = new Intent(this, AppBaseScrollableActivity.class);

        Button vocabulary_words = findViewById(R.id.vocabulary_words);
        vocabulary_words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.DICT_VOCABULARY_WORDS);
                startActivity(scrollable_activity);
            }
        });

        Button phrasebook = findViewById(R.id.phrasebook);
        phrasebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.DICT_PHRASEBOOK);
                startActivity(scrollable_activity);
            }
        });

        Button orthoepical_dictionary = findViewById(R.id.orthoepical_dictionary);
        orthoepical_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollable_activity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.DICT_ORTHOEPICAL);
                startActivity(scrollable_activity);
            }
        });
    }
}

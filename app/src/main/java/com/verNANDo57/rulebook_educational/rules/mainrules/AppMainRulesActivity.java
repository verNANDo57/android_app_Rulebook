package com.verNANDo57.rulebook_educational.rules.mainrules;

import static com.verNANDo57.rulebook_educational.tools.Utils.LOG_TAG;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.mainrules.adapter.CustomPagerAdapter;


public class AppMainRulesActivity extends CustomThemeEngineAppCompatActivity
{

	RulebookApplicationSharedPreferences preferences;

	public void onCreate(Bundle savedInstanceState) {
		preferences = new RulebookApplicationSharedPreferences(this);

		super.onCreate(savedInstanceState);

		//Activity Content as LAYOUT
		setContentView(R.layout.app_rulebook_main_rules);

		Toolbar toolbar = findViewById(R.id.toolbar_in_mainrules_layout);
		setSupportActionBar(toolbar);
		toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
			@Override
			public void onClick(View v) {
				BottomNavAmongLessonsFragment BottomNavFragmentFromLessons = new BottomNavAmongLessonsFragment();
				BottomNavFragmentFromLessons.show(getSupportFragmentManager(), LOG_TAG);
			}
		});

		CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());

		ViewPager mViewPager = findViewById(R.id.viewpager);
		mViewPager.setAdapter(mCustomPagerAdapter);

		com.google.android.material.tabs.TabLayout tabLayout = findViewById(R.id.tablayout);

		mViewPager.addOnPageChangeListener(new com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		tabLayout.addOnTabSelectedListener(new com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
	}
}

/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules.mainrules;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.mainrules.adapter.CustomPagerAdapter;

public class AppMainRulesActivity extends CustomThemeEngineAppCompatActivity {

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

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

		ViewPager2 mViewPager = findViewById(R.id.viewpager);
		mViewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager(), getLifecycle()));

		TabLayout tabLayout = findViewById(R.id.tablayout);
		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				// TODO: Auto-generated method
				mViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				// TODO: Auto-generated method
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				// TODO: Auto-generated method
			}
		});

		mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
			@Override
			public void onPageSelected(int position) {
				tabLayout.selectTab(tabLayout.getTabAt(position));
			}
		});
	}
}

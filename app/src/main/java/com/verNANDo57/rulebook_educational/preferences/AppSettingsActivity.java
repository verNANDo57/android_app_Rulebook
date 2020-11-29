package com.verNANDo57.rulebook_educational.preferences;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;

public class AppSettingsActivity extends CustomThemeEngineAppCompatActivity {

	RulebookApplicationSharedPreferences preferences;

	@SuppressLint("ClickableViewAccessibility")
	protected void onCreate(Bundle savedInstanceState){

		preferences =  new RulebookApplicationSharedPreferences(this);

		super.onCreate(savedInstanceState);

		//Activity Content as FRAGMENT
		getSupportFragmentManager().beginTransaction()
				.replace(android.R.id.content, new AppSettingsFragment())
				.commit();
	}
}

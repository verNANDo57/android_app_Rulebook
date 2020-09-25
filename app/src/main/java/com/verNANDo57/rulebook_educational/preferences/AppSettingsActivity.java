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

	//system navigationbar using
	public boolean onKeyDown(int keyCode, KeyEvent event) {     switch (keyCode) {     case KeyEvent.KEYCODE_BACK:
		if (android.os.Build.VERSION.SDK_INT <android.os.Build.VERSION_CODES.ECLAIR     && event.getRepeatCount() == 0) {     onBackPressed();     }     }
		return super.onKeyDown(keyCode, event); }
	public void onBackPressed(){ super.onBackPressed(); }
	//end of navbar using
}

/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.preferences;

import android.os.Bundle;

import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;

public class AppSettingsActivity extends CustomThemeEngineAppCompatActivity {

	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);

		//Activity Content as FRAGMENT
		getSupportFragmentManager().beginTransaction()
				.replace(android.R.id.content, new AppSettingsFragment())
				.commit();
	}
}

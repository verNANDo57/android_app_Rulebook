package com.verNANDo57.rulebook_educational.preferences;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.verNANDo57.rulebook_educational.extradata.R;

public class AppSettingsFragment extends PreferenceFragmentCompat
{
	RulebookApplicationSharedPreferences preferences;

	public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
		preferences =  new RulebookApplicationSharedPreferences(requireContext());
		setPreferencesFromResource(R.xml.preferences, rootKey);

		//Interface
		androidx.preference.Preference darktheme_switch = findPreference(PreferenceKeys.DARK_THEME_PREF);
		assert darktheme_switch != null;
		darktheme_switch.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				// setup the alert builder
				AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
				builder.setTitle(getString(R.string.app_darktheme_switch_summary));
				// add a list
				String[] options = {
						getString(R.string.app_darktheme_mode_no),
						getString(R.string.app_darktheme_mode_yes),
						getString(R.string.app_darktheme_mode_followsystem),
						getString(R.string.app_darktheme_mode_battery)};

				int checkedItem = 0; // Dark mode: NO
				if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_YES) {
					checkedItem = 1; // Dark mode: YES
				} else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
					checkedItem = 2; // Dark mode: FOLLOW SYSTEM
				} else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY) {
					checkedItem = 3; // Dark mode: AUTO BATTERY
				}

				//Pass the array list in Alert dialog
				builder.setSingleChoiceItems(options, checkedItem, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
							case 0:
								// Dark mode: NO
								preferences.setRulebookDarkModeBooleanState(AppCompatDelegate.MODE_NIGHT_NO);
								AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
								break;
							case 1:
								// Dark mode: YES
								preferences.setRulebookDarkModeBooleanState(AppCompatDelegate.MODE_NIGHT_YES);
								AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
								break;
							case 2:
								// Dark mode: FOLLOW SYSTEM
								preferences.setRulebookDarkModeBooleanState(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
								AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
								break;
							case 3:
								// Dark mode: AUTO BATTERY
								preferences.setRulebookDarkModeBooleanState(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
								AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
								break;
						}
					}
				});
				builder.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						dialogInterface.dismiss();
					}
				});
				builder.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.app_themeengine_icon));
				builder.create();
				builder.show();
				return true;
			}
		});

		androidx.preference.SwitchPreferenceCompat statusbar_enable = (SwitchPreferenceCompat) findPreference(PreferenceKeys.STATUSBAR_PREF);
		assert statusbar_enable != null;
		statusbar_enable.setChecked(preferences.loadRulebookStatusBarBooleanState());
		statusbar_enable.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				if (newValue.toString().equals("true")){
					preferences.setRulebookStatusBarBooleanState(true);
				} else {
					preferences.setRulebookStatusBarBooleanState(false);
				}
				return true;
			}
		});

		androidx.preference.Preference noticePreference = findPreference(PreferenceKeys.NOTICE_PREF);
	}
}

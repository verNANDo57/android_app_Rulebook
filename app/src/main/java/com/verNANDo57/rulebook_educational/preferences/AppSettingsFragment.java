package com.verNANDo57.rulebook_educational.preferences;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.verNANDo57.rulebook_educational.customthemeengine.prefs.CustomThemeEngineSettingsActivity;
import com.verNANDo57.rulebook_educational.extradata.R;


public class AppSettingsFragment extends PreferenceFragmentCompat
{
	RulebookApplicationSharedPreferences preferences;

	public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
		preferences =  new RulebookApplicationSharedPreferences(getContext());
		setPreferencesFromResource(R.xml.preferences, rootKey);

		//Interface
		androidx.preference.Preference appThemes = findPreference("appThemes");
		assert appThemes != null;
		appThemes.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				startActivity(new Intent(getActivity(), CustomThemeEngineSettingsActivity.class));
				return false;
			}
		});

		androidx.preference.SwitchPreferenceCompat statusbar_enable = (SwitchPreferenceCompat) findPreference("statusbar_enable");
		assert statusbar_enable != null;
		if(preferences.loadRulebookStatusBarBooleanState()==false){
			statusbar_enable.setChecked(false);
		} else if (preferences.loadRulebookStatusBarBooleanState()==true){
			statusbar_enable.setChecked(true);
		} else {
			statusbar_enable.setChecked(false);
		}
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

		androidx.preference.Preference rebootFromPrefs = findPreference("app_reboot_from_prefs");
	}
}

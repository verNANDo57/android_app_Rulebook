package com.verNANDo57.rulebook_educational.preferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.verNANDo57.rulebook_educational.SplashScreenActivity;
import com.verNANDo57.rulebook_educational.customthemeengine.prefs.CustomThemeEngineSettingsActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;


public class AppSettingsFragment extends PreferenceFragmentCompat
{
	RulebookApplicationSharedPreferences preferences;

	public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
		preferences =  new RulebookApplicationSharedPreferences(getContext());
		setPreferencesFromResource(R.xml.preferences, rootKey);

		//Interface
		androidx.preference.Preference OtherThemes = findPreference("other_themes");
		OtherThemes.setEnabled(true);
		OtherThemes.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				Intent toCustomThemes = new Intent(getActivity(), CustomThemeEngineSettingsActivity.class);
				startActivity(toCustomThemes);
				return false;
			}
		});

		androidx.preference.SwitchPreferenceCompat animations_disable = (SwitchPreferenceCompat) findPreference("animations_disable");
		animations_disable.setEnabled(true);
		if(preferences.loadRulebookAnimationsDisableState()==false){
			animations_disable.setChecked(false);
		} else if (preferences.loadRulebookAnimationsDisableState()==true){
			animations_disable.setChecked(true);
		} else {
			animations_disable.setChecked(false);
		}
		animations_disable.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				if (newValue.toString().equals("true")){
					preferences.setRulebookAnimationsDisableState(true);
				} else {
					preferences.setRulebookAnimationsDisableState(false);
				}
				return true;
			}
		});

		androidx.preference.SwitchPreferenceCompat statusbar_enable = (SwitchPreferenceCompat) findPreference("statusbar_enable");
		statusbar_enable.setEnabled(true);
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

		//reboot option
		androidx.preference.Preference RebootFromPrefs = findPreference("app_reboot_from_prefs");
		RebootFromPrefs.setEnabled(true);
		RebootFromPrefs.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				restartRulebook();
				return false;
			}
		});
	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
	public void restartRulebook(){
		getActivity().finishAffinity();
		Intent restartRulebook = new Intent(getContext(), SplashScreenActivity.class);
		startActivity(restartRulebook);
	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
	public void restartRulebookAlternative(){
		getActivity().finishAffinity();
		Intent restartRulebook = new Intent(getContext(), SplashScreenActivity.class);
		restartRulebook.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK & Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(restartRulebook);
	}
}

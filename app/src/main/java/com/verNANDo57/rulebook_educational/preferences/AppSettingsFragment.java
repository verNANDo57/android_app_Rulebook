/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.preferences;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.Constants;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.io.File;

public class AppSettingsFragment extends PreferenceFragmentCompat
{
	private RulebookApplicationSharedPreferences preferences;

	public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
		preferences =  new RulebookApplicationSharedPreferences(requireContext());
		setPreferencesFromResource(R.xml.preferences, rootKey);

		// Interface
		androidx.preference.Preference darktheme_switch_pref = findPreference(PreferenceKeys.DARK_THEME_PREF);
		assert darktheme_switch_pref != null;
		darktheme_switch_pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(@NonNull Preference preference) {
				// setup the alert builder
				AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
				builder.setTitle(getString(R.string.app_darkTheme_switch_summary));

				int checkedItem = 0; // Dark mode: NO
				if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_YES) {
					checkedItem = 1; // Dark mode: YES
				} else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
					checkedItem = 2; // Dark mode: FOLLOW SYSTEM
				} else if (preferences.loadRulebookDarkModeBooleanState() == AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY) {
					checkedItem = 3; // Dark mode: AUTO BATTERY
				}

				//Pass the array list in Alert dialog
				builder.setSingleChoiceItems(getResources().getStringArray(R.array.darkmode_modes), checkedItem, new DialogInterface.OnClickListener() {
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
				return false;
			}
		});

		androidx.preference.SwitchPreferenceCompat statusbar_enable_pref = findPreference(PreferenceKeys.STATUSBAR_PREF);
		assert statusbar_enable_pref != null;
		statusbar_enable_pref.setChecked(preferences.loadRulebookStatusBarBooleanState());
		statusbar_enable_pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
				preferences.setRulebookStatusBarBooleanState(newValue.toString().equals("true"));
				return false;
			}
		});

		// Functionality
		androidx.preference.SwitchPreferenceCompat use_sdcard_pref = findPreference(PreferenceKeys.USE_SDCARD_PREF);
		assert use_sdcard_pref != null;
		if (!AppUtils.checkIfSDCardExists()) {
			use_sdcard_pref.setEnabled(false);
			preferences.setRulebookUseSDCardBooleanState(false);
		}
		use_sdcard_pref.setChecked(preferences.loadRulebookUseSDCardBooleanState());
		use_sdcard_pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			@Override
			public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
				preferences.setRulebookUseSDCardBooleanState(newValue.toString().equals("true"));
				return false;
			}
		});

		androidx.preference.Preference delete_all_data = findPreference(PreferenceKeys.DELETE_ALL_DATA);
		assert delete_all_data != null;
		delete_all_data.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(@NonNull Preference preference) {
				androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(requireContext());
				builder.setTitle(getString(R.string.app_warning));
				builder.setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.app_delete_forever));
				builder.setMessage(getString(R.string.are_you_sure));
				builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						AppUtils.removeFolderRecursive(new File(AppUtils.getStorageAbsolutePath(requireContext(), false) + Constants.RULEBOOK_APP_DIRECTORY));
						if (AppUtils.checkIfSDCardExists()) {
							AppUtils.removeFolderRecursive(new File(AppUtils.getStorageAbsolutePath(requireContext(), true) + Constants.RULEBOOK_APP_DIRECTORY));
						}
					}
				});
				builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				androidx.appcompat.app.AlertDialog alert = builder.create();
				alert.show();
				return false;
			}
		});
	}
}

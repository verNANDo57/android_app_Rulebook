package com.verNANDo57.rulebook_educational;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.core.content.ContextCompat;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.dictionaries.AppDictionaries;
import com.verNANDo57.rulebook_educational.tools.PermissionsCheck;
import com.verNANDo57.rulebook_educational.tools.Utils;

public class MainActivity extends CustomThemeEngineAppCompatActivity
{
	RulebookApplicationSharedPreferences preferences;

	@SuppressLint("ClickableViewAccessibility")
	public void onCreate(Bundle savedInstanceState) {
		preferences = new RulebookApplicationSharedPreferences(this);

		super.onCreate(savedInstanceState);

		//Activity Content as LAYOUT
		setContentView(R.layout.main);

		ImageView main_image = findViewById(R.id.imageview_in_main);
		main_image.setColorFilter(R.color.coloraccent, PorterDuff.Mode.SRC_IN);

		ScrollView main_layout_scrollview = findViewById(R.id.main_layout_scrollview);

		Button app_rules_button = findViewById(R.id.app_rules_button);
		if(preferences.loadRulebookAnimationsDisableState()==false) {
			Utils.setAnimatorToAnyView(app_rules_button, "to_left", (float) 250);
		}
		app_rules_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppChooseYourDestiny.class));
			}
		});

		Button app_dictionaries = findViewById(R.id.app_dictionaries);
		if(preferences.loadRulebookAnimationsDisableState()==false) {
			Utils.setAnimatorToAnyView(app_dictionaries, "to_right", (float) 250);
		}
		app_dictionaries.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppDictionaries.class));
			}
		});

		Button settings_button = findViewById(R.id.settings_button);
		if(preferences.loadRulebookAnimationsDisableState()==false) {
			Utils.setAnimatorToAnyView(settings_button, "to_left", (float) 250);
		}
		settings_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), com.verNANDo57.rulebook_educational.preferences.AppSettingsActivity.class));
			}
		});

		Button about_app_button = findViewById(R.id.about_app_button);
		if(preferences.loadRulebookAnimationsDisableState()==false) {
			Utils.setAnimatorToAnyView(about_app_button, "to_right", (float) 250);
		}
		about_app_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppAboutApplicationActivity.class));
			}
		});

		Button app_exit_button = findViewById(R.id.app_exit_button);
		if(preferences.loadRulebookAnimationsDisableState()==false) {
			Utils.setAnimatorToAnyView(app_exit_button, "to_left", (float) 250);
		}
		app_exit_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				app_exit();
			}
		});

		//Check if needed permissions are granted (only if user use Android M or newer
		if (Build.VERSION.SDK_INT >= 23) {
			final Intent checkPermissions = new Intent(this, com.verNANDo57.rulebook_educational.tools.PermissionsCheck.class);
			checkPermissions.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(checkPermissions);
		}
	}

	@Override
	public void onBackPressed(){
		finishAffinity();
	}

	public void app_exit() {
		androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.app_exit));
		builder.setIcon(R.drawable.ic_warning_outline);
		builder.setMessage(getString(R.string.are_you_sure));
		builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finishAffinity();
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
	}
}

package com.verNANDo57.rulebook_educational;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.bookmarks.AppBookmarksActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.AppSettingsActivity;
import com.verNANDo57.rulebook_educational.rules.AppDictionaries;
import com.verNANDo57.rulebook_educational.search.AppSearchActivity;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.util.Arrays;

public class MainActivity extends CustomThemeEngineAppCompatActivity {

	public static final int STORAGE_PERMISSION_CODE = 1;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		ImageView main_image = findViewById(R.id.imageview_in_main);
		main_image.setColorFilter(R.color.colorAccent, PorterDuff.Mode.SRC_IN);

		Button app_rules_button = findViewById(R.id.app_rules_button);
		app_rules_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppSectionSelectionActivity.class));
			}
		});

		Button app_dictionaries = findViewById(R.id.app_dictionaries);
		app_dictionaries.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppDictionaries.class));
			}
		});

		Button bookmarks_button = findViewById(R.id.app_bookmarks);
		bookmarks_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppBookmarksActivity.class));
			}
		});

		Button search_function = findViewById(R.id.search_function);
		search_function.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppSearchActivity.class));
			}
		});

		Button settings_button = findViewById(R.id.settings_button);
		settings_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppSettingsActivity.class));
			}
		});

		Button about_app_button = findViewById(R.id.about_app_button);
		about_app_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), AppAboutApplicationActivity.class));
			}
		});

		Button app_exit_button = findViewById(R.id.app_exit_button);
		app_exit_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				app_exit();
			}
		});

		//Check for storage permission
		checkPermission();
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

	/*
  		These permissions are required:
        android.permission.WRITE_EXTERNAL_STORAGE,
        android.permission.READ_EXTERNAL_STORAGE,
        android.permission.MANAGE_EXTERNAL_STORAGE
	*/
	public void checkPermission() {
		//Check if android version is Android 11 or higher
		if (Build.VERSION.SDK_INT >= 30) {
			//Check if storage permission already granted
			if (!Environment.isExternalStorageManager()) {
				//Ask user to give storage permission
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle(getString(R.string.app_warning));
				builder.setMessage(getString(R.string.app_storageaccess_warning));
				builder.setIcon(R.drawable.ic_warning_outline);
				builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//GoToSettings Intent
						startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
					}
				});
				builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//Close dialog
						dialog.cancel();
					}
				});
				AlertDialog alert = builder.create();
				alert.show();
			}
		//Otherwise...
			//Check if android version is Android 10 or lower
		} else if (Build.VERSION.SDK_INT >= 23) {
			//Check if storage permission already granted
			if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				//Ask user to give storage permission
				if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
					createShouldShowRequestPermissionRationaleAlertDialogCompat();
				} else {
					requestPermissions(new String[]
									{
											Manifest.permission.WRITE_EXTERNAL_STORAGE,
											Manifest.permission.READ_EXTERNAL_STORAGE
									},
							STORAGE_PERMISSION_CODE);
				}
			}
		}
	}

	public void createShouldShowRequestPermissionRationaleAlertDialogCompat(){
		androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.app_warning));
		builder.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_warning_outline));
		builder.setMessage(getString(R.string.app_reason_why_these_permissions_are_needed));
		builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Re-request permissions
				checkPermission();
			}
		});
		builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		androidx.appcompat.app.AlertDialog alert = builder.create();
		alert.setCancelable(false);
		alert.setCanceledOnTouchOutside(false);
		alert.show();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == STORAGE_PERMISSION_CODE) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				Log.w(AppUtils.LOG_TAG, Arrays.toString(permissions) + " - " + getString(R.string.app_granted));
			} else {
				Log.w(AppUtils.LOG_TAG, Arrays.toString(permissions) + " - " + getString(R.string.app_denied));
			}
		}
	}
}

/*
  This app uses these permissions to save user needed rules as txt files:
        android.permission.WRITE_EXTERNAL_STORAGE,
        android.permission.READ_EXTERNAL_STORAGE,
        android.permission.MANAGE_EXTERNAL_STORAGE
 */

package com.verNANDo57.rulebook_educational;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.tools.Utils;

import java.util.Arrays;

public class SplashScreenActivity extends CustomThemeEngineAppCompatActivity {
	private static RulebookApplicationSharedPreferences preferences;

	public static final int THREAD_SLEEP_TIME_MILLISECONDS = 1000;

	public static final int STORAGE_PERMISSION_CODE = 1;

	public static final int PERMISSION_GRANTED = 0;
	public static final int PERMISSION_DENIED = -1;

	private ProgressBar Indicator1;
	private ProgressBar Indicator2;
	private ProgressBar Indicator3;

	private final int totalProgressTime = 10;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		preferences = new RulebookApplicationSharedPreferences(this);

		setContentView(R.layout.app_splashscreen);

		int BackgroundTintColor = ColorUtils.lighter(getResources().getColor(R.color.coloraccent), 0.01f);

		ImageView splashscreen_image = findViewById(R.id.splashscreen_image);

		Indicator1 = findViewById(R.id.appSplashScreenProgressBar1); //Indicator1(ProgressBar1)
		Indicator2 = findViewById(R.id.appSplashScreenProgressBar2); //Indicator2(ProgressBar2)
		Indicator3 = findViewById(R.id.appSplashScreenProgressBar3); //Indicator3(ProgressBar3)

		Indicator1.setIndeterminateTintList(ColorStateList.valueOf(BackgroundTintColor));
		Indicator2.setIndeterminateTintList(ColorStateList.valueOf(BackgroundTintColor));
		Indicator3.setIndeterminateTintList(ColorStateList.valueOf(BackgroundTintColor));

		Indicator1.setProgress(0); //Progress of Indicator1(ProgressBar1) at startup
		Indicator2.setProgress(0); //Progress of Indicator2(ProgressBar2) at startup
		Indicator3.setProgress(0); //Progress of Indicator3(ProgressBar3) at startup

		Indicator1.setMax(totalProgressTime);
		Indicator2.setMax(totalProgressTime);
		Indicator3.setMax(totalProgressTime);

		//splashscreen process start
		new Thread(new Runnable() {
			public void run() {
				//Can't create handler inside thread Thread that has not called Looper.prepare()
				Looper.prepare();

				int counter = 0;
				while (counter < totalProgressTime) {
					try {
						Thread.sleep(50);
						counter++;
						Indicator1.setProgress(counter);
						Indicator2.setProgress(counter);
						Indicator3.setProgress(counter);
					} catch (InterruptedException e) {
						Log.e(Utils.LOG_TAG, getString(R.string.app_error_occured));
						e.printStackTrace();
					}
				}
				checkPermission();
			}
		}).start();
	}

	public void checkPermission() {
		if (Build.VERSION.SDK_INT >= 30) {
			if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				preferences.setAppPermissionsAreGrantedBooleanState(false);

				if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
					createShouldShowRequestPermissionRationaleAlertDialogCompat();
				} else {
					requestPermissions(new String[]
									{
											Manifest.permission.MANAGE_EXTERNAL_STORAGE,
											Manifest.permission.WRITE_EXTERNAL_STORAGE,
											Manifest.permission.READ_EXTERNAL_STORAGE
									},
							STORAGE_PERMISSION_CODE);
				}
			} else {
				preferences.setAppPermissionsAreGrantedBooleanState(true);
				finishSplashScreenActivity();
			}
		} else if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 29) {
			if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				preferences.setAppPermissionsAreGrantedBooleanState(false);

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
			} else {
				preferences.setAppPermissionsAreGrantedBooleanState(true);
				finishSplashScreenActivity();
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
				//Re-request needed permissions
				checkPermission();
			}
		});
		builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				finishSplashScreenActivity();
			}
		});
		androidx.appcompat.app.AlertDialog alert = builder.create();
		alert.setCancelable(false);
		alert.setCanceledOnTouchOutside(false);
		alert.show();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (requestCode == STORAGE_PERMISSION_CODE) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				preferences.setAppPermissionsAreGrantedBooleanState(true);
				Log.w(Utils.LOG_TAG, Arrays.toString(permissions) + " - " + getString(R.string.app_granted));
				finishSplashScreenActivity();
			} else {
				preferences.setAppPermissionsAreGrantedBooleanState(false);
				Log.w(Utils.LOG_TAG, Arrays.toString(permissions) + " - " + getString(R.string.app_denied));
				finishSplashScreenActivity();
			}
		}
	}

	private void finishSplashScreenActivity(){
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

	@Override
	public void onResume() {
		super.onResume();
	}
}

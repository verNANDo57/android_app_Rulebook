/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.utils.AppUtils;
import com.verNANDo57.rulebook_educational.utils.ColorUtils;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends CustomThemeEngineAppCompatActivity {

	private ProgressBar Indicator1;
	private ProgressBar Indicator2;
	private ProgressBar Indicator3;

	private final int totalProgressTime = 10;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.app_splashscreen);

		int BackgroundTintColor = ColorUtils.lighter(getResources().getColor(R.color.colorAccent), 0.01f);

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
				//Can't create handler inside thread that has not called Looper.prepare()
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
						Log.e(AppUtils.LOG_TAG, getString(R.string.app_error_occurred));
						e.printStackTrace();
					}
				}
				finishSplashScreenActivity();
			}
		}).start();
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

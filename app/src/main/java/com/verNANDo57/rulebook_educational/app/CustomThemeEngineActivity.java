/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

import org.jetbrains.annotations.Nullable;

/**
 * Base class for an android.app.Activity.
 */
public abstract class CustomThemeEngineActivity extends Activity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        RulebookApplicationSharedPreferences preferences = new RulebookApplicationSharedPreferences(this);

        if (preferences.loadRulebookStatusBarBooleanState()) {
            // Show Status Bar.
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        } else if (!preferences.loadRulebookStatusBarBooleanState()) {
            // Hide Status Bar
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        // Set StatusBar color
        this.getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.app_statusbar_color));

        // Set NavigationBar color
        this.getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.app_navbar_color));

        // Set ActionBar color and icon [Only for devices with android 8 or lower]
        Bitmap RB = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_round);
        setTaskDescription(new ActivityManager.TaskDescription(getString(R.string.app_name), RB, ContextCompat.getColor(this, R.color.colorAccent)));

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode == 4) {
            this.onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}

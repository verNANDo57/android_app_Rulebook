package com.verNANDo57.rulebook_educational.customthemeengine.app

import android.app.Activity
import android.app.ActivityManager.TaskDescription
import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngineResources
import com.verNANDo57.rulebook_educational.customthemeengine.delegate.CustomThemeEngineDelegate
import com.verNANDo57.rulebook_educational.extradata.R
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences

/**
 * Base class for an [Activity] that uses [CustomThemeEngine] for dynamic themes.
 *
 * You must implement [BaseCustomThemeEngineActivity.getThemeResId] and return a valid customthemeengine theme.
 */
abstract class CustomThemeEngineActivity : Activity(), BaseCustomThemeEngineActivity {

  var preferences: RulebookApplicationSharedPreferences? = null

  private val delegate: CustomThemeEngineDelegate by lazy {
    CustomThemeEngineDelegate.create(this, customThemeEngine, getThemeResId())
  }

  private val resources: CustomThemeEngineResources by lazy {
    CustomThemeEngineResources(super.getResources(), customThemeEngine)
  }

  override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(delegate.wrap(newBase))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    preferences = RulebookApplicationSharedPreferences(this)

    if (preferences!!.loadRulebookStatusBarBooleanState() == true) {
      if (Build.VERSION.SDK_INT < 16) {
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        if (Build.VERSION.SDK_INT >= 21) {
          this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
        }
      } else {
        val decorView = window.decorView
        // Show Status Bar.
        val uiOptions = View.SYSTEM_UI_FLAG_VISIBLE
        decorView.systemUiVisibility = uiOptions
        if (Build.VERSION.SDK_INT >= 21) {
          this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
        }
      }
    } else if (preferences!!.loadRulebookStatusBarBooleanState() == false) {
      // Hide Status Bar
      this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN)
      if (Build.VERSION.SDK_INT >= 21) {
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
      } else {
        // Hide Status Bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        if (Build.VERSION.SDK_INT >= 21) {
          this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
        }
      }
    }

    //NavigationBarColor
    if (Build.VERSION.SDK_INT >= 21) {
      //If Build.VERSION.SDK_INT >= 21, set navbar color (declared by customthemeengine)
      window.navigationBarColor = ContextCompat.getColor(this, R.color.navbar_color)
    } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 20) {
      //but if Build.VERSION.SDK_INT >= 16 and Build.VERSION.SDK_INT <=20, set navbar color value to transparent
      var visibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
      visibility = visibility or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
      window.decorView.systemUiVisibility = visibility
    }

    //ActionBar color and icon in RECENTS
    val RB = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_round)
    val taskDesc: TaskDescription
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      taskDesc = TaskDescription(getString(R.string.app_name), RB, ContextCompat.getColor(this, R.color.coloraccent))
      setTaskDescription(taskDesc)
    }

    delegate.onCreate(savedInstanceState)
    super.onCreate(savedInstanceState)
  }

  //Catch "back" button press
  override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      onBackPressed()
    }
    return super.onKeyDown(keyCode, event)
  }

  override fun onBackPressed() {
    finish()
  }

  override fun onPostCreate(savedInstanceState: Bundle?) {
    super.onPostCreate(savedInstanceState)
    delegate.onPostCreate(savedInstanceState)
  }

  override fun onStart() {
    super.onStart()
    delegate.onStart()
  }

  override fun onResume() {
    super.onResume()
    delegate.onResume()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    return super.onCreateOptionsMenu(menu)
  }

  override fun getResources(): Resources = resources
}

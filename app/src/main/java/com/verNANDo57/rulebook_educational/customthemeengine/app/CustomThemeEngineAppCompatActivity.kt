package com.verNANDo57.rulebook_educational.customthemeengine.app

import android.app.ActivityManager.TaskDescription
import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngineResources
import com.verNANDo57.rulebook_educational.customthemeengine.delegate.CustomThemeEngineDelegate
import com.verNANDo57.rulebook_educational.extradata.R
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences

/**
 * Base class for an [AppCompatActivity] that uses [CustomThemeEngine] for dynamic themes.
 *
 * You must implement [BaseCustomThemeEngineActivity.getThemeResId] and return a valid customthemeengine theme.
 */
abstract class CustomThemeEngineAppCompatActivity : AppCompatActivity(), BaseCustomThemeEngineActivity {

  var preferences: RulebookApplicationSharedPreferences? = null

  private val delegate: CustomThemeEngineDelegate by lazy {
    CustomThemeEngineDelegate.create(this, customThemeEngine, getThemeResId())
  }

  private val resources: CustomThemeEngineResources by lazy {
    CustomThemeEngineResources(super.getResources(), customThemeEngine)
  }

  @Override
  override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(delegate.wrap(newBase))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    preferences = RulebookApplicationSharedPreferences(this)

    if (preferences!!.loadRulebookStatusBarBooleanState() == true) {
      val decorView = window.decorView
      // Show Status Bar.
      val uiOptions = View.SYSTEM_UI_FLAG_VISIBLE
      decorView.systemUiVisibility = uiOptions
      this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
    } else if (preferences!!.loadRulebookStatusBarBooleanState() == false) {
      // Hide Status Bar
      this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
      this.window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
    }

    //NavigationBarColor
    window.navigationBarColor = ContextCompat.getColor(this, R.color.navbar_color)

    //ActionBar color and icon in RECENTS
    val RB = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_round)
    val taskDesc: TaskDescription
    taskDesc = TaskDescription(getString(R.string.app_name), RB, ContextCompat.getColor(this, R.color.coloraccent))
    setTaskDescription(taskDesc)

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

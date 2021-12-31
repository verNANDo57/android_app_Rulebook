package com.verNANDo57.rulebook_educational.app

import android.app.ActivityManager.TaskDescription
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.verNANDo57.rulebook_educational.extradata.R
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences

/**
 * Base class for a [FragmentActivity].
 */
abstract class CustomThemeEngineFragmentActivity : FragmentActivity() {

  var preferences: RulebookApplicationSharedPreferences? = null

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
    val RB = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_round)
    val taskDesc = TaskDescription(getString(R.string.app_name), RB, ContextCompat.getColor(this, R.color.colorAccent))
    setTaskDescription(taskDesc)

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

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    return super.onCreateOptionsMenu(menu)
  }
}

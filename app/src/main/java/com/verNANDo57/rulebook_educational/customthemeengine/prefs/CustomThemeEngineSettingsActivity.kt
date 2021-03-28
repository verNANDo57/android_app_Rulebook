package com.verNANDo57.rulebook_educational.customthemeengine.prefs

import android.os.Bundle
import android.view.MenuItem
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity

/**
 * Activity to show CustomThemeEngine preferences allowing the user to modify the primary, accent and background color of the app.
 */
open class CustomThemeEngineSettingsActivity : CustomThemeEngineAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    supportActionBar?.setDisplayHomeAsUpEnabled(false)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
          .add(android.R.id.content, CustomThemeEngineSettingsFragment.newInstance())
          .commit()
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
    android.R.id.home -> {
      finish()
      true
    }
    else -> super.onOptionsItemSelected(item)
  }
}

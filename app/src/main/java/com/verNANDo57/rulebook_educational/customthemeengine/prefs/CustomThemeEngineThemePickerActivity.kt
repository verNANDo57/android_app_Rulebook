package com.verNANDo57.rulebook_educational.customthemeengine.prefs

import android.os.Bundle
import android.view.MenuItem
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity

/**
 * Activity to display a theme picker with pre-created themes.
 *
 * The themes will be read from assets/themes/custom_themes.json
 */
class CustomThemeEngineThemePickerActivity : CustomThemeEngineAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    supportActionBar?.setDisplayHomeAsUpEnabled(false)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
          .add(android.R.id.content, CustomThemeEngineThemePickerFragment.newInstance())
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

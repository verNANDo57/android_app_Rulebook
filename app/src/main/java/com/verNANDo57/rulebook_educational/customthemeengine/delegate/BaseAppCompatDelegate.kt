package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

interface BaseAppCompatDelegate {

  fun getSupportActionBar(): ActionBar?
  fun setSupportActionBar(toolbar: Toolbar?)
  fun getDelegate(): AppCompatDelegate
}

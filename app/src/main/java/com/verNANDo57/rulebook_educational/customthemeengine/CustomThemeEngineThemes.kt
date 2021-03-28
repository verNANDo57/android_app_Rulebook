package com.verNANDo57.rulebook_educational.customthemeengine

import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme.DARK
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme.LIGHT
import com.verNANDo57.rulebook_educational.for_pills.R

/**
 * Theme that can be used in your customthemeengine based activity.
 *
 * If using your own Toolbar via [AppCompatActivity.setSupportActionBar] use the following theme:
 *
 * ```kotlin
 * override fun getThemeResId(): Int = customthemeengine.themes.actionBarTheme
 * ```
 *
 * If using the default ActionBar use the following theme:
 *
 * ```kotlin
 * override fun getThemeResId(): Int = customthemeengine.themes.noActionBarTheme
 * ```
 */
class CustomThemeEngineThemes internal constructor(private val customThemeEngine: CustomThemeEngine) {

  /**
   * Get a ActionBar theme.
   *
   * @return One of the following themes:
   * [R.style.AppThemeRulebookLight],
   * [R.style.AppThemeRulebookDark],
   */
  @get:StyleRes
  val actionBarTheme: Int
    get() = when (customThemeEngine.baseTheme) {
      DARK -> R.style.AppThemeRulebookDark
      LIGHT -> R.style.AppThemeRulebookLight
    }

  /**
   * Get a theme.
   *
   * @return One of the following themes:
   * [R.style.AppThemeRulebookLight],
   * [R.style.AppThemeRulebookDark],
   */
  @get:StyleRes
  val noActionBarTheme: Int
    get() = when (customThemeEngine.baseTheme) {
      DARK -> R.style.AppThemeRulebookDark
      LIGHT -> R.style.AppThemeRulebookLight
    }
}

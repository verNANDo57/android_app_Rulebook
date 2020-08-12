package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.StyleRes
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.CustomThemeEngineContextWrapper
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.CustomThemeEngineViewFactory
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.CustomThemeEngineViewProcessor
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.decor.CustomThemeEngineDecorator

internal const val Build_VERSION_CODES_Q = 29

/**
 * This class represents a delegate which you can use to extend [CustomThemeEngine]'s support to any [Activity].
 *
 * When using a [delegate][CustomThemeEngineDelegate] the following methods should be called in the corresponding activity:
 *
 * * [CustomThemeEngineDelegate.onCreate]
 * * [CustomThemeEngineDelegate.onPostCreate]
 * * [CustomThemeEngineDelegate.onStart]
 * * [CustomThemeEngineDelegate.onResume]
 *
 * The method [CustomThemeEngineDelegate.wrap] should also be used in [Activity.attachBaseContext].
 */
abstract class CustomThemeEngineDelegate {

  /**
   * Wrap the context in a [CustomThemeEngineContextWrapper].
   *
   * @param newBase The base context
   * @return The wrapped context
   */
  abstract fun wrap(newBase: Context): Context

  /**
   * Should be called from [Activity.onCreate()][Activity.onCreate].
   *
   * This should be called before `super.onCreate()` as so:
   *
   * ```
   * override fun onCreate(savedInstanceState: Bundle?) {
   *     getCustomThemeEngineDelegate().onCreate(savedInstanceState)
   *     super.onCreate(savedInstanceState)
   *     // ...
   * }
   * ```
   */
  abstract fun onCreate(savedInstanceState: Bundle?)

  /**
   * Should be called from [Activity.onPostCreate]
   */
  abstract fun onPostCreate(savedInstanceState: Bundle?)

  /**
   * Should be called from [Activity.onStart]
   */
  abstract fun onStart()

  /**
   * Should be called from [Activity.onResume()][Activity.onResume].
   *
   * This should be called after `super.onResume()` as so:
   *
   * ```
   * override fun onResume() {
   *     super.onResume()
   *     getCyaneaDelegate().onResume()
   *     // ...
   * }
   * ```
   */
  abstract fun onResume()

  /**
   * Should be called from [Activity.onCreateOptionsMenu] after inflating the menu.
   */

  protected abstract fun getViewFactory(): CustomThemeEngineViewFactory

  protected abstract fun getViewProcessors(): Array<CustomThemeEngineViewProcessor<View>>

  protected abstract fun getDecorators(): Array<CustomThemeEngineDecorator>

  @StyleRes protected abstract fun getThemeResId(): Int

  companion object {

    /**
     * Create a [CustomThemeEngineDelegate] to be used in an [Activity].
     *
     * @param activity The activity
     * @param customThemeEngine The cyanea instance for theming
     * @param themeResId The theme resource id
     * @return The delegate
     */
    @SuppressLint("NewApi") // Needed for Android Pie (API 28) for whatever reason ¯\_(ツ)_/¯
    @JvmStatic
    fun create(activity: Activity, customThemeEngine: CustomThemeEngine, @StyleRes themeResId: Int): CustomThemeEngineDelegate {
      return when {
        Build.VERSION.SDK_INT >= Build_VERSION_CODES_Q -> CustomThemeEngineDelegateImplV29(activity, customThemeEngine, themeResId)
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> CustomThemeEngineDelegateImplV26(activity, customThemeEngine, themeResId)
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> CustomThemeEngineDelegateImplV24(activity, customThemeEngine, themeResId)
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> CustomThemeEngineDelegateImplV23(activity, customThemeEngine, themeResId)
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> CustomThemeEngineDelegateImplV21(activity, customThemeEngine, themeResId)
        else -> CustomThemeEngineDelegateImplBase(activity, customThemeEngine, themeResId)
      }
    }
  }
}
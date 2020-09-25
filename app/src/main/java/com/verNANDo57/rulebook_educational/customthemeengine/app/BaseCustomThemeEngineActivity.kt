package com.verNANDo57.rulebook_educational.customthemeengine.app

import androidx.annotation.StyleRes
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngineThemes
import com.verNANDo57.rulebook_educational.customthemeengine.delegate.CustomThemeEngineDelegate

/**
 * Implement in each [activity][android.app.Activity] to provide a [delegate][CustomThemeEngineDelegate] for custom theming.
 */
interface BaseCustomThemeEngineActivity {

  /**
   * The [CustomThemeEngine] instance used for styling.
   */
  val customThemeEngine: CustomThemeEngine get() = CustomThemeEngine.INSTANCE

  /**
   * Get the theme resource id. You can use a pre-defined theme in [CustomThemeEngineThemes] or use your own theme that inherits
   * from a CustomThemeEngine based theme.
   *
   * If 0 is returned then Customthemeengine will determine whether to use a NoActionBar theme based on the current theme.
   *
   * @return A customthemeengine theme
   *
   * @see [CustomThemeEngineThemes.actionBarTheme]
   * @see [CustomThemeEngineThemes.noActionBarTheme]
   */
  @StyleRes fun getThemeResId(): Int = 0
}

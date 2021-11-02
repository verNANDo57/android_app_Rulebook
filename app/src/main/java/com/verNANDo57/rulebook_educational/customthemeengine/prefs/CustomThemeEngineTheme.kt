package com.verNANDo57.rulebook_educational.customthemeengine.prefs

import android.content.res.AssetManager
import androidx.annotation.ColorInt
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme.DARK
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme.LIGHT
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

/**
 * A CustomThemeEngine theme. Load a list of themes using [CustomThemeEngineTheme.from].
 */
data class CustomThemeEngineTheme internal constructor(
  val themeName: String,
  val baseTheme: BaseTheme,
  @ColorInt val primary: Int,
  @ColorInt val accent: Int,
  @ColorInt val background: Int,
  @ColorInt val backgroundDark: Int,
  @ColorInt val backgroundLight: Int,
  @ColorInt val bottomAppBarItemColor: Int,
  @ColorInt val backgroundToast: Int,
  @ColorInt val buttonStrokeColor : Int,
  @ColorInt val accentToast: Int,
  @ColorInt val bottomSheetDialogAccent : Int,
  @ColorInt val bottomSheetDialogPrimary : Int,
  @ColorInt val bottomSheetDialogBackground : Int
) {

  /**
   * Set the theme. The activity will need to be recreated for changes to be applied.
   */
  fun apply(customThemeEngine: CustomThemeEngine) = customThemeEngine.edit {
    baseTheme(baseTheme)
    primary(primary)
    accent(accent)
    background(background)
    when (baseTheme) {
      LIGHT -> {
        backgroundLightDarker(backgroundDark)
        backgroundLightLighter(backgroundLight)
      }
      DARK -> {
        backgroundDarkDarker(backgroundDark)
        backgroundDarkLighter(backgroundLight)
      }
    }
    bottomAppBarItemColor(bottomAppBarItemColor)
    backgroundToast(backgroundToast)
    accentToast(accentToast)
    buttonStrokeColor(buttonStrokeColor)
    bottomSheetDialogAccent(bottomSheetDialogAccent)
    bottomSheetDialogPrimary(bottomSheetDialogPrimary)
    bottomSheetDialogBackground(bottomSheetDialogBackground)
  }

  /**
   * Check if this theme matches the current color scheme
   */
  fun isMatchingColorScheme(customThemeEngine: CustomThemeEngine): Boolean =
      primary == customThemeEngine.primary &&
      accent == customThemeEngine.accent &&
      bottomAppBarItemColor == customThemeEngine.bottomAppBarItemColor &&
      backgroundToast == customThemeEngine.backgroundToast &&
      accentToast == customThemeEngine.accentToast &&
      background == customThemeEngine.backgroundColor &&
      buttonStrokeColor == customThemeEngine.buttonStrokeColor &&
      bottomSheetDialogAccent == customThemeEngine.bottomSheetDialogAccent &&
      bottomSheetDialogPrimary == customThemeEngine.bottomSheetDialogPrimary &&
      bottomSheetDialogBackground == customThemeEngine.bottomSheetDialogBackground

  companion object {

    private const val TAG = "RULEBOOK_APP_CustomThemeEngine_currentTheme"

    // JSON Keys
    private const val THEME_NAME = "theme_name"
    private const val BASE_THEME = "base_theme"
    private const val PRIMARY_COLOR = "primary"
    private const val ACCENT_COLOR = "accent"
    private const val BACKGROUND_COLOR = "background"
    private const val BACKGROUND_DARK_COLOR = "background_dark"
    private const val BACKGROUND_LIGHT_COLOR = "background_light"
    private const val BOTTOMAPPBAR_ICONS_COLOR = "bottomappbar_icon_color"
    private const val BACKGROUND_TOAST = "toast_background"
    private const val ACCENT_TOAST = "toast_accent"
    private const val BUTTON_STROKE_COLOR = "button_stroke"
    private const val BOTTOMSHEETDIALOG_ACCENT = "bottomsheetdialog_accent"
    private const val BOTTOMSHEETDIALOG_PRIMARY = "bottomsheetdialog_primary"
    private const val BOTTOMSHEETDIALOG_BACKGROUND = "bottomsheetdialog_background"

    /**
     * Get a list of themes from a file containing the JSON
     */
    fun from(file: File) = from(file.inputStream().readBytes().toString(Charsets.UTF_8))

    /**
     * Get a list of themes from an asset containing the JSON
     */
    fun from(assets: AssetManager, path: String) = from(
        assets.open(path).bufferedReader().use { it.readText() }
    )

    /**
     * Get a list of themes from a JSON array.
     */
    fun from(json: String): List<CustomThemeEngineTheme> {
      val themes = mutableListOf<CustomThemeEngineTheme>()
      val array = JSONArray(json)
      for (i in 0 until array.length()) {
        try {
          (array.get(i) as? JSONObject)?.let {
            themes.add(newInstance(it))
          }
        } catch (e: Exception) {
          CustomThemeEngine.log(TAG, "Error reading theme #${i + 1}", e)
        }
      }
      return themes
    }

    /**
     * Deserialize JSON to a [CustomThemeEngineTheme]
     */
    private fun newInstance(json: JSONObject): CustomThemeEngineTheme {
      // Get the theme name
      val themeName = json.optString(THEME_NAME)

      // Get the primary colors
      val primary = ColorUtils.parseColor(json.getString(PRIMARY_COLOR))

      // Get the accent colors
      val accent = ColorUtils.parseColor(json.getString(ACCENT_COLOR))

      // Get the background colors
      val background = ColorUtils.parseColor(json.getString(BACKGROUND_COLOR))
      val backgroundDarker = if (json.has(BACKGROUND_DARK_COLOR)) {
        ColorUtils.parseColor(json.getString(BACKGROUND_DARK_COLOR))
      } else {
        ColorUtils.darker(background)
      }
      val backgroundLighter = if (json.has(BACKGROUND_LIGHT_COLOR)) {
        ColorUtils.parseColor(json.getString(BACKGROUND_LIGHT_COLOR))
      } else {
        ColorUtils.lighter(background)
      }

      // Get the base theme
      val baseTheme = if (json.has(BASE_THEME)) {
        if (json.getString(BASE_THEME) == DARK.name) DARK else LIGHT
      } else {
        if (ColorUtils.isDarkColor(background)) DARK else LIGHT
      }

      // Get the bottomappbar item colors
      val bottomAppBarItemColor = ColorUtils.parseColor(json.getString(BOTTOMAPPBAR_ICONS_COLOR))

      // Get the backgroundToast item colors
      val backgroundToast = ColorUtils.parseColor(json.getString(BACKGROUND_TOAST))

      // Get the accentToast item colors
      val accentToast = ColorUtils.parseColor(json.getString(ACCENT_TOAST))

      // Get the accentToast item colors
      val buttonStrokeColor = ColorUtils.parseColor(json.getString(BUTTON_STROKE_COLOR))

      //Get the bottomsheetdialog accent color
      val bottomSheetDialogAccent = ColorUtils.parseColor(json.getString(BOTTOMSHEETDIALOG_ACCENT))

      //Get the bottomsheetdialog primary color
      val bottomSheetDialogPrimary = ColorUtils.parseColor(json.getString(BOTTOMSHEETDIALOG_PRIMARY))

      //Get the bottomsheetdialog background color
      val bottomSheetDialogBackground = ColorUtils.parseColor(json.getString(BOTTOMSHEETDIALOG_BACKGROUND))

      return CustomThemeEngineTheme(
          themeName,
          baseTheme,
          primary,
          accent,
          background,
          backgroundDarker,
          backgroundLighter,
          bottomAppBarItemColor,
          backgroundToast,
          buttonStrokeColor,
          accentToast,
          bottomSheetDialogAccent,
          bottomSheetDialogPrimary,
          bottomSheetDialogBackground
      )
    }
  }
}

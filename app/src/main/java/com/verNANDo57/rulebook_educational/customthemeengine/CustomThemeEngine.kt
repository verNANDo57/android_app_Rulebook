@file:Suppress("DEPRECATION")

package com.verNANDo57.rulebook_educational.customthemeengine

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Keep
import androidx.annotation.MainThread
import com.verNANDo57.rulebook_educational.customthemeengine.Constants.LIGHT_ACTIONBAR_LUMINANCE_FACTOR
import com.verNANDo57.rulebook_educational.customthemeengine.Constants.NONE_TIMESTAMP
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme.DARK
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine.BaseTheme.LIGHT
import com.verNANDo57.rulebook_educational.customthemeengine.Defaults.DEFAULT_DARKER_FACTOR
import com.verNANDo57.rulebook_educational.customthemeengine.Defaults.DEFAULT_LIGHTER_FACTOR
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_ACCENT
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BACKGROUND_DARK
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BACKGROUND_DARK_DARKER
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BACKGROUND_DARK_LIGHTER
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BACKGROUND_LIGHT
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BACKGROUND_LIGHT_DARKER
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BACKGROUND_LIGHT_LIGHTER
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BASE_THEME
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BOTTOMAPPBAR_ITEMS_COLORS
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BOTTOMSHEETDIALOG_ACCENT
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BOTTOMSHEETDIALOG_BACKGROUND
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BOTTOMSHEETDIALOG_PRIMARY
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_BUTTON_STROKE_COLOR
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_FILE_NAME
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_PRIMARY
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_TIMESTAMP
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_TOAST_ACCENT
import com.verNANDo57.rulebook_educational.customthemeengine.PrefKeys.PREF_TOAST_BACKGROUND
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.CustomThemeEngineInflationDelegate
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.CustomThemeEngineLayoutInflater
import com.verNANDo57.rulebook_educational.customthemeengine.tinting.CustomThemeEngineTinter
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils
import com.verNANDo57.rulebook_educational.extradata.R
import kotlin.properties.Delegates

class CustomThemeEngine private constructor(private val prefs: SharedPreferences) {

  /** The primary color displayed most frequently across your app */
  var primary by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The accent color that accents select parts of the UI */
  var accent by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color of icons in a [bottomAppBarItemColor] */
  var bottomAppBarItemColor by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color of [backgroundToast] */
  var backgroundToast by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color of [accentToast] */
  var accentToast by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color of stroke in a [buttonStrokeColor] */
  var buttonStrokeColor by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color in a [bottomSheetDialogAccent] */
  var bottomSheetDialogAccent by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color in a [bottomSheetDialogPrimary] */
  var bottomSheetDialogPrimary by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The color in a [bottomSheetDialogBackground] */
  var bottomSheetDialogBackground by Delegates.notNull<Int>()
    @ColorInt get
    private set

  /** The background color used as the underlying color of the app's content */
  val backgroundColor: Int
    get() = when (baseTheme) {
      LIGHT -> backgroundLight
      DARK -> backgroundDark
    }
  /* A lighter version of the [background] color */
  val backgroundColorLight: Int
    get() = when (baseTheme) {
      LIGHT -> backgroundLightLighter
      DARK -> backgroundDarkLighter
    }
  /* A darker version of the [background] color */
  val backgroundColorDark: Int
    get() = when (baseTheme) {
      LIGHT -> backgroundLightDarker
      DARK -> backgroundDarkDarker
    }

  /** The base theme. Either [LIGHT] or [DARK] */
  var baseTheme by Delegates.notNull<BaseTheme>()
    internal set
  /** True if the [baseTheme] is [DARK] */
  val isDark get() = baseTheme == DARK
  /** True if the [baseTheme] is [LIGHT] */
  val isLight get() = baseTheme == LIGHT
  /** True if the [primary] color is a dark color */
  val isThemeModified get() = timestamp != NONE_TIMESTAMP

  /** Helper to tint a [Drawable], [ColorStateList] or a [View] */
  val tinter by lazy { CustomThemeEngineTinter() }
  val themes by lazy { CustomThemeEngineThemes(this) }

  internal var backgroundDark by Delegates.notNull<Int>()
    @ColorInt get
  internal var backgroundDarkLighter by Delegates.notNull<Int>()
    @ColorInt get
  internal var backgroundDarkDarker by Delegates.notNull<Int>()
    @ColorInt get
  internal var backgroundLight by Delegates.notNull<Int>()
    @ColorInt get
  internal var backgroundLightLighter by Delegates.notNull<Int>()
    @ColorInt get
  internal var backgroundLightDarker by Delegates.notNull<Int>()
    @ColorInt get

  internal var timestamp: Long = 0L
    private set

  init {
    loadDefaults()
  }
  /**
   * Create a new [Editor] to edit this instance
   */
  fun edit() = Editor(this)

  /**
   * Reset all theme values. The activity must be recreated after resetting.
   */
  fun reset() = prefs.edit().clear().apply().also { loadDefaults() }.run { Recreator() }

  /**
   * Creates a new editor and applys any edits in the action parameter
   */
  inline fun edit(action: Editor.() -> Unit) = edit().also { editor -> action(editor) }.apply()

  private fun loadDefaults() {
    primary = prefs.getInt(PREF_PRIMARY,
      res.getColor(R.color.app_rulebook_theme))

    accent = prefs.getInt(PREF_ACCENT,
      res.getColor(R.color.coloraccent_reference))

    backgroundLight = prefs.getInt(PREF_BACKGROUND_LIGHT,
      res.getColor(R.color.custom_bg_light))
    backgroundLightDarker = prefs.getInt(PREF_BACKGROUND_LIGHT_DARKER,
      res.getColor(R.color.custom_bg_light_darker))
    backgroundLightLighter = prefs.getInt(PREF_BACKGROUND_LIGHT_LIGHTER,
      res.getColor(R.color.custom_bg_light_lighter))

    backgroundDark = prefs.getInt(PREF_BACKGROUND_DARK,
      res.getColor(R.color.custom_bg_dark))
    backgroundDarkDarker = prefs.getInt(PREF_BACKGROUND_DARK_DARKER,
      res.getColor(R.color.custom_bg_dark_darker))
    backgroundDarkLighter = prefs.getInt(PREF_BACKGROUND_DARK_LIGHTER,
      res.getColor(R.color.custom_bg_dark_lighter))

    baseTheme = getBaseTheme(prefs, res)

    bottomAppBarItemColor = prefs.getInt(PREF_BOTTOMAPPBAR_ITEMS_COLORS,
      res.getColor(if (baseTheme == LIGHT) R.color.bottomappbar_items_color_everytheme_reference else R.color.bottomappbar_items_color_everytheme_reference))

    backgroundToast = prefs.getInt(PREF_TOAST_BACKGROUND,
            res.getColor(if (baseTheme == LIGHT) R.color.styleable_toast_default_background_color_reference else R.color.styleable_toast_default_background_color_reference))

    accentToast = prefs.getInt(PREF_TOAST_ACCENT,
            res.getColor(if (baseTheme == LIGHT) R.color.styleable_toast_default_accent_color_reference else R.color.styleable_toast_default_accent_color_reference))

    buttonStrokeColor = prefs.getInt(PREF_BUTTON_STROKE_COLOR,
      res.getColor(if (baseTheme == LIGHT) R.color.button_color_default else R.color.button_color_default))

    bottomSheetDialogAccent = prefs.getInt(PREF_BOTTOMSHEETDIALOG_ACCENT,
            res.getColor(if (baseTheme == LIGHT) R.color.bottomsheetdialog_accent_reference else R.color.bottomsheetdialog_accent_reference))

    bottomSheetDialogPrimary = prefs.getInt(PREF_BOTTOMSHEETDIALOG_PRIMARY,
            res.getColor(if (baseTheme == LIGHT) R.color.bottomsheetdialog_primary_reference else R.color.bottomsheetdialog_primary_reference))

    bottomSheetDialogBackground = prefs.getInt(PREF_BOTTOMSHEETDIALOG_BACKGROUND,
            res.getColor(if (baseTheme == LIGHT) R.color.bottomsheetdialog_background_reference else R.color.bottomsheetdialog_background_reference))

    timestamp = prefs.getLong(PREF_TIMESTAMP, NONE_TIMESTAMP)
  }

  companion object {

    @SuppressLint("StaticFieldLeak") // application context is safe
    internal lateinit var app: Application
    lateinit var res: Resources

    /**
     * Initialize CustomThemeEngine. This should be done in the [application][Application] class.
     */
    @JvmStatic
    fun init(app: Application, res: Resources) {
      Companion.app = app
      Companion.res = res
    }

    /**
     * Check if CustomThemeEngine has been initialized.
     *
     * @see [init]
     */
    @JvmStatic
    fun isInitialized(): Boolean {
      return try {
        app
        res
        true
      } catch (e: UninitializedPropertyAccessException) {
        false
      }
    }

    private object Holder {

      val INSTANCE: CustomThemeEngine
        get() {
          try {
            val preferences = app.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
            return CustomThemeEngine(preferences)
          } catch (e: UninitializedPropertyAccessException) {
            throw IllegalStateException("customThemeEngine.init must be called before referencing the singleton instance")
          }
        }
    }

    private val instances by lazy { mutableMapOf<String, CustomThemeEngine>() }

    /**
     * The singleton [CustomThemeEngine] instance that you can use throughout the application.
     */
    @JvmStatic
    val INSTANCE: CustomThemeEngine by lazy { Holder.INSTANCE }

    /**
     * Get a instance of [CustomThemeEngine] by name. This will create a new instance if none exist.
     *
     * This allows you to have more than one color scheme in an app. You must override Activity#getCustomThemeEngine().
     */
    @JvmStatic
    fun getInstance(name: String): CustomThemeEngine {
      instances[name]?.let { customThemeEngine ->
        return customThemeEngine
      } ?: run {
        val preferences = app.getSharedPreferences(name, Context.MODE_PRIVATE)
        val customthemeengine = CustomThemeEngine(preferences)
        instances[name] = customthemeengine
        return customthemeengine
      }
    }

    /**
     * Intercept and create views at inflation time
     *
     * @delegate The delegate used to intercept and create views
     */
    @JvmStatic
    @MainThread
    fun setInflationDelegate(delegate: CustomThemeEngineInflationDelegate) {
      CustomThemeEngineLayoutInflater.inflationDelegate = delegate
    }

    /**
     * Turns on logging for the [CustomThemeEngine] library
     */
    @JvmStatic
    var loggingEnabled = false

    @JvmStatic
    fun log(tag: String, msg: String, ex: Throwable? = null) {
      if (loggingEnabled) {
        Log.d(tag, msg, ex)
      }
    }

    /**
     * Get the original color of a color resource.
     *
     * @param resid The color resource to retrieve
     */
    @JvmStatic
    @ColorInt
    fun getOriginalColor(@ColorRes resid: Int): Int = res.getColor(resid)

    private fun getBaseTheme(prefs: SharedPreferences, res: Resources): BaseTheme {
      val themeName = prefs.getString(PREF_BASE_THEME, null)
      return when (themeName) {
        LIGHT.name -> LIGHT
        DARK.name -> DARK
        else -> {
          TypedValue().also {
            app.theme?.resolveAttribute(android.R.attr.windowBackground, it, true)
          }.let {
            return if (it.type >= TypedValue.TYPE_FIRST_COLOR_INT && it.type <= TypedValue.TYPE_LAST_COLOR_INT) {
              if (ColorUtils.isDarkColor(it.data, LIGHT_ACTIONBAR_LUMINANCE_FACTOR)) DARK else LIGHT
            } else if (res.getBoolean(R.bool.is_default_theme_light)) LIGHT else DARK
          }
        }
      }
    }
  }

  /**
   * An editor for CustomThemeEngine to change colors and other values
   */
  @Suppress("MemberVisibilityCanBePrivate")
  class Editor internal constructor(private val customThemeEngine: CustomThemeEngine) {

    private val editor = customThemeEngine.prefs.edit()

    /**
     * Set the [primary] color using a color resource.
     *
     * The [primaryDark], [primaryLight], [navigationBar], and [menuIconColor] will also be updated to match the theme.
     */
    fun primaryResource(@ColorRes resid: Int) = primary(res.getColor(resid))

    /**
     * Set the [accent] dark color using a color resource.
     *
     * The [accentDark] and [accentLight] colors will also be updated.
     */
    fun accentResource(@ColorRes resid: Int): Editor = accent(res.getColor(resid))

    /**
     * Set the background color using a color resource.
     *
     * The [baseTheme], [backgroundLight] and [backgroundDark] will also be updated.
     */
    fun backgroundResource(@ColorRes resid: Int) = background(res.getColor(resid))

    /** Set the background color for a [LIGHT] theme using a color resource. */
    fun backgroundLightResource(@ColorRes resid: Int) = backgroundLight(res.getColor(resid))

    /** Set the background dark color for a [LIGHT] theme using a color resource. */
    fun backgroundLightDarkerResource(@ColorRes resid: Int) = backgroundLightDarker(res.getColor(resid))

    /** Set the background light color for a [LIGHT] theme using a color resource. */
    fun backgroundLightLighterResource(@ColorRes resid: Int) = backgroundLightLighter(res.getColor(resid))

    /** Set the background color for a [DARK] theme using a color resource. */
    fun backgroundDarkResource(@ColorRes resid: Int) = backgroundDark(res.getColor(resid))

    /** Set the background dark color for a [DARK] theme using a color resource. */
    fun backgroundDarkDarkerResource(@ColorRes resid: Int) = backgroundDarkDarker(res.getColor(resid))

    /** Set the background light color for a [DARK] theme using a color resource. */
    fun backgroundDarkLighterResource(@ColorRes resid: Int) = backgroundDarkLighter(res.getColor(resid))

    /** Set the [bottomAppBarItemColor] using a color resource */
    fun bottomAppBarItemColorResource(@ColorRes resid: Int) = bottomAppBarItemColor(res.getColor(resid))

    /** Set the [backgroundToast] using a color resource */
    fun backgroundToastResource(@ColorRes resid: Int) = backgroundToast(res.getColor(resid))

    /** Set the [accentToast] using a color resource */
    fun accentToastResource(@ColorRes resid: Int) = accentToast(res.getColor(resid))

    /** Set the [buttonStrokeColor] using a color resource */
    fun buttonStrokeColorResource (@ColorRes resid: Int) = buttonStrokeColor(res.getColor(resid))

    /** Set the [bottomSheetDialogBackground] using a color resource */
    fun bottomSheetDialogBackgroundResource (@ColorRes resid: Int) = bottomSheetDialogBackground(res.getColor(resid))

    /** Set the [bottomSheetDialogAccent] using a color resource */
    fun bottomSheetDialogAccentResource (@ColorRes resid: Int) = bottomSheetDialogAccent(res.getColor(resid))

    /** Set the [bottomSheetDialogPrimary] using a color resource */
    fun bottomSheetDialogPrimaryResource (@ColorRes resid: Int) = bottomSheetDialogPrimary(res.getColor(resid))

    /**
     * Set the [primary] color using a color resource.
     *
     * The [primaryDark], [primaryLight], [navigationBar], and [menuIconColor] will also be updated to match the theme.
     */
    fun primary(@ColorInt color: Int): Editor {
      customThemeEngine.primary = color
      editor.putInt(PREF_PRIMARY, color)
      val isDarkColor = ColorUtils.isDarkColor(color, LIGHT_ACTIONBAR_LUMINANCE_FACTOR)
      return this
    }

    /**
     * Set the [accent] dark color using a color resource.
     *
     * The [accentDark] and [accentLight] colors will also be updated.
     */
    fun accent(@ColorInt color: Int): Editor {
      customThemeEngine.accent = color
      editor.putInt(PREF_ACCENT, color)
      return this
    }

    /**
     * Set the background color using a color resource.
     *
     * The [baseTheme], [backgroundLight], [backgroundDark] and [subMenuIconColor] will also be updated.
     */
    fun background(@ColorInt color: Int): Editor {
      val lighter = ColorUtils.lighter(color, DEFAULT_LIGHTER_FACTOR)
      val darker = ColorUtils.darker(color, DEFAULT_DARKER_FACTOR)
      val isDarkColor = ColorUtils.isDarkColor(color, LIGHT_ACTIONBAR_LUMINANCE_FACTOR)
      if (isDarkColor) {
        baseTheme(DARK)
        backgroundDark(color)
        backgroundDarkDarker(darker)
        backgroundDarkLighter(lighter)
      } else {
        baseTheme(LIGHT)
        backgroundLight(color)
        backgroundLightDarker(darker)
        backgroundLightLighter(lighter)
      }
      return this
    }

    /** Set the background color for a [LIGHT] theme using a literal (hardcoded) color integer. */
    fun backgroundLight(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundLight = color
      editor.putInt(PREF_BACKGROUND_LIGHT, color)
      return this
    }

    /** Set the background dark color for a [LIGHT] theme using a literal (hardcoded) color integer. */
    fun backgroundLightDarker(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundDarkDarker = color
      editor.putInt(PREF_BACKGROUND_LIGHT_DARKER, color)
      return this
    }

    /** Set the background light color for a [LIGHT] theme using a literal (hardcoded) color integer. */
    fun backgroundLightLighter(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundLightLighter = color
      editor.putInt(PREF_BACKGROUND_LIGHT_LIGHTER, color)
      return this
    }

    /** Set the background color for a [DARK] theme using a literal (hardcoded) color integer. */
    fun backgroundDark(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundDark = color
      editor.putInt(PREF_BACKGROUND_DARK, color)
      return this
    }

    /** Set the background dark color for a [DARK] theme using a literal (hardcoded) color integer. */
    fun backgroundDarkDarker(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundDarkDarker = color
      editor.putInt(PREF_BACKGROUND_DARK_DARKER, color)
      return this
    }

    /** Set the background light color for a [DARK] theme using a literal (hardcoded) color integer. */
    fun backgroundDarkLighter(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundDarkLighter = color
      editor.putInt(PREF_BACKGROUND_DARK_LIGHTER, color)
      return this
    }

    /** Set the [bottomAppBarItemColor] using a literal (hardcoded) color integer */
    fun bottomAppBarItemColor(@ColorInt color: Int): Editor {
      customThemeEngine.bottomAppBarItemColor = color
      editor.putInt(PREF_BOTTOMAPPBAR_ITEMS_COLORS, color)
      return this
    }

    /** Set the [backgroundToast] using a literal (hardcoded) color integer */
    fun backgroundToast(@ColorInt color: Int): Editor {
      customThemeEngine.backgroundToast = color
      editor.putInt(PREF_TOAST_BACKGROUND, color)
      return this
    }

    /** Set the [accentToast] using a literal (hardcoded) color integer */
    fun accentToast(@ColorInt color: Int): Editor {
      customThemeEngine.accentToast = color
      editor.putInt(PREF_TOAST_ACCENT, color)
      return this
    }

    /** Set the [buttonStrokeColor] using a literal (hardcoded) color integer */
    fun buttonStrokeColor(@ColorInt color: Int): Editor {
      customThemeEngine.buttonStrokeColor = color
      editor.putInt(PREF_BUTTON_STROKE_COLOR, color)
      return this
    }

    /** Set the [bottomSheetDialogBackground] using a literal (hardcoded) color integer */
    fun bottomSheetDialogBackground(@ColorInt color: Int): Editor {
      customThemeEngine.bottomSheetDialogBackground = color
      editor.putInt(PREF_BOTTOMSHEETDIALOG_BACKGROUND, color)
      return this
    }

    /** Set the [bottomSheetDialogAccent] using a literal (hardcoded) color integer */
    fun bottomSheetDialogAccent(@ColorInt color: Int): Editor {
      customThemeEngine.bottomSheetDialogAccent = color
      editor.putInt(PREF_BOTTOMSHEETDIALOG_ACCENT, color)
      return this
    }

    /** Set the [bottomSheetDialogPrimary] using a literal (hardcoded) color integer */
    fun bottomSheetDialogPrimary(@ColorInt color: Int): Editor {
      customThemeEngine.bottomSheetDialogPrimary = color
      editor.putInt(PREF_BOTTOMSHEETDIALOG_PRIMARY, color)
      return this
    }

    /** Set the base theme. Either [LIGHT] or [DARK]. This should correlate with the [backgroundColor] */
    fun baseTheme(theme: BaseTheme): Editor {
      customThemeEngine.baseTheme = theme
      editor.putString(PREF_BASE_THEME, theme.name)
      return this
    }

    /**
     * Apply preferences to the editor. For theme changes to be applied you must recreate the activity.
     */
    fun apply(): Recreator {
      customThemeEngine.timestamp = System.currentTimeMillis()
      editor.putLong(PREF_TIMESTAMP, customThemeEngine.timestamp)
      editor.apply()
      return Recreator()
    }
  }

  /**
   * Helper to recreate a modified themed activity
   */
  class Recreator {

    /**
     * Recreate the current activity
     *
     * @param activity The current activity
     * @param delay The delay in milliseconds until the activity is recreated
     * @param smooth True to use a fade-in/fade-out animation when re-creating.
     * Use with caution, this will create a new instance of the activity.
     */
    @JvmOverloads
    fun recreate(activity: Activity, delay: Long = DEFAULT_DELAY, smooth: Boolean = false) {
      Handler().postDelayed({
        activity.run {
          if (smooth) {
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
          } else {
            recreate()
          }
        }
      }, delay)
    }

    companion object {
      private const val DEFAULT_DELAY = 200L
    }
  }

  /**
   * Callback when a theme has been modified and the [Activity] has been recreated.
   */
  interface ThemeModifiedListener {

    /**
     * Called in [onResume][Activity.onResume] of an [Activity] when the theme has been modified.
     */
    fun onThemeModified()
  }

  @Keep
  enum class BaseTheme {
    LIGHT,
    DARK
  }
}

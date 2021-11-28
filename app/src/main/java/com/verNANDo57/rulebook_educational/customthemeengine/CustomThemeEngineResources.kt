package com.verNANDo57.rulebook_educational.customthemeengine

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import com.verNANDo57.rulebook_educational.customthemeengine.tinting.CustomThemeEngineTinter.CustomThemeEngineTintException
import com.verNANDo57.rulebook_educational.extradata.R
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Resources to get custom colors from [CustomThemeEngine]
 */
@Suppress("DEPRECATION", "OverridingDeprecatedMember")
@SuppressLint("UseCompatLoadingForColorStateLists", "PrivateResource", "UseCompatLoadingForDrawables")
class CustomThemeEngineResources(original: Resources, private val customThemeEngine: CustomThemeEngine = CustomThemeEngine.INSTANCE) :
  Resources(original.assets, original.displayMetrics, original.configuration) {

  init {
    customThemeEngine.tinter.setup(original, this)
  }

  /* Track resources so we don't attempt to modify the Drawable or ColorStateList more than once */
  private val tintTracker = TintTracker()

  @Throws(NotFoundException::class)
  override fun getDrawable(id: Int): Drawable {
    return this.getDrawable(id, null)
  }

  @Throws(NotFoundException::class)
  override fun getDrawable(id: Int, theme: Theme?): Drawable {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      super.getDrawable(id, theme).let { drawable ->
        if (!tintTracker.contains(id, theme)) {
          try {
            customThemeEngine.tinter.tint(drawable)
          } catch (e: CustomThemeEngineTintException) {
            CustomThemeEngine.log(TAG, "Error tinting drawable", e)
          }
          tintTracker.add(id, theme)
        }
        return drawable
      }
    }
    return when (id) {
      R.color.custom_background_dark, R.drawable.customthemeengine_bg_dark
      -> ColorDrawable(customThemeEngine.backgroundDark)
      R.color.custom_background_dark_darker, R.drawable.customthemeengine_bg_dark_darker
      -> ColorDrawable(customThemeEngine.backgroundDarkDarker)
      R.color.custom_background_dark_lighter, R.drawable.customthemeengine_bg_dark_lighter
      -> ColorDrawable(customThemeEngine.backgroundDarkLighter)
      R.color.custom_background_light, R.drawable.customthemeengine_bg_light
      -> ColorDrawable(customThemeEngine.backgroundLight)
      R.color.custom_background_light_darker, R.drawable.customthemeengine_bg_light_darker
      -> ColorDrawable(customThemeEngine.backgroundLightDarker)
      R.color.custom_background_light_lighter, R.drawable.customthemeengine_bg_light_lighter
      -> ColorDrawable(customThemeEngine.backgroundLightLighter)
      R.color.bottomappbar_items_color_everytheme_reference, R.drawable.bottomappbar_item_color
      -> ColorDrawable(customThemeEngine.bottomAppBarItemColor)
      R.color.styleable_toast_default_background_color_reference, R.drawable.styleable_toast_default_background_color
      -> ColorDrawable(customThemeEngine.backgroundToast)
      R.color.button_color_default, R.drawable.button_color_default
      -> ColorDrawable(customThemeEngine.buttonStrokeColor)
      R.color.app_rulebook_background_reference, R.drawable.app_rulebook_background_reference
      -> ColorDrawable(customThemeEngine.bottomSheetDialogBackground)
      else -> {
        super.getDrawable(id, theme)
      }
    }
  }

  @Throws(NotFoundException::class)
  override fun getColor(id: Int): Int {
    return this.getColor(id, null)
  }

  @SuppressLint("PrivateResource")
  @Throws(NotFoundException::class)
  override fun getColor(id: Int, theme: Theme?): Int = when (id) {
    // ------ PRIMARY COLORS ------
    R.color.navbar_color, R.color.statusbar_color, R.color.app_rulebook_theme, R.color.app_vector_rating_face_color, R.color.app_text_reference, R.color.styleable_toast_default_text_color_reference, R.color.actionbar_in_recents_default_color -> customThemeEngine.primary
    // ------ ACCENT COLORS ------
    R.color.coloraccent_reference -> customThemeEngine.accent
    // ------ BACKGROUND COLORS ------
    R.color.layout_dark, R.color.custom_bg_dark, R.color.custom_bg_dark_darker, R.color.custom_bg_dark_lighter -> customThemeEngine.backgroundDark
    R.color.layout_light, R.color.custom_bg_light, R.color.custom_bg_light_darker, R.color.custom_bg_light_lighter -> customThemeEngine.backgroundLight
    // ------ BOTTOMAPPBAR ITEM COLOR ------
    R.color.bottomappbar_items_color_everytheme_reference -> customThemeEngine.bottomAppBarItemColor
    // ------ TOAST BACKGROUND COLOR ------
    R.color.styleable_toast_default_background_color_reference -> customThemeEngine.backgroundToast
    // ------ TOAST ACCENT COLOR ------
    R.color.styleable_toast_default_accent_color_reference -> customThemeEngine.accentToast
    // ------ BUTTON STROKE COLOR ------
    R.color.button_color_default -> customThemeEngine.buttonStrokeColor
    // ------ BOTTOMSHEETDIALOG ACCENT COLOR ------
    R.color.bottomsheetdialog_accent_reference -> customThemeEngine.bottomSheetDialogAccent
    // ------ BOTTOMSHEETDIALOG PRIMARY COLOR ------
    R.color.bottomsheetdialog_primary_reference -> customThemeEngine.bottomSheetDialogPrimary
    // ------ BOTTOMSHEETDIALOG BACKGROUND COLOR ------
    R.color.app_rulebook_background_reference -> customThemeEngine.bottomSheetDialogBackground
    else -> {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        super.getColor(id) else super.getColor(id, theme)
    }
  }

  @RequiresApi(Build.VERSION_CODES.M)
  @Throws(NotFoundException::class)
  override fun getColorStateList(id: Int): ColorStateList {
    return super.getColorStateList(id)
  }

  @RequiresApi(Build.VERSION_CODES.M)
  @Throws(NotFoundException::class)
  override fun getColorStateList(id: Int, theme: Resources.Theme?): ColorStateList {
    val colorStateList = super.getColorStateList(id, theme)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (!tintTracker.contains(id, theme)) {
        customThemeEngine.tinter.tint(colorStateList)
        tintTracker.add(id, theme)
      }
    }
    return colorStateList
  }

  private inner class TintTracker {

    private val cache: MutableSet<Int> by lazy {
      Collections.newSetFromMap(ConcurrentHashMap<Int, Boolean>())
    }

    fun contains(id: Int, theme: Resources.Theme?): Boolean = cache.contains(key(id, theme))

    fun add(id: Int, theme: Resources.Theme?): Boolean = cache.add(key(id, theme))

    private fun key(id: Int, theme: Resources.Theme?): Int = id + (theme?.hashCode() ?: 0)
  }

  companion object {
    private const val TAG = "RULEBOOK_APP_CustomThemeEngineResources"
  }
}

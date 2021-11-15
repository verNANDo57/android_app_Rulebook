package com.verNANDo57.rulebook_educational.customthemeengine.prefs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.XmlRes
import androidx.preference.*
import androidx.preference.Preference.OnPreferenceChangeListener
import androidx.preference.Preference.OnPreferenceClickListener
import androidx.recyclerview.widget.RecyclerView
import com.verNANDo57.rulebook_educational.colorpicker.ColorPreferenceCompat
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.app.BaseCustomThemeEngineActivity
import com.verNANDo57.rulebook_educational.extradata.R

open class CustomThemeEngineSettingsFragment : PreferenceFragmentCompat(), OnPreferenceChangeListener, OnPreferenceClickListener {

  private lateinit var prefThemePicker: Preference
  private lateinit var prefColorPrimary: ColorPreferenceCompat
  private lateinit var prefColorAccent: ColorPreferenceCompat
  private lateinit var prefColorBackground: ColorPreferenceCompat
  private lateinit var prefBottomAppBarItemColor: ColorPreferenceCompat
  private lateinit var prefToastBackground: ColorPreferenceCompat
  private lateinit var prefToastAccent: ColorPreferenceCompat
  private lateinit var prefButtonStroke: ColorPreferenceCompat
  private lateinit var prefBottomSheetDialogAccent: ColorPreferenceCompat
  private lateinit var prefBottomSheetDialogPrimary: ColorPreferenceCompat
  private lateinit var prefBottomSheetDialogBackground: ColorPreferenceCompat

  /**
   * The [CustomThemeEngine] instance used for styling.
   */
  open val customThemeEngine: CustomThemeEngine get() = (activity as? BaseCustomThemeEngineActivity)?.customThemeEngine ?: CustomThemeEngine.INSTANCE

  /**
   * Get the preferences resource to load into the preference hierarchy.
   *
   * The preferences should contain a [ColorPreferenceCompat] for "pref_color_primary",
   * "pref_color_accent" and "pref_color_background".
   *
   * It should also contain preferences for "pref_theme_picker" and "pref_color_navigation_bar".
   *
   * @return The XML resource id to inflate
   */
  @XmlRes open fun getPreferenceXmlResId(): Int = R.xml.pref_customthemeengine

  /**
   * Sets whether to reserve the space of all Preference views. If set to false, all padding will be removed.
   *
   * By default, if the action bar is displaying home as up then padding will be added to the preference.
   */
  open val iconSpaceReserved = false

  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(getPreferenceXmlResId(), rootKey)

    prefThemePicker = findPreference(PREF_THEME_PICKER)
    prefColorPrimary = findPreference(PREF_COLOR_PRIMARY)
    prefColorAccent = findPreference(PREF_COLOR_ACCENT)
    prefColorBackground = findPreference(PREF_COLOR_BACKGROUND)
    prefBottomAppBarItemColor = findPreference(PREF_BOTTOMAPPBAR_ITEM_COLOR)
    prefToastBackground = findPreference(PREF_TOAST_BACKGROUND_COLOR)
    prefToastAccent = findPreference(PREF_TOAST_ACCENT_COLOR)
    prefButtonStroke = findPreference(PREF_BUTTON_STROKE_COLOR)
    prefBottomSheetDialogAccent = findPreference(PREF_BOTTOMSHEETDIALOG_ACCENT_COLOR)
    prefBottomSheetDialogPrimary = findPreference(PREF_BOTTOMSHEETDIALOG_PRIMARY_COLOR)
    prefBottomSheetDialogBackground = findPreference(PREF_BOTTOMSHEETDIALOG_BACKGROUND_COLOR)


    prefColorPrimary.saveValue(customThemeEngine.primary)
    prefColorAccent.saveValue(customThemeEngine.accent)
    prefColorBackground.saveValue(customThemeEngine.backgroundColor)
    prefBottomAppBarItemColor.saveValue(customThemeEngine.bottomAppBarItemColor)
    prefToastBackground.saveValue(customThemeEngine.backgroundToast)
    prefToastAccent.saveValue(customThemeEngine.accentToast)
    prefButtonStroke.saveValue(customThemeEngine.buttonStrokeColor)
    prefBottomSheetDialogAccent.saveValue(customThemeEngine.bottomSheetDialogAccent)
    prefBottomSheetDialogPrimary.saveValue(customThemeEngine.bottomSheetDialogPrimary)
    prefBottomSheetDialogBackground.saveValue(customThemeEngine.bottomSheetDialogBackground)

    prefThemePicker.onPreferenceClickListener = this
    prefColorPrimary.onPreferenceChangeListener = this
    prefColorAccent.onPreferenceChangeListener = this
    prefColorBackground.onPreferenceChangeListener = this
    prefBottomAppBarItemColor.onPreferenceChangeListener = this
    prefToastBackground.onPreferenceChangeListener = this
    prefToastAccent.onPreferenceChangeListener = this
    prefButtonStroke.onPreferenceChangeListener = this
    prefBottomSheetDialogAccent.onPreferenceChangeListener = this
    prefBottomSheetDialogPrimary.onPreferenceChangeListener = this
    prefBottomSheetDialogBackground.onPreferenceChangeListener = this
  }

  override fun onPreferenceClick(preference: Preference?): Boolean {
    return when (preference) {
      prefThemePicker -> {
        activity?.run {
          if (this is CustomThemePickerLauncher) {
            launchThemePicker()
          } else {
            startActivity(Intent(this, CustomThemeEngineThemePickerActivity::class.java))
          }
        }
        true
      }
      else -> false
    }
  }

  override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
    fun editTheme(action: (editor: CustomThemeEngine.Editor) -> Unit) {
      customThemeEngine.edit {
        action(this)
      }.recreate(requireActivity(), smooth = true)
    }

    when (preference) {
      prefColorPrimary -> editTheme { it.primary(newValue as Int) }
      prefColorAccent -> editTheme { it.accent(newValue as Int) }
      prefColorBackground -> editTheme { it.background(newValue as Int) }
      prefBottomAppBarItemColor -> editTheme { it.bottomAppBarItemColor(newValue as Int) }
      prefToastBackground -> editTheme { it.backgroundToast(newValue as Int) }
      prefToastAccent -> editTheme { it.accentToast(newValue as Int) }
      prefButtonStroke -> editTheme { it.buttonStrokeColor(newValue as Int) }
      prefBottomSheetDialogAccent -> editTheme { it.bottomSheetDialogAccent(newValue as Int) }
      prefBottomSheetDialogPrimary -> editTheme { it.bottomSheetDialogPrimary(newValue as Int) }
      prefBottomSheetDialogBackground -> editTheme { it.bottomSheetDialogBackground(newValue as Int) }
      else -> return false
    }

    return true
  }

  override fun onCreateAdapter(preferenceScreen: PreferenceScreen): RecyclerView.Adapter<*> {
    return object : PreferenceGroupAdapter(preferenceScreen) {
      @SuppressLint("RestrictedApi")
      override fun onBindViewHolder(holder: PreferenceViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (iconSpaceReserved) return
        val preference = getItem(position)
        if (preference is PreferenceCategory) {
          setZeroPaddingToLayoutChildren(holder.itemView)
        } else {
          holder.itemView.findViewById<View>(R.id.icon_frame)?.let { iconFrame ->
            iconFrame.visibility = if (preference.icon == null) View.GONE else View.VISIBLE
          }
        }
      }
    }
  }

  private fun setZeroPaddingToLayoutChildren(view: View) {
    if (view !is ViewGroup) return
    for (i in 0 until view.childCount) {
      setZeroPaddingToLayoutChildren(view.getChildAt(i))
      view.setPaddingRelative(0, view.paddingTop, view.paddingEnd, view.paddingBottom)
    }
  }

  private inline fun <reified T : Preference> findPreference(key: String): T = super.findPreference(key)!!

  companion object {
    private const val PREF_THEME_PICKER = "pref_theme_picker"
    private const val PREF_COLOR_PRIMARY = "pref_color_primary"
    private const val PREF_COLOR_ACCENT = "pref_color_accent"
    private const val PREF_COLOR_BACKGROUND = "pref_color_background"
    private const val PREF_BOTTOMAPPBAR_ITEM_COLOR = "pref_bottomappbar_item_color"
    private const val PREF_TOAST_BACKGROUND_COLOR = "pref_toast_background_color"
    private const val PREF_TOAST_ACCENT_COLOR = "pref_toast_accent_color"
    private const val PREF_BUTTON_STROKE_COLOR = "pref_button_stroke_color"
    private const val PREF_BOTTOMSHEETDIALOG_ACCENT_COLOR = "pref_bottomsheetdialog_accent"
    private const val PREF_BOTTOMSHEETDIALOG_PRIMARY_COLOR = "pref_bottomsheetdialog_primary"
    private const val PREF_BOTTOMSHEETDIALOG_BACKGROUND_COLOR = "pref_bottomsheetdialog_background"

    fun newInstance() = CustomThemeEngineSettingsFragment()
  }
}

/**
 * Let the hosting activity implement this to launch a custom theme picker from preferences
 */
interface CustomThemePickerLauncher {

  /**
   * Launch a theme picker for CustomThemeEngine
   */
  fun launchThemePicker()
}

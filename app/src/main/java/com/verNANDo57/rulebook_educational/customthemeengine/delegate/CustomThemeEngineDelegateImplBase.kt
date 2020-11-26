package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.annotation.StyleRes
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.*
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.decor.CustomThemeEngineDecorator
import com.verNANDo57.rulebook_educational.customthemeengine.tinting.EdgeEffectTint
import com.verNANDo57.rulebook_educational.customthemeengine.tinting.MenuTint
import com.verNANDo57.rulebook_educational.for_pills.R

internal open class CustomThemeEngineDelegateImplBase(
        private val activity: Activity,
        private val customThemeEngine: CustomThemeEngine,
        @StyleRes private var themeResId: Int
) : CustomThemeEngineDelegate() {

  private val timestamp = customThemeEngine.timestamp

  override fun wrap(newBase: Context): Context {
    return CustomThemeEngineContextWrapper(newBase, getDecorators(), getViewFactory())
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    if (customThemeEngine.isThemeModified && getThemeResId() != 0) {
      activity.setTheme(themeResId)
    }
    if (customThemeEngine.isThemeModified) {
      //TODO
    } else {
      // We use a transparent primary dark color so the library user
      // is not required to specify a color value for customthemeengine_default_primary_dark
      // If the theme is using the transparent (fake) primary dark color, we need
      // to update the status bar background with the auto-generated primary
      // dark color.
      val defaultPrimaryDark = CustomThemeEngine.getOriginalColor(R.color.app_rulebook_theme)
      val realPrimaryDark = CustomThemeEngine.getOriginalColor(R.color.app_rulebook_theme)
    }
  }

  override fun onPostCreate(savedInstanceState: Bundle?) {
    if (customThemeEngine.isThemeModified) {
      val ta = activity.obtainStyledAttributes(intArrayOf(android.R.attr.windowIsTranslucent))
      try {
        val isTranslucent = ta.getBoolean(0, false)
        if (!isTranslucent) {
          activity.window.setBackgroundDrawable(ColorDrawable(customThemeEngine.backgroundColor))
        }
      } finally {
        ta.recycle()
      }
    }
  }

  override fun onStart() {
    if (customThemeEngine.isThemeModified) {
      EdgeEffectTint(activity).tint(customThemeEngine.primary)
      MenuTint.forceOverflow(activity)
    }
  }

  override fun onResume() {
    if (timestamp != customThemeEngine.timestamp) {
      recreateActivity()
      if (activity is CustomThemeEngine.ThemeModifiedListener) {
        activity.onThemeModified()
      }
    }
  }

  override fun getViewFactory(): CustomThemeEngineViewFactory {
    val processors = getViewProcessors()
    return CustomThemeEngineViewFactory(customThemeEngine, *processors)
  }

  override fun getViewProcessors(): Array<CustomThemeEngineViewProcessor<View>> {
    val processors = mutableListOf<CustomThemeEngineViewProcessor<View>>()
    // Add processors needed for tinting
    if (customThemeEngine.isThemeModified) {
      processors.addAll(getProcessorsForTheming().filterIsInstance<CustomThemeEngineViewProcessor<View>>())
    }
    // Add processors from application
    ((activity.application ?: CustomThemeEngine.app) as? CustomThemeEngineViewProcessor.Provider)?.let { provider ->
      processors.addAll(provider.getViewProcessors().filterIsInstance<CustomThemeEngineViewProcessor<View>>())
    }
    // Add processors from activity
    (activity as? CustomThemeEngineViewProcessor.Provider)?.let { provider ->
      processors.addAll(provider.getViewProcessors().filterIsInstance<CustomThemeEngineViewProcessor<View>>())
    }
    return processors.toTypedArray()
  }

  override fun getDecorators(): Array<CustomThemeEngineDecorator> {
    val decorators = mutableListOf<CustomThemeEngineDecorator>()

    // Add decorators from activity
    if (activity is CustomThemeEngineDecorator.Provider) {
      activity.getDecorators().forEach { decorators.add(it) }
    }

    // Add decorators from application
    ((activity.application ?: CustomThemeEngine.app) as? CustomThemeEngineDecorator.Provider)?.apply {
      this.getDecorators().forEach { decorators.add(it) }
    }

    return decorators.toTypedArray()
  }

  protected open fun recreateActivity() = activity.recreate()

  protected open fun getProcessorsForTheming(): List<CustomThemeEngineViewProcessor<out View>> {
    return arrayListOf(
        ListMenuItemViewProcessor(),
        AlertDialogProcessor(),
        TextViewProcessor(),
        BottomAppBarProcessor(),
        FloatingActionButtonProcessor(),
        TextInputLayoutProcessor(),
        NavigationViewProcessor()
    )
  }

  @StyleRes override fun getThemeResId(): Int {
    if (themeResId == 0) {
      activity.theme?.obtainStyledAttributes(intArrayOf(R.attr.windowActionBar))?.let { styledAttrs ->
        val windowActionBar = styledAttrs.getBoolean(0, true)
        themeResId = if (windowActionBar) {
          customThemeEngine.themes.actionBarTheme
        } else {
          customThemeEngine.themes.noActionBarTheme
        }
      } ?: run {
        CustomThemeEngine.log(TAG, "Error getting styled attribute: 'windowActionBar'")
      }
    }
    return themeResId
  }

  companion object {
    private const val TAG = "CustomThemeEngineDelegateImplBase"
  }
}

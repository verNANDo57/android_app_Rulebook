package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.getKey
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection
import com.verNANDo57.rulebook_educational.extradata.R

@RequiresApi(Build.VERSION_CODES.N)
@TargetApi(Build.VERSION_CODES.N)
internal open class CustomThemeEngineDelegateImplV24(
        private val activity: Activity,
        private val customThemeEngine: CustomThemeEngine,
        themeResId: Int
) : CustomThemeEngineDelegateImplV23(activity, customThemeEngine, themeResId) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (customThemeEngine.isThemeModified) {
      preloadColors()
    }
  }

  @SuppressLint("PrivateApi")
  private fun preloadColors() {
    try {
      val klass = Class.forName("android.content.res.ColorStateList\$ColorStateListFactory")
      val constructor = klass.getConstructor(ColorStateList::class.java).apply {
        if (!isAccessible) isAccessible = true
      }

      val mResourcesImpl = Reflection.getFieldValue<Any?>(activity.resources, "mResourcesImpl") ?: return
      val cache = Reflection.getFieldValue<Any?>(mResourcesImpl, "sPreloadedComplexColors") ?: return
      val method = Reflection.getMethod(cache, "put", Long::class.java, Object::class.java) ?: return

      for ((id, color) in hashMapOf<Int, Int>().apply {
        put(R.color.coloraccent, customThemeEngine.accent)
        put(R.color.bottomappbar_items_color_everytheme, customThemeEngine.bottomAppBarItemColor)
        put(R.color.styleable_toast_default_background_color, customThemeEngine.backgroundToast)
        put(R.color.styleable_toast_default_text_color_reference, customThemeEngine.primary)
        put(R.color.styleable_toast_default_accent_color, customThemeEngine.accentToast)
        put(R.color.button_color, customThemeEngine.buttonStrokeColor)
        put(R.color.bottomsheetdialog_accent, customThemeEngine.bottomSheetDialogAccent)
        put(R.color.bottomsheetdialog_primary, customThemeEngine.bottomSheetDialogPrimary)
        put(R.color.bottomsheetdialog_background, customThemeEngine.bottomSheetDialogBackground)
      }) {
        constructor.newInstance(ColorStateList.valueOf(color))?.let { factory ->
          val key = activity.resources.getKey(id)
          method.invoke(cache, key, factory)
        }
      }
    } catch (ex: Throwable) {
      CustomThemeEngine.log(TAG, "Error preloading colors", ex)
    }
  }

  companion object {
    private const val TAG = "RULEBOOK_APP_CustomThemeEngineDelegateImplV24"
  }
}

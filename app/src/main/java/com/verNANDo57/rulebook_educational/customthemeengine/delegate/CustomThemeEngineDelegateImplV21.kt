package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import android.annotation.TargetApi
import android.app.Activity
import android.app.ActivityManager
import android.content.ComponentName
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.getKey
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection.Companion.getFieldValue
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection.Companion.getMethod
import com.verNANDo57.rulebook_educational.for_pills.R

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
internal open class CustomThemeEngineDelegateImplV21(
        private val activity: Activity,
        private val customThemeEngine: CustomThemeEngine,
        themeResId: Int
) : CustomThemeEngineDelegateImplBase(activity, customThemeEngine, themeResId) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (customThemeEngine.isThemeModified) {
      when (Build.VERSION.SDK_INT) {
        Build.VERSION_CODES.LOLLIPOP,
        Build.VERSION_CODES.LOLLIPOP_MR1 -> {
          preloadColors()
        }
      }
    }
  }

  override fun onStart() {
    // Do not call super
    if (customThemeEngine.isThemeModified) {
      // Set the task description with our custom primary color
      setTaskDescription()
    }
  }

  private fun setTaskDescription() {
    try {
      val color = ColorUtils.stripAlpha(customThemeEngine.primary)
      val componentName = ComponentName(activity, activity::class.java)
      activity.packageManager.getActivityInfo(componentName, 0)
        .iconResource.takeIf { it != 0 }?.let { iconRes ->
          val td = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ActivityManager.TaskDescription(activity.title.toString(), iconRes, color)
          } else {
            val icon = BitmapFactory.decodeResource(activity.resources, iconRes) ?: return
            @Suppress("DEPRECATION")
            ActivityManager.TaskDescription(activity.title.toString(), icon, color)
          }
          activity.setTaskDescription(td)
        } ?: run {
        val icon = activity.packageManager.getApplicationIcon(activity.packageName)
        (icon as? BitmapDrawable)?.bitmap?.let { bitmap ->
          @Suppress("DEPRECATION")
          val td = ActivityManager.TaskDescription(activity.title.toString(), bitmap, color)
          activity.setTaskDescription(td)
        }
      }
    } catch (ignored: PackageManager.NameNotFoundException) {
    }
  }

  private fun preloadColors() {
    try {
      val cache = getFieldValue<Any?>(activity.resources, "sPreloadedColorStateLists") ?: return
      val method = getMethod(cache, "put", Long::class.java, Object::class.java) ?: return
      for ((id, color) in hashMapOf<Int, Int>().apply {
        put(R.color.coloraccent, customThemeEngine.accent)
        put(R.color.styleable_toast_default_text_color_reference, customThemeEngine.primary)
        put(R.color.bottomappbar_items_color_everytheme, customThemeEngine.bottomAppBarItemColor)
        put(R.color.styleable_toast_default_background_color, customThemeEngine.backgroundToast)
        put(R.color.styleable_toast_default_accent_color, customThemeEngine.accentToast)
        put(R.color.button_color, customThemeEngine.buttonStrokeColor)
        put(R.color.bottomsheetdialog_accent, customThemeEngine.bottomSheetDialogAccent)
        put(R.color.bottomsheetdialog_primary, customThemeEngine.bottomSheetDialogPrimary)
        put(R.color.bottomsheetdialog_background, customThemeEngine.bottomSheetDialogBackground)
      }) {
        val csl = ColorStateList.valueOf(color)
        val key = activity.resources.getKey(id)
        method.invoke(cache, key, csl)
      }
    } catch (ex: Throwable) {
      CustomThemeEngine.log(TAG, "Error preloading colors", ex)
    }
  }

  companion object {
    private const val TAG = "RULEBOOK_APP_CustomThemeEngineDelegateImplV21"
  }
}

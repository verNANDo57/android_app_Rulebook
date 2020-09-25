package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import android.annotation.TargetApi
import android.app.Activity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.for_pills.R

@RequiresApi(Build_VERSION_CODES_Q)
@TargetApi(Build_VERSION_CODES_Q)
internal open class CustomThemeEngineDelegateImplV29(
        activity: Activity,
        private val customThemeEngine: CustomThemeEngine,
        themeResId: Int
) : CustomThemeEngineDelegateImplV26(activity, customThemeEngine, themeResId) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (!customThemeEngine.isThemeModified) {
      val defaultPrimaryDark = CustomThemeEngine.getOriginalColor(R.color.app_rulebook_theme)
      val realPrimaryDark = CustomThemeEngine.getOriginalColor(R.color.app_rulebook_theme)
    }
  }
}

package com.verNANDo57.rulebook_educational.customthemeengine.delegate

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine

@RequiresApi(Build.VERSION_CODES.O)
@TargetApi(Build.VERSION_CODES.O)
internal open class CustomThemeEngineDelegateImplV26(
        private val activity: Activity,
        customThemeEngine: CustomThemeEngine,
        themeResId: Int
) : CustomThemeEngineDelegateImplV24(activity, customThemeEngine, themeResId) {

  companion object {
    private const val TAG = "RULEBOOK_APP_CustomThemeEngineDelegateImplV26"
  }
}

package com.verNANDo57.rulebook_educational.customthemeengine.app

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine

/**
 * Base class for BottomSheetDialogFragments[BottomSheetDialogFragment] that use [CustomThemeEngine] for dynamic themes.
 */
open class CustomThemeEngineBottomSheetDialogFragment : BottomSheetDialogFragment() {
    /**
     * The [CustomThemeEngine] instance used for styling.
     */
    open val customThemeEngine: CustomThemeEngine get() = (activity as? BaseCustomThemeEngineActivity)?.customThemeEngine ?: CustomThemeEngine.INSTANCE
}
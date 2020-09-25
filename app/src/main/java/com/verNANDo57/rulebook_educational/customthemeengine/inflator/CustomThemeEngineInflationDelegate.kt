package com.verNANDo57.rulebook_educational.customthemeengine.inflator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine

/**
 * Hook to create custom views at inflation time.
 *
 * @see CustomThemeEngine.setInflationDelegate
 */

interface CustomThemeEngineInflationDelegate {

  /**
   * Hook you can supply that is called when inflating from a [CustomThemeEngineLayoutInflater].
   *
   * @param parent The parent that the created view will be placed in; <em>note that this may be null</em>.
   * @param name Tag name to be inflated.
   * @param context The context the view is being created in.
   * @param attrs Inflation attributes as specified in XML file.
   * @return Newly created view. Return null for the default behavior.
   */

  fun createView(parent: View?, name: String, context: Context, attrs: AttributeSet): View?
}

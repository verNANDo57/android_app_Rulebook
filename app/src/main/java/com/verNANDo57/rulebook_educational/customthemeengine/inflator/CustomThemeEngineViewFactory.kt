package com.verNANDo57.rulebook_educational.customthemeengine.inflator

import android.util.AttributeSet
import android.view.View
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import java.util.*

class CustomThemeEngineViewFactory(val customThemeEngine: CustomThemeEngine, vararg processors: CustomThemeEngineViewProcessor<View>) {

  private val processors = hashSetOf<CustomThemeEngineViewProcessor<View>>()

  init {
    Collections.addAll(this.processors, *processors)
  }

  fun onViewCreated(view: View, attrs: AttributeSet): View {
    for (processor in processors) {
      try {
        if (processor.shouldProcessView(view)) {
          processor.process(view, attrs, customThemeEngine)
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error processing view", e)
      }
    }
    return view
  }

  companion object {
    private const val TAG = "RULEBOOK_APP_CustomThemeEngineViewFactory"
  }
}

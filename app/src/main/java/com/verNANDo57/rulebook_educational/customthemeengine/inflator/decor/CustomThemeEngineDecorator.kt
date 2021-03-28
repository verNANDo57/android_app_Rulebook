package com.verNANDo57.rulebook_educational.customthemeengine.inflator.decor

import android.util.AttributeSet
import android.view.View

interface CustomThemeEngineDecorator {

  fun apply(view: View, attrs: AttributeSet)

  interface Provider {
    fun getDecorators(): Array<CustomThemeEngineDecorator>
  }
}

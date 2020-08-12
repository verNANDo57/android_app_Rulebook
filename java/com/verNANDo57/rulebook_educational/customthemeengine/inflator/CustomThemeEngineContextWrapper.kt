package com.verNANDo57.rulebook_educational.customthemeengine.inflator

import android.content.Context
import android.content.ContextWrapper
import com.verNANDo57.rulebook_educational.customthemeengine.inflator.decor.CustomThemeEngineDecorator

class CustomThemeEngineContextWrapper(
        context: Context,
        private val decorators: Array<CustomThemeEngineDecorator>? = null,
        private val viewFactory: CustomThemeEngineViewFactory? = null
) :
  ContextWrapper(context) {

  private val inflater: CustomThemeEngineLayoutInflater by lazy {
    CustomThemeEngineLayoutInflater(this).apply {
      this.decorators = this@CustomThemeEngineContextWrapper.decorators
      this.viewFactory = this@CustomThemeEngineContextWrapper.viewFactory
    }
  }

  override fun getSystemService(name: String): Any? = when (name) {
    LAYOUT_INFLATER_SERVICE -> inflater
    else -> super.getSystemService(name)
  }
}

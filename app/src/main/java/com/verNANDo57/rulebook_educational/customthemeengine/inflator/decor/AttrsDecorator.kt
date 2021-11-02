package com.verNANDo57.rulebook_educational.customthemeengine.inflator.decor

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

abstract class AttrsDecorator<T : View> : CustomThemeEngineDecorator {

  override fun apply(view: View, attrs: AttributeSet) {
    if (getType().isAssignableFrom(view.javaClass)) {
      val values = obtainAttributes(view.context, attrs)
      values?.let {
        try {
          for (i in 0 until values.length()) {
            val buf = TypedValue()
            if (it.hasValue(i) && it.getValue(i, buf)) {
              @Suppress("UNCHECKED_CAST")
              apply(view as T, it)
              break
            }
          }
        } finally {
          it.recycle()
        }
      }
    }
  }

  protected abstract fun apply(view: T, typedArray: TypedArray)

  protected abstract fun getType(): Class<T>

  protected abstract fun styleable(): IntArray

  @Suppress("MemberVisibilityCanBePrivate")
  protected fun defStyleAttr(): Int = 0

  @Suppress("MemberVisibilityCanBePrivate")
  protected fun defStyleRes(): Int = 0

  @Suppress("MemberVisibilityCanBePrivate")
  protected fun obtainAttributes(context: Context, attributeSet: AttributeSet): TypedArray =
      context.theme.obtainStyledAttributes(attributeSet, styleable(), defStyleAttr(), defStyleRes())
}

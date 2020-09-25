package com.verNANDo57.rulebook_educational.customthemeengine.tinting

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorFilterCompat
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection


class WidgetTint private constructor() {

  init {
    throw AssertionError("no instances")
  }

  companion object {

    private const val TAG = "WidgetTint"

    fun setFastScrollThumbColor(listView: AbsListView, @ColorInt color: Int) {
      try {
        val name = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) "mFastScroll" else "mFastScroller"
        val scroller = Reflection.getFieldValue<Any?>(listView, name)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
          Reflection.getFieldValue<ImageView?>(scroller, "mThumbImage")
            ?.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        } else {
          Reflection.getFieldValue<Drawable?>(scroller, "mThumbDrawable")
            ?.colorFilter = ColorFilterCompat.SRC_ATOP.get(color)
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error tinting the fast scroll thumb", e)
      }
    }

    fun setCursorColor(textView: TextView, @ColorInt color: Int) {
      try {
        Reflection.getField(TextView::class.java, "mCursorDrawableRes")?.let { fCursorDrawableRes ->
          Reflection.getField(TextView::class.java, "mEditor")?.let { fEditor ->
            fEditor.get(textView)?.let { editor ->
              Reflection.getField(editor, "mCursorDrawable")?.let { fCursorDrawable ->
                val cursorDrawableRes = fCursorDrawableRes.getInt(textView)
                ContextCompat.getDrawable(textView.context, cursorDrawableRes)?.let { drawable ->
                  @Suppress("DEPRECATION")
                  drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                  val drawables = arrayOf(drawable, drawable)
                  fCursorDrawable.set(editor, drawables)
                }
              }
            }
          }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting cursor color", e)
      }
    }
  }
}

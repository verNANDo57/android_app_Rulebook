package com.verNANDo57.rulebook_educational.customthemeengine.tinting

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.AbsListView
import android.widget.EdgeEffect
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.annotation.ColorInt
import androidx.core.widget.EdgeEffectCompat
import androidx.core.widget.NestedScrollView
import androidx.viewpager.widget.ViewPager
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorFilterCompat
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection

class EdgeEffectTint(private val view: ViewGroup) {

  constructor(activity: Activity) : this(
    activity.findViewById<View>(android.R.id.content).rootView as ViewGroup
  )

  fun tint(@ColorInt color: Int) = setEdgeTint(view, color)

  private fun setEdgeTint(viewGroup: ViewGroup, @ColorInt color: Int) {
    for (i in 0 until viewGroup.childCount) {
      viewGroup.getChildAt(i)?.let { child ->
        if (!setEdgeGlowColor(child, color) && child is ViewGroup) {
          setEdgeTint(child, color)
        }
      }
    }
  }

  companion object {

    private const val TAG = "RULEBOOK_APP_EdgeEffectTint"

    @JvmStatic
    fun setEdgeEffectColor(edgeEffect: EdgeEffect, @ColorInt color: Int) {
      try {
        edgeEffect.color = color
        for (name in arrayOf("mEdge", "mGlow")) {
          Reflection.getFieldValue<Drawable?>(edgeEffect, name)?.run {
            colorFilter = ColorFilterCompat.SRC_IN.get(color)
            callback = null // free up any references
          }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting edge effect color", e)
      }
    }

    fun setEdgeGlowColor(view: View, @ColorInt color: Int): Boolean {
      when (view) {
        is AbsListView -> setEdgeGlowColor(view, color)
        is HorizontalScrollView -> setEdgeGlowColor(view, color)
        is ScrollView -> setEdgeGlowColor(view, color)
        is NestedScrollView -> setEdgeGlowColor(view, color)
        is ViewPager -> setEdgeGlowColor(view, color)
        is WebView -> setEdgeGlowColor(view, color)
        else -> return false
      }
      return true
    }

    private fun setEdgeGlowColor(scrollView: NestedScrollView, @ColorInt color: Int) {
      try {
        Reflection.invoke<Any?>(scrollView, "ensureGlows")
        for (name in arrayOf("mEdgeGlowTop", "mEdgeGlowBottom")) {
          Reflection.getFieldValue<Any?>(scrollView, name)?.let { value ->
            if (value is EdgeEffect) {
              setEdgeEffectColor(value, color)
            } else if (value is EdgeEffectCompat) {
              Reflection.getFieldValue<EdgeEffect?>(value, "mEdgeEffect")?.let { edgeEffect ->
                setEdgeEffectColor(edgeEffect, color)
              }
            }
          }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting edge glow color on NestedScrollView", e)
      }
    }


    private fun setEdgeGlowColor(listView: AbsListView, @ColorInt color: Int) {
      try {
        for (name in arrayOf("mEdgeGlowTop", "mEdgeGlowBottom")) {
          Reflection.getFieldValue<EdgeEffect?>(listView, name)?.let { edgeEffect ->
            setEdgeEffectColor(edgeEffect, color)
          }
        }
      } catch (ignored: Exception) {
      }
    }

    private fun setEdgeGlowColor(hsv: HorizontalScrollView, @ColorInt color: Int) {
      try {
        for (name in arrayOf("mEdgeGlowLeft", "mEdgeGlowRight")) {
          val edgeEffect = Reflection.getFieldValue<EdgeEffect?>(hsv, name)
          edgeEffect?.let { setEdgeEffectColor(it, color) }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting edge glow color on HorizontalScrollView", e)
      }
    }


    private fun setEdgeGlowColor(scrollView: ScrollView, color: Int) {
      try {
        for (name in arrayOf("mEdgeGlowTop", "mEdgeGlowBottom")) {
          val edgeEffect = Reflection.getFieldValue<EdgeEffect?>(scrollView, name)
          edgeEffect?.let { setEdgeEffectColor(it, color) }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting edge glow color on ScrollView", e)
      }
    }


    private fun setEdgeGlowColor(viewPager: ViewPager, color: Int) {
      try {
        for (name in arrayOf("mLeftEdge", "mRightEdge")) {
          Reflection.getFieldValue<Any?>(viewPager, name)?.let { value ->
            if (value is EdgeEffect) {
              setEdgeEffectColor(value, color)
            } else if (value is EdgeEffectCompat) {
              Reflection.getFieldValue<EdgeEffect?>(value, "mEdgeEffect")?.let { edgeEffect ->
                setEdgeEffectColor(edgeEffect, color)
              }
            }
          }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting edge glow color on ViewPager", e)
      }
    }

    private fun setEdgeGlowColor(webView: WebView, color: Int) {
      try {
        val provider = Reflection.invoke<Any?>(webView, "getWebViewProvider")
        val delegate = Reflection.invoke<Any?>(provider, "getViewDelegate")
        val mAwContents = Reflection.getFieldValue<Any?>(delegate, "mAwContents")
        val mOverScrollGlow = Reflection.getFieldValue<Any?>(mAwContents, "mOverScrollGlow")
        val names = arrayOf("mEdgeGlowTop", "mEdgeGlowBottom", "mEdgeGlowLeft", "mEdgeGlowRight")
        for (name in names) {
          Reflection.getFieldValue<EdgeEffect?>(mOverScrollGlow, name)?.let {
            setEdgeEffectColor(it, color)
          }
        }
      } catch (e: Exception) {
        CustomThemeEngine.log(TAG, "Error setting edge glow color on WebView", e)
      }
    }
  }
}

package com.verNANDo57.rulebook_educational.customthemeengine.inflator

import android.R.attr
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.appcompat.widget.AlertDialogLayout
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.appcompat.widget.SearchView.SearchAutoComplete
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputLayout
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.tinting.EdgeEffectTint
import com.verNANDo57.rulebook_educational.customthemeengine.tinting.WidgetTint
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection
import com.verNANDo57.rulebook_educational.for_pills.R

abstract class CustomThemeEngineViewProcessor<T : View> {

  abstract fun process(view: T, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine)

  open fun shouldProcessView(view: View) = getType().isInstance(view)

  protected abstract fun getType(): Class<T>

  interface Provider {

    fun getViewProcessors(): Array<CustomThemeEngineViewProcessor<out View>>
  }
}

// ================================================================================================
// Processors

internal class AlertDialogProcessor : CustomThemeEngineViewProcessor<View>() {

  override fun getType(): Class<View> = View::class.java

  override fun shouldProcessView(view: View): Boolean = view is AlertDialogLayout || CLASS_NAME == view.javaClass.name

  override fun process(view: View, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    view.setBackgroundColor(customThemeEngine.backgroundColor) // Theme AlertDialog background
  }

  companion object {
    private const val CLASS_NAME = "com.android.internal.widget.AlertDialogLayout"
  }
}

internal class BottomAppBarProcessor : CustomThemeEngineViewProcessor<BottomAppBar>() {

  override fun getType(): Class<BottomAppBar> = BottomAppBar::class.java

  override fun process(view: BottomAppBar, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    view.backgroundTint?.let { view.backgroundTint = customThemeEngine.tinter.tint(it) }
    view.post {
      view.context?.let { context ->
        (context as? Activity)?.run {
          //TODO
        } ?: ((context as? ContextWrapper)?.baseContext as? Activity)?.run {
          //TODO
        }
      }
    }
  }
}

@RequiresApi(Build.VERSION_CODES.M)
internal class CompoundButtonProcessor : CustomThemeEngineViewProcessor<CompoundButton>() {

  override fun getType(): Class<CompoundButton> = CompoundButton::class.java

  @SuppressLint("PrivateResource")
  override fun process(view: CompoundButton, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    view.buttonTintList?.let { customThemeEngine.tinter.tint(it) } ?: run {
      view.buttonTintList = customThemeEngine.tinter.tint(
          view.context.getColorStateList(R.color.abc_tint_btn_checkable)
      )
    }
    val background = view.background
    if (background is RippleDrawable) {
      val resid = if (customThemeEngine.isDark) R.color.ripple_material_dark else R.color.ripple_material_light
      val unchecked = ContextCompat.getColor(view.context, resid)
      val checked = ColorUtils.adjustAlpha(customThemeEngine.accent, 0.4f)
      val csl = ColorStateList(
          arrayOf(
              intArrayOf(-attr.state_activated, -attr.state_checked),
              intArrayOf(attr.state_activated),
              intArrayOf(attr.state_checked)
          ),
          intArrayOf(unchecked, checked, checked)
      )
      background.setColor(csl)
    }
  }
}

internal class DatePickerProcessor : CustomThemeEngineViewProcessor<DatePicker>() {

  override fun getType(): Class<DatePicker> = DatePicker::class.java

  override fun process(view: DatePicker, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    val datePickerId = view.context.resources.getIdentifier("date_picker_header", "id", "android")
    if (datePickerId != 0) {
      view.findViewById<ViewGroup>(datePickerId)?.let { layout ->
        customThemeEngine.tinter.tint(layout.background)
        if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
          customThemeEngine.tinter.tint(layout.backgroundTintList)
        }
      }
    }
  }
}

internal class FloatingActionButtonProcessor : CustomThemeEngineViewProcessor<FloatingActionButton>() {

  override fun getType(): Class<FloatingActionButton> = FloatingActionButton::class.java

  override fun process(view: FloatingActionButton, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    customThemeEngine.tinter.tint(view.backgroundTintList)
  }
}

@TargetApi(Build.VERSION_CODES.M)
internal class ImageButtonProcessor : CustomThemeEngineViewProcessor<ImageButton>() {

  override fun getType(): Class<ImageButton> = ImageButton::class.java

  override fun process(view: ImageButton, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    customThemeEngine.tinter.tint(view.background)
  }
}

/**
 * Style menu items
 */
internal class ListMenuItemViewProcessor : CustomThemeEngineViewProcessor<View>() {

  override fun getType(): Class<View> = View::class.java

  override fun shouldProcessView(view: View): Boolean = view is ListMenuItemView || view.javaClass.name == CLASS_NAME

  override fun process(view: View, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    customThemeEngine.tinter.tint(view)
  }

  companion object {
    private const val CLASS_NAME = "com.android.internal.view.menu.ListMenuItemView"
  }
}

internal class NavigationViewProcessor : CustomThemeEngineViewProcessor<NavigationView>() {

  override fun getType(): Class<NavigationView> = NavigationView::class.java

  override fun process(view: NavigationView, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    val baseColor = if (customThemeEngine.isDark) Color.WHITE else Color.BLACK
    val unselectedTextColor = ColorUtils.adjustAlpha(baseColor, 0.87f)
    val unselectedIconColor = ColorUtils.adjustAlpha(baseColor, 0.54f)
    val checkedColor = customThemeEngine.accent

    view.apply {
      itemTextColor = ColorStateList(
          arrayOf(
              intArrayOf(-android.R.attr.state_checked),
              intArrayOf(android.R.attr.state_checked)
          ),
          intArrayOf(unselectedTextColor, checkedColor)
      )
      itemIconTintList = ColorStateList(
          arrayOf(
              intArrayOf(-android.R.attr.state_checked),
              intArrayOf(android.R.attr.state_checked)
          ),
          intArrayOf(unselectedIconColor, checkedColor)
      )
    }
  }
}

@TargetApi(Build.VERSION_CODES.M)
internal class SearchAutoCompleteProcessor : CustomThemeEngineViewProcessor<SearchAutoComplete>() {

  override fun getType(): Class<SearchAutoComplete> = SearchAutoComplete::class.java

  override fun process(view: SearchAutoComplete, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    WidgetTint.setCursorColor(view, customThemeEngine.accent)
  }
}

@TargetApi(Build.VERSION_CODES.M)
internal class SwitchProcessor : CustomThemeEngineViewProcessor<Switch>() {

  override fun getType(): Class<Switch> = Switch::class.java

  @SuppressLint("PrivateResource")
  override fun process(view: Switch, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      customThemeEngine.tinter.tint(view.thumbDrawable)
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      view.trackTintList = ContextCompat.getColorStateList(view.context, R.color.abc_tint_switch_track)
    }
  }
}

internal class SwitchCompatProcessor : CustomThemeEngineViewProcessor<SwitchCompat>() {

  override fun getType(): Class<SwitchCompat> = SwitchCompat::class.java

  @SuppressLint("RestrictedApi", "PrivateResource")
  override fun process(view: SwitchCompat, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    // SwitchCompat sets a ColorStateList on the drawable. Here, we get and modify the tint.
    val manager = AppCompatDrawableManager.get()
    Reflection.invoke<ColorStateList>(manager, "getTintList",
        arrayOf(Context::class.java, Int::class.java),
        view.context,
        androidx.appcompat.R.drawable.abc_switch_thumb_material
    )?.let { csl ->
      customThemeEngine.tinter.tint(csl)
    }
  }
}

internal class TextInputLayoutProcessor : CustomThemeEngineViewProcessor<TextInputLayout>() {

  override fun getType(): Class<TextInputLayout> = TextInputLayout::class.java

  override fun process(view: TextInputLayout, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    if (view.boxStrokeColor == CustomThemeEngine.getOriginalColor(R.color.coloraccent_reference)) {
      view.boxStrokeColor = customThemeEngine.accent
    }
    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
      Reflection.getFieldValue<ColorStateList?>(view, "focusedTextColor")?.let { csl ->
        customThemeEngine.tinter.tint(csl)
      }
    }
  }
}

internal class TextViewProcessor : CustomThemeEngineViewProcessor<TextView>() {

  override fun getType(): Class<TextView> = TextView::class.java

  override fun process(view: TextView, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    view.textColors?.let { colors ->
      view.setTextColor(customThemeEngine.tinter.tint(colors))
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      customThemeEngine.tinter.tint(view.backgroundTintList)
    }
    customThemeEngine.tinter.tint(view.background)
  }
}

internal class TimePickerProcessor : CustomThemeEngineViewProcessor<TimePicker>() {

  override fun getType(): Class<TimePicker> = TimePicker::class.java

  override fun process(view: TimePicker, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    customThemeEngine.tinter.tint(view)
  }
}

@TargetApi(Build.VERSION_CODES.M)
internal class ViewGroupProcessor : CustomThemeEngineViewProcessor<ViewGroup>() {

  override fun getType(): Class<ViewGroup> = ViewGroup::class.java

  override fun process(view: ViewGroup, attrs: AttributeSet?, customThemeEngine: CustomThemeEngine) {
    EdgeEffectTint.setEdgeGlowColor(view, customThemeEngine.primary)
    customThemeEngine.tinter.tint(view.background)
    if (view is AbsListView) {
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.accent)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.primary)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.bottomAppBarItemColor)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.backgroundToast)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.accentToast)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.buttonStrokeColor)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.bottomSheetDialogAccent)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.bottomSheetDialogPrimary)
      WidgetTint.setFastScrollThumbColor(view, customThemeEngine.bottomSheetDialogBackground)
    }
  }
}

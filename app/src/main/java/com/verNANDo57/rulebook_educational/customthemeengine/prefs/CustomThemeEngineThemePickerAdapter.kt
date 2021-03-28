package com.verNANDo57.rulebook_educational.customthemeengine.prefs

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils
import com.verNANDo57.rulebook_educational.for_pills.R

/**
 * Adapter for items in the theme picker
 */
class CustomThemeEngineThemePickerAdapter(private val themes: List<CustomThemeEngineTheme>, private val customThemeEngine: CustomThemeEngine) : BaseAdapter() {

  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
    val holder: ViewHolder

    holder = if (convertView == null) {
      val inflater = LayoutInflater.from(parent.context)
      val view = inflater.inflate(R.layout.customthemeengine_item_theme, parent, false)
      ViewHolder(view)
    } else {
      convertView.tag as ViewHolder
    }

    val theme = themes[position]

    holder.find<FrameLayout>(R.id.preview).setBackgroundColor(theme.background)

    val fab = holder.find<FloatingActionButton>(R.id.fab_in_theme_preview)
    // Bug: when using the accent color, the last selected item's FAB is the same color as the newly selected FAB.
    // For now, slightly adjust the color.
    val fabMainColor = ColorUtils.lighter(theme.accent, 0.01f)
    fab.backgroundTintList = ColorStateList.valueOf(fabMainColor)
    fab.supportBackgroundTintList = ColorStateList.valueOf(fabMainColor)
    fab.rippleColor = theme.accent

    val title = holder.find<TextView>(R.id.title)
    title.text = theme.themeName

    val BottomAppBar = holder.find<BottomAppBar>(R.id.bar_in_theme_preview)
    val BarMainColor = ColorUtils.lighter(theme.accent, 0.01f)
    BottomAppBar.backgroundTint = ColorStateList.valueOf(BarMainColor)

    val title_preview = holder.find<TextView>(R.id.text_title)
    title_preview.setTextColor(ColorUtils.lighter(theme.accent, 0.01f))

    if (theme.isMatchingColorScheme(customThemeEngine)) {
      title.setBackgroundColor(ContextCompat.getColor(parent.context, R.color.customthemeengine_theme_selected_color))
      title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.customthemeengine_check, 0)
    } else {
      title.setBackgroundColor(ContextCompat.getColor(parent.context, R.color.customthemeengine_theme_title_bg_color))
      title.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
    }

    val isDark = ColorUtils.isDarkColor(theme.primary, 0.75)
    val menuIconColor = if (isDark) Color.WHITE else Color.BLACK
    val drawable = DrawerArrowDrawable(parent.context)
    drawable.color = menuIconColor

    return holder.itemView
  }

  override fun getItem(position: Int): CustomThemeEngineTheme = themes[position]

  override fun getItemId(position: Int): Long = position.toLong()

  override fun getCount(): Int = themes.size

  private class ViewHolder(val itemView: View) {

    private val views = SparseArray<View>()

    init {
      itemView.tag = this
    }

    fun <T : View> find(@IdRes id: Int): T {
      views[id]?.let {
        @Suppress("UNCHECKED_CAST")
        return it as T
      } ?: run {
        val view = itemView.findViewById<T>(id)
        views.put(id, view)
        return view
      }
    }
  }
}

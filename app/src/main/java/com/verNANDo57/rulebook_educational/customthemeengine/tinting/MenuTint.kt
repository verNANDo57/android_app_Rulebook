package com.verNANDo57.rulebook_educational.customthemeengine.tinting

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.Menu
import android.view.MenuItem
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.view.menu.MenuItemImpl
import androidx.appcompat.widget.ActionMenuView
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorFilterCompat
import com.verNANDo57.rulebook_educational.customthemeengine.utils.Reflection


class MenuTint(
        val menu: Menu,
        @ColorInt private var bottomAppBarIconColorReference: Int? = null,
        private var bottomAppBarIconAlpha: Int? = null,
        @DrawableRes private val overflowDrawableRes: Int? = null,
        @ColorInt private val originalMenuIconColor: Int? = null,
        private val reApplyOnChange: Boolean = false,
        private val forceIcons: Boolean = false,
        private val tintOverflowIcon: Boolean = true
) {

  private var actionBar: ViewGroup? = null

  /**
   * Sets a [android.graphics.ColorFilter] and/or alpha on all the [MenuItem]s in the menu,
   * including the OverflowMenuButton.
   *
   * Call this method after inflating/creating your menu in [Activity.onCreateOptionsMenu]
   *
   * The [activity][Activity] context
   */
  fun apply() {
    if (forceIcons) {
      forceMenuIcons(menu)
    }

    val size = menu.size()
    for (i in 0 until size) {
      val item = menu.getItem(i)
      colorMenuItem(item, bottomAppBarIconColorReference, bottomAppBarIconAlpha)
      if (reApplyOnChange) {
        item.actionView?.let {
          item.setOnActionExpandListener(ActionExpandListener())
        }
      }
    }
  }

  private fun reapply() {
    val size = menu.size()
    for (i in 0 until size) {
      val item = menu.getItem(i)
      if (isActionButton(item)) {
        colorMenuItem(item, bottomAppBarIconColorReference, bottomAppBarIconAlpha)
      }
    }

    actionBar?.post {
      for (i in 0 until size) {
        val item = menu.getItem(i)
          colorMenuItem(item, bottomAppBarIconColorReference, bottomAppBarIconAlpha)
        // Tint the overflow icon
        if (tintOverflowIcon) {
          tintOverflow()
        }
      }
    }
  }

  private fun tintOverflow() {
    findOverflowMenuButton(actionBar)?.let { overflowView ->
      overflowDrawableRes?.let { resId -> overflowView.setImageResource(resId) }
      bottomAppBarIconColorReference?.let { color -> overflowView.setColorFilter(color) }
      bottomAppBarIconAlpha?.let { alpha -> overflowView.imageAlpha = alpha
      }
    }
  }

  companion object {

    /**
     * Sets the color filter and/or the alpha transparency on a [MenuItem]'s icon.
     *
     * @param menuItem The [MenuItem] to theme.
     * @param color The color to set for the color filter or `null` for no changes.
     * @param alpha The alpha value (0...255) to set on the icon or `null` for no changes.
     */
    fun colorMenuItem(menuItem: MenuItem, color: Int?, alpha: Int? = null) {
      menuItem.icon?.mutate()?.let { drawable ->
        color?.let { drawable.colorFilter = ColorFilterCompat.SRC_IN.get(it) }
        alpha?.let { drawable.alpha = it }
        menuItem.icon = drawable
      }
    }

    /**
     * Check if an item is showing (not in the overflow menu).
     *
     * @param item The MenuItem.
     * @return `true` if the MenuItem is visible on the ActionBar.
     */
    @SuppressLint("RestrictedApi")
    fun isActionButton(item: MenuItem): Boolean {
      if (item is MenuItemImpl) {
        return item.isActionButton
      }
      return Reflection.invoke(item, "isActionButton") ?: false
    }

    /**
     * Set the menu to show MenuItem icons in the overflow window.
     *
     * @param menu The menu to force icons to show
     */
    fun forceMenuIcons(menu: Menu) {
      Reflection.invoke<Any?>(menu, "setOptionalIconsVisible",
        arrayOf(Boolean::class.javaPrimitiveType!!), true)
    }

    /**
     * Force the app to show the overflow menu. The menu button will still work, but it will open the menu in the
     * top right corner.
     *
     * See: http://stackoverflow.com/a/11438245/1048340
     *
     * @param context The current context
     */
    fun forceOverflow(context: Context) {
      val configuration = ViewConfiguration.get(context)
      Reflection.getField(configuration, "sHasPermanentMenuKey")?.set(configuration, false)
    }

    private fun findOverflowMenuButton(viewGroup: ViewGroup?): ImageView? {
      if (viewGroup == null) return null
      var i = 0
      val count = viewGroup.childCount
      while (i < count) {
        val view = viewGroup.getChildAt(i)
        if (view is ImageView &&
          (view.javaClass.simpleName == "OverflowMenuButton" ||
            view is ActionMenuView.ActionMenuChildView)) {
          return view
        } else if (view is ViewGroup) {
          findOverflowMenuButton(view)?.let { btn -> return btn }
        }
        i++
      }
      return null
    }


  }

  inner class ActionExpandListener : MenuItem.OnActionExpandListener {
    override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
      val color = originalMenuIconColor ?: bottomAppBarIconColorReference
      bottomAppBarIconColorReference = color
      reapply()
      return true
    }

    override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
      val color = originalMenuIconColor ?: bottomAppBarIconColorReference
      bottomAppBarIconColorReference = color
      reapply()
      return true
    }
  }
}

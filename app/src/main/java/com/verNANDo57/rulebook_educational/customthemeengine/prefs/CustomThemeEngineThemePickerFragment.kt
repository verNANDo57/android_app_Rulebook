package com.verNANDo57.rulebook_educational.customthemeengine.prefs

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import com.verNANDo57.rulebook_educational.customthemeengine.CustomThemeEngine
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineFragment
import com.verNANDo57.rulebook_educational.extradata.R

/**
 * Fragment containing the theme picker
 */
open class CustomThemeEngineThemePickerFragment : CustomThemeEngineFragment(), OnItemClickListener {

  open val themesJsonAssetPath get() = "themes/custom_themes.json"

  private lateinit var gridView: GridView

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.customthemeengine_theme_picker, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    gridView = view.findViewById(R.id.gridView)
    val themes = CustomThemeEngineTheme.from(requireActivity().assets, themesJsonAssetPath)
    gridView.adapter = CustomThemeEngineThemePickerAdapter(themes, customThemeEngine)
    gridView.onItemClickListener = this
    scrollToCurrentTheme(themes)
  }

  override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    val theme = (gridView.adapter as CustomThemeEngineThemePickerAdapter).getItem(position)
    val themeName = theme.themeName
    CustomThemeEngine.log(TAG, "Clicked $themeName")
    theme.apply(customThemeEngine).recreate(requireActivity(), smooth = true)
  }

  private fun scrollToCurrentTheme(themes: List<CustomThemeEngineTheme>) {
    var selectedTheme = -1
    run {
      themes.forEachIndexed { index, theme ->
        if (theme.isMatchingColorScheme(customThemeEngine)) {
          selectedTheme = index
          return@run
        }
      }
    }
    if (selectedTheme != -1) {
      gridView.post {
        if (selectedTheme < gridView.firstVisiblePosition || selectedTheme > gridView.lastVisiblePosition) {
          gridView.setSelection(selectedTheme)
        }
      }
    }
  }

  companion object {
    private const val TAG = "RULEBOOK_APP_ThemePickerFragment"

    fun newInstance() = CustomThemeEngineThemePickerFragment()
  }
}

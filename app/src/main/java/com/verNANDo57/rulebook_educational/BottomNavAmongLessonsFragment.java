/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.bookmarks.AppBookmarksActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.AppSettingsActivity;
import com.verNANDo57.rulebook_educational.rules.AppAnalyzeMethods;
import com.verNANDo57.rulebook_educational.rules.AppLexiconActivity;
import com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity;
import com.verNANDo57.rulebook_educational.search.AppSearchActivity;

public class BottomNavAmongLessonsFragment extends BottomSheetDialogFragment {

    public BottomNavAmongLessonsFragment(){
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_navigationview_content, container, false);

        NavigationView navigation_among_activities = viewFragment.findViewById(R.id.navigation_view);

        // Clear and inflate menu from resource
        navigation_among_activities.getMenu().clear();
        navigation_among_activities.inflateMenu(R.menu.bottom_nav_drawer_menu_among_fragments);

        // Set onClickListener
        navigation_among_activities.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            String className = requireActivity().getClass().getName();

            if (id == R.id.bottomsheetdialog_amonglessons_mainrules) {
                if (!(className.equals(AppMainRulesActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppMainRulesActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_lexicon) {
                if (!(className.equals(AppLexiconActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppLexiconActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_schemesandtables) {
                if (!(className.equals(AppRulesInSchemesAndTablesActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppRulesInSchemesAndTablesActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_analyzemethods) {
                if (!(className.equals(AppAnalyzeMethods.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppAnalyzeMethods.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_bookmarks) {
                if (!(className.equals(AppBookmarksActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppBookmarksActivity.class));
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_search) {
                if (!(className.equals(AppSearchActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppSearchActivity.class));
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_about) {
                if (!(className.equals(AppAboutApplicationActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppAboutApplicationActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amonglessons_settings) {
                if (!(className.equals(AppSettingsActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppSettingsActivity.class));
                    requireActivity().finish();
                }
            }
            return false;
        });
        return viewFragment;
    }
}
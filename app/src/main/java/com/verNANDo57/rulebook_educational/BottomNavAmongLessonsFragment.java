package com.verNANDo57.rulebook_educational;

import android.content.Intent;
import android.content.res.ColorStateList;
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
import com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity;
import com.verNANDo57.rulebook_educational.search.AppSearchActivity;
import com.verNANDo57.rulebook_educational.utils.ColorUtils;

public class BottomNavAmongLessonsFragment extends BottomSheetDialogFragment {

    public BottomNavAmongLessonsFragment(){
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_among_lessons, container, false);

        NavigationView navigation_among_activities = viewFragment.findViewById(R.id.navigation_view_among_lessons);
        navigation_among_activities.setBackgroundColor(getResources().getColor(R.color.app_rulebook_background));
        navigation_among_activities.setItemTextColor(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_primary), 0.01f)));
        navigation_among_activities.setItemIconTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_accent), 0.01f)));
        navigation_among_activities.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            if (id == R.id.bottomsheetdialog_amonglessons_mainrules) {
                startActivity(new Intent(getActivity(), AppMainRulesActivity.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_lexicon) {
                startActivity(new Intent(getActivity(), com.verNANDo57.rulebook_educational.rules.AppLexiconActivity.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_schemesandtables) {
                startActivity(new Intent(getActivity(), AppRulesInSchemesAndTablesActivity.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_analyzemethods) {
                startActivity(new Intent(getActivity(), AppAnalyzeMethods.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_bookmarks) {
                startActivity(new Intent(getActivity(), AppBookmarksActivity.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_search) {
                startActivity(new Intent(getActivity(), AppSearchActivity.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_about) {
                startActivity(new Intent(getActivity(), AppAboutApplicationActivity.class));
            } else if (id == R.id.bottomsheetdialog_amonglessons_settings) {
                startActivity(new Intent(getActivity(), AppSettingsActivity.class));
            }
            requireActivity().finish();

            return false;
        });
        return viewFragment;
    }
}
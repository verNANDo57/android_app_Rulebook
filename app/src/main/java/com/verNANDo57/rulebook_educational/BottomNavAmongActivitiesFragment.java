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
import com.verNANDo57.rulebook_educational.rules.AppDictionaries;
import com.verNANDo57.rulebook_educational.search.AppSearchActivity;
import com.verNANDo57.rulebook_educational.utils.ColorUtils;

public class BottomNavAmongActivitiesFragment extends BottomSheetDialogFragment {

    public BottomNavAmongActivitiesFragment(){
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_among_activities, container, false);

        NavigationView navigationbetweenlessons = viewFragment.findViewById(R.id.navigation_view_among_activities);
        navigationbetweenlessons.setBackgroundColor(getResources().getColor(R.color.app_rulebook_background));
        navigationbetweenlessons.setItemTextColor(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_primary), 0.01f)));
        navigationbetweenlessons.setItemIconTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_accent), 0.01f)));
        navigationbetweenlessons.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            String className = requireActivity().getClass().getName();

            if (id == R.id.bottomsheetdialog_amongactivities_mainrules) {
                if (!(className.equals(AppSectionSelectionActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppSectionSelectionActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amongactivities_dictionaries) {
                if (!(className.equals(AppDictionaries.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppDictionaries.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amongactivities_bookmarks) {
                if (!(className.equals(AppBookmarksActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppBookmarksActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amongactivities_search) {
                if (!(className.equals(AppSearchActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppSearchActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amongactivities_about) {
                if (!(className.equals(AppAboutApplicationActivity.class.getName()))) {
                    startActivity(new Intent(getActivity(), AppAboutApplicationActivity.class));
                    requireActivity().finish();
                }
            } else if (id == R.id.bottomsheetdialog_amongactivities_settings) {
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

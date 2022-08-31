/*
 * Author: VerNANDo57 <silvenation@gmail.com>
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
import com.verNANDo57.rulebook_educational.rules.AppDictionaries;

public class BottomNavAmongActivitiesFragment extends BottomSheetDialogFragment {

    public BottomNavAmongActivitiesFragment(){
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_navigationview_content, container, false);

        NavigationView navigation_between_lessons = viewFragment.findViewById(R.id.navigation_view);

        // Clear and inflate menu from resource
        navigation_between_lessons.getMenu().clear();
        navigation_between_lessons.inflateMenu(R.menu.bottom_nav_drawer_menu_among_activities);

        // Set onClickListener
        navigation_between_lessons.setNavigationItemSelectedListener(menuItem -> {
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
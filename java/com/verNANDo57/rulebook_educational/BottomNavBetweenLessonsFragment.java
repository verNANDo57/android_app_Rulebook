package com.verNANDo57.rulebook_educational;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineBottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity;

import java.util.Objects;

public class BottomNavBetweenLessonsFragment extends CustomThemeEngineBottomSheetDialogFragment {

    public BottomNavBetweenLessonsFragment(){
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater ,ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_between_lessons, container, false);

        NavigationView navigationbetweenactivities = viewFragment.findViewById(R.id.navigation_view_between_lessons);
        navigationbetweenactivities.setBackgroundColor(getResources().getColor(R.color.bottomsheetdialog_background));
        navigationbetweenactivities.setItemTextColor(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_primary), 0.01f)));
        navigationbetweenactivities.setItemIconTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_accent), 0.01f)));
        navigationbetweenactivities.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            switch (id)
            {
                case R.id.bottomsheetdialog_betweenlessons_first:
                Objects.requireNonNull(getActivity()).finish();
                Intent BASICS = new Intent(getActivity(), AppMainRulesActivity.class);
                startActivity(BASICS);
                break;

                case R.id.bottomsheetdialog_betweenlessons_second:
                Intent AppLexiconRules = new Intent(getActivity(), com.verNANDo57.rulebook_educational.rules.AppLexiconActivity.class);
                startActivity(AppLexiconRules);
                break;

                case R.id.bottomsheetdialog_betweenlessons_third:
                Objects.requireNonNull(getActivity()).finish();
                Intent AppRulesInSchemesAndTablesActivity = new Intent(getActivity(), com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity.class);
                startActivity(AppRulesInSchemesAndTablesActivity);
                break;

                case R.id.bottomsheetdialog_betweenlessons_fourth:
                Objects.requireNonNull(getActivity()).finish();
                Intent AppAnalyzeMethods = new Intent(getActivity(), com.verNANDo57.rulebook_educational.rules.analyze_methods.AppAnalyzeMethods.class);
                startActivity(AppAnalyzeMethods);
                break;
            }

            return false;
        });
        return viewFragment;
    }
}
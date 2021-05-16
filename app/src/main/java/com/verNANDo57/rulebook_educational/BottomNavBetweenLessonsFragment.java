package com.verNANDo57.rulebook_educational;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineBottomSheetDialogFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.AppRulesInSchemesAndTablesActivity;
import com.verNANDo57.rulebook_educational.rules.analyze_methods.AppAnalyzeMethods;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesActivity;
import com.verNANDo57.rulebook_educational.search.AppSearchActivity;

public class BottomNavBetweenLessonsFragment extends CustomThemeEngineBottomSheetDialogFragment {

    public BottomNavBetweenLessonsFragment(){
        //Required empty public constructor
    }

    @SuppressLint("NonConstantResourceId")
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_between_lessons, container, false);

        NavigationView navigationbetweenactivities = viewFragment.findViewById(R.id.navigation_view_between_lessons);
        navigationbetweenactivities.setBackgroundColor(getResources().getColor(R.color.bottomsheetdialog_background));
        navigationbetweenactivities.setItemTextColor(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_primary), 0.01f)));
        navigationbetweenactivities.setItemIconTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_accent), 0.01f)));
        navigationbetweenactivities.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            switch (id)
            {
                case R.id.bottomsheetdialog_betweenlessons_orphoandpunct:
                    requireActivity().finish();
                    startActivity(new Intent(getActivity(), AppMainRulesActivity.class));
                break;

                case R.id.bottomsheetdialog_betweenlessons_lexicon:
                    requireActivity().finish();
                    startActivity(new Intent(getActivity(), com.verNANDo57.rulebook_educational.rules.AppLexiconActivity.class));
                break;

                case R.id.bottomsheetdialog_betweenlessons_intables:
                    requireActivity().finish();
                    startActivity(new Intent(getActivity(), AppRulesInSchemesAndTablesActivity.class));
                break;

                case R.id.bottomsheetdialog_betweenlessons_analyzemethods:
                    requireActivity().finish();
                    startActivity(new Intent(getActivity(), AppAnalyzeMethods.class));
                break;

                case R.id.bottomsheetdialog_betweenlessons_search:
                    requireActivity().finish();
                    startActivity(new Intent(getActivity(), AppSearchActivity.class));
                break;
            }

            return false;
        });
        return viewFragment;
    }
}
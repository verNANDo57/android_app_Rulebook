package com.verNANDo57.rulebook_educational;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineBottomSheetDialogFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.for_pills.R;

import java.util.Objects;

public class BottomNavBetweenActivitiesFragment extends CustomThemeEngineBottomSheetDialogFragment {

    public BottomNavBetweenActivitiesFragment(){
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater ,ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_bottomsheet_between_activities, container, false);

        NavigationView navigationbetweenlessons = viewFragment.findViewById(R.id.navigation_view_between_activities);
        navigationbetweenlessons.setBackgroundColor(getResources().getColor(R.color.bottomsheetdialog_background));
        navigationbetweenlessons.setItemTextColor(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_primary), 0.01f)));
        navigationbetweenlessons.setItemIconTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.bottomsheetdialog_accent), 0.01f)));
        navigationbetweenlessons.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            switch (id)
            {
                case R.id.bottomsheetdialog_betweenactivities_first:
                    Objects.requireNonNull(getActivity()).finish();
                    Intent AppChooseYourDestiny = new Intent(getActivity(), AppChooseYourDestiny.class);
                    startActivity(AppChooseYourDestiny);
                    break;

                case R.id.bottomsheetdialog_betweenactivities_second:
                    Objects.requireNonNull(getActivity()).finish();
                    Intent AppCreditsActivity = new Intent(getActivity(), AppAboutApplicationActivity.class);
                    startActivity(AppCreditsActivity);
                    break;

                case R.id.bottomsheetdialog_betweenactivities_third:
                    Objects.requireNonNull(getActivity()).finish();
                    Intent AppRulebookPreferencesScreenActivity = new Intent(getActivity(), com.verNANDo57.rulebook_educational.preferences.AppSettingsActivity.class);
                    startActivity(AppRulebookPreferencesScreenActivity);
                    break;

                case R.id.bottomsheetdialog_betweenactivities_fourth:
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                    builder.setTitle(getString(R.string.app_exit));
                    builder.setMessage(getString(R.string.are_you_sure));
                    builder.setIcon(R.drawable.ic_warning_outline);
                    builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Objects.requireNonNull(getActivity()).finishAffinity();
                        }
                    });
                    builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    androidx.appcompat.app.AlertDialog alert = builder.create();
                    alert.show();
                    break;
            }

            return false;
        });
        return viewFragment;
    }
}

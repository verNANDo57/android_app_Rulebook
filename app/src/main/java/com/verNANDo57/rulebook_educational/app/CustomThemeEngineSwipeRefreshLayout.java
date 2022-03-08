package com.verNANDo57.rulebook_educational.app;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.verNANDo57.rulebook_educational.extradata.R;

/**
 * Base class for an androidx.swiperefreshlayout.widget.SwipeRefreshLayout.
 */
public class CustomThemeEngineSwipeRefreshLayout extends SwipeRefreshLayout {

    public CustomThemeEngineSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Set custom color theme
        setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.app_custom_background));
    }

    public CustomThemeEngineSwipeRefreshLayout(@NonNull Context context) {
        super(context);

        // Set custom color theme
        setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.app_custom_background));
    }

}

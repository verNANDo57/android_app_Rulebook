package com.verNANDo57.rulebook_educational.rules;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavBetweenLessonsFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

public class AppRulesInSchemesAndTablesActivity extends CustomThemeEngineAppCompatActivity {

    public String simplewaytolearninfile = "simplewaytolearn.html";
    RulebookApplicationSharedPreferences preferences;

    @SuppressLint({"ClickableViewAccessibility", "SetJavaScriptEnabled"})
    public void onCreate(Bundle savedInstanceState)
    {
        preferences =  new RulebookApplicationSharedPreferences(this);

        super.onCreate(savedInstanceState);

        //Activity Content as LAYOUT
        setContentView(R.layout.app_bottomappbar_in_webview);

        //init WebView
        WebView apprulesinschemesandtablesview = findViewById(R.id.app_rules_webview);
        // displaying content in WebView from html file that stored in assets folder
        apprulesinschemesandtablesview.loadUrl("file:///android_asset/rulesinschemesandtables/" + simplewaytolearninfile);
        apprulesinschemesandtablesview.getSettings().setJavaScriptEnabled(true);
        //WebView preferences
        apprulesinschemesandtablesview.setInitialScale(120);

        //disable text selection
        apprulesinschemesandtablesview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        apprulesinschemesandtablesview.setLongClickable(false);

        apprulesinschemesandtablesview.getSettings().setSupportZoom(true);
        apprulesinschemesandtablesview.getSettings().setBuiltInZoomControls(true);
        apprulesinschemesandtablesview.getSettings().setDisplayZoomControls(false);

        //BottomAppBar
        final FloatingActionButton fab_in_schemes_and_tables = findViewById(R.id.fab_in_webview);
        fab_in_schemes_and_tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final BottomAppBar bar_in_schemes_and_tables = findViewById(R.id.bar_in_webview);
        setSupportActionBar(bar_in_schemes_and_tables);
        //Antimation when activity starts------------------------------------------------
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            TranslateAnimation animate = new TranslateAnimation(
                    0, 0, 250, 0);
            animate.setDuration(250);
            animate.setFillAfter(false);
            bar_in_schemes_and_tables.startAnimation(animate);
        }
        //End of Animation---------------------------------------------------------------

        //BottomNavigationView
        bar_in_schemes_and_tables.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavBetweenLessonsFragment BottomNavBetweenLessons = new BottomNavBetweenLessonsFragment();
                BottomNavBetweenLessons.show(getSupportFragmentManager(), "TAG");
            }
        });

        //Hide on SwipeDown
        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==false){
            bar_in_schemes_and_tables.setOnTouchListener(new View.OnTouchListener() {

                float mY;
                float swipeDistance;
                final float REQUIRED_SWIPE = 25;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    float y = event.getY();

                    switch(event.getAction()) {

                        case MotionEvent.ACTION_DOWN :
                            swipeDistance = 0;
                            mY = y;
                            break;

                        case MotionEvent.ACTION_MOVE :
                            swipeDistance += y - mY;
                            if(Math.abs(swipeDistance) > REQUIRED_SWIPE) {
                                if(swipeDistance > 0) {
                                    if(bar_in_schemes_and_tables.getVisibility() == View.VISIBLE) {
                                        if(preferences.loadRulebookAnimationsDisableState()==false) {
                                            TranslateAnimation animate = new TranslateAnimation(
                                                    0,0,0,bar_in_schemes_and_tables.getHeight());
                                            animate.setDuration(250);
                                            animate.setFillAfter(false);
                                            bar_in_schemes_and_tables.startAnimation(animate);
                                        }
                                        bar_in_schemes_and_tables.setVisibility(View.GONE);
                                        swipeDistance = 0;
                                        fab_in_schemes_and_tables.hide();
                                    }
                                }
                            }
                            mY = y;
                            break;
                    }
                    mY = y;
                    return false;
                }
            });
        }


        //Tap and Hold to view the bottomappbar
        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==false){
            apprulesinschemesandtablesview.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (bar_in_schemes_and_tables.getVisibility() == View.GONE) {
                        if(preferences.loadRulebookAnimationsDisableState()==false) {
                            TranslateAnimation animate = new TranslateAnimation(
                                    0,0,bar_in_schemes_and_tables.getHeight(),0);
                            animate.setDuration(250);
                            animate.setFillAfter(false);
                            bar_in_schemes_and_tables.startAnimation(animate);
                        }
                        bar_in_schemes_and_tables.setVisibility(View.VISIBLE);
                        fab_in_schemes_and_tables.show();
                    }
                    return true;
                }
            });
        }


        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==true){
            apprulesinschemesandtablesview.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    //see https://gist.github.com/aqua30/e8623abaff190ee86727ee5ae8dac82a
                    int movement = apprulesinschemesandtablesview.getScrollY();

                    if(movement >= 100){
                        if (bar_in_schemes_and_tables.getVisibility() == View.VISIBLE) {
                            if (preferences.loadRulebookAnimationsDisableState() == false) {
                                TranslateAnimation animate = new TranslateAnimation(
                                        0, 0, 0, bar_in_schemes_and_tables.getHeight());
                                animate.setDuration(250);
                                animate.setFillAfter(false);
                                bar_in_schemes_and_tables.startAnimation(animate);
                            }
                            bar_in_schemes_and_tables.setVisibility(View.GONE);
                            fab_in_schemes_and_tables.hide();
                        }
                    } else if(movement >= -100){
                        if (bar_in_schemes_and_tables.getVisibility() == View.GONE) {
                            if (preferences.loadRulebookAnimationsDisableState() == false) {
                                TranslateAnimation animate = new TranslateAnimation(
                                        0, 0, bar_in_schemes_and_tables.getHeight(), 0);
                                animate.setDuration(250);
                                animate.setFillAfter(false);
                                bar_in_schemes_and_tables.startAnimation(animate);
                            }
                            bar_in_schemes_and_tables.setVisibility(View.VISIBLE);
                            fab_in_schemes_and_tables.show();
                        }
                    }
                }
            });
        }
    }

    //system navigationbar
    public boolean onKeyDown(int keyCode, KeyEvent event) {     switch (keyCode) {     case KeyEvent.KEYCODE_BACK:
        if (android.os.Build.VERSION.SDK_INT <android.os.Build.VERSION_CODES.ECLAIR     && event.getRepeatCount() == 0) {     onBackPressed();     }     }
        return super.onKeyDown(keyCode, event); }
    public void onBackPressed(){ finish();}
}

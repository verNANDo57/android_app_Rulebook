package com.verNANDo57.rulebook_educational;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class AppStatusActivity extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;

    @SuppressLint("ClickableViewAccessibility")
    public void onCreate(Bundle savedInstanceState)
    {
        preferences =  new RulebookApplicationSharedPreferences(this);

        super.onCreate(savedInstanceState);

        //Activity Content as LAYOUT
        setContentView(R.layout.app_bottomappbar_in_appstatuspage);

        //BottomAppBar
        final FloatingActionButton fab_in_status_page = findViewById(R.id.fab_in_status_page);
        fab_in_status_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                resetAllPrefs(); //Custom Method 2
            }
        });
        final BottomAppBar bar_in_status_page = findViewById(R.id.bar_in_status_page);
        setSupportActionBar(bar_in_status_page);
        //Antimation when activity starts------------------------------------------------
        if(preferences.loadRulebookAnimationsDisableState()==false) {
            TranslateAnimation animate = new TranslateAnimation(
                    0, 0, 250, 0);
            animate.setDuration(250);
            animate.setFillAfter(false);
            bar_in_status_page.startAnimation(animate);
        }
        //End of Animation---------------------------------------------------------------

        //Hide on SwipeDown
        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==false){
            bar_in_status_page.setOnTouchListener(new View.OnTouchListener() {

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
                                if (swipeDistance > 0) {
                                    if (bar_in_status_page.getVisibility() == View.VISIBLE) {
                                        if(preferences.loadRulebookAnimationsDisableState()==false) {
                                            TranslateAnimation animate = new TranslateAnimation(
                                                    0, 0, 0, bar_in_status_page.getHeight());
                                            animate.setDuration(250);
                                            animate.setFillAfter(false);
                                            bar_in_status_page.startAnimation(animate);
                                        }
                                        bar_in_status_page.setVisibility(View.GONE);
                                        swipeDistance = 0;
                                        fab_in_status_page.hide();
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
        TextView status_headline = findViewById(R.id.status_headline);
        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==false){
            status_headline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bar_in_status_page.getVisibility() == View.GONE) {
                        if(preferences.loadRulebookAnimationsDisableState()==false) {
                            TranslateAnimation animate = new TranslateAnimation(
                                    0,0,bar_in_status_page.getHeight(),0);
                            animate.setDuration(250);
                            animate.setFillAfter(false);
                            bar_in_status_page.startAnimation(animate);
                        }
                        bar_in_status_page.setVisibility(View.VISIBLE);
                        fab_in_status_page.show();
                    }
                }
            });
        }

        ScrollView status_scrollview = findViewById(R.id.status_scrollview);
        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==true){
            status_scrollview.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    //see https://gist.github.com/aqua30/e8623abaff190ee86727ee5ae8dac82a
                    int movement = status_scrollview.getScrollY();

                    if(movement >= 100){
                        if (bar_in_status_page.getVisibility() == View.VISIBLE) {
                            if (preferences.loadRulebookAnimationsDisableState() == false) {
                                TranslateAnimation animate = new TranslateAnimation(
                                        0, 0, 0, bar_in_status_page.getHeight());
                                animate.setDuration(250);
                                animate.setFillAfter(false);
                                bar_in_status_page.startAnimation(animate);
                            }
                            bar_in_status_page.setVisibility(View.GONE);
                            fab_in_status_page.hide();
                        }
                    } else if(movement >= -100){
                        if (bar_in_status_page.getVisibility() == View.GONE) {
                            if (preferences.loadRulebookAnimationsDisableState() == false) {
                                TranslateAnimation animate = new TranslateAnimation(
                                        0, 0, bar_in_status_page.getHeight(), 0);
                                animate.setDuration(250);
                                animate.setFillAfter(false);
                                bar_in_status_page.startAnimation(animate);
                            }
                            bar_in_status_page.setVisibility(View.VISIBLE);
                            fab_in_status_page.show();
                        }
                    }
                }
            });
        }

        TextView app_status_voicesearch_boolean_state_value = findViewById(R.id.app_status_voicesearch_boolean_state_value);
        app_status_voicesearch_boolean_state_value.setEnabled(true);
        if (preferences.loadRulebookVoiceSearchDisableState()==true){
            app_status_voicesearch_boolean_state_value.setText(getString(R.string.app_status_boolean_state_yes));
        } else if (preferences.loadRulebookVoiceSearchDisableState()==false) {
            app_status_voicesearch_boolean_state_value.setText(getString(R.string.app_status_boolean_state_no));
        }

        TextView app_status_anim_boolean_state_value = findViewById(R.id.app_status_anim_boolean_state_value);
        app_status_anim_boolean_state_value.setEnabled(true);
        if (preferences.loadRulebookAnimationsDisableState()==true) {
            app_status_anim_boolean_state_value.setText(getString(R.string.app_status_boolean_state_yes));
        } else if (preferences.loadRulebookAnimationsDisableState()==false) {
            app_status_anim_boolean_state_value.setText(getString(R.string.app_status_boolean_state_no));
        }

        TextView app_status_page_boolean_state_value = findViewById(R.id.app_status_page_boolean_state_value);
        app_status_page_boolean_state_value.setEnabled(true);
        if (preferences.loadRulebookStatusPageBooleanState()==true) {
            app_status_page_boolean_state_value.setText(getString(R.string.app_status_boolean_state_yes));
        } else if (preferences.loadRulebookStatusPageBooleanState()==false) {
        app_status_page_boolean_state_value.setText(getString(R.string.app_status_boolean_state_no));
        }

        TextView app_statusbar_boolean_state_value = findViewById(R.id.app_statusbar_boolean_state_value);
        app_statusbar_boolean_state_value.setEnabled(true);
        if (preferences.loadRulebookStatusBarBooleanState()==true) {
            app_statusbar_boolean_state_value.setText(R.string.app_status_boolean_state_yes);
        } else if (preferences.loadRulebookStatusBarBooleanState()==false) {
            app_statusbar_boolean_state_value.setText(R.string.app_status_boolean_state_no);
        }

        TextView app_autohidebottomappbar_boolean_state_value = findViewById(R.id.app_autohidebottomappbar_boolean_state_value);
        app_autohidebottomappbar_boolean_state_value.setEnabled(true);
        if(preferences.loadRulebookBottomAppBarAutoHideBooleanState()==true){
            app_autohidebottomappbar_boolean_state_value.setText(R.string.app_status_boolean_state_yes);
        } else if (preferences.loadRulebookBottomAppBarAutoHideBooleanState()==false){
            app_autohidebottomappbar_boolean_state_value.setText(R.string.app_status_boolean_state_no);
        }

    }

    //system navigationbar using
    public boolean onKeyDown(int keyCode, KeyEvent event) {     switch (keyCode) {     case KeyEvent.KEYCODE_BACK:
        if (android.os.Build.VERSION.SDK_INT <android.os.Build.VERSION_CODES.ECLAIR     && event.getRepeatCount() == 0) {     onBackPressed();     }     }
        return super.onKeyDown(keyCode, event); }
    public void onBackPressed(){ finish();}
    //end of navbar using

    //ActionBar_Elements
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.status_page_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.debugging_mode:
                startActivity(newDebuggingIntent()); //Custom Method 4
                return true;

            case R.id.status_details:
                statusDetails(); //Custom Method 5
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

//End of ActionBarElements

    //Custom Method 5
    public void statusDetails(){
        //Include data from custom Method 6
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screeenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        int screendens = dm.densityDpi;
        double wi = (double)screeenwidth / (double)screendens;
        double hi = (double)screenheight / (double)screendens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x+y);
        screenInches = (double) Math.round(screenInches * 10) / 10;

        androidx.appcompat.app.AlertDialog.Builder builderDetails = new androidx.appcompat.app.AlertDialog.Builder(this);
        builderDetails.setTitle(getString(R.string.app_status_details_headline));
        builderDetails.setIcon(R.drawable.ic_warning_outline);
        builderDetails.setMessage(getString(R.string.review_device_name) + Build.DEVICE + "\n"
                + getString(R.string.review_device_model) + Build.MODEL + "\n"
                + getString(R.string.review_device_manufacter) + Build.MANUFACTURER + "\n"
                + getString(R.string.review_oc_name) + Build.ID + "\n"
                + getString(R.string.review_device_sdk_version) + Build.VERSION.SDK_INT + "\n"
                + getString(R.string.review_device_hardware) + Build.HARDWARE + "\n"
                + getString(R.string.review_device_brand) + Build.BRAND + "\n"
                + getString(R.string.review_device_fingerprint) + Build.FINGERPRINT + "\n"
                + getString(R.string.review_device_serial) + Build.SERIAL + "\n"
                + getString(R.string.review_device_android_version) + Build.VERSION.RELEASE + "\n"
                + getString(R.string.review_device_screen_resolution) + screeenwidth + "x" + screenheight + "\n"
                + getString(R.string.review_device_current_dpi_value) + screenInches);
        builderDetails.setCancelable(true);
        builderDetails.setNeutralButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        androidx.appcompat.app.AlertDialog alertDetails = builderDetails.create();
        alertDetails.show();
    }

    //Custom Method 4
    final Intent newDebuggingIntent() {
        final Intent newDocumentIntent = new Intent(this, AppRulebookLiveLoggingActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            newDocumentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        } else {
            newDocumentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        newDocumentIntent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        return newDocumentIntent;
    }

    public void restartRulebook(){
        finishAffinity();
        Intent restartRulebook = new Intent(this, StrangeScreenActivity.class);
        startActivity(restartRulebook);
    }

    //Custom Method 2
    public void resetAllPrefs(){
        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.are_you_sure);
        builder.setItems(new CharSequence[]
                        {getString(R.string.yes_and_reset), getString(R.string.cancel)},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position of the selected item
                        switch (which) {
                            case 0:
                                preferences.setRulebookVoiceSearchDisableState(false);
                                preferences.setRulebookAnimationsDisableState(false);
                                preferences.setRulebookStatusPageBooleanState(false);
                                preferences.setRulebookStatusBarBooleanState(false);
                                preferences.setRulebookBottomAppBarAutoHideBooleanState(false);
                                restartRulebook();
                                break;
                            case 1:
                                dialog.cancel();
                                break;
                        }
                    }
                });
        builder.create().show();
    }
}

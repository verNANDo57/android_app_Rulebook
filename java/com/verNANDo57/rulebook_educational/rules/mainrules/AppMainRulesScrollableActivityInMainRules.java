package com.verNANDo57.rulebook_educational.rules.mainrules;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavBetweenLessonsFragment;
import com.verNANDo57.rulebook_educational.customclasses.AppSomeUtils;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.RulebookApplicationBooleans;
import com.verNANDo57.rulebook_educational.styleabletoast.StyleableToast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AppMainRulesScrollableActivityInMainRules extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;
    private RulebookApplicationBooleans booleansInMainRules;

    private RelativeLayout app_scrollableactivity_in_mainrules_toolbarlayout_container;
    private RelativeLayout app_scrollableactivity_everywhere_toolbarlayout_search_container;
    private AppBarLayout app_bar_in_mainrules;

    private Animation fade_in;
    private Animation fade_out;

    private Menu menu;

    private String out;
    private  String outFileDir;
    private String outFileName;

    private File outFile;

    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    public void onCreate(Bundle savedInstanceState) {
        preferences = new RulebookApplicationSharedPreferences(this);
        booleansInMainRules = new RulebookApplicationBooleans(this);

        booleansInMainRules.setAppBarPageSelected("info_container");

        fade_in = AnimationUtils.loadAnimation(this, R.anim.app_fade_in);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.app_fade_out);

        int ImageViewBackgroundTintColor = ColorUtils.lighter(getResources().getColor(R.color.coloraccent), 0.01f);

        //Activity Content as LAYOUT
        setContentView(R.layout.app_scrollable_activity_in_mainrules);

        super.onCreate(savedInstanceState);

        TextView app_scrollableactivity_in_mainrules_title = findViewById(R.id.app_scrollableactivity_in_mainrules_title);
        TextView app_scrollableactivity_in_mainrules_subtitle = findViewById(R.id.app_scrollableactivity_in_mainrules_subtitle);
        TextView app_scrollableactivity_content_in_mainrules_text = findViewById(R.id.app_scrollableactivity_content_everywhere_text);
        app_scrollableactivity_in_mainrules_toolbarlayout_container = findViewById(R.id.app_scrollableactivity_in_mainrules_toolbarlayout_container);
        app_scrollableactivity_everywhere_toolbarlayout_search_container = findViewById(R.id.app_scrollableactivity_everywhere_toolbarlayout_search_container);

        Toolbar toolbar = findViewById(R.id.toolbar_in_mainrules);
        if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_")){
            toolbar.setTitle(getString(R.string.ortho));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_")){
            toolbar.setTitle(getString(R.string.punct));
        }
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavBetweenLessonsFragment BottomNavFragmentFromLessons = new BottomNavBetweenLessonsFragment();
                BottomNavFragmentFromLessons.show(getSupportFragmentManager(), "TAG");
            }
        });

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout_in_mainrules);
        toolBarLayout.setTitle(" "); //should be a space, otherwise the trick will not work
        app_bar_in_mainrules = findViewById(R.id.app_bar_in_mainrules);
        ImageView app_scrollableactivity_in_mainrules_icon = findViewById(R.id.app_scrollableactivity_in_mainrules_icon);
        NestedScrollView app_scrollableactivity_content_scrollview = findViewById(R.id.app_scrollableactivity_content_scrollview);
        EditText app_wordsearch_edittext = findViewById(R.id.app_wordsearch_edittext);
        Button searchword_button = findViewById(R.id.searchword_button);

        if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_")){
            app_scrollableactivity_in_mainrules_icon.setBackground(getDrawable(R.drawable.app_pen_icon));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_")){
            app_scrollableactivity_in_mainrules_icon.setBackground(getDrawable(R.drawable.app_pencil_icon));
        }
        app_scrollableactivity_in_mainrules_icon.setBackgroundTintList(ColorStateList.valueOf(ImageViewBackgroundTintColor));

        if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_1_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_1));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_2_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_2));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_3_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_3));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_4_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_5_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_5));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_6_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_6));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_7_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_7));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_8_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_8));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_9_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_9));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_10_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_10));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_11_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_11));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_12_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_12));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_13_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_13));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_14_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_14));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_15_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_16_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_17_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.ortho_17));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_18_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_19_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_1_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_1));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_2_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_2));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_3_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_3));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_4_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_4));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_5_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_5));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_6_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_6));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_7_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_7));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_8_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_8));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_9_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_9));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_10_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_10));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_11_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_11));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_12_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_12));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_13_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_14_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_14));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_15_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_15));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_16_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_17_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_17));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_18_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_18));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_19_")) {
            app_scrollableactivity_in_mainrules_subtitle.setText(getString(R.string.punct_19));
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_20_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_21_")) {
            app_scrollableactivity_in_mainrules_subtitle.setVisibility(View.GONE);
        }

        switch (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean()) {
            case "ortho_1_1":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_1_1));
                break;
            case "ortho_1_2":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_1_2));
                break;
            case "ortho_1_3":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_1_3));
                break;
            case "ortho_1_4":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_1_4));
                break;
            case "ortho_1_5":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_1_5));
                break;
            case "ortho_1_6":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_1_6));
                break;
            case "ortho_2_7":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_2_7));
                break;
            case "ortho_2_8":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_2_8));
                break;
            case "ortho_2_9":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_2_9));
                break;
            case "ortho_3_10":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_10));
                break;
            case "ortho_3_11":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_11));
                break;
            case "ortho_3_12":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_12));
                break;
            case "ortho_3_13":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_13));
                break;
            case "ortho_3_14":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_14));
                break;
            case "ortho_3_15":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_15));
                break;
            case "ortho_3_16":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_16));
                break;
            case "ortho_3_17":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_17));
                break;
            case "ortho_3_18":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_18));
                break;
            case "ortho_3_19":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_19));
                break;
            case "ortho_3_20":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_20));
                break;
            case "ortho_3_21":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_21));
                break;
            case "ortho_3_22":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_22));
                break;
            case "ortho_3_23":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_23));
                break;
            case "ortho_3_24":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_24));
                break;
            case "ortho_3_25":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_25));
                break;
            case "ortho_3_26":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_3_26));
                break;
            case "ortho_4_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.ortho_4);
                break;
            case "ortho_5_27":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_5_27));
                break;
            case "ortho_5_28":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_5_28));
                break;
            case "ortho_5_29":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_5_29));
                break;
            case "ortho_6_30":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_6_30));
                break;
            case "ortho_6_31":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_6_31));
                break;
            case "ortho_7_32":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_7_32));
                break;
            case "ortho_7_33":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_7_33));
                break;
            case "ortho_8_34":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_8_34));
                break;
            case "ortho_8_35":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_8_35));
                break;
            case "ortho_9_36":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_9_36));
                break;
            case "ortho_9_37":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_9_37));
                break;
            case "ortho_9_38":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_9_38));
                break;
            case "ortho_9_39":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_9_39));
                break;
            case "ortho_10_40":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_10_40));
                break;
            case "ortho_10_41":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_10_41));
                break;
            case "ortho_11_42":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_11_42));
                break;
            case "ortho_11_43":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_11_43));
                break;
            case "ortho_12_44":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_12_44));
                break;
            case "ortho_12_45":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_12_45));
                break;
            case "ortho_12_46":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_12_46));
                break;
            case "ortho_13_47":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_13_47));
                break;
            case "ortho_13_48":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_13_48));
                break;
            case "ortho_14_49":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_14_49));
                break;
            case "ortho_14_50":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_14_50));
                break;
            case "ortho_14_51":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_14_51));
                break;
            case "ortho_14_52":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_14_52));
                break;
            case "ortho_14_53":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_14_53));
                break;
            case "ortho_14_54":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_14_54));
                break;
            case "ortho_15_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.ortho_15);
                break;
            case "ortho_16_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.ortho_16);
                break;
            case "ortho_17_55":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_55));
                break;
            case "ortho_17_56":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_56));
                break;
            case "ortho_17_57":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_57));
                break;
            case "ortho_17_58":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_58));
                break;
            case "ortho_17_59":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_59));
                break;
            case "ortho_17_60":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_60));
                break;
            case "ortho_17_61":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_61));
                break;
            case "ortho_17_62":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.ortho_17_62));
                break;
            case "ortho_18_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.ortho_18);
                break;
            case "ortho_19_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.ortho_19);
                break;
            case "punct_1_1":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_1_1));
                break;
            case "punct_1_2":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_1_2));
                break;
            case "punct_1_3":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_1_3));
                break;
            case "punct_1_4":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_1_4));
                break;
            case "punct_2_5":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_2_5));
                break;
            case "punct_2_6":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_2_6));
                break;
            case "punct_2_7":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_2_7));
                break;
            case "punct_2_8":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_2_8));
                break;
            case "punct_3_9":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_9));
                break;
            case "punct_3_10":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_10));
                break;
            case "punct_3_11":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_11));
                break;
            case "punct_3_12":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_12));
                break;
            case "punct_3_13":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_13));
                break;
            case "punct_3_14":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_14));
                break;
            case "punct_3_15":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_3_15));
                break;
            case "punct_4_16":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_4_16));
                break;
            case "punct_4_17":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_4_17));
                break;
            case "punct_5_18":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_5_18));
                break;
            case "punct_5_19":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_5_19));
                break;
            case "punct_5_20":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_5_20));
                break;
            case "punct_5_21":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_5_21));
                break;
            case "punct_6_22":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_6_22));
                break;
            case "punct_6_23":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_6_23));
                break;
            case "punct_6_24":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_6_24));
                break;
            case "punct_7_25":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_7_25));
                break;
            case "punct_7_26":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_7_26));
                break;
            case "punct_7_27":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_7_27));
                break;
            case "punct_8_28":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_8_28));
                break;
            case "punct_8_29":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_8_29));
                break;
            case "punct_9_30":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_9_30));
                break;
            case "punct_9_31":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_9_31));
                break;
            case "punct_9_32":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_9_32));
                break;
            case "punct_10_33":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_33));
                break;
            case "punct_10_34":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_34));
                break;
            case "punct_10_35":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_35));
                break;
            case "punct_10_36":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_36));
                break;
            case "punct_10_37":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_37));
                break;
            case "punct_10_38":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_38));
                break;
            case "punct_10_39":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_39));
                break;
            case "punct_10_40":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_10_40));
                break;
            case "punct_11_41":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_11_41));
                break;
            case "punct_11_42":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_11_42));
                break;
            case "punct_12_43":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_12_43));
                break;
            case "punct_12_44":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_12_44));
                break;
            case "punct_12_45":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_12_45));
                break;
            case "punct_12_46":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_12_46));
                break;
            case "punct_13_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.punct_13);
                break;
            case "punct_14_47":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_47));
                break;
            case "punct_14_48":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_48));
                break;
            case "punct_14_49":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_49));
                break;
            case "punct_14_50":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_50));
                break;
            case "punct_14_51":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_51));
                break;
            case "punct_14_52":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_52));
                break;
            case "punct_14_53":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_53));
                break;
            case "punct_14_54":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_14_54));
                break;
            case "punct_15_55":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_15_55));
                break;
            case "punct_15_56":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_15_56));
                break;
            case "punct_15_57":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_15_57));
                break;
            case "punct_15_58":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_15_58));
                break;
            case "punct_16_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.punct_16);
                break;
            case "punct_17_59":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_17_59));
                break;
            case "punct_17_60":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_17_60));
                break;
            case "punct_17_61":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_17_61));
                break;
            case "punct_17_62":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_17_62));
                break;
            case "punct_17_63":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_17_63));
                break;
            case "punct_18_64":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_18_64));
                break;
            case "punct_18_65":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_18_65));
                break;
            case "punct_18_66":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_18_66));
                break;
            case "punct_18_67":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_18_67));
                break;
            case "punct_18_68":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_18_68));
                break;
            case "punct_18_69":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_18_69));
                break;
            case "punct_19_70":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_19_70));
                break;
            case "punct_19_71":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_19_71));
                break;
            case "punct_19_72":
                app_scrollableactivity_in_mainrules_title.setText(getString(R.string.punct_19_72));
                break;
            case "punct_20_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.punct_20);
                break;
            case "punct_21_split":
                app_scrollableactivity_in_mainrules_title.setText(R.string.punct_21);
                break;
        }

        InputStream inputStream;
        try {
            if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_")) {
                inputStream = getAssets().open("mainrules/orthography/" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");
                app_scrollableactivity_content_in_mainrules_text.setText(AppSomeUtils.convertStreamToString(inputStream));
            } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_")){
                inputStream = getAssets().open("mainrules/punctuation/" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");
                app_scrollableactivity_content_in_mainrules_text.setText(AppSomeUtils.convertStreamToString(inputStream));
            }
        } catch (IOException e) {
            new StyleableToast.Builder(getApplicationContext())
                    .text(getString(R.string.error_while_reading_a_file)) // set text
                    .textBold() //set text bold
                    .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                    .show(); //show custom toast
            e.printStackTrace();
        }

        outFileName = app_scrollableactivity_in_mainrules_title.getText().toString();

        if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_")){
            out = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.ortho) + "/";
            outFileDir = "/Rulebook/" + getString(R.string.ortho) + "/";
        } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_")){
            out = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.punct) + "/";
            outFileDir = "/Rulebook/" + getString(R.string.punct) + "/";
        }
        outFile = new File(out, booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");

        searchword_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String criteria = app_wordsearch_edittext.getText().toString();
                String fullText = app_scrollableactivity_content_in_mainrules_text.getText().toString();

                AppSomeUtils.resetHighLightedText(app_scrollableactivity_content_in_mainrules_text, fullText);

                if(criteria.equals(" ")){
                    new StyleableToast.Builder(getApplicationContext())
                            .text(getString(R.string.app_edittext_is_empty)) // set text
                            .textBold() //set text bold
                            .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                            .show(); //show custom toast
                } else if (criteria.contains("        ")){
                    new StyleableToast.Builder(getApplicationContext())
                            .text(getString(R.string.app_edittext_is_empty)) // set text
                            .textBold() //set text bold
                            .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                            .show(); //show custom toast
                } else if (criteria.isEmpty()){
                    new StyleableToast.Builder(getApplicationContext())
                            .text(getString(R.string.app_edittext_is_empty)) // set text
                            .textBold() //set text bold
                            .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                            .show(); //show custom toast
                } else {
                    if (fullText.contains(criteria)) {
                        int indexOfCriteria = fullText.indexOf(criteria);
                        int lineNumber = app_scrollableactivity_content_in_mainrules_text.getLayout().getLineForOffset(indexOfCriteria);
                        AppSomeUtils.setHighLightedText(app_scrollableactivity_content_in_mainrules_text, criteria);

                        app_scrollableactivity_content_scrollview.scrollTo(0, app_scrollableactivity_content_in_mainrules_text.getLayout().getLineTop(lineNumber));
                    }
                }
            }
        });

        app_bar_in_mainrules.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    //TODO: Something onExapnded(true)
                    isShow = true;
                } else if(isShow) {
                    //TODO: Something onExapnded(false)
                    isShow = false;
                }
            }
        });

    }

    //ActionBar_Elements
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.app_scrollableactivity_menu, menu);
        this.menu = menu;
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.search_word:
                if(app_scrollableactivity_in_mainrules_toolbarlayout_container.getVisibility()==View.VISIBLE){

                    app_scrollableactivity_in_mainrules_toolbarlayout_container.startAnimation(fade_out);
                    app_scrollableactivity_in_mainrules_toolbarlayout_container.setVisibility(View.GONE);

                    app_scrollableactivity_everywhere_toolbarlayout_search_container.startAnimation(fade_in);
                    app_scrollableactivity_everywhere_toolbarlayout_search_container.setVisibility(View.VISIBLE);

                    booleansInMainRules.setAppBarPageSelected("search_container");
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_warning_outline_menu));
                } else {
                    app_scrollableactivity_everywhere_toolbarlayout_search_container.startAnimation(fade_out);
                    app_scrollableactivity_everywhere_toolbarlayout_search_container.setVisibility(View.GONE);

                    app_scrollableactivity_in_mainrules_toolbarlayout_container.startAnimation(fade_in);
                    app_scrollableactivity_in_mainrules_toolbarlayout_container.setVisibility(View.VISIBLE);

                    booleansInMainRules.setAppBarPageSelected("info_container");
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_searchword_icon));
                }
                app_bar_in_mainrules.setExpanded(true);
                return true;

            case R.id.save_rule:
                copyAssets();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    //system navigationbar
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event); }
    public void onBackPressed(){
        booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("null");
        finish();
    }

    private void copyAssets() {
        AssetManager assetManager = getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", getString(R.string.app_error_while_saving_file), e);
        }
            InputStream in = null;
            OutputStream out = null;
                try {
		        String outPreDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/";
		        String outDir = null;
                    if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("ortho_")) {
                        in = assetManager.open("mainrules/orthography/" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");

                        outDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.ortho) + "/";
                    } else if (booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("punct_")){
                        in = assetManager.open("mainrules/punctuation/" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");

                        outDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.punct) + "/";
                    }

		            File preDirectory = new File(outPreDir);
		            if (! preDirectory.exists()){
                        preDirectory.mkdir();
                        // If you require it to make the entire directory path including parents,
                        // use directory.mkdirs(); here instead.
                    }

                    File directory = new File(outDir);
                    if (! directory.exists()){
                        directory.mkdir();
                        // If you require it to make the entire directory path including parents,
                        // use directory.mkdirs(); here instead.
                    }

                    File outFile = new File(outDir,  outFileName + ".txt");
                    if (outFile.exists()){
                        new StyleableToast.Builder(getApplicationContext())
                                .text(getString(R.string.app_saved_already) + ":" + outFileDir + outFileName + ".txt") // set text
                                .textBold() //set text bold
                                .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                                .show(); //show custom toast
                    } else {
                        out = new FileOutputStream(outFile);
                        AppSomeUtils.copyFile(in, out);
                        in.close();
                        in = null;
                        out.flush();
                        out.close();
                        out = null;

                        new StyleableToast.Builder(getApplicationContext())
                                .text(getString(R.string.app_saved) + ":" + outFileDir + outFileName + ".txt") // set text
                                .textBold() //set text bold
                                .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                                .show(); //show custom toast
                    }
            } catch(IOException e) {
                Log.e("tag", getString(R.string.app_error_while_saving_file) + ":" + outFileDir + outFileName + ".txt" + "(" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt" + ")", e);

                new StyleableToast.Builder(getApplicationContext())
                        .text(getString(R.string.app_error_while_saving_file)) // set text
                        .textBold() //set text bold
                        .iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
                        .show(); //show custom toast
            }
    }
}

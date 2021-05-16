package com.verNANDo57.rulebook_educational.rules.analyze_methods;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.customthemeengine.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.AppExtraBooleans;
import com.verNANDo57.rulebook_educational.styleabletoast.StyleableToast;
import com.verNANDo57.rulebook_educational.tools.Utils;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.verNANDo57.rulebook_educational.tools.Utils.LOG_TAG;

public class AppAnalyzeMethodsScrollableActivity extends CustomThemeEngineAppCompatActivity {

    RulebookApplicationSharedPreferences preferences;
    private AppExtraBooleans booleansInMainRules;

    private RelativeLayout app_scrollableactivity_in_analyzemethods_toolbarlayout_container;
    private RelativeLayout app_scrollableactivity_everywhere_toolbarlayout_search_container;
    private AppBarLayout app_bar_in_analyzemethods;

    private Animation fade_in;
    private Animation fade_out;

    private Menu menu;

    private String outFileDir;
    private String outFileName;

    @SuppressLint("ClickableViewAccessibility")
    public void onCreate(Bundle savedInstanceState) {
        preferences = new RulebookApplicationSharedPreferences(this);
        booleansInMainRules = new AppExtraBooleans(this);

        booleansInMainRules.setAppBarPageSelected("info_container");

        fade_in = AnimationUtils.loadAnimation(this, R.anim.app_fade_in);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.app_fade_out);

        //Activity Content as LAYOUT
        setContentView(R.layout.app_scrollable_activity);

        ImageView app_scrollableactivity_in_scrollableactivity_icon = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_icon);
        app_scrollableactivity_in_scrollableactivity_icon.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_search_black));
        app_scrollableactivity_in_scrollableactivity_icon.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.coloraccent), 0.01f)));

        TextView app_scrollableactivity_in_analyzemethods_title = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_title);
        TextView app_scrollableactivity_in_analyzemethods_subtitle = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_subtitle);
        TextView app_scrollableactivity_content_in_analyzemethods_text = findViewById(R.id.app_scrollableactivity_content_everywhere_text);

        Toolbar toolbar = findViewById(R.id.toolbar_in_scrollableactivity);
        toolbar.setTitle(getString(R.string.analyze_methods));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavBetweenLessonsFragment BottomNavFragmentFromLessons = new BottomNavBetweenLessonsFragment();
                BottomNavFragmentFromLessons.show(getSupportFragmentManager(), "TAG");
            }
        });

        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout_in_scrollableactivity);
        toolBarLayout.setTitle(" "); //should be a space, otherwise the trick will not work

        app_bar_in_analyzemethods = findViewById(R.id.app_bar_in_scrollableactivity);

        app_scrollableactivity_in_analyzemethods_toolbarlayout_container = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_toolbarlayout_container);
        app_scrollableactivity_everywhere_toolbarlayout_search_container = findViewById(R.id.app_scrollableactivity_everywhere_toolbarlayout_search_container);

        NestedScrollView app_scrollableactivity_content_scrollview = findViewById(R.id.app_scrollableactivity_content_scrollview);
        EditText app_wordsearch_edittext = findViewById(R.id.app_wordsearch_edittext);
        Button searchword_button = findViewById(R.id.searchword_button);

        super.onCreate(savedInstanceState);

        if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphemic_analyze_method")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphemic_analyze_method));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_noun")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_noun));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_verb")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_verb));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_adjective")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_adjective));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_numeral")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_numeral));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_adverb")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_adverb));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_participle")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_participle));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_participle2")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_participle2));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_pretext")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_pretext));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_union")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_union));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("morphological_analyze_method_for_particle")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.morphological_analyze_method_for_particle));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("syntactic_analyze_method_for_simple_sentence")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.syntactic_analyze_method_for_simple_sentence));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("syntactic_analyze_method_for_difficult_sentence")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.syntactic_analyze_method_for_difficult_sentence));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("lexical_analyze_method_for_everyword")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.lexical_analyze_method_for_everyword));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("orthographic_analyze_method_for_everyword")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.orthographic_analyze_method_for_everyword));
        } else if(booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean().contains("phonetic_analyze_method")) {
            app_scrollableactivity_in_analyzemethods_title.setText(getString(R.string.phonetic_analyze_method));
        }

        app_scrollableactivity_in_analyzemethods_subtitle.setText(getString(R.string.app_launch_analyze_extended));

        try {
            InputStream inputStream;
            inputStream = getAssets().open("analyze_methods/" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");
            app_scrollableactivity_content_in_analyzemethods_text.setText(Utils.convertStreamToString(inputStream));
        } catch (IOException e) {
            new StyleableToast.Builder(getApplicationContext())
                    .text(getString(R.string.error_while_reading_a_file)) // set text
                    .textBold() //set text bold
                    .iconStart(Utils.getIconWarning()) //icon in start of toast
                    .show(); //show custom toast
            e.printStackTrace();
        }

        outFileName = app_scrollableactivity_in_analyzemethods_title.getText().toString();
        outFileDir = "/Rulebook/" + getString(R.string.analyze_methods) + "/";

        searchword_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String criteria = app_wordsearch_edittext.getText().toString();
                String fullText = app_scrollableactivity_content_in_analyzemethods_text.getText().toString();

                Utils.resetHighLightedText(app_scrollableactivity_content_in_analyzemethods_text, fullText);

                if(criteria.equals(" ") | criteria.contains("        ") | criteria.isEmpty()){
                    new StyleableToast.Builder(getApplicationContext())
                            .text(getString(R.string.app_edittext_is_empty)) // set text
                            .textBold() //set text bold
                            .iconStart(Utils.getIconWarning()) //icon in start of toast
                            .show(); //show custom toast
                } else {
                    if (fullText.contains(criteria)) {
                        int indexOfCriteria = fullText.indexOf(criteria);
                        int lineNumber = app_scrollableactivity_content_in_analyzemethods_text.getLayout().getLineForOffset(indexOfCriteria);
                        Utils.setHighLightedText(app_scrollableactivity_content_in_analyzemethods_text, criteria);

                        app_scrollableactivity_content_scrollview.scrollTo(0, app_scrollableactivity_content_in_analyzemethods_text.getLayout().getLineTop(lineNumber));
                    }
                }
            }
        });

        app_bar_in_analyzemethods.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
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

    //ActionBar elements
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.app_scrollableactivity_menu, menu);
        this.menu = menu;
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.search_word:
            if(app_scrollableactivity_in_analyzemethods_toolbarlayout_container.getVisibility()==View.VISIBLE){

                app_scrollableactivity_in_analyzemethods_toolbarlayout_container.startAnimation(fade_out);
                app_scrollableactivity_in_analyzemethods_toolbarlayout_container.setVisibility(View.GONE);

                app_scrollableactivity_everywhere_toolbarlayout_search_container.startAnimation(fade_in);
                app_scrollableactivity_everywhere_toolbarlayout_search_container.setVisibility(View.VISIBLE);

                booleansInMainRules.setAppBarPageSelected("search_container");
                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_warning_outline_menu));
            } else {
                app_scrollableactivity_everywhere_toolbarlayout_search_container.startAnimation(fade_out);
                app_scrollableactivity_everywhere_toolbarlayout_search_container.setVisibility(View.GONE);

                app_scrollableactivity_in_analyzemethods_toolbarlayout_container.startAnimation(fade_in);
                app_scrollableactivity_in_analyzemethods_toolbarlayout_container.setVisibility(View.VISIBLE);

                booleansInMainRules.setAppBarPageSelected("info_container");
                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_searchword_icon));
            }
            app_bar_in_analyzemethods.setExpanded(true);
                return true;

            case R.id.save_rule:
                copyAssets();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("null");
        finish();
    }

    private void copyAssets() {
        AssetManager assetManager = getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            String outPreDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/";
            in = assetManager.open("analyze_methods/" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt");
	        String outDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.analyze_methods) + "/";

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
                        .iconStart(Utils.getIconWarning()) //icon in start of toast
                        .show(); //show custom toast
            } else {
                out = new FileOutputStream(outFile);
                Utils.copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;

                new StyleableToast.Builder(getApplicationContext())
                        .text(getString(R.string.app_saved) + ":" + outFileDir + outFileName + ".txt") // set text
                        .textBold() //set text bold
                        .iconStart(Utils.getIconWarning()) //icon in start of toast
                        .show(); //show custom toast
            }

        } catch(IOException e) {
            Log.e(LOG_TAG, getString(R.string.app_error_while_saving_file) + ":" + outFileDir + outFileName + ".txt" + "(" + booleansInMainRules.loadRulebookMainRulesFragmentOpenedBoolean() + ".txt" + ")", e);

            new StyleableToast.Builder(getApplicationContext())
                    .text(getString(R.string.app_error_while_saving_file)) // set text
                    .textBold() //set text bold
                    .iconStart(Utils.getIconWarning()) //icon in start of toast
                    .show(); //show custom toast
        }
    }
}

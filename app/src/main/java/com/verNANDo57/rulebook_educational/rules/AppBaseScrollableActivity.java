package com.verNANDo57.rulebook_educational.rules;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.content.Intent;
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

import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.utils.AppUtils;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.bookmarks.AppBookmarkUtils;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.utils.ColorUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.search.SearchReferences;
import com.verNANDo57.rulebook_educational.styleabletoast.StyleableToast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class AppBaseScrollableActivity extends CustomThemeEngineAppCompatActivity {
    private RelativeLayout app_basescrollableactivity_toolbar_container;
    private RelativeLayout app_basescrollableactivity_search_container;
    private AppBarLayout appbar;

    private Animation fade_in;
    private Animation fade_out;

    private Menu menu;

    private String outFileDir;
    private String outFileName;

    private TextView app_basescrollableactivity_title;
    private TextView app_basescrollableactivity_summary;

    private Intent sourceIntent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sourceIntent = getIntent();

        fade_in = AnimationUtils.loadAnimation(this, R.anim.app_fade_in);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.app_fade_out);

        setContentView(R.layout.app_scrollable_activity);

        ImageView app_basescrollableactivity_icon = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_icon);
        app_basescrollableactivity_title = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_title);
        app_basescrollableactivity_summary = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_summary);
        TextView app_scrollableactivity_content_in_mainrules_text = findViewById(R.id.app_scrollableactivity_content_everywhere_text);
        app_basescrollableactivity_toolbar_container = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_toolbarlayout_container);
        app_basescrollableactivity_search_container = findViewById(R.id.app_scrollableactivity_everywhere_toolbarlayout_search_container);

        Toolbar toolbar = findViewById(R.id.toolbar_in_scrollableactivity);
        if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("ortho_")) {
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.app_pen_icon));
            toolbar.setTitle(getString(R.string.ortho));
            app_basescrollableactivity_title.setText(SearchReferences.getTitleOrthography(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)));
            if (SearchReferences.getSummaryOrthography(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)) != null) {
                app_basescrollableactivity_summary.setText(SearchReferences.getSummaryOrthography(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)));
            } else {
                app_basescrollableactivity_summary.setVisibility(View.GONE);
            }
            outFileDir = "/Rulebook/" + getString(R.string.ortho) + "/";
        } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("punct_")){
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.app_pencil_icon));
            toolbar.setTitle(getString(R.string.punct));
            app_basescrollableactivity_title.setText(SearchReferences.getTitlePunctuation(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)));
            if (SearchReferences.getSummaryPunctuation(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)) != null) {
                app_basescrollableactivity_summary.setText(SearchReferences.getSummaryPunctuation(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)));
            } else {
                app_basescrollableactivity_summary.setVisibility(View.GONE);
            }
            outFileDir = "/Rulebook/" + getString(R.string.punct) + "/";
        } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("dict_")) {
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.app_char_icon));
            toolbar.setTitle(getString(R.string.dictionaries));
            app_basescrollableactivity_title.setText(SearchReferences.getTitleDictionaries(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)));
            app_basescrollableactivity_summary.setText(getString(R.string.dictionaries));
            outFileDir = "/Rulebook/" + getString(R.string.dictionaries) + "/";
        } else {
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_search_menu));
            toolbar.setTitle(getString(R.string.analyze_methods));
            app_basescrollableactivity_title.setText(SearchReferences.getTitleAnalyzeMethods(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME)));
            app_basescrollableactivity_summary.setText(getString(R.string.analyze_methods));
            outFileDir = "/Rulebook/" + getString(R.string.analyze_methods) + "/";
        }
        app_basescrollableactivity_icon.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.lighter(getResources().getColor(R.color.colorAccent), 0.01f)));
        outFileName = app_basescrollableactivity_title.getText().toString();
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongLessonsFragment BottomNavFragmentFromLessons = new BottomNavAmongLessonsFragment();
                BottomNavFragmentFromLessons.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout_in_scrollableactivity);
        toolBarLayout.setTitle(" "); //should be a space, otherwise the trick will not work
        appbar = findViewById(R.id.app_bar_in_scrollableactivity);
        NestedScrollView app_scrollableactivity_content_scrollview = findViewById(R.id.app_scrollableactivity_content_scrollview);
        EditText app_wordsearch_edittext = findViewById(R.id.app_wordsearch_edittext);
        Button searchword_button = findViewById(R.id.searchword_button);

        InputStream inputStream;
        final Markwon markwon = Markwon.create(getApplicationContext());
        try {
            if(sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("ortho_")) {
                inputStream = getAssets().open("mainrules/orthography/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT);
                markwon.setMarkdown(app_scrollableactivity_content_in_mainrules_text, AppUtils.convertStreamToString(inputStream));
            } else if(sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("punct_")){
                inputStream = getAssets().open("mainrules/punctuation/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT);
                markwon.setMarkdown(app_scrollableactivity_content_in_mainrules_text, AppUtils.convertStreamToString(inputStream));
            } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("dict_")) {
                inputStream = getAssets().open("dictionaries/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT);
                markwon.setMarkdown(app_scrollableactivity_content_in_mainrules_text, AppUtils.convertStreamToString(inputStream));
            } else {
                inputStream = getAssets().open("analyze_methods/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT);
                markwon.setMarkdown(app_scrollableactivity_content_in_mainrules_text, AppUtils.convertStreamToString(inputStream));
            }
        } catch (IOException e) {
            new StyleableToast.Builder(getApplicationContext())
                    .text(getString(R.string.error_while_reading_a_file)) // set text
                    .textBold() //set text bold
                    .iconStart(AppUtils.getIconWarning()) //icon in start of toast
                    .show(); //show custom toast
            e.printStackTrace();
        }

        searchword_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String criteria = app_wordsearch_edittext.getText().toString();
                String fullText = app_scrollableactivity_content_in_mainrules_text.getText().toString();

                AppUtils.resetHighLightedText(app_scrollableactivity_content_in_mainrules_text, fullText);

                if(criteria.equals(" ") | criteria.contains("        ") | criteria.isEmpty()){
                    new StyleableToast.Builder(getApplicationContext())
                            .text(getString(R.string.app_edittext_is_empty)) // set text
                            .textBold() //set text bold
                            .iconStart(AppUtils.getIconWarning()) //icon in start of toast
                            .show(); //show custom toast
                } else {
                    if (fullText.contains(criteria)) {
                        int indexOfCriteria = fullText.indexOf(criteria);
                        int lineNumber = app_scrollableactivity_content_in_mainrules_text.getLayout().getLineForOffset(indexOfCriteria);
                        AppUtils.setHighLightedText(app_scrollableactivity_content_in_mainrules_text, criteria);

                        app_scrollableactivity_content_scrollview.scrollTo(0, app_scrollableactivity_content_in_mainrules_text.getLayout().getLineTop(lineNumber));
                    }
                }
            }
        });

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                } else if(isShow) {
                    isShow = false;
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.app_scrollableactivity_menu, menu);
        this.menu = menu;

        try {
            if (AppBookmarkUtils.checkIfBookmarkExist(getApplicationContext(), sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME))) {
                menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.app_bookmark_minus));
                menu.getItem(1).setTitle(getResources().getString(R.string.app_remove_bookmark));
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, getResources().getString(R.string.app_error_occured));
            e.printStackTrace();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_word) {
            if(app_basescrollableactivity_toolbar_container.getVisibility()==View.VISIBLE){

                app_basescrollableactivity_toolbar_container.startAnimation(fade_out);
                app_basescrollableactivity_toolbar_container.setVisibility(View.GONE);

                app_basescrollableactivity_search_container.startAnimation(fade_in);
                app_basescrollableactivity_search_container.setVisibility(View.VISIBLE);

                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_warning_outline_menu));
            } else {
                app_basescrollableactivity_search_container.startAnimation(fade_out);
                app_basescrollableactivity_search_container.setVisibility(View.GONE);

                app_basescrollableactivity_toolbar_container.startAnimation(fade_in);
                app_basescrollableactivity_toolbar_container.setVisibility(View.VISIBLE);

                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_searchword));
            }
            appbar.setExpanded(true);
        } else if (id == R.id.bookmark) {
            if (menu.getItem(1).getTitle() == getResources().getString(R.string.app_add_bookmark)) {
                try {
                    AppBookmarkUtils.addBookmark(
                            getApplicationContext(),
                            sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME),
                            app_basescrollableactivity_title.getText().toString(),
                            app_basescrollableactivity_summary.getText().toString());
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.app_bookmark_minus));
                    menu.getItem(1).setTitle(getResources().getString(R.string.app_remove_bookmark));
                } catch (IOException | JSONException e) {
                    Log.e(LOG_TAG, getResources().getString(R.string.app_error_occured));
                    e.printStackTrace();
                }
            } else {
                try {
                    AppBookmarkUtils.removeBookmark(
                            getApplicationContext(),
                            sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME),
                            app_basescrollableactivity_title.getText().toString(),
                            app_basescrollableactivity_summary.getText().toString());
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.app_bookmark_plus));
                    menu.getItem(1).setTitle(getResources().getString(R.string.app_add_bookmark));
                } catch (IOException | JSONException e) {
                    Log.e(LOG_TAG, getResources().getString(R.string.app_error_occured));
                    e.printStackTrace();
                }
            }
        } else if (id == R.id.save_rule) {
            if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("ortho_")) {
                AppUtils.copyTXTFileFromAssets(
                        getApplicationContext(),
                        "mainrules/orthography/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT,
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/",
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.ortho) + "/",
                        outFileName, outFileDir,
                        getString(R.string.app_error_while_saving_file) + ":" + outFileDir + outFileName + Constants.FILE_EXPORT_FORMAT + "(" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_EXPORT_FORMAT + ")");
            } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("punct_")){
                AppUtils.copyTXTFileFromAssets(
                        getApplicationContext(),
                        "mainrules/punctuation/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT,
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/",
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.punct) + "/",
                        outFileName, outFileDir,
                        getString(R.string.app_error_while_saving_file) + ":" + outFileDir + outFileName + Constants.FILE_EXPORT_FORMAT + "(" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_EXPORT_FORMAT + ")");
            } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains("dict_")){
                AppUtils.copyTXTFileFromAssets(
                        getApplicationContext(),
                        "dictionaries/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT,
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/",
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.dictionaries) + "/",
                        outFileName, outFileDir,
                        getString(R.string.app_error_while_saving_file) + ":" + outFileDir + outFileName + Constants.FILE_EXPORT_FORMAT + "(" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_EXPORT_FORMAT + ")");
            } else {
                AppUtils.copyTXTFileFromAssets(
                        getApplicationContext(),
                        "analyze_methods/" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT,
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/",
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/Rulebook/" + getString(R.string.analyze_methods) + "/",
                        outFileName, outFileDir,
                        getString(R.string.app_error_while_saving_file) + ":" + outFileDir + outFileName + Constants.FILE_EXPORT_FORMAT + "(" + sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_EXPORT_FORMAT + ")");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

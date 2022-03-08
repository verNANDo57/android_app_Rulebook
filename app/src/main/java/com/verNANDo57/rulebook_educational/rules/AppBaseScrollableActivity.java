/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.bookmarks.AppBookmarkUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.markwon.Markwon;
import com.verNANDo57.rulebook_educational.search.SearchItemData;
import com.verNANDo57.rulebook_educational.search.SearchReferences;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AppBaseScrollableActivity extends CustomThemeEngineAppCompatActivity {
    private CoordinatorLayout mRootLayout;
    private RelativeLayout app_basescrollableactivity_toolbar_container;
    private RelativeLayout app_basescrollableactivity_search_container;
    private AppBarLayout appbar;

    private Animation fade_in;
    private Animation fade_out;

    private Menu menu;

    private String inputFileDir;
    private String exportFileDir;

    private TextView app_basescrollableactivity_title;
    private TextView app_basescrollableactivity_summary;

    private Intent sourceIntent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sourceIntent = getIntent();

        ArrayList<SearchItemData> listdata = SearchReferences.setupSearchData(getApplicationContext());

        fade_in = AnimationUtils.loadAnimation(this, R.anim.app_fade_in);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.app_fade_out);

        setContentView(R.layout.app_scrollable_activity);

        mRootLayout = findViewById(R.id.scrollableactivity_root);

        ImageView app_basescrollableactivity_icon = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_icon);
        app_basescrollableactivity_title = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_title);
        app_basescrollableactivity_summary = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_summary);
        TextView app_scrollableactivity_content_in_mainrules_text = findViewById(R.id.app_scrollableactivity_content_everywhere_text);
        app_basescrollableactivity_toolbar_container = findViewById(R.id.app_scrollableactivity_in_scrollableactivity_toolbarlayout_container);
        app_basescrollableactivity_search_container = findViewById(R.id.app_scrollableactivity_everywhere_toolbarlayout_search_container);

        Toolbar toolbar = findViewById(R.id.toolbar_in_scrollableactivity);
        if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains(Constants.ORTHOGRAPHY)) {
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.app_pen_icon));
            toolbar.setTitle(getString(R.string.ortho));
            inputFileDir = Constants.RULEBOOK_ORTHOGRAPHY_DIRECTORY_ASSETS;
            exportFileDir = Constants.RULEBOOK_APP_DIRECTORY + getString(R.string.ortho) + "/";
        } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains(Constants.PUNCTUATION)){
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.app_pencil_icon));
            toolbar.setTitle(getString(R.string.punct));
            inputFileDir = Constants.RULEBOOK_PUNCTUATION_DIRECTORY_ASSETS;
            exportFileDir = Constants.RULEBOOK_APP_DIRECTORY + getString(R.string.punct) + "/";
        } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains(Constants.DICTIONARIES)) {
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.app_char_icon));
            toolbar.setTitle(getString(R.string.dictionaries));
            inputFileDir = Constants.RULEBOOK_DICTIONARIES_DIRECTORY_ASSETS;
            exportFileDir = Constants.RULEBOOK_APP_DIRECTORY + getString(R.string.dictionaries) + "/";
        } else if (sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME).contains(Constants.ANALYZE_METHOD)) {
            app_basescrollableactivity_icon.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_search_menu));
            toolbar.setTitle(getString(R.string.analyze_methods));
            inputFileDir = Constants.RULEBOOK_ANALYZE_METHODS_DIRECTORY_ASSETS;
            exportFileDir = Constants.RULEBOOK_APP_DIRECTORY + getString(R.string.analyze_methods) + "/";
        }
        app_basescrollableactivity_title.setText(listdata.get(sourceIntent.getIntExtra(AppUtils.EXTRA_DATA_POSITION, 0)).getItemTitle());
        app_basescrollableactivity_summary.setText(listdata.get(sourceIntent.getIntExtra(AppUtils.EXTRA_DATA_POSITION, 0)).getItemDescription());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongLessonsFragment BottomNavFragmentFromLessons = new BottomNavAmongLessonsFragment();
                BottomNavFragmentFromLessons.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout_in_scrollableactivity);
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
            Snackbar.make(mRootLayout, getString(R.string.error_while_reading_a_file), Snackbar.LENGTH_LONG).show();
            e.printStackTrace();
        }

        searchword_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String criteria = app_wordsearch_edittext.getText().toString();
                String fullText = app_scrollableactivity_content_in_mainrules_text.getText().toString();

                AppUtils.resetHighLightedText(app_scrollableactivity_content_in_mainrules_text, fullText);

                if(criteria.equals(" ") | criteria.contains("        ") | criteria.isEmpty()){
                    Snackbar.make(mRootLayout, getString(R.string.app_edittext_is_empty), Snackbar.LENGTH_LONG).show();
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
                menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.app_bookmark_remove));
                menu.getItem(1).setTitle(getResources().getString(R.string.app_remove_bookmark));
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, getResources().getString(R.string.app_error_occurred));
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

                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_warning_menu));
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
                    Snackbar.make(mRootLayout, getResources().getString(R.string.app_bookmark_added), Snackbar.LENGTH_LONG).show();
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.app_bookmark_remove));
                    menu.getItem(1).setTitle(getResources().getString(R.string.app_remove_bookmark));
                } catch (IOException | JSONException e) {
                    Log.e(LOG_TAG, getResources().getString(R.string.app_error_occurred));
                    e.printStackTrace();
                }
            } else {
                try {
                    AppBookmarkUtils.removeBookmark(
                            getApplicationContext(),
                            sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME),
                            app_basescrollableactivity_title.getText().toString(),
                            app_basescrollableactivity_summary.getText().toString());
                    Snackbar.make(mRootLayout, getResources().getString(R.string.app_bookmark_removed), Snackbar.LENGTH_LONG).show();
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.app_bookmark_add));
                    menu.getItem(1).setTitle(getResources().getString(R.string.app_add_bookmark));
                } catch (IOException | JSONException e) {
                    Log.e(LOG_TAG, getResources().getString(R.string.app_error_occurred));
                    e.printStackTrace();
                }
            }
        } else if (id == R.id.save_rule) {
            AppUtils.copyFileFromAssets(
                    getApplicationContext(),
                    mRootLayout,
                    inputFileDir,
                    sourceIntent.getStringExtra(AppUtils.EXTRA_DATA_NAME) + Constants.FILE_FORMAT,
                    exportFileDir,
                    app_basescrollableactivity_title.getText() + Constants.FILE_EXPORT_FORMAT);
        }
        return super.onOptionsItemSelected(item);
    }
}

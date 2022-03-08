/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.bookmarks;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.verNANDo57.rulebook_educational.BottomNavAmongActivitiesFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineSwipeRefreshLayout;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.search.SearchReferences;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppBookmarksActivity extends CustomThemeEngineAppCompatActivity {

    private LinearLayout mRootLinearLayout;
    private final List<BookmarkItem> viewItems = new ArrayList<>();
    private BookmarkRecyclerAdapter mAdapter;
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private CustomThemeEngineSwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTextView;
    private Menu menu;
    private boolean selectionModeIsEnabled; // Using this boolean we can check if user started selecting bookmarks

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bookmarks);

        Toolbar toolbar = findViewById(R.id.toolbar_bookmarks);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongActivitiesFragment bottomNavFragmentAmongActivities = new BottomNavAmongActivitiesFragment();
                bottomNavFragmentAmongActivities.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        // Initialize root LinearLayout
        mRootLinearLayout = findViewById(R.id.bookmarks_root_linearlayout);
        // Initialize RecyclerView
        mRecyclerView = findViewById(R.id.bookmarks_recyclerview);
        // Disable RecyclerView refreshing animation
        mRecyclerView.setItemAnimator(null);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Initialize LayoutManager
        RecyclerView.LayoutManager layoutManager;
        // Check if device is tablet
        if (getResources().getBoolean(R.bool.deviceIsTablet)) {
            // If so, use GridLayoutManager
            layoutManager = new GridLayoutManager(this, AppUtils.calculateNumberOfColumns(this, getResources().getDimension(R.dimen.gridview_item_width)));
        } else {
            // Otherwise use LinearLayoutManager
            layoutManager = new LinearLayoutManager(this);
        }
        mRecyclerView.setLayoutManager(layoutManager);

        // Specify an adapter
        mAdapter = new BookmarkRecyclerAdapter(viewItems, new BookmarkHolder.ClickListener() {
            @Override
            public void onItemClicked(int position) {
                if (selectionModeIsEnabled) {
                    mAdapter.toggleSelection(position);
                    bookmarkSelectionMode();
                } else {
                    SearchReferences.performSearchItemOnClickAction(mRecyclerView.getContext(), mAdapter.listRecyclerItem.get(position).getObject_key(), SearchReferences.getItemPosition(mAdapter.listRecyclerItem.get(position).getObject_key()));
                }
            }

            @Override
            public boolean onItemLongClicked(int position) {
                if (!selectionModeIsEnabled) {
                    mAdapter.toggleSelection(position);
                    bookmarkSelectionMode();
                }
                return true;
            }

            @Override
            public void onItemSwiped(int position) {
                try {
                    // Make backup of bookmarksList file
                    AppBookmarkUtils.makeBookmarksListBackup(getApplicationContext());
                    // Remove bookmark
                    AppBookmarkUtils.removeBookmark(getApplicationContext(),
                            mAdapter.listRecyclerItem.get(position).getObject_key(),
                            mAdapter.listRecyclerItem.get(position).getObject_title(),
                            mAdapter.listRecyclerItem.get(position).getObject_summary());
                } catch (IOException | JSONException e) {
                    Log.e(LOG_TAG, getResources().getString(R.string.app_error_occurred));
                    e.printStackTrace();
                }
                // Show message (using Snackbar)
                Snackbar.make(mRootLinearLayout, getResources().getString(R.string.app_bookmark_removed), Snackbar.LENGTH_LONG)
                        .setAction(R.string.cancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Allow user to undo bookmark deletion if needed
                                AppBookmarkUtils.undoBookmarkDeletion(getApplicationContext());
                                performRefresh();
                            }
                        })
                        .show();
                // Clear selectedItems list
                mAdapter.clearSelection();
                // Perform refresh manually
                performRefresh();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        // Initialize ItemTouchHelper to handle swipe actions
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new BookmarkTouchHelperCallback(mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        // Initialize TextView that will be used in that time when mRecyclerView is empty
        mTextView = findViewById(R.id.bookmarks_empty_text);

        // Initialize list
        addItemsFromJSON();

        // Initialize EditText
        mEditText = findViewById(R.id.bookmark_edittext);
        // Filter our list after EditText content is changed
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Auto-generated method
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Auto-generated method
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Auto-generated method
                filter(s.toString());
            }
        });

        // Check if RecyclerView is empty after reading JSON
        // If so, then show message that there are no bookmarks
        checkIfRecyclerViewIsEmpty();

        // Initialize SwipeRefreshLayout
        mSwipeRefreshLayout = findViewById(R.id.bookmarks_swiperefreshlayout);
        // Set setOnRefreshListener
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Check if RecyclerView is empty after reading JSON
                // If so, then show message that there are no bookmarks
                refreshRecyclerView();

                // Stop refreshing animation
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.app_bookmarks_menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.menu_removeSelectedBookmarks) {
            try {
                // Make backup of bookmarksList file
                AppBookmarkUtils.makeBookmarksListBackup(getApplicationContext());
                // Get selected bookmarks count and remove them one by one using cycle
                for (int i=0;i!=mAdapter.getSelectedItemCount();i++) {
                    // Remove bookmarks
                    AppBookmarkUtils.removeBookmark(this,
                            mAdapter.listRecyclerItem.get(mAdapter.getSelectedItems().get(i)).getObject_key(),
                            mAdapter.listRecyclerItem.get(mAdapter.getSelectedItems().get(i)).getObject_title(),
                            mAdapter.listRecyclerItem.get(mAdapter.getSelectedItems().get(i)).getObject_summary());
                }
            } catch (IOException | JSONException e) {
                Log.e(LOG_TAG, getResources().getString(R.string.app_error_occurred));
                e.printStackTrace();
            }
            // Show message (using Snackbar)
            String toastMsg = getResources().getString(R.string.app_bookmark_removed); // If only one bookmark is going to be removed
            if (mAdapter.getSelectedItemCount()>1) {
                toastMsg = getResources().getString(R.string.app_several_bookmarks_removed); // If more than one bookmarks are going to be removed
            }
            Snackbar.make(mRootLinearLayout, toastMsg, Snackbar.LENGTH_LONG)
                    .setAction(R.string.cancel, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Allow user to undo bookmark deletion if needed
                            AppBookmarkUtils.undoBookmarkDeletion(getApplicationContext());
                            performRefresh();
                        }
                    })
                    .show();
            // Clear selectedItems list
            mAdapter.clearSelection();
            // Perform refresh manually
            performRefresh();
            // Quit bookmark selection mode if needed
            bookmarkSelectionMode();
        } else if (id == R.id.menu_selectAllBookmarks) {
            // Check if all bookmarks are selected
            if (mAdapter.getSelectedItemCount()!=mAdapter.getItemCount()){
                // If so, then check every bookmark in the list
                for (int i=0;i!=mAdapter.getItemCount();i++){
                    // Select only unselected ones
                    if(!mAdapter.isSelected(i)){
                        mAdapter.toggleSelection(i);
                    }
                }
            } else {
                // Otherwise unselect all bookmarks
                mAdapter.clearSelection();
            }
            bookmarkSelectionMode();
        } else if (id == R.id.menu_refresh) {
            // Perform refresh manually
            performRefresh();
        }
        return super.onOptionsItemSelected(item);
    }

    private String readJSONDataFromFile() throws IOException {
        FileInputStream fis = new FileInputStream (new File(getApplicationContext().getFilesDir(), AppBookmarkUtils.JSON_FILE));
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            String jsonString;
            inputStream = fis;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }
        } finally {
            inputStream.close();
        }
        fis.close();
        return new String(builder);
    }

    private void addItemsFromJSON() {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);
            for (int i=0; i<jsonArray.length(); ++i) {
                JSONObject itemObj = jsonArray.getJSONObject(i);

                String object_key = itemObj.getString(AppBookmarkUtils.JSON_OBJECT_KEY);
                String object_title = itemObj.getString(AppBookmarkUtils.JSON_OBJECT_TITLE);
                String object_summary = itemObj.getString(AppBookmarkUtils.JSON_OBJECT_SUMMARY);

                BookmarkItem bookmarkItem = new BookmarkItem(object_key,object_title, object_summary);
                viewItems.add(bookmarkItem);
            }
        } catch (JSONException | IOException e) {
            Log.d(LOG_TAG, "addItemsFromJSON: ", e);
        }
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        List<BookmarkItem> filteredList = new ArrayList<>();
        for (BookmarkItem item : viewItems) {
            if (item.getObject_title().toLowerCase().contains(charText)) {
                filteredList.add(item);
            } else if (item.getObject_summary().toLowerCase().contains(charText)) {
                filteredList.add(item);
            }
        }
        this.mAdapter.filterList(filteredList);
    }

    public void performRefresh() {
        // Start refreshing animation
        mSwipeRefreshLayout.setRefreshing(true);
        // Do refresh
        refreshRecyclerView();
        // Stop refreshing animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void refreshRecyclerView() {
        // Clear viewItems list
        viewItems.clear();
        // Re-read JSON file
        addItemsFromJSON();
        // Reload RecyclerView
        mAdapter.notifyDataSetChanged();
        // Check if RecyclerView is empty after reading JSON
        // If so, then show message that there are no bookmarks
        checkIfRecyclerViewIsEmpty();
    }

    public void checkIfRecyclerViewIsEmpty() {
        // If RecyclerView is empty
        if (mAdapter.getItemCount()==0 && mEditText.getVisibility()==View.VISIBLE && mRecyclerView.getVisibility()==View.VISIBLE && mTextView.getVisibility()==View.GONE) {
            // Hide EditText and RecyclerView
            mEditText.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.GONE);
            // Show our message
            mTextView.setVisibility(View.VISIBLE);
        } else if (mAdapter.getItemCount()>0 && mEditText.getVisibility()==View.GONE && mRecyclerView.getVisibility()==View.GONE && mTextView.getVisibility()==View.VISIBLE) {
            // Show EditText and RecyclerView
            mEditText.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
            // Hide our message
            mTextView.setVisibility(View.GONE);
        }
    }

    public void bookmarkSelectionMode() {
        if (mAdapter.getSelectedItemCount()>0) {
            selectionModeIsEnabled=true; // Enable bookmark selection mode
            menu.getItem(0).setVisible(true); // Show removeBookmarks menu button if one or more bookmarks are selected
            menu.getItem(1).setVisible(true); // Show selectAllBookmarks menu button if one or more bookmarks are selected
            menu.getItem(2).setVisible(false); // Hide refresh menu button if one or more bookmarks are selected
            if (mAdapter.getSelectedItemCount()>1) {
                menu.getItem(0).setTitle(getResources().getString(R.string.app_remove_several_bookmarks)); // Show this title if more than one bookmark selected
            } else {
                menu.getItem(0).setTitle(getResources().getString(R.string.app_remove_bookmark)); // Show this title if only one bookmark is selected
            }
        } else if (mAdapter.getSelectedItemCount()==0) {
            selectionModeIsEnabled=false; // Disable bookmark selection mode
            menu.getItem(0).setVisible(false); // Hide removeBookmarks menu button if there is no any selected bookmark
            menu.getItem(1).setVisible(false); // Hide selectAllBookmarks menu button if there is no any selected bookmark
            menu.getItem(2).setVisible(true); // Show refresh menu button if there is no any selected bookmark
        }
    }
}
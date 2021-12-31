package com.verNANDo57.rulebook_educational.bookmarks;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavAmongActivitiesFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;

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

    private RecyclerView mRecyclerView;
    private final List<BookmarkItem> viewItems = new ArrayList<>();

    private BookmarkRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
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

        mRecyclerView = findViewById(R.id.bookmarks_recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BookmarkRecyclerAdapter(this, viewItems);
        mRecyclerView.setAdapter(mAdapter);

        addItemsFromJSON();

        EditText editText = findViewById(R.id.bookmark_edittext);
        editText.addTextChangedListener(new TextWatcher() {
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
}

/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.search;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.BottomNavAmongActivitiesFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.util.ArrayList;
import java.util.Locale;

public class AppSearchActivity extends CustomThemeEngineAppCompatActivity {

    private SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_search);

        Toolbar toolbar = findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongActivitiesFragment bottomNavFragmentAmongActivities = new BottomNavAmongActivitiesFragment();
                bottomNavFragmentAmongActivities.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        // Init
        RecyclerView recyclerView = findViewById(R.id.search_recyclerview);
        searchAdapter = new SearchAdapter(SearchReferences.setupSearchData(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
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
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(searchAdapter);

        EditText search_edittext = findViewById(R.id.search_edittext);
        search_edittext.addTextChangedListener(new TextWatcher() {
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

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        ArrayList<SearchItemData> filteredList = new ArrayList<>();
        for (SearchItemData item : SearchReferences.setupSearchData(getApplicationContext())) {
            if (item.getItemTitle().toLowerCase().contains(charText)) {
                filteredList.add(item);
            } else if (item.getItemDescription().toLowerCase().contains(charText)) {
                filteredList.add(item);
            }
        }
        this.searchAdapter.filterList(filteredList);
    }
}

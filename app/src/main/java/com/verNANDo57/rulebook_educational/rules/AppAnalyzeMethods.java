/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.rules;

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
import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.data.RuleItemData;
import com.verNANDo57.rulebook_educational.rules.data.RulesDatabase;
import com.verNANDo57.rulebook_educational.rules.mainrules.BaseRecyclerViewAdapterOne;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.util.ArrayList;
import java.util.Locale;

public class AppAnalyzeMethods extends CustomThemeEngineAppCompatActivity {

    private BaseRecyclerViewAdapterOne baseRecyclerViewAdapterOne;
    private ArrayList<RuleItemData> viewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_analyze_methods);

        Toolbar toolbar = findViewById(R.id.toolbar_analyze_methods);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new NavigationView.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavAmongLessonsFragment BottomNavBetweenLessons = new BottomNavAmongLessonsFragment();
                BottomNavBetweenLessons.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        viewItems = RulesDatabase.setupAnalyzeMethodsRulesData(this);

        //Init
        RecyclerView recyclerView = findViewById(R.id.base_recyclerview);
        baseRecyclerViewAdapterOne = new BaseRecyclerViewAdapterOne(viewItems);
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
        recyclerView.setAdapter(baseRecyclerViewAdapterOne);

        EditText search_edittext = findViewById(R.id.base_edittext);
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
        ArrayList<RuleItemData> filteredList = new ArrayList<>();
        for (RuleItemData item : viewItems) {
            if (item.getItemTitle().toLowerCase().contains(charText)) {
                filteredList.add(item);
            } else if (item.getItemSummary().toLowerCase().contains(charText)) {
                filteredList.add(item);
            }
        }
        this.baseRecyclerViewAdapterOne.filterList(filteredList);
    }
}

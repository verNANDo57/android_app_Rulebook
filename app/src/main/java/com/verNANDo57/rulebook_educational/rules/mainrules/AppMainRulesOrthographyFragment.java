/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules.mainrules;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.data.RuleItemData;
import com.verNANDo57.rulebook_educational.rules.data.RulesDatabase;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.util.ArrayList;
import java.util.Locale;

public class AppMainRulesOrthographyFragment extends Fragment {

    private BaseRecyclerViewAdapterOne baseRecyclerViewAdapterOne;
    private ArrayList<RuleItemData> viewItems;

    public AppMainRulesOrthographyFragment() {
        //required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_base_recyclerview, container, false);

        Context context = view.getContext();
        viewItems = RulesDatabase.setupOrthographyRulesData(context);

        //Init
        RecyclerView recyclerView = view.findViewById(R.id.base_recyclerview);
        baseRecyclerViewAdapterOne = new BaseRecyclerViewAdapterOne(viewItems);
        recyclerView.setHasFixedSize(true);
        // Initialize LayoutManager
        RecyclerView.LayoutManager layoutManager;
        // Check if device is tablet
        if (getResources().getBoolean(R.bool.deviceIsTablet)) {
            // If so, use GridLayoutManager
            layoutManager = new GridLayoutManager(context, AppUtils.calculateNumberOfColumns(context, getResources().getDimension(R.dimen.gridview_item_width)));
        } else {
            // Otherwise use LinearLayoutManager
            layoutManager = new LinearLayoutManager(context);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(baseRecyclerViewAdapterOne);

        EditText search_edittext = view.findViewById(R.id.base_edittext);
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

        return view;
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
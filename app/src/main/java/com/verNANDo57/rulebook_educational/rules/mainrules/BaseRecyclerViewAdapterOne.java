/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/05/14 6:00PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules.mainrules;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.bookmarks.AppBookmarkUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.data.RuleItemData;
import com.verNANDo57.rulebook_educational.rules.data.RulesDatabase;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class BaseRecyclerViewAdapterOne extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    public ArrayList<RuleItemData> listdata;
    public BaseRecyclerViewAdapterOne(ArrayList<RuleItemData> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_recyclerview_item, parent, false);
        return new BaseRecyclerViewHolder(listItem, listdata);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        // Set Context
        Context context = holder.itemView.getContext();
        // Set CardView title
        holder.base_item_title.setText(listdata.get(holder.getAdapterPosition()).getItemTitle());
        // Set CardView Summary
        holder.base_item_summary.setText(listdata.get(holder.getAdapterPosition()).getItemSummary());
        // Set CardView Icon (Drawable from resource)
        holder.base_item_imageview.setImageResource(listdata.get(holder.getAdapterPosition()).getItemImgId());
        // Set CardView ImageButton background (Drawable from resource)
        holder.base_item_imagebutton.setImageResource(listdata.get(holder.getAdapterPosition()).getItem_imageBtnId());
        // Handle CardView onClick action
        holder.base_item_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RulesDatabase.performOnClickAction(context, listdata.get(holder.getAdapterPosition()).getItem_key(), listdata.get(holder.getAdapterPosition()).getItemTitle(), listdata.get(holder.getAdapterPosition()).getItemSummary());
            }
        });
        // Handle ImageButton click action
        holder.base_item_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // If bookmark exist...
                    if (AppBookmarkUtils.checkIfBookmarkExist(context, listdata.get(holder.getAdapterPosition()).getItem_key())) {
                        // Then remove bookmark
                        AppBookmarkUtils.removeBookmark(context, listdata.get(holder.getAdapterPosition()).getItem_key(), listdata.get(holder.getAdapterPosition()).getItemTitle(), listdata.get(holder.getAdapterPosition()).getItemSummary());
                        listdata.get(holder.getAdapterPosition()).setItem_imageBtnId(holder.ITEM_IS_NOT_BOOKMARKED);
                        holder.base_item_imagebutton.setImageResource(holder.ITEM_IS_NOT_BOOKMARKED);
                    } else {
                        // Otherwise add bookmark
                        AppBookmarkUtils.addBookmark(context, listdata.get(holder.getAdapterPosition()).getItem_key(), listdata.get(holder.getAdapterPosition()).getItemTitle(), listdata.get(holder.getAdapterPosition()).getItemSummary());
                        listdata.get(holder.getAdapterPosition()).setItem_imageBtnId(holder.ITEM_IS_BOOKMARKED);
                        holder.base_item_imagebutton.setImageResource(holder.ITEM_IS_BOOKMARKED);
                    }
                } catch (IOException | JSONException e) {
                    Log.e(AppUtils.LOG_TAG, context.getString(R.string.app_error_occurred));
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<RuleItemData> filteredList) {
        listdata = filteredList;
        notifyDataSetChanged();
    }
}

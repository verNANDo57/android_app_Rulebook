/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.search;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.extradata.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchHolder> {

    public static ArrayList<SearchItemData> listdata;
    public SearchAdapter(ArrayList<SearchItemData> listdata) {
        SearchAdapter.listdata = listdata;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recyclerview_item, parent, false);
        return new SearchHolder(listItem, listdata);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        // Set CardView title
        holder.search_item_title.setText(listdata.get(holder.getAdapterPosition()).getItemTitle());
        // Set CardView Summary
        holder.search_item_summary.setText(listdata.get(holder.getAdapterPosition()).getItemDescription());
        // Set CardView Icon (Drawable from resource)
        holder.search_item_imageview.setImageResource(listdata.get(holder.getAdapterPosition()).getItemImgId());
        // Set CardView ImageButton background (Drawable from resource)
        holder.search_item_imagebutton.setImageResource(listdata.get(holder.getAdapterPosition()).getItem_imageBtnId());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<SearchItemData> filteredList) {
        listdata = filteredList;
        notifyDataSetChanged();
    }
}

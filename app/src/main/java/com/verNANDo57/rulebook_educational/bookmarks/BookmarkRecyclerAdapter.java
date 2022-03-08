/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.bookmarks;

import android.annotation.SuppressLint;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.Constants;

import java.util.ArrayList;
import java.util.List;

public class BookmarkRecyclerAdapter extends RecyclerView.Adapter<BookmarkHolder> implements BookmarkTouchHelperAdapter{

    public List<BookmarkItem> listRecyclerItem;
    private final BookmarkHolder.ClickListener clickListener;
    public SparseBooleanArray selectedItems;

    public BookmarkRecyclerAdapter(List<BookmarkItem> listRecyclerItem, BookmarkHolder.ClickListener clickListener) {
        this.listRecyclerItem = listRecyclerItem;
        this.clickListener = clickListener;
        selectedItems = new SparseBooleanArray();
    }

    @NonNull
    @Override
    public BookmarkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bookmark_recyclerview_item, viewGroup, false);
        return new BookmarkHolder((layoutView), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkHolder holder, int position) {
        // Set CardView title
        holder.bookmark_title.setText(listRecyclerItem.get(holder.getAdapterPosition()).getObject_title());
        // Set CardView summary
        holder.bookmark_summary.setText(listRecyclerItem.get(holder.getAdapterPosition()).getObject_summary());
        // Set CardView's ImageView drawable from resource
        if (listRecyclerItem.get(holder.getAdapterPosition()).getObject_key().contains(Constants.ORTHOGRAPHY)) {
            holder.bookmark_imageview.setImageResource(R.drawable.app_pen_icon);
        } else if (listRecyclerItem.get(holder.getAdapterPosition()).getObject_key().contains(Constants.PUNCTUATION)) {
            holder.bookmark_imageview.setImageResource(R.drawable.app_pencil_icon);
        } else if (listRecyclerItem.get(holder.getAdapterPosition()).getObject_key().contains(Constants.DICTIONARIES)) {
            holder.bookmark_imageview.setImageResource(R.drawable.app_char_icon);
        } else {
            holder.bookmark_imageview.setImageResource(R.drawable.app_search);
        }
        // Highlight the CardView if it's selected
        holder.bookmark_selected_imageview.setVisibility(isSelected(position) ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * Indicates if the item at position position is selected
     * @param position Position of the item to check
     * @return true if the item is selected, false otherwise
     */
    public boolean isSelected(int position) {
        return getSelectedItems().contains(position);
    }

    /**
     * Toggle the selection status of the item at a given position
     * @param position Position of the item to toggle the selection status for
     */
    public void toggleSelection(int position) {
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }

    /**
     * Clear the selection status for all items
     */
    public void clearSelection() {
        List<Integer> selection = getSelectedItems();
        selectedItems.clear();
        for (Integer i : selection) {
            notifyItemChanged(i);
        }
    }

    /**
     * Count the selected items
     * @return Selected items count
     */
    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    /**
     * Indicates the list of selected items
     * @return List of selected items ids
     */
    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); ++i) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

    @Override
    public void onItemSwiped(int position) {
        if (BookmarkHolder.listener != null) {
            BookmarkHolder.listener.onItemSwiped(position);
        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(List<BookmarkItem> filteredList) {
        listRecyclerItem = filteredList;
        notifyDataSetChanged();
    }
}

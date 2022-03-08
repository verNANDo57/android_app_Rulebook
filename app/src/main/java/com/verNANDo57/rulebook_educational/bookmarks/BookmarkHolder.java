/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/03/08 3:07PM GMT+7
 */

package com.verNANDo57.rulebook_educational.bookmarks;

import android.animation.AnimatorInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.extradata.R;

public class BookmarkHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

    // Define CardView
    public static CardView bookmark_card;
    // Define CardView's ImageView
    public ImageView bookmark_imageview;
    // Define CardView's ImageView that shows up when CardView is selected
    public ImageView bookmark_selected_imageview;
    // Define CardView's Title TextView
    public TextView bookmark_title;
    // Define CardView's Summary TextView
    public TextView bookmark_summary;
    // Define ClickListener Interface
    public static ClickListener listener;

    public BookmarkHolder(@NonNull View itemView, ClickListener listener) {
        super(itemView);
        // Initialize CardView
        bookmark_card = itemView.findViewById(R.id.recycler_view_item_card);
        // Initialize CardView's ImageView
        bookmark_imageview = itemView.findViewById(R.id.cardview_image);
        // Initialize CardView's ImageView that shows up when CardView is selected
        bookmark_selected_imageview = itemView.findViewById(R.id.cardview_selected_imageview);
        // Initialize CardView's Title TextView
        bookmark_title = itemView.findViewById(R.id.recyclerview_item_title);
        // Initialize CardView's Summary TextView
        bookmark_summary = itemView.findViewById(R.id.recyclerview_item_summary);
        // Set CardView background value to TRANSPARENT (equals 0) to make it look better
        bookmark_card.setCardBackgroundColor(0);
        // Remove shadow around cardview to make it look better
        bookmark_card.setCardElevation(0);
        // Set custom StateListAnimator
        bookmark_card.setStateListAnimator(AnimatorInflater.loadStateListAnimator(itemView.getContext(), R.animator.btn_anim_zoom));
        // Initialize clickListener interface
        BookmarkHolder.listener = listener;
        // Initialize onClickListener
        itemView.setOnClickListener(this);
        // Initialize onLongClickListener
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onItemClicked(getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (listener != null) {
            return listener.onItemLongClicked(getAdapterPosition());
        }
        return true;
    }

    public interface ClickListener {
        void onItemClicked(int position);
        boolean onItemLongClicked(int position);
        void onItemSwiped(int position);
    }
}

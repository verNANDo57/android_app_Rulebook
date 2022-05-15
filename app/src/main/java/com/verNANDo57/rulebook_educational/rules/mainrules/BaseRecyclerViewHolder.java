/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/05/14 6:00PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules.mainrules;

import android.animation.AnimatorInflater;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.bookmarks.AppBookmarkUtils;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.data.RuleItemData;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.io.IOException;
import java.util.ArrayList;

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public Integer ITEM_IS_BOOKMARKED = R.drawable.app_bookmark_added;
    public Integer ITEM_IS_NOT_BOOKMARKED = R.drawable.app_bookmark_removed;

    // Define CardView
    public final CardView base_item_card;
    // Define CardView's ImageView
    public final ImageView base_item_imageview;
    // Define CardView's ImageView that shows up when CardView is bookmarked
    public final ImageButton base_item_imagebutton;
    // Define CardView's Title TextView
    public final TextView base_item_title;
    // Define CardView's Summary TextView
    public final TextView base_item_summary;

    public BaseRecyclerViewHolder(@NonNull View itemView, ArrayList<RuleItemData> listdata) {
        super(itemView);
        // Initialize CardView
        base_item_card = itemView.findViewById(R.id.recycler_view_item_card);
        // Initialize CardView's ImageView
        base_item_imageview = itemView.findViewById(R.id.cardview_image);
        // Initialize CardView's ImageView that shows up when CardView is bookmarked
        base_item_imagebutton = itemView.findViewById(R.id.cardview_imagebutton);
        // Initialize CardView's Title TextView
        base_item_title = itemView.findViewById(R.id.recyclerview_item_title);
        // Initialize CardView's Summary TextView
        base_item_summary = itemView.findViewById(R.id.recyclerview_item_summary);
        // Set CardView background value to TRANSPARENT (equals 0) to make it look better
        base_item_card.setCardBackgroundColor(0);
        // Remove shadow around CardView to make it look better
        base_item_card.setCardElevation(0);
        // Set custom StateListAnimator
        base_item_card.setStateListAnimator(AnimatorInflater.loadStateListAnimator(itemView.getContext(), R.animator.btn_anim_zoom));
        // If item is already bookmarked, then change imagebutton background
        for (int i=0;i<listdata.size();i++) {
            try {
                if (AppBookmarkUtils.checkIfBookmarkExist(itemView.getContext(), listdata.get(i).getItem_key())) {
                    listdata.get(i).setItem_imageBtnId(ITEM_IS_BOOKMARKED);
                }
            } catch (IOException e) {
                Log.e(AppUtils.LOG_TAG, itemView.getContext().getString(R.string.app_error_occurred));
                e.printStackTrace();
            }
        }
    }
}

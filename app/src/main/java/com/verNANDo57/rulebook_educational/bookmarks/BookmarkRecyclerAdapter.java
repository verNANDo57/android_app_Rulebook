/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.bookmarks;

import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.search.SearchReferences;
import com.verNANDo57.rulebook_educational.utils.ColorUtils;

import java.util.List;

public class BookmarkRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class BookmarkHolder extends RecyclerView.ViewHolder {

        private final CardView bookmark_card;
        private final ImageView bookmark_imageview;
        private final TextView bookmark_title;
        private final TextView bookmark_summary;

        public BookmarkHolder(@NonNull View itemView) {
            super(itemView);
            bookmark_card = itemView.findViewById(R.id.recycler_view_item_card);
            bookmark_imageview = itemView.findViewById(R.id.recyclerview_image);
            bookmark_title = (TextView) itemView.findViewById(R.id.recyclerview_item_title);
            bookmark_summary = (TextView) itemView.findViewById(R.id.recyclerview_item_summary);
        }
    }

    private final Context context;
    public List<BookmarkItem> listRecyclerItem;

    public BookmarkRecyclerAdapter(Context context, List<BookmarkItem> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new BookmarkHolder((layoutView));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BookmarkHolder itemViewHolder = (BookmarkHolder) viewHolder;
        BookmarkItem bookmarkItem = (BookmarkItem) listRecyclerItem.get(i);

        itemViewHolder.bookmark_title.setText(bookmarkItem.getObject_title());
        itemViewHolder.bookmark_summary.setText(bookmarkItem.getObject_summary());
        if (bookmarkItem.getObject_key().contains("ortho_")) {
            itemViewHolder.bookmark_imageview.setImageResource(R.drawable.app_pen_icon);
        } else if (bookmarkItem.getObject_key().contains("punct_")) {
            itemViewHolder.bookmark_imageview.setImageResource(R.drawable.app_pencil_icon);
        } else if (bookmarkItem.getObject_key().contains("dict_")) {
            itemViewHolder.bookmark_imageview.setImageResource(R.drawable.app_char_icon);
        } else {
            itemViewHolder.bookmark_imageview.setImageResource(R.drawable.ic_search);
        }
        itemViewHolder.bookmark_imageview.setColorFilter(ColorUtils.lighter(context.getResources().getColor(R.color.colorAccent), 0.01f));

        //Set CardView background value to TRANSPARENT (equals 0) to make it look better
        itemViewHolder.bookmark_card.setCardBackgroundColor(0);

        //Remove shadow around cardview to make it look better
        itemViewHolder.bookmark_card.setCardElevation(0);

        //Set custom StateListAnimator
        itemViewHolder.bookmark_card.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.btn_anim_fade));

        itemViewHolder.bookmark_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get context from any VIEW object instead of passing CONTEXT as an argument to SearchAdapter and keeping it as class field
                SearchReferences.performSearchItemOnClickAction(context, itemViewHolder.bookmark_title.getText().toString());
            }
        });
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

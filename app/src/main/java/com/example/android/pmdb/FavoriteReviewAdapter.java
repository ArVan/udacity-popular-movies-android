package com.example.android.pmdb;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.pmdb.provider.movie.MovieCursor;
import com.example.android.pmdb.provider.review.ReviewColumns;
import com.example.android.pmdb.provider.review.ReviewCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by arpy on 10/18/15.
 */
public class FavoriteReviewAdapter extends CursorRecyclerViewAdapter<FavoriteReviewAdapter.ViewHolder> {
    Context mContext;

    public FavoriteReviewAdapter(Context context, Cursor cursor){
        super(context, cursor);
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mRootView;
        public TextView mAuthor;
        public TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mRootView = (LinearLayout) itemView.findViewById(R.id.list_item_review);
            mAuthor = (TextView) itemView.findViewById(R.id.review_author);
            mContent = (TextView) itemView.findViewById(R.id.review_content);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_review, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        ReviewCursor reviewCursor = new ReviewCursor(cursor);

        viewHolder.mAuthor.setText(reviewCursor.getAuthor());
        viewHolder.mContent.setText(reviewCursor.getContent());
    }
}

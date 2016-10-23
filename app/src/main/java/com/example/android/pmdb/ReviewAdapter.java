package com.example.android.pmdb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arpy on 10/6/15.
 */
public class ReviewAdapter  extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>  {
    Context mContext;

    // Store a member variable for the movies
    private ArrayList<Review> mReviews;

    // Pass in the movie array into the constructor
    public ReviewAdapter(Context context, ArrayList<Review> reviews) {
        mContext = context;
        mReviews = reviews;
    }

    // View lookup cache
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mRootView;
        public TextView mAuthor;
        public TextView mContent;

        public ViewHolder(Context context, View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            mRootView = (LinearLayout) itemView.findViewById(R.id.list_item_review);
            mAuthor = (TextView) itemView.findViewById(R.id.review_author);
            mContent = (TextView) itemView.findViewById(R.id.review_content);
        }
    }


    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View reviewView = inflater.inflate(R.layout.list_item_review, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context, reviewView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ReviewAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        Review review = mReviews.get(position);

        // Set item views based on the data model
        viewHolder.mAuthor.setText(review.getAuthor());
        viewHolder.mContent.setText(review.getContent());
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return mReviews.size();
    }
}

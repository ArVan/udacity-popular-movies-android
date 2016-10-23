package com.example.android.pmdb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by arpy on 8/5/15.
 */
public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> {
    Context mContext;

    // Store a member variable for the movies
    private List<Movie> mMovies;

    // Pass in the movie array into the constructor
    public ThumbnailAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    // View lookup cache
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mRootView;
        public ImageView mPoster;
        public TextView mTitle;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            mRootView = (RelativeLayout) itemView.findViewById(R.id.grid_item_movie);
            mPoster = (ImageView) itemView.findViewById(R.id.thumbnail_poster);
            mTitle = (TextView) itemView.findViewById(R.id.thumbnail_title);

            // Store the context
            this.context = context;
        }
    }


    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ThumbnailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View thumbnailView = inflater.inflate(R.layout.grid_item_movie, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context, thumbnailView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ThumbnailAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        Movie movie = mMovies.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.mTitle;
        textView.setText(movie.getTitle());

        viewHolder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Movie movie = mMovies.get(position);
                ((Callback) mContext).onItemSelected(movie);
            }
        });

        Picasso.with(mContext).load(Constant.TMDB_URL_IMAGE_BASE + "/w342/" + movie.getPosterPath()).into(viewHolder.mPoster);
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}

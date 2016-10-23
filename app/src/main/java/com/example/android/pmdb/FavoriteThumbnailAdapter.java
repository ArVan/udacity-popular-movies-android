package com.example.android.pmdb;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.pmdb.provider.movie.MovieCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by arpy on 10/18/15.
 */
public class FavoriteThumbnailAdapter extends CursorRecyclerViewAdapter<FavoriteThumbnailAdapter.ViewHolder> {
    Context mContext;

    public FavoriteThumbnailAdapter(Context context, Cursor cursor){
        super(context, cursor);
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mRootView;
        public ImageView mPoster;
        public TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            mRootView = (RelativeLayout) itemView.findViewById(R.id.grid_item_movie);
            mPoster = (ImageView) itemView.findViewById(R.id.thumbnail_poster);
            mTitle = (TextView) itemView.findViewById(R.id.thumbnail_title);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        MovieCursor movieCursor = new MovieCursor(cursor);
        final Movie movie = new Movie(movieCursor);

        viewHolder.mTitle.setText(movieCursor.getTitle());
        Picasso.with(mContext).load(Constant.TMDB_URL_IMAGE_BASE + "/w342/" + movieCursor.getPoster()).into(viewHolder.mPoster);

        viewHolder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Callback) mContext).onItemSelected(movie);
            }
        });
    }
}

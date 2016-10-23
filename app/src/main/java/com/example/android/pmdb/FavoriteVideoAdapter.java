package com.example.android.pmdb;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.pmdb.provider.video.VideoColumns;
import com.example.android.pmdb.provider.video.VideoCursor;

/**
 * Created by arpy on 10/18/15.
 */
public class FavoriteVideoAdapter extends CursorRecyclerViewAdapter<FavoriteVideoAdapter.ViewHolder> {
    Context mContext;

    public FavoriteVideoAdapter(Context context, Cursor cursor){
        super(context, cursor);
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mRootView;
        public TextView mTitle;
        public TextView mSize;

        public ViewHolder(View view) {
            super(view);
            mRootView = (LinearLayout) itemView.findViewById(R.id.list_item_video);
            mTitle = (TextView) itemView.findViewById(R.id.video_name);
            mSize = (TextView) itemView.findViewById(R.id.video_size);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_video, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        final VideoCursor videoCursor = new VideoCursor(cursor);

        // Set item views based on the data model
        viewHolder.mTitle.setText(videoCursor.getName());
        viewHolder.mSize.setText("(" + videoCursor.getSize() + "p)");

        viewHolder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoCursor.getSite().equals("YouTube")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + videoCursor.getKey()));
                    mContext.startActivity(intent);
                }
            }
        });
    }
}

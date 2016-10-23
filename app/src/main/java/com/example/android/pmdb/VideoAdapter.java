package com.example.android.pmdb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arpy on 8/5/15.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    Context mContext;

    // Store a member variable for the movies
    private ArrayList<Video> mVideos;
    private float mItemHeight;

    public float getItemHeight() {
        return mItemHeight;
    }

    // Pass in the movie array into the constructor
    public VideoAdapter(Context context, ArrayList<Video> videos) {
        mContext = context;
        mVideos = videos;
        mItemHeight = 0;
    }

    // View lookup cache
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mRootView;
        public TextView mTitle;
        public TextView mSize;

        public ViewHolder(Context context, View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            mRootView = (LinearLayout) itemView.findViewById(R.id.list_item_video);
            mTitle = (TextView) itemView.findViewById(R.id.video_name);
            mSize = (TextView) itemView.findViewById(R.id.video_size);
        }
    }


    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View videoView = inflater.inflate(R.layout.list_item_video, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context, videoView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(VideoAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        Video video = mVideos.get(position);

        // Set item views based on the data model
        viewHolder.mTitle.setText(video.getName());
        viewHolder.mSize.setText("(" + video.getSize() + "p)");

        if(mItemHeight == 0) {
            mItemHeight = viewHolder.mRootView.getMeasuredHeight();
        }

        viewHolder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Video theVideo = mVideos.get(position);
                if (theVideo.getSite().equals("YouTube")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + theVideo.getKey()));
                    mContext.startActivity(intent);
                }
            }
        });
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return mVideos.size();
    }
}

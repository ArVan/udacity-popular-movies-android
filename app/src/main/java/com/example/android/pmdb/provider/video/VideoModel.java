package com.example.android.pmdb.provider.video;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * The videos related to a movie saved as favorite
 */
public interface VideoModel extends BaseModel {

    /**
     * The Video ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    String getVideoId();

    /**
     * Get the {@code iso} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getIso();

    /**
     * Get the {@code key} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getKey();

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * Get the {@code site} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getSite();

    /**
     * Get the {@code size} value.
     */
    int getSize();

    /**
     * Get the {@code type} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getType();

    /**
     * Get the {@code movie_id} value.
     */
    long getMovieId();
}

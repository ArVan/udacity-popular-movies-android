package com.example.android.pmdb.provider.review;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * The reviews of a movie saved as favorite
 */
public interface ReviewModel extends BaseModel {

    /**
     * The Review ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    String getReviewId();

    /**
     * The review author
     * Cannot be {@code null}.
     */
    @NonNull
    String getAuthor();

    /**
     * The review text
     * Cannot be {@code null}.
     */
    @NonNull
    String getContent();

    /**
     * The review url
     * Cannot be {@code null}.
     */
    @NonNull
    String getUrl();

    /**
     * Get the {@code movie_id} value.
     */
    long getMovieId();
}

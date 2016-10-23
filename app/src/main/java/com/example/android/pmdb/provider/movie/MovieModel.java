package com.example.android.pmdb.provider.movie;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A movie saved as favorite
 */
public interface MovieModel extends BaseModel {

    /**
     * The Movie ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    Integer getMovieId();

    /**
     * The movie title
     * Cannot be {@code null}.
     */
    @NonNull
    String getTitle();

    /**
     * Get the {@code original_title} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getOriginalTitle();

    /**
     * Get the {@code poster} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPoster();

    /**
     * Get the {@code backdrop} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBackdrop();

    /**
     * Get the {@code genres} value.
     * Can be {@code null}.
     */
    @Nullable
    String getGenres();

    /**
     * Get the {@code countries} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCountries();

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOverview();

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    String getReleasedate();

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getPopularity();

    /**
     * Get the {@code voteaverage} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getVoteaverage();

    /**
     * Get the {@code votecount} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getVotecount();

    /**
     * Get the {@code runtime} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getRuntime();

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStatus();
}

package com.example.android.pmdb.provider.movie;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movie} table.
 */
public class MovieContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MovieSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MovieSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * The Movie ID field from TMDB
     */
    public MovieContentValues putMovieId(@Nullable Integer value) {
        mContentValues.put(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieContentValues putMovieIdNull() {
        mContentValues.putNull(MovieColumns.MOVIE_ID);
        return this;
    }

    /**
     * The movie title
     */
    public MovieContentValues putTitle(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("title must not be null");
        mContentValues.put(MovieColumns.TITLE, value);
        return this;
    }


    public MovieContentValues putOriginalTitle(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("originalTitle must not be null");
        mContentValues.put(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }


    public MovieContentValues putPoster(@Nullable String value) {
        mContentValues.put(MovieColumns.POSTER, value);
        return this;
    }

    public MovieContentValues putPosterNull() {
        mContentValues.putNull(MovieColumns.POSTER);
        return this;
    }

    public MovieContentValues putBackdrop(@Nullable String value) {
        mContentValues.put(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieContentValues putBackdropNull() {
        mContentValues.putNull(MovieColumns.BACKDROP);
        return this;
    }

    public MovieContentValues putGenres(@Nullable String value) {
        mContentValues.put(MovieColumns.GENRES, value);
        return this;
    }

    public MovieContentValues putGenresNull() {
        mContentValues.putNull(MovieColumns.GENRES);
        return this;
    }

    public MovieContentValues putCountries(@Nullable String value) {
        mContentValues.put(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieContentValues putCountriesNull() {
        mContentValues.putNull(MovieColumns.COUNTRIES);
        return this;
    }

    public MovieContentValues putOverview(@Nullable String value) {
        mContentValues.put(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieContentValues putOverviewNull() {
        mContentValues.putNull(MovieColumns.OVERVIEW);
        return this;
    }

    public MovieContentValues putReleasedate(@Nullable String value) {
        mContentValues.put(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieContentValues putReleasedateNull() {
        mContentValues.putNull(MovieColumns.RELEASEDATE);
        return this;
    }

    public MovieContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieContentValues putPopularityNull() {
        mContentValues.putNull(MovieColumns.POPULARITY);
        return this;
    }

    public MovieContentValues putVoteaverage(@Nullable Double value) {
        mContentValues.put(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieContentValues putVoteaverageNull() {
        mContentValues.putNull(MovieColumns.VOTEAVERAGE);
        return this;
    }

    public MovieContentValues putVotecount(@Nullable Integer value) {
        mContentValues.put(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieContentValues putVotecountNull() {
        mContentValues.putNull(MovieColumns.VOTECOUNT);
        return this;
    }

    public MovieContentValues putRuntime(@Nullable Integer value) {
        mContentValues.put(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieContentValues putRuntimeNull() {
        mContentValues.putNull(MovieColumns.RUNTIME);
        return this;
    }

    public MovieContentValues putStatus(@Nullable String value) {
        mContentValues.put(MovieColumns.STATUS, value);
        return this;
    }

    public MovieContentValues putStatusNull() {
        mContentValues.putNull(MovieColumns.STATUS);
        return this;
    }
}

package com.example.android.pmdb.provider.movie;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movie} table.
 */
public class MovieCursor extends AbstractCursor implements MovieModel {
    public MovieCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MovieColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The Movie ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    public Integer getMovieId() {
        Integer res = getIntegerOrNull(MovieColumns.MOVIE_ID);
        return res;
    }

    /**
     * The movie title
     * Cannot be {@code null}.
     */
    @NonNull
    public String getTitle() {
        String res = getStringOrNull(MovieColumns.TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code original_title} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getOriginalTitle() {
        String res = getStringOrNull(MovieColumns.ORIGINAL_TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'original_title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code poster} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPoster() {
        String res = getStringOrNull(MovieColumns.POSTER);
        return res;
    }

    /**
     * Get the {@code backdrop} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getBackdrop() {
        String res = getStringOrNull(MovieColumns.BACKDROP);
        return res;
    }

    /**
     * Get the {@code genres} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getGenres() {
        String res = getStringOrNull(MovieColumns.GENRES);
        return res;
    }

    /**
     * Get the {@code countries} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCountries() {
        String res = getStringOrNull(MovieColumns.COUNTRIES);
        return res;
    }

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOverview() {
        String res = getStringOrNull(MovieColumns.OVERVIEW);
        return res;
    }

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getReleasedate() {
        String res = getStringOrNull(MovieColumns.RELEASEDATE);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopularity() {
        Double res = getDoubleOrNull(MovieColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code voteaverage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getVoteaverage() {
        Double res = getDoubleOrNull(MovieColumns.VOTEAVERAGE);
        return res;
    }

    /**
     * Get the {@code votecount} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVotecount() {
        Integer res = getIntegerOrNull(MovieColumns.VOTECOUNT);
        return res;
    }

    /**
     * Get the {@code runtime} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getRuntime() {
        Integer res = getIntegerOrNull(MovieColumns.RUNTIME);
        return res;
    }

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStatus() {
        String res = getStringOrNull(MovieColumns.STATUS);
        return res;
    }
}

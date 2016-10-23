package com.example.android.pmdb.provider.review;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractCursor;
import com.example.android.pmdb.provider.movie.*;

/**
 * Cursor wrapper for the {@code review} table.
 */
public class ReviewCursor extends AbstractCursor implements ReviewModel {
    public ReviewCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(ReviewColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The Review ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    public String getReviewId() {
        String res = getStringOrNull(ReviewColumns.REVIEW_ID);
        return res;
    }

    /**
     * The review author
     * Cannot be {@code null}.
     */
    @NonNull
    public String getAuthor() {
        String res = getStringOrNull(ReviewColumns.AUTHOR);
        if (res == null)
            throw new NullPointerException("The value of 'author' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The review text
     * Cannot be {@code null}.
     */
    @NonNull
    public String getContent() {
        String res = getStringOrNull(ReviewColumns.CONTENT);
        if (res == null)
            throw new NullPointerException("The value of 'content' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The review url
     * Cannot be {@code null}.
     */
    @NonNull
    public String getUrl() {
        String res = getStringOrNull(ReviewColumns.URL);
        if (res == null)
            throw new NullPointerException("The value of 'url' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code movie_id} value.
     */
    public long getMovieId() {
        Long res = getLongOrNull(ReviewColumns.MOVIE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'movie_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The Movie ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    public Integer getMovieMovieId() {
        Integer res = getIntegerOrNull(MovieColumns.MOVIE_ID);
        return res;
    }

    /**
     * The movie title
     * Cannot be {@code null}.
     */
    @NonNull
    public String getMovieTitle() {
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
    public String getMovieOriginalTitle() {
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
    public String getMoviePoster() {
        String res = getStringOrNull(MovieColumns.POSTER);
        return res;
    }

    /**
     * Get the {@code backdrop} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieBackdrop() {
        String res = getStringOrNull(MovieColumns.BACKDROP);
        return res;
    }

    /**
     * Get the {@code genres} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieGenres() {
        String res = getStringOrNull(MovieColumns.GENRES);
        return res;
    }

    /**
     * Get the {@code countries} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieCountries() {
        String res = getStringOrNull(MovieColumns.COUNTRIES);
        return res;
    }

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieOverview() {
        String res = getStringOrNull(MovieColumns.OVERVIEW);
        return res;
    }

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieReleasedate() {
        String res = getStringOrNull(MovieColumns.RELEASEDATE);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getMoviePopularity() {
        Double res = getDoubleOrNull(MovieColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code voteaverage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getMovieVoteaverage() {
        Double res = getDoubleOrNull(MovieColumns.VOTEAVERAGE);
        return res;
    }

    /**
     * Get the {@code votecount} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getMovieVotecount() {
        Integer res = getIntegerOrNull(MovieColumns.VOTECOUNT);
        return res;
    }

    /**
     * Get the {@code runtime} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getMovieRuntime() {
        Integer res = getIntegerOrNull(MovieColumns.RUNTIME);
        return res;
    }

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieStatus() {
        String res = getStringOrNull(MovieColumns.STATUS);
        return res;
    }
}

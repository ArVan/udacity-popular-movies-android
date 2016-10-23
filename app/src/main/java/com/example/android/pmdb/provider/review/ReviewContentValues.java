package com.example.android.pmdb.provider.review;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code review} table.
 */
public class ReviewContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ReviewColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ReviewSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable ReviewSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * The Review ID field from TMDB
     */
    public ReviewContentValues putReviewId(@Nullable String value) {
        mContentValues.put(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewContentValues putReviewIdNull() {
        mContentValues.putNull(ReviewColumns.REVIEW_ID);
        return this;
    }

    /**
     * The review author
     */
    public ReviewContentValues putAuthor(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("author must not be null");
        mContentValues.put(ReviewColumns.AUTHOR, value);
        return this;
    }


    /**
     * The review text
     */
    public ReviewContentValues putContent(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("content must not be null");
        mContentValues.put(ReviewColumns.CONTENT, value);
        return this;
    }


    /**
     * The review url
     */
    public ReviewContentValues putUrl(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("url must not be null");
        mContentValues.put(ReviewColumns.URL, value);
        return this;
    }


    public ReviewContentValues putMovieId(long value) {
        mContentValues.put(ReviewColumns.MOVIE_ID, value);
        return this;
    }

}

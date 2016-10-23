package com.example.android.pmdb.provider.genre;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code genre} table.
 */
public class GenreContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return GenreColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable GenreSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable GenreSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * The genre ID field from TMDB
     */
    public GenreContentValues putGenreId(@Nullable Integer value) {
        mContentValues.put(GenreColumns.GENRE_ID, value);
        return this;
    }

    public GenreContentValues putGenreIdNull() {
        mContentValues.putNull(GenreColumns.GENRE_ID);
        return this;
    }

    /**
     * The genre name
     */
    public GenreContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(GenreColumns.NAME, value);
        return this;
    }

}

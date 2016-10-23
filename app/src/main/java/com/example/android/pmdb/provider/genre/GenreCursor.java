package com.example.android.pmdb.provider.genre;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code genre} table.
 */
public class GenreCursor extends AbstractCursor implements GenreModel {
    public GenreCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(GenreColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The genre ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    public Integer getGenreId() {
        Integer res = getIntegerOrNull(GenreColumns.GENRE_ID);
        return res;
    }

    /**
     * The genre name
     * Cannot be {@code null}.
     */
    @NonNull
    public String getName() {
        String res = getStringOrNull(GenreColumns.NAME);
        if (res == null)
            throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}

package com.example.android.pmdb.provider.movieproductioncountry;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movie_production_country} table.
 */
public class MovieProductionCountryContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MovieProductionCountryColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MovieProductionCountrySelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MovieProductionCountrySelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MovieProductionCountryContentValues putMovieId(long value) {
        mContentValues.put(MovieProductionCountryColumns.MOVIE_ID, value);
        return this;
    }


    public MovieProductionCountryContentValues putProductionCountryId(long value) {
        mContentValues.put(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, value);
        return this;
    }

}

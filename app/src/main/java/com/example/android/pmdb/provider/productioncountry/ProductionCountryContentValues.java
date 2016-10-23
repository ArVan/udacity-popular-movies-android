package com.example.android.pmdb.provider.productioncountry;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code production_country} table.
 */
public class ProductionCountryContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ProductionCountryColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ProductionCountrySelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable ProductionCountrySelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * The production country ID field from TMDB
     */
    public ProductionCountryContentValues putProductionCountryIso(@Nullable String value) {
        mContentValues.put(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountryContentValues putProductionCountryIsoNull() {
        mContentValues.putNull(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO);
        return this;
    }

    /**
     * The production country name
     */
    public ProductionCountryContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(ProductionCountryColumns.NAME, value);
        return this;
    }

}

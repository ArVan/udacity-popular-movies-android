package com.example.android.pmdb.provider.productioncountry;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.pmdb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code production_country} table.
 */
public class ProductionCountryCursor extends AbstractCursor implements ProductionCountryModel {
    public ProductionCountryCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(ProductionCountryColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The production country ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    public String getProductionCountryIso() {
        String res = getStringOrNull(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO);
        return res;
    }

    /**
     * The production country name
     * Cannot be {@code null}.
     */
    @NonNull
    public String getName() {
        String res = getStringOrNull(ProductionCountryColumns.NAME);
        if (res == null)
            throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}

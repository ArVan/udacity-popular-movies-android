package com.example.android.pmdb.provider.productioncountry;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.pmdb.provider.base.AbstractSelection;

/**
 * Selection for the {@code production_country} table.
 */
public class ProductionCountrySelection extends AbstractSelection<ProductionCountrySelection> {
    @Override
    protected Uri baseUri() {
        return ProductionCountryColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ProductionCountryCursor} object, which is positioned before the first entry, or null.
     */
    public ProductionCountryCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ProductionCountryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public ProductionCountryCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ProductionCountryCursor} object, which is positioned before the first entry, or null.
     */
    public ProductionCountryCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ProductionCountryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public ProductionCountryCursor query(Context context) {
        return query(context, null);
    }


    public ProductionCountrySelection id(long... value) {
        addEquals("production_country." + ProductionCountryColumns._ID, toObjectArray(value));
        return this;
    }

    public ProductionCountrySelection idNot(long... value) {
        addNotEquals("production_country." + ProductionCountryColumns._ID, toObjectArray(value));
        return this;
    }

    public ProductionCountrySelection orderById(boolean desc) {
        orderBy("production_country." + ProductionCountryColumns._ID, desc);
        return this;
    }

    public ProductionCountrySelection orderById() {
        return orderById(false);
    }

    public ProductionCountrySelection productionCountryIso(String... value) {
        addEquals(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountrySelection productionCountryIsoNot(String... value) {
        addNotEquals(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountrySelection productionCountryIsoLike(String... value) {
        addLike(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountrySelection productionCountryIsoContains(String... value) {
        addContains(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountrySelection productionCountryIsoStartsWith(String... value) {
        addStartsWith(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountrySelection productionCountryIsoEndsWith(String... value) {
        addEndsWith(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public ProductionCountrySelection orderByProductionCountryIso(boolean desc) {
        orderBy(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, desc);
        return this;
    }

    public ProductionCountrySelection orderByProductionCountryIso() {
        orderBy(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, false);
        return this;
    }

    public ProductionCountrySelection name(String... value) {
        addEquals(ProductionCountryColumns.NAME, value);
        return this;
    }

    public ProductionCountrySelection nameNot(String... value) {
        addNotEquals(ProductionCountryColumns.NAME, value);
        return this;
    }

    public ProductionCountrySelection nameLike(String... value) {
        addLike(ProductionCountryColumns.NAME, value);
        return this;
    }

    public ProductionCountrySelection nameContains(String... value) {
        addContains(ProductionCountryColumns.NAME, value);
        return this;
    }

    public ProductionCountrySelection nameStartsWith(String... value) {
        addStartsWith(ProductionCountryColumns.NAME, value);
        return this;
    }

    public ProductionCountrySelection nameEndsWith(String... value) {
        addEndsWith(ProductionCountryColumns.NAME, value);
        return this;
    }

    public ProductionCountrySelection orderByName(boolean desc) {
        orderBy(ProductionCountryColumns.NAME, desc);
        return this;
    }

    public ProductionCountrySelection orderByName() {
        orderBy(ProductionCountryColumns.NAME, false);
        return this;
    }
}

package com.example.android.pmdb.provider.movieproductioncountry;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Entity joining movie and production countries.  A movie contains several production countries, and a production country can belong to several movies.
 */
public interface MovieProductionCountryModel extends BaseModel {

    /**
     * Get the {@code movie_id} value.
     */
    long getMovieId();

    /**
     * Get the {@code production_country_id} value.
     */
    long getProductionCountryId();
}

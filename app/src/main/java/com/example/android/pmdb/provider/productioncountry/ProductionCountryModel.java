package com.example.android.pmdb.provider.productioncountry;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * The production countries of a movie saved as favorite
 */
public interface ProductionCountryModel extends BaseModel {

    /**
     * The production country ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    String getProductionCountryIso();

    /**
     * The production country name
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();
}

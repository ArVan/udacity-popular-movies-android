package com.example.android.pmdb.provider.genre;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * The genres of a movie saved as favorite
 */
public interface GenreModel extends BaseModel {

    /**
     * The genre ID field from TMDB
     * Can be {@code null}.
     */
    @Nullable
    Integer getGenreId();

    /**
     * The genre name
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();
}

package com.example.android.pmdb.provider.moviegenre;

import com.example.android.pmdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Entity joining movie and genres.  A movie contains several genres, and a genre can belong to several movies.
 */
public interface MovieGenreModel extends BaseModel {

    /**
     * Get the {@code movie_id} value.
     */
    long getMovieId();

    /**
     * Get the {@code genre_id} value.
     */
    long getGenreId();
}

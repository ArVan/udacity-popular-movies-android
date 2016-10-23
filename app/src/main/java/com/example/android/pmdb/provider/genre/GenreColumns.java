package com.example.android.pmdb.provider.genre;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.android.pmdb.provider.MoviesProvider;
import com.example.android.pmdb.provider.genre.GenreColumns;
import com.example.android.pmdb.provider.movie.MovieColumns;
import com.example.android.pmdb.provider.moviegenre.MovieGenreColumns;
import com.example.android.pmdb.provider.movieproductioncountry.MovieProductionCountryColumns;
import com.example.android.pmdb.provider.productioncountry.ProductionCountryColumns;
import com.example.android.pmdb.provider.review.ReviewColumns;
import com.example.android.pmdb.provider.video.VideoColumns;

/**
 * The genres of a movie saved as favorite
 */
public class GenreColumns implements BaseColumns {
    public static final String TABLE_NAME = "genre";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * The genre ID field from TMDB
     */
    public static final String GENRE_ID = "genre_id";

    /**
     * The genre name
     */
    public static final String NAME = "name";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            GENRE_ID,
            NAME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(GENRE_ID) || c.contains("." + GENRE_ID)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
        }
        return false;
    }

}

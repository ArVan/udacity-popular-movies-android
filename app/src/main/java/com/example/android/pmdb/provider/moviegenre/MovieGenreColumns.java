package com.example.android.pmdb.provider.moviegenre;

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
 * Entity joining movie and genres.  A movie contains several genres, and a genre can belong to several movies.
 */
public class MovieGenreColumns implements BaseColumns {
    public static final String TABLE_NAME = "movie_genre";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String MOVIE_ID = "movie_id";

    public static final String GENRE_ID = "genre_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ID,
            GENRE_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
            if (c.equals(GENRE_ID) || c.contains("." + GENRE_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_MOVIE = TABLE_NAME + "__" + MovieColumns.TABLE_NAME;
    public static final String PREFIX_GENRE = TABLE_NAME + "__" + GenreColumns.TABLE_NAME;
}

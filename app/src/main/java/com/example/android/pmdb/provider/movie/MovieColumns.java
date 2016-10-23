package com.example.android.pmdb.provider.movie;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.android.pmdb.provider.MoviesProvider;

/**
 * A movie saved as favorite
 */
public class MovieColumns implements BaseColumns {
    public static final String TABLE_NAME = "movie";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * The Movie ID field from TMDB
     */
    public static final String MOVIE_ID = "movie_id";

    /**
     * The movie title
     */
    public static final String TITLE = "title";

    public static final String ORIGINAL_TITLE = "original_title";

    public static final String POSTER = "poster";

    public static final String BACKDROP = "backdrop";

    public static final String GENRES = "genres";

    public static final String COUNTRIES = "countries";

    public static final String OVERVIEW = "overview";

    public static final String RELEASEDATE = "releaseDate";

    public static final String POPULARITY = "popularity";

    public static final String VOTEAVERAGE = "voteAverage";

    public static final String VOTECOUNT = "voteCount";

    public static final String RUNTIME = "runtime";

    public static final String STATUS = "status";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ID,
            TITLE,
            ORIGINAL_TITLE,
            POSTER,
            BACKDROP,
            GENRES,
            COUNTRIES,
            OVERVIEW,
            RELEASEDATE,
            POPULARITY,
            VOTEAVERAGE,
            VOTECOUNT,
            RUNTIME,
            STATUS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(ORIGINAL_TITLE) || c.contains("." + ORIGINAL_TITLE)) return true;
            if (c.equals(POSTER) || c.contains("." + POSTER)) return true;
            if (c.equals(BACKDROP) || c.contains("." + BACKDROP)) return true;
            if (c.equals(GENRES) || c.contains("." + GENRES)) return true;
            if (c.equals(COUNTRIES) || c.contains("." + COUNTRIES)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
            if (c.equals(RELEASEDATE) || c.contains("." + RELEASEDATE)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(VOTEAVERAGE) || c.contains("." + VOTEAVERAGE)) return true;
            if (c.equals(VOTECOUNT) || c.contains("." + VOTECOUNT)) return true;
            if (c.equals(RUNTIME) || c.contains("." + RUNTIME)) return true;
            if (c.equals(STATUS) || c.contains("." + STATUS)) return true;
        }
        return false;
    }

}

package com.example.android.pmdb.provider.review;

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
 * The reviews of a movie saved as favorite
 */
public class ReviewColumns implements BaseColumns {
    public static final String TABLE_NAME = "review";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * The Review ID field from TMDB
     */
    public static final String REVIEW_ID = "review_id";

    /**
     * The review author
     */
    public static final String AUTHOR = "author";

    /**
     * The review text
     */
    public static final String CONTENT = "content";

    /**
     * The review url
     */
    public static final String URL = "url";

    public static final String MOVIE_ID = "review__movie_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            REVIEW_ID,
            AUTHOR,
            CONTENT,
            URL,
            MOVIE_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(REVIEW_ID) || c.contains("." + REVIEW_ID)) return true;
            if (c.equals(AUTHOR) || c.contains("." + AUTHOR)) return true;
            if (c.equals(CONTENT) || c.contains("." + CONTENT)) return true;
            if (c.equals(URL) || c.contains("." + URL)) return true;
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_MOVIE = TABLE_NAME + "__" + MovieColumns.TABLE_NAME;
}

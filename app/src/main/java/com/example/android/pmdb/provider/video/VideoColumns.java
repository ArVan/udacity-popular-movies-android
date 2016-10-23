package com.example.android.pmdb.provider.video;

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
 * The videos related to a movie saved as favorite
 */
public class VideoColumns implements BaseColumns {
    public static final String TABLE_NAME = "video";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * The Video ID field from TMDB
     */
    public static final String VIDEO_ID = "video_id";

    public static final String ISO = "iso";

    public static final String KEY = "key";

    public static final String NAME = "name";

    public static final String SITE = "site";

    public static final String SIZE = "size";

    public static final String TYPE = "type";

    public static final String MOVIE_ID = "video__movie_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VIDEO_ID,
            ISO,
            KEY,
            NAME,
            SITE,
            SIZE,
            TYPE,
            MOVIE_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VIDEO_ID) || c.contains("." + VIDEO_ID)) return true;
            if (c.equals(ISO) || c.contains("." + ISO)) return true;
            if (c.equals(KEY) || c.contains("." + KEY)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(SITE) || c.contains("." + SITE)) return true;
            if (c.equals(SIZE) || c.contains("." + SIZE)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_MOVIE = TABLE_NAME + "__" + MovieColumns.TABLE_NAME;
}

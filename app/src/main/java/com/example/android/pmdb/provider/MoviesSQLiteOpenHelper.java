package com.example.android.pmdb.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.android.pmdb.BuildConfig;
import com.example.android.pmdb.provider.genre.GenreColumns;
import com.example.android.pmdb.provider.movie.MovieColumns;
import com.example.android.pmdb.provider.moviegenre.MovieGenreColumns;
import com.example.android.pmdb.provider.movieproductioncountry.MovieProductionCountryColumns;
import com.example.android.pmdb.provider.productioncountry.ProductionCountryColumns;
import com.example.android.pmdb.provider.review.ReviewColumns;
import com.example.android.pmdb.provider.video.VideoColumns;

public class MoviesSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = MoviesSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;
    private static MoviesSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final MoviesSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_GENRE = "CREATE TABLE IF NOT EXISTS "
            + GenreColumns.TABLE_NAME + " ( "
            + GenreColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + GenreColumns.GENRE_ID + " INTEGER, "
            + GenreColumns.NAME + " TEXT NOT NULL "
            + ", CONSTRAINT unique_id UNIQUE (genre_id) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_INDEX_GENRE_GENRE_ID = "CREATE INDEX IDX_GENRE_GENRE_ID "
            + " ON " + GenreColumns.TABLE_NAME + " ( " + GenreColumns.GENRE_ID + " );";

    public static final String SQL_CREATE_TABLE_MOVIE = "CREATE TABLE IF NOT EXISTS "
            + MovieColumns.TABLE_NAME + " ( "
            + MovieColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MovieColumns.MOVIE_ID + " INTEGER, "
            + MovieColumns.TITLE + " TEXT NOT NULL, "
            + MovieColumns.ORIGINAL_TITLE + " TEXT NOT NULL, "
            + MovieColumns.POSTER + " TEXT, "
            + MovieColumns.BACKDROP + " TEXT, "
            + MovieColumns.GENRES + " TEXT, "
            + MovieColumns.COUNTRIES + " TEXT, "
            + MovieColumns.OVERVIEW + " TEXT, "
            + MovieColumns.RELEASEDATE + " TEXT, "
            + MovieColumns.POPULARITY + " REAL, "
            + MovieColumns.VOTEAVERAGE + " REAL, "
            + MovieColumns.VOTECOUNT + " INTEGER, "
            + MovieColumns.RUNTIME + " INTEGER, "
            + MovieColumns.STATUS + " TEXT "
            + ", CONSTRAINT unique_movie_id UNIQUE (movie_id) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_INDEX_MOVIE_MOVIE_ID = "CREATE INDEX IDX_MOVIE_MOVIE_ID "
            + " ON " + MovieColumns.TABLE_NAME + " ( " + MovieColumns.MOVIE_ID + " );";

    public static final String SQL_CREATE_TABLE_MOVIE_GENRE = "CREATE TABLE IF NOT EXISTS "
            + MovieGenreColumns.TABLE_NAME + " ( "
            + MovieGenreColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MovieGenreColumns.MOVIE_ID + " INTEGER NOT NULL, "
            + MovieGenreColumns.GENRE_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_movie_id FOREIGN KEY (" + MovieGenreColumns.MOVIE_ID + ") REFERENCES movie (_id) ON DELETE CASCADE"
            + ", CONSTRAINT fk_genre_id FOREIGN KEY (" + MovieGenreColumns.GENRE_ID + ") REFERENCES genre (_id) ON DELETE CASCADE"
            + ", CONSTRAINT unique_movie_genre UNIQUE (movie_id, genre_id) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_MOVIE_PRODUCTION_COUNTRY = "CREATE TABLE IF NOT EXISTS "
            + MovieProductionCountryColumns.TABLE_NAME + " ( "
            + MovieProductionCountryColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MovieProductionCountryColumns.MOVIE_ID + " INTEGER NOT NULL, "
            + MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_movie_id FOREIGN KEY (" + MovieProductionCountryColumns.MOVIE_ID + ") REFERENCES movie (_id) ON DELETE CASCADE"
            + ", CONSTRAINT fk_production_country_id FOREIGN KEY (" + MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID + ") REFERENCES production_country (_id) ON DELETE CASCADE"
            + ", CONSTRAINT unique_movie_production_country UNIQUE (movie_id, production_country_id) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_PRODUCTION_COUNTRY = "CREATE TABLE IF NOT EXISTS "
            + ProductionCountryColumns.TABLE_NAME + " ( "
            + ProductionCountryColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ProductionCountryColumns.PRODUCTION_COUNTRY_ISO + " TEXT, "
            + ProductionCountryColumns.NAME + " TEXT NOT NULL "
            + ", CONSTRAINT unique_iso UNIQUE (production_country_iso) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_INDEX_PRODUCTION_COUNTRY_PRODUCTION_COUNTRY_ISO = "CREATE INDEX IDX_PRODUCTION_COUNTRY_PRODUCTION_COUNTRY_ISO "
            + " ON " + ProductionCountryColumns.TABLE_NAME + " ( " + ProductionCountryColumns.PRODUCTION_COUNTRY_ISO + " );";

    public static final String SQL_CREATE_TABLE_REVIEW = "CREATE TABLE IF NOT EXISTS "
            + ReviewColumns.TABLE_NAME + " ( "
            + ReviewColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ReviewColumns.REVIEW_ID + " TEXT, "
            + ReviewColumns.AUTHOR + " TEXT NOT NULL, "
            + ReviewColumns.CONTENT + " TEXT NOT NULL, "
            + ReviewColumns.URL + " TEXT NOT NULL, "
            + ReviewColumns.MOVIE_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_movie_id FOREIGN KEY (" + ReviewColumns.MOVIE_ID + ") REFERENCES movie (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_INDEX_REVIEW_REVIEW_ID = "CREATE INDEX IDX_REVIEW_REVIEW_ID "
            + " ON " + ReviewColumns.TABLE_NAME + " ( " + ReviewColumns.REVIEW_ID + " );";

    public static final String SQL_CREATE_TABLE_VIDEO = "CREATE TABLE IF NOT EXISTS "
            + VideoColumns.TABLE_NAME + " ( "
            + VideoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VideoColumns.VIDEO_ID + " TEXT, "
            + VideoColumns.ISO + " TEXT NOT NULL, "
            + VideoColumns.KEY + " TEXT NOT NULL, "
            + VideoColumns.NAME + " TEXT NOT NULL, "
            + VideoColumns.SITE + " TEXT NOT NULL, "
            + VideoColumns.SIZE + " INTEGER NOT NULL, "
            + VideoColumns.TYPE + " TEXT NOT NULL, "
            + VideoColumns.MOVIE_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_movie_id FOREIGN KEY (" + VideoColumns.MOVIE_ID + ") REFERENCES movie (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_INDEX_VIDEO_VIDEO_ID = "CREATE INDEX IDX_VIDEO_VIDEO_ID "
            + " ON " + VideoColumns.TABLE_NAME + " ( " + VideoColumns.VIDEO_ID + " );";

    // @formatter:on

    public static MoviesSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static MoviesSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static MoviesSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new MoviesSQLiteOpenHelper(context);
    }

    private MoviesSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new MoviesSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static MoviesSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new MoviesSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private MoviesSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new MoviesSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_GENRE);
        db.execSQL(SQL_CREATE_INDEX_GENRE_GENRE_ID);
        db.execSQL(SQL_CREATE_TABLE_MOVIE);
        db.execSQL(SQL_CREATE_INDEX_MOVIE_MOVIE_ID);
        db.execSQL(SQL_CREATE_TABLE_MOVIE_GENRE);
        db.execSQL(SQL_CREATE_TABLE_MOVIE_PRODUCTION_COUNTRY);
        db.execSQL(SQL_CREATE_TABLE_PRODUCTION_COUNTRY);
        db.execSQL(SQL_CREATE_INDEX_PRODUCTION_COUNTRY_PRODUCTION_COUNTRY_ISO);
        db.execSQL(SQL_CREATE_TABLE_REVIEW);
        db.execSQL(SQL_CREATE_INDEX_REVIEW_REVIEW_ID);
        db.execSQL(SQL_CREATE_TABLE_VIDEO);
        db.execSQL(SQL_CREATE_INDEX_VIDEO_VIDEO_ID);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}

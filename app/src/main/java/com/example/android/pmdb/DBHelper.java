package com.example.android.pmdb;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import com.example.android.pmdb.provider.genre.GenreContentValues;
import com.example.android.pmdb.provider.genre.GenreCursor;
import com.example.android.pmdb.provider.genre.GenreSelection;
import com.example.android.pmdb.provider.movie.MovieContentValues;
import com.example.android.pmdb.provider.movie.MovieSelection;
import com.example.android.pmdb.provider.moviegenre.MovieGenreContentValues;
import com.example.android.pmdb.provider.movieproductioncountry.MovieProductionCountryContentValues;
import com.example.android.pmdb.provider.productioncountry.ProductionCountryContentValues;
import com.example.android.pmdb.provider.review.ReviewColumns;
import com.example.android.pmdb.provider.review.ReviewContentValues;
import com.example.android.pmdb.provider.video.VideoColumns;
import com.example.android.pmdb.provider.video.VideoContentValues;

import java.util.List;

/**
 * Created by arpy on 10/15/15.
 */
public class DBHelper {

    private DBHelper(){}

    /**
     * Insert a movie.
     *
     * @return the id of the created movie.
     */
    public static long insertMovie(Context context, Movie movie) {
        MovieContentValues values = new MovieContentValues();
        values.putMovieId(movie.getId());
        values.putTitle(movie.getTitle());
        values.putOriginalTitle(movie.getOriginalTitle());
        values.putPoster(movie.getPosterPath());
        values.putBackdrop(movie.getBackdropPath());
        values.putOverview(movie.getOverview());
        values.putReleasedate(movie.getReleaseDate());
        values.putPopularity(movie.getPopularity());
        values.putVotecount(movie.getVoteCount());
        values.putVoteaverage(movie.getVoteAverage());
        values.putRuntime(movie.getRuntime());
        values.putStatus(movie.getStatus());

        Uri uri = values.insert(context.getContentResolver());
        return ContentUris.parseId(uri);
    }

    /**
     * Delete a movie
     *
     * @return the number of deleted movies
     */
    public static int deleteMovie(Context context, int movieId) {
        MovieSelection where = new MovieSelection();
        where.movieId(movieId);

        return where.delete(context.getContentResolver());
    }

    /**
     * Insert videos.
     *
     * @return the number of newly created rows.
     */
    public static int insertVideos(Context context, ContentValues[] videoContentValues) {
        return context.getContentResolver().bulkInsert(VideoColumns.CONTENT_URI, videoContentValues);
    }

    /**
     * Insert reviews.
     *
     * @return the number of newly created rows.
     */
    public static int insertReviews(Context context, ContentValues[] reviewContentValues) {
        return context.getContentResolver().bulkInsert(ReviewColumns.CONTENT_URI, reviewContentValues);
    }

    /**
     * Insert reviews.
     *
     */
    public static void insertMovieGenres(Context context, GenreContentValues[] genreContentValues, long movieId) {
        for (GenreContentValues genreContentValue : genreContentValues) {
            Uri uri = genreContentValue.insert(context.getContentResolver());
            long id = ContentUris.parseId(uri);

            MovieGenreContentValues movieGenreContentValues = new MovieGenreContentValues();
            movieGenreContentValues.putMovieId(movieId);
            movieGenreContentValues.putGenreId(id);
            movieGenreContentValues.insert(context.getContentResolver());
        }
    }

    /**
     * Insert reviews.
     *
     */
    public static void insertMovieProductionCountries(Context context, ProductionCountryContentValues[] productionCountryContentValues, long movieId) {
        for (ProductionCountryContentValues productionCountryContentValue : productionCountryContentValues) {
            Uri uri = productionCountryContentValue.insert(context.getContentResolver());
            long id = ContentUris.parseId(uri);

            MovieProductionCountryContentValues movieProductionCountryContentValues = new MovieProductionCountryContentValues();
            movieProductionCountryContentValues.putMovieId(movieId);
            movieProductionCountryContentValues.putProductionCountryId(id);
            movieProductionCountryContentValues.insert(context.getContentResolver());
        }
    }
}

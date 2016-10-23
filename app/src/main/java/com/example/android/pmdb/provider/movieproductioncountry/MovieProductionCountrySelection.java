package com.example.android.pmdb.provider.movieproductioncountry;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.pmdb.provider.base.AbstractSelection;
import com.example.android.pmdb.provider.movie.*;
import com.example.android.pmdb.provider.productioncountry.*;

/**
 * Selection for the {@code movie_production_country} table.
 */
public class MovieProductionCountrySelection extends AbstractSelection<MovieProductionCountrySelection> {
    @Override
    protected Uri baseUri() {
        return MovieProductionCountryColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieProductionCountryCursor} object, which is positioned before the first entry, or null.
     */
    public MovieProductionCountryCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieProductionCountryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MovieProductionCountryCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieProductionCountryCursor} object, which is positioned before the first entry, or null.
     */
    public MovieProductionCountryCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieProductionCountryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MovieProductionCountryCursor query(Context context) {
        return query(context, null);
    }


    public MovieProductionCountrySelection id(long... value) {
        addEquals("movie_production_country." + MovieProductionCountryColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieProductionCountrySelection idNot(long... value) {
        addNotEquals("movie_production_country." + MovieProductionCountryColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieProductionCountrySelection orderById(boolean desc) {
        orderBy("movie_production_country." + MovieProductionCountryColumns._ID, desc);
        return this;
    }

    public MovieProductionCountrySelection orderById() {
        return orderById(false);
    }

    public MovieProductionCountrySelection movieId(long... value) {
        addEquals(MovieProductionCountryColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public MovieProductionCountrySelection movieIdNot(long... value) {
        addNotEquals(MovieProductionCountryColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public MovieProductionCountrySelection movieIdGt(long value) {
        addGreaterThan(MovieProductionCountryColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieIdGtEq(long value) {
        addGreaterThanOrEquals(MovieProductionCountryColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieIdLt(long value) {
        addLessThan(MovieProductionCountryColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieIdLtEq(long value) {
        addLessThanOrEquals(MovieProductionCountryColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieId(boolean desc) {
        orderBy(MovieProductionCountryColumns.MOVIE_ID, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieId() {
        orderBy(MovieProductionCountryColumns.MOVIE_ID, false);
        return this;
    }

    public MovieProductionCountrySelection movieMovieId(Integer... value) {
        addEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieMovieIdNot(Integer... value) {
        addNotEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieMovieIdGt(int value) {
        addGreaterThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieMovieIdGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieMovieIdLt(int value) {
        addLessThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection movieMovieIdLtEq(int value) {
        addLessThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieMovieId(boolean desc) {
        orderBy(MovieColumns.MOVIE_ID, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieMovieId() {
        orderBy(MovieColumns.MOVIE_ID, false);
        return this;
    }

    public MovieProductionCountrySelection movieTitle(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieTitleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieTitleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieTitleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public MovieProductionCountrySelection movieOriginalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieOriginalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieOriginalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieOriginalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieOriginalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection movieOriginalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public MovieProductionCountrySelection moviePoster(String... value) {
        addEquals(MovieColumns.POSTER, value);
        return this;
    }

    public MovieProductionCountrySelection moviePosterNot(String... value) {
        addNotEquals(MovieColumns.POSTER, value);
        return this;
    }

    public MovieProductionCountrySelection moviePosterLike(String... value) {
        addLike(MovieColumns.POSTER, value);
        return this;
    }

    public MovieProductionCountrySelection moviePosterContains(String... value) {
        addContains(MovieColumns.POSTER, value);
        return this;
    }

    public MovieProductionCountrySelection moviePosterStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER, value);
        return this;
    }

    public MovieProductionCountrySelection moviePosterEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMoviePoster(boolean desc) {
        orderBy(MovieColumns.POSTER, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMoviePoster() {
        orderBy(MovieColumns.POSTER, false);
        return this;
    }

    public MovieProductionCountrySelection movieBackdrop(String... value) {
        addEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieProductionCountrySelection movieBackdropNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieProductionCountrySelection movieBackdropLike(String... value) {
        addLike(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieProductionCountrySelection movieBackdropContains(String... value) {
        addContains(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieProductionCountrySelection movieBackdropStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieProductionCountrySelection movieBackdropEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieBackdrop(boolean desc) {
        orderBy(MovieColumns.BACKDROP, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieBackdrop() {
        orderBy(MovieColumns.BACKDROP, false);
        return this;
    }

    public MovieProductionCountrySelection movieGenres(String... value) {
        addEquals(MovieColumns.GENRES, value);
        return this;
    }

    public MovieProductionCountrySelection movieGenresNot(String... value) {
        addNotEquals(MovieColumns.GENRES, value);
        return this;
    }

    public MovieProductionCountrySelection movieGenresLike(String... value) {
        addLike(MovieColumns.GENRES, value);
        return this;
    }

    public MovieProductionCountrySelection movieGenresContains(String... value) {
        addContains(MovieColumns.GENRES, value);
        return this;
    }

    public MovieProductionCountrySelection movieGenresStartsWith(String... value) {
        addStartsWith(MovieColumns.GENRES, value);
        return this;
    }

    public MovieProductionCountrySelection movieGenresEndsWith(String... value) {
        addEndsWith(MovieColumns.GENRES, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieGenres(boolean desc) {
        orderBy(MovieColumns.GENRES, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieGenres() {
        orderBy(MovieColumns.GENRES, false);
        return this;
    }

    public MovieProductionCountrySelection movieCountries(String... value) {
        addEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieProductionCountrySelection movieCountriesNot(String... value) {
        addNotEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieProductionCountrySelection movieCountriesLike(String... value) {
        addLike(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieProductionCountrySelection movieCountriesContains(String... value) {
        addContains(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieProductionCountrySelection movieCountriesStartsWith(String... value) {
        addStartsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieProductionCountrySelection movieCountriesEndsWith(String... value) {
        addEndsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieCountries(boolean desc) {
        orderBy(MovieColumns.COUNTRIES, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieCountries() {
        orderBy(MovieColumns.COUNTRIES, false);
        return this;
    }

    public MovieProductionCountrySelection movieOverview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieProductionCountrySelection movieOverviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieProductionCountrySelection movieOverviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieProductionCountrySelection movieOverviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieProductionCountrySelection movieOverviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieProductionCountrySelection movieOverviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public MovieProductionCountrySelection movieReleasedate(String... value) {
        addEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieProductionCountrySelection movieReleasedateNot(String... value) {
        addNotEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieProductionCountrySelection movieReleasedateLike(String... value) {
        addLike(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieProductionCountrySelection movieReleasedateContains(String... value) {
        addContains(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieProductionCountrySelection movieReleasedateStartsWith(String... value) {
        addStartsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieProductionCountrySelection movieReleasedateEndsWith(String... value) {
        addEndsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieReleasedate(boolean desc) {
        orderBy(MovieColumns.RELEASEDATE, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieReleasedate() {
        orderBy(MovieColumns.RELEASEDATE, false);
        return this;
    }

    public MovieProductionCountrySelection moviePopularity(Double... value) {
        addEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieProductionCountrySelection moviePopularityNot(Double... value) {
        addNotEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieProductionCountrySelection moviePopularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieProductionCountrySelection moviePopularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieProductionCountrySelection moviePopularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieProductionCountrySelection moviePopularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMoviePopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMoviePopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public MovieProductionCountrySelection movieVoteaverage(Double... value) {
        addEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieProductionCountrySelection movieVoteaverageNot(Double... value) {
        addNotEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieProductionCountrySelection movieVoteaverageGt(double value) {
        addGreaterThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieProductionCountrySelection movieVoteaverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieProductionCountrySelection movieVoteaverageLt(double value) {
        addLessThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieProductionCountrySelection movieVoteaverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieVoteaverage(boolean desc) {
        orderBy(MovieColumns.VOTEAVERAGE, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieVoteaverage() {
        orderBy(MovieColumns.VOTEAVERAGE, false);
        return this;
    }

    public MovieProductionCountrySelection movieVotecount(Integer... value) {
        addEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieProductionCountrySelection movieVotecountNot(Integer... value) {
        addNotEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieProductionCountrySelection movieVotecountGt(int value) {
        addGreaterThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieProductionCountrySelection movieVotecountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieProductionCountrySelection movieVotecountLt(int value) {
        addLessThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieProductionCountrySelection movieVotecountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieVotecount(boolean desc) {
        orderBy(MovieColumns.VOTECOUNT, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieVotecount() {
        orderBy(MovieColumns.VOTECOUNT, false);
        return this;
    }

    public MovieProductionCountrySelection movieRuntime(Integer... value) {
        addEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieProductionCountrySelection movieRuntimeNot(Integer... value) {
        addNotEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieProductionCountrySelection movieRuntimeGt(int value) {
        addGreaterThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieProductionCountrySelection movieRuntimeGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieProductionCountrySelection movieRuntimeLt(int value) {
        addLessThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieProductionCountrySelection movieRuntimeLtEq(int value) {
        addLessThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieRuntime(boolean desc) {
        orderBy(MovieColumns.RUNTIME, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieRuntime() {
        orderBy(MovieColumns.RUNTIME, false);
        return this;
    }

    public MovieProductionCountrySelection movieStatus(String... value) {
        addEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieProductionCountrySelection movieStatusNot(String... value) {
        addNotEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieProductionCountrySelection movieStatusLike(String... value) {
        addLike(MovieColumns.STATUS, value);
        return this;
    }

    public MovieProductionCountrySelection movieStatusContains(String... value) {
        addContains(MovieColumns.STATUS, value);
        return this;
    }

    public MovieProductionCountrySelection movieStatusStartsWith(String... value) {
        addStartsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieProductionCountrySelection movieStatusEndsWith(String... value) {
        addEndsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieStatus(boolean desc) {
        orderBy(MovieColumns.STATUS, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByMovieStatus() {
        orderBy(MovieColumns.STATUS, false);
        return this;
    }

    public MovieProductionCountrySelection productionCountryId(long... value) {
        addEquals(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, toObjectArray(value));
        return this;
    }

    public MovieProductionCountrySelection productionCountryIdNot(long... value) {
        addNotEquals(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, toObjectArray(value));
        return this;
    }

    public MovieProductionCountrySelection productionCountryIdGt(long value) {
        addGreaterThan(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryIdGtEq(long value) {
        addGreaterThanOrEquals(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryIdLt(long value) {
        addLessThan(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryIdLtEq(long value) {
        addLessThanOrEquals(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, value);
        return this;
    }

    public MovieProductionCountrySelection orderByProductionCountryId(boolean desc) {
        orderBy(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByProductionCountryId() {
        orderBy(MovieProductionCountryColumns.PRODUCTION_COUNTRY_ID, false);
        return this;
    }

    public MovieProductionCountrySelection productionCountryProductionCountryIso(String... value) {
        addEquals(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryProductionCountryIsoNot(String... value) {
        addNotEquals(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryProductionCountryIsoLike(String... value) {
        addLike(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryProductionCountryIsoContains(String... value) {
        addContains(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryProductionCountryIsoStartsWith(String... value) {
        addStartsWith(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryProductionCountryIsoEndsWith(String... value) {
        addEndsWith(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, value);
        return this;
    }

    public MovieProductionCountrySelection orderByProductionCountryProductionCountryIso(boolean desc) {
        orderBy(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByProductionCountryProductionCountryIso() {
        orderBy(ProductionCountryColumns.PRODUCTION_COUNTRY_ISO, false);
        return this;
    }

    public MovieProductionCountrySelection productionCountryName(String... value) {
        addEquals(ProductionCountryColumns.NAME, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryNameNot(String... value) {
        addNotEquals(ProductionCountryColumns.NAME, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryNameLike(String... value) {
        addLike(ProductionCountryColumns.NAME, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryNameContains(String... value) {
        addContains(ProductionCountryColumns.NAME, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryNameStartsWith(String... value) {
        addStartsWith(ProductionCountryColumns.NAME, value);
        return this;
    }

    public MovieProductionCountrySelection productionCountryNameEndsWith(String... value) {
        addEndsWith(ProductionCountryColumns.NAME, value);
        return this;
    }

    public MovieProductionCountrySelection orderByProductionCountryName(boolean desc) {
        orderBy(ProductionCountryColumns.NAME, desc);
        return this;
    }

    public MovieProductionCountrySelection orderByProductionCountryName() {
        orderBy(ProductionCountryColumns.NAME, false);
        return this;
    }
}

package com.example.android.pmdb.provider.moviegenre;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.pmdb.provider.base.AbstractSelection;
import com.example.android.pmdb.provider.movie.*;
import com.example.android.pmdb.provider.genre.*;

/**
 * Selection for the {@code movie_genre} table.
 */
public class MovieGenreSelection extends AbstractSelection<MovieGenreSelection> {
    @Override
    protected Uri baseUri() {
        return MovieGenreColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieGenreCursor} object, which is positioned before the first entry, or null.
     */
    public MovieGenreCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieGenreCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MovieGenreCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieGenreCursor} object, which is positioned before the first entry, or null.
     */
    public MovieGenreCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieGenreCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MovieGenreCursor query(Context context) {
        return query(context, null);
    }


    public MovieGenreSelection id(long... value) {
        addEquals("movie_genre." + MovieGenreColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieGenreSelection idNot(long... value) {
        addNotEquals("movie_genre." + MovieGenreColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieGenreSelection orderById(boolean desc) {
        orderBy("movie_genre." + MovieGenreColumns._ID, desc);
        return this;
    }

    public MovieGenreSelection orderById() {
        return orderById(false);
    }

    public MovieGenreSelection movieId(long... value) {
        addEquals(MovieGenreColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public MovieGenreSelection movieIdNot(long... value) {
        addNotEquals(MovieGenreColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public MovieGenreSelection movieIdGt(long value) {
        addGreaterThan(MovieGenreColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieIdGtEq(long value) {
        addGreaterThanOrEquals(MovieGenreColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieIdLt(long value) {
        addLessThan(MovieGenreColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieIdLtEq(long value) {
        addLessThanOrEquals(MovieGenreColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection orderByMovieId(boolean desc) {
        orderBy(MovieGenreColumns.MOVIE_ID, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieId() {
        orderBy(MovieGenreColumns.MOVIE_ID, false);
        return this;
    }

    public MovieGenreSelection movieMovieId(Integer... value) {
        addEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieMovieIdNot(Integer... value) {
        addNotEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieMovieIdGt(int value) {
        addGreaterThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieMovieIdGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieMovieIdLt(int value) {
        addLessThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection movieMovieIdLtEq(int value) {
        addLessThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieGenreSelection orderByMovieMovieId(boolean desc) {
        orderBy(MovieColumns.MOVIE_ID, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieMovieId() {
        orderBy(MovieColumns.MOVIE_ID, false);
        return this;
    }

    public MovieGenreSelection movieTitle(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieGenreSelection movieTitleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieGenreSelection movieTitleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public MovieGenreSelection movieTitleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public MovieGenreSelection movieTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieGenreSelection movieTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieGenreSelection orderByMovieTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public MovieGenreSelection movieOriginalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieGenreSelection movieOriginalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieGenreSelection movieOriginalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieGenreSelection movieOriginalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieGenreSelection movieOriginalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieGenreSelection movieOriginalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieGenreSelection orderByMovieOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public MovieGenreSelection moviePoster(String... value) {
        addEquals(MovieColumns.POSTER, value);
        return this;
    }

    public MovieGenreSelection moviePosterNot(String... value) {
        addNotEquals(MovieColumns.POSTER, value);
        return this;
    }

    public MovieGenreSelection moviePosterLike(String... value) {
        addLike(MovieColumns.POSTER, value);
        return this;
    }

    public MovieGenreSelection moviePosterContains(String... value) {
        addContains(MovieColumns.POSTER, value);
        return this;
    }

    public MovieGenreSelection moviePosterStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER, value);
        return this;
    }

    public MovieGenreSelection moviePosterEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER, value);
        return this;
    }

    public MovieGenreSelection orderByMoviePoster(boolean desc) {
        orderBy(MovieColumns.POSTER, desc);
        return this;
    }

    public MovieGenreSelection orderByMoviePoster() {
        orderBy(MovieColumns.POSTER, false);
        return this;
    }

    public MovieGenreSelection movieBackdrop(String... value) {
        addEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieGenreSelection movieBackdropNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieGenreSelection movieBackdropLike(String... value) {
        addLike(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieGenreSelection movieBackdropContains(String... value) {
        addContains(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieGenreSelection movieBackdropStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieGenreSelection movieBackdropEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieGenreSelection orderByMovieBackdrop(boolean desc) {
        orderBy(MovieColumns.BACKDROP, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieBackdrop() {
        orderBy(MovieColumns.BACKDROP, false);
        return this;
    }

    public MovieGenreSelection movieGenres(String... value) {
        addEquals(MovieColumns.GENRES, value);
        return this;
    }

    public MovieGenreSelection movieGenresNot(String... value) {
        addNotEquals(MovieColumns.GENRES, value);
        return this;
    }

    public MovieGenreSelection movieGenresLike(String... value) {
        addLike(MovieColumns.GENRES, value);
        return this;
    }

    public MovieGenreSelection movieGenresContains(String... value) {
        addContains(MovieColumns.GENRES, value);
        return this;
    }

    public MovieGenreSelection movieGenresStartsWith(String... value) {
        addStartsWith(MovieColumns.GENRES, value);
        return this;
    }

    public MovieGenreSelection movieGenresEndsWith(String... value) {
        addEndsWith(MovieColumns.GENRES, value);
        return this;
    }

    public MovieGenreSelection orderByMovieGenres(boolean desc) {
        orderBy(MovieColumns.GENRES, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieGenres() {
        orderBy(MovieColumns.GENRES, false);
        return this;
    }

    public MovieGenreSelection movieCountries(String... value) {
        addEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieGenreSelection movieCountriesNot(String... value) {
        addNotEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieGenreSelection movieCountriesLike(String... value) {
        addLike(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieGenreSelection movieCountriesContains(String... value) {
        addContains(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieGenreSelection movieCountriesStartsWith(String... value) {
        addStartsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieGenreSelection movieCountriesEndsWith(String... value) {
        addEndsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieGenreSelection orderByMovieCountries(boolean desc) {
        orderBy(MovieColumns.COUNTRIES, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieCountries() {
        orderBy(MovieColumns.COUNTRIES, false);
        return this;
    }

    public MovieGenreSelection movieOverview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieGenreSelection movieOverviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieGenreSelection movieOverviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieGenreSelection movieOverviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieGenreSelection movieOverviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieGenreSelection movieOverviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieGenreSelection orderByMovieOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public MovieGenreSelection movieReleasedate(String... value) {
        addEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieGenreSelection movieReleasedateNot(String... value) {
        addNotEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieGenreSelection movieReleasedateLike(String... value) {
        addLike(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieGenreSelection movieReleasedateContains(String... value) {
        addContains(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieGenreSelection movieReleasedateStartsWith(String... value) {
        addStartsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieGenreSelection movieReleasedateEndsWith(String... value) {
        addEndsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieGenreSelection orderByMovieReleasedate(boolean desc) {
        orderBy(MovieColumns.RELEASEDATE, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieReleasedate() {
        orderBy(MovieColumns.RELEASEDATE, false);
        return this;
    }

    public MovieGenreSelection moviePopularity(Double... value) {
        addEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieGenreSelection moviePopularityNot(Double... value) {
        addNotEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieGenreSelection moviePopularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieGenreSelection moviePopularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieGenreSelection moviePopularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieGenreSelection moviePopularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieGenreSelection orderByMoviePopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public MovieGenreSelection orderByMoviePopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public MovieGenreSelection movieVoteaverage(Double... value) {
        addEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieGenreSelection movieVoteaverageNot(Double... value) {
        addNotEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieGenreSelection movieVoteaverageGt(double value) {
        addGreaterThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieGenreSelection movieVoteaverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieGenreSelection movieVoteaverageLt(double value) {
        addLessThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieGenreSelection movieVoteaverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieGenreSelection orderByMovieVoteaverage(boolean desc) {
        orderBy(MovieColumns.VOTEAVERAGE, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieVoteaverage() {
        orderBy(MovieColumns.VOTEAVERAGE, false);
        return this;
    }

    public MovieGenreSelection movieVotecount(Integer... value) {
        addEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieGenreSelection movieVotecountNot(Integer... value) {
        addNotEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieGenreSelection movieVotecountGt(int value) {
        addGreaterThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieGenreSelection movieVotecountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieGenreSelection movieVotecountLt(int value) {
        addLessThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieGenreSelection movieVotecountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieGenreSelection orderByMovieVotecount(boolean desc) {
        orderBy(MovieColumns.VOTECOUNT, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieVotecount() {
        orderBy(MovieColumns.VOTECOUNT, false);
        return this;
    }

    public MovieGenreSelection movieRuntime(Integer... value) {
        addEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieGenreSelection movieRuntimeNot(Integer... value) {
        addNotEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieGenreSelection movieRuntimeGt(int value) {
        addGreaterThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieGenreSelection movieRuntimeGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieGenreSelection movieRuntimeLt(int value) {
        addLessThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieGenreSelection movieRuntimeLtEq(int value) {
        addLessThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieGenreSelection orderByMovieRuntime(boolean desc) {
        orderBy(MovieColumns.RUNTIME, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieRuntime() {
        orderBy(MovieColumns.RUNTIME, false);
        return this;
    }

    public MovieGenreSelection movieStatus(String... value) {
        addEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieGenreSelection movieStatusNot(String... value) {
        addNotEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieGenreSelection movieStatusLike(String... value) {
        addLike(MovieColumns.STATUS, value);
        return this;
    }

    public MovieGenreSelection movieStatusContains(String... value) {
        addContains(MovieColumns.STATUS, value);
        return this;
    }

    public MovieGenreSelection movieStatusStartsWith(String... value) {
        addStartsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieGenreSelection movieStatusEndsWith(String... value) {
        addEndsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieGenreSelection orderByMovieStatus(boolean desc) {
        orderBy(MovieColumns.STATUS, desc);
        return this;
    }

    public MovieGenreSelection orderByMovieStatus() {
        orderBy(MovieColumns.STATUS, false);
        return this;
    }

    public MovieGenreSelection genreId(long... value) {
        addEquals(MovieGenreColumns.GENRE_ID, toObjectArray(value));
        return this;
    }

    public MovieGenreSelection genreIdNot(long... value) {
        addNotEquals(MovieGenreColumns.GENRE_ID, toObjectArray(value));
        return this;
    }

    public MovieGenreSelection genreIdGt(long value) {
        addGreaterThan(MovieGenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreIdGtEq(long value) {
        addGreaterThanOrEquals(MovieGenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreIdLt(long value) {
        addLessThan(MovieGenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreIdLtEq(long value) {
        addLessThanOrEquals(MovieGenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection orderByGenreId(boolean desc) {
        orderBy(MovieGenreColumns.GENRE_ID, desc);
        return this;
    }

    public MovieGenreSelection orderByGenreId() {
        orderBy(MovieGenreColumns.GENRE_ID, false);
        return this;
    }

    public MovieGenreSelection genreGenreId(Integer... value) {
        addEquals(GenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreGenreIdNot(Integer... value) {
        addNotEquals(GenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreGenreIdGt(int value) {
        addGreaterThan(GenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreGenreIdGtEq(int value) {
        addGreaterThanOrEquals(GenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreGenreIdLt(int value) {
        addLessThan(GenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection genreGenreIdLtEq(int value) {
        addLessThanOrEquals(GenreColumns.GENRE_ID, value);
        return this;
    }

    public MovieGenreSelection orderByGenreGenreId(boolean desc) {
        orderBy(GenreColumns.GENRE_ID, desc);
        return this;
    }

    public MovieGenreSelection orderByGenreGenreId() {
        orderBy(GenreColumns.GENRE_ID, false);
        return this;
    }

    public MovieGenreSelection genreName(String... value) {
        addEquals(GenreColumns.NAME, value);
        return this;
    }

    public MovieGenreSelection genreNameNot(String... value) {
        addNotEquals(GenreColumns.NAME, value);
        return this;
    }

    public MovieGenreSelection genreNameLike(String... value) {
        addLike(GenreColumns.NAME, value);
        return this;
    }

    public MovieGenreSelection genreNameContains(String... value) {
        addContains(GenreColumns.NAME, value);
        return this;
    }

    public MovieGenreSelection genreNameStartsWith(String... value) {
        addStartsWith(GenreColumns.NAME, value);
        return this;
    }

    public MovieGenreSelection genreNameEndsWith(String... value) {
        addEndsWith(GenreColumns.NAME, value);
        return this;
    }

    public MovieGenreSelection orderByGenreName(boolean desc) {
        orderBy(GenreColumns.NAME, desc);
        return this;
    }

    public MovieGenreSelection orderByGenreName() {
        orderBy(GenreColumns.NAME, false);
        return this;
    }
}

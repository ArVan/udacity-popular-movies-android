package com.example.android.pmdb.provider.movie;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.pmdb.provider.base.AbstractSelection;

/**
 * Selection for the {@code movie} table.
 */
public class MovieSelection extends AbstractSelection<MovieSelection> {
    @Override
    protected Uri baseUri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MovieCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MovieCursor query(Context context) {
        return query(context, null);
    }


    public MovieSelection id(long... value) {
        addEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection idNot(long... value) {
        addNotEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection orderById(boolean desc) {
        orderBy("movie." + MovieColumns._ID, desc);
        return this;
    }

    public MovieSelection orderById() {
        return orderById(false);
    }

    public MovieSelection movieId(Integer... value) {
        addEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieSelection movieIdNot(Integer... value) {
        addNotEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieSelection movieIdGt(int value) {
        addGreaterThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieSelection movieIdGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieSelection movieIdLt(int value) {
        addLessThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieSelection movieIdLtEq(int value) {
        addLessThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public MovieSelection orderByMovieId(boolean desc) {
        orderBy(MovieColumns.MOVIE_ID, desc);
        return this;
    }

    public MovieSelection orderByMovieId() {
        orderBy(MovieColumns.MOVIE_ID, false);
        return this;
    }

    public MovieSelection title(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection orderByTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public MovieSelection orderByTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public MovieSelection originalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection orderByOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public MovieSelection orderByOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public MovieSelection poster(String... value) {
        addEquals(MovieColumns.POSTER, value);
        return this;
    }

    public MovieSelection posterNot(String... value) {
        addNotEquals(MovieColumns.POSTER, value);
        return this;
    }

    public MovieSelection posterLike(String... value) {
        addLike(MovieColumns.POSTER, value);
        return this;
    }

    public MovieSelection posterContains(String... value) {
        addContains(MovieColumns.POSTER, value);
        return this;
    }

    public MovieSelection posterStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER, value);
        return this;
    }

    public MovieSelection posterEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER, value);
        return this;
    }

    public MovieSelection orderByPoster(boolean desc) {
        orderBy(MovieColumns.POSTER, desc);
        return this;
    }

    public MovieSelection orderByPoster() {
        orderBy(MovieColumns.POSTER, false);
        return this;
    }

    public MovieSelection backdrop(String... value) {
        addEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieSelection backdropNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieSelection backdropLike(String... value) {
        addLike(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieSelection backdropContains(String... value) {
        addContains(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieSelection backdropStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieSelection backdropEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public MovieSelection orderByBackdrop(boolean desc) {
        orderBy(MovieColumns.BACKDROP, desc);
        return this;
    }

    public MovieSelection orderByBackdrop() {
        orderBy(MovieColumns.BACKDROP, false);
        return this;
    }

    public MovieSelection genres(String... value) {
        addEquals(MovieColumns.GENRES, value);
        return this;
    }

    public MovieSelection genresNot(String... value) {
        addNotEquals(MovieColumns.GENRES, value);
        return this;
    }

    public MovieSelection genresLike(String... value) {
        addLike(MovieColumns.GENRES, value);
        return this;
    }

    public MovieSelection genresContains(String... value) {
        addContains(MovieColumns.GENRES, value);
        return this;
    }

    public MovieSelection genresStartsWith(String... value) {
        addStartsWith(MovieColumns.GENRES, value);
        return this;
    }

    public MovieSelection genresEndsWith(String... value) {
        addEndsWith(MovieColumns.GENRES, value);
        return this;
    }

    public MovieSelection orderByGenres(boolean desc) {
        orderBy(MovieColumns.GENRES, desc);
        return this;
    }

    public MovieSelection orderByGenres() {
        orderBy(MovieColumns.GENRES, false);
        return this;
    }

    public MovieSelection countries(String... value) {
        addEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieSelection countriesNot(String... value) {
        addNotEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieSelection countriesLike(String... value) {
        addLike(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieSelection countriesContains(String... value) {
        addContains(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieSelection countriesStartsWith(String... value) {
        addStartsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieSelection countriesEndsWith(String... value) {
        addEndsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public MovieSelection orderByCountries(boolean desc) {
        orderBy(MovieColumns.COUNTRIES, desc);
        return this;
    }

    public MovieSelection orderByCountries() {
        orderBy(MovieColumns.COUNTRIES, false);
        return this;
    }

    public MovieSelection overview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection orderByOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public MovieSelection orderByOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public MovieSelection releasedate(String... value) {
        addEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieSelection releasedateNot(String... value) {
        addNotEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieSelection releasedateLike(String... value) {
        addLike(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieSelection releasedateContains(String... value) {
        addContains(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieSelection releasedateStartsWith(String... value) {
        addStartsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieSelection releasedateEndsWith(String... value) {
        addEndsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public MovieSelection orderByReleasedate(boolean desc) {
        orderBy(MovieColumns.RELEASEDATE, desc);
        return this;
    }

    public MovieSelection orderByReleasedate() {
        orderBy(MovieColumns.RELEASEDATE, false);
        return this;
    }

    public MovieSelection popularity(Double... value) {
        addEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityNot(Double... value) {
        addNotEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection orderByPopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public MovieSelection orderByPopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public MovieSelection voteaverage(Double... value) {
        addEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieSelection voteaverageNot(Double... value) {
        addNotEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieSelection voteaverageGt(double value) {
        addGreaterThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieSelection voteaverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieSelection voteaverageLt(double value) {
        addLessThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieSelection voteaverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public MovieSelection orderByVoteaverage(boolean desc) {
        orderBy(MovieColumns.VOTEAVERAGE, desc);
        return this;
    }

    public MovieSelection orderByVoteaverage() {
        orderBy(MovieColumns.VOTEAVERAGE, false);
        return this;
    }

    public MovieSelection votecount(Integer... value) {
        addEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieSelection votecountNot(Integer... value) {
        addNotEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieSelection votecountGt(int value) {
        addGreaterThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieSelection votecountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieSelection votecountLt(int value) {
        addLessThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieSelection votecountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public MovieSelection orderByVotecount(boolean desc) {
        orderBy(MovieColumns.VOTECOUNT, desc);
        return this;
    }

    public MovieSelection orderByVotecount() {
        orderBy(MovieColumns.VOTECOUNT, false);
        return this;
    }

    public MovieSelection runtime(Integer... value) {
        addEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeNot(Integer... value) {
        addNotEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeGt(int value) {
        addGreaterThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeLt(int value) {
        addLessThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeLtEq(int value) {
        addLessThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection orderByRuntime(boolean desc) {
        orderBy(MovieColumns.RUNTIME, desc);
        return this;
    }

    public MovieSelection orderByRuntime() {
        orderBy(MovieColumns.RUNTIME, false);
        return this;
    }

    public MovieSelection status(String... value) {
        addEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusNot(String... value) {
        addNotEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusLike(String... value) {
        addLike(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusContains(String... value) {
        addContains(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusStartsWith(String... value) {
        addStartsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusEndsWith(String... value) {
        addEndsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection orderByStatus(boolean desc) {
        orderBy(MovieColumns.STATUS, desc);
        return this;
    }

    public MovieSelection orderByStatus() {
        orderBy(MovieColumns.STATUS, false);
        return this;
    }
}

package com.example.android.pmdb.provider.review;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.pmdb.provider.base.AbstractSelection;
import com.example.android.pmdb.provider.movie.*;

/**
 * Selection for the {@code review} table.
 */
public class ReviewSelection extends AbstractSelection<ReviewSelection> {
    @Override
    protected Uri baseUri() {
        return ReviewColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ReviewCursor} object, which is positioned before the first entry, or null.
     */
    public ReviewCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ReviewCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public ReviewCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ReviewCursor} object, which is positioned before the first entry, or null.
     */
    public ReviewCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ReviewCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public ReviewCursor query(Context context) {
        return query(context, null);
    }


    public ReviewSelection id(long... value) {
        addEquals("review." + ReviewColumns._ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection idNot(long... value) {
        addNotEquals("review." + ReviewColumns._ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection orderById(boolean desc) {
        orderBy("review." + ReviewColumns._ID, desc);
        return this;
    }

    public ReviewSelection orderById() {
        return orderById(false);
    }

    public ReviewSelection reviewId(String... value) {
        addEquals(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewSelection reviewIdNot(String... value) {
        addNotEquals(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewSelection reviewIdLike(String... value) {
        addLike(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewSelection reviewIdContains(String... value) {
        addContains(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewSelection reviewIdStartsWith(String... value) {
        addStartsWith(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewSelection reviewIdEndsWith(String... value) {
        addEndsWith(ReviewColumns.REVIEW_ID, value);
        return this;
    }

    public ReviewSelection orderByReviewId(boolean desc) {
        orderBy(ReviewColumns.REVIEW_ID, desc);
        return this;
    }

    public ReviewSelection orderByReviewId() {
        orderBy(ReviewColumns.REVIEW_ID, false);
        return this;
    }

    public ReviewSelection author(String... value) {
        addEquals(ReviewColumns.AUTHOR, value);
        return this;
    }

    public ReviewSelection authorNot(String... value) {
        addNotEquals(ReviewColumns.AUTHOR, value);
        return this;
    }

    public ReviewSelection authorLike(String... value) {
        addLike(ReviewColumns.AUTHOR, value);
        return this;
    }

    public ReviewSelection authorContains(String... value) {
        addContains(ReviewColumns.AUTHOR, value);
        return this;
    }

    public ReviewSelection authorStartsWith(String... value) {
        addStartsWith(ReviewColumns.AUTHOR, value);
        return this;
    }

    public ReviewSelection authorEndsWith(String... value) {
        addEndsWith(ReviewColumns.AUTHOR, value);
        return this;
    }

    public ReviewSelection orderByAuthor(boolean desc) {
        orderBy(ReviewColumns.AUTHOR, desc);
        return this;
    }

    public ReviewSelection orderByAuthor() {
        orderBy(ReviewColumns.AUTHOR, false);
        return this;
    }

    public ReviewSelection content(String... value) {
        addEquals(ReviewColumns.CONTENT, value);
        return this;
    }

    public ReviewSelection contentNot(String... value) {
        addNotEquals(ReviewColumns.CONTENT, value);
        return this;
    }

    public ReviewSelection contentLike(String... value) {
        addLike(ReviewColumns.CONTENT, value);
        return this;
    }

    public ReviewSelection contentContains(String... value) {
        addContains(ReviewColumns.CONTENT, value);
        return this;
    }

    public ReviewSelection contentStartsWith(String... value) {
        addStartsWith(ReviewColumns.CONTENT, value);
        return this;
    }

    public ReviewSelection contentEndsWith(String... value) {
        addEndsWith(ReviewColumns.CONTENT, value);
        return this;
    }

    public ReviewSelection orderByContent(boolean desc) {
        orderBy(ReviewColumns.CONTENT, desc);
        return this;
    }

    public ReviewSelection orderByContent() {
        orderBy(ReviewColumns.CONTENT, false);
        return this;
    }

    public ReviewSelection url(String... value) {
        addEquals(ReviewColumns.URL, value);
        return this;
    }

    public ReviewSelection urlNot(String... value) {
        addNotEquals(ReviewColumns.URL, value);
        return this;
    }

    public ReviewSelection urlLike(String... value) {
        addLike(ReviewColumns.URL, value);
        return this;
    }

    public ReviewSelection urlContains(String... value) {
        addContains(ReviewColumns.URL, value);
        return this;
    }

    public ReviewSelection urlStartsWith(String... value) {
        addStartsWith(ReviewColumns.URL, value);
        return this;
    }

    public ReviewSelection urlEndsWith(String... value) {
        addEndsWith(ReviewColumns.URL, value);
        return this;
    }

    public ReviewSelection orderByUrl(boolean desc) {
        orderBy(ReviewColumns.URL, desc);
        return this;
    }

    public ReviewSelection orderByUrl() {
        orderBy(ReviewColumns.URL, false);
        return this;
    }

    public ReviewSelection movieId(long... value) {
        addEquals(ReviewColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection movieIdNot(long... value) {
        addNotEquals(ReviewColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection movieIdGt(long value) {
        addGreaterThan(ReviewColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieIdGtEq(long value) {
        addGreaterThanOrEquals(ReviewColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieIdLt(long value) {
        addLessThan(ReviewColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieIdLtEq(long value) {
        addLessThanOrEquals(ReviewColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection orderByMovieId(boolean desc) {
        orderBy(ReviewColumns.MOVIE_ID, desc);
        return this;
    }

    public ReviewSelection orderByMovieId() {
        orderBy(ReviewColumns.MOVIE_ID, false);
        return this;
    }

    public ReviewSelection movieMovieId(Integer... value) {
        addEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieMovieIdNot(Integer... value) {
        addNotEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieMovieIdGt(int value) {
        addGreaterThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieMovieIdGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieMovieIdLt(int value) {
        addLessThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection movieMovieIdLtEq(int value) {
        addLessThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public ReviewSelection orderByMovieMovieId(boolean desc) {
        orderBy(MovieColumns.MOVIE_ID, desc);
        return this;
    }

    public ReviewSelection orderByMovieMovieId() {
        orderBy(MovieColumns.MOVIE_ID, false);
        return this;
    }

    public ReviewSelection movieTitle(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public ReviewSelection movieTitleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public ReviewSelection movieTitleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public ReviewSelection movieTitleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public ReviewSelection movieTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public ReviewSelection movieTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public ReviewSelection orderByMovieTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public ReviewSelection orderByMovieTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public ReviewSelection movieOriginalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public ReviewSelection movieOriginalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public ReviewSelection movieOriginalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public ReviewSelection movieOriginalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public ReviewSelection movieOriginalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public ReviewSelection movieOriginalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public ReviewSelection orderByMovieOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public ReviewSelection orderByMovieOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public ReviewSelection moviePoster(String... value) {
        addEquals(MovieColumns.POSTER, value);
        return this;
    }

    public ReviewSelection moviePosterNot(String... value) {
        addNotEquals(MovieColumns.POSTER, value);
        return this;
    }

    public ReviewSelection moviePosterLike(String... value) {
        addLike(MovieColumns.POSTER, value);
        return this;
    }

    public ReviewSelection moviePosterContains(String... value) {
        addContains(MovieColumns.POSTER, value);
        return this;
    }

    public ReviewSelection moviePosterStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER, value);
        return this;
    }

    public ReviewSelection moviePosterEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER, value);
        return this;
    }

    public ReviewSelection orderByMoviePoster(boolean desc) {
        orderBy(MovieColumns.POSTER, desc);
        return this;
    }

    public ReviewSelection orderByMoviePoster() {
        orderBy(MovieColumns.POSTER, false);
        return this;
    }

    public ReviewSelection movieBackdrop(String... value) {
        addEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public ReviewSelection movieBackdropNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public ReviewSelection movieBackdropLike(String... value) {
        addLike(MovieColumns.BACKDROP, value);
        return this;
    }

    public ReviewSelection movieBackdropContains(String... value) {
        addContains(MovieColumns.BACKDROP, value);
        return this;
    }

    public ReviewSelection movieBackdropStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public ReviewSelection movieBackdropEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public ReviewSelection orderByMovieBackdrop(boolean desc) {
        orderBy(MovieColumns.BACKDROP, desc);
        return this;
    }

    public ReviewSelection orderByMovieBackdrop() {
        orderBy(MovieColumns.BACKDROP, false);
        return this;
    }

    public ReviewSelection movieGenres(String... value) {
        addEquals(MovieColumns.GENRES, value);
        return this;
    }

    public ReviewSelection movieGenresNot(String... value) {
        addNotEquals(MovieColumns.GENRES, value);
        return this;
    }

    public ReviewSelection movieGenresLike(String... value) {
        addLike(MovieColumns.GENRES, value);
        return this;
    }

    public ReviewSelection movieGenresContains(String... value) {
        addContains(MovieColumns.GENRES, value);
        return this;
    }

    public ReviewSelection movieGenresStartsWith(String... value) {
        addStartsWith(MovieColumns.GENRES, value);
        return this;
    }

    public ReviewSelection movieGenresEndsWith(String... value) {
        addEndsWith(MovieColumns.GENRES, value);
        return this;
    }

    public ReviewSelection orderByMovieGenres(boolean desc) {
        orderBy(MovieColumns.GENRES, desc);
        return this;
    }

    public ReviewSelection orderByMovieGenres() {
        orderBy(MovieColumns.GENRES, false);
        return this;
    }

    public ReviewSelection movieCountries(String... value) {
        addEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public ReviewSelection movieCountriesNot(String... value) {
        addNotEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public ReviewSelection movieCountriesLike(String... value) {
        addLike(MovieColumns.COUNTRIES, value);
        return this;
    }

    public ReviewSelection movieCountriesContains(String... value) {
        addContains(MovieColumns.COUNTRIES, value);
        return this;
    }

    public ReviewSelection movieCountriesStartsWith(String... value) {
        addStartsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public ReviewSelection movieCountriesEndsWith(String... value) {
        addEndsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public ReviewSelection orderByMovieCountries(boolean desc) {
        orderBy(MovieColumns.COUNTRIES, desc);
        return this;
    }

    public ReviewSelection orderByMovieCountries() {
        orderBy(MovieColumns.COUNTRIES, false);
        return this;
    }

    public ReviewSelection movieOverview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public ReviewSelection movieOverviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public ReviewSelection movieOverviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public ReviewSelection movieOverviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public ReviewSelection movieOverviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public ReviewSelection movieOverviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public ReviewSelection orderByMovieOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public ReviewSelection orderByMovieOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public ReviewSelection movieReleasedate(String... value) {
        addEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public ReviewSelection movieReleasedateNot(String... value) {
        addNotEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public ReviewSelection movieReleasedateLike(String... value) {
        addLike(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public ReviewSelection movieReleasedateContains(String... value) {
        addContains(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public ReviewSelection movieReleasedateStartsWith(String... value) {
        addStartsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public ReviewSelection movieReleasedateEndsWith(String... value) {
        addEndsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public ReviewSelection orderByMovieReleasedate(boolean desc) {
        orderBy(MovieColumns.RELEASEDATE, desc);
        return this;
    }

    public ReviewSelection orderByMovieReleasedate() {
        orderBy(MovieColumns.RELEASEDATE, false);
        return this;
    }

    public ReviewSelection moviePopularity(Double... value) {
        addEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public ReviewSelection moviePopularityNot(Double... value) {
        addNotEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public ReviewSelection moviePopularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public ReviewSelection moviePopularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public ReviewSelection moviePopularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public ReviewSelection moviePopularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public ReviewSelection orderByMoviePopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public ReviewSelection orderByMoviePopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public ReviewSelection movieVoteaverage(Double... value) {
        addEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public ReviewSelection movieVoteaverageNot(Double... value) {
        addNotEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public ReviewSelection movieVoteaverageGt(double value) {
        addGreaterThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public ReviewSelection movieVoteaverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public ReviewSelection movieVoteaverageLt(double value) {
        addLessThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public ReviewSelection movieVoteaverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public ReviewSelection orderByMovieVoteaverage(boolean desc) {
        orderBy(MovieColumns.VOTEAVERAGE, desc);
        return this;
    }

    public ReviewSelection orderByMovieVoteaverage() {
        orderBy(MovieColumns.VOTEAVERAGE, false);
        return this;
    }

    public ReviewSelection movieVotecount(Integer... value) {
        addEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public ReviewSelection movieVotecountNot(Integer... value) {
        addNotEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public ReviewSelection movieVotecountGt(int value) {
        addGreaterThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public ReviewSelection movieVotecountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public ReviewSelection movieVotecountLt(int value) {
        addLessThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public ReviewSelection movieVotecountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public ReviewSelection orderByMovieVotecount(boolean desc) {
        orderBy(MovieColumns.VOTECOUNT, desc);
        return this;
    }

    public ReviewSelection orderByMovieVotecount() {
        orderBy(MovieColumns.VOTECOUNT, false);
        return this;
    }

    public ReviewSelection movieRuntime(Integer... value) {
        addEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public ReviewSelection movieRuntimeNot(Integer... value) {
        addNotEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public ReviewSelection movieRuntimeGt(int value) {
        addGreaterThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public ReviewSelection movieRuntimeGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public ReviewSelection movieRuntimeLt(int value) {
        addLessThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public ReviewSelection movieRuntimeLtEq(int value) {
        addLessThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public ReviewSelection orderByMovieRuntime(boolean desc) {
        orderBy(MovieColumns.RUNTIME, desc);
        return this;
    }

    public ReviewSelection orderByMovieRuntime() {
        orderBy(MovieColumns.RUNTIME, false);
        return this;
    }

    public ReviewSelection movieStatus(String... value) {
        addEquals(MovieColumns.STATUS, value);
        return this;
    }

    public ReviewSelection movieStatusNot(String... value) {
        addNotEquals(MovieColumns.STATUS, value);
        return this;
    }

    public ReviewSelection movieStatusLike(String... value) {
        addLike(MovieColumns.STATUS, value);
        return this;
    }

    public ReviewSelection movieStatusContains(String... value) {
        addContains(MovieColumns.STATUS, value);
        return this;
    }

    public ReviewSelection movieStatusStartsWith(String... value) {
        addStartsWith(MovieColumns.STATUS, value);
        return this;
    }

    public ReviewSelection movieStatusEndsWith(String... value) {
        addEndsWith(MovieColumns.STATUS, value);
        return this;
    }

    public ReviewSelection orderByMovieStatus(boolean desc) {
        orderBy(MovieColumns.STATUS, desc);
        return this;
    }

    public ReviewSelection orderByMovieStatus() {
        orderBy(MovieColumns.STATUS, false);
        return this;
    }
}

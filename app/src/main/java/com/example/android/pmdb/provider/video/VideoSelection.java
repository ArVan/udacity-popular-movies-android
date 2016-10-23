package com.example.android.pmdb.provider.video;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.pmdb.provider.base.AbstractSelection;
import com.example.android.pmdb.provider.movie.*;

/**
 * Selection for the {@code video} table.
 */
public class VideoSelection extends AbstractSelection<VideoSelection> {
    @Override
    protected Uri baseUri() {
        return VideoColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VideoCursor} object, which is positioned before the first entry, or null.
     */
    public VideoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VideoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public VideoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VideoCursor} object, which is positioned before the first entry, or null.
     */
    public VideoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VideoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public VideoCursor query(Context context) {
        return query(context, null);
    }


    public VideoSelection id(long... value) {
        addEquals("video." + VideoColumns._ID, toObjectArray(value));
        return this;
    }

    public VideoSelection idNot(long... value) {
        addNotEquals("video." + VideoColumns._ID, toObjectArray(value));
        return this;
    }

    public VideoSelection orderById(boolean desc) {
        orderBy("video." + VideoColumns._ID, desc);
        return this;
    }

    public VideoSelection orderById() {
        return orderById(false);
    }

    public VideoSelection videoId(String... value) {
        addEquals(VideoColumns.VIDEO_ID, value);
        return this;
    }

    public VideoSelection videoIdNot(String... value) {
        addNotEquals(VideoColumns.VIDEO_ID, value);
        return this;
    }

    public VideoSelection videoIdLike(String... value) {
        addLike(VideoColumns.VIDEO_ID, value);
        return this;
    }

    public VideoSelection videoIdContains(String... value) {
        addContains(VideoColumns.VIDEO_ID, value);
        return this;
    }

    public VideoSelection videoIdStartsWith(String... value) {
        addStartsWith(VideoColumns.VIDEO_ID, value);
        return this;
    }

    public VideoSelection videoIdEndsWith(String... value) {
        addEndsWith(VideoColumns.VIDEO_ID, value);
        return this;
    }

    public VideoSelection orderByVideoId(boolean desc) {
        orderBy(VideoColumns.VIDEO_ID, desc);
        return this;
    }

    public VideoSelection orderByVideoId() {
        orderBy(VideoColumns.VIDEO_ID, false);
        return this;
    }

    public VideoSelection iso(String... value) {
        addEquals(VideoColumns.ISO, value);
        return this;
    }

    public VideoSelection isoNot(String... value) {
        addNotEquals(VideoColumns.ISO, value);
        return this;
    }

    public VideoSelection isoLike(String... value) {
        addLike(VideoColumns.ISO, value);
        return this;
    }

    public VideoSelection isoContains(String... value) {
        addContains(VideoColumns.ISO, value);
        return this;
    }

    public VideoSelection isoStartsWith(String... value) {
        addStartsWith(VideoColumns.ISO, value);
        return this;
    }

    public VideoSelection isoEndsWith(String... value) {
        addEndsWith(VideoColumns.ISO, value);
        return this;
    }

    public VideoSelection orderByIso(boolean desc) {
        orderBy(VideoColumns.ISO, desc);
        return this;
    }

    public VideoSelection orderByIso() {
        orderBy(VideoColumns.ISO, false);
        return this;
    }

    public VideoSelection key(String... value) {
        addEquals(VideoColumns.KEY, value);
        return this;
    }

    public VideoSelection keyNot(String... value) {
        addNotEquals(VideoColumns.KEY, value);
        return this;
    }

    public VideoSelection keyLike(String... value) {
        addLike(VideoColumns.KEY, value);
        return this;
    }

    public VideoSelection keyContains(String... value) {
        addContains(VideoColumns.KEY, value);
        return this;
    }

    public VideoSelection keyStartsWith(String... value) {
        addStartsWith(VideoColumns.KEY, value);
        return this;
    }

    public VideoSelection keyEndsWith(String... value) {
        addEndsWith(VideoColumns.KEY, value);
        return this;
    }

    public VideoSelection orderByKey(boolean desc) {
        orderBy(VideoColumns.KEY, desc);
        return this;
    }

    public VideoSelection orderByKey() {
        orderBy(VideoColumns.KEY, false);
        return this;
    }

    public VideoSelection name(String... value) {
        addEquals(VideoColumns.NAME, value);
        return this;
    }

    public VideoSelection nameNot(String... value) {
        addNotEquals(VideoColumns.NAME, value);
        return this;
    }

    public VideoSelection nameLike(String... value) {
        addLike(VideoColumns.NAME, value);
        return this;
    }

    public VideoSelection nameContains(String... value) {
        addContains(VideoColumns.NAME, value);
        return this;
    }

    public VideoSelection nameStartsWith(String... value) {
        addStartsWith(VideoColumns.NAME, value);
        return this;
    }

    public VideoSelection nameEndsWith(String... value) {
        addEndsWith(VideoColumns.NAME, value);
        return this;
    }

    public VideoSelection orderByName(boolean desc) {
        orderBy(VideoColumns.NAME, desc);
        return this;
    }

    public VideoSelection orderByName() {
        orderBy(VideoColumns.NAME, false);
        return this;
    }

    public VideoSelection site(String... value) {
        addEquals(VideoColumns.SITE, value);
        return this;
    }

    public VideoSelection siteNot(String... value) {
        addNotEquals(VideoColumns.SITE, value);
        return this;
    }

    public VideoSelection siteLike(String... value) {
        addLike(VideoColumns.SITE, value);
        return this;
    }

    public VideoSelection siteContains(String... value) {
        addContains(VideoColumns.SITE, value);
        return this;
    }

    public VideoSelection siteStartsWith(String... value) {
        addStartsWith(VideoColumns.SITE, value);
        return this;
    }

    public VideoSelection siteEndsWith(String... value) {
        addEndsWith(VideoColumns.SITE, value);
        return this;
    }

    public VideoSelection orderBySite(boolean desc) {
        orderBy(VideoColumns.SITE, desc);
        return this;
    }

    public VideoSelection orderBySite() {
        orderBy(VideoColumns.SITE, false);
        return this;
    }

    public VideoSelection size(int... value) {
        addEquals(VideoColumns.SIZE, toObjectArray(value));
        return this;
    }

    public VideoSelection sizeNot(int... value) {
        addNotEquals(VideoColumns.SIZE, toObjectArray(value));
        return this;
    }

    public VideoSelection sizeGt(int value) {
        addGreaterThan(VideoColumns.SIZE, value);
        return this;
    }

    public VideoSelection sizeGtEq(int value) {
        addGreaterThanOrEquals(VideoColumns.SIZE, value);
        return this;
    }

    public VideoSelection sizeLt(int value) {
        addLessThan(VideoColumns.SIZE, value);
        return this;
    }

    public VideoSelection sizeLtEq(int value) {
        addLessThanOrEquals(VideoColumns.SIZE, value);
        return this;
    }

    public VideoSelection orderBySize(boolean desc) {
        orderBy(VideoColumns.SIZE, desc);
        return this;
    }

    public VideoSelection orderBySize() {
        orderBy(VideoColumns.SIZE, false);
        return this;
    }

    public VideoSelection type(String... value) {
        addEquals(VideoColumns.TYPE, value);
        return this;
    }

    public VideoSelection typeNot(String... value) {
        addNotEquals(VideoColumns.TYPE, value);
        return this;
    }

    public VideoSelection typeLike(String... value) {
        addLike(VideoColumns.TYPE, value);
        return this;
    }

    public VideoSelection typeContains(String... value) {
        addContains(VideoColumns.TYPE, value);
        return this;
    }

    public VideoSelection typeStartsWith(String... value) {
        addStartsWith(VideoColumns.TYPE, value);
        return this;
    }

    public VideoSelection typeEndsWith(String... value) {
        addEndsWith(VideoColumns.TYPE, value);
        return this;
    }

    public VideoSelection orderByType(boolean desc) {
        orderBy(VideoColumns.TYPE, desc);
        return this;
    }

    public VideoSelection orderByType() {
        orderBy(VideoColumns.TYPE, false);
        return this;
    }

    public VideoSelection movieId(long... value) {
        addEquals(VideoColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public VideoSelection movieIdNot(long... value) {
        addNotEquals(VideoColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public VideoSelection movieIdGt(long value) {
        addGreaterThan(VideoColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieIdGtEq(long value) {
        addGreaterThanOrEquals(VideoColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieIdLt(long value) {
        addLessThan(VideoColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieIdLtEq(long value) {
        addLessThanOrEquals(VideoColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection orderByMovieId(boolean desc) {
        orderBy(VideoColumns.MOVIE_ID, desc);
        return this;
    }

    public VideoSelection orderByMovieId() {
        orderBy(VideoColumns.MOVIE_ID, false);
        return this;
    }

    public VideoSelection movieMovieId(Integer... value) {
        addEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieMovieIdNot(Integer... value) {
        addNotEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieMovieIdGt(int value) {
        addGreaterThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieMovieIdGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieMovieIdLt(int value) {
        addLessThan(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection movieMovieIdLtEq(int value) {
        addLessThanOrEquals(MovieColumns.MOVIE_ID, value);
        return this;
    }

    public VideoSelection orderByMovieMovieId(boolean desc) {
        orderBy(MovieColumns.MOVIE_ID, desc);
        return this;
    }

    public VideoSelection orderByMovieMovieId() {
        orderBy(MovieColumns.MOVIE_ID, false);
        return this;
    }

    public VideoSelection movieTitle(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public VideoSelection movieTitleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public VideoSelection movieTitleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public VideoSelection movieTitleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public VideoSelection movieTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public VideoSelection movieTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public VideoSelection orderByMovieTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public VideoSelection orderByMovieTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public VideoSelection movieOriginalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public VideoSelection movieOriginalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public VideoSelection movieOriginalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public VideoSelection movieOriginalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public VideoSelection movieOriginalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public VideoSelection movieOriginalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public VideoSelection orderByMovieOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public VideoSelection orderByMovieOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public VideoSelection moviePoster(String... value) {
        addEquals(MovieColumns.POSTER, value);
        return this;
    }

    public VideoSelection moviePosterNot(String... value) {
        addNotEquals(MovieColumns.POSTER, value);
        return this;
    }

    public VideoSelection moviePosterLike(String... value) {
        addLike(MovieColumns.POSTER, value);
        return this;
    }

    public VideoSelection moviePosterContains(String... value) {
        addContains(MovieColumns.POSTER, value);
        return this;
    }

    public VideoSelection moviePosterStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER, value);
        return this;
    }

    public VideoSelection moviePosterEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER, value);
        return this;
    }

    public VideoSelection orderByMoviePoster(boolean desc) {
        orderBy(MovieColumns.POSTER, desc);
        return this;
    }

    public VideoSelection orderByMoviePoster() {
        orderBy(MovieColumns.POSTER, false);
        return this;
    }

    public VideoSelection movieBackdrop(String... value) {
        addEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public VideoSelection movieBackdropNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP, value);
        return this;
    }

    public VideoSelection movieBackdropLike(String... value) {
        addLike(MovieColumns.BACKDROP, value);
        return this;
    }

    public VideoSelection movieBackdropContains(String... value) {
        addContains(MovieColumns.BACKDROP, value);
        return this;
    }

    public VideoSelection movieBackdropStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public VideoSelection movieBackdropEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP, value);
        return this;
    }

    public VideoSelection orderByMovieBackdrop(boolean desc) {
        orderBy(MovieColumns.BACKDROP, desc);
        return this;
    }

    public VideoSelection orderByMovieBackdrop() {
        orderBy(MovieColumns.BACKDROP, false);
        return this;
    }

    public VideoSelection movieGenres(String... value) {
        addEquals(MovieColumns.GENRES, value);
        return this;
    }

    public VideoSelection movieGenresNot(String... value) {
        addNotEquals(MovieColumns.GENRES, value);
        return this;
    }

    public VideoSelection movieGenresLike(String... value) {
        addLike(MovieColumns.GENRES, value);
        return this;
    }

    public VideoSelection movieGenresContains(String... value) {
        addContains(MovieColumns.GENRES, value);
        return this;
    }

    public VideoSelection movieGenresStartsWith(String... value) {
        addStartsWith(MovieColumns.GENRES, value);
        return this;
    }

    public VideoSelection movieGenresEndsWith(String... value) {
        addEndsWith(MovieColumns.GENRES, value);
        return this;
    }

    public VideoSelection orderByMovieGenres(boolean desc) {
        orderBy(MovieColumns.GENRES, desc);
        return this;
    }

    public VideoSelection orderByMovieGenres() {
        orderBy(MovieColumns.GENRES, false);
        return this;
    }

    public VideoSelection movieCountries(String... value) {
        addEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public VideoSelection movieCountriesNot(String... value) {
        addNotEquals(MovieColumns.COUNTRIES, value);
        return this;
    }

    public VideoSelection movieCountriesLike(String... value) {
        addLike(MovieColumns.COUNTRIES, value);
        return this;
    }

    public VideoSelection movieCountriesContains(String... value) {
        addContains(MovieColumns.COUNTRIES, value);
        return this;
    }

    public VideoSelection movieCountriesStartsWith(String... value) {
        addStartsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public VideoSelection movieCountriesEndsWith(String... value) {
        addEndsWith(MovieColumns.COUNTRIES, value);
        return this;
    }

    public VideoSelection orderByMovieCountries(boolean desc) {
        orderBy(MovieColumns.COUNTRIES, desc);
        return this;
    }

    public VideoSelection orderByMovieCountries() {
        orderBy(MovieColumns.COUNTRIES, false);
        return this;
    }

    public VideoSelection movieOverview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public VideoSelection movieOverviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public VideoSelection movieOverviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public VideoSelection movieOverviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public VideoSelection movieOverviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public VideoSelection movieOverviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public VideoSelection orderByMovieOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public VideoSelection orderByMovieOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public VideoSelection movieReleasedate(String... value) {
        addEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public VideoSelection movieReleasedateNot(String... value) {
        addNotEquals(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public VideoSelection movieReleasedateLike(String... value) {
        addLike(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public VideoSelection movieReleasedateContains(String... value) {
        addContains(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public VideoSelection movieReleasedateStartsWith(String... value) {
        addStartsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public VideoSelection movieReleasedateEndsWith(String... value) {
        addEndsWith(MovieColumns.RELEASEDATE, value);
        return this;
    }

    public VideoSelection orderByMovieReleasedate(boolean desc) {
        orderBy(MovieColumns.RELEASEDATE, desc);
        return this;
    }

    public VideoSelection orderByMovieReleasedate() {
        orderBy(MovieColumns.RELEASEDATE, false);
        return this;
    }

    public VideoSelection moviePopularity(Double... value) {
        addEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public VideoSelection moviePopularityNot(Double... value) {
        addNotEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public VideoSelection moviePopularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public VideoSelection moviePopularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public VideoSelection moviePopularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public VideoSelection moviePopularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public VideoSelection orderByMoviePopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public VideoSelection orderByMoviePopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public VideoSelection movieVoteaverage(Double... value) {
        addEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public VideoSelection movieVoteaverageNot(Double... value) {
        addNotEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public VideoSelection movieVoteaverageGt(double value) {
        addGreaterThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public VideoSelection movieVoteaverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public VideoSelection movieVoteaverageLt(double value) {
        addLessThan(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public VideoSelection movieVoteaverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTEAVERAGE, value);
        return this;
    }

    public VideoSelection orderByMovieVoteaverage(boolean desc) {
        orderBy(MovieColumns.VOTEAVERAGE, desc);
        return this;
    }

    public VideoSelection orderByMovieVoteaverage() {
        orderBy(MovieColumns.VOTEAVERAGE, false);
        return this;
    }

    public VideoSelection movieVotecount(Integer... value) {
        addEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public VideoSelection movieVotecountNot(Integer... value) {
        addNotEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public VideoSelection movieVotecountGt(int value) {
        addGreaterThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public VideoSelection movieVotecountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public VideoSelection movieVotecountLt(int value) {
        addLessThan(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public VideoSelection movieVotecountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTECOUNT, value);
        return this;
    }

    public VideoSelection orderByMovieVotecount(boolean desc) {
        orderBy(MovieColumns.VOTECOUNT, desc);
        return this;
    }

    public VideoSelection orderByMovieVotecount() {
        orderBy(MovieColumns.VOTECOUNT, false);
        return this;
    }

    public VideoSelection movieRuntime(Integer... value) {
        addEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public VideoSelection movieRuntimeNot(Integer... value) {
        addNotEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public VideoSelection movieRuntimeGt(int value) {
        addGreaterThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public VideoSelection movieRuntimeGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public VideoSelection movieRuntimeLt(int value) {
        addLessThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public VideoSelection movieRuntimeLtEq(int value) {
        addLessThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public VideoSelection orderByMovieRuntime(boolean desc) {
        orderBy(MovieColumns.RUNTIME, desc);
        return this;
    }

    public VideoSelection orderByMovieRuntime() {
        orderBy(MovieColumns.RUNTIME, false);
        return this;
    }

    public VideoSelection movieStatus(String... value) {
        addEquals(MovieColumns.STATUS, value);
        return this;
    }

    public VideoSelection movieStatusNot(String... value) {
        addNotEquals(MovieColumns.STATUS, value);
        return this;
    }

    public VideoSelection movieStatusLike(String... value) {
        addLike(MovieColumns.STATUS, value);
        return this;
    }

    public VideoSelection movieStatusContains(String... value) {
        addContains(MovieColumns.STATUS, value);
        return this;
    }

    public VideoSelection movieStatusStartsWith(String... value) {
        addStartsWith(MovieColumns.STATUS, value);
        return this;
    }

    public VideoSelection movieStatusEndsWith(String... value) {
        addEndsWith(MovieColumns.STATUS, value);
        return this;
    }

    public VideoSelection orderByMovieStatus(boolean desc) {
        orderBy(MovieColumns.STATUS, desc);
        return this;
    }

    public VideoSelection orderByMovieStatus() {
        orderBy(MovieColumns.STATUS, false);
        return this;
    }
}

package com.example.android.pmdb;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by arpy on 11/3/15.
 */
public interface TMDBService {
    @GET("discover/movie")
    Call<MoviesResult> getMovies(@Query(Constant.TMDB_URL_DISCOVER_PARAM_SORT) String filter, @Query(Constant.TMDB_URL_DISCOVER_PARAM_DATE) String date, @Query(Constant.TMDB_URL_DISCOVER_PARAM_API_KEY) String key);

    @GET("movie/{id}")
    Call<Movie> getMovie(@Path("id") int id, @Query(Constant.TMDB_URL_DISCOVER_PARAM_API_KEY) String key);

    @GET("movie/{id}/reviews")
    Call<ReviewsResult> getReviews(@Path("id") int id, @Query(Constant.TMDB_URL_DISCOVER_PARAM_API_KEY) String key);

    @GET("movie/{id}/videos")
    Call<VideosResult> getVideos(@Path("id") int id, @Query(Constant.TMDB_URL_DISCOVER_PARAM_API_KEY) String key);
}

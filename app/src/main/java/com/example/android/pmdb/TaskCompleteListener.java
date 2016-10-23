package com.example.android.pmdb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpy on 10/3/15.
 */
public interface TaskCompleteListener {
    void onVideosUpdated(ArrayList<Video> videoArrayList);
    void onMoviesUpdated(List<Movie> movieArrayList);
    void onMovieDetailUpdated(Movie movie);
    void onReviewsUpdated(List<Review> movieArrayList);
//    void showProgressDialog();
    void showSnackbarMessage(String message);
}

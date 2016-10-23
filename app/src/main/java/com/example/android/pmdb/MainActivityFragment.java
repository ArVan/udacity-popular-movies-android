package com.example.android.pmdb;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.pmdb.provider.movie.MovieColumns;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit.*;
import retrofit.Callback;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int MovieLOADER = 0;
    private ThumbnailAdapter mMoviesArrayAdapter;
    private FavoriteThumbnailAdapter mFavoriteMoviesCursorAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Movie> mMoviesList = new ArrayList<Movie>();
    private View rootLayout;
    private SwipeRefreshLayout swipeContainer;
    private ProgressDialog mProgressDialog;
    boolean isFromSavedInstance;
    boolean isFirstStart;


    public MainActivityFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(MovieLOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null || !savedInstanceState.containsKey("movies")) {
            mMoviesList = new ArrayList<>(0);
            isFromSavedInstance = false;
        } else {
            List moviesList = Arrays.asList(savedInstanceState.getParcelableArray("movies"));
            mMoviesList = new ArrayList<Movie>();
            mMoviesList.addAll(moviesList);
            isFromSavedInstance = true;
        }
        setHasOptionsMenu(true);
        isFirstStart = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!isFromSavedInstance || !isFirstStart) {
            if(mMoviesList == null) {
                mMoviesList = new ArrayList<>(0);
            }
            updateMovies();
        } else {
            if(mMoviesArrayAdapter != null) {
                mMoviesArrayAdapter.notifyItemRangeRemoved(0, mMoviesArrayAdapter.getItemCount());
                mMoviesArrayAdapter.notifyItemRangeInserted(0, mMoviesList.size());
            }
        }
        isFirstStart = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArray("movies", mMoviesList.toArray(new Movie[mMoviesList.size()]));
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        this.rootLayout = rootView;

        // Lookup the recyclerview in activity layout
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvMovies);

        GridLayoutManager manager;
        if(!getResources().getBoolean(R.bool.isTablet) && getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            manager = new GridLayoutManager(getContext(), 5);
        } else {
            manager = new GridLayoutManager(getContext(), 2);
        }

        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 8, true));

        // Set layout manager to position the items
        mRecyclerView.setLayoutManager(manager);

        if(mMoviesList != null) {
            mMoviesArrayAdapter = new ThumbnailAdapter(getActivity(), mMoviesList);
            mRecyclerView.setAdapter(mMoviesArrayAdapter);

        }

        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateMovies();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void updateMovies() {
        hideErrorMessageView();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String filter = prefs.getString(getString(R.string.pref_key_choose_filter), getString(R.string.pref_default_value_choose_sorting));

        if(filter.equals(getResources().getStringArray(R.array.pref_choose_sorting_values)[3])) {
            // Fetch favorite movies from DB
            if(mFavoriteMoviesCursorAdapter == null) {
                mFavoriteMoviesCursorAdapter = new FavoriteThumbnailAdapter(getActivity(), null);
                mRecyclerView.setAdapter(mFavoriteMoviesCursorAdapter);
            }
            swipeContainer.setRefreshing(false);
        } else {
            if (isNetworkAvailable()) {
                fetchMovies(filter);
            } else {
                showErrorMessageView();
            }
        }
    }

    /**
     * helper function to get current application context to be used in async task
     *
     * @return Context
     */
    private Context getDialogContext() {
        Context context;
        if (getActivity().getParent() != null) context = getActivity().getParent();
        else context = getActivity();
        return context;
    }

    private void showErrorMessageView() {
        rootLayout.findViewById(R.id.rvMovies).setVisibility(View.INVISIBLE);
        rootLayout.findViewById(R.id.error_message).setVisibility(View.VISIBLE);
    }

    private void hideErrorMessageView() {
        rootLayout.findViewById(R.id.rvMovies).setVisibility(View.VISIBLE);
        rootLayout.findViewById(R.id.error_message).setVisibility(View.INVISIBLE);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getDialogContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onMoviesUpdated(List<Movie> movieArrayList) {
        if(movieArrayList != null) {
            mMoviesList.clear();
            for(Movie movie : movieArrayList) {
                mMoviesList.add(movie);
            }

            mRecyclerView.setAdapter(mMoviesArrayAdapter);
            mMoviesArrayAdapter.notifyItemRangeRemoved(0, mMoviesArrayAdapter.getItemCount());
            mMoviesArrayAdapter.notifyItemRangeInserted(0, mMoviesList.size());
        }
        swipeContainer.setRefreshing(false);
    }

    public void showSnackbarMessage(String message) {
        Snackbar.make(this.rootLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), MovieColumns.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if(mFavoriteMoviesCursorAdapter != null) {
            mFavoriteMoviesCursorAdapter.swapCursor(cursor);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if(mFavoriteMoviesCursorAdapter != null) {
            mFavoriteMoviesCursorAdapter.swapCursor(null);
        }
    }

    private void fetchMovies(String filter) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getDialogContext());
            mProgressDialog.setMessage(getDialogContext().getString(R.string.progress_loading));
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.TMDB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService tmdbService = retrofit.create(TMDBService.class);

        Calendar c = Calendar.getInstance();

        String dateFilter = "";

        if(filter.equals(getResources().getStringArray(R.array.pref_choose_sorting_values)[2])) {
            dateFilter = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
        }

        Call<MoviesResult> call = tmdbService.getMovies(filter, dateFilter, Constant.TMDB_API_KEY);


        call.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Response<MoviesResult> response, Retrofit retrofit) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }

                if (response.body() != null) {
                    onMoviesUpdated(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                showErrorMessageView();
            }
        });
    }
}

package com.example.android.pmdb;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

import com.example.android.pmdb.provider.genre.GenreColumns;
import com.example.android.pmdb.provider.genre.GenreContentValues;
import com.example.android.pmdb.provider.genre.GenreSelection;
import com.example.android.pmdb.provider.movie.MovieCursor;
import com.example.android.pmdb.provider.movie.MovieSelection;
import com.example.android.pmdb.provider.moviegenre.MovieGenreColumns;
import com.example.android.pmdb.provider.moviegenre.MovieGenreCursor;
import com.example.android.pmdb.provider.moviegenre.MovieGenreSelection;
import com.example.android.pmdb.provider.movieproductioncountry.MovieProductionCountryColumns;
import com.example.android.pmdb.provider.movieproductioncountry.MovieProductionCountryCursor;
import com.example.android.pmdb.provider.movieproductioncountry.MovieProductionCountrySelection;
import com.example.android.pmdb.provider.productioncountry.ProductionCountryColumns;
import com.example.android.pmdb.provider.productioncountry.ProductionCountryContentValues;
import com.example.android.pmdb.provider.review.ReviewColumns;
import com.example.android.pmdb.provider.review.ReviewContentValues;
import com.example.android.pmdb.provider.review.ReviewCursor;
import com.example.android.pmdb.provider.video.VideoColumns;
import com.example.android.pmdb.provider.video.VideoContentValues;
import com.example.android.pmdb.provider.video.VideoCursor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int REVIEW_LOADER = 0;
    private static final int VIDEO_LOADER = 1;

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ProgressDialog mProgressDialog;

    private ShareActionProvider mShareActionProvider;

    VideoAdapter mVideosRVAdapter;
    ReviewAdapter mReviewsRVAdapter;
    FavoriteVideoAdapter mFavoriteVideosRVAdapter;
    FavoriteReviewAdapter mFavoriteReviewsRVAdapter;

    RecyclerView mVideosRecyclerView;
    RecyclerView mReviewsRecyclerView;
    View rootLayout;

    private Movie mMovie;
    private ArrayList<Video> mVideos;
    private ArrayList<Review> mReviews;

    boolean isFromSavedInstance;

    String mShareUrl;

    public MovieDetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(REVIEW_LOADER, null, this);
        getLoaderManager().initLoader(VIDEO_LOADER, null, this);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_detail);

        if(toolbar != null) {

            if(getActivity().getClass() == MovieDetailActivity.class) {
                MovieDetailActivity activity = ((MovieDetailActivity)getActivity());

                activity.setSupportActionBar(toolbar);
                ActionBar actionBar = activity.getSupportActionBar();

                if (actionBar != null) {
                    actionBar.setHomeButtonEnabled(true);
                    actionBar.setDisplayHomeAsUpEnabled(true);
                }
            }
        }

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState == null || !savedInstanceState.containsKey(Movie.class.getName())) {
            Intent intent = getActivity().getIntent();
            mMovie = intent.getParcelableExtra(Movie.class.getName());
            mVideos = new ArrayList<Video>();
            mReviews = new ArrayList<Review>();
            isFromSavedInstance = false;
        } else {
            mMovie = savedInstanceState.getParcelable(Movie.class.getName());
            mVideos = savedInstanceState.getParcelableArrayList(Video.class.getName());
            mReviews = savedInstanceState.getParcelableArrayList(Review.class.getName());
            isFromSavedInstance = true;
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(Movie.class.getName(), mMovie);
        outState.putParcelableArrayList(Video.class.getName(), mVideos);
        outState.putParcelableArrayList(Review.class.getName(), mReviews);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();

        if(mMovie != null) {
            if (!isFromSavedInstance) {
                updateMovieDetails();
            } else {
                loadMovieContentView();
            }
        }
    }

    public static MovieDetailActivityFragment newInstance(int index) {

        Bundle args = new Bundle();
        args.putInt("index", index);

        MovieDetailActivityFragment fragment = new MovieDetailActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(mMovie == null) {
            Bundle args = getArguments();
            if (args != null) {
                mMovie = args.getParcelable(Movie.class.getName());
            }
        }

        if(mMovie != null) {
            MovieSelection where = new MovieSelection();
            where.movieId(mMovie.getId());
            MovieCursor movieCursor = new MovieCursor(where.limit(1).query(getContext().getContentResolver()));
            if(movieCursor.moveToFirst()) {
                mMovie.setIsFavorite(true);
                mMovie.setDbId(movieCursor.getId());
                mMovie.setRuntime(movieCursor.getRuntime());
                mMovie.setStatus(movieCursor.getStatus());
            }
        }

        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        this.rootLayout = rootView;

        collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsingToolbarLayout);

        ImageView backdropImage = (ImageView) rootView.findViewById(R.id.backdrop_image);

        TextView originalTitle = (TextView) rootView.findViewById(R.id.original_title);
        originalTitle.setSelected(true);

        // Set layout manager to position the items
        mVideosRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvVideos);
        mVideosRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mVideosRVAdapter = new VideoAdapter(getActivity(), mVideos);
        mVideosRecyclerView.setAdapter(mVideosRVAdapter);


        // Set layout manager to position the items
        mReviewsRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvReviews);
        mReviewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mReviewsRVAdapter = new ReviewAdapter(getActivity(), mReviews);
        mReviewsRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        mReviewsRecyclerView.setAdapter(mReviewsRVAdapter);

        NestedScrollView nsView = (NestedScrollView)rootView.findViewById(R.id.scroll_view);
        FloatingActionButton fabFavButton = (FloatingActionButton) rootView.findViewById(R.id.fabBtnFav);

        if(mMovie != null) {
            Picasso.with(getActivity().getApplicationContext()).load(Constant.TMDB_URL_IMAGE_BASE + "/w500/" + mMovie.getBackdropPath()).into(backdropImage);

            if(collapsingToolbarLayout != null) {
                collapsingToolbarLayout.setTitle(mMovie.getTitle());
            }

            //set fav button correct state and attach click listener

            if (mMovie.isFavorite()) {
                fabFavButton.setId(R.id.fabBtnUnFav);
                fabFavButton.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_delete_white_48dp));
            }

            fabFavButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabOnClick(v);
                }
            });
            if(nsView != null) {
                nsView.setVisibility(View.VISIBLE);
                fabFavButton.setVisibility(View.VISIBLE);
            }
        } else {
            if(nsView != null) {
                nsView.setVisibility(View.INVISIBLE);
            }
            fabFavButton.setVisibility(View.INVISIBLE);
        }

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_detail, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);

        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if(mMovie != null) {

            if (!mMovie.isFavorite()) {
                return null;
            }

            switch (id) {
                case REVIEW_LOADER: {
                    String[] selectArgs = {mMovie.getDbId() + ""};
                    String[] projection = {ReviewColumns._ID, ReviewColumns.AUTHOR, ReviewColumns.URL, ReviewColumns.CONTENT, ReviewColumns.MOVIE_ID, ReviewColumns.REVIEW_ID};
                    return new CursorLoader(getActivity(), ReviewColumns.CONTENT_URI, projection, ReviewColumns.MOVIE_ID + "=?", selectArgs, null);
                }
                case VIDEO_LOADER: {
                    String[] selectArgs = {mMovie.getDbId() + ""};
                    String[] projection = {VideoColumns._ID, VideoColumns.ISO, VideoColumns.KEY, VideoColumns.MOVIE_ID, VideoColumns.NAME, VideoColumns.SITE, VideoColumns.SIZE, VideoColumns.TYPE, VideoColumns.VIDEO_ID};
                    return new CursorLoader(getActivity(), VideoColumns.CONTENT_URI, projection, VideoColumns.MOVIE_ID + "=?", selectArgs, null);
                }
                default: {
                    return null;
                }
            }
        }
        return  null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        switch (loader.getId()) {
            case REVIEW_LOADER: {
                if(mFavoriteReviewsRVAdapter != null) {
                    mFavoriteReviewsRVAdapter.swapCursor(cursor);
                }
                mReviews.clear();
                ReviewCursor reviewCursor = new ReviewCursor(cursor);
                reviewCursor.moveToFirst();
                if(reviewCursor.getCount() > 0) {
                    do {
                        mReviews.add(new Review(reviewCursor));
                    } while (reviewCursor.moveToNext());
                }
                break;
            }
            case VIDEO_LOADER: {
                if(mFavoriteVideosRVAdapter!= null) {
                    mFavoriteVideosRVAdapter.swapCursor(cursor);
                    if(cursor.getCount() != 0) {
                        cursor.moveToFirst();
                        VideoCursor videoCursor = new VideoCursor(cursor);
                        mShareUrl = "http://www.youtube.com/watch?v=" + videoCursor.getKey();
                        setupShareActionProvider();
                    }
                }

                mVideos.clear();
                VideoCursor videoCursor = new VideoCursor(cursor);
                videoCursor.moveToFirst();
                if(videoCursor.getCount() > 0) {
                   do {
                        mVideos.add(new Video(videoCursor));
                    } while (videoCursor.moveToNext());
                }
                break;
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        switch (loader.getId()) {
            case REVIEW_LOADER: {
                if(mFavoriteReviewsRVAdapter != null) {
                    mFavoriteReviewsRVAdapter.swapCursor(null);
                }
                break;
            }
            case VIDEO_LOADER: {
                if(mFavoriteVideosRVAdapter!= null) {
                    mFavoriteVideosRVAdapter.swapCursor(null);
                }
                break;
            }
        }
    }

    private void loadMovieContentView() {
        ImageView posterView = (ImageView) rootLayout.findViewById(R.id.poster_image);
        Picasso.with(getActivity().getApplicationContext()).load(Constant.TMDB_URL_IMAGE_BASE + "/w342/" + mMovie.getPosterPath()).into(posterView);

        TextView originalTitle = (TextView) rootLayout.findViewById(R.id.original_title);
        originalTitle.setText(mMovie.getOriginalTitle());

        TextView votes = (TextView) rootLayout.findViewById(R.id.average_vote);
        votes.setText(getString(R.string.movie_votes, mMovie.getVoteAverage(), mMovie.getVoteCount()));

        TextView overview = (TextView) rootLayout.findViewById(R.id.overview);
        overview.setText(mMovie.getOverview());

        String genres = "";
        int i = 0;
        for(Genre g : mMovie.getGenres()) {
            genres += g.getName();
            if(i < mMovie.getGenres().size() - 1) {
                genres += ", ";
            }
            i++;
        }

        TextView genre = (TextView) rootLayout.findViewById(R.id.genre);
        genre.setText(genres);

        String countries = "";
        i = 0;
        for(ProductionCountry c : mMovie.getProductionCountries()) {
            countries += c.getIso31661();
            if(i < mMovie.getProductionCountries().size() - 1) {
                countries += ", ";
            }
            i++;
        }

        TextView country = (TextView) rootLayout.findViewById(R.id.countries);
        country.setText(countries);

        TextView releaseDate = (TextView) rootLayout.findViewById(R.id.release_date);
        releaseDate.setText(mMovie.getReleaseDate());

        TextView runtime = (TextView) rootLayout.findViewById(R.id.runtime);
        runtime.setText(getString(R.string.movie_runtime, mMovie.getRuntime()));

    }

    private void updateMovieDetails() {
        if(mMovie.isFavorite()) {
            // Fetch favorite movies from DB
            if(mFavoriteReviewsRVAdapter == null) {
                mFavoriteReviewsRVAdapter = new FavoriteReviewAdapter(getActivity(), null);
                mReviewsRecyclerView.setAdapter(mFavoriteReviewsRVAdapter);
            }

            if(mFavoriteVideosRVAdapter== null) {
                mFavoriteVideosRVAdapter = new FavoriteVideoAdapter(getActivity(), null);
                mVideosRecyclerView.setAdapter(mFavoriteVideosRVAdapter);
            }

            // set genres

            String[] projectionGenres = {
                    MovieGenreColumns.TABLE_NAME + "." + MovieGenreColumns.GENRE_ID,
                    GenreColumns.NAME
            };

            MovieGenreSelection selection = new MovieGenreSelection();
            selection.movieId(mMovie.getDbId());
            MovieGenreCursor cursor = selection.query(getContext().getContentResolver(), projectionGenres);
            cursor.moveToFirst();

            ArrayList<Genre> genres = new ArrayList<Genre>(cursor.getCount());

            if(cursor.getCount() > 0) {
                do {
                    genres.add(new Genre(cursor.getGenreGenreId(), cursor.getGenreName()));
                } while (cursor.moveToNext());
            }
            cursor.close();

            mMovie.setGenres(genres);

            // set countries

            String[] projectionCountries = {
                    ProductionCountryColumns.PRODUCTION_COUNTRY_ISO,
                    ProductionCountryColumns.NAME
            };

            MovieProductionCountrySelection selectionPC = new MovieProductionCountrySelection();
            selectionPC.movieId(mMovie.getDbId());
            MovieProductionCountryCursor cursorPC = selectionPC.query(getContext().getContentResolver(), projectionCountries);
            cursorPC.moveToFirst();

            ArrayList<ProductionCountry> productionCountries = new ArrayList<ProductionCountry>(cursorPC.getCount());
            if(cursor.getCount() > 0) {
                do {
                    productionCountries.add(new ProductionCountry(cursorPC.getProductionCountryProductionCountryIso(), cursorPC.getProductionCountryName()));
                } while (cursorPC.moveToNext());

            }
            cursorPC.close();

            mMovie.setProductionCountries(productionCountries);

            loadMovieContentView();
        } else {
            //if network available, fetch movie details from API
            if (isNetworkAvailable()) {
                fetchMovieDetails(mMovie.getId());
                fetchMovieReviews(mMovie.getId());
                fetchMovieVideos(mMovie.getId());
            }
        }

    }

    public void onVideosUpdated(List<Video> videoArrayList) {
        int oldSize = mVideos.size();

        if(videoArrayList != null) {
            mVideos.clear();
            mVideosRVAdapter.notifyItemRangeRemoved(0, oldSize);

            for(Video aVideo : videoArrayList) {
                mVideos.add(aVideo);
            }

            mVideosRVAdapter.notifyItemRangeInserted(0, mVideos.size());
            mVideosRecyclerView.getLayoutParams().height = (150 + 16) * mVideos.size();

            if(mVideos.size() != 0) {
                mShareUrl = "http://www.youtube.com/watch?v=" + mVideos.get(0).getKey();
                setupShareActionProvider();
            }
        }

    }

    public void onMovieDetailUpdated(Movie movie) {
        mMovie = movie;
        loadMovieContentView();
    }

    public void onReviewsUpdated(List<Review> reviewArrayList) {
        int oldSize = mReviews.size();

        if(reviewArrayList != null) {
            mReviews.clear();
            mReviewsRVAdapter.notifyItemRangeRemoved(0, oldSize);

            for(Review aReview : reviewArrayList) {
                mReviews.add(aReview);
            }

            mReviewsRVAdapter.notifyItemRangeInserted(0, mReviews.size());
            mReviewsRecyclerView.getLayoutParams().height = (250 + 16) * mReviews.size();
        }
    }

    public void showSnackbarMessage(String message) {
        Snackbar.make(this.rootLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getDialogContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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


    private void fabOnClick(View view) {
        FloatingActionButton btnView = (FloatingActionButton)view;
        int id = view.getId();

        switch (id) {
            case R.id.fabBtnFav: {
                long movieId = DBHelper.insertMovie(getContext(), mMovie);
                mMovie.setDbId(movieId);

                // insert genres

                GenreContentValues[] genresContentValues = new GenreContentValues[mMovie.getGenres().size()];
                int i = 0;
                for(Genre genre : mMovie.getGenres()) {
                    GenreContentValues values = new GenreContentValues();
                    values.putName(genre.getName());
                    values.putGenreId(genre.getId());
                    genresContentValues[i] = values;
                    i++;
                }

                DBHelper.insertMovieGenres(getContext(), genresContentValues, movieId);

                // insert countries

                ProductionCountryContentValues[] productionCountryContentValues = new ProductionCountryContentValues[mMovie.getProductionCountries().size()];
                i = 0;
                for(ProductionCountry country : mMovie.getProductionCountries()) {
                    ProductionCountryContentValues values = new ProductionCountryContentValues();
                    values.putName(country.getName());
                    values.putProductionCountryIso(country.getIso31661());
                    productionCountryContentValues[i] = values;
                    i++;
                }

                DBHelper.insertMovieProductionCountries(getContext(), productionCountryContentValues, movieId);


                // bulk insert videos

                ContentValues[] videoContentValues = new ContentValues[mVideos.size()];
                i = 0;
                for(Video video : mVideos) {
                    VideoContentValues values = new VideoContentValues();
                    values.putVideoId(video.getId());
                    values.putIso(video.getIso());
                    values.putKey(video.getKey());
                    values.putName(video.getName());
                    values.putSite(video.getSite());
                    values.putSize(video.getSize());
                    values.putType(video.getType());
                    values.putMovieId(movieId);
                    videoContentValues[i] = values.values();
                    i++;
                }

                DBHelper.insertVideos(getContext(), videoContentValues);

                // bulk insert reviews

                ContentValues[] reviewContentValues = new ContentValues[mReviews.size()];
                i = 0;
                for(Review review : mReviews) {
                    ReviewContentValues values = new ReviewContentValues();
                    values.putReviewId(review.getId());
                    values.putAuthor(review.getAuthor());
                    values.putContent(review.getContent());
                    values.putUrl(review.getUrl());
                    values.putMovieId(movieId);
                    reviewContentValues[i] = values.values();
                    i++;
                }

                DBHelper.insertReviews(getContext(), reviewContentValues);

                btnView.setId(R.id.fabBtnUnFav);
                btnView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_delete_white_48dp));
                break;
            }
            case R.id.fabBtnUnFav: {
                DBHelper.deleteMovie(getContext(), mMovie.getId());
                btnView.setId(R.id.fabBtnFav);
                btnView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_favorite_white_48dp));
                break;
            }
        }
    }

    /**
     * @return Intent | null
     */
    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mShareUrl);

        return shareIntent;
    }

    private void setupShareActionProvider() {
        if(mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(createShareIntent());
        }
    }

    private void fetchMovieDetails(int id) {
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

        Call<Movie> call = tmdbService.getMovie(id, Constant.TMDB_API_KEY);

        call.enqueue(new retrofit.Callback<Movie>() {
            @Override
            public void onResponse(Response<Movie> movieResponse, Retrofit retrofit) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                onMovieDetailUpdated(movieResponse.body());
            }

            @Override
            public void onFailure(Throwable t) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                showSnackbarMessage(getString(R.string.message_not_connected));
            }
        });
    }

    private void fetchMovieReviews(int id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.TMDB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService tmdbService = retrofit.create(TMDBService.class);

        Call<ReviewsResult> call = tmdbService.getReviews(id, Constant.TMDB_API_KEY);

        call.enqueue(new retrofit.Callback<ReviewsResult>() {
            @Override
            public void onResponse(Response<ReviewsResult> response, Retrofit retrofit) {
                onReviewsUpdated(response.body().getReviews());
            }

            @Override
            public void onFailure(Throwable t) {
                showSnackbarMessage(getString(R.string.message_failed_get_reviews));
            }
        });
    }

    private void fetchMovieVideos(int id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.TMDB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService tmdbService = retrofit.create(TMDBService.class);

        Call<VideosResult> call = tmdbService.getVideos(id, Constant.TMDB_API_KEY);

        call.enqueue(new retrofit.Callback<VideosResult> () {
            @Override
            public void onResponse(Response<VideosResult> response, Retrofit retrofit) {
                onVideosUpdated(response.body().getVideos());
            }

            @Override
            public void onFailure(Throwable t) {
                showSnackbarMessage(getString(R.string.message_failed_get_reviews));
            }
        });
    }
}

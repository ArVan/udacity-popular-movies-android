package com.example.android.pmdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {
//    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        if(savedInstanceState == null) {
            Bundle args = new Bundle();
            args.putParcelable(Movie.class.getName(), getIntent().getParcelableExtra(Movie.class.getName()));

            MovieDetailActivityFragment movieDetailActivityFragment = new MovieDetailActivityFragment();
            movieDetailActivityFragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, movieDetailActivityFragment)
                    .commit();
        }

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        if(toolbar != null) {
//
//            setSupportActionBar(toolbar);
//            ActionBar actionBar = getSupportActionBar();
//            if (actionBar != null) {
//                actionBar.setHomeButtonEnabled(true);
//                actionBar.setDisplayHomeAsUpEnabled(true);
//            }
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void expandOverview(View view) {
        TextView overviewText = (TextView) findViewById(R.id.overview);
        overviewText.setMaxLines(Integer.MAX_VALUE);
        overviewText.setEllipsize(null);
    }
}

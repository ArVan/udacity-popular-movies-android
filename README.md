PMDB
---------

This is the Udacity Android Nanodegree Project 1 (The Popular Movie Database).
It has 1 Fragment Activities for popular movies list and single movie details.

The view is constructed using Android Design Support Library 22.2.1 (using [this tutorial](http://inthecheesefactory.com/blog/android-design-support-library-codelab/en)), so it should be added in Android Studio.

All the code used in the app is written for this project except the parts from Android Documentation

Important notice about The Movie Database API.
In order for the API to work, the API key should be added in `Constants.java` file in `TMDB_API_KEY` property.

There is one known issue in detail view. When trying to scroll the view while dragging on overview text view the scroll doesn't work.
It is somehow caused by the fact that there is a click listener on the text view.


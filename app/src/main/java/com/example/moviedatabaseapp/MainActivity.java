package com.example.moviedatabaseapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView moviePageTextView;
    private RecyclerView movieRecyclerView;
    List<Movie> movies;
    private MovieAdapter movieAdapter;

    /**
     * Set up the UI, initialize views, adapters, and data
     *
     * @param savedInstanceState Bundle containing the data it most recently supplied
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize UI components
        initializeViews();
        // Load and display movie data
        loadMovieData();
    }

    /**
     * Initialize UI components
     */
    private void initializeViews() {
        moviePageTextView = findViewById(R.id.textViewPageName);
        movieRecyclerView = findViewById(R.id.recyclerView);
        // Set up RecyclerView
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieRecyclerView.setHasFixedSize(true);
    }

    /**
     * Load movie data from JSON file
     */
    private void loadMovieData() {
        try {
            // Load movie data from JSON file
            movies = JsonUtils.loadMoviesFromJson(this, R.raw.movies);
            moviePageTextView.setText("Movie Vault");
            // Create and set adapter
            movieAdapter = new MovieAdapter(this.movies);
            movieRecyclerView.setAdapter(movieAdapter);
        } catch (Exception e) {
            Log.e(TAG, "Error loading movie data", e);
            ErrorHandler.handleError(this,  e, "Failed to load movie data. Please try again later."
            );
        }
    }
}
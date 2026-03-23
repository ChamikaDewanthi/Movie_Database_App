package com.example.moviedatabaseapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Represent a single movie item in a RecyclerView.
 *
 * Hold references to the UI components of a movie item layout
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ImageView posterImageView;
    private final TextView titleTextView;
    private final TextView yearTextView;
    private final TextView genreTextView;

    /**
     * Initialize movie holder with the provided item view.
     *
     * @param itemView the view representing a single item in the RecyclerView
     */
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        posterImageView = itemView.findViewById(R.id.imageViewMoviePoster);
        titleTextView = itemView.findViewById(R.id.textViewMovieTitle);
        yearTextView = itemView.findViewById(R.id.textViewMovieYear);
        genreTextView = itemView.findViewById(R.id.textViewMovieGenre);
    }

    /**
     * Return the ImageView used to display the movie poster.
     *
     * @return the ImageView representing the movie poster
     */
    public ImageView getPosterImageView() {
        return posterImageView;
    }

    /**
     * Return the TextView used to display the movie title.
     *
     * @return the TextView representing the movie title
     */
    public TextView getTitleTextView() {
        return titleTextView;
    }

    /**
     * Return the TextView used to display release year of the movie.
     *
     * @return the TextView representing release year of the movie
     */
    public TextView getYearTextView() {
        return yearTextView;
    }

    /**
     * Return the TextView used to display the movie genre.
     *
     * @return the TextView representing the movie genre
     */
    public TextView getGenreTextView() {
        return genreTextView;
    }
}

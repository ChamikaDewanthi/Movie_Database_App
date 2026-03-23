package com.example.moviedatabaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Display a list of Movie objects in a RecyclerView.
 *
 * Bind Movie data to MovieViewHolder items and handle the creation and binding of view holders.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final List<Movie> movies;

    /**
     * Construct a MovieAdapter with the provided list of movies.
     *
     * @param movies the list of Movies
     */
    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Inflate the item layout and create a new ViewHolder instance.
     *
     * @param parent the ViewGroup into which the new View will be added after it is bound
     * @param viewType the view type of the new View
     * @return a new MovieViewHolder that holds the inflated item view
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MovieViewHolder(view);
    }

    /**
     * Bind the data of a Movie object to the provided ViewHolder.
     *
     * Update the contents of the item view to reflect the Movie at the given position.
     *
     * @param holder the MovieViewHolder containing the views to be populated
     * @param position the position of the Movie item in the dataset
     */
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        try {
            Movie movie = movies.get(position);
            // Set the text of the title TextView in the ViewHolder
            holder.getTitleTextView().setText(
                    movie.getTitle() != null ? movie.getTitle() : "N/A"
            );
            // Set the text of the year TextView in the ViewHolder
            holder.getYearTextView().setText(
                    movie.getYear() > 1800 ? String.valueOf(movie.getYear()) : "N/A"
            );
            // Set the text of the genre TextView in the ViewHolder
            holder.getGenreTextView().setText(
                    movie.getGenre() != null ? movie.getGenre() : "N/A"
            );
            // Set the image for movie poster ImageView in the ViewHolder
            String posterName = movie.getPosterResource();
            int resId = holder.itemView.getContext()
                    .getResources()
                    .getIdentifier(posterName, "drawable",
                            holder.itemView.getContext().getPackageName());
            if (resId != 0) {
                holder.getPosterImageView().setImageResource(resId);
            } else {
                // Set placeholder movie poster, if the image is not available
                holder.getPosterImageView().setImageResource(R.drawable.movie_poster_placeholder);
            }
        } catch (Exception e) {
            ErrorHandler.logError("MovieAdapter", "Error binding view", e);
        }
    }

    /**
     * Return the total number of items in the movie list.
     *
     * @return the number of movies in the adapter's movie list
     */
    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    /**
     * Replace the current list of movies with a new list.
     *
     * @param newMovies the list of Movie objects to replace the current list
     */
    public void updateMovies(List<Movie> newMovies) {
        movies.clear();
        movies.addAll(newMovies);
    }
}
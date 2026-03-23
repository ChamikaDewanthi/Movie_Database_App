package com.example.moviedatabaseapp;

import java.io.Serializable;

/**
 * Represent a movie entity with basic details: title, release year, genre, and poster resource.
 */
public class Movie implements Serializable {

    private String title;
    private int year;
    private String genre;
    String posterResource;

    /**
     * Default constructor for the Movie.
     *
     * Initialize a Movie object without setting any initial values.
     */
    public Movie() {}

    /**
     * Construct a Movie object with the specified details.
     *
     * @param title the title of the movie
     * @param year the release year of the movie
     * @param genre the genre of the movie
     * @param posterResource the poster resource identifier or path for the movie
     */
    public Movie(String title, Integer year, String genre, String posterResource) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResource = posterResource;
    }

    /** Return the title of the movie.
     * @return the movie title
     */
    public String getTitle() {
        return this.title;
    }

    /** Set the title of the movie.
     * @param title the movie title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Return the release year of the movie.
     * @return the movie release year
     */
    public int getYear() {
        return this.year;
    }

    /** Set the release year of the movie.
     * @param year the movie release year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /** Return the genre of the movie.
     * @return the movie genre
     */
    public String getGenre() {
        return this.genre;
    }

    /** Set the genre of the movie.
     * @param genre the movie genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /** Return the poster resource of the movie.
     * @return the movie poster resource
     */
    public String getPosterResource() {
        return this.posterResource;
    }

    /** Set the poster resource of the movie.
     * @param posterResource the movie poster resource
     */
    public void setPosterResource(String posterResource) {
        this.posterResource = posterResource;
    }
}
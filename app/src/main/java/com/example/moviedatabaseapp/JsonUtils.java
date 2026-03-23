package com.example.moviedatabaseapp;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Load movies from a JSON file.
 */
public class JsonUtils {

    /**
     * Load a list of Movie objects from a JSON file stored in the app's raw resources.
     *
     * @param context The application or activity context used to access resources.
     * @param resourceId The resource ID.
     * @return A list of Movie objects.
     */
    public static List<Movie> loadMoviesFromJson(Context context, int resourceId) throws IOException, JSONException {

        // Read the JSON file content
        String jsonContent = readJsonFile(context, resourceId);
        // Parse the JSON content to an array
        JSONArray moviesArray = new JSONArray(jsonContent);
        // Create a movies list
        List<Movie> movies  = new ArrayList<>();

        // Set properties of movies
        for (int i = 0; i < moviesArray.length(); i++) {
            try {
                JSONObject itemJson = moviesArray.getJSONObject(i);
                Movie movie = new Movie();
                if (itemJson.has("title") && !itemJson.isNull("title")) {
                    movie.setTitle(itemJson.getString("title"));
                } else {
                    throw new JSONException("Movie title is required");
                } if (itemJson.has("year")) {
                    int year = itemJson.optInt("year", -1);
                    if(year != -1) {
                        movie.setYear(itemJson.getInt("year"));
                    } else {
                        movie.setYear(0);
                    }
                } else {
                    movie.setYear(0);
                } if (itemJson.has("genre")) {
                    movie.setGenre(itemJson.getString("genre"));
                } else {
                    movie.setGenre("N/A");
                } if (itemJson.has("poster")) {
                    movie.setPosterResource(itemJson.getString("poster"));
                } else {
                    movie.setPosterResource("N/A");
                }
                // Add the movie to the list
                movies.add(movie);
            } catch (JSONException e) {
                Log.e(TAG, "Error parsing movies at index " + i, e);
            }
        }
        // Return the movie list
        return movies;
    }

    /**
     * Read a JSON file from the app's raw resources and returns its content as a String.
     *
     * @param context the application context used to access resources
     * @param resourceId the resource ID
     * @return the content of the JSON file as a String
     */
    private static String readJsonFile(Context context, int resourceId) throws IOException {

        // Create a container for the file content
        StringBuilder stringBuilder = new StringBuilder();
        // Open the file
        try (InputStream inputStream = context.getResources().openRawResource(resourceId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Read file line by line and append to the container
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file", e);
            throw e;
        }
        // Return content as a String
        return stringBuilder.toString();
    }
}
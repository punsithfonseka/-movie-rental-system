package movierental.service;

import movierental.model.Movie;
import java.io.*;
import java.util.*;

public class MovieService {

    private static final String FILE_PATH =
            "src/main/resources/data/movies.txt";

    // ✅ ADD MOVIE (Admin)
    public void addMovie(Movie movie) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            writer.write(
                    movie.getMovieId() + "," +
                            movie.getTitle() + "," +
                            movie.getActorIds() + "," +
                            movie.getDirectorIds()
            );
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ VIEW MOVIES
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 4) continue;

                Movie movie = new Movie(
                        data[0],
                        data[1],
                        data[2],
                        data[3]
                );

                movies.add(movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
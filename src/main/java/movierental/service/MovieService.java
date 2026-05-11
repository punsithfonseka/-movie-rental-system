package movierental.service;

import movierental.model.Movie;
import java.io.*;
import java.util.*;

public class MovieService {

    private static final String FILE_PATH =
            "src/main/resources/data/movies.txt";

    // ✅ ✅ AUTO GENERATE MOVIE ID
    private String generateMovieId() {

        List<Movie> movies = getAllMovies();

        int count = movies.size() + 1;

        return "M" + String.format("%03d", count);
    }

    // ✅ ✅ ADD MOVIE (UPDATED WITH AUTO ID)
    public void addMovie(Movie movie) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            // ✅ Generate ID automatically
            String autoId = generateMovieId();
            movie.setMovieId(autoId);

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

    // ✅ READ ALL MOVIES
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

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
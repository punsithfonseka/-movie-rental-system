package movierental.service;

import movierental.model.Movie;
import movierental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    /* =========================
       ADD MOVIE
    ========================= */
    public void addMovie(Movie movie) {
        repo.save(movie);
    }

    /* =========================
       GET ALL MOVIES
    ========================= */
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    /* =========================
       DELETE MOVIE
    ========================= */
    public void deleteMovie(String id) {
        repo.deleteById(id);
    }

    /* =========================
       UPDATE MOVIE (FIXED)
    ========================= */
    public boolean updateMovie(String movieId, Movie updatedMovie) {

        Optional<Movie> optionalMovie = repo.findById(movieId);

        if (optionalMovie.isPresent()) {

            Movie existingMovie = optionalMovie.get();

            // keep same ID
            updatedMovie.setMovieId(movieId);

            // save updated movie
            repo.save(updatedMovie);

            return true;
        }

        return false;
    }
}
package movierental.service;

import movierental.model.Movie;
import movierental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    public void addMovie(Movie movie) {
        repo.save(movie);
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public void deleteMovie(String id) {
        repo.deleteById(id);
    }
}

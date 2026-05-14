package movierental.controller;

import movierental.model.Movie;
import movierental.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie) {
        service.addMovie(movie);
        return "Movie added";
    }

    @GetMapping("/all")
    public List<Movie> getAll() {
        return service.getAllMovies();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.deleteMovie(id);
        return "Movie deleted";
    }
}
package movierental.controller;

import movierental.model.Movie;
import movierental.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService service;

    /* =========================
       ADD MOVIE
    ========================= */
    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie) {
        service.addMovie(movie);
        return "Movie added successfully";
    }

    /* =========================
       GET ALL MOVIES
    ========================= */
    @GetMapping("/all")
    public List<Movie> getAll() {
        return service.getAllMovies();
    }

    /* =========================
       DELETE MOVIE
    ========================= */
    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        service.deleteMovie(id);
        return "Movie deleted successfully";
    }

    /* =========================
       UPDATE MOVIE (FIXED)
    ========================= */
    @PutMapping("/update/{movieId}")
    public String updateMovie(
            @PathVariable String movieId,
            @RequestBody Movie movie) {

        boolean updated = service.updateMovie(movieId, movie);

        if (updated) {
            return "Movie updated successfully";
        } else {
            return "Movie not found";
        }
    }
}
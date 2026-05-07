package movierental.controller;

import movierental.model.Movie;
import movierental.model.Contributor;
import movierental.service.MovieService;
import movierental.service.ContributorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService = new MovieService();
    private ContributorService contributorService = new ContributorService();

    // ✅ ADD MOVIE (Browser-friendly: GET)
    @GetMapping("/add")
    public String addMovie(@RequestParam String movieId,
                           @RequestParam String title,
                           @RequestParam String actorIds,
                           @RequestParam String directorIds) {

        Movie movie = new Movie(movieId, title, actorIds, directorIds);
        movieService.addMovie(movie);

        return "Movie added successfully";
    }

    // ✅ VIEW ALL MOVIES
    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // ✅ GET ACTORS FOR A SPECIFIC MOVIE (LINKING LOGIC)
    @GetMapping("/{movieId}/actors")
    public List<Contributor> getActorsForMovie(@PathVariable String movieId) {

        List<Contributor> result = new ArrayList<>();
        List<Movie> movies = movieService.getAllMovies();

        String actorIdString = "";

        // Find the movie
        for (Movie m : movies) {
            if (m.getMovieId().equals(movieId)) {
                actorIdString = m.getActorIds();
                break;
            }
        }

        if (actorIdString.isEmpty()) {
            return result;
        }

        String[] actorIds = actorIdString.split("\\|");

        // Match actor IDs with contributors
        for (Contributor c : contributorService.getAllContributors()) {
            for (String id : actorIds) {
                if (c.getId().equals(id) &&
                        c.getRole().equalsIgnoreCase("Actor")) {
                    result.add(c);
                }
            }
        }

        return result;
    }
}
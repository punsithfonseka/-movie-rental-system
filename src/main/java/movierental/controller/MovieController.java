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

    // ✅ ✅ UPDATED: ADD MOVIE (NO movieId from user)
    @GetMapping("/add")
    public String addMovie(@RequestParam String title,
                           @RequestParam String actorIds,
                           @RequestParam String directorIds) {

        // ✅ movieId will be generated automatically in service
        Movie movie = new Movie(null, title, actorIds, directorIds);

        movieService.addMovie(movie);

        return "Movie added successfully";
    }

    // ✅ VIEW ALL MOVIES
    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // ✅ SEARCH MOVIE BY TITLE
    @GetMapping("/search")
    public Movie searchByTitle(@RequestParam String title) {

        List<Movie> movies = movieService.getAllMovies();

        for (Movie m : movies) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return m;
            }
        }

        return null;
    }

    // ✅ GET ALL CONTRIBUTORS (Actors + Directors)
    @GetMapping("/{movieId}/contributors")
    public List<Contributor> getContributorsForMovie(@PathVariable String movieId) {

        List<Contributor> result = new ArrayList<>();
        List<Movie> movies = movieService.getAllMovies();

        String allIds = "";

        // ✅ Find movie
        for (Movie m : movies) {
            if (m.getMovieId().equals(movieId)) {

                // ✅ Combine actors + directors
                allIds = m.getActorIds() + "|" + m.getDirectorIds();
                break;
            }
        }

        if (allIds.isEmpty()) {
            return result;
        }

        // ✅ Split IDs (handles | , space)
        String[] ids = allIds.split("[,| ]+");

        // ✅ Match contributors
        for (Contributor c : contributorService.getAllContributors()) {
            for (String id : ids) {
                if (c.getId().equals(id.trim())) {
                    result.add(c);
                }
            }
        }

        return result;
    }
}

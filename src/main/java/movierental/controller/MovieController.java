package movierental.controller;

import movierental.model.Contributor;
import movierental.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService = new MovieService();

    // ✅ Get actors of a movie
    @GetMapping("/{movieId}/actors")
    public List<Contributor> getActorsForMovie(@PathVariable String movieId) {
        return movieService.getActorsForMovie(movieId);
    }
}
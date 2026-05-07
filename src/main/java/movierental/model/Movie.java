package movierental.model;

public class Movie {

    private String movieId;
    private String title;
    private String actorIds;
    private String directorIds;

    public Movie(String movieId, String title, String actorIds, String directorIds) {
        this.movieId = movieId;
        this.title = title;
        this.actorIds = actorIds;
        this.directorIds = directorIds;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getActorIds() {
        return actorIds;
    }

    public String getDirectorIds() {
        return directorIds;
    }
}

package movierental.model;

public class Movie {

    private String movieId;
    private String title;
    private String actorIds;
    private String directorIds;

    // ✅ Constructor
    public Movie(String movieId, String title, String actorIds, String directorIds) {
        this.movieId = movieId;
        this.title = title;
        this.actorIds = actorIds;
        this.directorIds = directorIds;
    }

    // ✅ GETTERS
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

    // ✅ ✅ ADD THESE SETTERS (VERY IMPORTANT)

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActorIds(String actorIds) {
        this.actorIds = actorIds;
    }

    public void setDirectorIds(String directorIds) {
        this.directorIds = directorIds;
    }
}
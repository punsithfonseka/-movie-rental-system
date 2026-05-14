package movierental.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    private String movieId;

    private String title;
    private int year;

    // ✅ RELATIONSHIP (IMPORTANT ⭐)
    @ManyToMany
    private List<Contributor> contributors;

    public Movie() {}

    public Movie(String movieId, String title, int year, List<Contributor> contributors) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.contributors = contributors;
    }

    // getters & setters

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public List<Contributor> getContributors() { return contributors; }
    public void setContributors(List<Contributor> contributors) { this.contributors = contributors; }
}
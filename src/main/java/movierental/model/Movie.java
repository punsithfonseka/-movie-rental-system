package movierental.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    private String movieId;

    private String title;

    private int year;

    /* =========================
       MOVIE BANNER
    ========================= */

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String banner;

    /* =========================
       RELATIONSHIP
    ========================= */

    @ManyToMany
    private List<Contributor> contributors;

    public Movie() {}

    public Movie(
            String movieId,
            String title,
            int year,
            String banner,
            List<Contributor> contributors
    ) {

        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.banner = banner;
        this.contributors = contributors;
    }

    /* =========================
       GETTERS & SETTERS
    ========================= */

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(
            List<Contributor> contributors
    ) {
        this.contributors = contributors;
    }
}
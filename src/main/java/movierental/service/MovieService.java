package movierental.service;

import movierental.model.Contributor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private static final String MOVIE_FILE = "src/main/resources/data/movies.txt";

    private ContributorService contributorService = new ContributorService();

    // ✅ Get actors for a specific movie using movieId
    public List<Contributor> getActorsForMovie(String movieId) {

        List<String> actorIds = new ArrayList<>();
        List<Contributor> actors = new ArrayList<>();

        // 1️⃣ Read movies.txt and find the movie
        try (BufferedReader reader = new BufferedReader(new FileReader(MOVIE_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].equals(movieId)) {
                    String[] ids = data[2].split("\\|");
                    for (String id : ids) {
                        actorIds.add(id);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2️⃣ Match actor IDs with contributors
        for (Contributor contributor : contributorService.getAllContributors()) {
            if (actorIds.contains(contributor.getId())
                    && contributor.getRole().equalsIgnoreCase("Actor")) {
                actors.add(contributor);
            }
        }

        return actors;
    }
}
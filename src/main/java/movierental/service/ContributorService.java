package movierental.service;

import movierental.model.Contributor;
import movierental.repository.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributorService {

    @Autowired
    private ContributorRepository repo;

    // ✅ AUTO ID GENERATOR (better safety)
    private String generateContributorId(String role) {

        long count = repo.count() + 1;
        String number = String.format("%03d", count);

        if ("Actor".equalsIgnoreCase(role)) {
            return "A" + number;
        } else if ("Director".equalsIgnoreCase(role)) {
            return "D" + number;
        } else {
            return "C" + number;
        }
    }

    // ✅ CREATE
    public void addContributor(Contributor contributor) {

        // generate ID only if not already set
        if (contributor.getId() == null || contributor.getId().isEmpty()) {
            String id = generateContributorId(contributor.getRole());
            contributor.setId(id);
        }

        repo.save(contributor);
    }

    // ✅ READ
    public List<Contributor> getAllContributors() {
        return repo.findAll();
    }

    // ✅ UPDATE
    public boolean updateContributor(String id, Contributor updatedContributor) {

        if (!repo.existsById(id)) {
            return false;
        }

        updatedContributor.setId(id);
        repo.save(updatedContributor);

        return true;
    }

    // ✅ DELETE
    public boolean deleteContributor(String id) {

        if (!repo.existsById(id)) {
            return false;
        }

        repo.deleteById(id);
        return true;
    }
}
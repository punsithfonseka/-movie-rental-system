package movierental.service;

import movierental.model.Contributor;
import movierental.repository.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ REQUIRED
public class ContributorService {

    @Autowired
    private ContributorRepository repo;

    // ✅ AUTO ID GENERATOR
    private String generateContributorId(String role) {

        long count = repo.count() + 1;

        String number = String.format("%03d", count);

        if (role.equalsIgnoreCase("Actor")) {
            return "A" + number;
        } else if (role.equalsIgnoreCase("Director")) {
            return "D" + number;
        } else {
            return "C" + number;
        }
    }

    // ✅ CREATE
    public void addContributor(Contributor contributor) {

        String id = generateContributorId(contributor.getRole());
        contributor.setId(id);

        repo.save(contributor);   // ✅ SAVES TO MYSQL
    }

    // ✅ READ
    public List<Contributor> getAllContributors() {
        return repo.findAll();   // ✅ FETCH FROM MYSQL
    }

    // ✅ UPDATE
    public boolean updateContributor(String id, Contributor updatedContributor) {

        if (repo.existsById(id)) {

            updatedContributor.setId(id);
            repo.save(updatedContributor);

            return true;
        }

        return false;
    }

    // ✅ DELETE
    public boolean deleteContributor(String id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }

        return false;
    }
}
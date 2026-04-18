package movierental.controller;

import movierental.model.Contributor;
import movierental.service.ContributorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contributors")

public class ContributorController {

    private ContributorService contributorService = new ContributorService();

    // ✅ CREATE: Add a contributor
    @PostMapping("/add")
    public String addContributor(@RequestBody Contributor contributor) {
        contributorService.addContributor(contributor);
        return "Contributor added successfully";
    }

    // ✅ READ: View all contributors
    @GetMapping("/all")
    public List<Contributor> getAllContributors() {
        return contributorService.getAllContributors();
    }
}



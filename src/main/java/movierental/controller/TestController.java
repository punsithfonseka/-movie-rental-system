package movierental.controller;

import movierental.model.Contributor;
import movierental.service.ContributorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Simple test endpoint
    @GetMapping("/")
    public String home() {
        return "Server is working!";
    }

    // TEMPORARY test to check file handling
    @GetMapping("/test-add")
    public String testAddContributor() {

        ContributorService service = new ContributorService();

        service.addContributor(
                new Contributor("A001", "John", "Reviewer", 25, "Sri Lanka")
        );

        return "Contributor added successfully";
    }
}
package movierental.controller;

import movierental.model.Contributor;
import movierental.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // ✅ Inject service properly
    @Autowired
    private ContributorService service;

    // ✅ Simple test endpoint
    @GetMapping("/")
    public String home() {
        return "Server is working!";
    }

    // ✅ TEMP TEST (with photo ✅)
    @GetMapping("/test-add")
    public String testAddContributor() {

        service.addContributor(
                new Contributor(
                        "A001",
                        "John",
                        "Reviewer",
                        25,
                        "Sri Lanka",
                        "https://via.placeholder.com/100"
                )
        );

        return "Contributor added successfully";
    }
}
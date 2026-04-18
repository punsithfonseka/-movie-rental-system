package movierental.service;

import movierental.model.Contributor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContributorService {

    private static final String FILE_PATH =
            "src/main/resources/data/contributors.txt";

    // CREATE: Add a contributor to the file
    public void addContributor(Contributor contributor) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            writer.write(
                    contributor.getId() + "," +
                            contributor.getName() + "," +
                            contributor.getRole() + "," +
                            contributor.getAge() + "," +
                            contributor.getCountry()
            );
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // READ: Get all contributors from the file
    public List<Contributor> getAllContributors() {

        List<Contributor> contributors = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Contributor contributor = new Contributor(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4]
                );

                contributors.add(contributor);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return contributors;
    }
}
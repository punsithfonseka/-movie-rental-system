package movierental.service;

import movierental.model.Contributor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContributorService {

    private static final String FILE_PATH =
            "src/main/resources/data/contributors.txt";

    // ✅ CREATE
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

    // ✅ READ
    public List<Contributor> getAllContributors() {
        List<Contributor> contributors = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data.length < 5) continue;

                Contributor contributor = new Contributor(
                        data[0],
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

    // ✅ UPDATE
    public boolean updateContributor(String id, Contributor updatedContributor) {
        List<Contributor> contributors = getAllContributors();
        boolean updated = false;

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Contributor c : contributors) {
                if (c.getId().equals(id)) {
                    writer.write(
                            updatedContributor.getId() + "," +
                                    updatedContributor.getName() + "," +
                                    updatedContributor.getRole() + "," +
                                    updatedContributor.getAge() + "," +
                                    updatedContributor.getCountry()
                    );
                    updated = true;
                } else {
                    writer.write(
                            c.getId() + "," +
                                    c.getName() + "," +
                                    c.getRole() + "," +
                                    c.getAge() + "," +
                                    c.getCountry()
                    );
                }
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return updated;
    }

    // ✅ DELETE
    public boolean deleteContributor(String id) {
        List<Contributor> contributors = getAllContributors();
        boolean deleted = false;

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Contributor c : contributors) {
                if (!c.getId().equals(id)) {
                    writer.write(
                            c.getId() + "," +
                                    c.getName() + "," +
                                    c.getRole() + "," +
                                    c.getAge() + "," +
                                    c.getCountry()
                    );
                    writer.newLine();
                } else {
                    deleted = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
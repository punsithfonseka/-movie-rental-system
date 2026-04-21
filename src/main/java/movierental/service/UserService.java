package movierental.service;

import movierental.model.User;
import java.io.*;
import java.util.*;

public class UserService {

    private static final String FILE_PATH = "src/main/resources/data/users.txt";

    public User authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return new User(data[0], data[1], data[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


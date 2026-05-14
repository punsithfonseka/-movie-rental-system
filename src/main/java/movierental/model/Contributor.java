package movierental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contributor {

    @Id
    private String id;

    private String name;
    private String role;
    private int age;
    private String country;

    // ✅ NEW FIELD FOR IMAGE
    private String photo;

    // ✅ Default constructor
    public Contributor() {}

    // ✅ Updated constructor
    public Contributor(String id, String name, String role, int age, String country, String photo) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
        this.country = country;
        this.photo = photo;
    }

    // ✅ Getters & Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    // ✅ NEW getter/setter for photo
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
}
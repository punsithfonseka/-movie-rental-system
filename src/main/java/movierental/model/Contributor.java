package movierental.model;

public class Contributor {

    private int id;
    private String name;
    private String role;
    private int age;
    private String country;

    public Contributor() {}

    public Contributor(int id, String name, String role, int age, String country) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
        this.country = country;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
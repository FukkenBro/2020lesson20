
public class User {
    private String id;
    private String name;
    private int age;

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void update(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                "}\n";
    }
}

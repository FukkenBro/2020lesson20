import java.util.List;

public interface Storage {
    void removeAll();

    void removeUser(String id);

    void removeUserByName(String name);

    void addUser(User user);

    void updateUser(User user);

    User getUser(String id);

    List<User> getAllUsers();
}

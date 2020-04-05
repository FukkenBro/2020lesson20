import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import flexjson.JSONSerializer;

public class FileStorage implements Storage {

    private HashSet<User> container = new HashSet<>();

    private void serialize() {
        JSONSerializer serializer = new JSONSerializer();
        String s = serializer.deepSerialize(this);
        write(s);
    }

    private void write(String s) {
        File fold = new File("storage.txt");
        fold.delete();
        File fnew = new File("storage.txt");
        try {
            FileWriter fw = new FileWriter(fnew, false);
            fw.write(s);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll() {
        container.clear();
        serialize();
    }

    @Override
    public void removeUser(String id) {
        User tmp = null;
        for (User u : container) {
            if (u.getId().equals(id)) ;
            tmp = u;
        }
        removeUser(tmp);
    }

    private void removeUser(User user) {
        container.remove(user);
        serialize();
    }

    @Override
    public void removeUserByName(String name) {
        User tmp = null;
        for (User u : container) {
            if (u.getName().equals(name)) ;
            tmp = u;
        }
        removeUser(tmp);
    }

    @Override
    public void addUser(User user) {
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        container.add(user);
        serialize();
    }

    @Override
    public void updateUser(User user) {
        for (User u : container) {
            if (u.equals(user)) {
                u = user;
            }
            serialize();
        }
    }

    @Override
    public User getUser(String id) {
        for (User u : container) {
            if (u.getId().equals(id)) ;
            return u;
        }
        return null;
    }

    public String getId(String name) {
        for (User u : container) {
            if (u.getName().equals(name)) ;
            return u.getId();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> output = new ArrayList<>(container);
        return output;
    }
}

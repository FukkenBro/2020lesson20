
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        FileStorage fs = new FileStorage();
        //addUser
        fs.addUser(new User("Никита Метёлкин", 25));
        fs.addUser(new User("Заслонка Дроссельная", 666));
        fs.addUser(new User("Старый Петрович", 2020));
        String oldPetrovichId = fs.getId("Старый Петрович");
        User oldPetrovich = fs.getUser(oldPetrovichId);
        oldPetrovich.update("Молодой Петрович", -14);
        //updateUser
        fs.updateUser(fs.getUser(oldPetrovichId));
        //getAllUsers
        ArrayList<User> allUsers = fs.getAllUsers();
        System.out.println(allUsers);
        //removeUser
        fs.removeUser(oldPetrovichId);
        //removeUserByName
        fs.removeUserByName("Заслонка Дроссельная");
        //removeAll
        fs.removeAll();
        allUsers = fs.getAllUsers();
        System.out.println(allUsers);

        // storageTest
        String[] fNames = new String[]{"John", "Emma", "Robbert", "Olivia", "Jackson", "Sarah", "Nathan", "Sam", "Kimmy", "Patrick", "Jill"};
        String[] lNames = new String[]{"Gourley", "Radcliff", "Jackson", "Stone", "Johnson", "Bellamy", "Bayley", "Irwin", "Seaward", "MacFarlane"};
        for (int i = 0; i < 10; i++) {
            int fn = RANDOM.nextInt(fNames.length);
            int ln = RANDOM.nextInt(lNames.length);
            StringBuilder sb = new StringBuilder(fNames[fn]);
            sb.append(" " + lNames[ln]);
            User tmp = new User(sb.toString(), RANDOM.nextInt(80) + 18);
            fs.addUser(tmp);
        }
        allUsers = fs.getAllUsers();
        System.out.println(allUsers);
    }
}

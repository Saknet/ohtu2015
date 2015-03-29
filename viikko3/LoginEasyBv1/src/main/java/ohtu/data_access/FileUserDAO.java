
package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;
import org.springframework.stereotype.Component;

@Component
public class FileUserDAO implements UserDao{
    
    private List<User> users;
    private File file;

    public FileUserDAO(String file) {
        this.users = new ArrayList<User>();
        this.file = new File(file);
        
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNext()) {
                String username = scanner.next();
                String password = scanner.next();
                users.add(new User(username, password));
            }
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe:" + e.getMessage());
        }
    }
    
    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        try {
            users.add(user);
            FileWriter writer = new FileWriter(this.file);
            for (User u : users) {
                writer.write(u.getUsername() + "\n" + u.getPassword() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Tiedoston kirjoittaminen epäonnistui. Virhe:" + e.getMessage());
        }
    }
}

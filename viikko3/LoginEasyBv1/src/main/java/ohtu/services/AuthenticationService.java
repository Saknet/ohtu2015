package ohtu.services;

import ohtu.domain.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;
    
    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.length() < 3 || !usernameIsValid(username)) {
            return true;
        }
        if (password.length() < 8 || !passwordIsValid(password)) {
            return true;
        }
        
        return false;
    }
    
    private boolean usernameIsValid(String username) {
        for (int i = 0; i < userDao.listAll().size(); i++) {
            if (userDao.listAll().get(i).getUsername().equals(username)) {
                return false;
            }
        }
        
        if (!username.matches("[a-zA-z]*")) {
            return false;
        }
        
        return true;
    }
    
    private boolean passwordIsValid(String password) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        
        if (b) {
            return true;
        } 
        else if (password.matches(".*\\d+.*")) {
            return true;
        } else {
            return false;
        }       
    }
}

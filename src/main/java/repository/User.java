package repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
//na razie klasa, później będzie podpięta DB
public class User implements UserInterface {

    private String userName = "Joe";
    private String password = "123";

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void showUserData() {
        String userData = "Dane użytkownika: login = " + userName;
    }
}

package pl.kfrak.repository;

import org.springframework.stereotype.Component;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
//na razie klasa, później będzie podpięta DB
public class User {

    private String userName = "Joe";
    private String password = "123";

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return userName;
    }

    public String getUsername() {
        return userName;
    }
}

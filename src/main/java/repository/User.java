package repository;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
//na razie klasa, później będzie podpięta DB
public class User implements Serializable {

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

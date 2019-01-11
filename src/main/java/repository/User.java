package repository;

/**
 * Created by kfrak on 15.12.2018.
 */
public class User {

    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }
}

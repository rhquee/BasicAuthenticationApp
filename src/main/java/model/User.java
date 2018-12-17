package model;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;

/**
 * Created by kfrak on 15.12.2018.
 */
@Entity
public class User {
    @NotNull
    private String userName;
    @NotNull
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

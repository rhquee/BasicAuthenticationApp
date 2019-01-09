package repository;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;

/**
 * User jest "bazą danych", DTO - klasą z polami odpowiadającymi 1:1 formularzowi.
 * <p>
 * Problem:
 * model.addAttribute("loginForm", new User());
 * new User() ma wartości pól Joe i 123 z defaultu.
 */
public class UserDTO implements Serializable {

    @NotNull
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

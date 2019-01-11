package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetails;

/**
 * Created by kfrak on 11.01.2019.
 */
public class AuthenticationValidator {
    @Autowired
    UserDetails userDetails;

    public boolean checkIfUserSuccessLogedIn(UserDetails userDetails, String password) {
        if (userDetails.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

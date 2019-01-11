package service;

import org.springframework.security.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by kfrak on 11.01.2019.
 */
@Service
public class AuthenticationValidator {

    public boolean checkIfUserSuccessLogedIn(UserDetails u, String password) {
        if (u.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

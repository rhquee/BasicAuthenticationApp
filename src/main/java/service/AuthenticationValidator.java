package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserDetailsServiceImplementation;

/**
 * Created by kfrak on 11.01.2019.
 */
@Service
public class AuthenticationValidator {

    @Autowired
    UserDetailsServiceImplementation userDetailsServiceImplementation;

    public boolean checkIfUserSuccessLogedIn(String username, String password) {
        if (userDetailsServiceImplementation.loadUserByUsername(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by kfrak on 31.12.2018.
 */
@Service
public class UserDetailsServiceImplemetation implements UserDetailsService {

    /*
    userDataService = Core interface which loads user-specific data.
     */

    @Autowired
    private User user;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        if (user.getUsername().equalsIgnoreCase(userName))
            return (UserDetails) user;
        else throw new UsernameNotFoundException("");
    }

}

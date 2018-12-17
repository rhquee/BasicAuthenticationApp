package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import repository.UserRepository;

/**
 * Created by kfrak on 15.12.2018.
 */
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(userName);
        return new org.springframework.security.userdetails.User(User.getUserName(), user.getPassword());
    }
}

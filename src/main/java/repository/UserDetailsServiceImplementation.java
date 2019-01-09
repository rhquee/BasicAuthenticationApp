package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService = Core interface which loads user-specific data.
 */
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private User user;

    public boolean loadUserByUsernameAndPassword(String userName, String password) {
        if (isLoginAndPasswordMatch(userName, password)) {
            loadUserByUsername(userName);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        if (!userName.equalsIgnoreCase(user.getUsername())) {
            throw new UsernameNotFoundException(userName + " not found");
        }
        return new UserDetails() {
            @Override
            public GrantedAuthority[] getAuthorities() {
                return new GrantedAuthority[0];
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    private boolean isLoginAndPasswordMatch(String userName, String password) {
        return userName.equalsIgnoreCase(user.getUsername())
                && password.equalsIgnoreCase(user.getPassword());
    }
}

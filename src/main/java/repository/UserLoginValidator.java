package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by kfrak on 31.12.2018.
 */
@Service
//public class UserLoginValidator implements UserDetailsService {
public class UserLoginValidator implements UserDetailsService, Validator {

    /*
    UserDetailsService = Core interface which loads user-specific data.

    Validator =  validator for application-specific objects. This interface is totally divorced from
    any infrastructure or context.
     */

    @Autowired
    private User user;


    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        if (user.getUsername().equalsIgnoreCase(userName))
            return (UserDetails) user;
        else throw new UsernameNotFoundException("");
    }


    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required");
        if(user.getUsername().trim().length() < 2 || user.getUsername().trim().length() > 10 ){
            errors.rejectValue("username", "login.field.min.max.length");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
        if(user.getPassword().trim().length() < 2 || user.getPassword().trim().length() > 10){
            errors.rejectValue("password", "password.field.min.max.length");
        }
    }
}

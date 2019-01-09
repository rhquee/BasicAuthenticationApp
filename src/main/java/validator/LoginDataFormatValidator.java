package validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import repository.User;
import repository.UserDTO;

/**
 * Validator =  validator for application-specific objects. This interface is totally divorced from
 * any infrastructure or context.
 */


@Service
public class LoginDataFormatValidator implements Validator {
    //zanim aplikacja sprawdzi, czy login i hasło się zgadzają z Userem,
    // to zwaliduje, czy wprowadzone dane nie są za którkie/długie

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object user, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required");
        if (!isUsernameLengthCorrect((UserDTO) user)) {
            errors.rejectValue("username", "login.field.min.max.length");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
        if (!isPasswordLengthCorrect((UserDTO) user)) {
            errors.rejectValue("password", "password.field.min.max.length");
        }
    }

    private boolean isPasswordLengthCorrect(UserDTO user) {
        return user.getPassword().trim().length() > 2 && user.getPassword().trim().length() < 10;
    }

    private boolean isUsernameLengthCorrect(UserDTO user) {
        return user.getUsername().trim().length() > 2 && user.getUsername().trim().length() < 10;
    }


}

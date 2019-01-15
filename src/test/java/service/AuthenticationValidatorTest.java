package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.userdetails.UserDetails;

import static org.mockito.Mockito.when;

/**
 * Created by kfrak on 14.01.2019.
 */
public class AuthenticationValidatorTest {

    @InjectMocks
    AuthenticationValidator authenticationValidator;

    @Mock
    UserDetails userDetails;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkIfUserSuccessLogedIn_happyPath() throws Exception {
        String password = "123";
        when(userDetails.getPassword()).thenReturn("123");

        boolean result = userDetails.getPassword().equals(password);
        Assert.assertTrue(result);
    }

    @Test
    public void checkIfUserSuccessLogedIn_unhappyPath() throws Exception {
        String password = "456";
        when(userDetails.getPassword()).thenReturn("123");

        boolean result = userDetails.getPassword().equals(password);
        Assert.assertFalse(result);
    }

}
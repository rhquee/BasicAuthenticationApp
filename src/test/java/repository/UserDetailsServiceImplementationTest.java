package repository;

import configuration.SpringRootConfig;
import configuration.SpringWebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class UserDetailsServiceImplementationTest {

    private MockMvc mockMvc;

    @InjectMocks
    UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Autowired
    UserDetailsService userDetailsService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadUserByUsername_CorrectData() throws Exception {
        User user = new User("Joe", "123");
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        UserDetails found = userDetailsServiceImplementation.loadUserByUsername("Joe");
        Assert.assertTrue(found != null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_NotCorrectData() throws Exception {
//        User user = new User("Joe", "123");
//        when(userRepository.findByUsername(anyString())).thenReturn(user);
        userDetailsServiceImplementation.loadUserByUsername("NotExistUser");
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_EmptyString() throws Exception {
//        User user = new User("Joe", "123");
//        when(userRepository.findByUsername(anyString())).thenReturn(user);
        userDetailsServiceImplementation.loadUserByUsername("");
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_Null() throws Exception {
        User user = new User("Joe", "123");
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        userDetailsServiceImplementation.loadUserByUsername(null);
    }
}
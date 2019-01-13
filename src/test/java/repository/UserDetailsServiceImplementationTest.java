//package repository;
//
//import configuration.SpringRootConfig;
//import configuration.SpringWebConfig;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.userdetails.UserDetails;
//import org.springframework.security.userdetails.UsernameNotFoundException;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.times;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
//public class UserDetailsServiceImplementationTest {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Mock
//    User user;
//
//    @Spy
//    UserDetailsServiceImplementation userDetailsServiceImplementation;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @Test
//    public void loadUserByUsernameAndPassword_CorrectData() throws Exception {
//        userDetailsServiceImplementation.loadUserByUsernameAndPassword("Joe", "123");
//        Mockito.verify(userDetailsServiceImplementation, times(1)).loadUserByUsername(anyString());
//    }
//
//    @Test(expected = UsernameNotFoundException.class)
//    public void loadUserByUsernameAndPassword_NotCorrectData() throws Exception {
//        userDetailsServiceImplementation.loadUserByUsernameAndPassword("Paul", "123456");
//        Mockito.verify(userDetailsServiceImplementation, times(0)).loadUserByUsername(anyString());
//    }
//
//    @Test(expected = UsernameNotFoundException.class)
//    public void loadUserByUsernameAndPassword_EmptyStrings() throws Exception {
//        userDetailsServiceImplementation.loadUserByUsernameAndPassword("", "");
//        Mockito.verify(userDetailsServiceImplementation, times(0)).loadUserByUsername(anyString());
//    }
//
//    @Test(expected = UsernameNotFoundException.class)
//    public void loadUserByUsernameAndPassword_Null() throws Exception {
//        userDetailsServiceImplementation.loadUserByUsernameAndPassword(null, null);
//        Mockito.verify(userDetailsServiceImplementation, times(0)).loadUserByUsername(anyString());
//    }
//
//    @Test
//    public void loadUserByUsername() throws Exception {
//        UserDetails loadedByUsername = userDetailsServiceImplementation.loadUserByUsername("Joe");
//        Assert.assertEquals(loadedByUsername.getUsername(), "Joe");
//    }
//
//    //NotCorrectUsername Case
//    //EmptyString Case
//    //NullUsername Case
//
//}
package controller;

import configuration.SpringRootConfig;
import configuration.SpringWebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import service.AuthenticationValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class LoginControllerTest {

    @InjectMocks
    LoginController loginController;

    private MockHttpSession mockHttpSession = new MockHttpSession();
    private MockMvc mockMvc;


    @Mock
    AuthenticationValidator authenticationValidator;


    @Mock
    UserDetailsService userDetailsService;

//    @Mock
//    UserDetails userDetails;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void login_getMethod() throws Exception {
        mockMvc
                .perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }


    @Test
    public void login_postMethod_userLoadByUsernameAndPasswordWithSuccess() throws Exception {
        when(authenticationValidator.checkIfUserSuccessLogedIn(any(), anyString())).thenReturn(true);
        MockHttpServletRequestBuilder request = post("/login")
                .session(mockHttpSession)
                .param("username", "Joe")
                .param("password", "123");
        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("username"))
                .andExpect(request().sessionAttribute("user", "Joe"));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void login_postMethod_userNameOrPasswordRejected() throws Exception {
        when(authenticationValidator.checkIfUserSuccessLogedIn(any(), anyString())).thenReturn(false);

        MockHttpServletRequestBuilder request =
                post("/login")
//                        .session(mockHttpSession)
                        .param("username", "joe")
                        .param("password", "123");

        mockMvc
                .perform(request)
                .andExpect(view().name("login"));
    }
}
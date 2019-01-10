package controller;

import configuration.SpringRootConfig;
import configuration.SpringWebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import repository.User;
import repository.UserDetailsServiceImplementation;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class LoginControllerTest {

    private MockMvc mockMvc;
    private MockHttpSession mockHttpSession;


    @Mock
    User mockedUser;

    @InjectMocks
    UserDetailsServiceImplementation mockedUserDetailsServiceImplementation;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockServletContext context = new MockServletContext();
        mockHttpSession = new MockHttpSession(context);
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
    public void login_postMethod_userLoadedByUsernameAndPassword() throws Exception {
        Mockito.doNothing().when(mockHttpSession).setAttribute("user", mockedUser);
        mockMvc
                .perform(post("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("username", mockedUser));
        verify(mockHttpSession, times(1)).setAttribute("user", mockedUser);
    }

    @Test
    public void login_postMethod_userNameOrPasswordRejected() throws Exception {
        mockMvc
                .perform(post("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

}
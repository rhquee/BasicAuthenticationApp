package controller;

import configuration.SpringRootConfig;
import configuration.SpringWebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import repository.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class IndexControllerTest {

    private MockMvc mockMvc;

    @Mock
    User mockedUser;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showIndex_getMethod() throws Exception {
        Mockito.when(mockedUser.getUsername()).thenReturn("Joe");
        Mockito.when(mockedUser.getPassword()).thenReturn("123");

        mockMvc
                .perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("username", mockedUser.getUsername()))
                .andExpect(model().attribute("password", mockedUser.getPassword()))
                .andExpect(model().attributeExists("loginForm"));
    }
}
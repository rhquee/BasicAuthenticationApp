package service.redirectStrategy;

import configuration.SpringRootConfig;
import configuration.SpringWebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class ToIndexRedirectStrategyTest {

    @InjectMocks
    private ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();

    private MockMvc mockMvc;
    private MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void supports_slashURIAddress() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
        mockHttpServletRequest.setRequestURI("/");
        Assert.assertTrue(toIndexRedirectStrategy.supports(mockHttpServletRequest));
    }

    @Test
    public void supports_indexURIAddress() throws Exception {
        mockHttpServletRequest.setRequestURI("/index");
        Assert.assertTrue(toIndexRedirectStrategy.supports(mockHttpServletRequest));
    }

    @Test
    public void execute() throws Exception {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/index");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.forwardedUrl(
                        "/WEB-INF/view/index.jsp"));

    }
}
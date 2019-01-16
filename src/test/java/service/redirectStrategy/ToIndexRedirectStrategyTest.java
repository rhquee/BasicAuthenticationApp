package service.redirectStrategy;

import configuration.SpringRootConfig;
import configuration.SpringWebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class ToIndexRedirectStrategyTest {

    @Autowired
    private ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private RequestDispatcher requestDispatcher;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        httpServletRequest = Mockito.mock(HttpServletRequest.class);
        httpServletResponse = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc = MockMvcBuilders.standaloneSetup(toIndexRedirectStrategy).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void supports_slashURIAddress() throws Exception {
        when(httpServletRequest.getRequestURI()).thenReturn("/");
        Assert.assertTrue(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_indexURIAddress() throws Exception {
        when(httpServletRequest.getRequestURI()).thenReturn("/index");
        Assert.assertTrue(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void execute() throws Exception {
        when(httpServletRequest.getRequestDispatcher("/WEB-INF/view/index.jsp")).thenReturn(requestDispatcher);

        toIndexRedirectStrategy.execute(httpServletRequest, httpServletResponse);

        verify(httpServletRequest, times(1)).getRequestDispatcher("/gfds");
        verify(requestDispatcher, times(1)).forward(httpServletRequest, httpServletResponse);

    }
}
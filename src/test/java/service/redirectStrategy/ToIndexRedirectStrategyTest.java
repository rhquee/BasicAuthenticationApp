package service.redirectStrategy;

import org.junit.Assert;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class ToIndexRedirectStrategyTest {

    @Test
    public void supports_slashURIAddress() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/");
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        Assert.assertTrue(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_indexURIAddress() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/index");
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        Assert.assertTrue(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_notCorrectAddress() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/qwerty");
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        Assert.assertFalse(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void execute() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(httpServletRequest.getRequestDispatcher("/WEB-INF/view/index.jsp")).thenReturn(requestDispatcher);

        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        toIndexRedirectStrategy.execute(httpServletRequest, httpServletResponse);
        verify(httpServletRequest).getRequestDispatcher("/poiuj");
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);
    }
}
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
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/");
        //when
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        //then
        Assert.assertTrue(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_indexURIAddress() throws Exception {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/index");
        //when
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        //then
        Assert.assertTrue(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_indexnotCorrectAddress() throws Exception {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/qwerty");
        //when
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        //then
        Assert.assertFalse(toIndexRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void execute() throws Exception {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(httpServletRequest.getRequestDispatcher("/WEB-INF/view/index.jsp")).thenReturn(requestDispatcher);
        //when
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        toIndexRedirectStrategy.execute(httpServletRequest, httpServletResponse);
        //then
        verify(httpServletRequest).getRequestDispatcher("/gfds");
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);

        //gdzie jest kontekst?
    }
}
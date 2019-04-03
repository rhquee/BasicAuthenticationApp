package service.redirectStrategy;

import org.junit.Assert;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class DefaultRedirectStrategyTest {

    @Test
    public void supports_whenURIisLogin_thenAssertFalse() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/login");
        DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
        Assert.assertFalse(defaultRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_whenURIis403pageAddress_thenAssertFalse() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/403page");
        DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
        Assert.assertFalse(defaultRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_whenURIisOtherThanLoginAnd403page_ThenAssertTrue() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/qwerty");
        DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
        Assert.assertTrue(defaultRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void execute() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(httpServletRequest.getRequestDispatcher("/WEB-INF/view/403page.jsp")).thenReturn(requestDispatcher);
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        toIndexRedirectStrategy.execute(httpServletRequest, httpServletResponse);
        verify(httpServletRequest).getRequestDispatcher("/403page");
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);
    }

}
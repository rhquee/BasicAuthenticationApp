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
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/login");
        //when
        DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
        //then
        Assert.assertFalse(defaultRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_whenURIis403pageAddress_thenAssertFalse() throws Exception {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/403page");
        //when
        DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
        //then
        Assert.assertFalse(defaultRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void supports_whenURIisOtherThanLoginAnd403page_ThenAssertTrue() throws Exception {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/qwerty");
        //when
        DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
        //then
        Assert.assertTrue(defaultRedirectStrategy.supports(httpServletRequest));
    }

    @Test
    public void execute() throws Exception {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(httpServletRequest.getRequestDispatcher("/WEB-INF/view/403page.jsp")).thenReturn(requestDispatcher);
        //when
        ToIndexRedirectStrategy toIndexRedirectStrategy = new ToIndexRedirectStrategy();
        toIndexRedirectStrategy.execute(httpServletRequest, httpServletResponse);
        //then
        verify(httpServletRequest).getRequestDispatcher("/403page");
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);
    }

}
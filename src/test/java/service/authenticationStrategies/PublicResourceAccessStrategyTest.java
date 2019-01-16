package service.authenticationStrategies;

import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PublicResourceAccessStrategyTest {
    @Test
    public void canAccessResource_whenUriIsLogin_thenAssertTrue() throws Exception {
//        List<String> allowedURIs = Arrays.asList("/resource/", "/login");
//        boolean answerForCorrectAddress = allowedURIs.stream().anyMatch(s -> s.equals("/login") || s.equals("/resources"));
//        boolean answerForUncorectAddress = allowedURIs.stream().anyMatch(s -> s.equals("/qwert"));
//        Assert.assertFalse(answerForUncorectAddress);

        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/login");
        PublicResourceAccessStrategy publicResourceAccessStrategy = new PublicResourceAccessStrategy();
        Assert.assertTrue(publicResourceAccessStrategy.canAccessResource(httpServletRequest));
    }

    @Test
    public void canAccessResource_whenUriIsResources_thenAssertTrue() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/resource/qwer");
        PublicResourceAccessStrategy publicResourceAccessStrategy = new PublicResourceAccessStrategy();
        Assert.assertTrue(publicResourceAccessStrategy.canAccessResource(httpServletRequest));
    }

    @Test
    public void canAccessResource_whenUriIsNotLoginAndNotResources_thenAssertFalse() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRequestURI()).thenReturn("/qwer");
        PublicResourceAccessStrategy publicResourceAccessStrategy = new PublicResourceAccessStrategy();
        Assert.assertFalse(publicResourceAccessStrategy.canAccessResource(httpServletRequest));
    }
}
//package service.redirectStrategy;
//
//import configuration.SpringRootConfig;
//import configuration.SpringWebConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.servlet.http.HttpServletRequest;
//
//import static org.junit.Assert.assertFalse;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
//public class DefaultRedirectStrategyTest {
//
//    @Mock
//    HttpServletRequest httpServletRequest;
//
//    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//
//    //
////    !httpServletRequest.getRequestURI().equals("/login")
////                && !httpServletRequest.getRequestURI().equals("/403page");
//    @Test
//    public void supports() throws Exception {
//        String loginURL = "/login";
//        String errorURL = "/403page";
//
//        when(httpServletRequest.getRequestURI()).thenReturn(loginURL);
////        when(httpServletRequest.getRequestURI()).thenReturn("/403page");
//
//        assertFalse(redirectStrategy.supports(httpServletRequest.getRequestURI().equals(loginURL)))
//    }
//
//    @Test
//    public void execute() throws Exception {
//
//    }
//
//}
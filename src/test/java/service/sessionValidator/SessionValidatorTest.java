package service.sessionValidator;

import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionValidatorTest {

    @Test
    public void isSessionActive_NotNullSessionCorrectUser() throws Exception {
        HttpSession mockHttpSession = mock(HttpSession.class);
        when(mockHttpSession.getAttribute("user")).thenReturn("Joe");
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);
        Assert.assertTrue(sessionValidator.isSessionActive(mockHttpSession));
    }

    @Test
    public void isSessionActive_NotNullSessionEmptyUser() throws Exception {
        HttpSession mockHttpSession = mock(HttpSession.class);
        when(mockHttpSession.getAttribute("user")).thenReturn("");
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);
        Assert.assertFalse(sessionValidator.isSessionActive(mockHttpSession));
    }

    @Test
    public void isSessionActive_NotNullSessionNullUser() throws Exception {
        HttpSession mockHttpSession = mock(HttpSession.class);
        when(mockHttpSession.getAttribute("user")).thenReturn(null);
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);
        Assert.assertFalse(sessionValidator.isSessionActive(mockHttpSession));
    }

    @Test
    public void isSessionActive_NullSession() throws Exception {
        HttpSession mockHttpSession = null;
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);
        Assert.assertFalse(sessionValidator.isSessionActive(mockHttpSession));
    }
}
package service.sessionValidator;

import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SessionValidatorTest {

    @Test
    public void isSessionActive_NotNullSessionCorrectUser() throws Exception {
        //given
        HttpSession mockHttpSession = mock(HttpSession.class);
        when(mockHttpSession.getAttribute("user")).thenReturn("Joe");

        //when
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);

        //then
        Assert.assertTrue(sessionValidator.isSessionActive(mockHttpSession));
    }

    @Test
    public void isSessionActive_NotNullSessionEmptyUser() throws Exception {
        //given
        HttpSession mockHttpSession = mock(HttpSession.class);

        when(mockHttpSession.getAttribute("user")).thenReturn("");

        //when
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);

        //then
        Assert.assertFalse(sessionValidator.isSessionActive(mockHttpSession));
    }

    @Test
    public void isSessionActive_NotNullSessionNullUser() throws Exception {
        //given
        HttpSession mockHttpSession = mock(HttpSession.class);

        when(mockHttpSession.getAttribute("user")).thenReturn(null);

        //when
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);

        //then
        Assert.assertFalse(sessionValidator.isSessionActive(mockHttpSession));
    }

    @Test
    public void isSessionActive_NullSession() throws Exception {
        //given
        HttpSession mockHttpSession = null;

        //when
        SessionValidator sessionValidator = new SessionValidator();
        sessionValidator.isSessionActive(mockHttpSession);

        //then
        Assert.assertFalse(sessionValidator.isSessionActive(mockHttpSession));
    }
}
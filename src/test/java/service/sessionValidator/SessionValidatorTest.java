package service.sessionValidator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 14.01.2019.
 */
public class SessionValidatorTest {

    @Autowired //@InjectMock?
            SessionValidator sessionValidator;

    @Autowired //Mock?
            HttpSession httpSession;


    @Test
    public void isSessionActive() throws Exception {

        //jak to przetestować żeby nie testować mocków?

        Assert.assertTrue(httpSession != null);
    }

}
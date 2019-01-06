package service.sessionValidator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 06.01.2019.
 */
@Service
public class SessionValidator {

    public boolean isSessionActive(HttpSession httpSession) {
        return httpSession == null || httpSession.getAttribute("user") == null;
    }
}

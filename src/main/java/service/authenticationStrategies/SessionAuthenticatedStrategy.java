package service.authenticationStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.sessionValidator.SessionValidator;

import javax.servlet.http.HttpServletRequest;

@Component
public class SessionAuthenticatedStrategy implements ResourceAccessStrategy {

    @Autowired
    private SessionValidator sessionValidator;

    @Override
    public boolean canAccessResource(HttpServletRequest request) {
        return sessionValidator.isSessionActive(request.getSession());
    }
}

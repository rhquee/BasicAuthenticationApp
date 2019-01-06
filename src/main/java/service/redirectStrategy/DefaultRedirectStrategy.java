package service.redirectStrategy;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import service.sessionValidator.SessionValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
@Service
public class DefaultRedirectStrategy implements RedirectStrategy {

    public boolean supports(HttpServletRequest httpServletRequest) {
        return !httpServletRequest.getRequestURL().equals("/") && !httpServletRequest.getRequestURL().equals("/index") && !httpServletRequest.getRequestURL().equals("/403page");
    }

    public void execute(SessionValidator sessionValidator, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
      httpServletResponse.sendRedirect(String.valueOf(httpServletRequest.getRequestURL()));
    }
}

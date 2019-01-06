package service.redirectStrategy;

import org.springframework.web.servlet.ModelAndView;
import service.sessionValidator.SessionValidator;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
public interface RedirectStrategy {
    boolean supports(HttpServletRequest httpServletRequest);

    void execute(SessionValidator sessionValidator, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException;
}

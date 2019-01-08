package service.redirectStrategy;

import service.sessionValidator.SessionValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
public interface RedirectStrategy {

     void execute(HttpServletRequest httpServletRequest,
                  HttpServletResponse httpServletResponse) throws IOException;

     boolean supports(HttpServletRequest httpServletRequest);
}

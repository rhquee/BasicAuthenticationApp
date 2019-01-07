package service.redirectStrategy;

import org.springframework.stereotype.Component;
import service.sessionValidator.SessionValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
public interface RedirectStrategy {


     boolean execute(SessionValidator sessionValidator,
                                  HttpServletRequest httpServletRequest,
                                  HttpServletResponse httpServletResponse) throws IOException;
//        if (supports(httpServletRequest)) {
//            return doExecute(sessionValidator, httpServletRequest, httpServletResponse);
//        }
//        return false;

    boolean doExecute(SessionValidator sessionValidator, HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse) throws IOException;

     boolean supports(HttpServletRequest httpServletRequest);

//    boolean execute (SessionValidator sessionValidator, HttpServletRequest httpServletRequest,
//                    HttpServletResponse httpServletResponse) throws IOException;
}

package service.redirectStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.sessionValidator.SessionValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
@Service
public class ToIndexRedirectStrategy implements RedirectStrategy {

    //czy idę do index?
    public boolean supports(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestURL().equals("/") || httpServletRequest.getRequestURL().equals("/index");
    }


    public void execute(SessionValidator sessionValidator, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        HttpSession httpSession = httpServletRequest.getSession();

        //czy jestem w aktywnej sesji?
        if (sessionValidator.isSessionActive(httpSession)){
            httpServletResponse.sendRedirect("userInfo");
        }
        httpServletResponse.sendRedirect("index");
    }
}

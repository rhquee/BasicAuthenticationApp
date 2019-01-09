package service.redirectStrategy;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ToIndexRedirectStrategy implements RedirectStrategy {

    @Override
    public boolean supports(HttpServletRequest httpServletRequest) {
        return (httpServletRequest.getRequestURI().equals("/")
                || httpServletRequest.getRequestURI().equals("/index"));
//                && httpServletRequest.getMethod().equals("GET");
    }

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {


        String redirectURL = "/WEB-INF/view/login.jsp";
        try {
            httpServletRequest.getRequestDispatcher(redirectURL).forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        }

//        String redirectURL = "/WEB-INF/view/login.jsp";
//        RequestDispatcher view = httpServletRequest.getRequestDispatcher(redirectURL);
//        try {
//            view.forward(httpServletRequest, httpServletResponse);
//        httpServletResponse.sendRedirect("login");
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
    }
}

package service.redirectStrategy;

import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kfrak on 06.01.2019.
 */
@Service
public class DefaultRedirectStrategy implements RedirectStrategy {

    @Override
    public boolean supports(HttpServletRequest httpServletRequest) {
        return !httpServletRequest.getRequestURI().equals("/login")
                && !httpServletRequest.getRequestURI().equals("/403page");
    }

    @Override
    public void execute(HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setStatus(403);
//        httpServletResponse.sendError(403);
//        httpServletResponse.sendRedirect("403page");
//
        String redirectURL = "/WEB-INF/view/403page.jsp";
        try {
            httpServletRequest.getRequestDispatcher(redirectURL).forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        }
//        try {
//        try {
//            view.forward(httpServletRequest, httpServletResponse);
//            httpServletResponse.setStatus(403);
////            httpServletResponse.sendError(403);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//            httpServletResponse.sendRedirect("403page");
//            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
//            httpServletResponse.setStatus(403);
//
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
    }
}

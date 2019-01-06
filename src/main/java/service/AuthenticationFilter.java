package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.redirectStrategy.RedirectStrategy;
import service.sessionValidator.SessionValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    @Autowired
    private List<RedirectStrategy> strategies;
    @Autowired
    SessionValidator sessionValidator;

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        /*with 'true' it creates a session if it does not exist,
        with 'false' it returns active session if exists otherwise null
         */
        HttpSession httpSession = httpServletRequest.getSession(false);

        RedirectStrategy redirectStrategy = strategies.stream().filter(s -> s.supports(httpServletRequest)).findAny().get();
        try {
            redirectStrategy.execute(sessionValidator, httpServletRequest, httpServletResponse);
            //filterChain.doFilter();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void destroy() {
    }
}

package pl.kfrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pl.kfrak.service.redirectStrategy.RedirectStrategy;
import pl.kfrak.service.sessionValidator.SessionValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Autowired
    SessionValidator sessionValidator;

    @Autowired
    private List<RedirectStrategy> strategies;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession(false);

        if (sessionValidator.isSessionActive(httpSession)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        Optional<RedirectStrategy> strategy = strategies.stream().filter(redirectStrategy -> redirectStrategy.supports(httpServletRequest)).findFirst();
        if (strategy.isPresent()) {
            strategy.get().execute(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {
        //empty
    }
}

package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.redirectStrategy.RedirectStrategy;
import service.sessionValidator.SessionValidator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    @Autowired
    SessionValidator sessionValidator;

    @Autowired
    private List<RedirectStrategy> strategies;

    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        for (RedirectStrategy strategy : strategies) {
            boolean processed = strategy.execute(sessionValidator, httpServletRequest, httpServletResponse);
            System.out.println("exetuted done");
            if (processed) { //the redirect strategy has processed the request, no further action necessary
                return;
            }
    }
        // if no redirect strategy stopped, it's authorised to proceed
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}

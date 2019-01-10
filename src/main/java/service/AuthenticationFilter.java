package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.authenticationStrategies.ResourceAccessStrategy;
import service.redirectStrategy.RedirectStrategy;
import service.sessionValidator.SessionValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private List<ResourceAccessStrategy> accessStrategies;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        boolean matchesAnyAllowedURL = accessStrategies.stream().anyMatch(accessStrategy -> accessStrategy.canAccessResource(httpServletRequest));
        if (matchesAnyAllowedURL) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Optional<RedirectStrategy> strategy = strategies.stream().filter(redirectStrategy -> redirectStrategy.supports(httpServletRequest)).findFirst();
        if (strategy.isPresent()) {
            strategy.get().execute(httpServletRequest, httpServletResponse);
            return;
        }

        throw new IllegalAccessError();
    }

    @Override
    public void destroy() {
    }
}

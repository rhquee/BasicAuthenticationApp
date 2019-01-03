package service;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kfrak on 15.12.2018.
 */
@Component
@WebFilter (urlPatterns = {"/login/*"})
public class AuthenticationFilter implements Filter {
    // Filtr sprawdza, czy user jest w sesji.
    // Jeśli jest, to kontynuuje chain,
    //a jeśli nie ma go w sesji, to przekierowuje na stronę logowania (index).

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession(false);

        if (httpSession == null || httpSession.getAttribute("user") == null) {
            httpServletResponse.sendRedirect("/403page"); //nie ma zalogowanego usera, więc przekieruj
        } else {
            filterChain.doFilter(servletRequest, servletResponse); // jest, więc kontunuuj chain.
        }
    }

    public void destroy() {}
}

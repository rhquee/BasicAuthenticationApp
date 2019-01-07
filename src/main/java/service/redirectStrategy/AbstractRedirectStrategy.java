//package service.redirectStrategy;
//
//import service.sessionValidator.SessionValidator;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public abstract class AbstractRedirectStrategy implements RedirectStrategy {
//
//    @Override
//    public boolean execute(SessionValidator sessionValidator,
//                           HttpServletRequest httpServletRequest,
//                           HttpServletResponse httpServletResponse) throws IOException {
//        if (supports(httpServletRequest)) {
//            return doExecute(sessionValidator, httpServletRequest, httpServletResponse);
//        }
//        return false;
//    }
//
//    abstract protected boolean doExecute(SessionValidator sessionValidator, HttpServletRequest httpServletRequest,
//                                         HttpServletResponse httpServletResponse) throws IOException;
//
//    abstract protected boolean supports(HttpServletRequest httpServletRequest);
//}

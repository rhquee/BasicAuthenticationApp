package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return new ModelAndView("/login/logout");
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout2(HttpServletRequest httpServletRequest) {
//        httpServletRequest.getSession().invalidate();
        return new ModelAndView("/login/logout");
    }

}

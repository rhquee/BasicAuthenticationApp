package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView showLogoutPage() {
        return new ModelAndView("logout");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView showLogoutPageWithPostMethod(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return new ModelAndView("logout");
    }



}

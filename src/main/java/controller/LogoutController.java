package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @PostMapping(value = "/logout")
    public ModelAndView showLogoutPageWithPostMethod(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return new ModelAndView("index");
    }


}

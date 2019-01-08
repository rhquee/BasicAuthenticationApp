package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @GetMapping(value = "/logout")
    public ModelAndView showLogoutPage() {
        return new ModelAndView("logout");
    }

    @PostMapping(value = "/logout")
    public ModelAndView showLogoutPageWithPostMethod(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return new ModelAndView("logout");
    }


}

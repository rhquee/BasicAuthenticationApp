package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 15.12.2018.
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private User user;

    @ModelAttribute("user")
    public User setUpUserForm() {
        return user;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam String username,
            @RequestParam String password,
            @ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            modelAndView.setViewName("/login/success");
            return modelAndView;
        } else {
            modelAndView.setViewName("/login/fail");
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/login/success"}, method = RequestMethod.GET)
    public ModelAndView successLogged(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", httpSession.getAttribute("user"));
        modelAndView.setViewName("/login/success");
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        httpServletRequest.getSession().invalidate();
        modelAndView.setViewName("/login/logout");
        return modelAndView;
    }


}
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
@SessionAttributes("username")
public class LoginController {

    @Autowired
    private User user;

    @ModelAttribute("username")
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
            @ModelAttribute("username") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            modelAndView.setViewName("success");
            return modelAndView;
        } else {
            modelAndView.setViewName("fail");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        /*jeśeli user jest już zalogowany (sesja), to wyślij go na stronę success,
        a jeśli jest niezalogowany lub sesja wygasła to wyślij go na stronę index (logowania)
         */
        return null;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        httpServletRequest.getSession().invalidate();
        modelAndView.setViewName("logout");
        return modelAndView;
    }


}
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 15.12.2018.
 */
@Controller
public class LoginController {

    @Autowired
    private User user;


    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if (httpSession == null || httpSession.getAttribute("user") == null){
            modelAndView.setViewName("index");
            return modelAndView;
        } else{
            modelAndView.addObject("username", user.getUsername());
            modelAndView.setViewName("/login/success");
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            httpSession.setAttribute("user", user);
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
        modelAndView.addObject("username", /*httpSession.getAttribute("user").toString()*/ user.getUsername());
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

    @RequestMapping(value = {"403page"}, method = RequestMethod.GET)
    public ModelAndView page403() {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("username", /*httpSession.getAttribute("user").toString()*/ user.getUsername());
        modelAndView.setViewName("403page");
        return modelAndView;
    }


}
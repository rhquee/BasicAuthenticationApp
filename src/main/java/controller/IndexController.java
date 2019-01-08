package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.User;
import repository.UserDTO;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class IndexController {

    @Autowired
    User user;

    @RequestMapping(value = {"/", "/index", "/login"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new UserDTO());
        }

        modelAndView.addObject("username");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.UserDTO;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new UserDTO());
        }
        model.addAttribute("username");
//        modelAndView.addObject("username");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
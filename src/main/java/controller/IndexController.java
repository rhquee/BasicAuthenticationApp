package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.User;
import repository.UserDTO;
import repository.UserLoginValidator;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class IndexController {

    @Autowired
    private User user;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpSession httpSession,
                              Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("loginForm", new UserDTO()); //?
//        if (httpSession == null || httpSession.getAttribute("user") == null) {
//            modelAndView.setViewName("index");
//            return modelAndView;
//        } else {
//            modelAndView.setViewName("/login/userpage");
//            modelAndView.addObject("username", user.getUsername());
        modelAndView.setViewName("index");
            return modelAndView;
//        }
    }
}

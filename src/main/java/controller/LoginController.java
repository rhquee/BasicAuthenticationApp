package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.UserDTO;
import service.AuthenticationValidator;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private AuthenticationValidator authenticationValidator;

    @Autowired
    UserDetailsService userDetailsService;


    @GetMapping(value = {"/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(value = {"/login"})
    public ModelAndView login(UserDTO loginForm, HttpSession httpSession, Model model) {
        ModelAndView modelAndView = new ModelAndView();

        if (authenticationValidator.checkIfUserSuccessLogedIn(userDetailsService.loadUserByUsername(loginForm.getUsername()), loginForm.getPassword())) {
            httpSession.setAttribute("user", loginForm.getUsername());
            model.addAttribute("username", loginForm.getUsername());
            modelAndView.setViewName("index");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
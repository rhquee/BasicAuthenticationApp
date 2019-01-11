package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String login() {
        return "login";
    }

    @PostMapping(value = {"/login"})
    public String login(UserDTO loginForm, HttpSession httpSession, Model model) {
        if (authenticationValidator.checkIfUserSuccessLogedIn(userDetailsService.loadUserByUsername(loginForm.getUsername()), loginForm.getPassword())) {
            httpSession.setAttribute("user", loginForm.getUsername());
            model.addAttribute("username", loginForm.getUsername());
            return "index";
        }
        return "login";
    }
}
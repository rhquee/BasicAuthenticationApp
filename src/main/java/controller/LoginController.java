package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import repository.User;
import repository.UserDTO;
import repository.UserLoginValidator;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 15.12.2018.
 */


@SessionAttributes({"loginForm"})
@Controller
public class LoginController {

    @Autowired
    private User user;

    @Autowired
    private UserLoginValidator userLoginValidator;

    @PostMapping(value = {"/", "/index"})
    public ModelAndView doLogin(HttpSession httpSession,
                                @ModelAttribute("loginForm") UserDTO loginForm,
                                Model model,
                                BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        userLoginValidator.validate(loginForm, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        }
        if (isLoginAndPasswordCorrect(loginForm)) {
            httpSession.setAttribute("user", user);
            model.addAttribute("username", user.getUsername());
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    private boolean isLoginAndPasswordCorrect(UserDTO loginForm) {
        return user.getUsername().equalsIgnoreCase(loginForm.getUsername())
                && user.getPassword().equalsIgnoreCase(loginForm.getPassword());
    }
}
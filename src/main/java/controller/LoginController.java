package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.User;
import repository.UserDTO;
import repository.UserDetailsServiceImplementation;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private User user;

    @Autowired
    private UserDetailsServiceImplementation userLoginValidator;

//    @Autowired
//    private LoginDataFormatValidator loginDataFormatValidator;

    @GetMapping(value = {"/login"})
    public ModelAndView login(@ModelAttribute("loginForm") UserDTO loginForm,
                              HttpSession httpSession,
                              Model model,
                              BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    

    @PostMapping(value = {"/login"})
    public ModelAndView doLogin(@ModelAttribute("loginForm") UserDTO loginForm,
                                HttpSession httpSession,
                                Model model,
                                BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

//        loginValidator.validate(loginForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("login");
//            //oraz dodaj błędy na widok
//        } else {

        if (userLoginValidator.loadUserByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword())) {

            httpSession.setAttribute("user", user);
            model.addAttribute("username", user);
            modelAndView.setViewName("index");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.User;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 15.12.2018.
 */
@Controller
public class LoginController {

    @Autowired
    private User user;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam String username,
            @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
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
    public ModelAndView logout(/*HttpSession httpSession*/) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
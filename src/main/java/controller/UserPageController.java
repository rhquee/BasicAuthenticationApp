package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.User;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class UserPageController {

    @Autowired
    User user;

    @RequestMapping(value = {"/userinfo"}, method = RequestMethod.GET)
    public ModelAndView showUserInfoPage(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", /*httpSession.getAttribute("user").toString()*/ user.getUsername());
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }
}

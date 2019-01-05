package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class Error403Controller {

    @RequestMapping(value = {"403page"}, method = RequestMethod.GET)
    public ModelAndView page403() {
        return new ModelAndView("403page");
    }

}

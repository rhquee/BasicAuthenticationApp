package pl.kfrak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class Error403Controller {

    @GetMapping(value = {"/403page"})
    public ModelAndView showPage403() {
        return new ModelAndView("403page");
    }
}

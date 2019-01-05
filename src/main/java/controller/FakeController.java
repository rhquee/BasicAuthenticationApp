package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class FakeController {

    @RequestMapping(value = {"fake"}, method = RequestMethod.GET)
    public ModelAndView fakePage() {
        return new ModelAndView("/login/fake");
    }



}

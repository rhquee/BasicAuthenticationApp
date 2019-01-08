package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class FakeController {

    @GetMapping(value = {"/fake"})
    public ModelAndView showFakePage() {
        return new ModelAndView("fake");
    }


}

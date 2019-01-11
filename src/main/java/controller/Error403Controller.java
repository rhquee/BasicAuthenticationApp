package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class Error403Controller {

    @GetMapping(value = {"/403page"})
    public String showPage403() {
        return "403page";
    }

}

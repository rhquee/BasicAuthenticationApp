package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model, HttpSession httpSession) {
        model.addAttribute("username", httpSession.getAttribute("user"));
        return "index";
    }
}
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kfrak on 05.01.2019.
 */
@Controller
public class FakeController {

    @GetMapping(value = {"/fake"})
    public String showFakePage() {
        return "fake";
    }


}

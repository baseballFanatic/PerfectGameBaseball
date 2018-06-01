package Baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetupController {
    @RequestMapping("/setup")
    public String setup(Model model) { return "setupPage.html"; }
}
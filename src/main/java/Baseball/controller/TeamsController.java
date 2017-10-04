package Baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamsController
{
    @RequestMapping( "/teams" )
    public String teams( Model model ) { return "teams"; }
}

package Baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatsController
{
    @RequestMapping( "/stats" )
    public String stats( Model model ) { return "statsPage.html"; }
}

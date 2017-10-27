package Baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimulationController
{
    @RequestMapping( "/simulate" )
    public String simulate( Model model ) { return "simulatePage.html"; }
}

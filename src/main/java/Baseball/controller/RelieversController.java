package Baseball.controller;

import Baseball.Reliever;
import Baseball.repositories.RelieverDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RelieversController {
    @Autowired
    private RelieverDao relieverService;

    @RequestMapping("/relievers")
    public String relievers(Model model) throws ClassNotFoundException {
        List<Reliever> relievers = relieverService.getAllRelievers();
        model.addAttribute("relievers", relievers);

        return "relievers";
    }

    @RequestMapping("/relievers/{playerId}")
    public String view(@PathVariable("playerId") String playerId, Model model) throws ClassNotFoundException {
        List<Reliever> relievers = relieverService.getReliever(playerId);
        model.addAttribute("reliever", relievers);
        return "reliever";
    }
}

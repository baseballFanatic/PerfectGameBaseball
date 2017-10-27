package Baseball.controller;

import Baseball.Reliever;
import Baseball.repositories.RelieverDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RelieversController {
    @Autowired
    private RelieverDao relieverDao;

    @RequestMapping(value = "/relievers", method = RequestMethod.GET)
    public String relievers() {
        return "relieversPage.html";
    }
    @RequestMapping("/relievers/{playerId}")
    public String view(@PathVariable("playerId") String playerId, Model model) throws ClassNotFoundException {
        List<Reliever> relievers = relieverDao.getReliever(playerId);
        model.addAttribute("relievers", relievers);
        return "reliever";
    }
}

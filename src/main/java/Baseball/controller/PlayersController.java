package Baseball.controller;

import Baseball.Player;
import Baseball.repositories.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PlayersController {
    @Autowired
    private PlayerDao playerDao;

    @RequestMapping("/players")
    public String players(Model model) throws ClassNotFoundException {
        return "playersPage.html";
    }

    @RequestMapping("/players/{playerId}")
    public String view(@PathVariable("playerId") String playerId, Model model) throws ClassNotFoundException {
        List<Player> players = playerDao.getPlayer(playerId);
        model.addAttribute("players", players);
        return "players";
    }
}

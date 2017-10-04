package Baseball.controller;

import Baseball.Player;
import Baseball.Reliever;
import Baseball.repositories.PlayerDao;
import Baseball.repositories.RelieverDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PlayersController {
    @Autowired
    private PlayerDao playerService;

    @RequestMapping("/players")
    public String players(Model model) throws ClassNotFoundException {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players);

        return "players";
    }

    @RequestMapping("/players/{playerId}")
    public String view(@PathVariable("playerId") String playerId, Model model) throws ClassNotFoundException {
        List<Player> players = playerService.getPlayer(playerId);
        model.addAttribute("players", players);
        return "players";
    }
}

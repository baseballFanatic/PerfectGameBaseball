/*package Baseball.controller;

import Baseball.Player;
import Baseball.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("/players")
    public String players(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);

        return "players";
    }

    @RequestMapping("/players/{playerId}")
    public String view(@PathVariable("playerId") String playerId, Model model) {
        Player player = playerService.findByPlayerId(playerId);
        model.addAttribute("player", player);
        return "player";
    }
}*/

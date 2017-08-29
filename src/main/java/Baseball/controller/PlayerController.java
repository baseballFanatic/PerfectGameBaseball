package Baseball.controller;

import Baseball.Player;
import Baseball.data.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;


    @RequestMapping("/")
    public String listPlayers(ModelMap modelMap) {
        List<Player> allPlayers = playerRepository.getAllPlayers() ;
        modelMap.put("players", allPlayers);
        return "players";
    }
}

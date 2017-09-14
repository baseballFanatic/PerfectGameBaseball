/*package Baseball.controller;

import Baseball.Player;
import Baseball.repositories.PlayerRepository;
import Baseball.repositories.RelieverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
class PerfectGameController {
    @Autowired
    private RelieverRepository relieverRepository;

*//*    @RequestMapping("/")
    public String perfectGameWebLaunch() {
        return "index";
    }*//*

    @RequestMapping("/simulate")
    public String perfectGameSimulate() {
        return "simulate";
    }
*//*    public String perfectGameSimulate() throws ClassNotFoundException, SQLException, InstantiationException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PlayBall game = new PlayBall();
        return "You simulated a game!";
*//*

*//*    @RequestMapping("/players")
    public String perfectGameAllPlayers(ModelMap modelMap) {
        List<Player> allPlayers = PlayerRepository.getAllPlayers();
        modelMap.put("players", allPlayers);
        return "players";
    }

    @RequestMapping("/players/{playerId}")
    public String playerDetails(@PathVariable String playerId, ModelMap modelMap) {
        Player players = PlayerRepository.findByPlayerId(playerId);
        modelMap.put("players", players);
        return "players";*//*
    }

*//*    @RequestMapping("/stats")
    public String perfectGameStandings() {
        return "stats";
    }*//*

*//*    @RequestMapping("/relievers")
    public String relieverDetails(@PathVariable String playerId, ModelMap modelMap) {
        Reliever relievers = relieverRepository.findByPlayerId(playerId);
        modelMap.put("relievers", relievers);
        return "relievers";
    }*//*

*//*    @GetMapping(path = "/relievers")
    public @ResponseBody
    Iterable<Reliever> getAllRelievers(ModelMap modelMap) {
        Iterable<Reliever> relievers = relieverRepository.findAll();
        modelMap.put("relievers", relievers);
        return relievers;
    }*//*

*//*    @GetMapping(path = "/find")
    public @ResponseBody
    Reliever findReliever(@RequestParam String playerId) {
        return relieverRepository.findByPlayerId(playerId);
    }*//*
}*/

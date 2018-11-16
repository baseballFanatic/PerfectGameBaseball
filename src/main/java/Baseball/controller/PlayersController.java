package Baseball.controller;

import Baseball.Batter;
import Baseball.Fielder;
import Baseball.Pitcher;
import Baseball.Player;
import Baseball.repositories.BatterDao;
import Baseball.repositories.FielderDao;
import Baseball.repositories.PitcherDao;
import Baseball.repositories.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PlayersController {
    private final PlayerDao playerDao;

    private final BatterDao batterDao;

    private final PitcherDao pitcherDao;

    private final FielderDao fielderDao;

    @Autowired
    public PlayersController(PlayerDao playerDao, BatterDao batterDao, PitcherDao pitcherDao, FielderDao fielderDao) {
        this.playerDao = playerDao;
        this.batterDao = batterDao;
        this.pitcherDao = pitcherDao;
        this.fielderDao = fielderDao;
    }

    @RequestMapping("/players")
    public String players(ModelMap modelMap, HttpSession session) {
        Object nameLast = session.getAttribute("playerSearchLastName");
        Object currentYear = session.getAttribute("recentYear");

        List<Player> playerNames = playerDao.getPlayerByLastNameByYear( String.valueOf(nameLast),
                String.valueOf(currentYear));

        if (playerNames.size() > 0 ) {
            modelMap.put("playerNames", playerNames);
        }

        return "playerSearchPage";
    }

    @RequestMapping("/player")
    public String displayPlayer (@RequestParam String playerId, ModelMap modelMap, HttpSession session) {

        List<Batter> batters = batterDao.getStatsByPlayerId(playerId);
        List<Pitcher> pitchers = pitcherDao.getStatsByPlayerId(playerId);
        List<Fielder> fielders = fielderDao.getStatsByPlayerId(playerId);

        if (batters.isEmpty()) {
            session.setAttribute("isBatter", false);
        } else {
            session.setAttribute("isBatter", true);
        }

        if (pitchers.isEmpty()) {
            session.setAttribute("isPitcher", false);
        } else {
            session.setAttribute("isPitcher", true);
        }

        if (fielders.isEmpty()) {
            session.setAttribute("isFielder", false);
        } else {
            session.setAttribute("isFielder", true);
        }

        modelMap.put("batterStats", batters);
        modelMap.put("isBatter", session.getAttribute("isBatter"));
        modelMap.put("pitcherStats", pitchers);
        modelMap.put("isPitcher", session.getAttribute("isPitcher"));
        modelMap.put("fielderStats", fielders);
        modelMap.put("isFielder", session.getAttribute("isFielder"));

        return "playersPage";
    }

    @RequestMapping(value = "/hitters", method = RequestMethod.GET)
    @ResponseBody
    public List<Batter> getAllBattersByYear( @RequestParam String yearID )
    {
        return batterDao.getAllBattersByYear( yearID );
    }

    @RequestMapping(value = "/pitchers", method = RequestMethod.GET)
    @ResponseBody
    public List<Pitcher> getAllPitchersByYear( @RequestParam String yearID )
    {
        return pitcherDao.getAllPitchersByYear( yearID );
    }
}

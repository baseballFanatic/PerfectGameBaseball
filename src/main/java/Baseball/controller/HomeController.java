package Baseball.controller;

import Baseball.Season;
import Baseball.Team;
import Baseball.repositories.SeasonDao;
import Baseball.repositories.TeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private SeasonDao seasonDao;

    @Autowired
    private TeamsDao teamsDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html"; }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "homePage.html"; }

    @RequestMapping(value = "/years", method = RequestMethod.GET)
    @ResponseBody
    public List<Season> getYears( )
    {
        return seasonDao.getYears();
    }

    @RequestMapping(value = "/season", method = RequestMethod.GET)
    @ResponseBody
    public List<Team> getAllTeamsByYear( @RequestParam String yearID )
    {
        return teamsDao.getAllTeamsByYear( yearID );
    }

}

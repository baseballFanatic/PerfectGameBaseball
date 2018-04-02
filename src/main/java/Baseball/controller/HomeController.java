package Baseball.controller;

import Baseball.Season;
import Baseball.Team;
import Baseball.Users;
import Baseball.repositories.SeasonDao;
import Baseball.repositories.TeamsDao;
import Baseball.repositories.UsersDao;
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

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html"; }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "perfectGameHome.html"; }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public String frontOffice() {
        return "frontOffice.html";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<Users> getUsers( ) { return usersDao.getUsers(); }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public String players() {
        return "playersPage.html"; }

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

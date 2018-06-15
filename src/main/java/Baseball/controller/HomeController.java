package Baseball.controller;

import Baseball.Schedule;
import Baseball.Season;
import Baseball.Team;
import Baseball.repositories.ScheduleDao;
import Baseball.repositories.SeasonDao;
import Baseball.repositories.TeamsDao;
import Baseball.repositories.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private SeasonDao seasonDao;

    @Autowired
    private TeamsDao teamsDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ScheduleDao scheduleDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html"; }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "perfectGameHome"; }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public String frontOffice() {
        return "frontOffice";
    }

    @RequestMapping(value = "/standings", method = RequestMethod.GET)
    public String standings() { return "standingsPage"; }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String schedule(ModelMap modelMap) {
        List<Season> allYears = seasonDao.getYears();
        modelMap.put( "years", allYears );
        return "schedulePage";
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String stats() { return "statsPage"; }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String teams() { return "teamsPage"; }

    @RequestMapping(value = "/box", method = RequestMethod.GET)
    public String boxScore( @RequestParam int gameKey, ModelMap modelMap) {
        Schedule schedule = scheduleDao.getScheduleGameByGameKey( gameKey );
        modelMap.put( "gameDate", schedule.getGameDate() );
        modelMap.put( "gameDay", schedule.getGameDay());
        modelMap.put( "gameMonth", schedule.getGameMonth() );
        modelMap.put( "visitingTeamID", schedule.getVisitingTeamId() );
        modelMap.put( "homeTeamID", schedule.getHomeTeamId() );
        modelMap.put( "visitingScore", schedule.getVisitingScore() );
        modelMap.put( "homeScore", schedule.getHomeScore() );
        modelMap.put( "visitingStartingPitcherName", schedule.getVisitingStartingPitcherId() );
        modelMap.put( "homeStartingPitcherName", schedule.getHomeStartingPitcherName() );
        modelMap.put( "gameKey", schedule.getGameKey() );
        return "boxScorePage";
    }

    @RequestMapping(value = "/getSessionUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object getSession( HttpSession session ) {
        Object username = session.getAttribute( "username" );
        System.out.println("Got into getSessionUser - " + username);
        return username;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkUser( @RequestParam String user, HttpSession session ) {
        System.out.println( "Last one: " + session.getAttribute( "username" ) );
        session.setAttribute( "username", user );
        System.out.println( "Current one: " + session.getAttribute( "username" ));
        return usersDao.checkUser( user ); }

    @RequestMapping(value = "/years", method = RequestMethod.GET)
    @ResponseBody
    public List<Season> getYears()
    {
        return seasonDao.getYears();
    }

    @RequestMapping(value = "/season", method = RequestMethod.GET)
    @ResponseBody
    public List<Team> getAllTeamsByYear( @RequestParam String yearID )
    {
        return teamsDao.getAllTeamsByYear( yearID );
    }

    @RequestMapping(value = "/scheduleMonth", method = RequestMethod.GET)
    @ResponseBody
    public List<Schedule> getScheduleByYear( @RequestParam String yearID) { return scheduleDao.getScheduleByYear( yearID ); }

}

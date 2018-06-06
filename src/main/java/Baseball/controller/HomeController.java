package Baseball.controller;

import Baseball.Schedule;
import Baseball.Season;
import Baseball.Team;
import Baseball.Users;
import Baseball.repositories.ScheduleDao;
import Baseball.repositories.SeasonDao;
import Baseball.repositories.TeamsDao;
import Baseball.repositories.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        return "perfectGameHome.html"; }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public String frontOffice() {
        return "frontOffice.html";
    }

    @RequestMapping(value = "/standings", method = RequestMethod.GET)
    public String standings() { return "standingsPage.html"; }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String schedule() { return "schedulePage.html"; }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String stats() { return "statsPage.html"; }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String teams() { return "teamsPage.html"; }

/*    @RequestMapping(value = "/box", method = RequestMethod.GET)
    public ModelAndView boxScore( @RequestParam int gameKey) {
        ModelAndView modelAndView = new ModelAndView( "boxScorePage" );
        modelAndView.addObject( "gameKey", gameKey );
        return modelAndView;
    }*/


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkUser( @RequestParam String user, HttpSession session ) {
        System.out.println( "Last one: " + session.getAttribute( "username" ) );
        session.setAttribute( "username", user );
        return usersDao.checkUser( user ); }

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

    @RequestMapping(value = "/scheduleMonth", method = RequestMethod.GET)
    @ResponseBody
    public List<Schedule> getScheduleByYear( @RequestParam String yearID) { return scheduleDao.getScheduleByYear( yearID ); }

}

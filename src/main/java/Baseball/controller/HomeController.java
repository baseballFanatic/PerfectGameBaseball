package Baseball.controller;

import Baseball.*;
import Baseball.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    private final SeasonDao seasonDao;

    private final TeamsDao teamsDao;

    private final UsersDao usersDao;

    private final ScheduleDao scheduleDao;

    private final BoxScoreDao boxScoreDao;

    @Autowired
    public HomeController(SeasonDao seasonDao, TeamsDao teamsDao, UsersDao usersDao, ScheduleDao scheduleDao, BoxScoreDao boxScoreDao) {
        this.seasonDao = seasonDao;
        this.teamsDao = teamsDao;
        this.usersDao = usersDao;
        this.scheduleDao = scheduleDao;
        this.boxScoreDao = boxScoreDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "perfectGameHome"; }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "perfectGameHome"; }

    @RequestMapping(value = "/standings", method = RequestMethod.GET)
    public String standings() { return "standingsPage"; }

    @RequestMapping(value = "/box", method = RequestMethod.GET)
    public String boxScore( @RequestParam int gameKey, ModelMap modelMap) {
        Schedule schedule = scheduleDao.getScheduleGameByGameKey( gameKey );
        Team homeTeam = teamsDao.getTeamByYear( schedule.getGameYear(), schedule.getHomeTeamId() );
        Team visitingTeam = teamsDao.getTeamByYear( schedule.getGameYear(), schedule.getVisitingTeamId() );
        List<BoxScore> visitorGameBoxScore = boxScoreDao.getBoxScoreByYearIdByGameKeyByTeamID( schedule.getGameYear(), gameKey, visitingTeam.getTeamId() );
        List<BoxScore> homeGameBoxScore = boxScoreDao.getBoxScoreByYearIdByGameKeyByTeamID( schedule.getGameYear(), gameKey, homeTeam.getTeamId() );
        boolean homeWon = false;
        if (schedule.getHomeScore() > schedule.getVisitingScore()) {
            homeWon = true;
        }
        modelMap.put( "gameDate", schedule.getGameDate() );
        modelMap.put( "gameDay", schedule.getGameDay());
        modelMap.put( "gameMonth", schedule.getGameMonth() );
        modelMap.put( "gameYear", schedule.getGameYear() );
        modelMap.put( "visitingTeamID", schedule.getVisitingTeamId() );
        modelMap.put( "homeTeamID", schedule.getHomeTeamId() );
        modelMap.put( "visitingScore", schedule.getVisitingScore() );
        modelMap.put( "homeScore", schedule.getHomeScore() );
        modelMap.put( "homeHits", schedule.getHomeHits() );
        modelMap.put( "homeErrors", schedule.getHomeErrors() );
        modelMap.put( "visitingHits", schedule.getVisitingHits() );
        modelMap.put( "visitingErrors", schedule.getVisitingErrors() );
        modelMap.put( "visitingTeamWins", schedule.getAwayWins() );
        modelMap.put( "visitingTeamLosses", schedule.getAwayLosses() );
        modelMap.put( "homeTeamWins", schedule.getHomeWins() );
        modelMap.put( "homeTeamLosses", schedule.getHomeLosses() );
        modelMap.put( "visitingStartingPitcherName", schedule.getVisitingStartingPitcherName() );
        modelMap.put( "homeStartingPitcherName", schedule.getHomeStartingPitcherName() );
        modelMap.put( "winningPitcherWins", schedule.getWinningPitcherWins() );
        modelMap.put( "winningPitcherLosses", schedule.getWinningPitcherLosses() );
        modelMap.put( "losingPitcherWins", schedule.getLosingPitcherLosses() );
        modelMap.put( "losingPitcherLosses", schedule.getLosingPitcherLosses() );
        modelMap.put( "homeTeamFullName", homeTeam.getTeamName() );
        modelMap.put( "visitingTeamFullName", visitingTeam.getTeamName() );
        modelMap.put( "gameKey", schedule.getGameKey() );
        modelMap.put( "visitorBoxScore", visitorGameBoxScore );
        modelMap.put( "homeBoxScore", homeGameBoxScore );
        modelMap.put( "winningPitcherName", schedule.getWinningPitcherName() );
        modelMap.put( "losingPitcherName", schedule.getLosingPitcherName() );
        modelMap.put( "homeWon", homeWon );
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
    public boolean checkUser( @RequestParam String user, HttpSession session )
    {
        System.out.println( "Last one: " + session.getAttribute( "username" ) );
        if ( usersDao.checkUser( user ) )
        {
            List<Users> returnedUser = usersDao.getUser( user );
            for (Users possibleUser : returnedUser) {
                session.setAttribute( "username", user );
                session.setAttribute( "firstName", possibleUser.getFirstName() );
                session.setAttribute( "lastName", possibleUser.getLastName() );
                session.setAttribute( "active", possibleUser.getActive() );
                session.setAttribute( "recentYear", possibleUser.getRecentYear() );
                System.out.println("username: " + session.getAttribute( "username" ));
                System.out.println("firstName: " + session.getAttribute( "firstName" ));
                System.out.println("lastName: " + session.getAttribute( "lastName" ));
                System.out.println("active: " + session.getAttribute( "active" ));
                System.out.println("recentYear: " + session.getAttribute( "recentYear" ));
            }
            return true;
        }
        else
        {
            return false;
        }
    }



    @RequestMapping( value = "/playGame", method = RequestMethod.GET)
    @ResponseBody
    public boolean startGame ( @RequestParam String yearID, @RequestParam String lgID, @RequestParam String round,
                               @RequestParam String simName, @RequestParam String gameKey ) throws NoSuchMethodException, InstantiationException,
            SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException
    {
        PlayBall playBall = new PlayBall( Integer.parseInt( yearID ), lgID, round, simName, gameKey );

        return true;
    }

    @RequestMapping(value = "/years", method = RequestMethod.GET)
    @ResponseBody
    public List<Season> getYears( HttpSession session )
    {
        List<Season> allYears = seasonDao.getYears( session.getAttribute( "username" ));
        return allYears;
    }

    @RequestMapping(value = "/season", method = RequestMethod.GET)
    @ResponseBody
    public List<Team> getAllTeamsByYear( @RequestParam String yearID )
    {
        return teamsDao.getAllTeamsByYear( yearID );
    }

}

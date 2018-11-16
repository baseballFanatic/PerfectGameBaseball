package Baseball.controller;

import Baseball.*;
import Baseball.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

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
        String currentLeague = "MLB";
        String currentMonth = "4";
        if ( usersDao.checkUser( user ) )
        {
            Users returnedUser = usersDao.getUser( user );
            setSessionUser(user, session, returnedUser, currentLeague, currentMonth);
            return true;
        }
        else
        {
            return false;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public boolean registerUser( @RequestParam String user, @RequestParam String firstName,
                              @RequestParam String lastName, @RequestParam String active,
                              @RequestParam int mostRecentYear, HttpSession session) {
        session.setAttribute( "username", user );
        session.setAttribute("firstName", firstName );
        session.setAttribute( "lastName", lastName );
        session.setAttribute( "active", active );
        session.setAttribute( "mostRecentYear" , mostRecentYear );
        session.setAttribute("currentLeague", "MLB");
        session.setAttribute("currentMonth", "4");
        session.setAttribute("playerSearchLastName", "");
        session.setAttribute("availableGames", false );
        session.setAttribute("simulatedGames", false );
        session.setAttribute("displayAll", true );

        usersDao.addUser(session);

        return true;
    }

    private void setSessionUser(@RequestParam String user, HttpSession session, Users returnedUser,
                                String currentLeague, String currentMonth) {
        session.setAttribute( "username", user );
        session.setAttribute( "firstName", returnedUser.getFirstName() );
        session.setAttribute( "lastName", returnedUser.getLastName() );
        session.setAttribute( "active", returnedUser.getActive() );
        session.setAttribute( "recentYear", returnedUser.getRecentYear() );
        session.setAttribute("currentLeague", currentLeague );
        session.setAttribute("currentMonth", currentMonth );
        session.setAttribute("playerSearchLastName", "");
        session.setAttribute("availableGames", false );
        session.setAttribute("simulatedGames", false );
        session.setAttribute("displayAll", true );
    }

    @RequestMapping(value = "/setSessionLeague", method = RequestMethod.GET)
    @ResponseBody
    public boolean setSessionLeague ( @RequestParam String league, HttpSession session ) {
        session.setAttribute("currentLeague", league);
        return true;
    }

    @RequestMapping(value = "/setSessionMonth", method = RequestMethod.GET)
    @ResponseBody
    public boolean setSessionMonth ( @RequestParam String month, HttpSession session ) {
        session.setAttribute("currentMonth", month );
        return true;
    }

    @RequestMapping(value = "/setSessionSearchPlayer", method = RequestMethod.GET)
    @ResponseBody
    public boolean setSessionSearchPlayer (@RequestParam String lastName, HttpSession session) {
        session.setAttribute("playerSearchLastName", lastName );
        return true;
    }

    @RequestMapping(value = "/setSessionGames", method = RequestMethod.GET)
    @ResponseBody
    public boolean setSessionGames ( @RequestParam String gamesDisplay, HttpSession session ) {
        switch (gamesDisplay) {
            case "availableRadio":
                session.setAttribute("availableGames", true);
                session.setAttribute("simulatedGames", false);
                session.setAttribute("displayAll", false);

                break;
            case "simulatedRadio":
                session.setAttribute("availableGames", false);
                session.setAttribute("simulatedGames", true);
                session.setAttribute("displayAll", false);
                break;

            case "allRadio":
                session.setAttribute("availableGames", false);
                session.setAttribute("simulatedGames", false);
                session.setAttribute("displayAll", true);
                break;
        }
        return true;
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

package Baseball.controller;

import Baseball.Schedule;
import Baseball.Season;
import Baseball.repositories.ScheduleDao;
import Baseball.repositories.SeasonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScheduleController
{
    private final ScheduleDao scheduleDao;

    private final SeasonDao seasonDao;

    @Autowired
    public ScheduleController(ScheduleDao scheduleDao, SeasonDao seasonDao) {
        this.scheduleDao = scheduleDao;
        this.seasonDao = seasonDao;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String schedule(ModelMap modelMap, HttpSession session ) {
        int displayYear = 1900;
        String displayGames = "";
        Object displayMonth = session.getAttribute("currentMonth");
        Object league = session.getAttribute("currentLeague");
        List<Season> allYears = seasonDao.getYears( session.getAttribute( "username" ));
        for ( Season year : allYears ) {
            displayYear = year.getYearID();
            break;
        }

        if (session.getAttribute("availableGames").equals(true) ) {
            displayGames = "N";
        } else if (session.getAttribute("simulatedGames").equals(true) ) {
            displayGames = "Y";
        } else if (session.getAttribute("displayAll").equals(true) ) {
            displayGames = "A";
        }

        List<Schedule> displaySchedule = scheduleDao.getScheduleByYear( String.valueOf( displayYear ),
                String.valueOf( displayMonth ), String.valueOf( league ), displayGames );

        modelMap.put( "displaySchedule", displaySchedule );
        modelMap.put( "displayYear", displayYear );
        modelMap.put( "years", allYears );
        modelMap.put( "currentLeague", session.getAttribute("currentLeague") );
        modelMap.put( "currentMonth", session.getAttribute( "currentMonth") );
        modelMap.put( "availableGames", session.getAttribute("availableGames") );
        modelMap.put( "simulatedGames", session.getAttribute("simulatedGames") );
        modelMap.put( "displayAll", session.getAttribute("displayAll") );
        return "schedulePage";
    }

    @RequestMapping(value = "/scheduleMonth", method = RequestMethod.GET)
    @ResponseBody
    public List<Schedule> getScheduleByYear( @RequestParam String yearID, @RequestParam String gameMonth, @RequestParam String league) {
        //TODO: add in update of session currentLeague and month to values from the web page so they can remain while re-loading
        String displayGames = "A";
        return scheduleDao.getScheduleByYear( yearID, gameMonth, league, displayGames );
    }

}

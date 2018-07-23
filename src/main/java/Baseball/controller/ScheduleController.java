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
        List<Season> allYears = seasonDao.getYears( session.getAttribute( "username" ));
        for ( Season year : allYears ) {
            displayYear = year.getYearID();
            break;
        }
        List<Schedule> displaySchedule = scheduleDao.getScheduleByYear( String.valueOf( displayYear ) );

        modelMap.put( "displaySchedule", displaySchedule );
        modelMap.put( "displayYear", displayYear );
        modelMap.put( "years", allYears );
        return "schedulePage";
    }

    @RequestMapping(value = "/scheduleMonth", method = RequestMethod.GET)
    @ResponseBody
    public List<Schedule> getScheduleByYear( @RequestParam String yearID) { return scheduleDao.getScheduleByYear( yearID ); }

}

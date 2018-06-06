package Baseball.controller;

import Baseball.Schedule;
import Baseball.repositories.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ScheduleController
{
    @Autowired
    private ScheduleDao scheduleDao;

    @RequestMapping( "/schedule" )
    public String schedule ( Model model ) { return "schedulePage.html"; }

/*    @RequestMapping( "/schedule/{yearID}" )
    public String view ( @PathVariable("yearID") String yearID, Model model) throws ClassNotFoundException {
        List<Schedule> schedule = scheduleDao.getScheduleByYear( yearID );
        model.addAttribute( "schedule", schedule );
        return "schedule";
    }*/

}

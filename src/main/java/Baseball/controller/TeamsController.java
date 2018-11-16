package Baseball.controller;

import Baseball.Team;
import Baseball.repositories.TeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeamsController
{
    private final TeamsDao teamsDao;

    @Autowired
    public TeamsController(TeamsDao teamsDao) {
        this.teamsDao = teamsDao;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String teams( ModelMap modelMap, HttpSession session) {
        Object currentYear = session.getAttribute("recentYear");
        System.out.println("recentYear: " + currentYear);
        List<Team> teams = teamsDao.getAllTeamsByYear( String.valueOf(currentYear) );
        modelMap.put("teams", teams);
        return "teamsSearchPage";
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public String view(@RequestParam String teamId, ModelMap modelMap, HttpSession session) {
        Object currentYear = session.getAttribute("recentYear");
        List<Team> selectedTeam = teamsDao.getTeamByYearId( teamId, String.valueOf(currentYear));
        modelMap.addAttribute("teamStats", selectedTeam);
        return "teamsPage";
    }
}

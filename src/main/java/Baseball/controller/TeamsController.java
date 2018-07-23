package Baseball.controller;

import Baseball.Team;
import Baseball.repositories.TeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String teams() { return "teamsPage"; }

    @RequestMapping("/teams/{yearID}")
    public String view( @PathVariable("yearID") String yearID, Model model) throws ClassNotFoundException {
        List<Team> teams = teamsDao.getAllTeamsByYear(yearID);
        model.addAttribute("teams", teams);
        return "teams";
    }
}

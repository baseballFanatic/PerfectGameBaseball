package Baseball.controller;

import Baseball.Team;
import Baseball.repositories.TeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeamsController
{
    @Autowired
    private TeamsDao teamsDao;

    @RequestMapping( "/teams" )
    public String teams( Model model ) { return "teamsPage.html"; }
/*
    @RequestMapping( "/teams/getAllTeamsByYear" )
    public List<Team> getAllTeamsByYear( ) { return teamsDao.getAllTeamsByYear(); }*/
}

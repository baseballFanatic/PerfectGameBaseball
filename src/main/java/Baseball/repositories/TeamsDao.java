package Baseball.repositories;

import Baseball.Team;

import java.util.List;

public interface TeamsDao
{
    List<Team> getAllTeamsByYear(String yearID);
}

package Baseball.repositories;

import Baseball.BoxScore;

import java.util.List;

public interface BoxScoreDao
{
    List<BoxScore> getBoxScoreByYearIdByGameKeyByTeamID (int yearID, int gameKey, String teamID);

}

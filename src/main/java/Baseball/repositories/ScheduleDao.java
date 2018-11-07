package Baseball.repositories;

import Baseball.Schedule;

import java.util.List;

public interface ScheduleDao
{
    List<Schedule> getScheduleByYear( String yearID, String gameMonth, String league, String displayGames );

    Schedule getScheduleGameByGameKey ( int gameKey);
}

package Baseball.repositories;

import Baseball.Schedule;

import java.util.List;

public interface ScheduleDao
{
    List<Schedule> getScheduleByYear( String yearID);

    Schedule getScheduleGameByGameKey ( int gameKey);
}

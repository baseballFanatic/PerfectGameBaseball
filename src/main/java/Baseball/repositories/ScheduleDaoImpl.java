package Baseball.repositories;

import Baseball.Schedule;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public List<Schedule> getScheduleByYear( String yearID, String gameMonth, String league, String displayGames )
    {
        Connection connection;

        List<Schedule> schedules = new ArrayList<>();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;

            if (league.equals("MLB")) {
                statement = connection.prepareStatement( "SELECT gameDate, gameMonth, gameDay, gameKey, visitingTeamId, homeTeamId, visitingScore, " +
                        "homeScore, winningPitcherName, losingPitcherName, homeLgId," +
                        "visitingStartingPitcherName, homeStartingPitcherName, gameCompleted, gameKey, homeWins, " +
                        "homeLosses, awayWins, awayLosses, winningPitcherWins, winningPitcherLosses, losingPitcherWins, " +
                        "losingPitcherLosses FROM pgbs_schedule " +
                        "where gameYear = ? and gameMonth = ?" +
                        "ORDER BY gameKey ASC" );
                statement.setString( 1, yearID );
                statement.setString(2, gameMonth);
            } else {
                statement = connection.prepareStatement("SELECT gameDate, gameMonth, gameDay, gameKey, visitingTeamId, homeTeamId, visitingScore, " +
                        "homeScore, winningPitcherName, losingPitcherName, homeLgId," +
                        "visitingStartingPitcherName, homeStartingPitcherName, gameCompleted, gameKey, homeWins, " +
                        "homeLosses, awayWins, awayLosses, winningPitcherWins, winningPitcherLosses, losingPitcherWins, " +
                        "losingPitcherLosses FROM pgbs_schedule " +
                        "where gameYear = ? and gameMonth = ? and homeLgId = ?" +
                        "ORDER BY gameKey ASC");
                statement.setString(1, yearID);
                statement.setString(2, gameMonth);
                statement.setString(3, league);
            }

            ResultSet resultSet = statement.executeQuery();

            System.out.println("displayGames: " + displayGames);

            while ( resultSet.next() )
            {
                Schedule schedule = new Schedule();
                if (displayGames.equals("A")) {
                    setSchedulesFile(schedules, resultSet, schedule);
                } else {
                    if ( resultSet.getString("gameCompleted").equals(displayGames)) {
                        setSchedulesFile(schedules, resultSet, schedule);
                    }
                }
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch ( IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return schedules;
    }

    @Override
    public Schedule getScheduleGameByGameKey( int gameKey )
    {
        Connection connection;

        Schedule schedule = new Schedule();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;
            statement = connection.prepareStatement( "SELECT gameDate, gameMonth, gameDay, gameYear, visitingTeamId, homeTeamId, visitingScore, " +
                    "homeScore, winningPitcherName, losingPitcherName, homeHits, homeErrors, visitingHits, visitingErrors, " +
                    "visitingStartingPitcherName, homeStartingPitcherName, gameCompleted, gameKey, homeWins, homeLosses, " +
                    "awayWins, awayLosses, winningPitcherWins, winningPitcherLosses, losingPitcherWins, losingPitcherLosses, " +
                    "losingPitcherName, winningPitcherName " +
                    "FROM pgbs_schedule WHERE gameKey = ? " +
                    "ORDER BY gameDate ASC" );
            statement.setInt( 1, gameKey );

            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() )
            {
                schedule.setGameMonth( resultSet.getInt( "gameMonth" ) );
                schedule.setGameDay( resultSet.getInt( "gameDay" ) );
                schedule.setGameYear( resultSet.getInt( "gameYear" ) );
                schedule.setVisitingTeamId( resultSet.getString( "visitingTeamId" ) );
                schedule.setHomeTeamId( resultSet.getString( "homeTeamId" ) );
                schedule.setVisitingScore( resultSet.getInt( "visitingScore" ) );
                schedule.setHomeScore( resultSet.getInt( "homeScore" ) );
                schedule.setWinningPitcherName( resultSet.getString( "winningPitcherName" ) );
                schedule.setLosingPitcherName( resultSet.getString( "losingPitcherName" ) );
                schedule.setHomeHits( resultSet.getInt( "homeHits" ) );
                schedule.setHomeErrors( resultSet.getInt( "homeErrors" ) );
                schedule.setVisitingHits( resultSet.getInt( "visitingHits" ) );
                schedule.setVisitingErrors( resultSet.getInt( "visitingErrors" ) );
                schedule.setVisitingStartingPitcherName( resultSet.getString( "visitingStartingPitcherName" ) );
                schedule.setHomeStartingPitcherName( resultSet.getString( "homeStartingPitcherName" ) );
                schedule.setGameCompleted( resultSet.getString( "gameCompleted" ) );
                schedule.setHomeWins( resultSet.getInt( "homeWins" ) );
                schedule.setHomeLosses( resultSet.getInt( "homeLosses" ) );
                schedule.setAwayWins( resultSet.getInt( "awayWins" ) );
                schedule.setAwayLosses( resultSet.getInt( "awayLosses" ) );
                schedule.setWinningPitcherWins( resultSet.getInt( "winningPitcherWins" ) );
                schedule.setWinningPitcherLosses( resultSet.getInt( "winningPitcherLosses" ));
                schedule.setLosingPitcherWins( resultSet.getInt( "losingPitcherWins" ) );
                schedule.setLosingPitcherLosses( resultSet.getInt( "losingPitcherLosses" ) );
                schedule.setLosingPitcherName( resultSet.getString( "losingPitcherName" ) );
                schedule.setWinningPitcherName( resultSet.getString( "winningPitcherName" ) );
                schedule.setGameKey( resultSet.getInt( "gameKey" ) );
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch ( IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return schedule;
    }

    private List<Schedule> setSchedulesFile (@NotNull List<Schedule> schedules, @NotNull ResultSet resultSet,
                                             @NotNull Schedule schedule) throws SQLException {
        schedule.setGameMonth( resultSet.getInt( "gameMonth" ) );
        schedule.setGameDay( resultSet.getInt( "gameDay" ) );
        schedule.setVisitingTeamId( resultSet.getString( "visitingTeamId" ) );
        schedule.setHomeTeamId( resultSet.getString( "homeTeamId" ) );
        schedule.setVisitingScore( resultSet.getInt( "visitingScore" ) );
        schedule.setHomeScore( resultSet.getInt( "homeScore" ) );
        schedule.setWinningPitcherName( resultSet.getString( "winningPitcherName" ) );
        schedule.setLosingPitcherName( resultSet.getString( "losingPitcherName" ) );
        schedule.setHomeLgId( resultSet.getString( "homeLgId" ) );
        schedule.setVisitingStartingPitcherName( resultSet.getString( "visitingStartingPitcherName" ) );
        schedule.setHomeStartingPitcherName( resultSet.getString( "homeStartingPitcherName" ) );
        schedule.setGameCompleted( resultSet.getString( "gameCompleted" ) );
        schedule.setHomeWins( resultSet.getInt( "homeWins" ) );
        schedule.setHomeLosses( resultSet.getInt( "homeLosses" ) );
        schedule.setAwayWins( resultSet.getInt( "awayWins" ) );
        schedule.setAwayLosses( resultSet.getInt( "awayLosses" ) );
        schedule.setWinningPitcherWins( resultSet.getInt( "winningPitcherWins" ) );
        schedule.setWinningPitcherLosses( resultSet.getInt( "winningPitcherLosses" ) );
        schedule.setLosingPitcherWins( resultSet.getInt( "losingPitcherWins" ) );
        schedule.setLosingPitcherLosses( resultSet.getInt( "losingPitcherLosses" ) );
        schedule.setGameKey( resultSet.getInt( "gameKey" ) );
        schedules.add( schedule );
        return schedules;
    }
}

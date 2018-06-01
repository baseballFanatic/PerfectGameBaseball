package Baseball.repositories;

import Baseball.Schedule;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Schedule> getScheduleByYear( String yearID )
    {
        Connection connection;

        List<Schedule> schedules = new ArrayList<>();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;
            statement = connection.prepareStatement( "SELECT gameDate, visitingTeamId, homeTeamId, visitingScore, " +
                    "homeScore, winningPitcherName, losingPitcherName, " +
                    "visitingStartingPitcherName, homeStartingPitcherName FROM pgbs_schedule WHERE yearID=? " +
                    "ORDER BY gameDate ASC" );
            statement.setString( 1, yearID );

            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() )
            {
                Schedule schedule = new Schedule();
                schedule.setVisitingTeamId( resultSet.getString( "visitingTeamId" ) );
                schedule.setHomeTeamId( resultSet.getString( "homeTeamId" ) );
                schedule.setVisitingScore( resultSet.getInt( "visitingScore" ) );
                schedule.setHomeScore( resultSet.getInt( "homeScore" ) );
                schedule.setWinningPitcherName( resultSet.getString( "winningPitcherName" ) );
                schedule.setLosingPitcherName( resultSet.getString( "losingPitcherName" ) );
                schedule.setVisitingStartingPitcherName( resultSet.getString( "visitingStartingPitcherName" ) );
                schedule.setHomeStartingPitcherName( resultSet.getString( "homeStartingPitcherName" ) );

                schedules.add( schedule );
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
}

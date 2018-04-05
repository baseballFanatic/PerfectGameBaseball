package Baseball.repositories;

import Baseball.Team;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamsDaoImpl implements TeamsDao
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Team> getAllTeamsByYear(String yearID)
    {
        Connection connection;

        List<Team> teams = new ArrayList<>();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;
            statement = connection.prepareStatement( "SELECT name, yearID, teamID, lgID, seasonGames, seasonWins, " +
                    "seasonLosses, homeWins, homeLosses, awayWins, awayLosses FROM pgbs_teams WHERE yearID=? " +
                    "ORDER BY lgID ASC, seasonWins DESC" );
            statement.setString( 1, yearID );

            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() )
            {
                Team team = new Team();
                team.setTeamName( resultSet.getString( "name" ) );
                team.setYearId( resultSet.getInt( "yearID" ) );
                team.setTeamId( resultSet.getString( "teamID" ) );
                team.setLgId( resultSet.getString( "lgID" ) );
                team.getTeamStats().setSeasonGames( resultSet.getInt( "seasonGames" ) );
                team.getTeamStats().setSeasonWins( resultSet.getInt( "seasonWins" ) );
                team.getTeamStats().setSeasonLosses( resultSet.getInt( "seasonLosses" ) );
                team.getTeamStats().setHomeWins( resultSet.getInt( "homeWins" ) );
                team.getTeamStats().setHomeLosses( resultSet.getInt( "homeLosses" ) );
                team.getTeamStats().setAwayWins( resultSet.getInt( "awayWins" ) );
                team.getTeamStats().setAwayLosses( resultSet.getInt( "awayLosses" ) );

                teams.add( team );
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch ( IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return teams;
    }
}

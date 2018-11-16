package Baseball.repositories;

import Baseball.Team;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamsDaoImpl implements TeamsDao
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Team> getTeamByYearId(String teamId, String yearId) {
        Connection connection;

        List<Team> teams = new ArrayList<>();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;
            statement = connection.prepareStatement( "SELECT name, yearID, teamID, lgID, seasonGames, seasonWins, " +
                    "seasonLosses, homeWins, homeLosses, awayWins, awayLosses, park, attendance FROM pgbs_teams WHERE yearID=? " +
                    "and teamID=?" );
            statement.setString( 1, yearId );
            statement.setString(2, teamId);

            ResultSet resultSet = statement.executeQuery();

            setTeamDataFromQuery(teams, resultSet);

            resultSet.close();
            statement.close();
            connection.close();
        } catch ( IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return teams;
    }

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
                    "seasonLosses, homeWins, homeLosses, awayWins, awayLosses, park, attendance FROM pgbs_teams WHERE yearID=? " +
                    "ORDER BY lgID ASC, seasonWins DESC" );
            statement.setString( 1, yearID );

            ResultSet resultSet = statement.executeQuery();

            setTeamDataFromQuery(teams, resultSet);

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

    private void setTeamDataFromQuery(List<Team> teams, ResultSet resultSet) throws SQLException {
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
            team.setPark(resultSet.getString("park"));
            team.getTeamStats().setAttendance(resultSet.getInt("attendance"));

            teams.add( team );
        }
    }

    @Override
    public List<Team> getTeamsPlayedByYear( String awayYearId, String homeYearId )
    {
        Connection connection;

        List<Team> teams = new ArrayList<>();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;
            statement = connection.prepareStatement( "SELECT name, yearID, teamID, lgID, seasonGames, seasonWins, " +
                    "seasonLosses, homeWins, homeLosses, awayWins, awayLosses FROM pgbs_teams WHERE yearID=? or yearID = ? " +
                    "ORDER BY lgID ASC, seasonWins DESC" );
            statement.setString( 1, awayYearId );
            statement.setString( 2, homeYearId );

            ResultSet resultSet = statement.executeQuery();

            setTeamDataFromQuery(teams, resultSet);

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

    @Override
    public Team getTeamByYear( int yearID, String teamID )
    {
        Connection connection;

        Team team = new Team();

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;

            statement = connection.prepareStatement( "SELECT name, yearID, teamID, lgID, seasonGames, seasonWins, " +
                    "seasonLosses, homeWins, homeLosses, awayWins, awayLosses, currentWinStreak, currentLosingStreak, " +
                    "park, attendance FROM pgbs_teams WHERE yearID=? and teamID = ? " );
            statement.setInt( 1, yearID );
            statement.setString( 2, teamID );

            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() ) {
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
                team.getTeamStats().setCurrentWinStreak( resultSet.getInt( "currentWinStreak" ) );
                team.getTeamStats().setCurrentLossStreak( resultSet.getInt( "currentLosingStreak" ) );
                team.setPark( resultSet.getString( "park" ) );
                team.getTeamStats().setAttendance( Integer.parseInt( resultSet.getString( "attendance" ) ) );
            }

        }
        catch ( SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

        return team;
    }
}

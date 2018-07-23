package Baseball.repositories;

import Baseball.Pitcher;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PitcherDaoImpl implements PitcherDao
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Pitcher> getAllPitchersByYear( String yearID )
    {
        Connection conn;

        List<Pitcher> pitchers = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT nameFirst, nameLast, playerId, teamID, lgID, " +
                    "yearID, sGamesPlayed, sGamesStarted, sBattersFaced, sHitsAllowed, sHitBatters, sEarnedRuns," +
                    " sRunsAllowed, sStrikeOutsAllowed, sWalksAllowed, sHomeRunsAllowed, sInningsPitchedOuts," +
                    " sShutOuts, sCompleteGames, sWins, sLosses, sSaves" +
                    " from pgbs_pitchers " +
                    " where yearID=? order by sWins DESC limit 50");
            stmt.setString(1, yearID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pitcher pitcher = new Pitcher();
                // Retrieve by column name
                pitcher.setNameFirst( rs.getString( "nameFirst" ) );
                pitcher.setNameLast( rs.getString( "nameLast" ) );
                pitcher.setPlayerId( rs.getString( "playerID" ) );
                pitcher.setTeamID( rs.getString( "teamID" ) );
                pitcher.setLgID( rs.getString( "lgID" ) );
                pitcher.getPitcherStats().setsGamesPlayed( rs.getInt( "sGamesPlayed" ) );
                pitcher.getPitcherStats().setsGamesStarted( rs.getInt( "sGamesStarted" ) );
                pitcher.getPitcherStats().setsBattersFaced( rs.getInt( "sBattersFaced" ) );
                pitcher.getPitcherStats().setsHitsAllowed( rs.getInt( "sHitsAllowed" ) );
                pitcher.getPitcherStats().setsHitBatters( rs.getInt( "sHitBatters" ) );
                pitcher.getPitcherStats().setsEarnedRuns( rs.getInt( "sEarnedRuns" ) );
                pitcher.getPitcherStats().setsRunsAllowed( rs.getInt( "sRunsAllowed" ) );
                pitcher.getPitcherStats().setsStrikeOutAllowed( rs.getInt( "sStrikeOutsAllowed" ) );
                pitcher.getPitcherStats().setsWalksAllowed( rs.getInt( "sWalksAllowed" ) );
                pitcher.getPitcherStats().setsHomeRunsAllowed( rs.getInt( "sHomeRunsAllowed" ) );
                pitcher.getPitcherStats().setsInningsPitchedOuts( rs.getInt( "sInningsPitchedOuts" ) );
                pitcher.getPitcherStats().setsShutOuts( rs.getInt( "sShutOuts" ) );
                pitcher.getPitcherStats().setsCompleteGames( rs.getInt( "sCompleteGames" ) );
                pitcher.getPitcherStats().setsWins( rs.getInt( "sWins" ) );
                pitcher.getPitcherStats().setsLosses( rs.getInt( "sLosses" ) );
                pitcher.getPitcherStats().setsSaves( rs.getInt( "sSaves" ) );

                pitchers.add(pitcher);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pitchers;
    }

    @Override
    public List<Pitcher> getPitcher( String yearID )
    {
        return null;
    }
}

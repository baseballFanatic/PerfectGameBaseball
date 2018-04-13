package Baseball.repositories;

import Baseball.Batter;
import Baseball.BatterStats;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BatterDaoImpl implements BatterDao
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Batter> getAllBattersByYear( String yearId)
    {
        Connection conn;

        List<Batter> batters = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT nameFirst, nameLast, playerId, teamID, lgID, " +
                    "yearID, teamID, sGamesPlayed, sHomeRuns, sTriples, sDoubles, sWalks," +
                    "sAtBats, sStolenBases, sCaughtStealing, sRuns, sRbi, sHits, sStrikeOuts" +
                    " from pgbs_batters " +
                    " where yearID=? order by sGamesPlayed DESC limit 50");
            stmt.setString(1, yearId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Batter batter = new Batter();
                // Retrieve by column name
                batter.setNameFirst( rs.getString( "nameFirst" ) );
                batter.setNameLast( rs.getString( "nameLast" ) );
                batter.setPlayerId( rs.getString( "playerID" ) );
                batter.setTeamID( rs.getString( "teamID" ) );
                batter.setLgID( rs.getString( "lgID" ) );
                batter.getBatterStats().setYearID( rs.getInt( "yearID" ) );
                batter.getBatterStats().setsGamesPlayed( rs.getInt( "sGamesPlayed" ) );
                batter.getBatterStats().setsAtBats( rs.getInt( "sAtBats" ) );
                batter.getBatterStats().setsHits( rs.getInt( "sHits" ) );
                batter.getBatterStats().setsDoubles( rs.getInt( "sDoubles" ) );
                batter.getBatterStats().setsTriples( rs.getInt( "sTriples" ) );
                batter.getBatterStats().setsHomeRuns( rs.getInt( "sHomeRuns" ) );
                batter.getBatterStats().setsRbi( rs.getInt( "sRbi" ) );
                batter.getBatterStats().setsRuns( rs.getInt( "sRuns" ) );
                batter.getBatterStats().setsStolenBases( rs.getInt( "sStolenBases" ) );
                batter.getBatterStats().setsCaughtStealing( rs.getInt( "sCaughtStealing" ) );
                batter.getBatterStats().setsWalks( rs.getInt( "sWalks" ) );
                batter.getBatterStats().setsStrikeOuts( rs.getInt( "sStrikeOuts" ) );

                batters.add(batter);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return batters;
    }

    @Override
    public List<Batter> getBatter( String playerId )
    {
        Connection conn;

        List<Batter> batters = new ArrayList<>();

            try {
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // Open connection
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        PreparedStatement stmt;
        stmt = conn.prepareStatement("SELECT * from pgbs_batter " +
                " where player_id=?");
        stmt.setString(1, playerId);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Batter batter = new Batter();
            // Retrieve by column name
            batter.setNameGiven(rs.getString("name_given"));
            batter.setBirthYear(rs.getString("birth_year"));
            batter.setBirthMonth(rs.getString("birth_month"));
            batter.setBirthDay(rs.getString("birth_day"));
            batter.setBirthCountry( rs.getString("birth_country") );
            batter.setPlayerId(rs.getString("player_id"));
            batter.setBirthState( rs.getString( "birth_state" ) );
            batter.setBirthCity( rs.getString( "birth_city" ) );
            batter.setDeathYear( rs.getString( "death_year" ) );
            batter.setDeathMonth( rs.getString( "death_month" ) );
            batter.setDeathDay( rs.getString( "death_day" ) );
            batter.setDeathCountry( rs.getString( "death_country" ) );
            batter.setDeathState( rs.getString( "death_state" ) );
            batter.setDeathCity( rs.getString( "death_city" ) );
            batter.setNameFirst( rs.getString( "name_first" ) );
            batter.setNameLast( rs.getString( "name_last" ) );
            batter.setWeight( rs.getInt( "weight" ) );
            batter.setHeight( rs.getInt( "height" ) );

            batters.add(batter);
        }

        rs.close();
        stmt.close();
        conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return batters;
    }
}

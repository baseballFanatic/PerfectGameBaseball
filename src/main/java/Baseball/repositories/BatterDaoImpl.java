package Baseball.repositories;

import Baseball.Batter;
import Baseball.Hands;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BatterDaoImpl implements BatterDao
{
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

    @Override
    public List<Batter> getStatsByPlayerId( String playerId ) {
        Connection conn;

        List<Batter> batterSeasons = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement stmt;
/*            stmt = conn.prepareStatement( "SELECT * FROM pgbs_batters WHERE playerKey = ?");*/
            stmt = conn.prepareStatement("SELECT players.*, batters.*, batters.sHits / batters.sAtBats as BAvg," +
                    " (batters.sHits + batters.sHitByPitch + batters.sWalks) / batters.sAtBats as OBP," +
                    " ((batters.sHits - batters.sDoubles - batters.sTriples - batters.sHomeRuns) + " +
                    "(batters.sDoubles * 2) + (batters.sTriples * 3) + (batters.sHomeRuns * 4) + " +
                    "batters.sWalks) / batters.sAtBats as SLG," +
                    " ((batters.sHits + batters.sHitByPitch + batters.sWalks) / batters.sAtBats) + " +
                    " (((batters.sHits - batters.sDoubles - batters.sTriples - batters.sHomeRuns) + " +
                    "(batters.sDoubles * 2) + (batters.sTriples * 3) + (batters.sHomeRuns * 4) + " +
                    "(batters.sWalks)) / batters.sAtBats) as OPS, " +
                    "sum(sHits) as tHits, sum(sAtBats) as tAtBats, sum(sRuns) as tRuns," +
                    "sum(sHits) / sum(sAtBats) as tBAvg, sum(sHomeRuns) as tHomeRuns, sum(sRbi) as tRbi," +
                    "sum(sStolenBases) as tStolenBases, ((sum(sHits) + sum(sWalks) + sum(sHitByPitch)) / sum(sAtBats)) " +
                    "as tOBP, (((sum(sHits) - sum(sdoubles) - sum(sTriples) - sum(sHomeRuns)) + (sum(sDoubles) * 2) + (sum(sTriples) * 3) + " +
                    "(sum(sHomeRuns) * 4) + sum(sWalks)) / sum(sAtBats)) as tSLG," +
                    " ((sum(sHits) + sum(sWalks) + sum(sHitByPitch)) / sum(sAtBats)) + (((sum(sHits) - sum(sDoubles) " +
                    "- sum(sTriples) - sum(sHomeRuns)) + (sum(sDoubles) * 2) + (sum(sTriples) * 3) + (sum(sHomeRuns) * 4) + sum(sWalks)) / sum(sAtBats))" +
                    " as tOPS " +
                    "from master players, pgbs_batters batters where " +
                    "batters.playerID=? and players.playerID = batters.playerID");
            stmt.setString( 1, playerId );

            ResultSet rs = stmt.executeQuery();

            while ( rs.next() ) {
                Batter batterSeason = new Batter();
                batterSeason.setPlayerId(rs.getString("playerID"));
                batterSeason.setNameFirst(rs.getString("nameFirst"));
                batterSeason.setNameLast(rs.getString("nameLast"));
                batterSeason.setNameGiven(rs.getString("nameGiven"));
                batterSeason.setBirthYear(rs.getString("birthYear"));
                batterSeason.setDeathYear(rs.getString("deathYear"));
                batterSeason.setDeathCity(rs.getString("deathCity"));
                batterSeason.setDeathState(rs.getString("deathState"));
                batterSeason.setHeight(rs.getInt("height"));
                batterSeason.setWeight(rs.getInt("weight"));
                batterSeason.setBats(Hands.get( rs.getString("bats") ));
                batterSeason.setBirthCity(rs.getString("birthCity"));
                batterSeason.setBirthState(rs.getString("birthState"));
                batterSeason.getBatterStats().setYearID( rs.getInt( "yearID" ) );
                batterSeason.setTeamID( rs.getString( "teamID" ) );
                batterSeason.setLgID( rs.getString( "lgID" ) );
                batterSeason.getBatterStats().setsGamesPlayed(rs.getInt("sGamesPlayed"));
                batterSeason.getBatterStats().setsGamesStarted(rs.getInt("sGamesStarted"));
                batterSeason.getBatterStats().setsAtBats( rs.getInt( "sAtBats" ) );
                batterSeason.getBatterStats().setsRuns( rs.getInt( "sRuns" ) );
                batterSeason.getBatterStats().setsHits( rs.getInt( "sHits" ) );
                batterSeason.getBatterStats().setsRbi( rs.getInt( "sRbi" ) );
                batterSeason.getBatterStats().setsDoubles( rs.getInt( "sDoubles" ) );
                batterSeason.getBatterStats().setsTriples( rs.getInt( "sTriples" ) );
                batterSeason.getBatterStats().setsHomeRuns( rs.getInt( "sHomeRuns" ) );
                batterSeason.getBatterStats().setsStolenBases( rs.getInt("sStolenBases" ) );
                batterSeason.getBatterStats().setsCaughtStealing( rs.getInt("sCaughtStealing" ) );
                batterSeason.getBatterStats().setBattingAverage(rs.getDouble("BAvg"));
                batterSeason.getBatterStats().setOnBasePercentage(rs.getDouble("OBP"));
                batterSeason.getBatterStats().setSluggingAverage(rs.getDouble("SLG"));
                batterSeason.getBatterStats().setSumAtBats(rs.getInt("tAtBats"));
                batterSeason.getBatterStats().setSumHits(rs.getInt("tHits"));
                batterSeason.getBatterStats().setSumRuns(rs.getInt("tRuns"));
                batterSeason.getBatterStats().setSumRbi(rs.getInt("tRbi"));
                batterSeason.getBatterStats().setSumBattingAverage(rs.getDouble("tBAvg"));
                batterSeason.getBatterStats().setSumHomeRuns(rs.getInt("tHomeRuns"));
                batterSeason.getBatterStats().setSumStolenBases(rs.getInt("tStolenBases"));
                batterSeason.getBatterStats().setOnBasePlusSlugging(rs.getDouble("OPS"));
                batterSeason.getBatterStats().setSumOnBaseAverage(rs.getDouble("tOBP"));
                batterSeason.getBatterStats().setSumSluggingPercentage(rs.getDouble("tSLG"));
                batterSeason.getBatterStats().setSumOps(rs.getDouble("tOPS"));

                batterSeasons.add( batterSeason );
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch ( IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return batterSeasons;
    }
}

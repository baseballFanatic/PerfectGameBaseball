package Baseball.repositories;

import Baseball.Fielder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FielderDaoImpl implements FielderDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";


    @Override
    public List<Fielder> getStatsByPlayerId(String playerId) {
        Connection conn;

        List<Fielder> fielderSeasons = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT *, ((sPutOuts + sAssists) / (sErrors + sAssists + sPutOuts)) as fielding" +
                    " from pgbs_fielders " +
                    " where playerID=?");
            stmt.setString(1, playerId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fielder fielder = new Fielder();
                fielder.setNameFirst(rs.getString("nameFirst"));
                fielder.setNameLast(rs.getString("nameLast"));
                fielder.setYearID(rs.getInt("yearID"));
                fielder.setTeamID(rs.getString("teamID"));
                fielder.setPos(rs.getString("POS"));
                fielder.getFielderStats().setsGamesPlayed(rs.getInt("sGamesPlayed"));
                fielder.getFielderStats().setsGamesStarted(rs.getInt("sGamesStarted"));
                fielder.getFielderStats().setsErrors(rs.getInt("sErrors"));
                fielder.getFielderStats().setsAssists(rs.getInt("sAssists"));
                fielder.getFielderStats().setsPutOuts(rs.getInt("sPutOuts"));
                fielder.getFielderStats().setsRunnersThrownOut(rs.getInt("sRunnersThrownOut"));
                fielder.getFielderStats().setsRunnersSuccessful(rs.getInt("sRunnersSuccessful"));
                fielder.getFielderStats().setFieldingPercentage(rs.getDouble("fielding"));

                fielderSeasons.add(fielder);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return fielderSeasons;
    }
}

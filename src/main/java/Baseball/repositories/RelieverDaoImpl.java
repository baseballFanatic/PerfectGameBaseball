package Baseball.repositories;

import Baseball.Reliever;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RelieverDaoImpl implements RelieverDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pgb_db";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Reliever> getAllRelievers() throws ClassNotFoundException {
        Connection conn;

        List<Reliever> relievers = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_reliever " +
                    " GROUP BY player_id");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reliever reliever = new Reliever();
                // Retrieve by column name
                reliever.setNameGiven(rs.getString("name_given"));
                reliever.setHands(rs.getString("hands"));
                reliever.setYearId(rs.getString("year_id"));
                reliever.setLgId(rs.getString("lg_id"));
                reliever.setTeamId(rs.getString("team_id"));
                reliever.setPlayerId(rs.getString("player_id"));

                relievers.add(reliever);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return relievers;
    }

    @Override
    public List<Reliever> getReliever(String playerId) throws ClassNotFoundException {
        Connection conn;

        List<Reliever> relievers = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_reliever " +
                    " where player_id=? ");
            stmt.setString(1, playerId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reliever reliever = new Reliever();
                // Retrieve by column name
                reliever.setNameGiven(rs.getString("name_given"));
                reliever.setHands(rs.getString("hands"));
                reliever.setYearId(rs.getString("year_id"));
                reliever.setLgId(rs.getString("lg_id"));
                reliever.setTeamId(rs.getString("team_id"));
                reliever.setPlayerId(rs.getString("player_id"));

                relievers.add(reliever);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return relievers;
    }
}

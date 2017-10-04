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
    public List<Reliever> getAllRelievers()
    {
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
                reliever.setWins( rs.getInt( "wins" ) );
                reliever.setLosses( rs.getInt( "losses" ) );
                reliever.setSaves( rs.getInt( "saves" ) );
                reliever.setGames( rs.getInt( "games" ) );
                reliever.setGamesStarted( rs.getInt( "games_started" ) );
                reliever.setHitsAgainst( rs.getInt( "hits_against" ) );

                relievers.add(reliever);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return relievers;
    }

    @Override
    public List<Reliever> getReliever(String playerId)
    {
        Connection conn;

        List<Reliever> relievers = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_reliever " +
                    " where player_id=? ORDER BY year_id ASC");
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
                reliever.setWins( rs.getInt( "wins" ) );
                reliever.setLosses( rs.getInt( "losses" ) );
                reliever.setSaves( rs.getInt( "saves" ) );
                reliever.setGames( rs.getInt( "games" ) );
                reliever.setGamesStarted( rs.getInt( "games_started" ) );
                reliever.setHitsAgainst( rs.getInt( "hits_against" ) );

                relievers.add(reliever);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return relievers;
    }
}

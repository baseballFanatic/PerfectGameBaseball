package Baseball.repositories;

import Baseball.Player;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pgb_db";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Player> getAllPlayers()
    {
        Connection conn;

        List<Player> players = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
/*            stmt = conn.prepareStatement("SELECT * from master " +
                    " GROUP BY player_id limit 10");*/
            stmt = conn.prepareStatement( "SELECT * FROM master " +
                    "WHERE player_id LIKE 'A%' GROUP BY player_id" );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                // Retrieve by column name
                player.setNameGiven(rs.getString("name_given"));
                player.setBirthYear(rs.getString("birth_year"));
                player.setBirthMonth(rs.getString("birth_month"));
                player.setBirthDay(rs.getString("birth_day"));
                player.setBirthCountry( rs.getString("birth_country") );
                player.setPlayerId(rs.getString("player_id"));
                player.setBirthState( rs.getString( "birth_state" ) );
                player.setBirthCity( rs.getString( "birth_city" ) );
                player.setDeathYear( rs.getString( "death_year" ) );
                player.setDeathMonth( rs.getString( "death_month" ) );
                player.setDeathDay( rs.getString( "death_day" ) );
                player.setDeathCountry( rs.getString( "death_country" ) );
                player.setDeathState( rs.getString( "death_state" ) );
                player.setDeathCity( rs.getString( "death_city" ) );
                player.setNameFirst( rs.getString( "name_first" ) );
                player.setNameLast( rs.getString( "name_last" ) );
                player.setWeight( rs.getInt( "weight" ) );
                player.setHeight( rs.getInt( "height" ) );

                players.add(player);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return players;
    }

    @Override
    public List<Player> getPlayer(String playerId)
    {
        Connection conn;

        List<Player> players = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from master " +
                    " where player_id=?");
            stmt.setString(1, playerId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                // Retrieve by column name
                player.setNameGiven(rs.getString("name_given"));
                player.setBirthYear(rs.getString("birth_year"));
                player.setBirthMonth(rs.getString("birth_month"));
                player.setBirthDay(rs.getString("birth_day"));
                player.setBirthCountry( rs.getString("birth_country") );
                player.setPlayerId(rs.getString("player_id"));
                player.setBirthState( rs.getString( "birth_state" ) );
                player.setBirthCity( rs.getString( "birth_city" ) );
                player.setDeathYear( rs.getString( "death_year" ) );
                player.setDeathMonth( rs.getString( "death_month" ) );
                player.setDeathDay( rs.getString( "death_day" ) );
                player.setDeathCountry( rs.getString( "death_country" ) );
                player.setDeathState( rs.getString( "death_state" ) );
                player.setDeathCity( rs.getString( "death_city" ) );
                player.setNameFirst( rs.getString( "name_first" ) );
                player.setNameLast( rs.getString( "name_last" ) );
                player.setWeight( rs.getInt( "weight" ) );
                player.setHeight( rs.getInt( "height" ) );

                players.add(player);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return players;
    }
}


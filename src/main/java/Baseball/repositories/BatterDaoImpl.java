package Baseball.repositories;

import Baseball.Batter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatterDaoImpl implements BatterDao
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pgb_db";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Batter> getAllBatters()
    {
        Connection conn;

        List<Batter> batters = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
/*            stmt = conn.prepareStatement("SELECT * from master " +
                    " GROUP BY player_id limit 10");*/
            stmt = conn.prepareStatement( "SELECT * FROM pgbs_batters " +
                    "WHERE player_id LIKE 'A%' GROUP BY player_id" );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Batter batter = new Batter();
                // Retrieve by column name

                batter.setNameFirst( rs.getString( "name_first" ) );
                batter.setNameLast( rs.getString( "name_last" ) );
                batter.setPlayerId( rs.getString( "player_id" ) );

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
    public List<Batter> getHomeRunLeaders()
    {
        return null;
    }

    @Override
    public List<Batter> getRbiLeaders()
    {
        return null;
    }

    @Override
    public List<Batter> getRunsLeaders()
    {
        return null;
    }

    @Override
    public List<Batter> getBattingAverageLeaders()
    {
        return null;
    }

    @Override
    public List<Batter> getStolenBasesLeaders()
    {
        return null;
    }

/*    @Override
    public List<Batter> getHomeRunLeaders()
    {
        Connection conn;

        List<Batter> batters = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
*//*            stmt = conn.prepareStatement("SELECT * from pgbs_batter " +
                    " where year_id=?");
            stmt.setString(1, playerId);*//*

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
    }*/
}

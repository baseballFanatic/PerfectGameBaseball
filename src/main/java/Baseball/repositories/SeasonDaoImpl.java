package Baseball.repositories;

import Baseball.Season;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeasonDaoImpl implements SeasonDao
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Season> getYears( Object username )
    {
        Connection conn;

        List<Season> seasons = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT yearID from pgbs_season_reference where simName = ?" +
                    "ORDER BY yearID DESC");

            stmt.setString( 1, (String) username );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Season season = new Season();
                // Retrieve by column name
                season.setYearID( rs.getInt( "yearID" ) );

                seasons.add(season);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return seasons;
    }
}

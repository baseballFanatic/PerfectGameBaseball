package Baseball.repositories;

import Baseball.Users;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<Users> getUsers()
    {
        Connection conn;

        List<Users> users = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT username from pgbs_registry " +
                    "ORDER BY username ASC");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Users user = new Users();
                // Retrieve by column name
                user.setUsername( rs.getString( "username" ) );

                users.add(user);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }
}

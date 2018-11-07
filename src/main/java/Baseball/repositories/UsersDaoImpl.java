package Baseball.repositories;

import Baseball.StringSupport;
import Baseball.Users;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
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
    private Users registeredUser;

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

    @Override
    public boolean checkUser(String user)
    {
        List<Users> validUsers = getUsers();
        for ( Users userToCheck : validUsers ) {

            if ( StringSupport.safeEqual( user, userToCheck.getUsername() ) ) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void addUser (HttpSession session )
    {
        Connection conn;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO pgbs_registry(username, email, password, firstName, " +
                    "lastName, active, mostRecentYear) values (?, ?, ?, ?, ?, ?, ?)");
            stmt.setObject(1, session.getAttribute("username"));
            stmt.setString(2, "");
            stmt.setString(3, "");
            stmt.setObject(4, session.getAttribute("firstName"));
            stmt.setObject(5, session.getAttribute("lastName"));
            stmt.setObject(6, session.getAttribute("active"));
            stmt.setObject(7, session.getAttribute("mostRecentYear"));

            int rs = stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getUser( String user )
    {
        Connection conn;

/*        List<Users> returnedUsers = new ArrayList<>();*/
        Users returnedUser = new Users();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_registry " +
                    "where username=?");
            stmt.setString( 1, user );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
/*                Users requestedUser = new Users();*/
                // Retrieve by column name
                returnedUser.setUsername( rs.getString( "username" ) );
                returnedUser.setRecentYear( rs.getInt( "mostRecentYear" ) );
                returnedUser.setFirstName( rs.getString( "firstName" ) );
                returnedUser.setLastName( rs.getString( "lastName" ) );
                returnedUser.setActive( rs.getString( "active" ) );

/*                returnedUser.add(returnedUser);*/
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnedUser;
    }
}

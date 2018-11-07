package Baseball.repositories;

import Baseball.Users;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UsersDao
{
    List<Users> getUsers();

    boolean checkUser(String user);

    Users getUser( String user);

    void addUser (HttpSession session );
}

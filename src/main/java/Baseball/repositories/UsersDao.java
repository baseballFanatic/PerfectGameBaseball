package Baseball.repositories;

import Baseball.Users;

import java.util.List;

public interface UsersDao
{
    List<Users> getUsers();

    boolean checkUser(String user);

    List<Users> getUser(String user);
}

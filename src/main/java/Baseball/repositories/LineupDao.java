package Baseball.repositories;

import Baseball.LineUp;

import java.util.List;

public interface LineupDao
{
    List<LineUp> getLineupByGameKey ( int gameKey );
}

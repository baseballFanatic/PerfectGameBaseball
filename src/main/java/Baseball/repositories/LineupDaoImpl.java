package Baseball.repositories;

import Baseball.LineUp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LineupDaoImpl implements LineupDao
{
    @Override
    public List<LineUp> getLineupByGameKey( int gameKey )
    {
        return null;
    }
}

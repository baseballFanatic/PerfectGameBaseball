package Baseball.repositories;

import Baseball.Batter;

import java.util.List;

public interface BatterDao
{
    List<Batter> getAllBattersByYear( String yearId );

    List<Batter> getBatter( String playerId );
}

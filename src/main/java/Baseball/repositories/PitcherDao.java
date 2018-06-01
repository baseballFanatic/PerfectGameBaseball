package Baseball.repositories;

import Baseball.Pitcher;

import java.util.List;

public interface PitcherDao
{
    List<Pitcher> getAllPitchersByYear( String yearID );

    List<Pitcher> getPitcher ( String yearID );
}

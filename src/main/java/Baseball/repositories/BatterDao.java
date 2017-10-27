package Baseball.repositories;

import Baseball.Batter;

import java.util.List;

public interface BatterDao
{
    List<Batter> getAllBatters();

    List<Batter> getBatter( String playerId );

    List<Batter> getHomeRunLeaders();

    List<Batter> getRbiLeaders();

    List<Batter> getRunsLeaders();

    List<Batter> getBattingAverageLeaders();

    List<Batter> getStolenBasesLeaders();
}

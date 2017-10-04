package Baseball.repositories;

import Baseball.Reliever;

import java.util.List;

public interface RelieverDao {
    List<Reliever> getAllRelievers();
    List<Reliever> getReliever( String playerId );
}

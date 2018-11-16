package Baseball.repositories;

import Baseball.Fielder;
import java.util.List;

public interface FielderDao {

    List<Fielder> getStatsByPlayerId ( String playerId );
}

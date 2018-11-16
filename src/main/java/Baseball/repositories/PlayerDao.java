package Baseball.repositories;

import Baseball.Batter;
import Baseball.Player;

import java.util.List;

public interface PlayerDao {
    List<Player> getAllPlayers();

    List<Player> getPlayer(String playerId);

    List<Player> getPlayerByLastNameByYear(String lastName, String yearId);


}

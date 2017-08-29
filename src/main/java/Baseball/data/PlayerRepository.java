package Baseball.data;

import Baseball.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PlayerRepository {
    private static final List<Player> ALL_PLAYERS = Arrays.asList(
            new Player("Clitn", "Riggan", "crigga01"),
            new Player("James", "Sutherland", "jsuther01"),
            new Player("Luc", "Sutherland", "lsuther01"),
            new Player("Mitch", "Maynard", "mmayna01")
    );

    public Player findByName(String name) {
        for (Player player : ALL_PLAYERS) {
            if (player.getNameFirst().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getAllPlayers() { return ALL_PLAYERS; }

    public List<Player> findByPlayerId(String playerId) {
        List<Player> players = new ArrayList<>();
        for(Player player : ALL_PLAYERS) {
            if(player.getPlayerId().equals(playerId)){
                players.add(player);
            }
        }
        return players;
    }
}

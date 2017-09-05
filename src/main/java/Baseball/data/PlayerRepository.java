package Baseball.data;

import Baseball.Player;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Component
public class PlayerRepository {
    private static final List<Player> ALL_PLAYERS = Arrays.asList(
        new Player("Clint", "Riggan", "criggan01"),
        new Player("James", "Sutherland", "jsutherl01"),
        new Player("Luke", "Sutherland", "lsutherl01"),
        new Player("Matt", "Hepburn", "mhepburn01")
    );

    public PlayerRepository() throws ClassNotFoundException, SQLException, InstantiationException {
    }

    public Player findByName(String name) {
        for(Player player : ALL_PLAYERS) {
            if(player.getNameFirst().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public static Player findByPlayerId(String playerId) {
        for(Player player : ALL_PLAYERS) {
            if(player.getPlayerId().equals(playerId)) {
                return player;
            }
        }
        return null;
    }

    public static List<Player> getAllPlayers() {
        return ALL_PLAYERS;
    }
}

package Baseball.data;
/*
import Baseball.Reliever;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RelieverRepository {
    private static final List<Reliever> ALL_RELIEVERS = Arrays.asList(
        new Reliever("Clint", "Riggan", "Clint Riggan", "crigga01"),
        new Reliever("James", "Sutherland", "James Sutherland", "jsuther01"),
        new Reliever("Luc", "Sutherland", "Luc Sutherland", "lsuther01"),
        new Reliever("Mitch", "Maynard", "Mitch Maynard", "mmayna01"),
        new Reliever("Tyler", "Wood", "Tyler Wood", "twood01")
    );

    public Reliever findByName(String name) {
        for(Reliever reliever : ALL_RELIEVERS) {
            if(reliever.getNameFirst().equals(name)) {
                return reliever;
            }
        }
        return null;
    }
}*/

import Baseball.Reliever;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelieverRepository extends CrudRepository<Reliever, Long> {

    Reliever findByPlayerId(String playerId);
}

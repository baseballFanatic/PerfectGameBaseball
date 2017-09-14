package Baseball.repositories;

import Baseball.Reliever;

import java.util.List;

public interface RelieverDao {
    public List<Reliever> getAllRelievers() throws ClassNotFoundException;
    public List<Reliever> getReliever(String playerId) throws ClassNotFoundException;
}

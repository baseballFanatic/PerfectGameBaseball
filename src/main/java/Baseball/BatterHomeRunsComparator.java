package Baseball;

import java.util.Comparator;

public class BatterHomeRunsComparator implements Comparator<Batter>{
    @Override
    public int compare(Batter batter1, Batter batter2)
    {
        return Double.compare(batter2.getBatterStats().getHomeRuns(),batter1.getBatterStats().getHomeRuns());
//        return batter1.getBatterStats().getHomeRuns() - batter2.getBatterStats().getHomeRuns();
    }
}

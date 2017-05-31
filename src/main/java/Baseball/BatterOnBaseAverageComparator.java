package Baseball;

import java.util.Comparator;

public class BatterOnBaseAverageComparator implements Comparator<Batter> {
    @Override
    public int compare (Batter batter1, Batter batter2)
    {
        return Double.compare(batter2.getBatterStats().getOnBasePercentage(), batter1.getBatterStats().getOnBasePercentage());
    }
}

package Baseball;

import java.util.Comparator;

public class BatterBattingAverageComparator implements Comparator<Batter>{
    @Override
    public int compare(Batter batter1, Batter batter2)
    {
        return Double.compare(batter2.getBatterStats().getBattingAverage(), batter1.getBatterStats().getBattingAverage());
        //return batter1.getBatterStats().getBattingAverage() - batter2.getBatterStats().getBattingAverage();
    }
}

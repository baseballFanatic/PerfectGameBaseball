package Baseball;

import java.util.Comparator;

class BatterStolenBasesComparator implements Comparator<Batter> {
    @Override
    public int compare(Batter batter1, Batter batter2)
    {
        return batter2.getBatterStats().getStolenBases() - batter1.getBatterStats().getStolenBases();
    }
}

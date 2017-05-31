package Baseball;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BatterChainedComparator implements Comparator<Batter>{
    private List<Comparator<Batter>> listComparators;

    @SafeVarargs
    public BatterChainedComparator(Comparator<Batter>... comparators)
    {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Batter batter1, Batter batter2)
    {
        for (Comparator<Batter> comparator : listComparators)
        {
            int result = comparator.compare(batter1, batter2);
            if (result != 0)
            {
                return result;
            }
        }
        return 0;
    }
}

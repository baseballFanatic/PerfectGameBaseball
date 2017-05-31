package Baseball;

import java.util.*;

class LineUp {
    private int battingOrder;
    private int visitorBattingNumber;
    private int homeBattingNumber;

    LineUp() {
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    int getVisitorBattingNumber() {
        return visitorBattingNumber;
    }

    void setVisitorBattingNumber(int visitorBattingNumber) {
        this.visitorBattingNumber = visitorBattingNumber;
    }

    int getHomeBattingNumber() {
        return homeBattingNumber;
    }

    void setHomeBattingNumber(int homeBattingNumber) {
        this.homeBattingNumber = homeBattingNumber;
    }

    List<Batter> optimizeLineUp(List<Batter> lineUp)
    {
        List<Batter> optimizedLineUp = new ArrayList<>();

        lineUp.sort(new BatterChainedComparator(
                new BatterStolenBasesComparator()
        ));

        for (int o = 0; o < 1; o++)
        {
            optimizedLineUp.add(lineUp.get(o));
            lineUp.get(o).setBattingOrder(1);
            lineUp.remove(lineUp.get(o));
        }

        List<Batter> lineUpOba = lineUp;

        lineUpOba.sort(new BatterChainedComparator(
                new BatterOnBaseAverageComparator()
        ));

        for (Batter batter : lineUpOba)
        {
            if (batter.getBatterStats().getHomeRuns() < 25)
            {
                optimizedLineUp.add(batter);
                batter.setBattingOrder(2);
                lineUpOba.remove(batter);
                break;
            }
        }

        List<Batter> lineUpHr = lineUpOba;

        lineUpHr.sort(new BatterChainedComparator(
                new BatterHomeRunsComparator()
        ));

        for (int o = 3; o < 10; o++)
        {
            optimizedLineUp.add(lineUpHr.get(o));
            lineUpHr.get(o).setBattingOrder(o);
            lineUpHr.remove(lineUpHr.get(o));
        }

        return optimizedLineUp;
    }
}





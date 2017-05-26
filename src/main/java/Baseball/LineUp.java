package Baseball;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    Set<Batter> optimizeLineUp(List<Batter> lineUp)
    {
        Set<Batter> set = new TreeSet<Batter>();

        set.addAll(lineUp);

        return set;
    }
}





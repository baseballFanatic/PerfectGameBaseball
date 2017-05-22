package Baseball;

public class Base {
    private Batter batter;
    private boolean occupied;


    boolean isOccupied() {
        return occupied;
    }

    public Batter getBatter() {
        return batter;
    }

    private void setBatter(Batter batter) {
        this.batter = batter;
    }

    void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    void occupy(Batter batter) {
        setBatter(batter);
        setOccupied(true);
    }
}

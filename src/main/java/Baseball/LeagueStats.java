package Baseball;

public class LeagueStats {
    private double walkPercentage = .0536;
    private double singlePercentage = .2428;
    private double doublePercentage = .0465;
    private double triplePercentage = .0076;
    private double homeRunPercentage = .0204;
    private double strikeOutPercentage = .209;

/*    public LeagueStats(double walkPercentage, double singlePercentage, double doublePercentage, double triplePercentage, double homeRunPercentage, double strikeOutPercentage) {
        this.walkPercentage = walkPercentage;
        this.singlePercentage = singlePercentage;
        this.doublePercentage = doublePercentage;
        this.triplePercentage = triplePercentage;
        this.homeRunPercentage = homeRunPercentage;
        this.strikeOutPercentage = strikeOutPercentage;
    }*/

    public double getWalkPercentage() {
        return walkPercentage;
    }

    public void setWalkPercentage(double walkPercentage) {
        this.walkPercentage = walkPercentage;
    }

    public double getSinglePercentage() {
        return singlePercentage;
    }

    public void setSinglePercentage(double singlePercentage) {
        this.singlePercentage = singlePercentage;
    }

    public double getDoublePercentage() {
        return doublePercentage;
    }

    public void setDoublePercentage(double doublePercentage) {
        this.doublePercentage = doublePercentage;
    }

    public double getTriplePercentage() {
        return triplePercentage;
    }

    public void setTriplePercentage(double triplePercentage) {
        this.triplePercentage = triplePercentage;
    }

    public double getHomeRunPercentage() {
        return homeRunPercentage;
    }

    public void setHomeRunPercentage(double homeRunPercentage) {
        this.homeRunPercentage = homeRunPercentage;
    }

    public double getStrikeOutPercentage() {
        return strikeOutPercentage;
    }

    public void setStrikeOutPercentage(double strikeOutPercentage) {
        this.strikeOutPercentage = strikeOutPercentage;
    }
}

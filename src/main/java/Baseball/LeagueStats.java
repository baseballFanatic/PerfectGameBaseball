package Baseball;

class LeagueStats {
/*    private double walkPercentage = .0536;
    private double singlePercentage = .2428;
    private double doublePercentage = .0465;
    private double triplePercentage = .0076;
    private double homeRunPercentage = .0204;
    private double strikeOutPercentage = .209;*/
    private double atBats, hits, doubles, triples, homeRuns, walks, strikeOuts, singles, walkPercentage, singlePercentage,
        triplePercentage, homeRunPercentage, strikeOutPercentage, doublePercentage;

/*    public LeagueStats(double walkPercentage, double singlePercentage, double doublePercentage, double triplePercentage, double homeRunPercentage, double strikeOutPercentage) {
        this.walkPercentage = walkPercentage;
        this.singlePercentage = singlePercentage;
        this.doublePercentage = doublePercentage;
        this.triplePercentage = triplePercentage;
        this.homeRunPercentage = homeRunPercentage;
        this.strikeOutPercentage = strikeOutPercentage;
    }*/

    public double getSingles() {
        return singles;
    }

    public void setSingles(double singles) {
        this.singles = singles;
    }

    public double getAtBats() {
        return atBats;
    }

    public void setAtBats(double atBats) {
        this.atBats = atBats;
    }

    public double getHits() {
        return hits;
    }

    public void setHits(double hits) {
        this.hits = hits;
    }

    public double getDoubles() {
        return doubles;
    }

    public void setDoubles(double doubles) {
        this.doubles = doubles;
    }

    public double getTriples() {
        return triples;
    }

    public void setTriples(double triples) {
        this.triples = triples;
    }

    public double getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(double homeRuns) {
        this.homeRuns = homeRuns;
    }

    public double getWalks() {
        return walks;
    }

    public void setWalks(double walks) {
        this.walks = walks;
    }

    public double getStrikeOuts() {
        return strikeOuts;
    }

    public void setStrikeOuts(double strikeOuts) {
        this.strikeOuts = strikeOuts;
    }

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

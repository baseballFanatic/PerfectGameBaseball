package Baseball;

class PitcherStats {
    private double inningsPitched, hitsAllowed, homeRunsAllowed, walksAllowed, strikeOutsAllowed, battersFaced,
            probabilityHomeRun, probabilityTriple, probabilityDouble, probabilitySingle, probabilityWalk,
            probabilityStrikeOut, probabilityHitBatter ;

    private int earnedRuns, gameBattersFaced, gameHitsAllowed, hitBatters,
            gameRunsAllowed, gameStrikeOutsAllowed, gameWalksAllowed, gameHomeRunsAllowed, gameEarnedRunsAllowed,
            gameUnearnedRunsAllowed, unearnedRunsAllowed, gameHitByPitch, gameInningsPitchedOuts;

    private double getInningsPitched() {
        return inningsPitched;
    }

    void setInningsPitched(double inningsPitched) {
        this.inningsPitched = inningsPitched;
    }

    int getGameInningsPitchedOuts() {
        return gameInningsPitchedOuts;
    }

    void setGameInningsPitchedOuts(int gameInningsPitchedOuts) {
        this.gameInningsPitchedOuts = gameInningsPitchedOuts;
    }

    private double getHitsAllowed() {
        return hitsAllowed;
    }

    void setHitsAllowed(double hitsAllowed) {
        this.hitsAllowed = hitsAllowed;
    }

    private double getHomeRunsAllowed() {
        return homeRunsAllowed;
    }

    void setHomeRunsAllowed(double homeRunsAllowed) {
        this.homeRunsAllowed = homeRunsAllowed;
    }

    private double getWalksAllowed() {
        return walksAllowed;
    }

    void setWalksAllowed(double walksAllowed) {
        this.walksAllowed = walksAllowed;
    }

    private double getStrikeOutsAllowed() {
        return strikeOutsAllowed;
    }

    void setStrikeOutsAllowed(double strikeOutsAllowed) {
        this.strikeOutsAllowed = strikeOutsAllowed;
    }

    private double getBattersFaced() {
        return battersFaced;
    }

    private void setBattersFaced(double battersFaced) {
        this.battersFaced = battersFaced;
    }

    double getProbabilityHomeRun() {
        return probabilityHomeRun;
    }

    private void setProbabilityHomeRun(double probabilityHomeRun) {
        this.probabilityHomeRun = probabilityHomeRun;
    }

    double getProbabilityTriple() {
        return probabilityTriple;
    }

    private void setProbabilityTriple(double probabilityTriple) {
        this.probabilityTriple = probabilityTriple;
    }

    double getProbabilityDouble() {
        return probabilityDouble;
    }

    private void setProbabilityDouble(double probabilityDouble) {
        this.probabilityDouble = probabilityDouble;
    }

    public double getProbabilitySingle() {
        return probabilitySingle;
    }

    private void setProbabilitySingle(double probabilitySingle) {
        this.probabilitySingle = probabilitySingle;
    }

    public double getProbabilityWalk() {
        return probabilityWalk;
    }

    private void setProbabilityWalk(double probabilityWalk) {
        this.probabilityWalk = probabilityWalk;
    }

    public double getProbabilityStrikeOut() {
        return probabilityStrikeOut;
    }

    private void setProbabilityStrikeOut(double probabilityStrikeOut) {
        this.probabilityStrikeOut = probabilityStrikeOut;
    }

    public int getEarnedRuns() {
        return earnedRuns;
    }

    private void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    public void setGameBattersFaced(int gameBattersFaced) {
        this.gameBattersFaced = gameBattersFaced;
    }

    public void setGameHitsAllowed(int gameHitsAllowed) {
        this.gameHitsAllowed = gameHitsAllowed;
    }

    public void setGameRunsAllowed(int gameRunsAllowed) {
        this.gameRunsAllowed = gameRunsAllowed;
    }

    public void setGameStrikeOutsAllowed(int gameStrikeOutsAllowed) {
        this.gameStrikeOutsAllowed = gameStrikeOutsAllowed;
    }

    public int getGameHitByPitch() {
        return gameHitByPitch;
    }

    public void setGameHitByPitch(int gameHitByPitch) {
        this.gameHitByPitch = gameHitByPitch;
    }

    public void setGameWalksAllowed(int gameWalksAllowed) {
        this.gameWalksAllowed = gameWalksAllowed;
    }

    public void setGameHomeRunsAllowed(int gameHomeRunsAllowed) {
        this.gameHomeRunsAllowed = gameHomeRunsAllowed;
    }

    public int getGameEarnedRunsAllowed() {
        return gameEarnedRunsAllowed;
    }

    public void setGameEarnedRunsAllowed(int gameEarnedRunsAllowed) {
        this.gameEarnedRunsAllowed = gameEarnedRunsAllowed;
    }

    public double getProbabilityHitBatter() {
        return probabilityHitBatter;
    }

    public int getGameBattersFaced() {
        return gameBattersFaced;
    }

    public int getGameHitsAllowed() {
        return gameHitsAllowed;
    }

    public int getGameRunsAllowed() {
        return gameRunsAllowed;
    }

    public int getGameStrikeOutsAllowed() {
        return gameStrikeOutsAllowed;
    }

    public int getGameWalksAllowed() {
        return gameWalksAllowed;
    }

    private void setProbabilityHitBatter(double probabilityHitBatter) {
        this.probabilityHitBatter = probabilityHitBatter;
    }

    public int getGameHomeRunsAllowed() {
        return gameHomeRunsAllowed;
    }

    public int getGameUnearnedRunsAllowed() {
        return gameUnearnedRunsAllowed;
    }

    public void setGameUnearnedRunsAllowed(int gameUnearnedRunsAllowed) {
        this.gameUnearnedRunsAllowed = gameUnearnedRunsAllowed;
    }

    public int getUnearnedRunsAllowed() {
        return unearnedRunsAllowed;
    }

    private void setUnearnedRunsAllowed(int unearnedRunsAllowed) {
        this.unearnedRunsAllowed = unearnedRunsAllowed;
    }

    public void calculatePitcherProbabilities() {
        setBattersFaced((getInningsPitched() * 3) + getHitsAllowed() + getWalksAllowed());
        setProbabilityHomeRun(getHomeRunsAllowed() / getBattersFaced());
        setProbabilityTriple((getHitsAllowed() * .024) / getBattersFaced());
        setProbabilityDouble((getHitsAllowed() * .174) / getBattersFaced());
        setProbabilitySingle((getHitsAllowed() / getBattersFaced()) - getProbabilityHomeRun() - getProbabilityTriple() - getProbabilityDouble());
        setProbabilityWalk(getWalksAllowed() /getBattersFaced());
        setProbabilityStrikeOut(getStrikeOutsAllowed() / getBattersFaced());
        setProbabilityHitBatter(getHitBatters() / getBattersFaced());
    }

    public void updatePitcherStats(int gameBattersFaced, int gameHitsAllowed, int gameStrikeOutsAllowed, int gameWalksAllowed,
                                   int gameEarnedRunsAllowed, int gameUnearnedRunsAllowed) {
        setBattersFaced(getGameBattersFaced() + gameBattersFaced);
        setHitsAllowed(getGameHitsAllowed()+ gameHitsAllowed);
        setStrikeOutsAllowed(getGameStrikeOutsAllowed() + gameStrikeOutsAllowed);
        setWalksAllowed((getGameWalksAllowed() + gameWalksAllowed));
        setEarnedRuns(getGameEarnedRunsAllowed() + gameEarnedRunsAllowed);
        setUnearnedRunsAllowed(getGameUnearnedRunsAllowed() + gameUnearnedRunsAllowed);

    }


    private int getHitBatters() {
        return hitBatters;
    }

    public void setHitBatters(int hitBatters) {
        this.hitBatters = hitBatters;
    }

    public void outNoRuns() {
        setBattersFaced(getGameBattersFaced() + 1);
    }

    public void outRunScored(Base baseRunner, Pitcher pitcher) {
        if (baseRunner.getBatter().getBatterStats().isRunEarned()) {
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameEarnedRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameEarnedRunsAllowed() + 1);
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameRunsAllowed() + 1);

        } else{
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameUnearnedRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameUnearnedRunsAllowed() + 1);
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameRunsAllowed() + 1);
            baseRunner.getBatter().getBatterStats().setRunEarned(true);
        }
    }

    public void hitRunScores(Base baseRunner, Pitcher pitcher) {
        if (baseRunner.getBatter().getBatterStats().isRunEarned()) {
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameEarnedRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameEarnedRunsAllowed() + 1);
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameRunsAllowed() + 1);

        } else{
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameUnearnedRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameUnearnedRunsAllowed() + 1);
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameRunsAllowed() + 1);
            baseRunner.getBatter().getBatterStats().setRunEarned(true);
        }
    }

}

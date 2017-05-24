package Baseball;

class BatterStats {
    private double atBats, hits, doubles, triples, homeRuns, walks, strikeOuts, plateAppearances, probabilityWalk,
            probabilitySingle, probabilityDouble, probabilityTriple, probabilityHomeRun, probabilityStrikeOut,
            stolenBaseAttempt = .1973, stolenBaseSuccess = .833, onBasePercentage = .359;
    private int gamesPlayed, runs, rbi, intentionalWalks, hitByPitch, sacrificeHits, speedRating, stolenBases,
            sacrificeFlies, groundedIntoDp, sGamesPlayed, sGamesStarted, sAtBats, sHits, sRuns, caughtStealing,
            sDoubles, sTriples, sHomeRuns, sRbi, sWalks, sStrikeOuts, sHitByPitch,
            sPlateAppearances, sSacrificeHits, sSacrificeFlies, gameDate, histPercentPlayed, actualPlayPercent,
            awardPoints, pinchAtBat, pinchHit, pinchRbi, rispAtBat, rispHit, rispRbi, rispSingle, rispDouble, rispTriple,
            rispHomeRun, rispWalk, rispStrikeOut, rispGroundedIntoDp, rispHitByPitch, leftOnBase, gameGamePlayed,
            gameGameStarted, gameAtBats, gameHits, gameRuns, gameRbi, gameSingle, gameDouble, gameTriple, gameHomeRun,
            gameWalk, gameStrikeOut, gameHitByPitch, gameGidp, gameLeftOnBase, gameRispAtBat, gameRispHit, gameRispSingle,
            gameRispDouble, gameRispTriple, gameRispHomeRun, gameRispRbi, gameRispStrikeOut, gameRispWalk,
            gameSacrificeFly, gameSacrificeHit, gameRispSacrificeFly, gamePlateAppearance, gameStolenBases,
            gameCaughtStealing, sStolenBases, sCaughtStealing, gameRispGidp, yearID;

    public int getYearID() {
        return yearID;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    private boolean isRunEarned = true;

    public int getPinchRbi() {
        return pinchRbi;
    }

    public void setPinchRbi(int pinchRbi) {
        this.pinchRbi = pinchRbi;
    }

    double getOnBasePercentage() {
        return onBasePercentage;
    }

    public void setOnBasePercentage(double onBasePercentage) {
        this.onBasePercentage = onBasePercentage;
    }

    int getGameRispGidp() {
        return gameRispGidp;
    }

    void setGameRispGidp(int gameRispGidp) {
        this.gameRispGidp = gameRispGidp;
    }

    private double getAtBats() {
        return atBats;
    }

    void setAtBats(double atBats) {
        this.atBats = atBats;
    }

    private double getHits() {
        return hits;
    }

    void setHits(double hits) {
        this.hits = hits;
    }

    private double getDoubles() {
        return doubles;
    }

    void setDoubles(double doubles) {
        this.doubles = doubles;
    }

    private double getTriples() {
        return triples;
    }

    void setTriples(double triples) {
        this.triples = triples;
    }

    private double getHomeRuns() {
        return homeRuns;
    }

    void setHomeRuns(double homeRuns) {
        this.homeRuns = homeRuns;
    }

    private double getWalks() {
        return walks;
    }

    void setWalks(double walks) {
        this.walks = walks;
    }

    private double getStrikeOuts() {
        return strikeOuts;
    }

    void setStrikeOuts(double strikeOuts) {
        this.strikeOuts = strikeOuts;
    }

    private double getPlateAppearances() {
        return plateAppearances;
    }

    private void setPlateAppearances(double plateAppearances) {
        this.plateAppearances = plateAppearances;
    }

    double getProbabilityWalk() {
        return probabilityWalk;
    }

    private void setProbabilityWalk(double probabilityWalk) {
        this.probabilityWalk = probabilityWalk;
    }

    double getProbabilitySingle() {
        return probabilitySingle;
    }

    private void setProbabilitySingle(double probabilitySingle) {
        this.probabilitySingle = probabilitySingle;
    }

    double getProbabilityDouble() {
        return probabilityDouble;
    }

    private void setProbabilityDouble(double probabilityDouble) {
        this.probabilityDouble = probabilityDouble;
    }

    double getProbabilityTriple() {
        return probabilityTriple;
    }

    private void setProbabilityTriple(double probabilityTriple) {
        this.probabilityTriple = probabilityTriple;
    }

    double getProbabilityHomeRun() {
        return probabilityHomeRun;
    }

    private void setProbabilityHomeRun(double probabilityHomeRun) {
        this.probabilityHomeRun = probabilityHomeRun;
    }

    double getProbabilityStrikeOut() {
        return probabilityStrikeOut;
    }

    private void setProbabilityStrikeOut(double probabilityStrikeOut) {
        this.probabilityStrikeOut = probabilityStrikeOut;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getRbi() {
        return rbi;
    }

    public void setRbi(int rbi) {
        this.rbi = rbi;
    }

    public int getIntentionalWalks() {
        return intentionalWalks;
    }

    public void setIntentionalWalks(int intentionalWalks) {
        this.intentionalWalks = intentionalWalks;
    }

    public int getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(int hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public int getSacrificeHits() {
        return sacrificeHits;
    }

    public void setSacrificeHits(int sacrificeHits) {
        this.sacrificeHits = sacrificeHits;
    }

    public int getSacrificeFlies() {
        return sacrificeFlies;
    }

    public void setSacrificeFlies(int sacrificeFlies) {
        this.sacrificeFlies = sacrificeFlies;
    }

    public int getGroundedIntoDp() {
        return groundedIntoDp;
    }

    public void setGroundedIntoDp(int groundedIntoDp) {
        this.groundedIntoDp = groundedIntoDp;
    }

    public int getsGamesPlayed() {
        return sGamesPlayed;
    }

    public void setsGamesPlayed(int sGamesPlayed) {
        this.sGamesPlayed = sGamesPlayed;
    }

    public int getsGamesStarted() {
        return sGamesStarted;
    }

    public void setsGamesStarted(int sGamesStarted) {
        this.sGamesStarted = sGamesStarted;
    }

    public int getsAtBats() {
        return sAtBats;
    }

    public void setsAtBats(int sAtBats) {
        this.sAtBats = sAtBats;
    }

    public int getsHits() {
        return sHits;
    }

    public void setsHits(int sHits) {
        this.sHits = sHits;
    }

    public int getsRuns() {
        return sRuns;
    }

    public void setsRuns(int sRuns) {
        this.sRuns = sRuns;
    }

    public int getsDoubles() {
        return sDoubles;
    }

    public void setsDoubles(int sDoubles) {
        this.sDoubles = sDoubles;
    }

    public int getsTriples() {
        return sTriples;
    }

    public void setsTriples(int sTriples) {
        this.sTriples = sTriples;
    }

    public int getsHomeRuns() {
        return sHomeRuns;
    }

    public void setsHomeRuns(int sHomeRuns) {
        this.sHomeRuns = sHomeRuns;
    }

    public int getsRbi() {
        return sRbi;
    }

    public void setsRbi(int sRbi) {
        this.sRbi = sRbi;
    }

    public int getsWalks() {
        return sWalks;
    }

    public void setsWalks(int sWalks) {
        this.sWalks = sWalks;
    }

    public int getsStrikeOuts() {
        return sStrikeOuts;
    }

    public void setsStrikeOuts(int sStrikeOuts) {
        this.sStrikeOuts = sStrikeOuts;
    }

    public int getsHitByPitch() {
        return sHitByPitch;
    }

    public void setsHitByPitch(int sHitByPitch) {
        this.sHitByPitch = sHitByPitch;
    }

    public int getsStolenBases() {
        return sStolenBases;
    }

    public void setsStolenBases(int sStolenBases) {
        this.sStolenBases = sStolenBases;
    }

    public int getsCaughtStealing() {
        return sCaughtStealing;
    }

    public void setsCaughtStealing(int sCaughtStealing) {
        this.sCaughtStealing = sCaughtStealing;
    }

    public int getsPlateAppearances() {
        return sPlateAppearances;
    }

    public void setsPlateAppearances(int sPlateAppearances) {
        this.sPlateAppearances = sPlateAppearances;
    }

    public int getsSacrificeHits() {
        return sSacrificeHits;
    }

    public void setsSacrificeHits(int sSacrificeHits) {
        this.sSacrificeHits = sSacrificeHits;
    }

    public int getsSacrificeFlies() {
        return sSacrificeFlies;
    }

    public void setsSacrificeFlies(int sSacrificeFlies) {
        this.sSacrificeFlies = sSacrificeFlies;
    }

    public int getGameDate() {
        return gameDate;
    }

    public void setGameDate(int gameDate) {
        this.gameDate = gameDate;
    }

    public int getHistPercentPlayed() {
        return histPercentPlayed;
    }

    public void setHistPercentPlayed(int histPercentPlayed) {
        this.histPercentPlayed = histPercentPlayed;
    }

    public int getActualPlayPercent() {
        return actualPlayPercent;
    }

    public void setActualPlayPercent(int actualPlayPercent) {
        this.actualPlayPercent = actualPlayPercent;
    }

    public int getAwardPoints() {
        return awardPoints;
    }

    public void setAwardPoints(int awardPoints) {
        this.awardPoints = awardPoints;
    }

    public int getPinchAtBat() {
        return pinchAtBat;
    }

    public void setPinchAtBat(int pinchAtBat) {
        this.pinchAtBat = pinchAtBat;
    }

    public int getPinchHit() {
        return pinchHit;
    }

    public void setPinchHit(int pinchHit) {
        this.pinchHit = pinchHit;
    }

    public int getRispAtBat() {
        return rispAtBat;
    }

    public void setRispAtBat(int rispAtBat) {
        this.rispAtBat = rispAtBat;
    }

    public int getRispHit() {
        return rispHit;
    }

    public void setRispHit(int rispHit) {
        this.rispHit = rispHit;
    }

    public int getRispRbi() {
        return rispRbi;
    }

    public void setRispRbi(int rispRbi) {
        this.rispRbi = rispRbi;
    }

    public int getRispSingle() {
        return rispSingle;
    }

    public void setRispSingle(int rispSingle) {
        this.rispSingle = rispSingle;
    }

    public int getRispDouble() {
        return rispDouble;
    }

    public void setRispDouble(int rispDouble) {
        this.rispDouble = rispDouble;
    }

    public int getRispTriple() {
        return rispTriple;
    }

    public void setRispTriple(int rispTriple) {
        this.rispTriple = rispTriple;
    }

    public int getRispHomeRun() {
        return rispHomeRun;
    }

    public void setRispHomeRun(int rispHomeRun) {
        this.rispHomeRun = rispHomeRun;
    }

    public int getRispWalk() {
        return rispWalk;
    }

    public void setRispWalk(int rispWalk) {
        this.rispWalk = rispWalk;
    }

    public int getRispStrikeOut() {
        return rispStrikeOut;
    }

    public void setRispStrikeOut(int rispStrikeOut) {
        this.rispStrikeOut = rispStrikeOut;
    }

    public int getRispGroundedIntoDp() {
        return rispGroundedIntoDp;
    }

    public void setRispGroundedIntoDp(int rispGroundedIntoDp) {
        this.rispGroundedIntoDp = rispGroundedIntoDp;
    }

    public int getRispHitByPitch() {
        return rispHitByPitch;
    }

    public void setRispHitByPitch(int rispHitByPitch) {
        this.rispHitByPitch = rispHitByPitch;
    }

    public int getLeftOnBase() {
        return leftOnBase;
    }

    public void setLeftOnBase(int leftOnBase) {
        this.leftOnBase = leftOnBase;
    }

    public int getGameGamePlayed() {
        return gameGamePlayed;
    }

    public void setGameGamePlayed(int gameGamePlayed) {
        this.gameGamePlayed = gameGamePlayed;
    }

    public int getGameGameStarted() {
        return gameGameStarted;
    }

    public void setGameGameStarted(int gameGameStarted) {
        this.gameGameStarted = gameGameStarted;
    }

    int getGameAtBats() {
        return gameAtBats;
    }

    void setGameAtBats(int gameAtBats) {
        this.gameAtBats = gameAtBats;
    }

    int getGameHits() {
        return gameHits;
    }

    void setGameHits(int gameHits) {
        this.gameHits = gameHits;
    }

    int getGameRuns() {
        return gameRuns;
    }

    void setGameRuns(int gameRuns) {
        this.gameRuns = gameRuns;
    }

    int getGameRbi() {
        return gameRbi;
    }

    void setGameRbi(int gameRbi) {
        this.gameRbi = gameRbi;
    }

    int getGameSingle() {
        return gameSingle;
    }

    private void setGameSingle(int gameSingle) {
        this.gameSingle = gameSingle;
    }

    int getGameDouble() {
        return gameDouble;
    }

    private void setGameDouble(int gameDouble) {
        this.gameDouble = gameDouble;
    }

    int getGameTriple() {
        return gameTriple;
    }

    private void setGameTriple(int gameTriple) {
        this.gameTriple = gameTriple;
    }

    int getGameHomeRun() {
        return gameHomeRun;
    }

    private void setGameHomeRun(int gameHomeRun) {
        this.gameHomeRun = gameHomeRun;
    }

    int getGameWalk() {
        return gameWalk;
    }

    void setGameWalk(int gameWalk) {
        this.gameWalk = gameWalk;
    }

    int getGameStrikeOut() {
        return gameStrikeOut;
    }

    void setGameStrikeOut(int gameStrikeOut) {
        this.gameStrikeOut = gameStrikeOut;
    }

    int getGameHitByPitch() {
        return gameHitByPitch;
    }

    void setGameHitByPitch(int gameHitByPitch) {
        this.gameHitByPitch = gameHitByPitch;
    }

    public int getGameGidp() {
        return gameGidp;
    }

    public void setGameGidp(int gameGidp) {
        this.gameGidp = gameGidp;
    }

    public int getGameLeftOnBase() {
        return gameLeftOnBase;
    }

    public void setGameLeftOnBase(int gameLeftOnBase) {
        this.gameLeftOnBase = gameLeftOnBase;
    }

    int getGameRispAtBat() {
        return gameRispAtBat;
    }

    void setGameRispAtBat(int gameRispAtBat) {
        this.gameRispAtBat = gameRispAtBat;
    }

    int getGameRispHit() {
        return gameRispHit;
    }

    private void setGameRispHit(int gameRispHit) {
        this.gameRispHit = gameRispHit;
    }

    int getGameRispSingle() {
        return gameRispSingle;
    }

    private void setGameRispSingle(int gameRispSingle) {
        this.gameRispSingle = gameRispSingle;
    }

    int getGameRispDouble() {
        return gameRispDouble;
    }

    private void setGameRispDouble(int gameRispDouble) {
        this.gameRispDouble = gameRispDouble;
    }

    int getGameRispTriple() {
        return gameRispTriple;
    }

    private void setGameRispTriple(int gameRispTriple) {
        this.gameRispTriple = gameRispTriple;
    }

    int getGameRispHomeRun() {
        return gameRispHomeRun;
    }

    private void setGameRispHomeRun(int gameRispHomeRun) {
        this.gameRispHomeRun = gameRispHomeRun;
    }

    int getGameRispRbi() {
        return gameRispRbi;
    }

    void setGameRispRbi(int gameRispRbi) {
        this.gameRispRbi = gameRispRbi;
    }

    public int getGameRispStrikeOut() {
        return gameRispStrikeOut;
    }

    public void setGameRispStrikeOut(int gameRispStrikeOut) {
        this.gameRispStrikeOut = gameRispStrikeOut;
    }

    int getGameRispWalk() {
        return gameRispWalk;
    }

    void setGameRispWalk(int gameRispWalk) {
        this.gameRispWalk = gameRispWalk;
    }

    int getGameSacrificeFly() {
        return gameSacrificeFly;
    }

    void setGameSacrificeFly(int gameSacrificeFly) {
        this.gameSacrificeFly = gameSacrificeFly;
    }

    int getGameSacrificeHit() {
        return gameSacrificeHit;
    }

    void setGameSacrificeHit(int gameSacrificeHit) {
        this.gameSacrificeHit = gameSacrificeHit;
    }

    int getGameRispSacrificeFly() {
        return gameRispSacrificeFly;
    }

    void setGameRispSacrificeFly(int gameRispSacrificeFly) {
        this.gameRispSacrificeFly = gameRispSacrificeFly;
    }

    public int getGamePlateAppearance() {
        return gamePlateAppearance;
    }

    public void setGamePlateAppearance(int gamePlateAppearance) {
        this.gamePlateAppearance = gamePlateAppearance;
    }

    int getSpeedRating() {
        return speedRating;
    }

    void setSpeedRating(int speedRating) {
        this.speedRating = speedRating;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(int stolenBases) {
        this.stolenBases = stolenBases;
    }

    public int getCaughtStealing() {
        return caughtStealing;
    }

    public void setCaughtStealing(int caughtStealing) {
        this.caughtStealing = caughtStealing;
    }

    int getGameStolenBases() {
        return gameStolenBases;
    }

    void setGameStolenBases(int gameStolenBases) {
        this.gameStolenBases = gameStolenBases;
    }

    int getGameCaughtStealing() {
        return gameCaughtStealing;
    }

    void setGameCaughtStealing(int gameCaughtStealing) {
        this.gameCaughtStealing = gameCaughtStealing;
    }

    void calculateBatterProbabilities() {
        setPlateAppearances(getAtBats() + getWalks());
        setProbabilityWalk(getWalks() / getPlateAppearances());
        setProbabilityStrikeOut(getStrikeOuts() / getPlateAppearances());
        setProbabilitySingle((getHits() - (getDoubles() - getTriples() - getHomeRuns())) / getPlateAppearances());
        setProbabilityDouble(getDoubles() / getPlateAppearances());
        setProbabilityTriple(getTriples()/ getPlateAppearances());
        setProbabilityHomeRun(getHomeRuns() / getPlateAppearances());
    }

    void updateBatterStats(Batter batter, AtBatResult atBatResult) {
        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
        switch (atBatResult) {
            case SINGLE: {
                batter.getBatterStats().setGameSingle(batter.getBatterStats().getGameSingle() + 1);
                break;
            }
            case DOUBLE: {
                batter.getBatterStats().setGameDouble(batter.getBatterStats().getGameDouble() + 1);
                break;
            }
            case TRIPLE: {
                batter.getBatterStats().setGameTriple(batter.getBatterStats().getGameTriple() + 1);
                break;
            }
            case HOME_RUN: {
                batter.getBatterStats().setGameHomeRun(batter.getBatterStats().getGameHomeRun() + 1);
                batter.getBatterStats().setGameRuns(batter.getBatterStats().getGameRuns() + 1);
                break;
            }
        }
    }

    void updateBatterStatsRisp(Batter batter, AtBatResult atBatResult, GameRbi gameRbi) {
        batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
        batter.getBatterStats().setGameRispHit(batter.getBatterStats().getGameRispHit() + 1);
        switch (atBatResult) {
            case SINGLE: {
                batter.getBatterStats().setGameRispSingle(batter.getBatterStats().getGameRispSingle() + 1);
                break;
            }
            case DOUBLE: {
                batter.getBatterStats().setGameRispDouble(batter.getBatterStats().getGameRispDouble() + 1);
                break;
            }
            case TRIPLE: {
                batter.getBatterStats().setGameRispTriple(batter.getBatterStats().getGameRispTriple() + 1);
                break;
            }
            case HOME_RUN: {
                batter.getBatterStats().setGameRispHomeRun(batter.getBatterStats().getGameRispHomeRun() + 1);
                break;
            }
        }
        switch (gameRbi) {
            case ONE: {
                batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                break;
            }
            case TWO: {
                batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 2);
                break;
            }
            case THREE: {
                batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 3);
                break;
            }
            case FOUR: {
                batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 4);
                break;
            }
        }
    }

    void recordOutNoRbi() {
        setGameAtBats(getGameAtBats() + 1);
    }

    boolean isRunEarned() {
        return isRunEarned;
    }

    void setRunEarned(boolean runEarned) {
        isRunEarned = runEarned;
    }

    void updateSacFlyRbi(Batter batter) {
        batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
        batter.getBatterStats().setGameSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() - 1);
    }

    void checkIfRunnerEarned(Base baseRunner, Pitcher pitcher) {
        if (baseRunner.getBatter().getBatterStats().isRunEarned()) {
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameEarnedRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameEarnedRunsAllowed() + 1);
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameRunsAllowed() + 1);

        } else {
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameUnearnedRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameUnearnedRunsAllowed() + 1);
            baseRunner.getBatter().getPitcherReachedOn().getPitcherStats().setGameRunsAllowed(baseRunner.getBatter()
                    .getPitcherReachedOn().getPitcherStats().getGameRunsAllowed() + 1);
            baseRunner.getBatter().getBatterStats().setRunEarned(true);
        }
    }

    double getStolenBaseAttempt() {
        return stolenBaseAttempt;
    }

    public void setStolenBaseAttempt(double stolenBaseAttempt) {
        this.stolenBaseAttempt = stolenBaseAttempt;
    }

    double getStolenBaseSuccess() {
        return stolenBaseSuccess;
    }

    public void setStolenBaseSuccess(double stolenBaseSuccess) {
        this.stolenBaseSuccess = stolenBaseSuccess;
    }
}


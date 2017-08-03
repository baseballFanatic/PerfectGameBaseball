package Baseball;

import java.util.List;
import java.util.Objects;

class BatterStats {
    private double atBats, hits, doubles, triples, homeRuns, walks, strikeOuts, plateAppearances, probabilityWalk,
            probabilitySingle, probabilityDouble, probabilityTriple, probabilityHomeRun, probabilityStrikeOut,
            stolenBaseAttempt, stolenBaseSuccess, onBasePercentage,
            battingAverage, sluggingAverage, triplesFactor, speedRating, stolenBases,
            stolenBaseAttemptPercentage, stolenBaseAttemptSuccessPercentage, histPercentPlayed,actualPlayPercent;
    private int gamesPlayed, runs ,rbi, intentionalWalks ,hitByPitch, sacrificeHits, sacrificeFlies, groundedIntoDp,
            sGamesPlayed, sGamesStarted, sAtBats, sHits, sRuns, caughtStealing, sDoubles, sTriples, sHomeRuns, sRbi,
            sWalks, sStrikeOuts, sHitByPitch, sPlateAppearances, sSacrificeHits, sSacrificeFlies, gameDate, awardPoints,
            pinchAtBat, pinchHit, pinchRbi, rispAtBat, rispHit, rispRbi, rispSingle, rispDouble, rispTriple,
            rispHomeRun, rispWalk, rispStrikeOut, rispGroundedIntoDp, rispHitByPitch, leftOnBase, gameGamePlayed,
            gameGameStarted, gameAtBats, gameHits, gameRuns, gameRbi, gameSingle, gameDouble, gameTriple, gameHomeRun,
            gameWalk, gameStrikeOut, gameHitByPitch, gameGidp, gameLeftOnBase, gameRispAtBat, gameRispHit, gameRispSingle,
            gameRispDouble, gameRispTriple, gameRispHomeRun, gameRispRbi, gameRispStrikeOut, gameRispWalk, gameRispHitByPitch,
            gameSacrificeFly, gameSacrificeHit, gameRispSacrificeFly, gamePlateAppearance, gameStolenBases, gameCaughtStealing,
            sStolenBases, sCaughtStealing, gameRispGidp, yearID;

    int getYearID() {
        return yearID;
    }

    private int getGameRispHitByPitch() {
        return gameRispHitByPitch;
    }

    public void setGameRispHitByPitch(int gameRispHitByPitch) {
        this.gameRispHitByPitch = gameRispHitByPitch;
    }

    double getStolenBaseAttemptPercentage() {
        return stolenBaseAttemptPercentage;
    }

    private void setStolenBaseAttemptPercentage(double stolenBaseAttemptPercentage) {
        this.stolenBaseAttemptPercentage = stolenBaseAttemptPercentage;
    }

    double getStolenBaseAttemptSuccessPercentage() {
        return stolenBaseAttemptSuccessPercentage;
    }

    private void setStolenBaseAttemptSuccessPercentage(double stolenBaseAttemptSuccessPercentage) {
        this.stolenBaseAttemptSuccessPercentage = stolenBaseAttemptSuccessPercentage;
    }

    private double getTriplesFactor() {
        return triplesFactor;
    }

    private void setTriplesFactor(double triplesFactor) {
        this.triplesFactor = triplesFactor;
    }

    public void setGameGamePlayed(int gameGamePlayed) {
        this.gameGamePlayed = gameGamePlayed;
    }

    double getBattingAverage() {
        return battingAverage;
    }

    private void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getSluggingAverage() {
        return sluggingAverage;
    }

    private void setSluggingAverage(double sluggingAverage) {
        this.sluggingAverage = sluggingAverage;
    }

    void setYearID(int yearID) {
        this.yearID = yearID;
    }

    private boolean isRunEarned = true;

    public int getPinchRbi() {
        return pinchRbi;
    }

    void setPinchRbi(int pinchRbi) {
        this.pinchRbi = pinchRbi;
    }

    double getOnBasePercentage() {
        return onBasePercentage;
    }

    private void setOnBasePercentage(double onBasePercentage) {
        this.onBasePercentage = onBasePercentage;
    }

    int getGameRispGidp() {
        return gameRispGidp;
    }

    void setGameRispGidp(int gameRispGidp) {
        this.gameRispGidp = gameRispGidp;
    }

    double getAtBats() {
        return atBats;
    }

    void setAtBats(double atBats) {
        this.atBats = atBats;
    }

    double getHits() {
        return hits;
    }

    void setHits(double hits) {
        this.hits = hits;
    }

   double getDoubles() {
        return doubles;
    }

    void setDoubles(double doubles) {
        this.doubles = doubles;
    }

    double getTriples() {
        return triples;
    }

    void setTriples(double triples) {
        this.triples = triples;
    }

    double getHomeRuns() {
        return homeRuns;
    }

    void setHomeRuns(double homeRuns) {
        this.homeRuns = homeRuns;
    }

   double getWalks() {
        return walks;
    }

    void setWalks(double walks) {
        this.walks = walks;
    }

    double getStrikeOuts() {
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

    int getGamesPlayed() {
        return gamesPlayed;
    }

    void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    int getRuns() {
        return runs;
    }

    void setRuns(int runs) {
        this.runs = runs;
    }

    int getRbi() {
        return rbi;
    }

    void setRbi(int rbi) {
        this.rbi = rbi;
    }

    public int getIntentionalWalks() {
        return intentionalWalks;
    }

    public void setIntentionalWalks(int intentionalWalks) {
        this.intentionalWalks = intentionalWalks;
    }

    private int getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(int hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    int getSacrificeHits() {
        return sacrificeHits;
    }

    void setSacrificeHits(int sacrificeHits) {
        this.sacrificeHits = sacrificeHits;
    }

    int getSacrificeFlies() {
        return sacrificeFlies;
    }

    void setSacrificeFlies(int sacrificeFlies) {
        this.sacrificeFlies = sacrificeFlies;
    }

    public int getGroundedIntoDp() {
        return groundedIntoDp;
    }

    public void setGroundedIntoDp(int groundedIntoDp) {
        this.groundedIntoDp = groundedIntoDp;
    }

    int getsGamesPlayed() {
        return sGamesPlayed;
    }

    void setsGamesPlayed(int sGamesPlayed) {
        this.sGamesPlayed = sGamesPlayed;
    }

    private int getsGamesStarted() {
        return sGamesStarted;
    }

    void setsGamesStarted(int sGamesStarted) {
        this.sGamesStarted = sGamesStarted;
    }

    int getsAtBats() {
        return sAtBats;
    }

    void setsAtBats(int sAtBats) {
        this.sAtBats = sAtBats;
    }

    int getsHits() {
        return sHits;
    }

    void setsHits(int sHits) {
        this.sHits = sHits;
    }

    int getsRuns() {
        return sRuns;
    }

    void setsRuns(int sRuns) {
        this.sRuns = sRuns;
    }

    int getsDoubles() {
        return sDoubles;
    }

    void setsDoubles(int sDoubles) {
        this.sDoubles = sDoubles;
    }

    int getsTriples() {
        return sTriples;
    }

    void setsTriples(int sTriples) {
        this.sTriples = sTriples;
    }

    int getsHomeRuns() {
        return sHomeRuns;
    }

    void setsHomeRuns(int sHomeRuns) {
        this.sHomeRuns = sHomeRuns;
    }

    int getsRbi() {
        return sRbi;
    }

    void setsRbi(int sRbi) {
        this.sRbi = sRbi;
    }

    int getsWalks() {
        return sWalks;
    }

    void setsWalks(int sWalks) {
        this.sWalks = sWalks;
    }

    int getsStrikeOuts() {
        return sStrikeOuts;
    }

    void setsStrikeOuts(int sStrikeOuts) {
        this.sStrikeOuts = sStrikeOuts;
    }

    int getsHitByPitch() {
        return sHitByPitch;
    }

    void setsHitByPitch(int sHitByPitch) {
        this.sHitByPitch = sHitByPitch;
    }

    int getsStolenBases() {
        return sStolenBases;
    }

    void setsStolenBases(int sStolenBases) {
        this.sStolenBases = sStolenBases;
    }

    int getsCaughtStealing() {
        return sCaughtStealing;
    }

    void setsCaughtStealing(int sCaughtStealing) {
        this.sCaughtStealing = sCaughtStealing;
    }

    int getsPlateAppearances() {
        return sPlateAppearances;
    }

    void setsPlateAppearances(int sPlateAppearances) {
        this.sPlateAppearances = sPlateAppearances;
    }

    int getsSacrificeHits() {
        return sSacrificeHits;
    }

    private void setsSacrificeHits(int sSacrificeHits) {
        this.sSacrificeHits = sSacrificeHits;
    }

    int getsSacrificeFlies() {
        return sSacrificeFlies;
    }

    private void setsSacrificeFlies(int sSacrificeFlies) {
        this.sSacrificeFlies = sSacrificeFlies;
    }

    public int getGameDate() {
        return gameDate;
    }

    public void setGameDate(int gameDate) {
        this.gameDate = gameDate;
    }

    public double getHistPercentPlayed() {
        return histPercentPlayed;
    }

    void setHistPercentPlayed(double histPercentPlayed) {
        this.histPercentPlayed = histPercentPlayed;
    }

    public double getActualPlayPercent() {
        return actualPlayPercent;
    }

    void setActualPlayPercent(double actualPlayPercent) {
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

    void setPinchAtBat(int pinchAtBat) {
        this.pinchAtBat = pinchAtBat;
    }

    public int getPinchHit() {
        return pinchHit;
    }

    void setPinchHit(int pinchHit) {
        this.pinchHit = pinchHit;
    }

    int getRispAtBat() {
        return rispAtBat;
    }

    void setRispAtBat(int rispAtBat) {
        this.rispAtBat = rispAtBat;
    }

    int getRispHit() {
        return rispHit;
    }

    void setRispHit(int rispHit) {
        this.rispHit = rispHit;
    }

    int getRispRbi() {
        return rispRbi;
    }

    void setRispRbi(int rispRbi) {
        this.rispRbi = rispRbi;
    }

    int getRispSingle() {
        return rispSingle;
    }

    void setRispSingle(int rispSingle) {
        this.rispSingle = rispSingle;
    }

    int getRispDouble() {
        return rispDouble;
    }

    void setRispDouble(int rispDouble) {
        this.rispDouble = rispDouble;
    }

    int getRispTriple() {
        return rispTriple;
    }

    void setRispTriple(int rispTriple) {
        this.rispTriple = rispTriple;
    }

    int getRispHomeRun() {
        return rispHomeRun;
    }

    void setRispHomeRun(int rispHomeRun) {
        this.rispHomeRun = rispHomeRun;
    }

    int getRispWalk() {
        return rispWalk;
    }

    void setRispWalk(int rispWalk) {
        this.rispWalk = rispWalk;
    }

    int getRispStrikeOut() {
        return rispStrikeOut;
    }

    void setRispStrikeOut(int rispStrikeOut) {
        this.rispStrikeOut = rispStrikeOut;
    }

    int getRispGroundedIntoDp() {
        return rispGroundedIntoDp;
    }

    void setRispGroundedIntoDp(int rispGroundedIntoDp) {
        this.rispGroundedIntoDp = rispGroundedIntoDp;
    }

    private int getRispHitByPitch() {
        return rispHitByPitch;
    }

    void setRispHitByPitch(int rispHitByPitch) {
        this.rispHitByPitch = rispHitByPitch;
    }

    int getLeftOnBase() {
        return leftOnBase;
    }

    void setLeftOnBase(int leftOnBase) {
        this.leftOnBase = leftOnBase;
    }

    int getGameGamePlayed() {
        return gameGamePlayed;
    }

    void setGameGamePlayed() {
        this.gameGamePlayed = 1;
    }

    private int getGameGameStarted() {
        return gameGameStarted;
    }

    void setGameGameStarted(int gameGameStarted) {
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

    int getGameLeftOnBase() {
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

    private int getGameRispStrikeOut() {
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

    int getGamePlateAppearance() {
        return gamePlateAppearance;
    }

    public void setGamePlateAppearance(int gamePlateAppearance) {
        this.gamePlateAppearance = gamePlateAppearance;
    }

    double getSpeedRating() {
        return speedRating;
    }

    void setSpeedRating(double speedRating) {
        this.speedRating = speedRating;
    }

    double getStolenBases() {
        return stolenBases;
    }

    void setStolenBases(double stolenBases) {
        this.stolenBases = stolenBases;
    }

    int getCaughtStealing() {
        return caughtStealing;
    }

    void setCaughtStealing(int caughtStealing) {
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
        setBattingAverage(getHits() / getAtBats());
        setOnBasePercentage((getHitByPitch() + getHits() + getWalks()) / getAtBats());
        double singles = getHits() - getDoubles() - getTriples() - getHomeRuns();
        if (getCaughtStealing() == 0)
        {
            setCaughtStealing((int) (getStolenBases() * .826795));
        }
        setSluggingAverage((singles + (getDoubles() * 2) + (getTriples() * 3) + getHomeRuns() * 4) / getAtBats());
        if (Objects.isNull(getSpeedRating()) || getSpeedRating() == 0)
        {
            if (getStolenBases() + getCaughtStealing() < 10)
            {
                setStolenBaseAttemptPercentage(.2);
                setStolenBaseAttemptSuccessPercentage(.7);
            }
            setStolenBaseSuccess((((getStolenBases() + 3) / (getStolenBases() + getCaughtStealing() + 7)) - 0.4 ) * 20);
            setStolenBaseAttempt(Math.sqrt(((getStolenBases() + getCaughtStealing()) / (singles + getWalks()))) / .07);
            if (Double.isNaN(getStolenBaseAttempt()))
            {
                setStolenBaseAttempt(.1973);
            }
            setTriplesFactor(((getTriples() / (getAtBats() - getHomeRuns() - getStrikeOuts())) / .02) * 10);
            setSpeedRating(((getStolenBaseSuccess() * 10) + (getStolenBaseAttempt() * 10) + (getTriplesFactor() * 6)) / 26);
        }
        setStolenBaseAttemptPercentage((getStolenBases() + getCaughtStealing()) / (singles + getWalks()));
        setStolenBaseAttemptSuccessPercentage((getStolenBases() / (getStolenBases() + getCaughtStealing())));

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

    private double getStolenBaseAttempt() {
        return stolenBaseAttempt;
    }

    private void setStolenBaseAttempt(double stolenBaseAttempt) {
        this.stolenBaseAttempt = stolenBaseAttempt;
    }

    double getStolenBaseSuccess() {
        return stolenBaseSuccess;
    }

    private void setStolenBaseSuccess(double stolenBaseSuccess) {
        this.stolenBaseSuccess = stolenBaseSuccess;
    }

    void updateBatterGameStats(List<Batter> batterList)
    {
        for (Batter batter: batterList)
        {
            batter.getBatterStats().setsGamesPlayed(batter.getBatterStats().getsGamesPlayed() + batter.getBatterStats().getGameGamePlayed());
            batter.getBatterStats().setsGamesStarted(batter.getBatterStats().getsGamesStarted() + batter.getBatterStats().getGameGameStarted());
            batter.getBatterStats().setsAtBats(batter.getBatterStats().getsAtBats() + batter.getBatterStats().getGameAtBats());
            batter.getBatterStats().setsHits(batter.getBatterStats().getsHits() + batter.getBatterStats().getGameHits());
            batter.getBatterStats().setsRuns(batter.getBatterStats().getsRuns() + batter.getBatterStats().getGameRuns());
            batter.getBatterStats().setsDoubles(batter.getBatterStats().getsDoubles() + batter.getBatterStats().getGameDouble());
            batter.getBatterStats().setsTriples(batter.getBatterStats().getsTriples() + batter.getBatterStats().getGameTriple());
            batter.getBatterStats().setsHomeRuns(batter.getBatterStats().getsHomeRuns() + batter.getBatterStats().getGameHomeRun());
            batter.getBatterStats().setsRbi(batter.getBatterStats().getsRbi() + batter.getBatterStats().getGameRbi());
            batter.getBatterStats().setsWalks(batter.getBatterStats().getsWalks() + batter.getBatterStats().getGameWalk());
            batter.getBatterStats().setsStrikeOuts(batter.getBatterStats().getsStrikeOuts() + batter.getBatterStats().getGameStrikeOut());
            batter.getBatterStats().setsHitByPitch(batter.getBatterStats().getsHitByPitch() + batter.getBatterStats().getGameHitByPitch());
            batter.getBatterStats().setsPlateAppearances(batter.getBatterStats().getsPlateAppearances() + batter.getBatterStats().getGamePlateAppearance());
            batter.getBatterStats().setsSacrificeHits(batter.getBatterStats().getsSacrificeHits() + batter.getBatterStats().getGameSacrificeHit());
            batter.getBatterStats().setsSacrificeFlies(batter.getBatterStats().getsSacrificeFlies() + batter.getBatterStats().getGameRispSacrificeFly());
            batter.getBatterStats().setsStolenBases(batter.getBatterStats().getsStolenBases() + batter.getBatterStats().getGameStolenBases());
            batter.getBatterStats().setsCaughtStealing(batter.getBatterStats().getsCaughtStealing() + batter.getBatterStats().getGameCaughtStealing());
            //TODO Add in pinch at bat stats
            batter.getBatterStats().setRispAtBat(batter.getBatterStats().getRispAtBat() + batter.getBatterStats().getGameRispAtBat());
            batter.getBatterStats().setRispHit(batter.getBatterStats().getRispHit() + batter.getBatterStats().getGameRispHit());
            batter.getBatterStats().setRispRbi(batter.getBatterStats().getRispRbi() + batter.getBatterStats().getGameRispRbi());
            batter.getBatterStats().setRispSingle(batter.getBatterStats().getRispSingle() + batter.getBatterStats().getGameRispSingle());
            batter.getBatterStats().setRispDouble(batter.getBatterStats().getRispDouble() + batter.getBatterStats().getGameRispDouble());
            batter.getBatterStats().setRispTriple(batter.getBatterStats().getRispTriple() + batter.getBatterStats().getGameRispTriple());
            batter.getBatterStats().setRispHomeRun(batter.getBatterStats().getRispHomeRun() + batter.getBatterStats().getGameRispHomeRun());
            batter.getBatterStats().setRispWalk(batter.getBatterStats().getRispWalk() + batter.getBatterStats().getGameRispWalk());
            batter.getBatterStats().setRispStrikeOut(batter.getBatterStats().getRispStrikeOut() + batter.getBatterStats().getGameRispStrikeOut());
            batter.getBatterStats().setRispGroundedIntoDp(batter.getBatterStats().getRispGroundedIntoDp() + batter.getBatterStats().getGameRispGidp());
            batter.getBatterStats().setRispHitByPitch(batter.getBatterStats().getRispHitByPitch() + batter.getBatterStats().getGameRispHitByPitch());
            batter.getBatterStats().setLeftOnBase(batter.getBatterStats().getLeftOnBase() + batter.getBatterStats().getGameLeftOnBase());
        }
    }
}


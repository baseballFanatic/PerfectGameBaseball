package Baseball;

import java.util.List;
import java.util.Objects;

class BatterStats {
    private double atBats, hits, doubles, triples, homeRuns, walks, strikeOuts, plateAppearances, probabilityWalk,
            probabilitySingle, probabilityDouble, probabilityTriple, probabilityHomeRun, probabilityStrikeOut,
            //stolenBaseAttempt = .1973, stolenBaseSuccess = .833, onBasePercentage = .359,
            stolenBaseAttempt, stolenBaseSuccess, onBasePercentage,
            battingAverage, sluggingAverage, triplesFactor, speedRating, stolenBases,
            stolenBaseAttemptPercentage, stolenBaseAttemptSuccessPercentage;
    private int gamesPlayed;
    private int runs;
    private int rbi;
    private int intentionalWalks;
    private int hitByPitch;
    private int sacrificeHits;
   // private int stolenBases;
    private int sacrificeFlies;
    private int groundedIntoDp;
    private int sGamesPlayed;
    private int sGamesStarted;
    private int sAtBats;
    private int sHits;
    private int sRuns;
    private int caughtStealing;
    private int sDoubles;
    private int sTriples;
    private int sHomeRuns;
    private int sRbi;
    private int sWalks;
    private int sStrikeOuts;
    private int sHitByPitch;
    private int sPlateAppearances;
    private int sSacrificeHits;
    private int sSacrificeFlies;
    private int gameDate;
    private int histPercentPlayed;
    private int actualPlayPercent;
    private int awardPoints;
    private int pinchAtBat;
    private int pinchHit;
    private int pinchRbi;
    private int rispAtBat;
    private int rispHit;
    private int rispRbi;
    private int rispSingle;
    private int rispDouble;
    private int rispTriple;
    private int rispHomeRun;
    private int rispWalk;
    private int rispStrikeOut;
    private int rispGroundedIntoDp;
    private int rispHitByPitch;
    private int leftOnBase;
    private int gameGamePlayed;
    private int gameGameStarted;
    private int gameAtBats;
    private int gameHits;
    private int gameRuns;
    private int gameRbi;
    private int gameSingle;
    private int gameDouble;
    private int gameTriple;
    private int gameHomeRun;
    private int gameWalk;
    private int gameStrikeOut;
    private int gameHitByPitch;
    private int gameGidp;
    private int gameLeftOnBase;
    private int gameRispAtBat;
    private int gameRispHit;
    private int gameRispSingle;
    private int gameRispDouble;
    private int gameRispTriple;
    private int gameRispHomeRun;
    private int gameRispRbi;
    private int gameRispStrikeOut;
    private int gameRispWalk;
    private int gameRispHitByPitch;
    private int gameSacrificeFly;
    private int gameSacrificeHit;
    private int gameRispSacrificeFly;
    private int gamePlateAppearance;
    private int gameStolenBases;
    private int gameCaughtStealing;
    private int sStolenBases;
    private int sCaughtStealing;
    private int gameRispGidp;
    private int yearID;

    public int getYearID() {
        return yearID;
    }

    public int getGameRispHitByPitch() {
        return gameRispHitByPitch;
    }

    public void setGameRispHitByPitch(int gameRispHitByPitch) {
        this.gameRispHitByPitch = gameRispHitByPitch;
    }

    public double getStolenBaseAttemptPercentage() {
        return stolenBaseAttemptPercentage;
    }

    public void setStolenBaseAttemptPercentage(double stolenBaseAttemptPercentage) {
        this.stolenBaseAttemptPercentage = stolenBaseAttemptPercentage;
    }

    public double getStolenBaseAttemptSuccessPercentage() {
        return stolenBaseAttemptSuccessPercentage;
    }

    public void setStolenBaseAttemptSuccessPercentage(double stolenBaseAttemptSuccessPercentage) {
        this.stolenBaseAttemptSuccessPercentage = stolenBaseAttemptSuccessPercentage;
    }

    public double getTriplesFactor() {
        return triplesFactor;
    }

    public void setTriplesFactor(double triplesFactor) {
        this.triplesFactor = triplesFactor;
    }

    public void setGameGamePlayed(int gameGamePlayed) {
        this.gameGamePlayed = gameGamePlayed;
    }

    public double getBattingAverage() {
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

    public void setPinchRbi(int pinchRbi) {
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

    public int getGamesPlayed() {
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

    public void setSacrificeHits(int sacrificeHits) {
        this.sacrificeHits = sacrificeHits;
    }

    int getSacrificeFlies() {
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

    public void setGameGamePlayed() {
        this.gameGamePlayed = 1;
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


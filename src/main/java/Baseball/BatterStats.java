package Baseball;

import java.util.List;
import java.util.Objects;

public class BatterStats {
    private double atBats, hits, doubles, triples, homeRuns, walks, strikeOuts, plateAppearances, probabilityWalk,
            probabilitySingle, probabilityDouble, probabilityTriple, probabilityHomeRun, probabilityStrikeOut,
            stolenBaseAttempt, stolenBaseSuccess, onBasePercentage,
            battingAverage, sluggingAverage, triplesFactor, speedRating, stolenBases,
            stolenBaseAttemptPercentage, stolenBaseAttemptSuccessPercentage, histPercentPlayed, actualPlayPercent,
            onBasePlusSlugging;
    private int gamesPlayed, runs ,rbi, intentionalWalks ,hitByPitch, sacrificeHits, sacrificeFlies, groundedIntoDp,
            sGamesPlayed, sGamesStarted, sAtBats, sHits, sRuns, caughtStealing, sDoubles, sTriples, sHomeRuns, sRbi,
            sWalks, sStrikeOuts, sHitByPitch, sPlateAppearances, sSacrificeHits, sSacrificeFlies, gameDate, awardPoints,
            pinchAtBat, pinchHit, pinchRbi, rispAtBat, rispHit, rispRbi, rispSingle, rispDouble, rispTriple,
            rispHomeRun, rispWalk, rispStrikeOut, rispGroundedIntoDp, rispHitByPitch, leftOnBase, gameGamePlayed,
            gameGameStarted, gameAtBats, gameHits, gameRuns, gameRbi, gameSingle, gameDouble, gameTriple, gameHomeRun,
            gameWalk, gameStrikeOut, gameHitByPitch, gameGidp, gameLeftOnBase, gameRispAtBat, gameRispHit, gameRispSingle,
            gameRispDouble, gameRispTriple, gameRispHomeRun, gameRispRbi, gameRispStrikeOut, gameRispWalk, gameRispHitByPitch,
            gameSacrificeFly, gameSacrificeHit, gameRispSacrificeFly, gamePlateAppearance, gameStolenBases, gameCaughtStealing,
            sStolenBases, sCaughtStealing, gameRispGidp, yearID, gameNumber, gamePinchAtBat, gamePinchHitHit, gameKey,
            gamePinchHitSingle, gamePinchHitDouble, gamePinchHitTriple, gamePinchHitHomeRun, gamePinchHitRbi, gamePinchHitWalk,
            gamePinchHitStrikeOut, gamePinchHitGdp;

    private String gameField;

    public int getGameKey()
    {
        return gameKey;
    }

    public int getGamePinchHitSingle()
    {
        return gamePinchHitSingle;
    }

    public void setGamePinchHitSingle( int gamePinchHitSingle )
    {
        this.gamePinchHitSingle = gamePinchHitSingle;
    }

    public int getGamePinchHitDouble()
    {
        return gamePinchHitDouble;
    }

    public void setGamePinchHitDouble( int gamePinchHitDouble )
    {
        this.gamePinchHitDouble = gamePinchHitDouble;
    }

    public int getGamePinchHitTriple()
    {
        return gamePinchHitTriple;
    }

    public void setGamePinchHitTriple( int gamePinchHitTriple )
    {
        this.gamePinchHitTriple = gamePinchHitTriple;
    }

    public int getGamePinchHitHomeRun()
    {
        return gamePinchHitHomeRun;
    }

    public void setGamePinchHitHomeRun( int gamePinchHitHomeRun )
    {
        this.gamePinchHitHomeRun = gamePinchHitHomeRun;
    }

    public int getGamePinchHitRbi()
    {
        return gamePinchHitRbi;
    }

    public void setGamePinchHitRbi( int gamePinchHitRbi )
    {
        this.gamePinchHitRbi = gamePinchHitRbi;
    }

    public int getGamePinchHitWalk()
    {
        return gamePinchHitWalk;
    }

    public void setGamePinchHitWalk( int gamePinchHitWalk )
    {
        this.gamePinchHitWalk = gamePinchHitWalk;
    }

    public int getGamePinchHitStrikeOut()
    {
        return gamePinchHitStrikeOut;
    }

    public void setGamePinchHitStrikeOut( int gamePinchHitStrikeOut )
    {
        this.gamePinchHitStrikeOut = gamePinchHitStrikeOut;
    }

    public int getGamePinchHitGdp()
    {
        return gamePinchHitGdp;
    }

    public void setGamePinchHitGdp( int gamePinchHitGdp )
    {
        this.gamePinchHitGdp = gamePinchHitGdp;
    }

    public void setGameKey( int gameKey )
    {
        this.gameKey = gameKey;
    }

    public int getGameNumber()
    {
        return gameNumber;
    }

    public String getGameField()
    {
        return gameField;
    }

    public void setGameField( String gameField )
    {
        this.gameField = gameField;
    }

    public int getGamePinchAtBat()
    {
        return gamePinchAtBat;
    }

    public void setGamePinchAtBat( int gamePinchAtBat )
    {
        this.gamePinchAtBat = gamePinchAtBat;
    }

    public int getGamePinchHitHit()
    {
        return gamePinchHitHit;
    }

    public void setGamePinchHitHit( int gamePinchHitHit )
    {
        this.gamePinchHitHit = gamePinchHitHit;
    }

    public void setGameNumber( int gameNumber )
    {
        this.gameNumber = gameNumber;
    }

    public double getOnBasePlusSlugging()
    {
        return onBasePlusSlugging;
    }

    public void setOnBasePlusSlugging( double onBasePlusSlugging )
    {
        this.onBasePlusSlugging = onBasePlusSlugging;
    }

    public int getYearID() {
        return yearID;
    }

    int getGameRispHitByPitch() {
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

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getSluggingAverage() {
        return sluggingAverage;
    }

    public void setSluggingAverage(double sluggingAverage) {
        this.sluggingAverage = sluggingAverage;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    private boolean isRunEarned = true;

    public int getPinchRbi() {
        return pinchRbi;
    }

    void setPinchRbi(int pinchRbi) {
        this.pinchRbi = pinchRbi;
    }

    public double getOnBasePercentage() {
        return onBasePercentage;
    }

    public void setOnBasePercentage(double onBasePercentage) {
        this.onBasePercentage = onBasePercentage;
    }

    public int getGameRispGidp() {
        return gameRispGidp;
    }

    public void setGameRispGidp(int gameRispGidp) {
        this.gameRispGidp = gameRispGidp;
    }

    double getAtBats() {
        return atBats;
    }

    public void setAtBats(double atBats) {
        this.atBats = atBats;
    }

    double getHits() {
        return hits;
    }

    public void setHits(double hits) {
        this.hits = hits;
    }

   double getDoubles() {
        return doubles;
    }

    public void setDoubles(double doubles) {
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

    public void setHomeRuns(double homeRuns) {
        this.homeRuns = homeRuns;
    }

   double getWalks() {
        return walks;
    }

    public void setWalks(double walks) {
        this.walks = walks;
    }

    double getStrikeOuts() {
        return strikeOuts;
    }

    public void setStrikeOuts(double strikeOuts) {
        this.strikeOuts = strikeOuts;
    }

    private double getPlateAppearances() {
        return plateAppearances;
    }

    public void setPlateAppearances(double plateAppearances) {
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

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    int getRbi() {
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

    public double getHistPercentPlayed() {
        return histPercentPlayed;
    }

    public void setHistPercentPlayed(double histPercentPlayed) {
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

    public  int getRispGroundedIntoDp() {
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

    public int getGameAtBats() {
        return gameAtBats;
    }

    public void setGameAtBats(int gameAtBats) {
        this.gameAtBats = gameAtBats;
    }

    public int getGameHits() {
        return gameHits;
    }

    public void setGameHits(int gameHits) {
        this.gameHits = gameHits;
    }

    public int getGameRuns() {
        return gameRuns;
    }

    public void setGameRuns(int gameRuns) {
        this.gameRuns = gameRuns;
    }

    public int getGameRbi() {
        return gameRbi;
    }

    public void setGameRbi(int gameRbi) {
        this.gameRbi = gameRbi;
    }

    public int getGameSingle() {
        return gameSingle;
    }

    public void setGameSingle(int gameSingle) {
        this.gameSingle = gameSingle;
    }

    public int getGameDouble() {
        return gameDouble;
    }

    public void setGameDouble(int gameDouble) {
        this.gameDouble = gameDouble;
    }

    public int getGameTriple() {
        return gameTriple;
    }

    public void setGameTriple(int gameTriple) {
        this.gameTriple = gameTriple;
    }

    public int getGameHomeRun() {
        return gameHomeRun;
    }

    public void setGameHomeRun(int gameHomeRun) {
        this.gameHomeRun = gameHomeRun;
    }

    public int getGameWalk() {
        return gameWalk;
    }

    public void setGameWalk(int gameWalk) {
        this.gameWalk = gameWalk;
    }

    public int getGameStrikeOut() {
        return gameStrikeOut;
    }

    public void setGameStrikeOut(int gameStrikeOut) {
        this.gameStrikeOut = gameStrikeOut;
    }

    public int getGameHitByPitch() {
        return gameHitByPitch;
    }

    public void setGameHitByPitch(int gameHitByPitch) {
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

    public int getGameRispAtBat() {
        return gameRispAtBat;
    }

    public void setGameRispAtBat(int gameRispAtBat) {
        this.gameRispAtBat = gameRispAtBat;
    }

    public int getGameRispHit() {
        return gameRispHit;
    }

    public void setGameRispHit(int gameRispHit) {
        this.gameRispHit = gameRispHit;
    }

    public int getGameRispSingle() {
        return gameRispSingle;
    }

    public void setGameRispSingle(int gameRispSingle) {
        this.gameRispSingle = gameRispSingle;
    }

    public int getGameRispDouble() {
        return gameRispDouble;
    }

    public void setGameRispDouble(int gameRispDouble) {
        this.gameRispDouble = gameRispDouble;
    }

    public int getGameRispTriple() {
        return gameRispTriple;
    }

    public void setGameRispTriple(int gameRispTriple) {
        this.gameRispTriple = gameRispTriple;
    }

    public int getGameRispHomeRun() {
        return gameRispHomeRun;
    }

    public void setGameRispHomeRun(int gameRispHomeRun) {
        this.gameRispHomeRun = gameRispHomeRun;
    }

    public int getGameRispRbi() {
        return gameRispRbi;
    }

    public void setGameRispRbi(int gameRispRbi) {
        this.gameRispRbi = gameRispRbi;
    }

    public int getGameRispStrikeOut() {
        return gameRispStrikeOut;
    }

    public void setGameRispStrikeOut(int gameRispStrikeOut) {
        this.gameRispStrikeOut = gameRispStrikeOut;
    }

    public int getGameRispWalk() {
        return gameRispWalk;
    }

    public void setGameRispWalk(int gameRispWalk) {
        this.gameRispWalk = gameRispWalk;
    }

    public int getGameSacrificeFly() {
        return gameSacrificeFly;
    }

    public void setGameSacrificeFly(int gameSacrificeFly) {
        this.gameSacrificeFly = gameSacrificeFly;
    }

    public int getGameSacrificeHit() {
        return gameSacrificeHit;
    }

    public void setGameSacrificeHit(int gameSacrificeHit) {
        this.gameSacrificeHit = gameSacrificeHit;
    }

    public int getGameRispSacrificeFly() {
        return gameRispSacrificeFly;
    }

    public void setGameRispSacrificeFly(int gameRispSacrificeFly) {
        this.gameRispSacrificeFly = gameRispSacrificeFly;
    }

    public int getGamePlateAppearance() {
        return gamePlateAppearance;
    }

    public void setGamePlateAppearance(int gamePlateAppearance) {
        this.gamePlateAppearance = gamePlateAppearance;
    }

    public double getSpeedRating() {
        return speedRating;
    }

    public void setSpeedRating(double speedRating) {
        this.speedRating = speedRating;
    }

    public double getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(double stolenBases) {
        this.stolenBases = stolenBases;
    }

    public int getCaughtStealing() {
        return caughtStealing;
    }

    public void setCaughtStealing(int caughtStealing) {
        this.caughtStealing = caughtStealing;
    }

    public int getGameStolenBases() {
        return gameStolenBases;
    }

    public void setGameStolenBases(int gameStolenBases) {
        this.gameStolenBases = gameStolenBases;
    }

    public int getGameCaughtStealing() {
        return gameCaughtStealing;
    }

    public void setGameCaughtStealing(int gameCaughtStealing) {
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


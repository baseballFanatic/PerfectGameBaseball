package Baseball;

public class BoxScore
{
    private String gameNumber, teamID, nameFirst, nameLast, position, round, simName, gameField, lgID, playerID;
    private int simNumber, yearID, gameKey, gameStarted, gamePlayed, gameAtBats, gameHits, gameRuns, gameRbi,
        gameStolenBases, gameCaughtStealing, gameErrors, gamePutOuts, gameAssists, gameDoubles, gameTriples,
        gameHomeRuns, gameWalks, gameStrikeOuts, gameGdp, gameSacFly, gameSacHit, gameHitByPitch, gameHitsAllowed,
        gameWalksAllowed, gameRunsAllowed, gameUnearnedRunsAllowed, gameHomeRunsAllowed, gameHitBatters,
            gameStrikeOutsAllowed, gameBatterOuts, gameWin, gameLoss, gameSave, gameShutOut,
        gameCompleteGame, gameDoublePlaysStarted, gameCatcherRunnersThrownOut, gameCatcherRunnersSuccessful,
        gameRispAtBat, gameRispHit, gameRispRbi, gameRispSingle, gameRispDouble, gameRispTriple, gameRispHomeRun,
        gameRispGdp, gameRispWalk, gameRispStrikeOut, gameRispHitByPitch, gameLeftOnBase, gamePinchAtBat,
        gamePinchHitHit, gamePinchHitRbi, gamePinchHitSingle, gamePinchHitDouble, gamePinchHitTriple, gamePinchHitHomeRun,
            gamePinchHitGdp, gamePinchHitWalk, gamePinchHitStrikeOut, battingOrder;

    private double gameInningsPitched;

    private BatterStats batterStats = new BatterStats();
    private PitcherStats pitcherStats = new PitcherStats();


    public BoxScore()
    {
    }

    public BoxScore( String gameNumber, String teamID, String nameFirst, String nameLast, String position, String round, String simName, String gameField, String lgID, String playerID, int simNumber, int yearID, int gameKey, int gameStarted, int gamePlayed, int gameAtBats, int gameHits, int gameRuns, int gameRbi, int gameStolenBases, int gameCaughtStealing, int gameErrors, int gamePutOuts, int gameAssists, int gameDoubles, int gameTriples, int gameHomeRuns, int gameWalks, int gameStrikeOuts, int gameGdp, int gameSacFly, int gameSacHit, int gameHitByPitch, int gameHitsAllowed, int gameWalksAllowed, int gameRunsAllowed, int gameUnearnedRunsAllowed, int gameHomeRunsAllowed, int gameHitBatters, int gameInningsPitched, int gameStrikeOutsAllowed, int gameBatterOuts, int gameWin, int gameLoss, int gameSave, int gameShutOut, int gameCompleteGame, int gameDoublePlaysStarted, int gameCatcherRunnersThrownOut, int gameCatcherRunnersSuccessful, int gameRispAtBat, int gameRispHit, int gameRispRbi, int gameRispSingle, int gameRispDouble, int gameRispTriple, int gameRispHomeRun, int gameRispGdp, int gameRispWalk, int gameRispStrikeOut, int gameRispHitByPitch, int gameLeftOnBase, int gamePinchAtBat, int gamePinchHitHit, int gamePinchHitRbi, int gamePinchHitSingle, int gamePinchHitDouble, int gamePinchHitTriple, int gamePinchHitHomeRun, int gamePinchHitGdp, int gamePinchHitWalk, int gamePinchHitStrikeOut, int battingOrder, BatterStats batterStats, PitcherStats pitcherStats )
    {
        this.gameNumber = gameNumber;
        this.teamID = teamID;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
        this.round = round;
        this.simName = simName;
        this.gameField = gameField;
        this.lgID = lgID;
        this.playerID = playerID;
        this.simNumber = simNumber;
        this.yearID = yearID;
        this.gameKey = gameKey;
        this.gameStarted = gameStarted;
        this.gamePlayed = gamePlayed;
        this.gameAtBats = gameAtBats;
        this.gameHits = gameHits;
        this.gameRuns = gameRuns;
        this.gameRbi = gameRbi;
        this.gameStolenBases = gameStolenBases;
        this.gameCaughtStealing = gameCaughtStealing;
        this.gameErrors = gameErrors;
        this.gamePutOuts = gamePutOuts;
        this.gameAssists = gameAssists;
        this.gameDoubles = gameDoubles;
        this.gameTriples = gameTriples;
        this.gameHomeRuns = gameHomeRuns;
        this.gameWalks = gameWalks;
        this.gameStrikeOuts = gameStrikeOuts;
        this.gameGdp = gameGdp;
        this.gameSacFly = gameSacFly;
        this.gameSacHit = gameSacHit;
        this.gameHitByPitch = gameHitByPitch;
        this.gameHitsAllowed = gameHitsAllowed;
        this.gameWalksAllowed = gameWalksAllowed;
        this.gameRunsAllowed = gameRunsAllowed;
        this.gameUnearnedRunsAllowed = gameUnearnedRunsAllowed;
        this.gameHomeRunsAllowed = gameHomeRunsAllowed;
        this.gameHitBatters = gameHitBatters;
        this.gameInningsPitched = gameInningsPitched;
        this.gameStrikeOutsAllowed = gameStrikeOutsAllowed;
        this.gameBatterOuts = gameBatterOuts;
        this.gameWin = gameWin;
        this.gameLoss = gameLoss;
        this.gameSave = gameSave;
        this.gameShutOut = gameShutOut;
        this.gameCompleteGame = gameCompleteGame;
        this.gameDoublePlaysStarted = gameDoublePlaysStarted;
        this.gameCatcherRunnersThrownOut = gameCatcherRunnersThrownOut;
        this.gameCatcherRunnersSuccessful = gameCatcherRunnersSuccessful;
        this.gameRispAtBat = gameRispAtBat;
        this.gameRispHit = gameRispHit;
        this.gameRispRbi = gameRispRbi;
        this.gameRispSingle = gameRispSingle;
        this.gameRispDouble = gameRispDouble;
        this.gameRispTriple = gameRispTriple;
        this.gameRispHomeRun = gameRispHomeRun;
        this.gameRispGdp = gameRispGdp;
        this.gameRispWalk = gameRispWalk;
        this.gameRispStrikeOut = gameRispStrikeOut;
        this.gameRispHitByPitch = gameRispHitByPitch;
        this.gameLeftOnBase = gameLeftOnBase;
        this.gamePinchAtBat = gamePinchAtBat;
        this.gamePinchHitHit = gamePinchHitHit;
        this.gamePinchHitRbi = gamePinchHitRbi;
        this.gamePinchHitSingle = gamePinchHitSingle;
        this.gamePinchHitDouble = gamePinchHitDouble;
        this.gamePinchHitTriple = gamePinchHitTriple;
        this.gamePinchHitHomeRun = gamePinchHitHomeRun;
        this.gamePinchHitGdp = gamePinchHitGdp;
        this.gamePinchHitWalk = gamePinchHitWalk;
        this.gamePinchHitStrikeOut = gamePinchHitStrikeOut;
        this.battingOrder = battingOrder;
        this.batterStats = batterStats;
        this.pitcherStats = pitcherStats;
    }

    public int getGameKey()
    {
        return gameKey;
    }

    public void setGameKey( int gameKey )
    {
        this.gameKey = gameKey;
    }

    public int getGameStarted()
    {
        return gameStarted;
    }

    public void setGameStarted( int gameStarted )
    {
        this.gameStarted = gameStarted;
    }

    public int getGamePlayed()
    {
        return gamePlayed;
    }

    public void setGamePlayed( int gamePlayed )
    {
        this.gamePlayed = gamePlayed;
    }

    public int getGameAtBats()
    {
        return gameAtBats;
    }

    public void setGameAtBats( int gameAtBats )
    {
        this.gameAtBats = gameAtBats;
    }

    public int getGameHits()
    {
        return gameHits;
    }

    public void setGameHits( int gameHits )
    {
        this.gameHits = gameHits;
    }

    public int getGameRuns()
    {
        return gameRuns;
    }

    public void setGameRuns( int gameRuns )
    {
        this.gameRuns = gameRuns;
    }

    public int getGameRbi()
    {
        return gameRbi;
    }

    public void setGameRbi( int gameRbi )
    {
        this.gameRbi = gameRbi;
    }

    public int getGameStolenBases()
    {
        return gameStolenBases;
    }

    public void setGameStolenBases( int gameStolenBases )
    {
        this.gameStolenBases = gameStolenBases;
    }

    public int getGameCaughtStealing()
    {
        return gameCaughtStealing;
    }

    public void setGameCaughtStealing( int gameCaughtStealing )
    {
        this.gameCaughtStealing = gameCaughtStealing;
    }

    public int getGameErrors()
    {
        return gameErrors;
    }

    public void setGameErrors( int gameErrors )
    {
        this.gameErrors = gameErrors;
    }

    public int getGamePutOuts()
    {
        return gamePutOuts;
    }

    public void setGamePutOuts( int gamePutOuts )
    {
        this.gamePutOuts = gamePutOuts;
    }

    public int getGameAssists()
    {
        return gameAssists;
    }

    public void setGameAssists( int gameAssists )
    {
        this.gameAssists = gameAssists;
    }

    public int getGameDoubles()
    {
        return gameDoubles;
    }

    public void setGameDoubles( int gameDoubles )
    {
        this.gameDoubles = gameDoubles;
    }

    public int getGameTriples()
    {
        return gameTriples;
    }

    public void setGameTriples( int gameTriples )
    {
        this.gameTriples = gameTriples;
    }

    public int getGameHomeRuns()
    {
        return gameHomeRuns;
    }

    public void setGameHomeRuns( int gameHomeRuns )
    {
        this.gameHomeRuns = gameHomeRuns;
    }

    public int getGameWalks()
    {
        return gameWalks;
    }

    public void setGameWalks( int gameWalks )
    {
        this.gameWalks = gameWalks;
    }

    public int getGameStrikeOuts()
    {
        return gameStrikeOuts;
    }

    public void setGameStrikeOuts( int gameStrikeOuts )
    {
        this.gameStrikeOuts = gameStrikeOuts;
    }

    public int getGameGdp()
    {
        return gameGdp;
    }

    public void setGameGdp( int gameGdp )
    {
        this.gameGdp = gameGdp;
    }

    public int getGameSacFly()
    {
        return gameSacFly;
    }

    public void setGameSacFly( int gameSacFly )
    {
        this.gameSacFly = gameSacFly;
    }

    public int getGameSacHit()
    {
        return gameSacHit;
    }

    public void setGameSacHit( int gameSacHit )
    {
        this.gameSacHit = gameSacHit;
    }

    public int getGameHitByPitch()
    {
        return gameHitByPitch;
    }

    public void setGameHitByPitch( int gameHitByPitch )
    {
        this.gameHitByPitch = gameHitByPitch;
    }

    public int getGameHitsAllowed()
    {
        return gameHitsAllowed;
    }

    public void setGameHitsAllowed( int gameHitsAllowed )
    {
        this.gameHitsAllowed = gameHitsAllowed;
    }

    public int getGameWalksAllowed()
    {
        return gameWalksAllowed;
    }

    public void setGameWalksAllowed( int gameWalksAllowed )
    {
        this.gameWalksAllowed = gameWalksAllowed;
    }

    public int getGameRunsAllowed()
    {
        return gameRunsAllowed;
    }

    public void setGameRunsAllowed( int gameRunsAllowed )
    {
        this.gameRunsAllowed = gameRunsAllowed;
    }

    public int getGameUnearnedRunsAllowed()
    {
        return gameUnearnedRunsAllowed;
    }

    public void setGameUnearnedRunsAllowed( int gameUnearnedRunsAllowed )
    {
        this.gameUnearnedRunsAllowed = gameUnearnedRunsAllowed;
    }

    public int getGameHomeRunsAllowed()
    {
        return gameHomeRunsAllowed;
    }

    public void setGameHomeRunsAllowed( int gameHomeRunsAllowed )
    {
        this.gameHomeRunsAllowed = gameHomeRunsAllowed;
    }

    public int getGameHitBatters()
    {
        return gameHitBatters;
    }

    public void setGameHitBatters( int gameHitBatters )
    {
        this.gameHitBatters = gameHitBatters;
    }

    public double getGameInningsPitched()
    {
        return gameInningsPitched;
    }

    public void setGameInningsPitched( double gameInningsPitched )
    {
        this.gameInningsPitched = gameInningsPitched;
    }

    public int getGameStrikeOutsAllowed()
    {
        return gameStrikeOutsAllowed;
    }

    public void setGameStrikeOutsAllowed( int gameStrikeOutsAllowed )
    {
        this.gameStrikeOutsAllowed = gameStrikeOutsAllowed;
    }

    public int getGameBatterOuts()
    {
        return gameBatterOuts;
    }

    public void setGameBatterOuts( int gameBatterOuts )
    {
        this.gameBatterOuts = gameBatterOuts;
    }

    public int getGameWin()
    {
        return gameWin;
    }

    public void setGameWin( int gameWin )
    {
        this.gameWin = gameWin;
    }

    public int getGameLoss()
    {
        return gameLoss;
    }

    public void setGameLoss( int gameLoss )
    {
        this.gameLoss = gameLoss;
    }

    public int getGameSave()
    {
        return gameSave;
    }

    public void setGameSave( int gameSave )
    {
        this.gameSave = gameSave;
    }

    public int getGameShutOut()
    {
        return gameShutOut;
    }

    public void setGameShutOut( int gameShutOut )
    {
        this.gameShutOut = gameShutOut;
    }

    public int getGameCompleteGame()
    {
        return gameCompleteGame;
    }

    public void setGameCompleteGame( int gameCompleteGame )
    {
        this.gameCompleteGame = gameCompleteGame;
    }

    public int getGameDoublePlaysStarted()
    {
        return gameDoublePlaysStarted;
    }

    public void setGameDoublePlaysStarted( int gameDoublePlaysStarted )
    {
        this.gameDoublePlaysStarted = gameDoublePlaysStarted;
    }

    public int getGameCatcherRunnersThrownOut()
    {
        return gameCatcherRunnersThrownOut;
    }

    public void setGameCatcherRunnersThrownOut( int gameCatcherRunnersThrownOut )
    {
        this.gameCatcherRunnersThrownOut = gameCatcherRunnersThrownOut;
    }

    public int getGameCatcherRunnersSuccessful()
    {
        return gameCatcherRunnersSuccessful;
    }

    public void setGameCatcherRunnersSuccessful( int gameCatcherRunnersSuccessful )
    {
        this.gameCatcherRunnersSuccessful = gameCatcherRunnersSuccessful;
    }

    public int getGameRispAtBat()
    {
        return gameRispAtBat;
    }

    public void setGameRispAtBat( int gameRispAtBat )
    {
        this.gameRispAtBat = gameRispAtBat;
    }

    public int getGameRispHit()
    {
        return gameRispHit;
    }

    public void setGameRispHit( int gameRispHit )
    {
        this.gameRispHit = gameRispHit;
    }

    public int getGameRispRbi()
    {
        return gameRispRbi;
    }

    public void setGameRispRbi( int gameRispRbi )
    {
        this.gameRispRbi = gameRispRbi;
    }

    public int getGameRispSingle()
    {
        return gameRispSingle;
    }

    public void setGameRispSingle( int gameRispSingle )
    {
        this.gameRispSingle = gameRispSingle;
    }

    public int getGameRispDouble()
    {
        return gameRispDouble;
    }

    public void setGameRispDouble( int gameRispDouble )
    {
        this.gameRispDouble = gameRispDouble;
    }

    public int getGameRispTriple()
    {
        return gameRispTriple;
    }

    public void setGameRispTriple( int gameRispTriple )
    {
        this.gameRispTriple = gameRispTriple;
    }

    public int getGameRispHomeRun()
    {
        return gameRispHomeRun;
    }

    public void setGameRispHomeRun( int gameRispHomeRun )
    {
        this.gameRispHomeRun = gameRispHomeRun;
    }

    public int getGameRispGdp()
    {
        return gameRispGdp;
    }

    public void setGameRispGdp( int gameRispGdp )
    {
        this.gameRispGdp = gameRispGdp;
    }

    public int getGameRispWalk()
    {
        return gameRispWalk;
    }

    public void setGameRispWalk( int gameRispWalk )
    {
        this.gameRispWalk = gameRispWalk;
    }

    public int getGameRispStrikeOut()
    {
        return gameRispStrikeOut;
    }

    public void setGameRispStrikeOut( int gameRispStrikeOut )
    {
        this.gameRispStrikeOut = gameRispStrikeOut;
    }

    public int getGameRispHitByPitch()
    {
        return gameRispHitByPitch;
    }

    public void setGameRispHitByPitch( int gameRispHitByPitch )
    {
        this.gameRispHitByPitch = gameRispHitByPitch;
    }

    public int getGameLeftOnBase()
    {
        return gameLeftOnBase;
    }

    public void setGameLeftOnBase( int gameLeftOnBase )
    {
        this.gameLeftOnBase = gameLeftOnBase;
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

    public int getGamePinchHitRbi()
    {
        return gamePinchHitRbi;
    }

    public void setGamePinchHitRbi( int gamePinchHitRbi )
    {
        this.gamePinchHitRbi = gamePinchHitRbi;
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

    public int getGamePinchHitGdp()
    {
        return gamePinchHitGdp;
    }

    public void setGamePinchHitGdp( int gamePinchHitGdp )
    {
        this.gamePinchHitGdp = gamePinchHitGdp;
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

    public int getBattingOrder()
    {
        return battingOrder;
    }

    public void setBattingOrder( int battingOrder )
    {
        this.battingOrder = battingOrder;
    }

    public BatterStats getBatterStats()
    {
        return batterStats;
    }

    public void setBatterStats( BatterStats batterStats )
    {
        this.batterStats = batterStats;
    }

    public PitcherStats getPitcherStats()
    {
        return pitcherStats;
    }

    public void setPitcherStats( PitcherStats pitcherStats )
    {
        this.pitcherStats = pitcherStats;
    }

    public String getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID( String playerID )
    {
        this.playerID = playerID;
    }

    public String getGameNumber()
    {
        return gameNumber;
    }

    public void setGameNumber( String gameNumber )
    {
        this.gameNumber = gameNumber;
    }

    public String getTeamID()
    {
        return teamID;
    }

    public void setTeamID( String teamID )
    {
        this.teamID = teamID;
    }

    public String getNameFirst()
    {
        return nameFirst;
    }

    public void setNameFirst( String nameFirst )
    {
        this.nameFirst = nameFirst;
    }

    public String getNameLast()
    {
        return nameLast;
    }

    public void setNameLast( String nameLast )
    {
        this.nameLast = nameLast;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition( String position )
    {
        this.position = position;
    }

    public String getRound()
    {
        return round;
    }

    public void setRound( String round )
    {
        this.round = round;
    }

    public String getSimName()
    {
        return simName;
    }

    public void setSimName( String simName )
    {
        this.simName = simName;
    }

    public String getGameField()
    {
        return gameField;
    }

    public void setGameField( String gameField )
    {
        this.gameField = gameField;
    }

    public String getLgID()
    {
        return lgID;
    }

    public void setLgID( String lgID )
    {
        this.lgID = lgID;
    }

    public int getSimNumber()
    {
        return simNumber;
    }

    public void setSimNumber( int simNumber )
    {
        this.simNumber = simNumber;
    }

    public int getYearID()
    {
        return yearID;
    }

    public void setYearID( int yearID )
    {
        this.yearID = yearID;
    }
}

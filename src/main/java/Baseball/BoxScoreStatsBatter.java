package Baseball;

import java.math.BigDecimal;

public class BoxScoreStatsBatter
{
    private BigDecimal gameStarted, gamePlayed, gameAtBats, gameHits, gameRuns, gameRbi, gameStolenBases, gameCaughtStealing,
            gameErrors, gamePutOuts, gameAssists, gameDoubles, gameTriples, gameHomeRuns, gameWalks, gameStrikeOuts, gameGdp,
            gameSacFly, gameHitByPitch, gameDoublePlaysStarted, gameCatcherRunnersThrownOut, gameRispAtBat, gameRispHit,
            gameRispRun, gameRispRbi, gameRispSingle, gameRispDouble, gameRispTriple, gameRispHomeRun, gameRispGdp, gameRispWalk,
            gameRispStrikeOut, gameRispHitByPitch, gameLeftOnBase, gamePinchAtBat, gamePinchHitHit, battingOrder, simNumber;

    public BoxScoreStatsBatter()
    {
    }

    public BoxScoreStatsBatter( BigDecimal gameStarted, BigDecimal gamePlayed, BigDecimal gameAtBats, BigDecimal gameHits, BigDecimal gameRuns, BigDecimal gameRbi, BigDecimal gameStolenBases, BigDecimal gameCaughtStealing, BigDecimal gameErrors, BigDecimal gamePutOuts, BigDecimal gameAssists, BigDecimal gameDoubles, BigDecimal gameTriples, BigDecimal gameHomeRuns, BigDecimal gameWalks, BigDecimal gameStrikeOuts, BigDecimal gameGdp, BigDecimal gameSacFly, BigDecimal gameHitByPitch, BigDecimal gameDoublePlaysStarted, BigDecimal gameCatcherRunnersThrownOut, BigDecimal gameRispAtBat, BigDecimal gameRispHit, BigDecimal gameRispRun, BigDecimal gameRispRbi, BigDecimal gameRispSingle, BigDecimal gameRispDouble, BigDecimal gameRispTriple, BigDecimal gameRispHomeRun, BigDecimal gameRispGdp, BigDecimal gameRispWalk, BigDecimal gameRispStrikeOut, BigDecimal gameRispHitByPitch, BigDecimal gameLeftOnBase, BigDecimal gamePinchAtBat, BigDecimal gamePinchHitHit, BigDecimal battingOrder, BigDecimal simNumber )
    {
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
        this.gameHitByPitch = gameHitByPitch;
        this.gameDoublePlaysStarted = gameDoublePlaysStarted;
        this.gameCatcherRunnersThrownOut = gameCatcherRunnersThrownOut;
        this.gameRispAtBat = gameRispAtBat;
        this.gameRispHit = gameRispHit;
        this.gameRispRun = gameRispRun;
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
        this.battingOrder = battingOrder;
        this.simNumber = simNumber;
    }

    public BigDecimal getGameStarted()
    {
        return gameStarted;
    }

    public void setGameStarted( BigDecimal gameStarted )
    {
        this.gameStarted = gameStarted;
    }

    public BigDecimal getGamePlayed()
    {
        return gamePlayed;
    }

    public void setGamePlayed( BigDecimal gamePlayed )
    {
        this.gamePlayed = gamePlayed;
    }

    public BigDecimal getGameAtBats()
    {
        return gameAtBats;
    }

    public void setGameAtBats( BigDecimal gameAtBats )
    {
        this.gameAtBats = gameAtBats;
    }

    public BigDecimal getGameHits()
    {
        return gameHits;
    }

    public void setGameHits( BigDecimal gameHits )
    {
        this.gameHits = gameHits;
    }

    public BigDecimal getGameRuns()
    {
        return gameRuns;
    }

    public void setGameRuns( BigDecimal gameRuns )
    {
        this.gameRuns = gameRuns;
    }

    public BigDecimal getGameRbi()
    {
        return gameRbi;
    }

    public void setGameRbi( BigDecimal gameRbi )
    {
        this.gameRbi = gameRbi;
    }

    public BigDecimal getGameStolenBases()
    {
        return gameStolenBases;
    }

    public void setGameStolenBases( BigDecimal gameStolenBases )
    {
        this.gameStolenBases = gameStolenBases;
    }

    public BigDecimal getGameCaughtStealing()
    {
        return gameCaughtStealing;
    }

    public void setGameCaughtStealing( BigDecimal gameCaughtStealing )
    {
        this.gameCaughtStealing = gameCaughtStealing;
    }

    public BigDecimal getGameErrors()
    {
        return gameErrors;
    }

    public void setGameErrors( BigDecimal gameErrors )
    {
        this.gameErrors = gameErrors;
    }

    public BigDecimal getGamePutOuts()
    {
        return gamePutOuts;
    }

    public void setGamePutOuts( BigDecimal gamePutOuts )
    {
        this.gamePutOuts = gamePutOuts;
    }

    public BigDecimal getGameAssists()
    {
        return gameAssists;
    }

    public void setGameAssists( BigDecimal gameAssists )
    {
        this.gameAssists = gameAssists;
    }

    public BigDecimal getGameDoubles()
    {
        return gameDoubles;
    }

    public void setGameDoubles( BigDecimal gameDoubles )
    {
        this.gameDoubles = gameDoubles;
    }

    public BigDecimal getGameTriples()
    {
        return gameTriples;
    }

    public void setGameTriples( BigDecimal gameTriples )
    {
        this.gameTriples = gameTriples;
    }

    public BigDecimal getGameHomeRuns()
    {
        return gameHomeRuns;
    }

    public void setGameHomeRuns( BigDecimal gameHomeRuns )
    {
        this.gameHomeRuns = gameHomeRuns;
    }

    public BigDecimal getGameWalks()
    {
        return gameWalks;
    }

    public void setGameWalks( BigDecimal gameWalks )
    {
        this.gameWalks = gameWalks;
    }

    public BigDecimal getGameStrikeOuts()
    {
        return gameStrikeOuts;
    }

    public void setGameStrikeOuts( BigDecimal gameStrikeOuts )
    {
        this.gameStrikeOuts = gameStrikeOuts;
    }

    public BigDecimal getGameGdp()
    {
        return gameGdp;
    }

    public void setGameGdp( BigDecimal gameGdp )
    {
        this.gameGdp = gameGdp;
    }

    public BigDecimal getGameSacFly()
    {
        return gameSacFly;
    }

    public void setGameSacFly( BigDecimal gameSacFly )
    {
        this.gameSacFly = gameSacFly;
    }

    public BigDecimal getGameHitByPitch()
    {
        return gameHitByPitch;
    }

    public void setGameHitByPitch( BigDecimal gameHitByPitch )
    {
        this.gameHitByPitch = gameHitByPitch;
    }

    public BigDecimal getGameDoublePlaysStarted()
    {
        return gameDoublePlaysStarted;
    }

    public void setGameDoublePlaysStarted( BigDecimal gameDoublePlaysStarted )
    {
        this.gameDoublePlaysStarted = gameDoublePlaysStarted;
    }

    public BigDecimal getGameCatcherRunnersThrownOut()
    {
        return gameCatcherRunnersThrownOut;
    }

    public void setGameCatcherRunnersThrownOut( BigDecimal gameCatcherRunnersThrownOut )
    {
        this.gameCatcherRunnersThrownOut = gameCatcherRunnersThrownOut;
    }

    public BigDecimal getGameRispAtBat()
    {
        return gameRispAtBat;
    }

    public void setGameRispAtBat( BigDecimal gameRispAtBat )
    {
        this.gameRispAtBat = gameRispAtBat;
    }

    public BigDecimal getGameRispHit()
    {
        return gameRispHit;
    }

    public void setGameRispHit( BigDecimal gameRispHit )
    {
        this.gameRispHit = gameRispHit;
    }

    public BigDecimal getGameRispRun()
    {
        return gameRispRun;
    }

    public void setGameRispRun( BigDecimal gameRispRun )
    {
        this.gameRispRun = gameRispRun;
    }

    public BigDecimal getGameRispRbi()
    {
        return gameRispRbi;
    }

    public void setGameRispRbi( BigDecimal gameRispRbi )
    {
        this.gameRispRbi = gameRispRbi;
    }

    public BigDecimal getGameRispSingle()
    {
        return gameRispSingle;
    }

    public void setGameRispSingle( BigDecimal gameRispSingle )
    {
        this.gameRispSingle = gameRispSingle;
    }

    public BigDecimal getGameRispDouble()
    {
        return gameRispDouble;
    }

    public void setGameRispDouble( BigDecimal gameRispDouble )
    {
        this.gameRispDouble = gameRispDouble;
    }

    public BigDecimal getGameRispTriple()
    {
        return gameRispTriple;
    }

    public void setGameRispTriple( BigDecimal gameRispTriple )
    {
        this.gameRispTriple = gameRispTriple;
    }

    public BigDecimal getGameRispHomeRun()
    {
        return gameRispHomeRun;
    }

    public void setGameRispHomeRun( BigDecimal gameRispHomeRun )
    {
        this.gameRispHomeRun = gameRispHomeRun;
    }

    public BigDecimal getGameRispGdp()
    {
        return gameRispGdp;
    }

    public void setGameRispGdp( BigDecimal gameRispGdp )
    {
        this.gameRispGdp = gameRispGdp;
    }

    public BigDecimal getGameRispWalk()
    {
        return gameRispWalk;
    }

    public void setGameRispWalk( BigDecimal gameRispWalk )
    {
        this.gameRispWalk = gameRispWalk;
    }

    public BigDecimal getGameRispStrikeOut()
    {
        return gameRispStrikeOut;
    }

    public void setGameRispStrikeOut( BigDecimal gameRispStrikeOut )
    {
        this.gameRispStrikeOut = gameRispStrikeOut;
    }

    public BigDecimal getGameRispHitByPitch()
    {
        return gameRispHitByPitch;
    }

    public void setGameRispHitByPitch( BigDecimal gameRispHitByPitch )
    {
        this.gameRispHitByPitch = gameRispHitByPitch;
    }

    public BigDecimal getGameLeftOnBase()
    {
        return gameLeftOnBase;
    }

    public void setGameLeftOnBase( BigDecimal gameLeftOnBase )
    {
        this.gameLeftOnBase = gameLeftOnBase;
    }

    public BigDecimal getGamePinchAtBat()
    {
        return gamePinchAtBat;
    }

    public void setGamePinchAtBat( BigDecimal gamePinchAtBat )
    {
        this.gamePinchAtBat = gamePinchAtBat;
    }

    public BigDecimal getGamePinchHitHit()
    {
        return gamePinchHitHit;
    }

    public void setGamePinchHitHit( BigDecimal gamePinchHitHit )
    {
        this.gamePinchHitHit = gamePinchHitHit;
    }

    public BigDecimal getBattingOrder()
    {
        return battingOrder;
    }

    public void setBattingOrder( BigDecimal battingOrder )
    {
        this.battingOrder = battingOrder;
    }

    public BigDecimal getSimNumber()
    {
        return simNumber;
    }

    public void setSimNumber( BigDecimal simNumber )
    {
        this.simNumber = simNumber;
    }
}

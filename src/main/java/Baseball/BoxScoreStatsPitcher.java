package Baseball;

import java.math.BigDecimal;

public class BoxScoreStatsPitcher
{
    private BigDecimal gameHitsAllowed, gameWalksAllowed, gameRunsAllowed, gameUnearnedRunsAllowed, gameHomeRunsAllowed,
    gameHitBatters, gameInningsPitched, gameStrikeOutsAllowed, gameBatter,Outs, gameWin, gameLoss, gameSave, gameShutOut,
    gameCompleteGame;

    public BoxScoreStatsPitcher()
    {
    }

    public BoxScoreStatsPitcher( BigDecimal gameHitsAllowed, BigDecimal gameWalksAllowed, BigDecimal gameRunsAllowed, BigDecimal gameUnearnedRunsAllowed, BigDecimal gameHomeRunsAllowed, BigDecimal gameHitBatters, BigDecimal gameInningsPitched, BigDecimal gameStrikeOutsAllowed, BigDecimal gameBatter, BigDecimal outs, BigDecimal gameWin, BigDecimal gameLoss, BigDecimal gameSave, BigDecimal gameShutOut, BigDecimal gameCompleteGame )
    {
        this.gameHitsAllowed = gameHitsAllowed;
        this.gameWalksAllowed = gameWalksAllowed;
        this.gameRunsAllowed = gameRunsAllowed;
        this.gameUnearnedRunsAllowed = gameUnearnedRunsAllowed;
        this.gameHomeRunsAllowed = gameHomeRunsAllowed;
        this.gameHitBatters = gameHitBatters;
        this.gameInningsPitched = gameInningsPitched;
        this.gameStrikeOutsAllowed = gameStrikeOutsAllowed;
        this.gameBatter = gameBatter;
        Outs = outs;
        this.gameWin = gameWin;
        this.gameLoss = gameLoss;
        this.gameSave = gameSave;
        this.gameShutOut = gameShutOut;
        this.gameCompleteGame = gameCompleteGame;
    }

    public BigDecimal getGameHitsAllowed()
    {
        return gameHitsAllowed;
    }

    public void setGameHitsAllowed( BigDecimal gameHitsAllowed )
    {
        this.gameHitsAllowed = gameHitsAllowed;
    }

    public BigDecimal getGameWalksAllowed()
    {
        return gameWalksAllowed;
    }

    public void setGameWalksAllowed( BigDecimal gameWalksAllowed )
    {
        this.gameWalksAllowed = gameWalksAllowed;
    }

    public BigDecimal getGameRunsAllowed()
    {
        return gameRunsAllowed;
    }

    public void setGameRunsAllowed( BigDecimal gameRunsAllowed )
    {
        this.gameRunsAllowed = gameRunsAllowed;
    }

    public BigDecimal getGameUnearnedRunsAllowed()
    {
        return gameUnearnedRunsAllowed;
    }

    public void setGameUnearnedRunsAllowed( BigDecimal gameUnearnedRunsAllowed )
    {
        this.gameUnearnedRunsAllowed = gameUnearnedRunsAllowed;
    }

    public BigDecimal getGameHomeRunsAllowed()
    {
        return gameHomeRunsAllowed;
    }

    public void setGameHomeRunsAllowed( BigDecimal gameHomeRunsAllowed )
    {
        this.gameHomeRunsAllowed = gameHomeRunsAllowed;
    }

    public BigDecimal getGameHitBatters()
    {
        return gameHitBatters;
    }

    public void setGameHitBatters( BigDecimal gameHitBatters )
    {
        this.gameHitBatters = gameHitBatters;
    }

    public BigDecimal getGameInningsPitched()
    {
        return gameInningsPitched;
    }

    public void setGameInningsPitched( BigDecimal gameInningsPitched )
    {
        this.gameInningsPitched = gameInningsPitched;
    }

    public BigDecimal getGameStrikeOutsAllowed()
    {
        return gameStrikeOutsAllowed;
    }

    public void setGameStrikeOutsAllowed( BigDecimal gameStrikeOutsAllowed )
    {
        this.gameStrikeOutsAllowed = gameStrikeOutsAllowed;
    }

    public BigDecimal getGameBatter()
    {
        return gameBatter;
    }

    public void setGameBatter( BigDecimal gameBatter )
    {
        this.gameBatter = gameBatter;
    }

    public BigDecimal getOuts()
    {
        return Outs;
    }

    public void setOuts( BigDecimal outs )
    {
        Outs = outs;
    }

    public BigDecimal getGameWin()
    {
        return gameWin;
    }

    public void setGameWin( BigDecimal gameWin )
    {
        this.gameWin = gameWin;
    }

    public BigDecimal getGameLoss()
    {
        return gameLoss;
    }

    public void setGameLoss( BigDecimal gameLoss )
    {
        this.gameLoss = gameLoss;
    }

    public BigDecimal getGameSave()
    {
        return gameSave;
    }

    public void setGameSave( BigDecimal gameSave )
    {
        this.gameSave = gameSave;
    }

    public BigDecimal getGameShutOut()
    {
        return gameShutOut;
    }

    public void setGameShutOut( BigDecimal gameShutOut )
    {
        this.gameShutOut = gameShutOut;
    }

    public BigDecimal getGameCompleteGame()
    {
        return gameCompleteGame;
    }

    public void setGameCompleteGame( BigDecimal gameCompleteGame )
    {
        this.gameCompleteGame = gameCompleteGame;
    }
}

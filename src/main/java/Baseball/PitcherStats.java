package Baseball;

import java.time.LocalDate;
import java.util.List;

public class PitcherStats {
    private double probabilityHomeRun, probabilityTriple, probabilityDouble, probabilitySingle, probabilityWalk,
            probabilityStrikeOut, probabilityHitBatter, era, actualPlayPercent, histPercentPlayed, sumInningsPitchedOuts;

    private int earnedRuns, gameBattersFaced, gameHitsAllowed, hitBatters,
            gameRunsAllowed, gameStrikeOutsAllowed, gameWalksAllowed, gameHomeRunsAllowed, gameEarnedRunsAllowed,
            gameUnearnedRunsAllowed, unearnedRunsAllowed, gameHitByPitch, gameInningsPitchedOuts, gameGameStarted,
            gameGamePlayed, wins,
            losses, saves, gamesPlayed, gamesStarted, shutOuts, completeGames, iPouts,
            inningsPitched, hitsAllowed, homeRunsAllowed, walksAllowed, strikeOutsAllowed,
            intentionalWalksAllowed, wildPitches, balks, battersFaced, gamesFinished, sacrificeHits, sacrificeFlies,
            groundedIntoDoublePlays, runs, gameShutOuts, gameCompleteGame, gameWin, gameLoss, gameSave,
            sGamesPlayed, sGamesStarted, sBattersFaced, sHitsAllowed, sHitBatters, sEarnedRuns, sRunsAllowed,
            sStrikeOutAllowed, sWalksAllowed, sHomeRunsAllowed, sInningsPitchedOuts, sShutOuts, sCompleteGames,
            sWins, sLosses, sSaves, daysRest, sumWins, sumLosses, sumSaves, sumGamesStarted, sumGamesPlayed, sumStrikeOutsAllowed;

    public int getSumWins() {
        return sumWins;
    }

    public void setSumWins(int sumWins) {
        this.sumWins = sumWins;
    }

    public int getSumLosses() {
        return sumLosses;
    }

    public void setSumLosses(int sumLosses) {
        this.sumLosses = sumLosses;
    }

    public int getSumSaves() {
        return sumSaves;
    }

    public void setSumSaves(int sumSaves) {
        this.sumSaves = sumSaves;
    }

    public int getSumGamesStarted() {
        return sumGamesStarted;
    }

    public void setSumGamesStarted(int sumGamesStarted) {
        this.sumGamesStarted = sumGamesStarted;
    }

    public int getSumGamesPlayed() {
        return sumGamesPlayed;
    }

    public void setSumGamesPlayed(int sumGamesPlayed) {
        this.sumGamesPlayed = sumGamesPlayed;
    }

    public double getSumInningsPitchedOuts() {
        return sumInningsPitchedOuts;
    }

    public void setSumInningsPitchedOuts(double sumInningsPitchedOuts) {
        this.sumInningsPitchedOuts = sumInningsPitchedOuts;
    }

    public int getSumStrikeOutsAllowed() {
        return sumStrikeOutsAllowed;
    }

    public void setSumStrikeOutsAllowed(int sumStrikeOutsAllowed) {
        this.sumStrikeOutsAllowed = sumStrikeOutsAllowed;
    }

    private LocalDate lastGameDatePitched;

    LocalDate getLastGameDatePitched() {
        return lastGameDatePitched;
    }

    void setLastGameDatePitched(LocalDate lastGameDatePitched) {
        this.lastGameDatePitched = lastGameDatePitched;
    }

    int getDaysRest() {
        return daysRest;
    }

    void setDaysRest(int daysRest) {
        this.daysRest = daysRest;
    }

    double getActualPlayPercent() {
        return actualPlayPercent;
    }

    void setActualPlayPercent(double actualPlayPercent) {
        this.actualPlayPercent = actualPlayPercent;
    }

    double getHistPercentPlayed() {
        return histPercentPlayed;
    }

    void setHistPercentPlayed(double histPercentPlayed) {
        this.histPercentPlayed = histPercentPlayed;
    }

    int getGameGameStarted() {
        return gameGameStarted;
    }

    void setGameGameStarted(int gameGameStarted) {
        this.gameGameStarted = gameGameStarted;
    }

    int getGameGamePlayed() {
        return gameGamePlayed;
    }

    void setGameGamePlayed(int gameGamePlayed) {
        this.gameGamePlayed = gameGamePlayed;
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

    public int getsBattersFaced() {
        return sBattersFaced;
    }

    public void setsBattersFaced(int sBattersFaced) {
        this.sBattersFaced = sBattersFaced;
    }

    public int getsHitsAllowed() {
        return sHitsAllowed;
    }

    public void setsHitsAllowed(int sHitsAllowed) {
        this.sHitsAllowed = sHitsAllowed;
    }

    public int getsHitBatters() {
        return sHitBatters;
    }

    public void setsHitBatters(int sHitBatters) {
        this.sHitBatters = sHitBatters;
    }

    public int getsEarnedRuns() {
        return sEarnedRuns;
    }

    public void setsEarnedRuns(int sEarnedRuns) {
        this.sEarnedRuns = sEarnedRuns;
    }

    public int getsRunsAllowed() {
        return sRunsAllowed;
    }

    public void setsRunsAllowed(int sRunsAllowed) {
        this.sRunsAllowed = sRunsAllowed;
    }

    public int getsStrikeOutAllowed() {
        return sStrikeOutAllowed;
    }

    public void setsStrikeOutAllowed(int sStrikeOutAllowed) {
        this.sStrikeOutAllowed = sStrikeOutAllowed;
    }

    public int getsWalksAllowed() {
        return sWalksAllowed;
    }

    public void setsWalksAllowed(int sWalksAllowed) {
        this.sWalksAllowed = sWalksAllowed;
    }

    public int getsHomeRunsAllowed() {
        return sHomeRunsAllowed;
    }

    public void setsHomeRunsAllowed(int sHomeRunsAllowed) {
        this.sHomeRunsAllowed = sHomeRunsAllowed;
    }

    public int getsInningsPitchedOuts() {
        return sInningsPitchedOuts;
    }

    public void setsInningsPitchedOuts(int sInningsPitchedOuts) {
        this.sInningsPitchedOuts = sInningsPitchedOuts;
    }

    public int getsShutOuts() {
        return sShutOuts;
    }

    public void setsShutOuts(int sShutOuts) {
        this.sShutOuts = sShutOuts;
    }

    public int getsCompleteGames() {
        return sCompleteGames;
    }

    public void setsCompleteGames(int sCompleteGames) {
        this.sCompleteGames = sCompleteGames;
    }

    public int getsWins() {
        return sWins;
    }

    public void setsWins(int sWins) {
        this.sWins = sWins;
    }

    public int getsLosses() {
        return sLosses;
    }

    public void setsLosses(int sLosses) {
        this.sLosses = sLosses;
    }

    public int getsSaves() {
        return sSaves;
    }

    public void setsSaves(int sSaves) {
        this.sSaves = sSaves;
    }

    public int getGameShutOuts() {
        return gameShutOuts;
    }

    public void setGameShutOuts(int gameShutOuts) {
        this.gameShutOuts = gameShutOuts;
    }

    public int getGameCompleteGame() {
        return gameCompleteGame;
    }

    public void setGameCompleteGame(int gameCompleteGame) {
        this.gameCompleteGame = gameCompleteGame;
    }

    int getGameWin() {
        return gameWin;
    }

    public void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    int getGameLoss() {
        return gameLoss;
    }

    public void setGameLoss(int gameLoss) {
        this.gameLoss = gameLoss;
    }

    int getGameSave() {
        return gameSave;
    }

    public void setGameSave(int gameSave) {
        this.gameSave = gameSave;
    }

    int getInningsPitched() {
        return inningsPitched;
    }

    public int getWins() {
        return wins;
    }

    void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    void setLosses(int losses) {
        this.losses = losses;
    }

    int getSaves() {
        return saves;
    }

    void setSaves(int saves) {
        this.saves = saves;
    }

    int getGamesPlayed() {
        return gamesPlayed;
    }

    void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    int getGamesStarted() {
        return gamesStarted;
    }

    void setGamesStarted(int gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public int getShutOuts() {
        return shutOuts;
    }

    void setShutOuts(int shutOuts) {
        this.shutOuts = shutOuts;
    }

    public int getCompleteGames() {
        return completeGames;
    }

    void setCompleteGames(int completeGames) {
        this.completeGames = completeGames;
    }

    int getiPouts() {
        return iPouts;
    }

    void setiPouts(int iPouts) {
        this.iPouts = iPouts;
    }

    public double getEra() {
        return era;
    }

    void setEra(double era) {
        this.era = era;
    }

    public int getIntentionalWalksAllowed() {
        return intentionalWalksAllowed;
    }

    void setIntentionalWalksAllowed(int intentionalWalksAllowed) {
        this.intentionalWalksAllowed = intentionalWalksAllowed;
    }

    public int getWildPitches() {
        return wildPitches;
    }

    void setWildPitches(int wildPitches) {
        this.wildPitches = wildPitches;
    }

    public int getBalks() {
        return balks;
    }

    void setBalks(int balks) {
        this.balks = balks;
    }

    public int getGamesFinished() {
        return gamesFinished;
    }

    void setGamesFinished(int gamesFinished) {
        this.gamesFinished = gamesFinished;
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

    void setSacrificeFlies(int sacrificeFlies) {
        this.sacrificeFlies = sacrificeFlies;
    }

    public int getGroundedIntoDoublePlays() {
        return groundedIntoDoublePlays;
    }

    void setGroundedIntoDoublePlays(int groundedIntoDoublePlays) {
        this.groundedIntoDoublePlays = groundedIntoDoublePlays;
    }

    int getRuns() {
        return runs;
    }

    void setRuns(int runs) {
        this.runs = runs;
    }

    void setInningsPitched(int inningsPitched) {
        this.inningsPitched = inningsPitched;
    }

    int getGameInningsPitchedOuts() {
        return gameInningsPitchedOuts;
    }

    void setGameInningsPitchedOuts(int gameInningsPitchedOuts) {
        this.gameInningsPitchedOuts = gameInningsPitchedOuts;
    }

    int getHitsAllowed() {
        return hitsAllowed;
    }

    void setHitsAllowed(int hitsAllowed) {
        this.hitsAllowed = hitsAllowed;
    }

    int getHomeRunsAllowed() {
        return homeRunsAllowed;
    }

    void setHomeRunsAllowed(int homeRunsAllowed) {
        this.homeRunsAllowed = homeRunsAllowed;
    }

    int getWalksAllowed() {
        return walksAllowed;
    }

    void setWalksAllowed(int walksAllowed) {
        this.walksAllowed = walksAllowed;
    }

    int getStrikeOutsAllowed() {
        return strikeOutsAllowed;
    }

    void setStrikeOutsAllowed(int strikeOutsAllowed) {
        this.strikeOutsAllowed = strikeOutsAllowed;
    }

    int getBattersFaced() {
        return battersFaced;
    }

    void setBattersFaced(int battersFaced) {
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

    double getProbabilitySingle() {
        return probabilitySingle;
    }

    private void setProbabilitySingle(double probabilitySingle) {
        this.probabilitySingle = probabilitySingle;
    }

    double getProbabilityWalk() {
        return probabilityWalk;
    }

    private void setProbabilityWalk(double probabilityWalk) {
        this.probabilityWalk = probabilityWalk;
    }

    double getProbabilityStrikeOut() {
        return probabilityStrikeOut;
    }

    private void setProbabilityStrikeOut(double probabilityStrikeOut) {
        this.probabilityStrikeOut = probabilityStrikeOut;
    }

    int getEarnedRuns() {
        return earnedRuns;
    }

    void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    void setGameBattersFaced(int gameBattersFaced) {
        this.gameBattersFaced = gameBattersFaced;
    }

    void setGameHitsAllowed(int gameHitsAllowed) {
        this.gameHitsAllowed = gameHitsAllowed;
    }

    void setGameRunsAllowed(int gameRunsAllowed) {
        this.gameRunsAllowed = gameRunsAllowed;
    }

    void setGameStrikeOutsAllowed(int gameStrikeOutsAllowed) {
        this.gameStrikeOutsAllowed = gameStrikeOutsAllowed;
    }

    int getGameHitByPitch() {
        return gameHitByPitch;
    }

    void setGameHitByPitch(int gameHitByPitch) {
        this.gameHitByPitch = gameHitByPitch;
    }

    void setGameWalksAllowed(int gameWalksAllowed) {
        this.gameWalksAllowed = gameWalksAllowed;
    }

    void setGameHomeRunsAllowed(int gameHomeRunsAllowed) {
        this.gameHomeRunsAllowed = gameHomeRunsAllowed;
    }

    int getGameEarnedRunsAllowed() {
        return gameEarnedRunsAllowed;
    }

    void setGameEarnedRunsAllowed(int gameEarnedRunsAllowed) {
        this.gameEarnedRunsAllowed = gameEarnedRunsAllowed;
    }

    double getProbabilityHitBatter() {
        return probabilityHitBatter;
    }

    int getGameBattersFaced() {
        return gameBattersFaced;
    }

    int getGameHitsAllowed() {
        return gameHitsAllowed;
    }

    int getGameRunsAllowed() {
        return gameRunsAllowed;
    }

    int getGameStrikeOutsAllowed() {
        return gameStrikeOutsAllowed;
    }

    int getGameWalksAllowed() {
        return gameWalksAllowed;
    }

    private void setProbabilityHitBatter(double probabilityHitBatter) {
        this.probabilityHitBatter = probabilityHitBatter;
    }

    int getGameHomeRunsAllowed() {
        return gameHomeRunsAllowed;
    }

    int getGameUnearnedRunsAllowed() {
        return gameUnearnedRunsAllowed;
    }

    void setGameUnearnedRunsAllowed(int gameUnearnedRunsAllowed) {
        this.gameUnearnedRunsAllowed = gameUnearnedRunsAllowed;
    }

    int getUnearnedRunsAllowed() {
        return unearnedRunsAllowed;
    }

    private void setUnearnedRunsAllowed(int unearnedRunsAllowed) {
        this.unearnedRunsAllowed = unearnedRunsAllowed;
    }

    void calculatePitcherProbabilities() {
        double homers = getHomeRunsAllowed();
        double batters = getBattersFaced();
        double hits = getHitsAllowed();
        double walks = getWalksAllowed();
        double strikeOuts = getStrikeOutsAllowed();
        double hitBatsmen = getHitBatters();
        setProbabilityHomeRun(homers / batters);
        setProbabilityTriple((hits * .024) / batters);
        setProbabilityDouble((hits * .174) / batters);
        setProbabilitySingle((hits / batters) - getProbabilityHomeRun() - getProbabilityTriple() - getProbabilityDouble());
        setProbabilityWalk(walks /batters);
        setProbabilityStrikeOut(strikeOuts / batters);
        setProbabilityHitBatter(hitBatsmen / batters);


    }

    public void updatePitcherStats(int gameBattersFaced, int gameHitsAllowed, int gameStrikeOutsAllowed, int gameWalksAllowed,
                                   int gameEarnedRunsAllowed, int gameUnearnedRunsAllowed) {
       // setBattersFaced(getGameBattersFaced() + gameBattersFaced);
        setHitsAllowed(getGameHitsAllowed()+ gameHitsAllowed);
        setStrikeOutsAllowed(getGameStrikeOutsAllowed() + gameStrikeOutsAllowed);
        setWalksAllowed((getGameWalksAllowed() + gameWalksAllowed));
        setEarnedRuns(getGameEarnedRunsAllowed() + gameEarnedRunsAllowed);
        setUnearnedRunsAllowed(getGameUnearnedRunsAllowed() + gameUnearnedRunsAllowed);

    }


    int getHitBatters() {
        return hitBatters;
    }

    void setHitBatters(int hitBatters) {
        this.hitBatters = hitBatters;
    }

    public void outNoRuns() {
        setBattersFaced(getGameBattersFaced() + 1);
    }

    void outRunScored(Base baseRunner, Pitcher pitcher) {
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

    void hitRunScores(Base baseRunner, Pitcher pitcher) {
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

    void updatePitcherGameStats(List<Pitcher> pitcherList)
    {
        for (Pitcher pitcher : pitcherList)
        {
            pitcher.getPitcherStats().setsGamesPlayed(pitcher.getPitcherStats().getsGamesPlayed() + pitcher.getPitcherStats().getGameGamePlayed());
            pitcher.getPitcherStats().setsGamesStarted(pitcher.getPitcherStats().getsGamesStarted() + pitcher.getPitcherStats().getGameGameStarted());
            pitcher.getPitcherStats().setsBattersFaced(pitcher.getPitcherStats().getsBattersFaced() + pitcher.getPitcherStats().getGameBattersFaced());
            pitcher.getPitcherStats().setsHitsAllowed(pitcher.getPitcherStats().getsHitsAllowed() + pitcher.getPitcherStats().getGameHitsAllowed());
            pitcher.getPitcherStats().setsHitBatters(pitcher.getPitcherStats().getsHitBatters() + pitcher.getPitcherStats().getGameHitByPitch());
            pitcher.getPitcherStats().setsEarnedRuns(pitcher.getPitcherStats().getsEarnedRuns() + pitcher.getPitcherStats().getGameEarnedRunsAllowed());
            pitcher.getPitcherStats().setsRunsAllowed(pitcher.getPitcherStats().getsRunsAllowed() + pitcher.getPitcherStats().getGameRunsAllowed());
            pitcher.getPitcherStats().setsStrikeOutAllowed(pitcher.getPitcherStats().getsStrikeOutAllowed() + pitcher.getPitcherStats().getGameStrikeOutsAllowed());
            pitcher.getPitcherStats().setsWalksAllowed(pitcher.getPitcherStats().getsWalksAllowed() + pitcher.getPitcherStats().getGameWalksAllowed());
            pitcher.getPitcherStats().setsHomeRunsAllowed(pitcher.getPitcherStats().getsHomeRunsAllowed() + pitcher.getPitcherStats().getGameHomeRunsAllowed());
            pitcher.getPitcherStats().setsInningsPitchedOuts(pitcher.getPitcherStats().getsInningsPitchedOuts() + pitcher.getPitcherStats().getGameInningsPitchedOuts());
            pitcher.getPitcherStats().setsShutOuts(pitcher.getPitcherStats().getsShutOuts() + pitcher.getPitcherStats().getGameShutOuts());
            pitcher.getPitcherStats().setsCompleteGames(pitcher.getPitcherStats().getsCompleteGames() + pitcher.getPitcherStats().getGameCompleteGame());
            pitcher.getPitcherStats().setsWins(pitcher.getPitcherStats().getsWins() + pitcher.getPitcherStats().getGameWin());
            pitcher.getPitcherStats().setsLosses(pitcher.getPitcherStats().getsLosses() + pitcher.getPitcherStats().getGameLoss());
            pitcher.getPitcherStats().setsSaves(pitcher.getPitcherStats().getsSaves() + pitcher.getPitcherStats().getGameSave());
        }
    }

}

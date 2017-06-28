package Baseball;

import java.util.List;

class PitcherStats {
    private double probabilityHomeRun, probabilityTriple, probabilityDouble, probabilitySingle, probabilityWalk,
            probabilityStrikeOut, probabilityHitBatter, era ;

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
            sWins, sLosses, sSaves;

    public int getGameGameStarted() {
        return gameGameStarted;
    }

    public void setGameGameStarted(int gameGameStarted) {
        this.gameGameStarted = gameGameStarted;
    }

    public int getGameGamePlayed() {
        return gameGamePlayed;
    }

    public void setGameGamePlayed(int gameGamePlayed) {
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

    public int getGameWin() {
        return gameWin;
    }

    public void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    public int getGameLoss() {
        return gameLoss;
    }

    public void setGameLoss(int gameLoss) {
        this.gameLoss = gameLoss;
    }

    public int getGameSave() {
        return gameSave;
    }

    public void setGameSave(int gameSave) {
        this.gameSave = gameSave;
    }

    private int getInningsPitched() {
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

    public int getSaves() {
        return saves;
    }

    void setSaves(int saves) {
        this.saves = saves;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesStarted() {
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

    public int getiPouts() {
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

    public int getRuns() {
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

    private int getHomeRunsAllowed() {
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

    public int getEarnedRuns() {
        return earnedRuns;
    }

    void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    void setGameBattersFaced(int gameBattersFaced) {
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
        //setBattersFaced((getInningsPitched() * 3) + getHitsAllowed() + getWalksAllowed());
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

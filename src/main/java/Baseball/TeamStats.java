package Baseball;

public class TeamStats {
    private int games, gamesHome, wins, losses;
    private String divWin, wcWin, lgWin, WsWin;
    private int runs, atBats, hits, doubles, triples, homeRuns, walks, strikeOuts, stolenBases, caughtStealing, hitByPitch,
            sacrificeFlies, runsAllowed, earnedRuns, completeGames, shutOuts, saves, IpOuts, hitsAllowed, homeRunsAllowed,
            walksAllowed, strikeOutsAllowed, errors, doublePlaysTurned, attendance, battingParkEffect, pitchingParkEffect,
            currentWinStreak, currentLossStreak, longestWinStreak, longestLossStreak, teamLeftOnBase, sTeamDoublePlaysTurned,
            sLeftOnBase, sAtBats, sRunsScored, sHits, sRbi, sDoubles, sTriples, sHomeRuns, sStrikeOuts, sWalks, sStolenBases,
            sCaughtStealing, sHitByPitch, sAssists, sErrors, sPutOuts, sDoublePlays, sRunnersThrownOut, sPlateAppearances,
            sInningsPitched, sHitsAllowed, sHomeRunsAllowed, sWalksAllowed, sStrikeOutsPitcher, sSaves, sShutOuts, sCompleteGames,
            sHitBatters, sRunsAllowed, seasonWins, seasonLosses, seasonGames, homeWins, homeLosses, awayWins, awayLosses,
            gameRuns, gameHits, gameErrors, gameDoublePlays, gameLeftOnBase, inningRuns;
    private double fieldingPercentage, era;

    TeamStats() {
    }

    int getInningRuns() {
        return inningRuns;
    }

    void setInningRuns(int inningRuns) {
        this.inningRuns = inningRuns;
    }

    int getGameLeftOnBase() {
        return gameLeftOnBase;
    }

    void setGameLeftOnBase(int gameLeftOnBase) {
        this.gameLeftOnBase = gameLeftOnBase;
    }

    int getGameDoublePlays() {
        return gameDoublePlays;
    }

    private void setGameDoublePlays(int gameDoublePlays) {
        this.gameDoublePlays = gameDoublePlays;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGamesHome() {
        return gamesHome;
    }

    public void setGamesHome(int gamesHome) {
        this.gamesHome = gamesHome;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getDivWin() {
        return divWin;
    }

    public void setDivWin(String divWin) {
        this.divWin = divWin;
    }

    public String getWcWin() {
        return wcWin;
    }

    public void setWcWin(String wcWin) {
        this.wcWin = wcWin;
    }

    public String getLgWin() {
        return lgWin;
    }

    public void setLgWin(String lgWin) {
        this.lgWin = lgWin;
    }

    public String getWsWin() {
        return WsWin;
    }

    public void setWsWin(String wsWin) {
        WsWin = wsWin;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getAtBats() {
        return atBats;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getDoubles() {
        return doubles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public int getTriples() {
        return triples;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public int getWalks() {
        return walks;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public int getStrikeOuts() {
        return strikeOuts;
    }

    public void setStrikeOuts(int strikeOuts) {
        this.strikeOuts = strikeOuts;
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

    public int getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(int hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public int getSacrificeFlies() {
        return sacrificeFlies;
    }

    public void setSacrificeFlies(int sacrificeFlies) {
        this.sacrificeFlies = sacrificeFlies;
    }

    public int getRunsAllowed() {
        return runsAllowed;
    }

    public void setRunsAllowed(int runsAllowed) {
        this.runsAllowed = runsAllowed;
    }

    public int getEarnedRuns() {
        return earnedRuns;
    }

    public void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    public int getCompleteGames() {
        return completeGames;
    }

    public void setCompleteGames(int completeGames) {
        this.completeGames = completeGames;
    }

    public int getShutOuts() {
        return shutOuts;
    }

    public void setShutOuts(int shutOuts) {
        this.shutOuts = shutOuts;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getIpOuts() {
        return IpOuts;
    }

    public void setIpOuts(int ipOuts) {
        IpOuts = ipOuts;
    }

    public int getHitsAllowed() {
        return hitsAllowed;
    }

    public void setHitsAllowed(int hitsAllowed) {
        this.hitsAllowed = hitsAllowed;
    }

    public int getHomeRunsAllowed() {
        return homeRunsAllowed;
    }

    public void setHomeRunsAllowed(int homeRunsAllowed) {
        this.homeRunsAllowed = homeRunsAllowed;
    }

    public int getWalksAllowed() {
        return walksAllowed;
    }

    public void setWalksAllowed(int walksAllowed) {
        this.walksAllowed = walksAllowed;
    }

    public int getStrikeOutsAllowed() {
        return strikeOutsAllowed;
    }

    public void setStrikeOutsAllowed(int strikeOutsAllowed) {
        this.strikeOutsAllowed = strikeOutsAllowed;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getDoublePlaysTurned() {
        return doublePlaysTurned;
    }

    public void setDoublePlaysTurned(int doublePlaysTurned) {
        this.doublePlaysTurned = doublePlaysTurned;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getBattingParkEffect() {
        return battingParkEffect;
    }

    public void setBattingParkEffect(int battingParkEffect) {
        this.battingParkEffect = battingParkEffect;
    }

    public int getPitchingParkEffect() {
        return pitchingParkEffect;
    }

    public void setPitchingParkEffect(int pitchingParkEffect) {
        this.pitchingParkEffect = pitchingParkEffect;
    }

    public int getCurrentWinStreak() {
        return currentWinStreak;
    }

    public void setCurrentWinStreak(int currentWinStreak) {
        this.currentWinStreak = currentWinStreak;
    }

    public int getCurrentLossStreak() {
        return currentLossStreak;
    }

    public void setCurrentLossStreak(int currentLossStreak) {
        this.currentLossStreak = currentLossStreak;
    }

    public int getLongestWinStreak() {
        return longestWinStreak;
    }

    public void setLongestWinStreak(int longestWinStreak) {
        this.longestWinStreak = longestWinStreak;
    }

    public int getLongestLossStreak() {
        return longestLossStreak;
    }

    public void setLongestLossStreak(int longestLossStreak) {
        this.longestLossStreak = longestLossStreak;
    }

    public int getTeamLeftOnBase() {
        return teamLeftOnBase;
    }

    public void setTeamLeftOnBase(int teamLeftOnBase) {
        this.teamLeftOnBase = teamLeftOnBase;
    }

    public int getsTeamDoublePlaysTurned() {
        return sTeamDoublePlaysTurned;
    }

    public void setsTeamDoublePlaysTurned(int sTeamDoublePlaysTurned) {
        this.sTeamDoublePlaysTurned = sTeamDoublePlaysTurned;
    }

    public int getsLeftOnBase() {
        return sLeftOnBase;
    }

    public void setsLeftOnBase(int sLeftOnBase) {
        this.sLeftOnBase = sLeftOnBase;
    }

    public int getsAtBats() {
        return sAtBats;
    }

    public void setsAtBats(int sAtBats) {
        this.sAtBats = sAtBats;
    }

    public int getsRunsScored() {
        return sRunsScored;
    }

    public void setsRunsScored(int sRunsScored) {
        this.sRunsScored = sRunsScored;
    }

    public int getsHits() {
        return sHits;
    }

    public void setsHits(int sHits) {
        this.sHits = sHits;
    }

    public int getsRbi() {
        return sRbi;
    }

    public void setsRbi(int sRbi) {
        this.sRbi = sRbi;
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

    public int getsStrikeOuts() {
        return sStrikeOuts;
    }

    public void setsStrikeOuts(int sStrikeOuts) {
        this.sStrikeOuts = sStrikeOuts;
    }

    public int getsWalks() {
        return sWalks;
    }

    public void setsWalks(int sWalks) {
        this.sWalks = sWalks;
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

    public int getsHitByPitch() {
        return sHitByPitch;
    }

    public void setsHitByPitch(int sHitByPitch) {
        this.sHitByPitch = sHitByPitch;
    }

    public int getsAssists() {
        return sAssists;
    }

    public void setsAssists(int sAssists) {
        this.sAssists = sAssists;
    }

    public int getsErrors() {
        return sErrors;
    }

    public void setsErrors(int sErrors) {
        this.sErrors = sErrors;
    }

    public int getsPutOuts() {
        return sPutOuts;
    }

    public void setsPutOuts(int sPutOuts) {
        this.sPutOuts = sPutOuts;
    }

    public int getsDoublePlays() {
        return sDoublePlays;
    }

    public void setsDoublePlays(int sDoublePlays) {
        this.sDoublePlays = sDoublePlays;
    }

    public int getsRunnersThrownOut() {
        return sRunnersThrownOut;
    }

    public void setsRunnersThrownOut(int sRunnersThrownOut) {
        this.sRunnersThrownOut = sRunnersThrownOut;
    }

    public int getsPlateAppearances() {
        return sPlateAppearances;
    }

    public void setsPlateAppearances(int sPlateAppearances) {
        this.sPlateAppearances = sPlateAppearances;
    }

    public int getsInningsPitched() {
        return sInningsPitched;
    }

    public void setsInningsPitched(int sInningsPitched) {
        this.sInningsPitched = sInningsPitched;
    }

    public int getsHitsAllowed() {
        return sHitsAllowed;
    }

    public void setsHitsAllowed(int sHitsAllowed) {
        this.sHitsAllowed = sHitsAllowed;
    }

    public int getsHomeRunsAllowed() {
        return sHomeRunsAllowed;
    }

    public void setsHomeRunsAllowed(int sHomeRunsAllowed) {
        this.sHomeRunsAllowed = sHomeRunsAllowed;
    }

    public int getsWalksAllowed() {
        return sWalksAllowed;
    }

    public void setsWalksAllowed(int sWalksAllowed) {
        this.sWalksAllowed = sWalksAllowed;
    }

    public int getsStrikeOutsPitcher() {
        return sStrikeOutsPitcher;
    }

    public void setsStrikeOutsPitcher(int sStrikeOutsPitcher) {
        this.sStrikeOutsPitcher = sStrikeOutsPitcher;
    }

    public int getsSaves() {
        return sSaves;
    }

    public void setsSaves(int sSaves) {
        this.sSaves = sSaves;
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

    public int getsHitBatters() {
        return sHitBatters;
    }

    public void setsHitBatters(int sHitBatters) {
        this.sHitBatters = sHitBatters;
    }

    public int getsRunsAllowed() {
        return sRunsAllowed;
    }

    public void setsRunsAllowed(int sRunsAllowed) {
        this.sRunsAllowed = sRunsAllowed;
    }

    public int getSeasonWins() {
        return seasonWins;
    }

    public void setSeasonWins(int seasonWins) {
        this.seasonWins = seasonWins;
    }

    public int getSeasonLosses() {
        return seasonLosses;
    }

    public void setSeasonLosses(int seasonLosses) {
        this.seasonLosses = seasonLosses;
    }

    public int getSeasonGames() {
        return seasonGames;
    }

    public void setSeasonGames(int seasonGames) {
        this.seasonGames = seasonGames;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public int getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(int homeLosses) {
        this.homeLosses = homeLosses;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public int getAwayLosses() {
        return awayLosses;
    }

    public void setAwayLosses(int awayLosses) {
        this.awayLosses = awayLosses;
    }

    int getGameRuns() {
        return gameRuns;
    }

    void setGameRuns(int gameRuns) {
        this.gameRuns = gameRuns;
    }

    int getGameHits() {
        return gameHits;
    }

    private void setGameHits(int gameHits) {
        this.gameHits = gameHits;
    }

    int getGameErrors() {
        return gameErrors;
    }

    void setGameErrors(int gameErrors) {
        this.gameErrors = gameErrors;
    }

    public double getFieldingPercentage() {
        return fieldingPercentage;
    }

    public void setFieldingPercentage(double fieldingPercentage) {
        this.fieldingPercentage = fieldingPercentage;
    }

    public double getEra() {
        return era;
    }

    public void setEra(double era) {
        this.era = era;
    }

    void updateTeamHits(Inning inning, Team visitorTeam, Team homeTeam) {
        if (inning.isTop()) {
            visitorTeam.getTeamStats().setGameHits(visitorTeam.getTeamStats().getGameHits() + 1);
        } else {
            homeTeam.getTeamStats().setGameHits(homeTeam.getTeamStats().getGameHits() + 1);
        }
    }

    void updateTeamDoublePlays(Inning inning, Team visitorTeam, Team homeTeam) {
        if (inning.isTop()) {
            homeTeam.getTeamStats().setGameDoublePlays(homeTeam.getTeamStats().getGameDoublePlays() + 1);
        } else {
            visitorTeam.getTeamStats().setGameDoublePlays(visitorTeam.getTeamStats().getGameDoublePlays() + 1);
        }
    }

    void updateTeamRuns(Inning inning, Team visitorTeam, Team homeTeam) {
        if (inning.isTop()) {
            visitorTeam.getTeamStats().setGameRuns((visitorTeam.getTeamStats().getGameRuns() + 1));
            visitorTeam.getTeamStats().setInningRuns(visitorTeam.getTeamStats().getInningRuns() + 1);
        } else {
            homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
            homeTeam.getTeamStats().setInningRuns(homeTeam.getTeamStats().getInningRuns() + 1);
        }
    }

}

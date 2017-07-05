package Baseball;

import java.util.List;

class Team {
    private String teamId, lgId, franchId, divId, simName, park, teamIdBr, teamIdLahman45, teamIdRetro, teamName;
    private int yearId, simNumber, rank, teamKey;
    private TeamStats teamStats = new TeamStats();

    Team() {

    }

    public Team(String teamId, String lgId, String franchId, String divId, String simName, int yearId, int simNumber, int rank) {
        this.teamId = teamId;
        this.lgId = lgId;
        this.franchId = franchId;
        this.divId = divId;
        this.simName = simName;
        this.yearId = yearId;
        this.simNumber = simNumber;
        this.rank = rank;
    }

    public int getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(int teamKey) {
        this.teamKey = teamKey;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getTeamIdBr() {
        return teamIdBr;
    }

    public void setTeamIdBr(String teamIdBr) {
        this.teamIdBr = teamIdBr;
    }

    public String getTeamIdLahman45() {
        return teamIdLahman45;
    }

    public void setTeamIdLahman45(String teamIdLahman45) {
        this.teamIdLahman45 = teamIdLahman45;
    }

    public String getTeamIdRetro() {
        return teamIdRetro;
    }

    public void setTeamIdRetro(String teamIdRetro) {
        this.teamIdRetro = teamIdRetro;
    }

    String getTeamName() {
        return teamName;
    }

    void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getLgId() {
        return lgId;
    }

    public void setLgId(String lgId) {
        this.lgId = lgId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public String getFranchId() {
        return franchId;
    }

    public void setFranchId(String franchId) {
        this.franchId = franchId;
    }

    public String getDivId() {
        return divId;
    }

    public void setDivId(String divId) {
        this.divId = divId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSimName() {
        return simName;
    }

    public void setSimName(String simName) {
        this.simName = simName;
    }

    public int getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(int simNumber) {
        this.simNumber = simNumber;
    }

    TeamStats getTeamStats() {
        return teamStats;
    }

    public void setTeamStats(TeamStats teamStats) {
        this.teamStats = teamStats;
    }

    public void updateTeamGameStats(Team team, List<Batter> batterList, List<Fielder> fielderList,
                                    List<Pitcher> pitcherList) {

        for (Batter batter : batterList) {
            team.getTeamStats().setTeamLeftOnBase(team.getTeamStats().getTeamLeftOnBase() + batter.getBatterStats().getGameLeftOnBase());
            team.getTeamStats().setsAtBats(team.getTeamStats().getsAtBats() + batter.getBatterStats().getGameAtBats());
            team.getTeamStats().setsRunsScored(team.getTeamStats().getsRunsScored() + batter.getBatterStats().getGameRuns());
            team.getTeamStats().setsHits(team.getTeamStats().getsHits() + batter.getBatterStats().getGameHits());
            team.getTeamStats().setsRbi(team.getTeamStats().getsRbi() + batter.getBatterStats().getGameRbi());
            team.getTeamStats().setsDoubles(team.getTeamStats().getsDoubles() + batter.getBatterStats().getGameDouble());
            team.getTeamStats().setsTriples(team.getTeamStats().getsTriples() + batter.getBatterStats().getGameTriple());
            team.getTeamStats().setsHomeRuns(team.getTeamStats().getsHomeRuns() + batter.getBatterStats().getGameHomeRun());
            team.getTeamStats().setsStrikeOuts(team.getTeamStats().getsStrikeOuts() + batter.getBatterStats().getGameStrikeOut());
            team.getTeamStats().setsWalks(team.getTeamStats().getsWalks() + batter.getBatterStats().getGameWalk());
            team.getTeamStats().setsStolenBases(team.getTeamStats().getsStolenBases() + batter.getBatterStats().getGameStolenBases());
            team.getTeamStats().setsCaughtStealing(team.getTeamStats().getsCaughtStealing() + batter.getBatterStats().getGameCaughtStealing());
            team.getTeamStats().setsHitByPitch(team.getTeamStats().getsHitByPitch() + batter.getBatterStats().getGameHitByPitch());
            team.getTeamStats().setsPlateAppearances(team.getTeamStats().getsPlateAppearances() + batter.getBatterStats().getGamePlateAppearance());
        }

        for (Fielder fielder : fielderList)
        {
            team.getTeamStats().setsAssists(team.getTeamStats().getsAssists() + fielder.getFielderStats().getGameAssists());
            team.getTeamStats().setsErrors(team.getTeamStats().getsErrors() + fielder.getFielderStats().getGameErrors());
            team.getTeamStats().setsPutOuts(team.getTeamStats().getsPutOuts() + fielder.getFielderStats().getGamePutOuts());
            team.getTeamStats().setsDoublePlays(team.getTeamStats().getsDoublePlays() + fielder.getFielderStats().getGameDoublePlay());
            team.getTeamStats().setsRunnersThrownOut(team.getTeamStats().getsRunnersThrownOut() + fielder.getFielderStats().getGameRunnersThrownOut());
        }

        for (Pitcher pitcher : pitcherList)
        {
            team.getTeamStats().setsInningsPitched(team.getTeamStats().getsInningsPitched() + pitcher.getPitcherStats().getGameInningsPitchedOuts());
            team.getTeamStats().setsHitsAllowed(team.getTeamStats().getsHitsAllowed() + pitcher.getPitcherStats().getGameHitsAllowed());
            team.getTeamStats().setsHomeRunsAllowed(team.getTeamStats().getsHomeRunsAllowed() + pitcher.getPitcherStats().getGameHomeRunsAllowed());
            team.getTeamStats().setsWalksAllowed(team.getTeamStats().getsWalksAllowed() + pitcher.getPitcherStats().getGameWalksAllowed());
            team.getTeamStats().setsHitBatters(team.getTeamStats().getsHitBatters() + pitcher.getPitcherStats().getGameHitByPitch());
            team.getTeamStats().setsRunsAllowed(team.getTeamStats().getsRunsAllowed() + pitcher.getPitcherStats().getGameRunsAllowed());
        }
    }

    public void updateTeamStreaks(Team winningTeam, Team losingTeam) {
        if (winningTeam.getTeamStats().getCurrentWinStreak() == winningTeam.getTeamStats().getLongestWinStreak())
        {
            winningTeam.getTeamStats().setLongestWinStreak(winningTeam.getTeamStats().getLongestWinStreak() + 1);
        }
        if (losingTeam.getTeamStats().getCurrentLossStreak() == losingTeam.getTeamStats().getLongestLossStreak())
        {
            losingTeam.getTeamStats().setLongestLossStreak(losingTeam.getTeamStats().getLongestLossStreak() + 1);
        }
    }
}


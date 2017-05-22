package Baseball;

class Team {
    private String teamId, lgId, franchId, divId, simName, park, teamIdBr, teamIdLahman45, teamIdRetro, teamName;
    private int yearId, simNumber, rank;
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
}


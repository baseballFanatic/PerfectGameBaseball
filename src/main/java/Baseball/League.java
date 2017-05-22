package Baseball;

class League {
    private String lgID;
    private LeagueStats leagueStats;

    public String getLgID() {
        return lgID;
    }

    public League() {
        setLeagueStats(new LeagueStats());
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public LeagueStats getLeagueStats() {
        return leagueStats;
    }

    private void setLeagueStats(LeagueStats leagueStats) {
        this.leagueStats = leagueStats;
    }
}


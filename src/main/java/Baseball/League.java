package Baseball;

class League {
    private String lgID;
    private LeagueStats leagueStats;

    public String getLgID() {
        return lgID;
    }

    League() {
        setLeagueStats(new LeagueStats());
    }

    void setLgID(String lgID) {
        this.lgID = lgID;
    }

    LeagueStats getLeagueStats() {
        return leagueStats;
    }

    private void setLeagueStats(LeagueStats leagueStats) {
        this.leagueStats = leagueStats;
    }
}


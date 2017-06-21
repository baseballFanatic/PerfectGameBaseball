package Baseball;

import java.sql.SQLException;
import java.util.List;

import static java.lang.Math.abs;

public class Pitcher extends Player {
    private String pitchingArm = "NA", teamID, lgID;
    private Pitcher visitorStarter, homeStarter, visitorPitcher, homePitcher,
            visitorWinningPitcher, visitorLosingPitcher, visitorSavePitcher, homeWinningPitcher, homeLosingPitcher,
            homeSavePitcher;
    private PitcherStats pitcherStats = new PitcherStats();
    private PitcherRole pitcherRole;
    private int playerKey, yearID, stint, battingOrder;
    private boolean isAvailable = true;

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    public String getTeamID() {
        return teamID;
    }

    void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public int getYearID() {
        return yearID;
    }

    void setYearID(int yearID) {
        this.yearID = yearID;
    }

    public int getStint() {
        return stint;
    }

    void setStint(int stint) {
        this.stint = stint;
    }

    public Pitcher() {}

    private Pitcher(String nameFirst, String nameLast, PitcherRole pitcherRole) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.pitcherRole = pitcherRole;
    }

    public int getPlayerKey() {
        return playerKey;
    }

    void setPlayerKey(int playerKey) {
        this.playerKey = playerKey;
    }

    String getPitchingArm() {
        return pitchingArm;
    }

    void setPitchingArm(String pitchingArm) {
        this.pitchingArm = pitchingArm;
    }

    PitcherStats getPitcherStats() {
        return pitcherStats;
    }

    public void setPitcherStats(PitcherStats pitcherStats) {
        this.pitcherStats = pitcherStats;
    }

    public Pitcher getVisitorStarter() {
        return visitorStarter;
    }

    public void setVisitorStarter(Pitcher visitorStarter) {
        this.visitorStarter = visitorStarter;
    }

    public Pitcher getHomeStarter() {
        return homeStarter;
    }

    public void setHomeStarter(Pitcher homeStarter) {
        this.homeStarter = homeStarter;
    }

    boolean needReliever(Pitcher pitcher, Inning inning, Team visitorTeam, Team homeTeam, List<Pitcher> pitchingTeam) {
        //TODO: need to add more logic to this to take into account different situations.
        if ((pitcher.getPitcherStats().getGameRunsAllowed() > 4) && (Math.abs(visitorTeam.getTeamStats().getGameRuns() -
                homeTeam.getTeamStats().getGameRuns()) > 3))
        {
            return true;
            //Don't allow a pitcher to pitch longer than 9 innings unless he's pitching a no-hitter.
        } else if (pitcher.getPitcherStats().getGameInningsPitchedOuts() > 27 && pitcher.getPitcherStats().getGameHitsAllowed() > 0)
        {
            return true;
        }
        return false;
    }

    Pitcher getReliever(List<Pitcher> pitchingTeam) {
        for (Pitcher pitcher : pitchingTeam) {
            if (pitcher.isAvailable && pitcher.getPitcherRole().equals(PitcherRole.RELIEVER)) {
                pitcher.setAvailable(false);
                System.out.printf("%s comes in from the bullpen.%n", pitcher.getNameLast());
                return pitcher;
            }
        }
        return null;
    }

    void determineWinnerAndLoser(Pitcher pitcher, Inning inning, Team visitorTeam, Team homeTeam) {
        if (inning.getInning() < 6) {
            if (visitorTeam.getTeamStats().getGameRuns() < homeTeam.getTeamStats().getGameRuns()) {
                if (pitcher.getVisitorLosingPitcher() == null) {
                    pitcher.setVisitorLosingPitcher(pitcher.getVisitorPitcher());
                    pitcher.setHomeLosingPitcher(null);
                    pitcher.setVisitorSavePitcher(null);
                }
            } else if (homeTeam.getTeamStats().getGameRuns() < visitorTeam.getTeamStats().getGameRuns()) {
                if (pitcher.getHomeLosingPitcher() == null) {
                    pitcher.setHomeLosingPitcher(pitcher.getHomePitcher());
                    pitcher.setVisitorLosingPitcher(null);
                    pitcher.setHomeSavePitcher(null);
                }
            } else {
                pitcher.setVisitorLosingPitcher(null);
                pitcher.setHomeLosingPitcher(null);
            }
        } else {
            if (visitorTeam.getTeamStats().getGameRuns() > homeTeam.getTeamStats().getGameRuns()) {
                if (pitcher.getVisitorWinningPitcher() == null){
                    pitcher.setVisitorWinningPitcher(pitcher.getVisitorPitcher());
                    pitcher.setVisitorLosingPitcher(null);
                    pitcher.setHomeWinningPitcher(null);
                }
                if (pitcher.getHomeLosingPitcher() == null) {
                    pitcher.setHomeLosingPitcher(pitcher.getHomePitcher());
                    pitcher.setHomeWinningPitcher(null);
                }
                pitcher.setHomeSavePitcher(null);
            } else if (homeTeam.getTeamStats().getGameRuns() > visitorTeam.getTeamStats().getGameRuns()) {
                if (pitcher.getHomeWinningPitcher() == null) {
                    pitcher.setHomeWinningPitcher(pitcher.getHomePitcher());
                    pitcher.setHomeLosingPitcher(null);
                    pitcher.setVisitorWinningPitcher(null);
                }
                if (pitcher.getVisitorLosingPitcher() == null) {
                    pitcher.setVisitorLosingPitcher(pitcher.getVisitorPitcher());
                    pitcher.setVisitorWinningPitcher(null);
                }
                pitcher.setVisitorSavePitcher(null);
            } else {
                pitcher.setVisitorWinningPitcher(null);
                pitcher.setVisitorLosingPitcher(null);
                pitcher.setHomeWinningPitcher(null);
                pitcher.setHomeLosingPitcher(null);
                pitcher.setVisitorSavePitcher(null);
                pitcher.setHomeSavePitcher(null);
            }
        }
    }

    void setPitcherSave(Pitcher pitcher, Inning inning, Team visitorTeam, Team homeTeam) {
        if (homeTeam.getTeamStats().getGameRuns() > visitorTeam.getTeamStats().getGameRuns() &&
                homeTeam.getTeamStats().getGameRuns() - visitorTeam.getTeamStats().getGameRuns() < 5) {
            pitcher.setHomeSavePitcher(pitcher);
            pitcher.setVisitorSavePitcher(null);
        } else if (visitorTeam.getTeamStats().getGameRuns() > homeTeam.getTeamStats().getGameRuns() &&
                visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRuns() < 5) {
            pitcher.setVisitorSavePitcher(pitcher);
            pitcher.setHomeSavePitcher(null);
        }
    }

    PitcherRole getPitcherRole() {
        return pitcherRole;
    }

    void setPitcherRole(PitcherRole pitcherRole) {
        this.pitcherRole = pitcherRole;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    private void setAvailable(boolean available) {
        isAvailable = available;
    }

    Pitcher getVisitorPitcher() {
        return visitorPitcher;
    }

    void setVisitorPitcher(Pitcher visitorPitcher) {
        this.visitorPitcher = visitorPitcher;
    }

    Pitcher getHomePitcher() {
        return homePitcher;
    }

    void setHomePitcher(Pitcher homePitcher) {
        this.homePitcher = homePitcher;
    }

    Pitcher getVisitorWinningPitcher() {
        return visitorWinningPitcher;
    }

    void setVisitorWinningPitcher(Pitcher visitorWinningPitcher) {
        this.visitorWinningPitcher = visitorWinningPitcher;
    }

    Pitcher getVisitorLosingPitcher() {
        return visitorLosingPitcher;
    }

    void setVisitorLosingPitcher(Pitcher visitorLosingPitcher) {
        this.visitorLosingPitcher = visitorLosingPitcher;
    }

    Pitcher getVisitorSavePitcher() {
        return visitorSavePitcher;
    }

    void setVisitorSavePitcher(Pitcher visitorSavePitcher) {
        this.visitorSavePitcher = visitorSavePitcher;
    }

    Pitcher getHomeWinningPitcher() {
        return homeWinningPitcher;
    }

    void setHomeWinningPitcher(Pitcher homeWinningPitcher) {
        this.homeWinningPitcher = homeWinningPitcher;
    }

    Pitcher getHomeLosingPitcher() {
        return homeLosingPitcher;
    }

    void setHomeLosingPitcher(Pitcher homeLosingPitcher) {
        this.homeLosingPitcher = homeLosingPitcher;
    }

    Pitcher getHomeSavePitcher() {
        return homeSavePitcher;
    }

    void setHomeSavePitcher(Pitcher homeSavePitcher) {
        this.homeSavePitcher = homeSavePitcher;
    }

    List<Pitcher> getPitcherList(boolean visitors, Schedule schedule) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Pitcher> pitcherList;
        Pitcher pitcher = new Pitcher();

        if (visitors) {
            int yearID=1927;
            String teamID = schedule.getVisitingTeamId();
            pitcherList = Database.selectPitchers(teamID, yearID);
        } else {
            String teamID = schedule.getHomeTeamId();
            int yearID=1927;
            pitcherList = Database.selectPitchers(teamID, yearID);
        }
        return pitcherList;
    }

    Pitcher findStartingPitcher(List<Pitcher> pitchingTeam, Schedule schedule, boolean visitors)
    {
        for (Pitcher pitcher : pitchingTeam)
        {
            if (visitors)
            {
                if (pitcher.getRetroId().equals(schedule.getVisitingStartingPitcherId()))
                {
                    pitcher.setAvailable(false);
                    return pitcher;
                }
            } else
            {
                if (pitcher.getRetroId().equals(schedule.getHomeStartingPitcherId()))
                {
                    pitcher.setAvailable(false);
                    return pitcher;
                }
            }
        }
        return null;
    }
}



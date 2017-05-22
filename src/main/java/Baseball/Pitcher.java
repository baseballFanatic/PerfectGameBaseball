package Baseball;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Pitcher extends Player {
    private String pitchingArm = "NA";
    private Pitcher visitorStarter, homeStarter, visitorPitcher, homePitcher,
            visitorWinningPitcher, visitorLosingPitcher, visitorSavePitcher, homeWinningPitcher, homeLosingPitcher,
            homeSavePitcher;
    private PitcherStats pitcherStats = new PitcherStats();
    private PitcherRole pitcherRole;
    private boolean isAvailable = true;

    public Pitcher() {}

    private Pitcher(String nameFirst, String nameLast, PitcherRole pitcherRole) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.pitcherRole = pitcherRole;
    }

    String getPitchingArm() {
        return pitchingArm;
    }

    public void setPitchingArm(String pitchingArm) {
        this.pitchingArm = pitchingArm;
    }

    PitcherStats getPitcherStats() {
        return pitcherStats;
    }

    public void setPitcherStats(PitcherStats pitcherStats) {
        this.pitcherStats = pitcherStats;
    }

/*    public void recordOutNoRuns() {
        getPitcherStats().outNoRuns();
    }

    public void recordOutRunScored(Base baseRunner, Pitcher pitcher) {
        getPitcherStats().outRunScored(baseRunner, pitcher);
    }*/

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
        if (pitcher.getPitcherStats().getGameRunsAllowed() > 4) {
            System.out.println("Would bring in a reliever.");
            return true;
        }
        return false;
    }

    Pitcher getReliever(List<Pitcher> pitchingTeam) {
        for (Pitcher pitcher : pitchingTeam) {
            if (pitcher.isAvailable) {
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

    public PitcherRole getPitcherRole() {
        return pitcherRole;
    }

    public void setPitcherRole(PitcherRole pitcherRole) {
        this.pitcherRole = pitcherRole;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available) {
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

    private void setVisitorWinningPitcher(Pitcher visitorWinningPitcher) {
        this.visitorWinningPitcher = visitorWinningPitcher;
    }

    Pitcher getVisitorLosingPitcher() {
        return visitorLosingPitcher;
    }

    private void setVisitorLosingPitcher(Pitcher visitorLosingPitcher) {
        this.visitorLosingPitcher = visitorLosingPitcher;
    }

    Pitcher getVisitorSavePitcher() {
        return visitorSavePitcher;
    }

    private void setVisitorSavePitcher(Pitcher visitorSavePitcher) {
        this.visitorSavePitcher = visitorSavePitcher;
    }

    Pitcher getHomeWinningPitcher() {
        return homeWinningPitcher;
    }

    private void setHomeWinningPitcher(Pitcher homeWinningPitcher) {
        this.homeWinningPitcher = homeWinningPitcher;
    }

    Pitcher getHomeLosingPitcher() {
        return homeLosingPitcher;
    }

    private void setHomeLosingPitcher(Pitcher homeLosingPitcher) {
        this.homeLosingPitcher = homeLosingPitcher;
    }

    Pitcher getHomeSavePitcher() {
        return homeSavePitcher;
    }

    private void setHomeSavePitcher(Pitcher homeSavePitcher) {
        this.homeSavePitcher = homeSavePitcher;
    }

    List<Pitcher> getPitcherList(boolean visitors) {
        List<Pitcher> pitcherList = new ArrayList<>();

        if (visitors) {
            pitcherList.add(new Pitcher ("Cy", "Young", PitcherRole.STARTER));
            pitcherList.add(new Pitcher ("Pete", "Alexander", PitcherRole.STARTER));
            pitcherList.add(new Pitcher ("Jack", "Chesbro", PitcherRole.STARTER));
            pitcherList.add(new Pitcher ("Three-Finger", "Brown", PitcherRole.RELIEVER));
            pitcherList.add(new Pitcher ("Dennis", "Eckersley", PitcherRole.CLOSER));
        } else {
            pitcherList.add(new Pitcher ("Christy", "Mathewson", PitcherRole.STARTER));
            pitcherList.add(new Pitcher ("Greg", "Maddux", PitcherRole.STARTER));
            pitcherList.add(new Pitcher ("John", "Smoltz", PitcherRole.STARTER));
            pitcherList.add(new Pitcher ("Catfish", "Hunter", PitcherRole.RELIEVER));
            pitcherList.add(new Pitcher ("Mariano", "Rivera", PitcherRole.CLOSER));
        }

        for (Pitcher pitcher : pitcherList) {
            pitcher.getPitcherStats().setInningsPitched(200);
            pitcher.getPitcherStats().setHitsAllowed(210);
            pitcher.getPitcherStats().setHomeRunsAllowed(15);
            pitcher.getPitcherStats().setWalksAllowed(50);
            pitcher.getPitcherStats().setStrikeOutsAllowed(80);
            pitcher.getPitcherStats().calculatePitcherProbabilities();
        }
        return pitcherList;
    }
}



package Baseball;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    int getBattingOrder() {
        return battingOrder;
    }

    void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
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

    public void setYearID(int yearID) {
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

    public String getPitchingArm() {
        return pitchingArm;
    }

    public void setPitchingArm(String pitchingArm) {
        this.pitchingArm = pitchingArm;
    }

    public PitcherStats getPitcherStats() {
        return pitcherStats;
    }

    public void setPitcherStats(PitcherStats pitcherStats) {
        this.pitcherStats = pitcherStats;
    }

    Pitcher getVisitorStarter() {
        return visitorStarter;
    }

    void setVisitorStarter(Pitcher visitorStarter) {
        this.visitorStarter = visitorStarter;
    }

    Pitcher getHomeStarter() {
        return homeStarter;
    }

    void setHomeStarter(Pitcher homeStarter) {
        this.homeStarter = homeStarter;
    }

    boolean needReliever(Pitcher currentPitcher, Inning inning, Team pitchTeam, Team battingTeam, List<Pitcher> pitchingTeam,
                         Bases bases) {
        BasesOccupied baseState = bases.checkBases(bases);

        //TODO: need to add more logic to this to take into account different situations.
        if ((currentPitcher.getPitcherStats().getGameRunsAllowed() > 4) && (Math.abs(pitchTeam.getTeamStats().getGameRuns() -
                battingTeam.getTeamStats().getGameRuns()) > 3))
        {
            return true;
            //Don't allow a pitcher to pitch longer than 9 innings unless he's pitching a no-hitter.
        } else if (currentPitcher.getPitcherStats().getGameInningsPitchedOuts() > 27 && currentPitcher.getPitcherStats().getGameHitsAllowed() > 0)
        {
            return true;
        } else if (inning.getInning() > 8 && pitchTeam.getTeamStats().getGameRuns() > battingTeam.getTeamStats().getGameRuns()
                && pitchTeam.getTeamStats().getGameRuns() > battingTeam.getTeamStats().getGameRuns() &&
                pitchTeam.getTeamStats().getGameRuns() - battingTeam.getTeamStats().getGameRuns() < 5 &&
                (baseState.toString().equals("SECOND_THIRD") || baseState.toString().equals("FIRST_THIRD") ||
                baseState.toString().equals("BASES_LOADED")) && currentPitcher.getPitcherStats().getGameRunsAllowed() > 0)
        {
            return true;
        }
        return false;
    }

    Pitcher getReliever(List<Pitcher> pitchingTeam, LocalDate date, Batter currentBatter) {
        for (Pitcher pitcher : pitchingTeam) {
            if (pitcher.getPitcherStats().getDaysRest() > 0)
            {
                pitcher.setAvailable(false);
            }
            // Looks for available pitcher with good righty/lefty matchup
            if (pitcher.isAvailable && (pitcher.getPitcherStats().getActualPlayPercent() <
                    pitcher.getPitcherStats().getHistPercentPlayed())
                    && pitcher.getPitchingArm().equals(currentBatter.getBats().getHandCode())) {
                pitcher.setAvailable(false);
                pitcher.getPitcherStats().setLastGameDatePitched(date);
                System.out.printf("%s comes in from the bullpen.%n", pitcher.getNameLast());
                return pitcher;
            }

            // If no match above will repeat the if but drop the matchup
            if (pitcher.isAvailable && (pitcher.getPitcherStats().getActualPlayPercent() <
                    pitcher.getPitcherStats().getHistPercentPlayed())) {
                pitcher.setAvailable(false);
                pitcher.getPitcherStats().setLastGameDatePitched(date);
                System.out.printf("%s comes in from the bullpen.%n", pitcher.getNameLast());
                return pitcher;
            }

            // Added in the matchup but allows more inningsPitched as long as fewer games
            if (pitcher.isAvailable && (pitcher.getPitcherStats().getsInningsPitchedOuts() <
                    (pitcher.getPitcherStats().getiPouts() * 1.10))
                    && pitcher.getPitcherStats().getsGamesPlayed() < pitcher.getPitcherStats().getGamesPlayed()
                    && pitcher.getPitchingArm().equals(currentBatter.getBats().getHandCode()))
            {
                pitcher.setAvailable(false);
                pitcher.getPitcherStats().setLastGameDatePitched(date);
                System.out.printf("%s comes in from the bullpen.%n", pitcher.getNameLast());
                return pitcher;
            }

            // Drops the matchup again
            if (pitcher.isAvailable && (pitcher.getPitcherStats().getsInningsPitchedOuts() <
                    (pitcher.getPitcherStats().getiPouts() * 1.10))
                    && pitcher.getPitcherStats().getsGamesPlayed() < pitcher.getPitcherStats().getGamesPlayed())
            {
                pitcher.setAvailable(false);
                pitcher.getPitcherStats().setLastGameDatePitched(date);
                System.out.printf("%s comes in from the bullpen.%n", pitcher.getNameLast());
                return pitcher;
            }

            if (pitcher.isAvailable && pitcher.getPitcherRole().equals(PitcherRole.RELIEVER))
            {
                pitcher.setAvailable(false);
                pitcher.getPitcherStats().setLastGameDatePitched(date);
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

    void setPitcherSave(Pitcher pitcher, Inning inning, Team visitorTeam, Team homeTeam, Pitcher currentPitcher) {
        if (inning.getInning() > 6)
        {
            if (homeTeam.getTeamStats().getGameRuns() > visitorTeam.getTeamStats().getGameRuns() &&
                    homeTeam.getTeamStats().getGameRuns() - visitorTeam.getTeamStats().getGameRuns() < 5
                    && pitcher.getHomeSavePitcher() == null) {
                pitcher.setHomeSavePitcher(currentPitcher);
                pitcher.setVisitorSavePitcher(null);
            } else if (visitorTeam.getTeamStats().getGameRuns() > homeTeam.getTeamStats().getGameRuns() &&
                    visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRuns() < 5
                    && pitcher.getVisitorSavePitcher() == null) {
                pitcher.setVisitorSavePitcher(currentPitcher);
                pitcher.setHomeSavePitcher(null);
            }
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

    private void setVisitorWinningPitcher(Pitcher visitorWinningPitcher) {
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

    private void setVisitorSavePitcher(Pitcher visitorSavePitcher) {
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

    private void setHomeLosingPitcher(Pitcher homeLosingPitcher) {
        this.homeLosingPitcher = homeLosingPitcher;
    }

    Pitcher getHomeSavePitcher() {
        return homeSavePitcher;
    }

    private void setHomeSavePitcher(Pitcher homeSavePitcher) {
        this.homeSavePitcher = homeSavePitcher;
    }

    List<Pitcher> getPitcherList(boolean visitors, Schedule schedule, Team pitcherTeam) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Pitcher> pitcherList;
        Pitcher pitcher = new Pitcher();

        if (visitors) {
            //TODO Take out this hard coded year
            int yearID=1913;
            String teamID = schedule.getVisitingTeamId();
            pitcherList = Database.selectPitchers(teamID, yearID, schedule, schedule.getVisitingGameNumber(),
                    pitcherTeam);
        } else {
            String teamID = schedule.getHomeTeamId();
            int yearID=1913;
            pitcherList = Database.selectPitchers(teamID, yearID, schedule, schedule.getHomeGameNumber(),
                    pitcherTeam);
        }
        return pitcherList;
    }

    Pitcher findStartingPitcher(List<Pitcher> pitchingTeam, String id, LocalDate date)
    {
        /*for (Pitcher pitcher : pitchingTeam) {
            if (pitcher.getPitcherStats().getDaysRest() > 0) {
                int daysRest = (int) ChronoUnit.DAYS.between(pitcher.getPitcherStats().getLastGameDatePitched(), date);
                pitcher.getPitcherStats().setDaysRest(pitcher.getPitcherStats().getDaysRest() - daysRest);
            }
        }*/

        for (Pitcher pitcher1 : pitchingTeam)
        {
            if (pitcher1.getRetroId().equals(id))
            {
                pitcher1.setAvailable(false);
                pitcher1.getPitcherStats().setDaysRest(4);
                pitcher1.getPitcherStats().setLastGameDatePitched(date);
                return pitcher1;
            }
        }
        return null;
    }

    boolean isRelieverAvailable(Team team, List<Pitcher> teamPitchers) {
        for (Pitcher reliever : teamPitchers)
        {
            if (reliever.isAvailable && reliever.getPitcherRole().equals(PitcherRole.RELIEVER) &&
            reliever.getPitcherStats().getDaysRest() == 0)
            {
                return true;
            }
            if (reliever.isAvailable && reliever.getPitcherStats().getDaysRest() == 0)
            {
                return true;
            }
        }
        System.out.println("No reliever available to come in.");
        return false;
    }

    void setStartingPitcherBattingOrder(Pitcher startingPitcher, HashMap<Integer, Batter> pitcherBattersList) {
        for (Integer integer : pitcherBattersList.keySet()) {
            if(Objects.equals(pitcherBattersList.get(integer).getPlayerId(), startingPitcher.getPlayerId()) )
            {
                startingPitcher.setBattingOrder(pitcherBattersList.get(integer).getBattingOrder());
                System.out.printf("set %s batting order to %s.%n",
                        startingPitcher.getNameLast(), startingPitcher.getBattingOrder());
                break;
            }
        }
    }

    void checkCompleteGame(Pitcher pitcher, List<Integer> lineScore) {
        if ((pitcher.getPitcherStats().getGameInningsPitchedOuts() >= (lineScore.size() * 3) )
                && pitcher.getPitcherStats().getGameRunsAllowed() == 0
                && pitcher.getPitcherStats().getGameGameStarted() == 1)
        {
            System.out.printf("%s pitched a complete game shut-out. %n", pitcher.getNameLast());
            pitcher.getPitcherStats().setGameShutOuts(1);
            pitcher.getPitcherStats().setGameCompleteGame(1);
        } else if (pitcher.getPitcherStats().getGameInningsPitchedOuts() >=
                (lineScore.size() * 3)
                && pitcher.getPitcherStats().getGameGameStarted() == 1)
        {
            System.out.printf("%s pitched a complete game.%n", pitcher.getNameLast());
            pitcher.getPitcherStats().setGameCompleteGame(1);
        }
    }

    void updateDaysRest(Pitcher pitcher, Schedule schedule) {
        pitcher.getPitcherStats().setLastGameDatePitched(schedule.getGameDate());
        if (pitcher.getPitcherStats().getDaysRest() == 0)
        {
            if (pitcher.getPitcherStats().getGameInningsPitchedOuts() <= 4)
            {
                pitcher.getPitcherStats().setDaysRest(0);
            } else if (pitcher.getPitcherStats().getGameInningsPitchedOuts() <= 8)
            {
                pitcher.getPitcherStats().setDaysRest(2);
            } else if (pitcher.getPitcherStats().getGameInningsPitchedOuts() <= 14)
            {
                pitcher.getPitcherStats().setDaysRest(3);
            } else
            {
                pitcher.getPitcherStats().setDaysRest(4);
            }
        }
        if (pitcher.getPitcherStats().getDaysRest() < 0)
        {
            pitcher.getPitcherStats().setDaysRest(0);
        }
    }
}



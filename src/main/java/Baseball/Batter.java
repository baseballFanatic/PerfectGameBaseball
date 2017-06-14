package Baseball;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Batter extends Player implements Comparable<Batter> {
    private String round, teamID, lgID, pos;
    private int battingOrder;
    private Hands bats;
    private BatterStats batterStats = new BatterStats();
    private boolean availability;
    private int awardPoints, stint, playerKey, fielderKey;
    private Base firstBase = new Base();
    private Base secondBase = new Base();
    private Base thirdBase = new Base();
    private Pitcher pitcherReachedOn;
    private InPlayPosition position;

    public Batter() {

    }

    private Batter(String nameFirst, String nameLast, Hands bats, InPlayPosition position) {
        this.bats = bats;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    private void setPosition(InPlayPosition position) {
        this.position = position;
    }

    public InPlayPosition getPosition() {
        return position;
    }

    public int getPlayerKey() {
        return playerKey;
    }

    void setPlayerKey(int playerKey) {
        this.playerKey = playerKey;
    }

    public int getFielderKey() {
        return fielderKey;
    }

    public void setFielderKey(int fielderKey) {
        this.fielderKey = fielderKey;
    }

    public String getLgID() {
        return lgID;
    }

    void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getTeamID() {
        return teamID;
    }

    void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public int getAwardPoints() {
        return awardPoints;
    }

    public void setAwardPoints(int awardPoints) {
        this.awardPoints = awardPoints;
    }

    public int getStint() {
        return stint;
    }

    void setStint(int stint) {
        this.stint = stint;
    }

    public Hands getBats() {
        return bats;
    }

    void setBats(Hands bats) {
        this.bats = bats;
    }

    BatterStats getBatterStats() {
        return batterStats;
    }

    public void setBatterStats(BatterStats batterStats) {
        this.batterStats = batterStats;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    private int getBattingOrder() {
        return battingOrder;
    }

    void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
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

    public void recordOutNoRbi() {
        getBatterStats().recordOutNoRbi();
    }

    public Base getFirstBase() {
        return firstBase;
    }

    public void setFirstBase(Base firstBase) {
        this.firstBase = firstBase;
    }

    public Base getSecondBase() {
        return secondBase;
    }

    public void setSecondBase(Base secondbase) {
        this.secondBase = secondbase;
    }

    public Base getThirdBase() {
        return thirdBase;
    }

    public void setThirdBase(Base thirdBase) {
        this.thirdBase = thirdBase;
    }

    public boolean needPinchHitter(Inning inning, Team visitorTeam, Team homeTeam, Batter currentBatter)
    {
        return inning.getInning() > 6 && (Math.abs(visitorTeam.getTeamStats().getGameRuns() -
                homeTeam.getTeamStats().getGameRuns()) < 5 && currentBatter.getBattingOrder() > 7);
    }

    //List<Batter> getBatterList(boolean visitors, List<Schedule> scheduleList) throws ClassNotFoundException, SQLException, InstantiationException {
    List<Batter> getBatterList(boolean visitors, Schedule schedule) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Batter> batterList;
        Batter batter = new Batter();

        if (visitors) {
            int yearID=1927;
            String teamID = schedule.getVisitingTeamId();
            batterList = Database.selectBatters(teamID, yearID);

        } else {
            int yearID=1927;
            String teamID = schedule.getHomeTeamId();
            batterList = Database.selectBatters(teamID, yearID);
        }
        return batterList;
    }

    Pitcher getPitcherReachedOn() {
        return pitcherReachedOn;
    }

    void setPitcherReachedOn(Pitcher pitcherReachedOn) {
        this.pitcherReachedOn = pitcherReachedOn;
    }

    List<Batter> matchPositions(List<Batter> batters, List<Fielder> fielders) {
        //int b = 0;
        List<Batter> matchedBatters = new ArrayList<>();

        for (Batter batter : batters) {
            for (Fielder fielder : fielders) {
                if (Objects.equals(batter.getPlayerId(), fielder.getPlayerId())) {
                    batter.setPosition(fielder.getPosition());
                    if (matchedBatters.size() < 10)
                    //b++;
                    {
                        batter.getBatterStats().setGameGamePlayed();
                        matchedBatters.add(batter);
                        break;
                    }
                }
            }
        }
        return matchedBatters;
    }

    @Override
    public int compareTo(Batter o) {
        if(getBatterStats().getBattingAverage() < o.getBatterStats().getBattingAverage())
        {
            return 1;
        } else if (getBatterStats().getBattingAverage() > o.getBatterStats().getBattingAverage())
        {
            return -1;
        } else
        {
            return 0;
        }

    }

    List<Batter> findDesignatedHitter(List<Batter> batterStarters, List<Batter> teamBatters) {
        for (Batter batter : teamBatters)
        {
            if (batter.getBatterStats().getGameGamePlayed() == 0 && batterStarters.size() < 9)
            {
                batter.setPosition(InPlayPosition.DESIGNATED_HITTER);
                batterStarters.add(batter);
                break;
            }
        }
        return batterStarters;
    }
}

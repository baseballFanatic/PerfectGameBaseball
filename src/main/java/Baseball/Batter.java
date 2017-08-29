package Baseball;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Batter extends Player {
    private String round, teamID, lgID, pos;
    private int battingOrder;
    private Hands bats;
    private BatterStats batterStats = new BatterStats();
    //private boolean availability = true;
    private boolean isAvailable = true;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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

/*    boolean isAvailability() {
        return availability;
    }

    void setAvailability(boolean availability) {
        this.availability = availability;
    }*/

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

    int getBattingOrder() {
        return battingOrder;
    }

    void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
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

    boolean needPinchHitter(Inning inning, Team visitorTeam, Team homeTeam, Batter currentBatter,
                            List<Pitcher> visitorPitchers, List<Pitcher> homePitchers,
                            Pitcher battingPitcher)
    {
        return inning.getInning() > 6 && (Math.abs(visitorTeam.getTeamStats().getGameRuns() -
                homeTeam.getTeamStats().getGameRuns()) < 5 && currentBatter.getBattingOrder() > 7
        && battingPitcher.getPitcherStats().getGameRunsAllowed() != 0);
    }

    void removePitcherFromBatters(HashMap<Integer, Batter> batterStarters, Pitcher pitcher)
    {
        Integer indexToDelete = null;
        for (Integer integer : batterStarters.keySet()) {
            if(Objects.equals(batterStarters.get(integer).getPlayerId(), pitcher.getPlayerId()) )
            {
                pitcher.setBattingOrder(batterStarters.get(integer).getBattingOrder());
                System.out.printf("set %s batting order to %s and removed him from the batterStarters file.%n",
                        pitcher.getNameLast(), pitcher.getBattingOrder());
                indexToDelete = integer;
                break;
            }
        }

        batterStarters.remove(indexToDelete);
    }



    Batter getBatter(Inning inning, LineUp lineUp, HashMap<Integer, Batter> batters)
    {
        if (inning.isTop())
        {
            return batters.get(lineUp.getVisitorBattingNumber());
        } else
        {
            return batters.get(lineUp.getHomeBattingNumber());
        }
    }

    List<Batter> getBatterList(boolean visitors, Schedule schedule) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Batter> batterList;
        Batter batter = new Batter();

        if (visitors) {
            //TODO Take out this hard coded year
            int yearID=1913;
            String teamID = schedule.getVisitingTeamId();
            batterList = Database.selectBatters(teamID, yearID);

        } else {
            int yearID=1913;
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

    HashMap<Integer, Batter> matchPositions(List<Batter> batters, HashMap<Integer, Fielder> fielders){
        //int b = 0;
        HashMap<Integer, Batter> matchedBatters = new HashMap<>();

        for (Batter batter : batters)
        {
            for (Integer fielder : fielders.keySet())
            {
                if (Objects.equals(batter.getPlayerId(), fielders.get(fielder).getPlayerId()))
                {
                    batter.setPosition(fielders.get(fielder).getPosition());
                    batter.setBattingOrder(fielders.get(fielder).getBattingOrder());
                    batter.getBatterStats().setGameGamePlayed();
                    batter.getBatterStats().setGameGameStarted(1);
                    batter.setAvailable(false);
                    matchedBatters.put(batter.getBattingOrder(), batter);
                }
            }
        }
        return matchedBatters;
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

    void addNewPitcherToBatters(List<Batter> batterReserves, Pitcher currentPitcher,
                                HashMap<Integer, Batter> batterStarters) {
        Batter batter = new Batter();

        for (Batter batter1 : batterReserves)
        {
            if (batter1.getPlayerId().equals(currentPitcher.getPlayerId()))
            {
                batter1.setBattingOrder(currentPitcher.getBattingOrder());
                batter1.getBatterStats().setGameGamePlayed();
                batter1.setPosition(InPlayPosition.PITCHER);
                System.out.printf("Set currentPitcher batting order to %s and position to %s%n",
                        batter1.getBattingOrder(), batter1.getPosition());
                batter = batter1;
                break;
            }
        }

        batterStarters.put(batter.getBattingOrder(), batter);
    }

    void removeBatterFromBatter(HashMap<Integer, Batter> batterStarters, Batter currentBatter,
                                Inning inning) {
        Integer indexToDelete = null;

        for (Integer integer : batterStarters.keySet()) {
            if(Objects.equals(batterStarters.get(integer).getPlayerId(), currentBatter.getPlayerId()) )
            {
                currentBatter.setBattingOrder(batterStarters.get(integer).getBattingOrder() + inning.getInning());
                indexToDelete = integer;
                break;
            }
        }

        batterStarters.remove(indexToDelete);
    }

    Batter getPinchHitterBatter(Fielder fielder, List<Batter> batterList) {
        for (Batter batter : batterList)
        {
            if (batter.getPlayerId().equals(fielder.getPlayerId()))
            {
                batter.setPosition(fielder.getPosition());
                batter.setBattingOrder(fielder.getBattingOrder());
                return batter;
            }
        }
        return null;
    }

    void addBatterToBatterStarters(HashMap<Integer, Batter> batterStarters, Batter batter) {
        batter.getBatterStats().setGameGamePlayed();
        batterStarters.put(batter.getBattingOrder(), batter);

    }

    Batter getPinchHitterForPitcher(List<Batter> batterList) {
        for (Batter batter : batterList)
        {
            if (batter.isAvailable)
            {
                batter.setPosition(InPlayPosition.PINCH_HITTER);
                return batter;
            }
        }
        return null;
    }
}

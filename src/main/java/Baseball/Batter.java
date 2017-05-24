package Baseball;

import java.util.ArrayList;
import java.util.List;

public class Batter extends Player {
    private String round, battingOrder, position, teamID, lgID;
    private Hands bats;
    private BatterStats batterStats = new BatterStats();
    private boolean availability;
    private int awardPoints, stint;
    private Base firstBase = new Base();
    private Base secondBase = new Base();
    private Base thirdBase = new Base();
    private Pitcher pitcherReachedOn;

    public Batter() {

    }

    private Batter(String nameFirst, String nameLast, Hands bats, String position) {
        this.bats = bats;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
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

    public void setTeamID(String teamID) {
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

    public void setStint(int stint) {
        this.stint = stint;
    }

    public Hands getBats() {
        return bats;
    }

    public void setBats(Hands bats) {
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

    public String getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(String battingOrder) {
        this.battingOrder = battingOrder;
    }

    String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    List<Batter> getBatterList(boolean visitors) {
        List<Batter> batterList = new ArrayList<>();
        Batter batter = new Batter();

        if (visitors) {
            int yearID=1927;
            String teamID="NYA";
            batterList = Database.selectBatters(teamID, yearID, batter);

/*            batterList.add(new Batter("Rickey", "Henderson", Hands.LEFT, "LEFT_FIELD"));
            batterList.add(new Batter("Ty", "Cobb", Hands.LEFT, "CENTER_FIELD"));
            batterList.add(new Batter("Babe", "Ruth", Hands.LEFT, "RIGHT_FIELD"));
            batterList.add(new Batter("Lou", "Gehrig", Hands.LEFT, "FIRST_BASE"));
            batterList.add(new Batter("Hank", "Aaron", Hands.RIGHT, "SHORTSTOP"));
            batterList.add(new Batter("Mike", "Schmidt", Hands.RIGHT, "THIRD_BASE"));
            batterList.add(new Batter("Joe", "Jackson", Hands.LEFT, "SECOND_BASE"));
            batterList.add(new Batter("Yogi", "Berra", Hands.RIGHT, "CATCHER"));
            batterList.add(new Batter("Honus", "Wagner", Hands.RIGHT, "PITCHER"));*/
        } else {
            int yearID=1927;
            String teamID="PHA";
            batterList = Database.selectBatters(teamID, yearID, batter);
/*            batterList.add(new Batter ("Tris", "Speaker", Hands.RIGHT, "CENTER_FIELD"));
            batterList.add(new Batter ("Charlie", "Gehringer", Hands.LEFT, "SECOND_BASE"));
            batterList.add(new Batter ("Johnny", "Bench", Hands.RIGHT, "CATCHER"));
            batterList.add(new Batter ("Mel", "Ott", Hands.LEFT, "RIGHT_FIELD"));
            batterList.add(new Batter ("Harry", "Heilmann", Hands.LEFT, "LEFT_FIELD"));
            batterList.add(new Batter ("Hank", "Greenberg", Hands.RIGHT, "FIRST_BASE"));
            batterList.add(new Batter ("Joe", "Cronin", Hands.RIGHT, "SHORTSTOP"));
            batterList.add(new Batter ("Brooks", "Robinson", Hands.RIGHT, "THIRD_BASE"));
            batterList.add(new Batter ("Paul", "Waner", Hands.LEFT, "PITCHER"));*/
        }

/*        for (Batter batter : batterList) {
            batter.getBatterStats().setAtBats(482);
            batter.getBatterStats().setHits(147);
            batter.getBatterStats().setDoubles(20);
            batter.getBatterStats().setTriples(4);
            batter.getBatterStats().setHomeRuns(12);
            batter.getBatterStats().setWalks(41);
            batter.getBatterStats().setStrikeOuts(71);
            batter.getBatterStats().setSpeedRating(7);
            batter.getBatterStats().calculateBatterProbabilities();*/
        return batterList;
    }

    public Pitcher getPitcherReachedOn() {
        return pitcherReachedOn;
    }

    void setPitcherReachedOn(Pitcher pitcherReachedOn) {
        this.pitcherReachedOn = pitcherReachedOn;
    }
}

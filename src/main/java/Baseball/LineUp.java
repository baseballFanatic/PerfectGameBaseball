package Baseball;

import java.time.LocalDate;
import java.util.*;

class LineUp {
    private int battingOrder;
    private int visitorBattingNumber;
    private int homeBattingNumber, yearID, gameKey, playerOrder, gameNumber;
    private LocalDate gameDate;
    private String retroID, playerName, lgID, teamID, playerPosition;

    LineUp() {
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getYearID() {
        return yearID;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    public int getGameKey() {
        return gameKey;
    }

    public void setGameKey(int gameKey) {
        this.gameKey = gameKey;
    }

    public int getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    int getVisitorBattingNumber() {
        return visitorBattingNumber;
    }

    void setVisitorBattingNumber(int visitorBattingNumber) {
        this.visitorBattingNumber = visitorBattingNumber;
    }

    int getHomeBattingNumber() {
        return homeBattingNumber;
    }

    void setHomeBattingNumber(int homeBattingNumber) {
        this.homeBattingNumber = homeBattingNumber;
    }

    List<Batter> optimizeLineUp(List<Batter> lineUp)
    {
        List<Batter> optimizedLineUp = new ArrayList<>();

        lineUp.sort(new BatterChainedComparator(
                new BatterStolenBasesComparator()
        ));

        for (int o = 0; o < 1; o++)
        {
            optimizedLineUp.add(lineUp.get(o));
            lineUp.get(o).setBattingOrder(1);
            lineUp.remove(lineUp.get(o));
        }

        List<Batter> lineUpOba = lineUp;

        lineUpOba.sort(new BatterChainedComparator(
                new BatterOnBaseAverageComparator()
        ));

        for (Batter batter : lineUpOba)
        {
            if (batter.getBatterStats().getHomeRuns() < 25)
            {
                optimizedLineUp.add(batter);
                batter.setBattingOrder(2);
                lineUpOba.remove(batter);
                break;
            }
        }

        List<Batter> lineUpHr = lineUpOba;

        lineUpHr.sort(new BatterChainedComparator(
                new BatterHomeRunsComparator()
        ));

        for (int o = 3; o < 10; o++)
        {
            optimizedLineUp.add(lineUpHr.get(o));
            lineUpHr.get(o).setBattingOrder(o);
            lineUpHr.remove(lineUpHr.get(o));
        }

        return optimizedLineUp;
    }
}





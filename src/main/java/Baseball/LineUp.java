package Baseball;

import javax.sound.sampled.Line;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class LineUp {
    private int battingOrder;
    private int visitorBattingNumber=1;
    private int homeBattingNumber=1, yearID, gameKey, playerOrder, gameNumber, gamePlayed;
    private LocalDate gameDate;
    private String retroID, playerName, lgID, teamID, playerPosition;

    LineUp() {
    }

    int getGamePlayed() {
        return gamePlayed;
    }

    void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    LocalDate getGameDate() {
        return gameDate;
    }

    void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    int getGameNumber() {
        return gameNumber;
    }

    void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    String getPlayerPosition() {
        return playerPosition;
    }

    void setPlayerPosition(String playerPosition) {
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

    int getPlayerOrder() {
        return playerOrder;
    }

    void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    String getRetroID() {
        return retroID;
    }

    void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    String getPlayerName() {
        return playerName;
    }

    void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    String getLgID() {
        return lgID;
    }

    void setLgID(String lgID) {
        this.lgID = lgID;
    }

    String getTeamID() {
        return teamID;
    }

    void setTeamID(String teamID) {
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

/*    List<Batter> optimizeLineUp(List<Batter> lineUp)
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
    }*/

    void setGameDate(Date date) {
    }

    List<LineUp> getStartingLineup(Schedule schedule, boolean visitors) throws ClassNotFoundException,
            SQLException, InstantiationException {
        List<LineUp> lineUpList = new ArrayList<>();

        if (visitors)
        {
            String teamID = schedule.getVisitingTeamId();
            LocalDate gameDate = schedule.getGameDate();
            int gameKey = schedule.getGameKey();
            int gameNumber = schedule.getVisitingGameNumber();

            lineUpList = Database.selectStartingFielders(teamID, gameDate, gameNumber, gameKey);

        } else
        {
            String teamID = schedule.getHomeTeamId();
            LocalDate gameDate = schedule.getGameDate();
            int gameNumber = schedule.getHomeGameNumber();
            int gameKey = schedule.getGameKey();

            lineUpList = Database.selectStartingFielders(teamID, gameDate, gameNumber, gameKey);
        }

        return lineUpList;
    }
}





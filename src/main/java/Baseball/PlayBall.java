package Baseball;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class PlayBall {
    //    private boolean top = true;
    private boolean gameOver = false;
    private boolean visitors = true;

    public PlayBall() throws InstantiationException, SQLException, ClassNotFoundException {
        Team visitorTeam = new Team();
        Team homeTeam = new Team();
        League league = new League();
        LineUp lineUp = new LineUp();
        Batter batter = new Batter();
        Fielder fielder = new Fielder();
        Pitcher pitcher = new Pitcher();

        List<Batter> visitorBatters = batter.getBatterList(visitors);
        List<Fielder> visitorFieldersReserves = fielder.getFielderList(visitors);
        List<Fielder> visitorFieldersStarters = fielder.getFieldersStartersList(visitorFieldersReserves);
        List<Pitcher> visitorPitchers = pitcher.getPitcherList(visitors);
        List<Batter> visitorStartingLineup = batter.matchPositions(visitorBatters, visitorFieldersStarters);


        setVisitors(false);

        List<Batter> homeBatters = batter.getBatterList(visitors);
        List<Fielder> homeFieldersReserves = fielder.getFielderList(visitors);
        List<Fielder> homeFieldersStarters = fielder.getFieldersStartersList(homeFieldersReserves);
        List<Pitcher> homePitchers = pitcher.getPitcherList(visitors);
        List<Batter> homeStartingLineup = batter.matchPositions(homeBatters, homeFieldersStarters);

        pitcher.setVisitorPitcher(pitcher.findStartingPitcher(visitorPitchers));
        List<Fielder> visitorCompleteStarters = fielder.addPitcherToFielders(visitorFieldersReserves,
                pitcher.getVisitorPitcher(), visitorFieldersStarters);
        pitcher.setHomePitcher(pitcher.findStartingPitcher(homePitchers));
        List<Fielder> homeCompleteStarters = fielder.addPitcherToFielders(homeFieldersReserves,
                pitcher.getHomePitcher(), homeFieldersStarters);

        // TODO: Changed this to a Set.  Need to see if this will work everywhere.
        // TODO: Need to add battingOrder to the lineups.
        Set<Batter> visitorOptimizedLineUp = lineUp.optimizeLineUp(visitorStartingLineup);

        int yearID=1927;
        String lgID="AL";

        league = Database.selectTeamStats(yearID, lgID, league);

        league.setLgID("AL");

        visitorTeam.setTeamName("1927 NY Yankees");
        homeTeam.setTeamName("1927 Philadelphia Athletics");

        out.printf("%s vs %s%n", visitorTeam.getTeamName(), homeTeam.getTeamName());
        System.out.println();
        //TODO: Changed first parameter to Set
        new DisplayInfo().displayLineUp(visitorOptimizedLineUp, homeStartingLineup, visitorPitchers, homePitchers,
                visitorFieldersStarters, homeFieldersStarters);

        Inning inning = new Inning();
        inning.setInning(1);

        while (!isGameOver()) {
            inning.startInning(league, visitorStartingLineup, homeStartingLineup, visitorTeam, homeTeam, inning, visitorCompleteStarters,
                    homeCompleteStarters, lineUp, visitorPitchers, homePitchers, gameOver, pitcher);
            checkGameOver(visitorTeam, homeTeam, gameOver, inning);
            if (inning.isTop()){
                inning.setTop(false);
            } else if (!inning.isTop()){
                inning.setTop(true);
                inning.setInning(inning.getInning() + 1);
                new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
            }

        }

        new DisplayInfo().endOfGame(visitorStartingLineup, homeStartingLineup, visitorFieldersStarters, homeFieldersStarters, visitorPitchers,
                homePitchers, visitorTeam, homeTeam, pitcher);
    }

    private boolean isGameOver() {
        return gameOver;
    }

    private void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    private void checkGameOver(Team visitorTeam, Team homeTeam, boolean gameOver, Inning inning) {
        if (inning.isTop() && !gameOver && inning.getInning() >= 9 && homeTeam.getTeamStats().getGameRuns() >
                visitorTeam.getTeamStats().getGameRuns()) {
            inning.setInning(inning.getInning() + 1);
            setGameOver(true);
            new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
        } else if (!inning.isTop() && !gameOver && inning.getInning() >= 9 && homeTeam.getTeamStats().getGameRuns() <
                visitorTeam.getTeamStats().getGameRuns()) {
            setGameOver(true);
            // new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
        } else if (!inning.isTop() && !gameOver && inning.getInning() >= 9 && homeTeam.getTeamStats().getGameRuns() >
                visitorTeam.getTeamStats().getGameRuns()) {
            setGameOver(true);
            //   new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
        }
    }

    public boolean isVisitors() {
        return visitors;
    }

    private void setVisitors(boolean visitors) {
        this.visitors = visitors;
    }
}

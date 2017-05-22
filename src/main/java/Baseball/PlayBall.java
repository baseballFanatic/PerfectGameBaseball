package Baseball;

import java.util.List;

import static java.lang.System.out;

public class PlayBall {
    //    private boolean top = true;
    private boolean gameOver = false;
    private boolean visitors = true;

    public PlayBall() {
        Team visitorTeam = new Team();
        Team homeTeam = new Team();
        League league = new League();
        LineUp lineUp = new LineUp();
        Batter batter = new Batter();
        Fielder fielder = new Fielder();
        Pitcher pitcher = new Pitcher();

        List<Batter> visitorBatters = batter.getBatterList(visitors);
        List<Fielder> visitorFielders = fielder.getFielderList(visitors);
        List<Pitcher> visitorPitchers = pitcher.getPitcherList(visitors);

        setVisitors(false);

        List<Batter> homeBatters = batter.getBatterList(visitors);
        List<Fielder> homeFielders = fielder.getFielderList(visitors);
        List<Pitcher> homePitchers = pitcher.getPitcherList(visitors);

        pitcher.setVisitorPitcher(visitorPitchers.get(0));
        pitcher.getVisitorPitcher().setAvailable(false);
        pitcher.setHomePitcher(homePitchers.get(0));
        pitcher.getHomePitcher().setAvailable(false);

        league.setLgID("NL");

        visitorTeam.setTeamName("AL All-Stars");
        homeTeam.setTeamName("NL All-Stars");

        out.printf("%s vs %s%n", visitorTeam.getTeamName(), homeTeam.getTeamName());

        Inning inning = new Inning();
        inning.setInning(1);

        while (!isGameOver()) {
            inning.startInning(league, visitorBatters, homeBatters, visitorTeam, homeTeam, inning, visitorFielders,
                    homeFielders, lineUp, visitorPitchers, homePitchers, gameOver, pitcher);
            checkGameOver(visitorTeam, homeTeam, gameOver, inning);
            if (inning.isTop()){
                inning.setTop(false);
            } else if (!inning.isTop()){
                inning.setTop(true);
                inning.setInning(inning.getInning() + 1);
                new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
            }

        }

        new DisplayInfo().endOfGame(visitorBatters, homeBatters, visitorFielders, homeFielders, visitorPitchers,
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

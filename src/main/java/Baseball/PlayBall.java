package Baseball;

import javax.sound.sampled.Line;
import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class PlayBall {
    //    private boolean top = true;
    private boolean gameOver = false;
    private boolean visitors = true;

    public PlayBall() throws InstantiationException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Team visitorTeam = new Team();
        Team homeTeam = new Team();
        League league = new League();
        LineUp lineUp = new LineUp();
        Batter batter = new Batter();
        Fielder fielder = new Fielder();
        Pitcher pitcher = new Pitcher();

        List<Integer> visitorLineScore = new ArrayList<>();
        List<Integer> homeLineScore = new ArrayList<>();

        int yearID=1927;
        String lgID="AL";

        league = Database.selectTeamStats(yearID, lgID, league);

        league.setLgID("AL");

        Schedule schedule = Database.selectSchedule(yearID, lgID);

        // Selects batters based on schedule file
        List<Batter> visitorBatters = batter.getBatterList(visitors,schedule);
        // Selects all fielders available for the team
        List<Fielder> visitorFieldersReserves = fielder.getFielderList(visitors, schedule);
        // Selects starters for all 8 regular positions from the list of fielders available
        List<LineUp> visitorStarters = lineUp.getStartingLineup(schedule, visitors);
        List<Fielder> visitorFieldersStarters = fielder.getFieldersStartersList(visitorStarters, visitorFieldersReserves);
        // Selects all pitchers for the team
        List<Pitcher> visitorPitchers = pitcher.getPitcherList(visitors, schedule);
        // Matches batter to fielder on retroID and assigns the batter to the starting lineup
        List<Batter> visitorBatterStarters = batter.matchPositions(visitorBatters, visitorFieldersStarters);

        setVisitors(false);

        List<Batter> homeBatters = batter.getBatterList(visitors, schedule);
        List<Fielder> homeFieldersReserves = fielder.getFielderList(visitors, schedule);
        List<LineUp> homeStarters = lineUp.getStartingLineup(schedule, visitors);
        List<Fielder> homeFieldersStarters = fielder.getFieldersStartersList(homeStarters, homeFieldersReserves);
        List<Pitcher> homePitchers = pitcher.getPitcherList(visitors, schedule);
        List<Batter> homeBatterStarters = batter.matchPositions(homeBatters, homeFieldersStarters);

        // Selects an available starting pitcher
        setVisitors(true);
        pitcher.setVisitorPitcher(pitcher.findStartingPitcher(visitorPitchers, schedule, visitors));
        setVisitors(false);
        pitcher.setHomePitcher(pitcher.findStartingPitcher(homePitchers, schedule, visitors));

        visitorTeam.setTeamName(schedule.getVisitingTeamId());
        homeTeam.setTeamName(schedule.getHomeTeamId());

        out.printf("%s vs %s%n", visitorTeam.getTeamName(), homeTeam.getTeamName());
        System.out.println();
        new DisplayInfo().displayLineUp(visitorBatterStarters, homeBatterStarters, visitorPitchers, homePitchers,
                visitorFieldersStarters, homeFieldersStarters);

        Inning inning = new Inning();
        inning.setInning(1);

        while (!isGameOver()) {
            inning.startInning(league, visitorBatterStarters, homeBatterStarters, visitorTeam, homeTeam, inning, visitorFieldersStarters,
                    homeFieldersStarters, lineUp, visitorPitchers, homePitchers, gameOver, pitcher, visitorLineScore,
                    homeLineScore);
            checkGameOver(visitorTeam, homeTeam, gameOver, inning);
            if (inning.isTop()){
                inning.setTop(false);
            } else if (!inning.isTop()){
                inning.setTop(true);
                inning.setInning(inning.getInning() + 1);
                new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
            }
        }

        new DisplayInfo().endOfGame(visitorBatterStarters, homeBatterStarters, visitorFieldersStarters, homeFieldersStarters, visitorPitchers,
                homePitchers, visitorTeam, homeTeam, pitcher, visitorLineScore, homeLineScore);
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
        } else if (!inning.isTop() && !gameOver && inning.getInning() >= 9 && homeTeam.getTeamStats().getGameRuns() >
                visitorTeam.getTeamStats().getGameRuns()) {
            setGameOver(true);
        }
    }

    public boolean isVisitors() {
        return visitors;
    }

    private void setVisitors(boolean visitors) {
        this.visitors = visitors;
    }
}

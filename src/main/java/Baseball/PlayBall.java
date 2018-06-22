package Baseball;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

public class PlayBall {
    //    private boolean top = true;
    private boolean gameOver = false;
    private boolean visitors = true;

    public PlayBall(int yearID, String lgID, String round, String simName) throws InstantiationException, SQLException, ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        Team visitorTeam;
        Team homeTeam;
        League league = new League();
        LineUp lineUp = new LineUp();
        Batter batter = new Batter();
        Fielder fielder = new Fielder();
        Pitcher pitcher = new Pitcher();
        Player player = new Player();

        List<Integer> visitorLineScore = new ArrayList<>();
        List<Integer> homeLineScore = new ArrayList<>();

        league = Database.selectTeamStats(yearID, lgID, league);
        league.setLgID(lgID);

        Schedule schedule = Database.selectSchedule(yearID, lgID);

        homeTeam = Database.getTeamInfo(schedule.getHomeTeamId(), yearID);
        visitorTeam = Database.getTeamInfo(schedule.getVisitingTeamId(), yearID);
        homeTeam.setTeamId(schedule.getHomeTeamId());
        visitorTeam.setTeamId(schedule.getVisitingTeamId());

        // Selects batters based on schedule file
        List<Batter> visitorBatters = batter.getBatterList(visitors, schedule);
        // Selects all fielders available for the team
        List<Fielder> visitorFieldersReserves = fielder.getFielderList(visitors, schedule);
        // Selects starters for all 8 regular positions from the schedule list based on game
        List<LineUp> visitorStarters = lineUp.getStartingLineup(schedule, visitors);
        HashMap<Integer, Fielder> visitorFieldersStarters = fielder.getFieldersStartersList(visitorStarters, visitorFieldersReserves);
        // Selects all pitchers for the team
        List<Pitcher> visitorPitchers = pitcher.getPitcherList(visitors, schedule, visitorTeam);
        // Matches batter to fielder on retroID and assigns the batter to the starting lineup
        HashMap<Integer, Batter> visitorBatterStarters = batter.matchPositions(visitorBatters, visitorFieldersStarters);

        setVisitors(false);

        List<Batter> homeBatters = batter.getBatterList(visitors, schedule);
        List<Fielder> homeFieldersReserves = fielder.getFielderList(visitors, schedule);
        List<LineUp> homeStarters = lineUp.getStartingLineup(schedule, visitors);
        HashMap<Integer, Fielder> homeFieldersStarters = fielder.getFieldersStartersList(homeStarters, homeFieldersReserves);
        List<Pitcher> homePitchers = pitcher.getPitcherList(visitors, schedule, homeTeam);
        HashMap<Integer, Batter> homeBatterStarters = batter.matchPositions(homeBatters, homeFieldersStarters);

        // Selects an available starting pitcher
        setVisitors(true);
        //pitcher.setVisitorPitcher(pitcher.findStartingPitcher(visitorPitchers, schedule, visitors));
        pitcher.setVisitorPitcher(pitcher.findStartingPitcher(visitorPitchers, schedule.getVisitingStartingPitcherId(),
                schedule.getGameDate()));
        pitcher.setVisitorStarter(pitcher.getVisitorPitcher());
        schedule.setVisitingStartingPitcherName(pitcher.getVisitorStarter().getNameLast());
        schedule.setVisitingStartingPitcherId(pitcher.getVisitorStarter().getPlayerId());
        pitcher.setStartingPitcherBattingOrder(pitcher.getVisitorPitcher(), visitorBatterStarters);
        pitcher.getVisitorStarter().getPitcherStats().setGameGamePlayed(1);
        pitcher.getVisitorStarter().getPitcherStats().setGameGameStarted(1);
        setVisitors(false);
        pitcher.setHomePitcher(pitcher.findStartingPitcher(homePitchers, schedule.getHomeStartingPitcherId(),
                schedule.getGameDate()));
        pitcher.setHomeStarter(pitcher.getHomePitcher());
        schedule.setHomeStartingPitcherName(pitcher.getHomeStarter().getNameLast());
        schedule.setHomeStartingPitcherId(pitcher.getHomeStarter().getPlayerId());
        pitcher.setStartingPitcherBattingOrder(pitcher.getHomePitcher(), homeBatterStarters);
        pitcher.getHomeStarter().getPitcherStats().setGameGameStarted(1);
        pitcher.getHomeStarter().getPitcherStats().setGameGamePlayed(1);

        player.updatePlayPercent(visitorBatters, visitorPitchers, visitorFieldersReserves, visitorTeam);
        player.updatePlayPercent(homeBatters, homePitchers, homeFieldersReserves, homeTeam);

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
                    homeLineScore, visitorBatters, homeBatters, visitorFieldersReserves, homeFieldersReserves, schedule);
            checkGameOver(visitorTeam, homeTeam, gameOver, inning);
            if (inning.isTop()){
                inning.setTop(false);
            } else if (!inning.isTop()){
                inning.setTop(true);
                inning.setInning(inning.getInning() + 1);
                new DisplayInfo().endOfInning(visitorTeam, homeTeam, inning);
            }
        }

        new DisplayInfo().endOfGame(visitorBatters, homeBatters, visitorFieldersStarters, homeFieldersStarters, visitorPitchers,
                homePitchers, visitorTeam, homeTeam, pitcher, visitorLineScore, homeLineScore, visitorFieldersReserves,
                homeFieldersReserves, schedule);


        batter.getBatterStats().updateBatterGameStats(visitorBatters);
        batter.getBatterStats().updateBatterGameStats(homeBatters);
        homeTeam.updateTeamGameStats(homeTeam, homeBatters, homeFieldersReserves, homePitchers);
        visitorTeam.updateTeamGameStats(visitorTeam, visitorBatters, visitorFieldersReserves, visitorPitchers);
        new Database().updateBatters(visitorBatters);
        new Database().updateBatters(homeBatters);

        pitcher.getPitcherStats().updatePitcherGameStats(visitorPitchers);
        pitcher.getPitcherStats().updatePitcherGameStats(homePitchers);
        fielder.getFielderStats().updateFielderGameStats(visitorFieldersReserves);
        fielder.getFielderStats().updateFielderGameStats(homeFieldersReserves);

        // Inserts the players into pgbs_box_score
        new Database().insertPlayersBoxScore( visitorBatters, round, simName );
        new Database().insertPlayersBoxScore( homeBatters, round, simName );
        // Updates the fielder stats for the players already inserted into pgbs_box_score
        new Database().updateBoxScoreFielders( visitorFieldersReserves );
        new Database().updateBoxScoreFielders( homeFieldersReserves );
        // Updates the pitcher stats for the players already inserted into pgbs_box_score
        new Database().updateBoxScorePitchers( visitorPitchers );
        new Database().updateBoxScorePitchers( homePitchers );

        new Database().updatePitchers(visitorPitchers);
        new Database().updatePitchers(homePitchers);
        new Database().updateFielders(visitorFieldersReserves);
        new Database().updateFielders(homeFieldersReserves);
        new Database().updateScheduleGame(schedule);
        new Database().updateTeamGameStats(homeTeam);
        new Database().updateTeamGameStats(visitorTeam);
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

package Baseball;

import java.util.HashMap;
import java.util.List;

class DisplayInfo {

    void inningStart(boolean top, Inning inning) {
        System.out.println();
        if (top) {
            System.out.printf("------------- Start of Inning %s ---------------%n", inning.getInning());
        } else {
            System.out.printf("------------- Bottom of Inning %s ---------------%n", inning.getInning());
        }
        System.out.println();
    }

    void preAtBatInfo(Bases bases, PitchResult outs) {
        System.out.println();
        System.out.println("Pre At-Bat:");
        if (bases.getFirstBase().isOccupied()) System.out.printf("On First: %s%n", bases.getFirstBase().getBatter().getNameLast());
        else {System.out.println("On First: None");}
        if (bases.getSecondBase().isOccupied()) {System.out.printf("On Second: %s%n", bases.getSecondBase().getBatter().getNameLast());}
        else {System.out.println("On Second: None");}
        if (bases.getThirdBase().isOccupied()) {System.out.printf("On Third: %s%n", bases.getThirdBase().getBatter().getNameLast());}
        else {System.out.println("On Third: None");}
        System.out.printf("Outs: %s%n", outs.getOuts());
    }

    void batterUp(Pitcher pitcher, Batter batter, AtBatResult ab) {
        System.out.println();
        System.out.printf("%s %s batting against %s %s%n", batter.getNameFirst(), batter.getNameLast(),
                pitcher.getNameFirst(), pitcher.getNameLast());
        System.out.println();
        System.out.printf("Result: %s%n", ab);
    }

    void atBatInfo(Base firstBase, Base secondBase, Base thirdBase, PitchResult outs) {
        System.out.println();
        System.out.println("Post Event:");
        if (firstBase.isOccupied()) System.out.printf("On First: %s%n", firstBase.getBatter().getNameLast());
        else {System.out.println("On First: None");}
        if (secondBase.isOccupied()) {System.out.printf("On Second: %s%n", secondBase.getBatter().getNameLast());}
        else {System.out.println("On Second: None");}
        if (thirdBase.isOccupied()) {System.out.printf("On Third: %s%n", thirdBase.getBatter().getNameLast());}
        else {System.out.println("On Third: None");}
        System.out.printf("Outs: %s%n", outs.getOuts());

    }

    void endOfInning(Team visitorTeam, Team homeTeam, Inning inning) {
        System.out.printf("%n---------------------------------------%n");
        System.out.printf("Visitor Runs: %s%n", visitorTeam.getTeamStats().getGameRuns());
        System.out.printf("Visitor Hits: %s%n", visitorTeam.getTeamStats().getGameHits());
        System.out.printf("Visitor Errors: %s%n", visitorTeam.getTeamStats().getGameErrors());
        System.out.printf("Visitor Double Plays: %s%n", visitorTeam.getTeamStats().getGameDoublePlays());
        System.out.printf("Visitor Left On Base: %s%n", visitorTeam.getTeamStats().getGameLeftOnBase());
        System.out.println();
        System.out.printf("Home Runs: %s%n", homeTeam.getTeamStats().getGameRuns());
        System.out.printf("Home Hits: %s%n", homeTeam.getTeamStats().getGameHits());
        System.out.printf("Home Errors: %s%n", homeTeam.getTeamStats().getGameErrors());
        System.out.printf("Home Double Plays: %s%n", homeTeam.getTeamStats().getGameDoublePlays());
        System.out.printf("Home Left On Base: %s%n", homeTeam.getTeamStats().getGameLeftOnBase());
        System.out.println();
        System.out.printf("End of Inning %s%n", inning.getInning() - 1);
    }

    void displayLineUp(HashMap<Integer, Batter> visitorStartingLineup, HashMap<Integer, Batter> homeStartingLineup, List<Pitcher> visitorPitchers,
                       List<Pitcher> homePitchers, HashMap<Integer, Fielder> visitorFielderStarters, HashMap<Integer, Fielder> homeFielderStarters)
    {
        System.out.println();
        System.out.printf("Starting LineUps:%n");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("Visitors:");
        System.out.printf("");
        System.out.printf("%10s %3s %6s %4s %4s %5s %5s %5s %5s %5s %5s %5s %4s %4s %3s %16s %6s", "Name", "Ord", "AtBats", "Runs", "Hits",
                "RBI", "2B", "3B", "HR", "BB", "K", "SacF", "SacH", "SB", "CS", "Position", "SR");
        System.out.println();
   //     for (Batter batter : visitorStartingLineup) {
        for (int i = 1; i < 10; i++)
        {
            Batter batter = visitorStartingLineup.get(i);
            System.out.format("%10s %3s %6s %4s %4s %4s %5s %5s %5s %5s %5s %4s %4s %4s %3s %16s %.1f",
                    batter.getNameLast(), batter.getBattingOrder(), batter.getBatterStats().getAtBats(),
                    batter.getBatterStats().getRuns(), batter.getBatterStats().getHits(),
                    batter.getBatterStats().getRbi(),
                    batter.getBatterStats().getDoubles(), batter.getBatterStats().getTriples(),
                    batter.getBatterStats().getHomeRuns(), batter.getBatterStats().getWalks(),
                    batter.getBatterStats().getStrikeOuts(), batter.getBatterStats().getSacrificeFlies(),
                    batter.getBatterStats().getSacrificeHits(), batter.getBatterStats().getStolenBases(),
                    batter.getBatterStats().getCaughtStealing(), batter.getPosition(), batter.getBatterStats().getSpeedRating());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %2s %2s %3s %2s %2s %2s %2s %10s", "Name", "BF", "IPO", "H", "R", "ER", "BB", "K", "Role");
        System.out.println();
        for (Pitcher printedPitcher : visitorPitchers) {
            System.out.printf("%10s %2s %2s %4s %2s %2s %2s %2s %10s", printedPitcher.getNameLast(),
                    printedPitcher.getPitcherStats().getBattersFaced(),
                    printedPitcher.getPitcherStats().getiPouts(),
                    printedPitcher.getPitcherStats().getHitsAllowed(),
                    printedPitcher.getPitcherStats().getRuns(),
                    printedPitcher.getPitcherStats().getEarnedRuns(),
                    printedPitcher.getPitcherStats().getWalksAllowed(),
                    printedPitcher.getPitcherStats().getStrikeOutsAllowed(),
                    printedPitcher.getPitcherRole());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Visitor Fielding Stats%n");
        System.out.printf("%10s %7s %2s %2s %2s %2s %2s", "Name", "Assists", "PO", "DP", "E", "SBA", "TO");
        System.out.println();
        //for (Fielder fielder : visitorFielderStarters) {
        for (int i = 1; i < 10; i++) {
            Fielder fielder = visitorFielderStarters.get(i);
            System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                    fielder.getFielderStats().getAssists(),
                    fielder.getFielderStats().getPutOuts(), fielder.getFielderStats().getDoublePlays(),
                    fielder.getFielderStats().getErrors(), fielder.getFielderStats().getStolenBases(),
                    fielder.getFielderStats().getCaughtStealing());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Home:");
        System.out.printf("");
        System.out.printf("%10s %3s %6s %4s %4s %5s %5s %5s %5s %5s %5s %5s %4s %4s %3s %16s", "Name", "Ord", "AtBats", "Runs", "Hits",
                "RBI", "2B", "3B", "HR", "BB", "K", "SacF", "SacH", "SB", "CS", "Position", "SR");
        System.out.println();
       // for (Batter batter : homeStartingLineup) {
        for (int i = 1; i < 10; i++)
        {
            Batter batter = homeStartingLineup.get(i);
            System.out.format("%10s %3s %6s %4s %4s %4s %5s %5s %5s %5s %5s %4s %4s %4s %3s %16s %.1f",
                    batter.getNameLast(), batter.getBattingOrder(), batter.getBatterStats().getAtBats(),
                    batter.getBatterStats().getRuns(), batter.getBatterStats().getHits(),
                    batter.getBatterStats().getRbi(),
                    batter.getBatterStats().getDoubles(), batter.getBatterStats().getTriples(),
                    batter.getBatterStats().getHomeRuns(), batter.getBatterStats().getWalks(),
                    batter.getBatterStats().getStrikeOuts(), batter.getBatterStats().getSacrificeFlies(),
                    batter.getBatterStats().getSacrificeHits(), batter.getBatterStats().getStolenBases(),
                    batter.getBatterStats().getCaughtStealing(), batter.getPosition(), batter.getBatterStats().getSpeedRating());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %2s %2s %3s %2s %2s %2s %2s %10s", "Name", "BF", "IPO", "H", "R", "ER", "BB", "K", "Role");
        System.out.println();
        for (Pitcher printedPitcher : homePitchers) {
            System.out.printf("%10s %2s %2s %4s %2s %2s %2s %2s %10s", printedPitcher.getNameLast(),
                    printedPitcher.getPitcherStats().getBattersFaced(),
                    printedPitcher.getPitcherStats().getiPouts(),
                    printedPitcher.getPitcherStats().getHitsAllowed(),
                    printedPitcher.getPitcherStats().getRuns(),
                    printedPitcher.getPitcherStats().getEarnedRuns(),
                    printedPitcher.getPitcherStats().getWalksAllowed(),
                    printedPitcher.getPitcherStats().getStrikeOutsAllowed(),
                    printedPitcher.getPitcherRole());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Home Fielding Stats%n");
        System.out.printf("%10s %7s %2s %2s %2s %2s %2s", "Name", "Assists", "PO", "DP", "E", "SBA", "TO");
        System.out.println();
        for (int i = 1; i < 10; i++) {
            Fielder fielder = homeFielderStarters.get(i);
            System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                    fielder.getFielderStats().getAssists(),
                    fielder.getFielderStats().getPutOuts(), fielder.getFielderStats().getDoublePlays(),
                    fielder.getFielderStats().getErrors(), fielder.getFielderStats().getStolenBases(),
                    fielder.getFielderStats().getCaughtStealing());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    void endOfGame(List<Batter> visitorBatters, List<Batter> homeBatters, HashMap<Integer, Fielder> visitorFielders,
                   HashMap<Integer, Fielder> homeFielders, List<Pitcher> visitorPitchers, List<Pitcher> homePitchers,
                   Team visitorTeam, Team homeTeam, Pitcher pitcher, List<Integer> visitorLineScore,
                   List<Integer> homeLineScore, List<Fielder> visitorFieldersReserves, List<Fielder> homeFieldersReserves,
                   Schedule schedule) {
        System.out.println();
        System.out.printf("BALLGAME!%n");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%3s: %2s %2s %2s %2s %2s %2s %2s %2s %2s %2s     %2s %2s %2s",
                "Team", "1", "2", "3", "4", "5", "6", "7", "8", "9", "X", "R", "H", "E");
        System.out.println();
        System.out.printf("%s   ", visitorTeam.getTeamName());

        String visitingScore = "";
        String homeScore = "";

        //TODO Need to fix the line score display when home team wins in bottom of 9th.
        //TODO currently displays the final inning twice, once in the X slot and once to the right.
        for (Integer score : visitorLineScore) {
            visitingScore = visitingScore + score;
            System.out.printf("%2s ", score);
        }

        if (visitorLineScore.size() == 9) {
            System.out.printf("       %2s %2s %2s", visitorTeam.getTeamStats().getGameRuns(),
                    visitorTeam.getTeamStats().getGameHits(), visitorTeam.getTeamStats().getGameErrors());
        } else
        {
            int lastAtBat = visitorLineScore.get(visitorLineScore.size() - 1);
            System.out.printf("%2s", lastAtBat);
            System.out.printf("    %2s %2s %2s", visitorTeam.getTeamStats().getGameRuns(),
                    visitorTeam.getTeamStats().getGameHits(), visitorTeam.getTeamStats().getGameErrors());

        }
        System.out.println();
        System.out.printf("%s   ", homeTeam.getTeamName());
        for (Integer hScore : homeLineScore)
        {
            homeScore = homeScore + hScore;
            System.out.printf("%2s ", hScore);
        }
        if (homeLineScore.size() == 8)
        {
            System.out.printf(" X");
            System.out.printf("        %2s %2s %2s", homeTeam.getTeamStats().getGameRuns(),
                    homeTeam.getTeamStats().getGameHits(), homeTeam.getTeamStats().getGameErrors());
        } else if (homeLineScore.size() == 9)
        {
            System.out.printf("       %2s %2s %2s", homeTeam.getTeamStats().getGameRuns(),
                    homeTeam.getTeamStats().getGameHits(), homeTeam.getTeamStats().getGameErrors());
        } else
        {
            int lastAtBat = homeLineScore.get(visitorLineScore.size() - 1);
            System.out.printf("%2s", lastAtBat);
            System.out.printf("    %2s %2s %2s", homeTeam.getTeamStats().getGameRuns(),
                    homeTeam.getTeamStats().getGameHits(), homeTeam.getTeamStats().getGameErrors());
        }
        System.out.println();
        System.out.println();
        schedule.setVisitingLineScore(visitingScore);
        schedule.setHomeLineScore(homeScore);
        schedule.setVisitingScore(visitorTeam.getTeamStats().getGameRuns());
        schedule.setHomeScore(homeTeam.getTeamStats().getGameRuns());
        schedule.setVisitingHits( visitorTeam.getTeamStats().getGameHits() );
        schedule.setVisitingErrors( visitorTeam.getTeamStats().getGameErrors() );
        schedule.setHomeHits( homeTeam.getTeamStats().getGameHits() );
        schedule.setHomeErrors( homeTeam.getTeamStats().getGameErrors() );
        schedule.setGameCompleted("Y");
        if (homeTeam.getTeamStats().getGameRuns() > visitorTeam.getTeamStats().getGameRuns()) {
            System.out.printf("Winning Pitcher: %s%n", pitcher.getHomeWinningPitcher().getNameLast());
            pitcher.getHomeWinningPitcher().getPitcherStats().setsWins(pitcher.getHomeWinningPitcher().getPitcherStats().getsWins() + 1);
            pitcher.getVisitorLosingPitcher().getPitcherStats().setsLosses(pitcher.getVisitorLosingPitcher().getPitcherStats().getsLosses() + 1);
            pitcher.checkCompleteGame(pitcher.getHomeWinningPitcher(), visitorLineScore);
            homeTeam.updateTeamStreaks(homeTeam, visitorTeam);
            String winningPitcherFullName = pitcher.getHomeWinningPitcher().getNameFirst().substring( 0, 1 ) + ' ' + pitcher.getHomeWinningPitcher().getNameLast();
            schedule.setWinningPitcherName(winningPitcherFullName);
            schedule.setWinningPitcherId(pitcher.getHomeWinningPitcher().getPlayerId());
            schedule.setWinningPitcherWins( pitcher.getHomeWinningPitcher().getPitcherStats().getsWins() );
            schedule.setWinningPitcherLosses( pitcher.getHomeWinningPitcher().getPitcherStats().getsLosses() );
            homeTeam.getTeamStats().setSeasonGames(homeTeam.getTeamStats().getSeasonGames() + 1);
            homeTeam.getTeamStats().setSeasonWins(homeTeam.getTeamStats().getSeasonWins() + 1);
            homeTeam.getTeamStats().setHomeWins(homeTeam.getTeamStats().getHomeWins() + 1);
            visitorTeam.getTeamStats().setAwayLosses(visitorTeam.getTeamStats().getAwayLosses() + 1);
            visitorTeam.getTeamStats().setSeasonGames(visitorTeam.getTeamStats().getSeasonGames() + 1);
            visitorTeam.getTeamStats().setSeasonLosses(visitorTeam.getTeamStats().getSeasonLosses() + 1);
            homeTeam.getTeamStats().setCurrentWinStreak(homeTeam.getTeamStats().getCurrentWinStreak() + 1);
            homeTeam.getTeamStats().setCurrentLossStreak(0);
            visitorTeam.getTeamStats().setCurrentWinStreak(0);
            visitorTeam.getTeamStats().setCurrentLossStreak(visitorTeam.getTeamStats().getCurrentLossStreak() + 1);
            System.out.printf("Losing Pitcher: %s%n", pitcher.getVisitorLosingPitcher().getNameLast());
            String losingPitcherFullName = pitcher.getVisitorLosingPitcher().getNameFirst().substring( 0, 1 ) + ' ' + pitcher.getVisitorLosingPitcher().getNameLast();
            schedule.setLosingPitcherName(losingPitcherFullName);
            schedule.setLosingPitcherId(pitcher.getVisitorLosingPitcher().getPlayerId());
            schedule.setLosingPitcherWins( pitcher.getVisitorLosingPitcher().getPitcherStats().getsWins() );
            schedule.setLosingPitcherLosses( pitcher.getVisitorLosingPitcher().getPitcherStats().getsLosses() );
            schedule.setHomeWins( homeTeam.getTeamStats().getSeasonWins() );
            schedule.setHomeLosses( homeTeam.getTeamStats().getSeasonLosses() );
            schedule.setAwayLosses( visitorTeam.getTeamStats().getSeasonLosses() );
            schedule.setAwayWins( visitorTeam.getTeamStats().getSeasonWins() );
            if (pitcher.getHomeSavePitcher() != null) {
                System.out.printf("Save: %s%n", pitcher.getHomeSavePitcher().getNameLast());
                pitcher.getHomeSavePitcher().getPitcherStats().setsSaves(pitcher.getHomeSavePitcher().getPitcherStats().getsSaves() + 1);
                String savingPitcherFullName = pitcher.getHomeSavePitcher().getFinalGame() + ' ' + pitcher.getHomeSavePitcher().getNameLast();
                schedule.setSavingPitcherName(savingPitcherFullName);
                schedule.setSavingPitcherId(pitcher.getHomeSavePitcher().getPlayerId());
                homeTeam.getTeamStats().setsSaves(homeTeam.getTeamStats().getsSaves() + 1);
            } else {
                System.out.println("Save: None");
            }
        } else {
            System.out.printf("Winning Pitcher: %s%n", pitcher.getVisitorWinningPitcher().getNameLast());
            System.out.printf("Losing Pitcher: %s%n", pitcher.getHomeLosingPitcher().getNameLast());
            pitcher.getVisitorWinningPitcher().getPitcherStats().setsWins(pitcher.getVisitorWinningPitcher().getPitcherStats().getsWins() + 1);
            pitcher.getHomeLosingPitcher().getPitcherStats().setsLosses(pitcher.getHomeLosingPitcher().getPitcherStats().getsLosses() + 1);
            pitcher.checkCompleteGame(pitcher.getVisitorWinningPitcher(), homeLineScore);
            visitorTeam.getTeamStats().setSeasonGames(visitorTeam.getTeamStats().getSeasonGames() + 1);
            visitorTeam.getTeamStats().setSeasonWins(visitorTeam.getTeamStats().getSeasonWins() + 1);
            visitorTeam.getTeamStats().setAwayWins(visitorTeam.getTeamStats().getAwayWins() + 1);
            homeTeam.getTeamStats().setHomeLosses(homeTeam.getTeamStats().getHomeLosses() + 1);
            homeTeam.getTeamStats().setSeasonGames(homeTeam.getTeamStats().getSeasonGames() + 1);
            homeTeam.getTeamStats().setSeasonLosses(homeTeam.getTeamStats().getSeasonLosses() + 1);
            homeTeam.getTeamStats().setCurrentLossStreak(homeTeam.getTeamStats().getCurrentLossStreak() + 1);
            homeTeam.getTeamStats().setCurrentWinStreak(0);
            visitorTeam.getTeamStats().setCurrentWinStreak(visitorTeam.getTeamStats().getCurrentWinStreak() + 1);
            visitorTeam.getTeamStats().setCurrentLossStreak(0);
            visitorTeam.updateTeamStreaks(visitorTeam, homeTeam);
            String winningPitcherFullName = pitcher.getVisitorWinningPitcher().getNameFirst().substring( 0, 1 ) + ' ' + pitcher.getVisitorWinningPitcher().getNameLast();
            schedule.setWinningPitcherName(winningPitcherFullName);
            schedule.setWinningPitcherId(pitcher.getVisitorWinningPitcher().getPlayerId());
            schedule.setWinningPitcherWins( pitcher.getVisitorWinningPitcher().getPitcherStats().getsWins() );
            schedule.setWinningPitcherLosses( pitcher.getVisitorWinningPitcher().getPitcherStats().getsLosses() );
            String losingPitcherFullName = pitcher.getHomeLosingPitcher().getNameFirst().substring( 0, 1 ) + ' ' + pitcher.getHomeLosingPitcher().getNameLast();
            schedule.setLosingPitcherName(losingPitcherFullName);
            schedule.setLosingPitcherId(pitcher.getHomeLosingPitcher().getPlayerId());
            schedule.setLosingPitcherWins( pitcher.getHomeLosingPitcher().getPitcherStats().getsWins() );
            schedule.setLosingPitcherLosses( pitcher.getHomeLosingPitcher().getPitcherStats().getsLosses() );
            schedule.setHomeLosses( homeTeam.getTeamStats().getSeasonLosses() );
            schedule.setHomeWins( homeTeam.getTeamStats().getSeasonWins() );
            schedule.setAwayWins( visitorTeam.getTeamStats().getSeasonWins() );
            schedule.setAwayLosses( visitorTeam.getTeamStats().getSeasonLosses() );
            if (pitcher.getVisitorSavePitcher() != null) {
                System.out.printf("Save: %s%n", pitcher.getVisitorSavePitcher().getNameLast());
                pitcher.getVisitorSavePitcher().getPitcherStats().setsSaves(pitcher.getVisitorSavePitcher().getPitcherStats().getsSaves() + 1);
                String pitcherSaveFullName = pitcher.getVisitorSavePitcher().getNameFirst().substring( 0, 1 ) + ' ' + pitcher.getVisitorSavePitcher().getNameLast();
                schedule.setSavingPitcherName(pitcherSaveFullName);
                schedule.setSavingPitcherId(pitcher.getVisitorSavePitcher().getPlayerId());
                visitorTeam.getTeamStats().setsSaves(visitorTeam.getTeamStats().getsSaves() + 1);
            } else {
                System.out.println("Save: None");
            }
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Visitor Batting Stats:%n");
        System.out.printf("%10s %6s %4s %4s %3s %2s %2s %2s %2s %2s %2s %4s %4s %2s %2s %2s %2s %2s %2s" +
                        " %2s %2s %2s %2s %2s", "Name", "AtBats", "Runs", "Hits", "RBI", "1B", "2B", "3B", "HR", "BB",
                "K", "SacF", "SacH", "SB", "CS", "RISPAB", "RISPH", "RISP1B", "RISP2B", "RISP3B", "RISPHR", "RISPRBI",
                "RISPGIDP", "RISPSAC");
        System.out.println();
        for (Batter batter : visitorBatters) {
           // if (batter.getBatterStats().getGameAtBats() > 0 || batter.getBatterStats().getGameWalk() > 0) {
            if (batter.getBatterStats().getGameGamePlayed() > 0) {
                System.out.format("%10s %6s %4s %4s %2s %2s %2s %2s %2s %2s %2s %4s %4s %2s %2s %6s %6s %6s %6s %6s %6s" +
                                "%6s %6s %6s",
                        batter.getNameLast(), batter.getBatterStats().getGameAtBats(),
                        batter.getBatterStats().getGameRuns(), batter.getBatterStats().getGameHits(),
                        batter.getBatterStats().getGameRbi(), batter.getBatterStats().getGameSingle(),
                        batter.getBatterStats().getGameDouble(), batter.getBatterStats().getGameTriple(),
                        batter.getBatterStats().getGameHomeRun(), batter.getBatterStats().getGameWalk(),
                        batter.getBatterStats().getGameStrikeOut(), batter.getBatterStats().getGameSacrificeFly(),
                        batter.getBatterStats().getGameSacrificeHit(), batter.getBatterStats().getGameStolenBases(),
                        batter.getBatterStats().getGameCaughtStealing(), batter.getBatterStats().getGameRispAtBat(),
                        batter.getBatterStats().getGameRispHit(), batter.getBatterStats().getGameRispSingle(),
                        batter.getBatterStats().getGameRispDouble(), batter.getBatterStats().getGameRispTriple(),
                        batter.getBatterStats().getGameRispHomeRun(), batter.getBatterStats().getGameRispRbi(),
                        batter.getBatterStats().getGameRispGidp(), batter.getBatterStats().getGameRispSacrificeFly());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %2s %2s %3s %2s %2s %2s %2s", "Name", "BF", "IPO", "H", "R", "ER", "BB", "K");
        System.out.println();
        for (Pitcher printedPitcher : visitorPitchers) {
            if (printedPitcher.getPitcherStats().getGameBattersFaced() > 0) {
                pitcher.updateDaysRest(printedPitcher, schedule);
                System.out.printf("%10s %2s %2s %4s %2s %2s %2s %2s", printedPitcher.getNameLast(),
                        printedPitcher.getPitcherStats().getGameBattersFaced(),
                        printedPitcher.getPitcherStats().getGameInningsPitchedOuts(),
                        printedPitcher.getPitcherStats().getGameHitsAllowed(),
                        printedPitcher.getPitcherStats().getGameRunsAllowed(),
                        printedPitcher.getPitcherStats().getGameEarnedRunsAllowed(),
                        printedPitcher.getPitcherStats().getGameWalksAllowed(),
                        printedPitcher.getPitcherStats().getGameStrikeOutsAllowed());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Visitor Fielding Stats%n");
        System.out.printf("%10s %7s %2s %2s %2s %2s %2s", "Name", "Assists", "PO", "DP", "E", "SBA", "TO");
        System.out.println();
        for (Fielder fielder : visitorFieldersReserves) {
            if (fielder.getFielderStats().getGameGamePlayed() > 0) {
                System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                        fielder.getFielderStats().getGameAssists(),
                        fielder.getFielderStats().getGamePutOuts(), fielder.getFielderStats().getGameDoublePlay(),
                        fielder.getFielderStats().getGameErrors(), fielder.getFielderStats().getGameRunnersSuccessful(),
                        fielder.getFielderStats().getGameRunnersThrownOut());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("Home Batting Stats:%n");
        System.out.printf("%10s %6s %4s %4s %3s %2s %2s %2s %2s %2s %2s %4s %4s %2s %2s %5s %5s %5s %5s" +
                        " %5s %5s %5s %5s %5s", "Name", "AtBats", "Runs", "Hits", "RBI", "1B", "2B", "3B", "HR", "BB",
                "K", "SacF", "SacH", "SB", "CS", "RISPAB", "RISPH", "RISP1B", "RISP2B", "RISP3B", "RISPHR", "RISPRBI",
                "RISPGIDP", "RISPSAC");
        System.out.println();
        for (Batter batter : homeBatters) {
            if (batter.getBatterStats().getGameGamePlayed() > 0) {
            //if (batter.getBatterStats().getGameAtBats() > 0 || batter.getBatterStats().getGameWalk() > 0) {
                System.out.format("%10s %6s %4s %4s %2s %2s %2s %2s %2s %2s %2s %4s %4s %2s %2s %6s %6s %6s %6s %6s %6s" +
                                "%6s %6s %6s",
                        batter.getNameLast(), batter.getBatterStats().getGameAtBats(),
                        batter.getBatterStats().getGameRuns(), batter.getBatterStats().getGameHits(),
                        batter.getBatterStats().getGameRbi(), batter.getBatterStats().getGameSingle(),
                        batter.getBatterStats().getGameDouble(), batter.getBatterStats().getGameTriple(),
                        batter.getBatterStats().getGameHomeRun(), batter.getBatterStats().getGameWalk(),
                        batter.getBatterStats().getGameStrikeOut(), batter.getBatterStats().getGameSacrificeFly(),
                        batter.getBatterStats().getGameSacrificeHit(), batter.getBatterStats().getGameStolenBases(),
                        batter.getBatterStats().getGameCaughtStealing(), batter.getBatterStats().getGameRispAtBat(),
                        batter.getBatterStats().getGameRispHit(), batter.getBatterStats().getGameRispSingle(),
                        batter.getBatterStats().getGameRispDouble(), batter.getBatterStats().getGameRispTriple(),
                        batter.getBatterStats().getGameRispHomeRun(), batter.getBatterStats().getGameRispRbi(),
                        batter.getBatterStats().getGameRispGidp(), batter.getBatterStats().getGameRispSacrificeFly());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %2s %2s %3s %2s %2s %2s %2s", "Name", "BF", "IPO", "H", "R", "ER", "BB", "K");
        System.out.println();
        for (Pitcher printedHomePitcher : homePitchers) {
            if (printedHomePitcher.getPitcherStats().getGameBattersFaced() > 0) {
                pitcher.updateDaysRest(printedHomePitcher, schedule);
                System.out.printf("%10s %2s %2s %4s %2s %2s %2s %2s", printedHomePitcher.getNameLast(),
                        printedHomePitcher.getPitcherStats().getGameBattersFaced(),
                        printedHomePitcher.getPitcherStats().getGameInningsPitchedOuts(),
                        printedHomePitcher.getPitcherStats().getGameHitsAllowed(),
                        printedHomePitcher.getPitcherStats().getGameRunsAllowed(),
                        printedHomePitcher.getPitcherStats().getGameEarnedRunsAllowed(),
                        printedHomePitcher.getPitcherStats().getGameWalksAllowed(),
                        printedHomePitcher.getPitcherStats().getGameStrikeOutsAllowed());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Home Fielding Stats%n");
        System.out.printf("%10s %7s %2s %2s %2s %2s %2s", "Name", "Assists", "PO", "DP", "E", "SBA", "TO");
        System.out.println();
        for (Fielder fielder : homeFieldersReserves) {
            if (fielder.getFielderStats().getGameGamePlayed() > 0) {
                System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                        fielder.getFielderStats().getGameAssists(),
                        fielder.getFielderStats().getGamePutOuts(), fielder.getFielderStats().getGameDoublePlay(),
                        fielder.getFielderStats().getGameErrors(), fielder.getFielderStats().getGameRunnersSuccessful(),
                        fielder.getFielderStats().getGameRunnersThrownOut());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------");
    }

    void printPitcherStats(Pitcher pitcher) {
        System.out.printf("%s Earned Runs Allowed: %d%n", pitcher.getNameLast(),
                pitcher.getPitcherStats().getGameEarnedRunsAllowed());
        System.out.printf("%s Unearned Runs Allowed: %d%n", pitcher.getNameLast(),
                pitcher.getPitcherStats().getUnearnedRunsAllowed());
        System.out.printf("%s Total Runs Allowed: %d%n", pitcher.getNameLast(),
                pitcher.getPitcherStats().getGameRunsAllowed());
    }
}


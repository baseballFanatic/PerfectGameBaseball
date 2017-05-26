package Baseball;

import java.util.List;
import java.util.Set;

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

    void displayLineUp(Set<Batter> visitorStartingLineup, List<Batter> homeStartingLineup, List<Pitcher> visitorPitchers,
                       List<Pitcher> homePitchers, List<Fielder> visitorFielderStarters, List<Fielder> homeFielderStarters)
    {
        System.out.println();
        System.out.printf("Starting LineUps:%n");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("Visitors:");
        System.out.printf("");
        System.out.printf("%10s %6s %4s %4s %5s %5s %5s %5s %5s %5s %5s %4s %4s %3s %16s", "Name", "AtBats", "Runs", "Hits",
                "RBI", "2B", "3B", "HR", "BB", "K", "SacF", "SacH", "SB", "CS", "Position");
        System.out.println();
        for (Batter batter : visitorStartingLineup) {
            System.out.format("%10s %6s %4s %4s %4s %5s %5s %5s %5s %5s %4s %4s %4s %3s %16s",
                    batter.getNameLast(), batter.getBatterStats().getAtBats(),
                    batter.getBatterStats().getRuns(), batter.getBatterStats().getHits(),
                    batter.getBatterStats().getRbi(),
                    batter.getBatterStats().getDoubles(), batter.getBatterStats().getTriples(),
                    batter.getBatterStats().getHomeRuns(), batter.getBatterStats().getWalks(),
                    batter.getBatterStats().getStrikeOuts(), batter.getBatterStats().getSacrificeFlies(),
                    batter.getBatterStats().getSacrificeHits(), batter.getBatterStats().getStolenBases(),
                    batter.getBatterStats().getCaughtStealing(), batter.getPosition());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %2s %2s %3s %2s %2s %2s %2s", "Name", "BF", "IPO", "H", "R", "ER", "BB", "K");
        System.out.println();
        for (Pitcher printedPitcher : visitorPitchers) {
            System.out.printf("%10s %2s %2s %4s %2s %2s %2s %2s", printedPitcher.getNameLast(),
                    printedPitcher.getPitcherStats().getBattersFaced(),
                    printedPitcher.getPitcherStats().getiPouts(),
                    printedPitcher.getPitcherStats().getHitsAllowed(),
                    printedPitcher.getPitcherStats().getRuns(),
                    printedPitcher.getPitcherStats().getEarnedRuns(),
                    printedPitcher.getPitcherStats().getWalksAllowed(),
                    printedPitcher.getPitcherStats().getStrikeOutsAllowed());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Visitor Fielding Stats%n");
        System.out.printf("%10s %7s %2s %2s %2s %2s %2s", "Name", "Assists", "PO", "DP", "E", "SBA", "TO");
        System.out.println();
        for (Fielder fielder : visitorFielderStarters) {
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
        System.out.printf("%10s %6s %4s %4s %5s %5s %5s %5s %5s %5s %5s %4s %4s %3s %16s", "Name", "AtBats", "Runs", "Hits",
                "RBI", "2B", "3B", "HR", "BB", "K", "SacF", "SacH", "SB", "CS", "Position");
        System.out.println();
        for (Batter batter : homeStartingLineup) {
            System.out.format("%10s %6s %4s %4s %4s %5s %5s %5s %5s %5s %4s %4s %4s %3s %16s",
                    batter.getNameLast(), batter.getBatterStats().getAtBats(),
                    batter.getBatterStats().getRuns(), batter.getBatterStats().getHits(),
                    batter.getBatterStats().getRbi(),
                    batter.getBatterStats().getDoubles(), batter.getBatterStats().getTriples(),
                    batter.getBatterStats().getHomeRuns(), batter.getBatterStats().getWalks(),
                    batter.getBatterStats().getStrikeOuts(), batter.getBatterStats().getSacrificeFlies(),
                    batter.getBatterStats().getSacrificeHits(), batter.getBatterStats().getStolenBases(),
                    batter.getBatterStats().getCaughtStealing(), batter.getPosition());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %2s %2s %3s %2s %2s %2s %2s", "Name", "BF", "IPO", "H", "R", "ER", "BB", "K");
        System.out.println();
        for (Pitcher printedPitcher : homePitchers) {
            System.out.printf("%10s %2s %2s %4s %2s %2s %2s %2s", printedPitcher.getNameLast(),
                    printedPitcher.getPitcherStats().getBattersFaced(),
                    printedPitcher.getPitcherStats().getiPouts(),
                    printedPitcher.getPitcherStats().getHitsAllowed(),
                    printedPitcher.getPitcherStats().getRuns(),
                    printedPitcher.getPitcherStats().getEarnedRuns(),
                    printedPitcher.getPitcherStats().getWalksAllowed(),
                    printedPitcher.getPitcherStats().getStrikeOutsAllowed());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.printf("Home Fielding Stats%n");
        System.out.printf("%10s %7s %2s %2s %2s %2s %2s", "Name", "Assists", "PO", "DP", "E", "SBA", "TO");
        System.out.println();
        for (Fielder fielder : homeFielderStarters) {
            System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                    fielder.getFielderStats().getAssists(),
                    fielder.getFielderStats().getPutOuts(), fielder.getFielderStats().getDoublePlays(),
                    fielder.getFielderStats().getErrors(), fielder.getFielderStats().getStolenBases(),
                    fielder.getFielderStats().getCaughtStealing());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    void endOfGame(List<Batter> visitorBatters, List<Batter> homeBatters, List<Fielder> visitorFielders,
                   List<Fielder> homeFielders, List<Pitcher> visitorPitchers, List<Pitcher> homePitchers,
                   Team visitorTeam, Team homeTeam, Pitcher pitcher) {
        System.out.println();
        System.out.printf("BALLGAME!%n");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        if (homeTeam.getTeamStats().getGameRuns() > visitorTeam.getTeamStats().getGameRuns()) {
            System.out.printf("Winning Pitcher: %s%n", pitcher.getHomeWinningPitcher().getNameLast());
            System.out.printf("Losing Pitcher: %s%n", pitcher.getVisitorLosingPitcher().getNameLast());
            if (pitcher.getHomeSavePitcher() != null) {
                System.out.printf("Save: %s%n", pitcher.getHomeSavePitcher().getNameLast());
            } else {
                System.out.println("Save: None");
            }
        } else {
            System.out.printf("Winning Pitcher: %s%n", pitcher.getVisitorWinningPitcher().getNameLast());
            System.out.printf("Losing Pitcher: %s%n", pitcher.getHomeLosingPitcher().getNameLast());
            if (pitcher.getVisitorSavePitcher() != null) {
                System.out.printf("Save: %s%n", pitcher.getVisitorSavePitcher().getNameLast());
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
            if (batter.getBatterStats().getGameAtBats() > 0 || batter.getBatterStats().getGameWalk() > 0) {
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
        for (Fielder fielder : visitorFielders) {
            System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                    fielder.getFielderStats().getGameAssists(),
                    fielder.getFielderStats().getGamePutOuts(), fielder.getFielderStats().getGameDoublePlay(),
                    fielder.getFielderStats().getGameErrors(), fielder.getFielderStats().getGameRunnersSuccessful(),
                    fielder.getFielderStats().getGameRunnersThrownOut());
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("Home Batting Stats:%n");
        System.out.printf("%10s %6s %4s %4s %3s %2s %2s %2s %2s %2s %2s %4s %4s %2s %2s %5s %5s %5s %5s" +
                        " %5s %5s %5s %5s %5s", "Name", "AtBats", "Runs", "Hits", "RBI", "1B", "2B", "3B", "HR", "BB",
                "K", "SacF", "SacH", "SB", "CS", "RISPAB", "RISPH", "RISP1B", "RISP2B", "RISP3B", "RISPHR", "RISPRBI",
                "RISPGIDP", "RISPSAC");
        System.out.println();
        for (Batter batter : homeBatters) {
            if (batter.getBatterStats().getGameAtBats() > 0 || batter.getBatterStats().getGameWalk() > 0) {
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
        for (Fielder fielder : homeFielders) {
            System.out.printf("%10s %7s %2s %2s %2s %3s %2s", fielder.getNameLast(),
                    fielder.getFielderStats().getGameAssists(),
                    fielder.getFielderStats().getGamePutOuts(), fielder.getFielderStats().getGameDoublePlay(),
                    fielder.getFielderStats().getGameErrors(), fielder.getFielderStats().getGameRunnersSuccessful(),
                    fielder.getFielderStats().getGameRunnersThrownOut());
            System.out.println();
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


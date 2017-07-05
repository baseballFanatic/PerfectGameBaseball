package Baseball;

import java.util.HashMap;
import java.util.List;

import static java.lang.Math.random;

class Bases {
    private Base firstBase = new Base();
    private Base secondBase = new Base();
    private Base thirdBase = new Base();
    private Team team = new Team();
    private BasesOccupied basesOccupied;

    void single(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam, Inning inning,
                BasesOccupied baseState, Fielder currentFielder, HashMap<Integer, Fielder> fielderList, AtBatResult atBatResult,
                Bases bases) {
        // Update batter and pitcher stats for hit.
        batter.getBatterStats().updateBatterStats(batter, atBatResult);
        batter.setPitcherReachedOn(pitcher);
        System.out.printf("%s with a single(%d) off %s.%n", batter.getNameLast(), batter.getBatterStats().getGameSingle(),
                pitcher.getNameLast());
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
        team.getTeamStats().updateTeamHits(inning, visitorTeam, homeTeam);
        GameRbi gameRbi;
        // Check for RBI or other events from the hit and update stats.
        switch (baseState) {
            case BASES_LOADED: {
                // Update stats for third-base runner scoring.
                gameRbi = GameRbi.ONE;
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                System.out.printf("%s scores(%d).%n", bases.getThirdBase().getBatter().getNameLast(), bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);

                // Check to see if any other runners score on the single and update their stats.
                double doesRunnerAdvance = random();
                if (doesRunnerAdvance < .021) {
                    // Runner scores from second but runner going from first to third is thrown out.
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) scores from second.%n", bases.getSecondBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.THIRD_BASE);
                    System.out.printf("%s heads to third.  He's out!%n",
                            bases.getFirstBase().getBatter().getNameLast());
                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                    outs.setOuts(outs.getOuts() + 1);
                    bases.getThirdBase().setOccupied(false);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < .673) {
                    // Runner from second tries to score but is thrown out at home.
                    double doesRunnerAdvanceAgain = random();
                    if (doesRunnerAdvanceAgain < .036) {
                        System.out.printf("%s attempts to score from second.%n", bases.getSecondBase().getBatter().getNameLast());
                        currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.CATCHER);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        System.out.printf("Here's the throw.  He's out!%n");
                        System.out.printf("%s holds at second.%n", bases.getFirstBase().getBatter().getNameLast());
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getThirdBase().setOccupied(false);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                        if (outs.getOuts() == 3) {
                            team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                        }
                    } else if (doesRunnerAdvanceAgain < .347) {
                        // No one else scores.
                        System.out.printf("%s holds at third.%n", bases.getSecondBase().getBatter().getNameLast());
                        System.out.printf("%s moves to second.%n", bases.getFirstBase().getBatter().getNameLast());
                        System.out.println("Bases are loaded!");
                        makeBasesLoaded(batter, bases);
                    } else if (doesRunnerAdvanceAgain < 1) {
                        // Runner at second scores but runner on first base holds at second.
                        pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                        batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                        batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                        bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                        System.out.printf("%s(%d) scores from second on the hit!%n", bases.getSecondBase().getBatter().getNameLast(),
                                bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                        System.out.printf("%s holds at second as %s rounds first.%n", bases.getFirstBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                        bases.getThirdBase().setOccupied(false);
                        team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    }
                } else if (doesRunnerAdvance < .986) {
                    // Runner on second scores and runner on first advances to third.
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s rounds second and slides into third. %s scores(%d)!%n", bases.getFirstBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getNameLast(), bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                    Batter first = bases.getFirstBase().getBatter();
                    bases.getSecondBase().setOccupied(false);
                    bases.getThirdBase().occupy(first);
                    bases.getFirstBase().occupy(batter);
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                } else if (doesRunnerAdvance < 1) {
                    // Runner on second scores as well as runner on first.
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) scores from second.%n", bases.getSecondBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                    System.out.printf("%s(%d) got a great jump on the pitch and scores from first.%n",
                            bases.getFirstBase().getBatter().getNameLast(), bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                    bases.getThirdBase().setOccupied(false);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                }
                break;
            }
            case SECOND_THIRD: {
                // Update stats for runner on third scoring on the single.
                gameRbi = GameRbi.ONE;
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                double doesRunnerAdvance = random();
                // Check to see if anything else happens.
                if (doesRunnerAdvance < .036) {
                    // Runner on second is thrown out at home trying to score on the single.
                    System.out.printf("%s is thrown out at home trying to score from second!%n",
                            bases.getSecondBase().getBatter().getNameLast());
                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                    bases.getThirdBase().setOccupied(false);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                    outs.setOuts(outs.getOuts() + 1);
                    currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.CATCHER);
                    System.out.printf("He's out!%n");

                } else if (doesRunnerAdvance < .347) {
                    // Runner on second stops at third after the single.
                    System.out.printf("%s holds at third.%n", bases.getSecondBase().getBatter().getNameLast());
                    Batter second = bases.getSecondBase().getBatter();
                    bases.getThirdBase().occupy(second);
                    bases.getFirstBase().occupy(batter);
                    bases.getSecondBase().setOccupied(false);
                } else if (doesRunnerAdvance < 1) {
                    // Runner on second scores on the single.
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) scores from second on the single.%n", bases.getSecondBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    bases.getThirdBase().setOccupied(false);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                }
                break;
            }
            case FIRST_THIRD: {
                // Update stats for the runner on third scoring.
                gameRbi = GameRbi.ONE;
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores from third on the single.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                double doesRunnerAdvance = random();
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                if (doesRunnerAdvance < .021) {
                    // Runner on first is thrown out trying to advance to third.
                    System.out.printf("%s is thrown out trying to reach third.%n", bases.getFirstBase().getBatter().getNameLast());
                    outs.setOuts(outs.getOuts() + 1);
                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                    currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.THIRD_BASE);
                    bases.getThirdBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < .673) {
                    // Runner on first holds at second base.
                    System.out.printf("%s holds at second.%n", bases.getFirstBase().getBatter().getNameLast());
                    Batter first = bases.getFirstBase().getBatter();
                    bases.getSecondBase().occupy(first);
                    bases.getFirstBase().occupy(batter);
                    bases.getThirdBase().setOccupied(false);
                } else if (doesRunnerAdvance < .986) {
                    // Runner on first advances to third on the single.
                    System.out.printf("%s slides into third while %s rounds first.%n",
                            bases.getFirstBase().getBatter().getNameLast(), batter.getNameLast());
                    Batter first = bases.getFirstBase().getBatter();
                    bases.getThirdBase().occupy(first);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < 1) {
                    // Runner on first scores on the single.
                    pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) was running on the pitch and slides home for the score.%n",
                            bases.getFirstBase().getBatter().getNameLast(), bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    bases.getThirdBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                }
                break;
            }
            case THIRD_BASE: {
                // Update stats for runner on third scoring.
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores from third on the single.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getFirstBase().occupy(batter);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_FIRST:
                gameRbi = GameRbi.ZERO;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
            {
                // Update stats for other scenarios.
                double doesRunnerAdvance = random();
                if (doesRunnerAdvance < .021) {
                    // Runner on second scores but the runner on first is thrown out at third.
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s scores(%d), %s is thrown out at third.", bases.getSecondBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast());
                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                    outs.setOuts(outs.getOuts() + 1);
                    currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.THIRD_BASE);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                } else if (doesRunnerAdvance < .673) {
                    double doesRunnerScoreAgain = random();
                    if (doesRunnerScoreAgain < .036) {
                        // Runner on second is thrown out at home trying to score.
                        System.out.printf("%s is thrown out at home trying to score on the hit.%n",
                                bases.getSecondBase().getBatter().getNameLast());
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        outs.setOuts(outs.getOuts() + 1);
                        currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.CATCHER);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        if (outs.getOuts() == 3) {
                            team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                        }
                        bases.getFirstBase().occupy(batter);
                    } else if (doesRunnerScoreAgain < .347) {
                        // Runner on second holds at third on the single.
                        System.out.printf("%s holds at third as %s rounds first.%n", bases.getSecondBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        makeBasesLoaded(batter, bases);
                    } else if (doesRunnerScoreAgain < 1) {
                        // Runner at second scores on the single.
                        batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                        batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                        pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                        bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                        System.out.printf("%s(%d) scores from second on the hit.%n", bases.getSecondBase().getBatter().getNameLast(),
                                bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                        team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    }
                } else if (doesRunnerAdvance < .986) {
                    // Runner at second scores on the hit and runner on first advances to third.
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) scores on the hit and %s slides into third.%n", bases.getSecondBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast());
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    Batter first = bases.getFirstBase().getBatter();
                    bases.getThirdBase().occupy(first);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);

                } else if (doesRunnerAdvance < 1) {
                    // Both runners score on the single.
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) got a great jump on the pitch and scores along with %s(%d).%n",
                            bases.getFirstBase().getBatter().getNameLast(), bases.getFirstBase().getBatter().getBatterStats().getGameRuns(),
                            bases.getSecondBase().getBatter().getNameLast(), bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                }
                break;
            }
            case SECOND_BASE: {
                gameRbi = GameRbi.ZERO;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                double doesRunnerAdvance = random();
                if (doesRunnerAdvance < .036) {
                    // Runner on second is thrown out at home trying to score.
                    System.out.printf("%s is thrown out at home trying to score.%n", bases.getSecondBase().getBatter().getNameLast());
                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                    outs.setOuts(outs.getOuts() + 1);
                    currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.CATCHER);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < .347) {
                    // Runner on second holds at third on the single.
                    System.out.printf("%s holds at third while %s rounds first.%n", bases.getSecondBase().getBatter().getNameLast(),
                            batter.getNameLast());
                    Batter second = bases.getSecondBase().getBatter();
                    bases.getThirdBase().occupy(second);
                    bases.getFirstBase().occupy(batter);
                    bases.getSecondBase().setOccupied(false);
                } else if (doesRunnerAdvance < 1) {
                    // Runner on second scores on the single.
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                    pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                    bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) scores on the single.%n", bases.getSecondBase().getBatter().getNameLast(),
                            bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    bases.getSecondBase().setOccupied(false);
                    bases.getFirstBase().occupy(batter);
                }
                break;
            }
            case FIRST_BASE: {
                double doesRunnerAdvance = random();
                if (doesRunnerAdvance < .021) {
                    // Runner on first is thrown out trying to advance to third.
                    System.out.printf("%s is thrown out trying to reach third.%n", bases.getFirstBase().getBatter().getNameLast());
                    currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.THIRD_BASE);
                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                    outs.setOuts(outs.getOuts() + 1);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < .673) {
                    // Runner on first stops at second.
                    System.out.printf("%s holds at second.%n", bases.getFirstBase().getBatter().getNameLast());
                    Batter first = bases.getFirstBase().getBatter();
                    bases.getSecondBase().occupy(first);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < .986) {
                    // Runner on first advances to third.
                    System.out.printf("%s races over to third.%n", bases.getFirstBase().getBatter().getNameLast());
                    Batter first = bases.getFirstBase().getBatter();
                    bases.getThirdBase().occupy(first);
                    bases.getFirstBase().occupy(batter);
                } else if (doesRunnerAdvance < 1) {
                    // Runner on first scores on the single.
                    pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                    bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                    System.out.printf("%s(%d) was running on the pitch and slides home for the score.%n",
                            bases.getFirstBase().getBatter().getNameLast(), bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                    bases.getFirstBase().occupy(batter);
                }
                break;
            }
            case EMPTY: {
                bases.getFirstBase().occupy(batter);
                break;
            }
        }
        new DisplayInfo().printPitcherStats(pitcher);
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    void doubleHit(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam, Inning inning,
                   BasesOccupied baseState, Fielder currentFielder, HashMap<Integer, Fielder> fielderList, AtBatResult atBatResult,
                   Bases bases) {
        batter.getBatterStats().updateBatterStats(batter, atBatResult);
        batter.setPitcherReachedOn(pitcher);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
        team.getTeamStats().updateTeamHits(inning, visitorTeam, homeTeam);
        GameRbi gameRbi;
        switch (baseState) {
            case BASES_LOADED: {
                gameRbi = GameRbi.TWO;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                new BatterStats().checkIfRunnerEarned(bases.getSecondBase(), pitcher);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) and %s(%d) score on the double.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                runnerScoringOnDouble(bases, currentFielder, fielderList, outs, batter,
                        pitcher, inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_THIRD: {
                gameRbi = GameRbi.TWO;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                new BatterStats().checkIfRunnerEarned(bases.getSecondBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) and %s(%d) score on the double.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().occupy(batter);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case FIRST_THIRD: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the double.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                runnerScoringOnDouble(bases, currentFielder, fielderList, outs, batter, pitcher,
                        inning, visitorTeam, homeTeam);
                break;
            }
            case THIRD_BASE: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the double.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                bases.getSecondBase().occupy(batter);
                bases.getThirdBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_FIRST: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the double.%n", bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                new BatterStats().checkIfRunnerEarned(bases.getSecondBase(), pitcher);
                runnerScoringOnDouble(bases, currentFielder, fielderList, outs, batter, pitcher,
                        inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_BASE: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                new BatterStats().checkIfRunnerEarned(bases.getSecondBase(), pitcher);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the double.%n", bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                bases.getFirstBase().setOccupied(false);
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().occupy(batter);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case FIRST_BASE: {
                runnerScoringOnDouble(bases, currentFielder, fielderList, outs, batter, pitcher,
                        inning, visitorTeam, homeTeam);
                break;
            }
            case EMPTY: {
                bases.getFirstBase().setOccupied(false);
                bases.getSecondBase().occupy(batter);
                bases.getThirdBase().setOccupied(false);
                break;
            }
        }
        new DisplayInfo().printPitcherStats(pitcher);
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    void triple(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam, Inning inning,
                BasesOccupied baseState, AtBatResult atBatResult,
                Bases bases) {
        batter.getBatterStats().updateBatterStats(batter, atBatResult);
        batter.setPitcherReachedOn(pitcher);
        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        team.getTeamStats().updateTeamHits(inning, visitorTeam, homeTeam);
        GameRbi gameRbi;
        switch (baseState) {
            case BASES_LOADED: {
                gameRbi = GameRbi.TWO;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 3);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d), %s(%d), %s(%d) all score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameTriple(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().occupy(batter);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_THIRD: {
                gameRbi = GameRbi.TWO;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d) and %s(%d) score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().occupy(batter);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case FIRST_THIRD: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d) and %s(%d) score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().occupy(batter);
                bases.getFirstBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                 break;
            }
            case THIRD_BASE: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d) scores!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                bases.getSecondBase().setOccupied(false);
                bases.getThirdBase().occupy(batter);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_FIRST: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d) and %s(%d) score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().occupy(batter);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_BASE: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d) scores!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                bases.getFirstBase().setOccupied(false);
                bases.getThirdBase().occupy(batter);
                bases.getSecondBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case FIRST_BASE: {
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases on the triple!  %s(%d) scores!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameTriple(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().occupy(batter);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case EMPTY: {
                bases.getFirstBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                bases.getThirdBase().occupy(batter);
                break;
            }
        }
        new DisplayInfo().printPitcherStats(pitcher);
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    void homeRun(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam, Inning inning,
                 BasesOccupied baseState, AtBatResult atBatResult,
                 Bases bases) {
        batter.getBatterStats().updateBatterStats(batter, atBatResult);
        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        pitcher.getPitcherStats().setGameHomeRunsAllowed(pitcher.getPitcherStats().getGameHomeRunsAllowed() + 1);
        pitcher.getPitcherStats().setGameEarnedRunsAllowed(pitcher.getPitcherStats().getGameEarnedRunsAllowed() + 1);
        pitcher.getPitcherStats().setGameRunsAllowed(pitcher.getPitcherStats().getGameRunsAllowed() + 1);
        team.getTeamStats().updateTeamHits(inning, visitorTeam, homeTeam);
        GameRbi gameRbi;
        switch (baseState) {
            case BASES_LOADED: {
                gameRbi = GameRbi.TWO;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 4);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("Grand Slam by %s(%d)!  %s(%d), %s(%d), %s(%d) all score!%n", batter.getNameLast(),
                        batter.getBatterStats().getGameHomeRun(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_THIRD: {
                gameRbi = GameRbi.TWO;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 3);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases with the Home Run!  %s(%d) and %s(%d) score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameHomeRun(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case FIRST_THIRD: {
                gameRbi = GameRbi.ONE;
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 3);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases with the Home Run!  %s(%d) and %s(%d) score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameHomeRun(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case THIRD_BASE: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases with the Home Run!  %s(%d) scores!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameHomeRun(), bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                bases.getSecondBase().setOccupied(false);
                bases.getThirdBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_FIRST: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 3);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases with the Home Run!  %s(%d) and %s(%d) score!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameHomeRun(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_BASE: {
                gameRbi = GameRbi.ONE;
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                batter.getBatterStats().updateBatterStatsRisp(batter, atBatResult, gameRbi);
                pitcher.getPitcherStats().hitRunScores(bases.getSecondBase(), pitcher);
                bases.getSecondBase().getBatter().getBatterStats().setGameRuns(bases.getSecondBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases with the Home Run!  %s(%d) scores!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameHomeRun(), bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameRuns());
                bases.getFirstBase().setOccupied(false);
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case FIRST_BASE: {
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 2);
                pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
                bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) clears the bases with the Home Run!  %s(%d) scores!%n",
                        batter.getNameLast(), batter.getBatterStats().getGameHomeRun(), bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case EMPTY: {
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                System.out.printf("%s(%d) homers!%n", batter.getNameLast(), batter.getBatterStats().getGameHomeRun());
                bases.getFirstBase().setOccupied(false);
                bases.getSecondBase().setOccupied(false);
                bases.getThirdBase().setOccupied(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }

        }
        new DisplayInfo().printPitcherStats(pitcher);
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    void walk(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam, Inning inning,
              BasesOccupied baseState, Bases bases) {
        batter.getBatterStats().setGameWalk(batter.getBatterStats().getGameWalk() + 1);
        batter.setPitcherReachedOn(pitcher);
        pitcher.getPitcherStats().setGameWalksAllowed(pitcher.getPitcherStats().getGameWalksAllowed() + 1);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        System.out.printf("%s(%d) walks %s(%d).%n", pitcher.getNameLast(), pitcher.getPitcherStats().getGameWalksAllowed(),
                batter.getNameLast(), batter.getBatterStats().getGameWalk());
        switch (baseState) {
            case BASES_LOADED: {
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().setGameRispWalk(batter.getBatterStats().getGameRispWalk() + 1);
                batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) comes home on the bases loaded walk.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                makeBasesLoaded(batter, bases);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_THIRD: {
                batter.getBatterStats().setGameRispWalk(batter.getBatterStats().getGameRispWalk() + 1);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case FIRST_THIRD: {
                batter.getBatterStats().setGameRispWalk(batter.getBatterStats().getGameRispWalk() + 1);
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case THIRD_BASE: {
                batter.getBatterStats().setGameRispWalk(batter.getBatterStats().getGameRispWalk() + 1);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case SECOND_FIRST: {
                makeBasesLoaded(batter, bases);
                break;
            }
            case SECOND_BASE: {
                batter.getBatterStats().setGameRispWalk(batter.getBatterStats().getGameRispWalk() + 1);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case FIRST_BASE: {
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case EMPTY: {
                bases.getFirstBase().occupy(batter);
                break;
            }
        }
        new DisplayInfo().printPitcherStats(pitcher);
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    void hitByPitch(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam,
                    Inning inning, BasesOccupied baseState, Bases bases) {
        batter.getBatterStats().setGameHitByPitch(batter.getBatterStats().getGameHitByPitch() + 1);
        batter.setPitcherReachedOn(pitcher);
        pitcher.getPitcherStats().setGameHitByPitch(pitcher.getPitcherStats().getGameHitByPitch() + 1);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        switch (baseState) {
            case BASES_LOADED: {
                batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(batter.getBatterStats().getGameRuns() + 1);
                makeBasesLoaded(batter, bases);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_THIRD: {
                bases.getFirstBase().occupy(batter);
                break;
            }
            case FIRST_THIRD: {
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case THIRD_BASE: {
                bases.getFirstBase().occupy(batter);
                break;
            }
            case SECOND_FIRST: {
                makeBasesLoaded(batter, bases);
                break;
            }
            case SECOND_BASE: {
                bases.getFirstBase().occupy(batter);
                break;
            }
            case FIRST_BASE: {
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().occupy(batter);
                break;
            }
            case EMPTY: {
                bases.getFirstBase().occupy(batter);
                break;
            }
        }
        new DisplayInfo().printPitcherStats(pitcher);
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    void strikeOut(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam,
                   Inning inning, BasesOccupied baseState, Fielder currentFielder, HashMap<Integer, Fielder> fielderList) {
        batter.getBatterStats().setGameStrikeOut(batter.getBatterStats().getGameStrikeOut() + 1);
        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        pitcher.getPitcherStats().setGameStrikeOutsAllowed(pitcher.getPitcherStats().getGameStrikeOutsAllowed() + 1);
        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
        Fielder catcherWithPutOut = currentFielder.getCurrentFielder(InPlayPosition.CATCHER, fielderList);
        catcherWithPutOut.getFielderStats().setGamePutOuts(catcherWithPutOut.getFielderStats().getGamePutOuts() + 1);
        System.out.printf("%s(%d) strikes out %s(%d).%n%s(%d)", pitcher.getNameLast(), pitcher.getPitcherStats().getGameStrikeOutsAllowed(),
                batter.getNameLast(), batter.getBatterStats().getGameStrikeOut(), catcherWithPutOut.getNameLast(),
                catcherWithPutOut.getFielderStats().getGamePutOuts());
        System.out.printf("Outs:  %s%n", outs.getOuts());
        if (outs.getOuts() >= 3) {
            teamLeftOnBase(baseState, inning, visitorTeam, homeTeam);
        }
    }

    void out(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam, Inning inning,
             BasesOccupied baseState, Fielder currentFielder, HashMap<Integer, Fielder> fielderList, InPlayPosition checkFielder,
             Bases bases) {
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);

        if (currentFielder.getPosition().equals(InPlayPosition.LEFT_FIELD) |
                currentFielder.getPosition().equals(InPlayPosition.CENTER_FIELD) |
                currentFielder.getPosition().equals(InPlayPosition.RIGHT_FIELD)) {
            flyOut(currentFielder, outs, baseState, batter, pitcher, fielderList, inning, visitorTeam, homeTeam, bases);
        } else {
            infieldOut(currentFielder, outs, baseState, batter, pitcher, fielderList, checkFielder, inning,
                    visitorTeam, homeTeam, bases);
        }
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    private void makeBasesLoaded(Batter batter, Bases bases) {
        Batter second = bases.getSecondBase().getBatter();
        Batter first = bases.getFirstBase().getBatter();
        bases.getThirdBase().occupy(second);
        bases.getSecondBase().occupy(first);
        bases.getFirstBase().occupy(batter);
    }

    private void makeBasesEmpty(Bases bases) {
        bases.getThirdBase().setOccupied(false);
        bases.getSecondBase().setOccupied(false);
        bases.getFirstBase().setOccupied(false);
    }

    private void setBasesOccupied(BasesOccupied basesOccupied) {
        this.basesOccupied = basesOccupied;
    }

    BasesOccupied checkBases(Bases bases) {
        if (bases.getThirdBase().isOccupied() && bases.getSecondBase().isOccupied() && bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.BASES_LOADED);
        } else if (bases.getThirdBase().isOccupied() && bases.getSecondBase().isOccupied() && !bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.SECOND_THIRD);
        } else if (bases.getThirdBase().isOccupied() && !bases.getSecondBase().isOccupied() && bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.FIRST_THIRD);
        } else if (bases.getThirdBase().isOccupied() && !bases.getSecondBase().isOccupied() && !bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.THIRD_BASE);
        } else if (!bases.getThirdBase().isOccupied() && bases.getSecondBase().isOccupied() && bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.SECOND_FIRST);
        } else if (!bases.getThirdBase().isOccupied() && bases.getSecondBase().isOccupied() && !bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.SECOND_BASE);
        } else if (!bases.getThirdBase().isOccupied() && !bases.getSecondBase().isOccupied() && bases.getFirstBase().isOccupied()) {
            setBasesOccupied(BasesOccupied.FIRST_BASE);
        } else {
            setBasesOccupied(BasesOccupied.EMPTY);
        }
        return basesOccupied;
    }

    boolean checkError(Inning inning, Team visitorTeam, Team homeTeam, Fielder currentFielder) {
        double checkError = random();
        boolean error = false;

        if (currentFielder != null && checkError > currentFielder.getFielderStats().getFieldingPercentage()) {
            error = true;
            if (inning.isTop()) {
                homeTeam.getTeamStats().setGameErrors((homeTeam.getTeamStats().getGameErrors() + 1));
            } else {
                visitorTeam.getTeamStats().setGameErrors(visitorTeam.getTeamStats().getGameErrors() + 1);
            }
        }
        return error;
    }

    void outError(Batter batter, Pitcher pitcher, PitchResult outs, Team visitorTeam, Team homeTeam,
                  Inning inning, BasesOccupied baseState, Fielder currentFielder, HashMap<Integer, Fielder> fielderList,
                  Bases bases) {
        /*
        Scoring rules for errors:  Any batter that reaches base on an error and scores is not an earned run (although
        batter knocking him in will get credit for an rbi,
        any runner that scores due to an error is not an earned run (and batter does NOT get an rbi),
        any runner that scores after an error that would have been the 3rd out is not an earned run (although
        a batter does get an rbi for that run).
         */
        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
        batter.setPitcherReachedOn(pitcher);
        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
        currentFielder.getFielderStats().setGameErrors(currentFielder.getFielderStats().getGameErrors() + 1);
        System.out.printf("%s(%d) makes an error on the play!%n", currentFielder.getNameLast(),
                currentFielder.getFielderStats().getGameErrors());
        switch (baseState) {
            case BASES_LOADED: {
                pitcher.getPitcherStats().setGameUnearnedRunsAllowed(pitcher.getPitcherStats().getGameUnearnedRunsAllowed() + 1);
                pitcher.getPitcherStats().setGameRunsAllowed(pitcher.getPitcherStats().getGameRunsAllowed() + 1);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the play.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                makeBasesLoaded(batter, bases);
                if (outs.getOuts() == 2) {
                    bases.getThirdBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getSecondBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                } else {
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                }
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                break;
            }
            case SECOND_THIRD: {
                pitcher.getPitcherStats().setGameUnearnedRunsAllowed(pitcher.getPitcherStats().getGameUnearnedRunsAllowed() + 1);
                pitcher.getPitcherStats().setGameRunsAllowed(pitcher.getPitcherStats().getGameRunsAllowed() + 1);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the play.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                Batter second = bases.getSecondBase().getBatter();
                bases.getThirdBase().occupy(second);
                bases.getSecondBase().setOccupied(false);
                bases.getFirstBase().occupy(batter);
                if (outs.getOuts() == 2) {
                    bases.getThirdBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                } else {
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                }
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                if (inning.isTop()) {
                    visitorTeam.getTeamStats().setGameRuns((visitorTeam.getTeamStats().getGameRuns() + 1));
                } else {
                    homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                }*/
                break;
            }
            case FIRST_THIRD: {
                pitcher.getPitcherStats().setGameUnearnedRunsAllowed(pitcher.getPitcherStats().getGameUnearnedRunsAllowed() + 1);
                pitcher.getPitcherStats().setGameRunsAllowed(pitcher.getPitcherStats().getGameRunsAllowed() + 1);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the play.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().occupy(batter);
                bases.getThirdBase().setOccupied(false);
                if (outs.getOuts() == 2) {
                    bases.getSecondBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                } else {
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                }
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                if (inning.isTop()) {
                    visitorTeam.getTeamStats().setGameRuns((visitorTeam.getTeamStats().getGameRuns() + 1));
                } else {
                    homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                }*/
                break;
            }
            case THIRD_BASE: {
                pitcher.getPitcherStats().setGameUnearnedRunsAllowed(pitcher.getPitcherStats().getGameUnearnedRunsAllowed() + 1);
                pitcher.getPitcherStats().setGameRunsAllowed(pitcher.getPitcherStats().getGameRunsAllowed() + 1);
                bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                System.out.printf("%s(%d) scores on the play.%n", bases.getThirdBase().getBatter().getNameLast(),
                        bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                bases.getThirdBase().setOccupied(false);
                bases.getFirstBase().occupy(batter);
                bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                if (inning.isTop()) {
                    visitorTeam.getTeamStats().setGameRuns((visitorTeam.getTeamStats().getGameRuns() + 1));
                } else {
                    homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                }*/
                break;
            }
            case SECOND_FIRST: {
                makeBasesLoaded(batter, bases);
                if (outs.getOuts() == 2) {
                    bases.getThirdBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getSecondBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                } else {
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                }
                break;
            }
            case SECOND_BASE: {
                Batter second = bases.getSecondBase().getBatter();
                bases.getFirstBase().occupy(batter);
                bases.getThirdBase().occupy(second);
                bases.getSecondBase().setOccupied(false);
                if (outs.getOuts() == 2) {
                    bases.getThirdBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                } else {
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                }
                break;
            }
            case FIRST_BASE: {
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().occupy(batter);
                if (outs.getOuts() ==2 ) {
                    bases.getSecondBase().getBatter().getBatterStats().setRunEarned(false);
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                } else {
                    bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                }
                break;
            }
            case EMPTY: {
                bases.getFirstBase().occupy(batter);
                bases.getFirstBase().getBatter().getBatterStats().setRunEarned(false);
                break;
            }
        }
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    Fielder determineOutfieldPosition(Fielder currentFielder, HashMap<Integer, Fielder> fielderList) {
        double outfieldPosition = random();
        if (outfieldPosition < .33) {
            currentFielder = currentFielder.getCurrentFielder(InPlayPosition.LEFT_FIELD, fielderList);
        } else if (outfieldPosition < .66) {
            currentFielder = currentFielder.getCurrentFielder(InPlayPosition.CENTER_FIELD, fielderList);
        } else if (outfieldPosition < 1) {
            currentFielder = currentFielder.getCurrentFielder(InPlayPosition.RIGHT_FIELD, fielderList);
        } else {
            currentFielder = currentFielder.getCurrentFielder(InPlayPosition.CENTER_FIELD, fielderList);
        }
        return currentFielder;
    }

    private void runnerScoringOnDouble(Bases bases, Fielder currentFielder,
                                       HashMap<Integer, Fielder> fielderList, PitchResult outs, Batter batter, Pitcher pitcher,
                                       Inning inning, Team visitorTeam, Team homeTeam) {
        double doesRunnerAdvance = random();
        if (doesRunnerAdvance < .031) {
            System.out.printf("%s is thrown out trying to score on the double.%n", bases.getFirstBase().getBatter().getNameLast());
            currentFielder.updateOutfielderAssist(currentFielder, fielderList, InPlayPosition.CATCHER);
            pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
            System.out.printf("Here's the throw.  He's out!");
            outs.setOuts(outs.getOuts() + 1);
            bases.getSecondBase().occupy(batter);
            bases.getFirstBase().setOccupied(false);
            bases.getThirdBase().setOccupied(false);
        } else if (doesRunnerAdvance < .567) {
            System.out.printf("%s holds at third.%n", bases.getFirstBase().getBatter().getNameLast());
            Batter first = bases.getFirstBase().getBatter();
            bases.getThirdBase().occupy(first);
            bases.getSecondBase().occupy(batter);
            bases.getFirstBase().setOccupied(false);
        } else if (doesRunnerAdvance < 1) {
            pitcher.getPitcherStats().hitRunScores(bases.getFirstBase(), pitcher);
            bases.getFirstBase().getBatter().getBatterStats().setGameRuns(bases.getFirstBase().getBatter().getBatterStats().getGameRuns() + 1);
            System.out.printf("%s(%d) scores all the way from first.%n", bases.getFirstBase().getBatter().getNameLast(),
                    bases.getFirstBase().getBatter().getBatterStats().getGameRuns());
            batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
            team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*            if (inning.isTop()) {
                visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
            } else {
                homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
            }*/
            bases.getFirstBase().setOccupied(false);
            bases.getSecondBase().occupy(batter);
            bases.getThirdBase().setOccupied(false);
        }
    }

    private OutfieldDepth determineOutfieldDepth() {
        double randomOutfieldDepth = random();
        OutfieldDepth depth = null;
        if (randomOutfieldDepth < .33) {
            depth = OutfieldDepth.SHORT;
        } else if (randomOutfieldDepth < .66) {
            depth = OutfieldDepth.MEDIUM;
        } else if (randomOutfieldDepth < 1) {
            depth = OutfieldDepth.LONG;
        }
        return depth;
    }


    private boolean doesRunnerTagMedium(Base baseRunner) {
        double randomAdvance = random();
        if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 7) {
            return randomAdvance < .5;
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 6) {
            return randomAdvance < .4;
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 5) {
            return randomAdvance < .3;
        } else
            return baseRunner.getBatter().getBatterStats().getSpeedRating() >= 4 && randomAdvance < .2;
    }

    private boolean doesRunnerTagLong(Base baseRunner) {
        double randomAdvance = random();
        if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 7) {
            return randomAdvance < .8;
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 6) {
            return randomAdvance < .7;
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 5) {
            return randomAdvance < .6;
        } else
            return baseRunner.getBatter().getBatterStats().getSpeedRating() >= 4 && randomAdvance < .5;
    }


    private boolean checkIfRunnerSafeMedium(Base baseRunner) {
        double randomThrowResult = random();
        if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 7) {
            return !(randomThrowResult > .6);
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 6) {
            return !(randomThrowResult > .5);
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 5) {
            return !(randomThrowResult > .4);
        } else {
            return !(randomThrowResult > .3);
        }
    }

    private boolean checkIfRunnerSafeLong(Base baseRunner) {
        double randomThrowResult = random();
        if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 7) {
            return !(randomThrowResult > .9);
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 6) {
            return !(randomThrowResult > .8);
        } else if (baseRunner.getBatter().getBatterStats().getSpeedRating() >= 5) {
            return !(randomThrowResult > .7);
        } else {
            return randomThrowResult <= .6;
        }
    }

    private void flyOut(Fielder currentFielder, PitchResult outs, BasesOccupied baseState, Batter batter,
                        Pitcher pitcher, HashMap<Integer, Fielder> fielderList, Inning inning, Team visitorTeam,
                        Team homeTeam, Bases bases) {
        OutfieldDepth currentDepth = determineOutfieldDepth();
        currentFielder.getFielderStats().setGamePutOuts(currentFielder.getFielderStats().getGamePutOuts() + 1);
        System.out.printf("%s flies out to %s(%d).%n", batter.getNameLast(), currentFielder.getNameLast(),
                currentFielder.getFielderStats().getGamePutOuts());
        if (outs.getOuts() < 2) {
            outs.setOuts(outs.getOuts() + 1);
            switch (currentDepth) {
                case MEDIUM:
                    switch (baseState) {
                        case BASES_LOADED:
                        case FIRST_THIRD:
                        case THIRD_BASE:
                        case SECOND_THIRD: {
                            if (doesRunnerTagMedium(bases.getThirdBase())) {
                                if (checkIfRunnerSafeMedium(bases.getThirdBase())) {
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    batter.getBatterStats().setGameRispSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    new BatterStats().updateSacFlyRbi(batter);
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) tags from third and scores.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                                    bases.getThirdBase().setOccupied(false);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                } else {
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    new FielderStats().updateOutfieldAssist(currentFielder, InPlayPosition.CATCHER, fielderList);
                                    System.out.printf("%s tags from third but is gunned down at home.%n", bases.getThirdBase().getBatter().getNameLast());
                                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                                    outs.setOuts(outs.getOuts() + 1);
                                    bases.getThirdBase().setOccupied(false);
                                    if (outs.getOuts() >= 3) {
                                        BasesOccupied newBaseState = checkBases(bases);
                                        teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    }
                                }
                            } else {
                                System.out.printf("Runners hold.%n");
                            }
                            break;
                        }
                        case SECOND_BASE:
                        case SECOND_FIRST: {
                            batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                            if (doesRunnerTagMedium(bases.getSecondBase())) {
                                if (checkIfRunnerSafeMedium(bases.getSecondBase())) {
                                    System.out.printf("%s tags from second and advances.%n", bases.getSecondBase().getBatter().getNameLast());
                                    batter.getBatterStats().setGameSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameRispSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() - 1);
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                } else {
                                    System.out.printf("%s tags from second but is gunned down at third.%n", bases.getSecondBase().getBatter().getNameLast());
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    new FielderStats().updateOutfieldAssist(currentFielder, InPlayPosition.THIRD_BASE, fielderList);
                                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                                    outs.setOuts(outs.getOuts() + 1);
                                    bases.getSecondBase().setOccupied(false);
                                    if (outs.getOuts() >= 3) {
                                        BasesOccupied newBaseState = checkBases(bases);
                                        teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    }
                                }
                            } else {
                                System.out.printf("Runners hold.%n");
                            }
                            break;
                        }
                        case FIRST_BASE: {
                            if (doesRunnerTagMedium(bases.getFirstBase())) {
                                if (checkIfRunnerSafeMedium(bases.getFirstBase())) {
                                    System.out.printf("%s tags from first and advances.%n", bases.getFirstBase().getBatter().getNameLast());
                                    batter.getBatterStats().setGameSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() - 1);
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().setOccupied(false);
                                } else {
                                    System.out.printf("%s tags from first but is gunned down at second.%n", bases.getFirstBase().getBatter().getNameLast());
                                    new FielderStats().updateOutfieldAssist(currentFielder, InPlayPosition.SECOND_BASE, fielderList);
                                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                                    outs.setOuts(outs.getOuts() + 1);
                                    bases.getFirstBase().setOccupied(false);
                                    if (outs.getOuts() >= 3) {
                                        BasesOccupied newBaseState = checkBases(bases);
                                        teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    }
                                }
                            } else {
                                System.out.printf("Runners hold.%n");
                            }
                            break;
                        }
                        case EMPTY: {
                            makeBasesEmpty(bases);
                            break;
                        }
                    }
                    break;
                case LONG:
                    switch (baseState) {
                        case BASES_LOADED:
                        case FIRST_THIRD:
                        case THIRD_BASE:
                        case SECOND_THIRD: {
                            if (doesRunnerTagLong(bases.getThirdBase())) {
                                if (checkIfRunnerSafeLong(bases.getThirdBase())) {
                                    batter.getBatterStats().setGameRispSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    new BatterStats().updateSacFlyRbi(batter);
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) tags from third and scores.%n",
                                            bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    bases.getThirdBase().setOccupied(false);
                                } else {
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    new FielderStats().updateOutfieldAssist(currentFielder, InPlayPosition.CATCHER, fielderList);
                                    System.out.printf("%s tags from third but is gunned down at home.%n", bases.getThirdBase().getBatter().getNameLast());
                                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                                    outs.setOuts(outs.getOuts() + 1);
                                    bases.getThirdBase().setOccupied(false);
                                    if (outs.getOuts() >= 3) {
                                        BasesOccupied newBaseState = checkBases(bases);
                                        teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    }
                                }
                            } else {
                                System.out.printf("Runners hold.%n");
                            }
                            break;
                        }
                        case SECOND_BASE:
                        case SECOND_FIRST: {
                            if (doesRunnerTagLong(bases.getSecondBase())) {
                                if (checkIfRunnerSafeLong(bases.getSecondBase())) {
                                    System.out.printf("%s tags from second and advances.%n", bases.getSecondBase().getBatter().getNameLast());
                                    batter.getBatterStats().setGameSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameRispSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() - 1);
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                } else {
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    new FielderStats().updateOutfieldAssist(currentFielder, InPlayPosition.THIRD_BASE, fielderList);
                                    System.out.printf("%s tags from second but is gunned down at third.%n", bases.getSecondBase().getBatter().getNameLast());
                                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                                    outs.setOuts(outs.getOuts() + 1);
                                    bases.getSecondBase().setOccupied(false);
                                    if (outs.getOuts() >= 3) {
                                        BasesOccupied newBaseState = checkBases(bases);
                                        teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    }
                                }
                            } else {
                                System.out.printf("Runners hold.%n");
                            }
                            break;
                        }
                        case FIRST_BASE: {
                            if (doesRunnerTagLong(bases.getFirstBase())) {
                                if (checkIfRunnerSafeLong(bases.getFirstBase())) {
                                    System.out.printf("%s tags from first and advances.%n", bases.getFirstBase().getBatter().getNameLast());
                                    batter.getBatterStats().setGameSacrificeFly(batter.getBatterStats().getGameSacrificeFly() + 1);
                                    batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() - 1);
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().setOccupied(false);
                                } else {
                                    new FielderStats().updateOutfieldAssist(currentFielder, InPlayPosition.SECOND_BASE, fielderList);
                                    System.out.printf("%s tags from first but is gunned down at second.%n", bases.getFirstBase().getBatter().getNameLast());
                                    pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                                    outs.setOuts(outs.getOuts() + 1);
                                    bases.getFirstBase().setOccupied(false);
                                    if (outs.getOuts() >= 3) {
                                        BasesOccupied newBaseState = checkBases(bases);
                                        teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    }
                                }
                            } else {
                                System.out.printf("Runners hold.%n");
                            }
                            break;
                        }
                        case EMPTY: {
                            makeBasesEmpty(bases);
                            break;
                        }
                    }
                    break;
                case SHORT:
                    break;
            }
        } else {
            System.out.println("End of inning.");
            outs.setOuts(outs.getOuts() + 1);
            teamLeftOnBase(baseState, inning, visitorTeam, homeTeam);
            makeBasesEmpty(bases);
        }
        new DisplayInfo().printPitcherStats(pitcher);
    }

    private void infieldOut(Fielder currentFielder, PitchResult outs, BasesOccupied baseState, Batter batter,
                            Pitcher pitcher, HashMap<Integer, Fielder> fielderList, InPlayPosition checkFielder, Inning inning,
                            Team visitorTeam, Team homeTeam, Bases bases) {
        double popOrGrounder = random();
        if (popOrGrounder < .464) {
            //This is for ground balls
            if (outs.getOuts() < 2) {
                switch (baseState) {
                    case BASES_LOADED:
                        outs.setOuts(outs.getOuts() + 2);
                        new TeamStats().updateTeamDoublePlays(inning, visitorTeam, homeTeam);
                        batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                        batter.getBatterStats().setGameRispGidp(batter.getBatterStats().getGameRispGidp() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        switch (checkFielder) {
                            case PITCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.PITCHER,
                                        InPlayPosition.CATCHER, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getThirdBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                }
                                break;
                            }
                            case CATCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.CATCHER,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    new BatterStats().checkIfRunnerEarned(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case THIRD_BASE: {
                                if (outs.getOuts() >= 3) {
                                    new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                            InPlayPosition.FIRST_BASE);
                                    bases.getThirdBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                            InPlayPosition.CATCHER);
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().occupy(batter);
                                    bases.getThirdBase().setOccupied(false);
                                }
                                break;
                            }
                            case SHORTSTOP: {
                                new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                        InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case SECOND_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.SECOND_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case FIRST_BASE: {
                                if (outs.getOuts() >= 3) {
                                    new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.FIRST_BASE,
                                            InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                            InPlayPosition.CATCHER);
                                    System.out.printf("%s bounces one to first, he steps on the bag and throws home " +
                                            "who tags %s sliding in from third.%n", batter.getNameLast(), bases.getThirdBase().getBatter().getNameLast());
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                        }
                        break;
                    case SECOND_FIRST: {
                        outs.setOuts(outs.getOuts() + 2);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                        batter.getBatterStats().setGameRispGidp(batter.getBatterStats().getGameRispGidp() + 1);
                        new TeamStats().updateTeamDoublePlays(inning, visitorTeam, homeTeam);
                        switch (checkFielder) {
                            case PITCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.PITCHER,
                                        InPlayPosition.THIRD_BASE, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case CATCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.CATCHER,
                                        InPlayPosition.THIRD_BASE, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case THIRD_BASE: {
                                new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                        InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter first = bases.getFirstBase().getBatter();
                                    bases.getSecondBase().occupy(first);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case SECOND_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.SECOND_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getFirstBase().setOccupied(false);
                                    bases.getSecondBase().setOccupied(false);
                                }
                                break;
                            }
                            case SHORTSTOP: {
                                new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                        InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getFirstBase().setOccupied(false);
                                    bases.getSecondBase().setOccupied(false);
                                }
                                break;
                            }
                            case FIRST_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.FIRST_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);

                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getFirstBase().setOccupied(false);
                                    bases.getSecondBase().setOccupied(false);
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case FIRST_THIRD: {
                        outs.setOuts(outs.getOuts() + 2);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                        batter.getBatterStats().setGameRispGidp(batter.getBatterStats().getGameRispGidp() + 1);
                        new TeamStats().updateTeamDoublePlays(inning, visitorTeam, homeTeam);
                        switch (checkFielder) {
                            case PITCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.PITCHER,
                                        InPlayPosition.SECOND_BASE, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case CATCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.CATCHER,
                                        InPlayPosition.SECOND_BASE, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case THIRD_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.THIRD_BASE,
                                        InPlayPosition.SECOND_BASE, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                } else {
                                    System.out.printf("%s remains at third.%n", bases.getThirdBase().getBatter().getNameLast());
                                    bases.getSecondBase().setOccupied(false);
                                    bases.getFirstBase().setOccupied(false);
                                }
                                break;
                            }
                            case SECOND_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.SECOND_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case SHORTSTOP: {
                                new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                        InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case FIRST_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.FIRST_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);

                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s(%d) scores from third.%n", bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRbi(batter.getBatterStats().getGameRbi() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case FIRST_BASE: {
                        outs.setOuts(outs.getOuts() + 2);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        new TeamStats().updateTeamDoublePlays(inning, visitorTeam, homeTeam);
                        switch (checkFielder) {
                            case PITCHER:
                            {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.PITCHER,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case THIRD_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.THIRD_BASE,
                                        InPlayPosition.SECOND_BASE, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getSecondBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case SECOND_BASE:
                            {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.SECOND_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case CATCHER: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.CATCHER,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case SHORTSTOP: {
                                new FielderStats().updateUnassistedDoublePlay(currentFielder, fielderList, currentFielder.getPosition(),
                                        InPlayPosition.FIRST_BASE);
                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                            case FIRST_BASE: {
                                new FielderStats().updateStandardDoublePlay(currentFielder, fielderList, InPlayPosition.FIRST_BASE,
                                        InPlayPosition.SHORTSTOP, InPlayPosition.FIRST_BASE);

                                if (outs.getOuts() >= 3) {
                                    bases.getFirstBase().setOccupied(false);
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case SECOND_THIRD: {
                        outs.setOuts(outs.getOuts() + 1);
                        switch (checkFielder) {
                            case PITCHER:
                            case THIRD_BASE:
                            case CATCHER: {
                                batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                                Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                        infielderPutOut.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    System.out.printf("%s grounds out %s-%s.%nEnd of Inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    System.out.printf("%s grounds out %s-%s.%nRunners hold.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                }
                                break;
                            }
                            case SECOND_BASE:
                            case FIRST_BASE:
                            case SHORTSTOP: {
                                currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                                Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                        infielderPutOut.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    System.out.printf("%s grounds out %s-%s.%nEnd of Inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s grounds out %s-%s.%n%s(%d) scores from third.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast(),
                                            bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                                    /*if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case SECOND_BASE: {
                        outs.setOuts(outs.getOuts() + 1);
                        batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                        switch (checkFielder) {
                            case CATCHER:
                            case PITCHER:
                            case FIRST_BASE:
                            case SHORTSTOP:
                            case SECOND_BASE: {
                                currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                                Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                        infielderPutOut.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    System.out.printf("%s grounds out %s-%s.%n End of inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    Batter second = bases.getSecondBase().getBatter();
                                    bases.getThirdBase().occupy(second);
                                    bases.getSecondBase().setOccupied(false);
                                    System.out.printf("%s grounds out %s-%s.%n%s moves to third.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast(), bases.getThirdBase().getBatter().getNameLast());
                                }
                                break;
                            }
                            case THIRD_BASE: {
                                currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                                Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                        infielderPutOut.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    System.out.printf("%s grounds out %s-%s.%n End of inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    System.out.printf("%s grounds out %s-%s.%nRunner holds at second.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case THIRD_BASE:
                    {
                        switch (checkFielder) {
                            case PITCHER:
                            case THIRD_BASE:
                            case CATCHER: {
                                batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                                Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                        infielderPutOut.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    System.out.printf("%s grounds out %s-%s.%nEnd of Inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    System.out.printf("%s grounds out %s-%s.%nRunners hold.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                }
                                break;
                            }
                            case SECOND_BASE:
                            case SHORTSTOP: {
                                currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                                Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                        infielderPutOut.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    System.out.printf("%s grounds out %s-%s.%nEnd of Inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    bases.getThirdBase().getBatter().getBatterStats().setGameRuns(bases.getThirdBase().getBatter().getBatterStats().getGameRuns() + 1);
                                    System.out.printf("%s grounds out %s-%s.%n%s(%d) scores from third.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), infielderPutOut.getNameLast(), bases.getThirdBase().getBatter().getNameLast(),
                                            bases.getThirdBase().getBatter().getBatterStats().getGameRuns());
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
                                    bases.getThirdBase().setOccupied(false);
                                }
                                break;
                            }
                            case FIRST_BASE:
                            {
                                currentFielder.getFielderStats().setGamePutOuts(currentFielder.getFielderStats().getGamePutOuts() + 1);
                                System.out.printf("Assist: None%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                        currentFielder.getFielderStats().getGamePutOuts());
                                if (outs.getOuts() >= 3) {
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    System.out.printf("%s grounds out %s unassisted.%nEnd of Inning.%n", batter.getNameLast(),
                                            currentFielder.getNameLast());
                                    BasesOccupied newBaseState = checkBases(bases);
                                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                                    makeBasesEmpty(bases);
                                } else {
                                    System.out.printf("%s grounds out %s unassisted.%n%s scores from third.%n", batter.getNameLast(),
                                            currentFielder.getNameLast(), bases.getThirdBase().getBatter().getNameLast());
                                    batter.getBatterStats().setGameRispAtBat(batter.getBatterStats().getGameRispAtBat() + 1);
                                    batter.getBatterStats().setGameRispRbi(batter.getBatterStats().getGameRispRbi() + 1);
                                    pitcher.getPitcherStats().outRunScored(bases.getThirdBase(), pitcher);
                                    team.getTeamStats().updateTeamRuns(inning, visitorTeam, homeTeam);
/*                                    if (inning.isTop()) {
                                        visitorTeam.getTeamStats().setGameRuns(visitorTeam.getTeamStats().getGameRuns() + 1);
                                    } else {
                                        homeTeam.getTeamStats().setGameRuns(homeTeam.getTeamStats().getGameRuns() + 1);
                                    }*/
                                    makeBasesEmpty(bases);
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case EMPTY: {
                        outs.setOuts(outs.getOuts() + 1);
                        if (currentFielder.getPosition().equals(InPlayPosition.FIRST_BASE)) {
                            currentFielder.getFielderStats().setGamePutOuts(currentFielder.getFielderStats().getGamePutOuts() + 1);
                            System.out.printf("%s grounds out %s unassisted(%d).%n", batter.getNameLast(),
                                    currentFielder.getNameLast(), currentFielder.getFielderStats().getGamePutOuts());
                        } else {
                            currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                            Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                            infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                            System.out.printf("%s grounds out %s-%s.%n", batter.getNameLast(),
                                    currentFielder.getNameLast(), infielderPutOut.getNameLast());
                            System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                                    currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                                    infielderPutOut.getFielderStats().getGamePutOuts());
                        }
                        break;
                    }
                }
            } else {
                outs.setOuts(outs.getOuts() + 1);
                if (currentFielder.getPosition().equals(InPlayPosition.FIRST_BASE)) {
                    currentFielder.getFielderStats().setGamePutOuts(currentFielder.getFielderStats().getGamePutOuts() + 1);
                    System.out.printf("%s grounds out %s unassisted(%d).%nEnd of Inning", batter.getNameLast(),
                            currentFielder.getNameLast(), currentFielder.getFielderStats().getGamePutOuts());
                    BasesOccupied newBaseState = checkBases(bases);
                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                } else {
                    currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
                    Fielder infielderPutOut = currentFielder.getCurrentFielder(InPlayPosition.FIRST_BASE, fielderList);
                    infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                    System.out.printf("%s grounds out %s-%s.%nEnd of Inning.%n", batter.getNameLast(),
                            currentFielder.getNameLast(), infielderPutOut.getNameLast());
                    System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%n", currentFielder.getNameLast(),
                            currentFielder.getFielderStats().getGameAssists(), infielderPutOut.getNameLast(),
                            infielderPutOut.getFielderStats().getGamePutOuts());
                    BasesOccupied newBaseState = checkBases(bases);
                    teamLeftOnBase(newBaseState, inning, visitorTeam, homeTeam);
                }
                makeBasesEmpty(bases);
            }
        } else {
            outs.setOuts(outs.getOuts() + 1);
            currentFielder.getFielderStats().setGamePutOuts(currentFielder.getFielderStats().getGamePutOuts() + 1);
            if (outs.getOuts() == 3) {
                teamLeftOnBase(baseState, inning, visitorTeam, homeTeam);
            }
            System.out.printf("%s pops out to %s(%d).%n", batter.getNameLast(), currentFielder.getNameLast(),
                    currentFielder.getFielderStats().getGamePutOuts());
        }
        new DisplayInfo().printPitcherStats(pitcher);
    }

    Base getFirstBase() {
        return firstBase;
    }

    public void setFirstBase(Base firstBase) {
        this.firstBase = firstBase;
    }

    Base getSecondBase() {
        return secondBase;
    }

    public void setSecondBase(Base secondBase) {
        this.secondBase = secondBase;
    }

    Base getThirdBase() {
        return thirdBase;
    }

    public void setThirdBase(Base thirdBase) {
        this.thirdBase = thirdBase;
    }

    void teamLeftOnBase(BasesOccupied baseState, Inning inning, Team visitorTeam, Team homeTeam) {
        switch (baseState) {
            case BASES_LOADED: {
                if (inning.isTop()) {
                    visitorTeam.getTeamStats().setGameLeftOnBase(visitorTeam.getTeamStats().getGameLeftOnBase() + 3);
                } else {
                    homeTeam.getTeamStats().setGameLeftOnBase(homeTeam.getTeamStats().getGameLeftOnBase() + 3);
                }
                break;
            }
            case SECOND_FIRST:
            case SECOND_THIRD:
            case FIRST_THIRD: {
                if (inning.isTop()) {
                    visitorTeam.getTeamStats().setGameLeftOnBase(visitorTeam.getTeamStats().getGameLeftOnBase() + 2);
                } else {
                    homeTeam.getTeamStats().setGameLeftOnBase(homeTeam.getTeamStats().getGameLeftOnBase() + 2);
                }
                break;
            }
            case FIRST_BASE:
            case SECOND_BASE:
            case THIRD_BASE: {
                if (inning.isTop()) {
                    visitorTeam.getTeamStats().setGameLeftOnBase(visitorTeam.getTeamStats().getGameLeftOnBase() + 1);
                } else {
                    homeTeam.getTeamStats().setGameLeftOnBase(homeTeam.getTeamStats().getGameLeftOnBase() + 1);
                }
                break;
            }
            case EMPTY: {
                break;
            }
        }
    }

    void resetBaseRunners(Bases bases) {
        if (bases.getFirstBase().getBatter() != null) {
            bases.getFirstBase().getBatter().getBatterStats().setRunEarned(true);
        }
        if (bases.getSecondBase().getBatter() != null) {
            bases.getSecondBase().getBatter().getBatterStats().setRunEarned(true);
        }
        if (bases.getThirdBase().getBatter() != null) {
            bases.getThirdBase().getBatter().getBatterStats().setRunEarned(true);
        }
    }
}



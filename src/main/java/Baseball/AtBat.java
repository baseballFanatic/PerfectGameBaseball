package Baseball;

import java.util.HashMap;

import static Baseball.InPlayPosition.*;
import static java.lang.Math.abs;
import static java.lang.Math.random;

class AtBat {

    private boolean pitchOut;


    AtBat() {
    }

    void batterUp(Batter batter, Pitcher pitcher, League league, PitchResult pitchResult, Bases bases,
                  LineUp lineUp, Team visitorTeam, Team homeTeam,
                  HashMap<Integer, Fielder> fielderList, Inning inning, HashMap<Integer, Batter> visitorBatters, HashMap<Integer, Batter> homeBatters) {

        Team team = new Team();

        Fielder fielder = new Fielder();
        BasesOccupied baseState = bases.checkBases(bases);
        new DisplayInfo().preAtBatInfo(bases, pitchResult);

        if (checkPitchOut(bases, baseState))
        {
            setPitchOut(true);
        }

        if (checkSteal(baseState, bases, pitcher, visitorTeam, homeTeam, inning)) {
            if (stealResult(baseState, bases, pitchOut)) {
                safeSteal(baseState, bases, fielderList, fielder, pitchResult);
            } else {
                outSteal(baseState, bases, fielderList, fielder, pitchResult, inning, visitorTeam, homeTeam, pitcher);
            }
        }
        baseState = bases.checkBases(bases);

        if (inning.getInning() > 7 && (abs(visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRuns())
                < 3)) {
            if (checkBunt(baseState, pitchResult, inning, lineUp, visitorTeam, homeTeam)) {
                buntResult(batter, pitcher, fielderList, pitchResult, bases, baseState);
                if (inning.isTop()) {
                    lineUp.setVisitorBattingNumber(lineUp.getVisitorBattingNumber() + 1);
                    if (lineUp.getVisitorBattingNumber() == 10) {
                        lineUp.setVisitorBattingNumber(1);
                    }
                    batter = visitorBatters.get(lineUp.getVisitorBattingNumber());
                } else {
                    lineUp.setHomeBattingNumber(lineUp.getHomeBattingNumber() + 1);
                    if (lineUp.getHomeBattingNumber() == 10) {
                        lineUp.setHomeBattingNumber(1);
                    }
                    batter = homeBatters.get(lineUp.getHomeBattingNumber());
                }
            }
        }

        baseState = bases.checkBases(bases);

        if (pitchResult.getOuts() < 3) {

            pitchResult.swing(batter, pitcher, league, pitchOut);

            AtBatResult ab = pitchResult.getPitchResult();

            InPlayPosition checkFielder = ballInPlayPosition();

            new DisplayInfo().batterUp(pitcher, batter, ab);


            //TODO: Need to add in pinch hit check/resolution, reliever check/resolution.

            Fielder currentFielder = fielder.getCurrentFielder(checkFielder, fielderList);

            checkResult(ab, batter, bases, pitcher, pitchResult, visitorTeam, homeTeam, inning, team, baseState,
                    currentFielder, fielderList, checkFielder);
        }
    }

    private boolean checkBunt(BasesOccupied baseState, PitchResult outs, Inning inning, LineUp lineUp,
                              Team visitorTeam, Team homeTeam) {
        switch (baseState) {
            case EMPTY:
            case BASES_LOADED:
            case THIRD_BASE:
            case SECOND_THIRD:
            case FIRST_THIRD: {
                return false;
            }
            case FIRST_BASE:
            case SECOND_BASE:
            case SECOND_FIRST: {
                if (outs.getOuts() < 2 && abs(visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRuns())
                        < 3) {
                    if (inning.isTop()) {
                        int order = lineUp.getVisitorBattingNumber() + 1;
                        return order > 7;
                    } else {
                        int order = lineUp.getHomeBattingNumber() + 1;
                        return order > 7;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private void buntResult(Batter batter, Pitcher pitcher, HashMap<Integer, Fielder> fielderList,
                            PitchResult outs, Bases bases, BasesOccupied baseState) {
        double randomBuntResult = random();
        Fielder currentFielder = new Fielder();
        Fielder buntFielder = currentFielder.getBuntFielder(fielderList);
        switch (baseState) {
            case SECOND_FIRST: {
                if (batter.getBatterStats().getOnBasePercentage() < .250) {
                    if (randomBuntResult < .136) {
                        System.out.printf("%s attempts to bunt.%n%s throws to third! Runner is out.  Failed bunt.%n",
                                batter.getNameLast(), buntFielder.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder thirdBase = currentFielder.getCurrentFielder(THIRD_BASE, fielderList);
                        thirdBase.getFielderStats().setGamePutOuts(thirdBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                thirdBase.getNameLast(), thirdBase.getFielderStats().getGamePutOuts());
                        outs.setOuts(outs.getOuts() + 1);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                    } else if (randomBuntResult < .864) {
                        System.out.printf("%s lays down a perfect bunt.%n%s advances to third, %s out at first.%n",
                                batter.getNameLast(), bases.getFirstBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        batter.getBatterStats().setGameSacrificeHit(batter.getBatterStats().getGameSacrificeHit() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder firstBase = currentFielder.getCurrentFielder(FIRST_BASE, fielderList);
                        firstBase.getFielderStats().setGamePutOuts(firstBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                firstBase.getNameLast(), firstBase.getFielderStats().getGamePutOuts());
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getFirstBase().setOccupied(false);
                    } else if (randomBuntResult < 1) {
                        System.out.printf("%s attempts to sacrifice.%n%s throws too late to second!%n%s beats the throw!" +
                                "at first", batter.getNameLast(), buntFielder.getNameLast(), batter.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                    }
                } else {
                    if (randomBuntResult < .178) {
                        System.out.printf("%s attempts to bunt.%n%s throws to second! Runner is out.  Failed bunt.%n",
                                batter.getNameLast(), buntFielder.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder secondBase = currentFielder.getCurrentFielder(SECOND_BASE, fielderList);
                        secondBase.getFielderStats().setGamePutOuts(secondBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                secondBase.getNameLast(), secondBase.getFielderStats().getGamePutOuts());
                        outs.setOuts(outs.getOuts() + 1);
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        bases.getFirstBase().occupy(batter);
                        bases.getSecondBase().setOccupied(false);
                    } else if (randomBuntResult < .894) {
                        System.out.printf("%s lays down a perfect bunt.%n%s advances to second, %s out at first.%n",
                                batter.getNameLast(), bases.getFirstBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        batter.getBatterStats().setGameSacrificeHit(batter.getBatterStats().getGameSacrificeHit() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder firstBase = currentFielder.getCurrentFielder(FIRST_BASE, fielderList);
                        firstBase.getFielderStats().setGamePutOuts(firstBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                firstBase.getNameLast(), firstBase.getFielderStats().getGamePutOuts());
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getFirstBase().setOccupied(false);
                    } else if (randomBuntResult < 1) {
                        System.out.printf("%s attempts to sacrifice.%n%s throws too late to second!%n%s beats the throw" +
                                "at first", batter.getNameLast(), buntFielder.getNameLast(), batter.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                    }
                }
                break;
            }
            case SECOND_BASE: {
                if (batter.getBatterStats().getOnBasePercentage() < .250) {
                    if (randomBuntResult < .136) {
                        System.out.printf("%s attempts to bunt.%n%s throws to third! Runner is out.  Failed bunt.%n",
                                batter.getNameLast(), buntFielder.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder thirdBase= currentFielder.getCurrentFielder(THIRD_BASE, fielderList);
                        thirdBase.getFielderStats().setGamePutOuts(thirdBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                thirdBase.getNameLast(), thirdBase.getFielderStats().getGamePutOuts());
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getSecondBase().setOccupied(false);
                        bases.getFirstBase().occupy(batter);
                    } else if (randomBuntResult < .864) {
                        System.out.printf("%s lays down a perfect bunt.%n%s advances to third, %s out at first.%n",
                                batter.getNameLast(), bases.getSecondBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        batter.getBatterStats().setGameSacrificeHit(batter.getBatterStats().getGameSacrificeHit() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder firstBase = currentFielder.getCurrentFielder(FIRST_BASE, fielderList);
                        firstBase.getFielderStats().setGamePutOuts(firstBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                firstBase.getNameLast(), firstBase.getFielderStats().getGamePutOuts());
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getFirstBase().setOccupied(false);
                        bases.getSecondBase().setOccupied(false);
                    } else if (randomBuntResult < 1) {
                        System.out.printf("%s attempts to sacrifice.%n%s throws too late to third!%n%s beats the throw!" +
                                "at first", batter.getNameLast(), buntFielder.getNameLast(), batter.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        bases.getFirstBase().occupy(batter);
                        bases.getSecondBase().setOccupied(false);
                    }
                } else {
                    if (randomBuntResult < .178) {
                        System.out.printf("%s attempts to bunt.%n%s throws to third! Runner is out.  Failed bunt.%n",
                                batter.getNameLast(), buntFielder.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder thirdBase = currentFielder.getCurrentFielder(THIRD_BASE, fielderList);
                        thirdBase.getFielderStats().setGamePutOuts(thirdBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                thirdBase.getNameLast(), thirdBase.getFielderStats().getGamePutOuts());
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getSecondBase().setOccupied(false);
                        bases.getFirstBase().occupy(batter);
                    } else if (randomBuntResult < .894) {
                        System.out.printf("%s lays down a perfect bunt.%n%s advances to third, %s out at first.%n",
                                batter.getNameLast(), bases.getSecondBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        batter.getBatterStats().setGameSacrificeHit(batter.getBatterStats().getGameSacrificeHit() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder firstBase = currentFielder.getCurrentFielder(FIRST_BASE, fielderList);
                        firstBase.getFielderStats().setGamePutOuts(firstBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                firstBase.getNameLast(), firstBase.getFielderStats().getGamePutOuts());
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getFirstBase().setOccupied(false);
                        bases.getSecondBase().setOccupied(false);
                    } else if (randomBuntResult < 1) {
                        System.out.printf("%s attempts to sacrifice.%n%s throws too late to third!%n%s beats the throw" +
                                "at first", batter.getNameLast(), buntFielder.getNameLast(), batter.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
                        Batter second = bases.getSecondBase().getBatter();
                        bases.getThirdBase().occupy(second);
                        bases.getFirstBase().occupy(batter);
                        bases.getSecondBase().setOccupied(false);
                    }
                }
                break;
            }
            case FIRST_BASE: {
                if (batter.getBatterStats().getOnBasePercentage() < .250) {
                    if (randomBuntResult < .136) {
                        System.out.printf("%s attempts to bunt.%n%s throws to second! Runner is out.  Failed bunt.%n",
                                batter.getNameLast(), buntFielder.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder secondBase = currentFielder.getCurrentFielder(SECOND_BASE, fielderList);
                        secondBase.getFielderStats().setGamePutOuts(secondBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                secondBase.getNameLast(), secondBase.getFielderStats().getGamePutOuts());
                        outs.setOuts(outs.getOuts() + 1);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                    } else if (randomBuntResult < .864) {
                        System.out.printf("%s lays down a perfect bunt.%n%s advances to second, %s out at first.%n",
                                batter.getNameLast(), bases.getFirstBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        batter.getBatterStats().setGameSacrificeHit(batter.getBatterStats().getGameSacrificeHit() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder firstBase = currentFielder.getCurrentFielder(FIRST_BASE, fielderList);
                        firstBase.getFielderStats().setGamePutOuts(firstBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                firstBase.getNameLast(), firstBase.getFielderStats().getGamePutOuts());
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getFirstBase().setOccupied(false);
                    } else if (randomBuntResult < 1) {
                        System.out.printf("%s attempts to sacrifice.%n%s throws too late to second!%n%s beats the throw " +
                                "at first", batter.getNameLast(), buntFielder.getNameLast(), batter.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                    }
                } else {
                    if (randomBuntResult < .178) {
                        System.out.printf("%s attempts to bunt.%n%s throws to second! Runner is out.  Failed bunt.%n",
                                batter.getNameLast(), buntFielder.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder secondBase = currentFielder.getCurrentFielder(SECOND_BASE, fielderList);
                        secondBase.getFielderStats().setGamePutOuts(secondBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                secondBase.getNameLast(), secondBase.getFielderStats().getGamePutOuts());
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getSecondBase().setOccupied(false);
                        bases.getFirstBase().occupy(batter);
                    } else if (randomBuntResult < .894) {
                        System.out.printf("%s lays down a perfect bunt.%n%s advances to second, %s out at first.%n",
                                batter.getNameLast(), bases.getFirstBase().getBatter().getNameLast(),
                                batter.getNameLast());
                        batter.getBatterStats().setGameSacrificeHit(batter.getBatterStats().getGameSacrificeHit() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
                        buntFielder.getFielderStats().setGameAssists(buntFielder.getFielderStats().getGameAssists() + 1);
                        Fielder firstBase = currentFielder.getCurrentFielder(FIRST_BASE, fielderList);
                        firstBase.getFielderStats().setGamePutOuts(firstBase.getFielderStats().getGamePutOuts() + 1);
                        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)", buntFielder.getNameLast(), buntFielder.getFielderStats().getGameAssists(),
                                firstBase.getNameLast(), firstBase.getFielderStats().getGamePutOuts());
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        outs.setOuts(outs.getOuts() + 1);
                        bases.getFirstBase().setOccupied(false);
                    } else if (randomBuntResult < 1) {
                        System.out.printf("%s attempts to sacrifice.%n%s throws too late to second!%n%s beats the throw" +
                                "at first", batter.getNameLast(), buntFielder.getNameLast(), batter.getNameLast());
                        batter.setPitcherReachedOn(pitcher);
                        batter.getBatterStats().setGameAtBats(batter.getBatterStats().getGameAtBats() + 1);
                        batter.getBatterStats().setGameHits(batter.getBatterStats().getGameHits() + 1);
                        pitcher.getPitcherStats().setGameBattersFaced(pitcher.getPitcherStats().getGameBattersFaced() + 1);
                        pitcher.getPitcherStats().setGameHitsAllowed(pitcher.getPitcherStats().getGameHitsAllowed() + 1);
                        Batter first = bases.getFirstBase().getBatter();
                        bases.getSecondBase().occupy(first);
                        bases.getFirstBase().occupy(batter);
                    }
                }
                break;
            }
        }
    }

    private void safeSteal(BasesOccupied baseState, Bases bases, HashMap<Integer, Fielder> fielderList, Fielder fielder,
                           PitchResult outs) {
        switch (baseState) {
            case FIRST_BASE:
            case FIRST_THIRD: {
                bases.getFirstBase().getBatter().getBatterStats().setGameStolenBases(bases.getFirstBase().getBatter().getBatterStats().getGameStolenBases() + 1);
                System.out.printf("%s tries to steal second!  He's safe(%d)!%n", bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameStolenBases());
                Fielder catcher = fielder.getCurrentFielder(CATCHER, fielderList);
                catcher.getFielderStats().setGameRunnersSuccessful(catcher.getFielderStats().getGameRunnersSuccessful() + 1);
                System.out.printf("Runner successful against %s(%d).%n", catcher.getNameFirst(), catcher.getFielderStats().getGameRunnersSuccessful());
                Batter first = bases.getFirstBase().getBatter();
                bases.getSecondBase().occupy(first);
                bases.getFirstBase().setOccupied(false);
                break;
            }
            case SECOND_BASE:
            case SECOND_FIRST: {
                bases.getSecondBase().getBatter().getBatterStats().setGameStolenBases(bases.getSecondBase().getBatter().getBatterStats().getGameStolenBases() + 1);
                System.out.printf("%s tries to steal third.  He's safe(%d)!%n", bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameStolenBases());
                Fielder catcher = fielder.getCurrentFielder(CATCHER, fielderList);
                catcher.getFielderStats().setGameRunnersSuccessful(catcher.getFielderStats().getGameRunnersSuccessful() + 1);
                System.out.printf("Runner successful against %s(%d).%n", catcher.getNameFirst(), catcher.getFielderStats().getGameRunnersSuccessful());
                Batter second = bases.getSecondBase().getBatter();
                bases.getThirdBase().occupy(second);
                bases.getSecondBase().setOccupied(false);
                break;
            }
        }
        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    private void outSteal(BasesOccupied baseState, Bases bases, HashMap<Integer, Fielder> fielderList, Fielder fielder, PitchResult outs,
                          Inning inning, Team visitorTeam, Team homeTeam, Pitcher pitcher) {
        outs.setOuts(outs.getOuts() + 1);
        pitcher.getPitcherStats().setGameInningsPitchedOuts(pitcher.getPitcherStats().getGameInningsPitchedOuts() + 1);
        switch (baseState) {
            case FIRST_BASE:
            case FIRST_THIRD: {
                bases.getFirstBase().getBatter().getBatterStats().setGameCaughtStealing(bases.getFirstBase().getBatter().getBatterStats().getGameCaughtStealing() + 1);
                System.out.printf("%s attempts to steal second.  He's out(%d)!%n", bases.getFirstBase().getBatter().getNameLast(),
                        bases.getFirstBase().getBatter().getBatterStats().getGameCaughtStealing());
                Fielder catcher = fielder.getCurrentFielder(CATCHER, fielderList);
                catcher.getFielderStats().setGameRunnersThrownOut(catcher.getFielderStats().getGameRunnersThrownOut() + 1);
                Fielder infielderPutOut = fielder.getCurrentFielder(SECOND_BASE, fielderList);
                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                System.out.printf("Catcher caught stealing: %s(%d)%nPut Out: %s(%d)", catcher.getNameLast(), catcher.getFielderStats().getGameRunnersThrownOut(),
                        infielderPutOut.getNameLast(), infielderPutOut.getFielderStats().getGamePutOuts());
                bases.getFirstBase().setOccupied(false);
                if (outs.getOuts() == 3) {
                    baseState = bases.checkBases(bases);
                    bases.teamLeftOnBase(baseState, inning, visitorTeam, homeTeam);
                }
                break;
            }
            case SECOND_BASE:
            case SECOND_FIRST: {
                bases.getSecondBase().getBatter().getBatterStats().setGameCaughtStealing(bases.getSecondBase().getBatter().getBatterStats().getGameCaughtStealing() + 1);
                System.out.printf("%s attempts to steal third.  He's out(%d)!%n", bases.getSecondBase().getBatter().getNameLast(),
                        bases.getSecondBase().getBatter().getBatterStats().getGameCaughtStealing());
                Fielder catcher = fielder.getCurrentFielder(CATCHER, fielderList);
                catcher.getFielderStats().setGameRunnersThrownOut(catcher.getFielderStats().getGameRunnersThrownOut() + 1);
                Fielder infielderPutOut = fielder.getCurrentFielder(THIRD_BASE, fielderList);
                infielderPutOut.getFielderStats().setGamePutOuts(infielderPutOut.getFielderStats().getGamePutOuts() + 1);
                System.out.printf("Catcher caught stealing: %s(%d)%nPut Out: %s(%d)", catcher.getNameLast(), catcher.getFielderStats().getGameRunnersThrownOut(),
                        infielderPutOut.getNameLast(), infielderPutOut.getFielderStats().getGamePutOuts());
                bases.getSecondBase().setOccupied(false);
                if (outs.getOuts() == 3) {
                    baseState = bases.checkBases(bases);
                    bases.teamLeftOnBase(baseState, inning, visitorTeam, homeTeam);
                }
                break;
            }
        }

        new DisplayInfo().atBatInfo(bases.getFirstBase(), bases.getSecondBase(), bases.getThirdBase(), outs);
    }

    private void checkResult(AtBatResult ab, Batter batter, Bases bases, Pitcher pitcher, PitchResult pitchResult,
                             Team visitorTeam, Team homeTeam, Inning inning, Team team, BasesOccupied baseState,
                             Fielder currentFielder, HashMap<Integer, Fielder> fielderList, InPlayPosition checkFielder) {
        switch (ab) {
            case OUT:
                if (bases.checkError(inning, visitorTeam, homeTeam, currentFielder)) {
                    bases.outError(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, currentFielder,
                            fielderList, bases);
                } else {
                    bases.out(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, currentFielder,
                            fielderList, checkFielder, bases);
                }
                break;
            case SINGLE:
                batter.setPitcherReachedOn(pitcher);
                bases.single(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, currentFielder,
                        fielderList, ab, bases);
                break;
            case DOUBLE:
                batter.setPitcherReachedOn(pitcher);
                bases.doubleHit(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, currentFielder,
                        fielderList, ab, bases);
                break;
            case TRIPLE:
                batter.setPitcherReachedOn(pitcher);
                bases.triple(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState,
                        ab, bases);
                break;
            case HOME_RUN:
                batter.setPitcherReachedOn(pitcher);
                bases.homeRun(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, ab, bases);
                break;
            case WALK:
                batter.setPitcherReachedOn(pitcher);
                bases.walk(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, bases);
                break;
            case HIT_BY_PITCH:
                batter.setPitcherReachedOn(pitcher);
                bases.hitByPitch(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState, bases);
                break;
            case STRIKE_OUT:
                bases.strikeOut(batter, pitcher, pitchResult, visitorTeam, homeTeam, inning, baseState,
                        currentFielder, fielderList);
                break;
        }
    }

    private InPlayPosition ballInPlayPosition() {
        double randomPosition = random();
        InPlayPosition position = null;

        if (randomPosition > .9577) {
            position = PITCHER;
        } else if (randomPosition > .9154) {
            position = CATCHER;
        } else if (randomPosition > .8222) {
            position = FIRST_BASE;
        } else if (randomPosition > .5807) {
            position = SECOND_BASE;
        } else if (randomPosition > .4578) {
            position = THIRD_BASE;
        } else if (randomPosition > .2546) {
            position = SHORTSTOP;
        } else if (randomPosition > .1784) {
            position = LEFT_FIELD;
        } else if (randomPosition > .0768) {
            position = CENTER_FIELD;
        } else if (randomPosition >= 0) {
            position = RIGHT_FIELD;
        } else {
            System.out.printf("%s was the value.", position);
        }
        return position;
    }

    private boolean checkSteal(BasesOccupied baseState, Bases bases, Pitcher pitcher, Team visitorTeam, Team homeTeam,
                               Inning inning) {
        switch (baseState) {
            case EMPTY:
            case BASES_LOADED:
            case SECOND_THIRD:
            case THIRD_BASE: {
                return false;
            }
            case FIRST_THIRD:
            case FIRST_BASE: {
                if (bases.getFirstBase().getBatter().getPosition().equals(InPlayPosition.PITCHER)) {
                    return false;
                } else {
                    // Runners steal 2nd 60% less on lefties than righties
                    if (pitcher.getPitchingArm().equals("L")) {
                        double randomStealPercentage = random();
                        if (randomStealPercentage < (bases.getFirstBase().getBatter().getBatterStats().getStolenBaseAttemptPercentage() *.6)
                                && Math.abs(visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRunsAllowed()) < 5
                                && inning.getInning() < 9)
                        {
                            return true;
                        }
                    } else {
                        double randomStealPercentage = random();
                        if (randomStealPercentage < bases.getFirstBase().getBatter().getBatterStats().getStolenBaseAttemptPercentage()
                                && Math.abs(visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRunsAllowed()) < 5
                                && inning.getInning() < 9)
                        {
                            return true;
                        }
                    }
                    return false;
                }
            }
            case SECOND_FIRST:
            case SECOND_BASE: {
                if (bases.getSecondBase().getBatter().getPosition().equals(InPlayPosition.PITCHER)) {
                    return false;
                } else {
                    // Runners steal 3rd 60% less than 2nd base.
                    double randomStealPercentage = random();
                    if ((randomStealPercentage < bases.getSecondBase().getBatter().getBatterStats().getStolenBaseAttemptPercentage() *.6)
                            && Math.abs(visitorTeam.getTeamStats().getGameRuns() - homeTeam.getTeamStats().getGameRunsAllowed()) < 5
                            && inning.getInning() < 9)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkPitchOut(Bases bases, BasesOccupied baseState) {
        double randomPitchOut = random();
        switch (baseState)
        {
            case EMPTY:
            case BASES_LOADED:
            case SECOND_THIRD:
            case FIRST_THIRD:
            case SECOND_FIRST:
            case THIRD_BASE:
            case SECOND_BASE:
                return false;
            case FIRST_BASE:
            {
                if (randomPitchOut < .35 && bases.getFirstBase().getBatter().getBatterStats().getSpeedRating() >= 9) {
                    System.out.println("Pitch out!");
                    return true;
                } else if (randomPitchOut < .30 && bases.getFirstBase().getBatter().getBatterStats().getSpeedRating() >= 8) {
                    System.out.println("Pitch out!");
                    return true;
                } else if (randomPitchOut < .25 && bases.getFirstBase().getBatter().getBatterStats().getSpeedRating() >= 6 )
                {
                    System.out.println("Pitch out!");
                    return true;
                } else if (randomPitchOut < .15 && bases.getFirstBase().getBatter().getBatterStats().getSpeedRating() >= 5)
                {
                    System.out.println("Pitch out!");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean stealResult(BasesOccupied baseState, Bases bases, boolean pitchOut) {
        double randomStealSuccess = random();
        switch (baseState) {
            case FIRST_THIRD:
            case FIRST_BASE: {
                if (pitchOut)
                {
                    if (bases.getFirstBase().getBatter().getBatterStats().getStolenBaseSuccess() < .5)
                    {
                        return .16 > randomStealSuccess;
                    } else if (bases.getFirstBase().getBatter().getBatterStats().getStolenBaseSuccess() < .6)
                    {
                        return .22 > randomStealSuccess;
                    } else if (bases.getFirstBase().getBatter().getBatterStats().getStolenBaseSuccess() < .7)
                    {
                        return .32 > randomStealSuccess;
                    } else if (bases.getFirstBase().getBatter().getBatterStats().getStolenBaseSuccess() < .8)
                    {
                        return .46 > randomStealSuccess;
                    } else if (bases.getFirstBase().getBatter().getBatterStats().getStolenBaseSuccess() < .9)
                    {
                        return .70 > randomStealSuccess;
                    } else return .90 > randomStealSuccess;
                }
                    return bases.getFirstBase().getBatter().getBatterStats().getStolenBaseAttemptSuccessPercentage() > randomStealSuccess;
            }
            case SECOND_FIRST:
            case SECOND_BASE: {
                return (bases.getSecondBase().getBatter().getBatterStats().getStolenBaseAttemptSuccessPercentage()) > randomStealSuccess;
            }
        }
        return false;
    }

    public boolean isPitchOut() {
        return pitchOut;
    }

    private void setPitchOut(boolean pitchOut) {
        this.pitchOut = pitchOut;
    }
}


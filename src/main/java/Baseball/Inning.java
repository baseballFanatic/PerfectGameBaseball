package Baseball;

import java.util.HashMap;
import java.util.List;

class Inning {
    private int inning;
    private boolean top = true;

    Inning() {
    }

    void startInning(League league, HashMap<Integer, Batter> visitorBatters, HashMap<Integer, Batter> homeBatters,
                     Team visitorTeam, Team homeTeam, Inning inning, HashMap<Integer, Fielder> visitorFielders,
                     HashMap<Integer, Fielder> homeFielders, LineUp lineUp,
                     List<Pitcher> visitorPitchers, List<Pitcher> homePitchers, boolean gameOver,
                     Pitcher pitcher, List<Integer> visitorLineScore, List<Integer> homeLineScore,
                     List<Batter> visitorBattersReserves, List<Batter> homeBattersReserves,
                     List<Fielder> visitorFielderReserves, List<Fielder> homeFielderReserves) {
        Batter batter = new Batter();
        Fielder fielder = new Fielder();
        Batter currentBatter;
        Pitcher currentPitcher;
        PitchResult pitchResult = new PitchResult();
        AtBat atBat = new AtBat();
        Bases bases = new Bases();

        if (inning.isTop()) {
            currentPitcher = pitcher.getHomePitcher();
        } else {
            currentPitcher = pitcher.getVisitorPitcher();
        }
        new DisplayInfo().inningStart(top, inning);

        do {
            if (inning.isTop()) {
                pitcher.determineWinnerAndLoser(pitcher, inning, visitorTeam, homeTeam);
                currentBatter = batter.getBatter(inning, lineUp, visitorBatters);
                  // Check to see if home pitcher needs to be relieved
                if (currentPitcher.needReliever(currentPitcher, inning, visitorTeam, homeTeam, homePitchers)) {
                    currentPitcher = currentPitcher.getReliever(homePitchers);
                    if (currentPitcher != null) {
                        batter.removePitcherFromBatters(homeBatters, pitcher.getHomePitcher());
                        fielder.removePitcherFromFielders(homeFielders, pitcher.getHomePitcher());
                        currentPitcher.setBattingOrder(pitcher.getHomePitcher().getBattingOrder());
                        pitcher.setHomePitcher(currentPitcher);
                        batter.addNewPitcherToBatters(homeBattersReserves, pitcher.getHomePitcher(), homeBatters);
                        fielder.addPitcherToFielders(homeFielderReserves, currentPitcher, homeFielders);
                        pitcher.setPitcherSave(pitcher, inning, visitorTeam, homeTeam);
                    } else {
                        currentPitcher = pitcher.getHomePitcher();
                    }
                }
                //TODO Add in actually removing batter and adding pinch hitter
                if (currentBatter.needPinchHitter(inning, visitorTeam, homeTeam, currentBatter, visitorPitchers,
                        homePitchers))
                {

                    if (currentBatter.getPosition().equals(InPlayPosition.PITCHER))
                    {
                        System.out.println("Need to look for a reliever");
                        if (pitcher.isRelieverAvailable(visitorTeam, visitorPitchers))
                        {
                            System.out.println("Would pinch hit for the pitcher and a reliever is available.");
                        }

                    } else
                    {
                        if (fielder.isFielderAvailable(visitorFielderReserves, currentBatter))
                        {
                            System.out.println("There is a fielder available to pinch hit.");
                            fielder.removeFielderFromFielders(visitorFielders, currentBatter);
                            batter.removeBatterFromBatter(visitorBatters, currentBatter, inning);
                            Fielder pinchHitFielder = fielder.getPinchHitterFielder(visitorFielderReserves, currentBatter);
                            fielder.addFielderToFielderStarters(visitorFielders, pinchHitFielder, currentBatter, inning);
                            Batter pinchHitter = batter.getPinchHitterBatter(pinchHitFielder, visitorBattersReserves);
                            batter.addBatterToBatterStarters(visitorBatters, pinchHitter);
                            currentBatter = batter.getBatter(inning, lineUp, visitorBatters);
                        }
                    }
                }
                atBat.batterUp(currentBatter, currentPitcher, league, pitchResult, bases, lineUp,
                        visitorTeam, homeTeam, homeFielders, inning, visitorBatters, homeBatters);
                lineUp.setVisitorBattingNumber(lineUp.getVisitorBattingNumber()+ 1);
                if (lineUp.getVisitorBattingNumber() == 10) {
                    lineUp.setVisitorBattingNumber(1);
                }
            } else {
                currentBatter = batter.getBatter(inning, lineUp, homeBatters);
                // Check to see if visitor pitcher needs to be relieved
                if (currentPitcher.needReliever(currentPitcher, inning, visitorTeam, homeTeam, visitorPitchers)) {
                    currentPitcher = currentPitcher.getReliever(visitorPitchers);
                    if (currentPitcher != null) {
                        batter.removePitcherFromBatters(visitorBatters, pitcher.getVisitorPitcher());
                        fielder.removePitcherFromFielders(visitorFielders, pitcher.getVisitorPitcher());
                        currentPitcher.setBattingOrder(pitcher.getVisitorPitcher().getBattingOrder());
                        pitcher.setVisitorPitcher(currentPitcher);
                        batter.addNewPitcherToBatters(visitorBattersReserves, pitcher.getVisitorPitcher(), visitorBatters);
                        fielder.addPitcherToFielders(visitorFielderReserves, currentPitcher, visitorFielders);
                        pitcher.setPitcherSave(pitcher, inning, visitorTeam, homeTeam);
                    } else {
                        currentPitcher = pitcher.getVisitorPitcher();
                    }
                }
                if (currentBatter.needPinchHitter(inning, visitorTeam, homeTeam, currentBatter, visitorPitchers,
                        homePitchers))
                {
                    if (currentBatter.getPosition().equals(InPlayPosition.PITCHER))
                    {
                        System.out.println("Need to look for a reliever");
                        if (pitcher.isRelieverAvailable(homeTeam, homePitchers))
                        {
                            System.out.println("Would pinch hit for the pitcher and a reliever is available.");
                        }

                    } else
                    {
                        if (fielder.isFielderAvailable(homeFielderReserves, currentBatter))
                        {
                            System.out.println("There is a fielder available to pinch hit.");
                            fielder.removeFielderFromFielders(homeFielders, currentBatter);
                            batter.removeBatterFromBatter(homeBatters, currentBatter, inning);
                            Fielder pinchHitFielder = fielder.getPinchHitterFielder(homeFielderReserves, currentBatter);
                            fielder.addFielderToFielderStarters(homeFielders, pinchHitFielder, currentBatter, inning);
                            Batter pinchHitter = batter.getPinchHitterBatter(pinchHitFielder, homeBattersReserves);
                            batter.addBatterToBatterStarters(homeBatters, pinchHitter);
                            currentBatter = batter.getBatter(inning, lineUp, homeBatters);
                        }
                    }
                }
                atBat.batterUp(currentBatter, currentPitcher, league, pitchResult, bases, lineUp,
                        visitorTeam, homeTeam, visitorFielders, inning, visitorBatters, homeBatters);
                lineUp.setHomeBattingNumber(lineUp.getHomeBattingNumber() + 1);
                if (checkWalkOffWin(inning, homeTeam, visitorTeam, pitcher)) {
                    break;
                }
                if (lineUp.getHomeBattingNumber() == 10) {
                    lineUp.setHomeBattingNumber(1);
                }
            }

            //TODO: Look at using ternary operator for top/bottom of inning to switch between.

        } while (pitchResult.getOuts() < 3);
        if (inning.isTop())
        {
            visitorLineScore.add(visitorTeam.getTeamStats().getInningRuns());
            visitorTeam.getTeamStats().setInningRuns(0);
        } else
        {
            homeLineScore.add(homeTeam.getTeamStats().getInningRuns());
            homeTeam.getTeamStats().setInningRuns(0);
        }
        bases.resetBaseRunners(bases);
    }

    int getInning() {
        return inning;
    }

    void setInning(int inning) {
        this.inning = inning;
    }

    boolean isTop() {
        return top;
    }

    void setTop(boolean top) {
        this.top = top;
    }

    private boolean checkWalkOffWin(Inning inning, Team homeTeam, Team visitorTeam, Pitcher pitcher) {
        if (inning.getInning() >= 9 && homeTeam.getTeamStats().getGameRuns() >
                visitorTeam.getTeamStats().getGameRuns()) {
            System.out.println("Ballgame!");
            pitcher.setHomeWinningPitcher(pitcher.getHomePitcher());
            pitcher.setVisitorLosingPitcher(pitcher.getVisitorPitcher());
            return true;
        }
        return false;
    }
}



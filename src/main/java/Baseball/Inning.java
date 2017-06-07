package Baseball;

import java.util.List;

class Inning {
    private int inning;
    private boolean top = true;

    Inning() {
    }

    void startInning(League league, List<Batter> visitorBatters, List<Batter> homeBatters,
                     Team visitorTeam, Team homeTeam, Inning inning, List<Fielder> visitorFielders,
                     List<Fielder> homeFielders, LineUp lineUp,
                     List<Pitcher> visitorPitchers, List<Pitcher> homePitchers, boolean gameOver,
                     Pitcher pitcher, List<Integer> visitorLineScore, List<Integer> homeLineScore) {
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
                //TODO: Lineup needs to be changed to actually read from the batting Order and not just
                //TODO: pulling the index value
                currentBatter = visitorBatters.get(lineUp.getVisitorBattingNumber());
                // Check to see if home pitcher needs to be relieved
                if (currentPitcher.needReliever(currentPitcher, inning, visitorTeam, homeTeam, homePitchers)) {
                    currentPitcher = currentPitcher.getReliever(homePitchers);
                    if (currentPitcher != null) {
                        pitcher.setHomePitcher(currentPitcher);
                        pitcher.setPitcherSave(pitcher, inning, visitorTeam, homeTeam);
                    } else {
                        currentPitcher = pitcher.getHomePitcher();
                    }
                }
                if (currentBatter.needPinchHitter(inning, visitorTeam, homeTeam, currentBatter))
                {
                    System.out.println("Would pinch hit here.");
                }
                atBat.batterUp(currentBatter, currentPitcher, league, pitchResult, bases, lineUp,
                        visitorTeam, homeTeam, homeFielders, inning, visitorBatters, homeBatters);
                lineUp.setVisitorBattingNumber(lineUp.getVisitorBattingNumber()+ 1);
                if (lineUp.getVisitorBattingNumber() == 9) {
                    lineUp.setVisitorBattingNumber(0);
                }
            } else {
                currentBatter = homeBatters.get(lineUp.getHomeBattingNumber());
                // Check to see if visitor pitcher needs to be relieved
                if (currentPitcher.needReliever(currentPitcher, inning, visitorTeam, homeTeam, visitorPitchers)) {
                    currentPitcher = currentPitcher.getReliever(visitorPitchers);
                    if (currentPitcher != null) {
                        pitcher.setVisitorPitcher(currentPitcher);
                        pitcher.setPitcherSave(pitcher, inning, visitorTeam, homeTeam);
                    } else {
                        currentPitcher = pitcher.getVisitorPitcher();
                    }
                }
                atBat.batterUp(currentBatter, currentPitcher, league, pitchResult, bases, lineUp,
                        visitorTeam, homeTeam, visitorFielders, inning, visitorBatters, homeBatters);
                lineUp.setHomeBattingNumber(lineUp.getHomeBattingNumber() + 1);
                if (checkWalkOffWin(inning, homeTeam, visitorTeam, gameOver)) {
                    break;
                }
                if (lineUp.getHomeBattingNumber() == 9) {
                    lineUp.setHomeBattingNumber(0);
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

    private boolean checkWalkOffWin(Inning inning, Team homeTeam, Team visitorTeam, boolean gameOver) {
        if (inning.getInning() >= 9 && homeTeam.getTeamStats().getGameRuns() >
                visitorTeam.getTeamStats().getGameRuns()) {
            System.out.println("Ballgame!");
            return true;
        }
        return false;
    }
}



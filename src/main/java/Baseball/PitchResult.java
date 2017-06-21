package Baseball;

import static java.lang.Math.random;

class PitchResult {
    private double adjustment = 1.0;
    private double check = 0.0;
    private AtBatResult pitchResult;
    private int outs;


    public PitchResult() {
    }

    public void swing(Batter batter, Pitcher pitcher, League league, boolean pitchOut) {
        double xw = 0;
        double x1 = (batter.getBatterStats().getProbabilitySingle() * pitcher.getPitcherStats().getProbabilitySingle())
                / league.getLeagueStats().getSinglePercentage();
        double y1 = x1 / (x1 + (1 - batter.getBatterStats().getProbabilitySingle()) * (1 -
                pitcher.getPitcherStats().getProbabilitySingle())) /
                (1 - league.getLeagueStats().getSinglePercentage());
        double x2 = (batter.getBatterStats().getProbabilityDouble() * pitcher.getPitcherStats().getProbabilityDouble())
                / league.getLeagueStats().getDoublePercentage();
        double y2 = x2 / (x2 + (1 - batter.getBatterStats().getProbabilityDouble()) *
                (1 - pitcher.getPitcherStats().getProbabilityDouble())) /
                (1 - league.getLeagueStats().getDoublePercentage());
        double x3 = (batter.getBatterStats().getProbabilityTriple() * pitcher.getPitcherStats().getProbabilityTriple())
                / league.getLeagueStats().getTriplePercentage();
        double y3 = x3 / (x3 + (1 - batter.getBatterStats().getProbabilityTriple()) *
                (1 - pitcher.getPitcherStats().getProbabilityTriple())) /
                (1 - league.getLeagueStats().getTriplePercentage());
        double x4 = (batter.getBatterStats().getProbabilityHomeRun() * pitcher.getPitcherStats().getProbabilityHomeRun())
                / league.getLeagueStats().getHomeRunPercentage();
        double y4 = x4 / (x4 + (1 - batter.getBatterStats().getProbabilityHomeRun()) *
                (1 - pitcher.getPitcherStats().getProbabilityHomeRun())) /
                (1 - league.getLeagueStats().getHomeRunPercentage());
        if (pitchOut)
        {
            xw = ((batter.getBatterStats().getProbabilityWalk() * 1.67) * pitcher.getPitcherStats().getProbabilityWalk())
                    / league.getLeagueStats().getWalkPercentage();
        } else {
            xw = (batter.getBatterStats().getProbabilityWalk() * pitcher.getPitcherStats().getProbabilityWalk())
                    / league.getLeagueStats().getWalkPercentage();
        }

        double yw = xw / (xw + ((1 - batter.getBatterStats().getProbabilityWalk() *
                (1 - pitcher.getPitcherStats().getProbabilityWalk())) /
                (1 - league.getLeagueStats().getWalkPercentage())));

        double combinedStrikeOutPercentage = (batter.getBatterStats().getProbabilityStrikeOut() *
                pitcher.getPitcherStats().getProbabilityStrikeOut()) / league.getLeagueStats().getStrikeOutPercentage();
        double strikeOut = (combinedStrikeOutPercentage + ((1 - batter.getBatterStats().getProbabilityStrikeOut()) *
                (1 - pitcher.getPitcherStats().getProbabilityStrikeOut())) /
                (1 - league.getLeagueStats().getWalkPercentage()));
        double probabilityStrikeOut = combinedStrikeOutPercentage / strikeOut;

        double rightLeftAdjustment = 0.0;
        this.adjustment = this.adjustment + rightLeftAdjustment;
        double changedAdjustment = 1 - this.adjustment;

        double bp1 = yw;
        double bp2 = bp1 + pitcher.getPitcherStats().getProbabilityHitBatter();
        double bp3 = bp2 + (y1 * (1 - (league.getLeagueStats().getSinglePercentage() *
                changedAdjustment)));
        double bp4 = bp3 + (y2 * (1 - (league.getLeagueStats().getDoublePercentage() *
                changedAdjustment)));
        double bp5 = bp4 + (y3 * (1 - (league.getLeagueStats().getTriplePercentage() *
                changedAdjustment)));
        double bp6 = bp5 + (y4 * (1 - (league.getLeagueStats().getHomeRunPercentage() *
                changedAdjustment)));
        double bp7 = bp6 + probabilityStrikeOut;

        double random = random();

        if (random > bp7) {
            setPitchResult(AtBatResult.OUT);
        } else if (random > bp6) {
            setPitchResult(AtBatResult.STRIKE_OUT);
            setOuts(getOuts() + 1);
        } else if (random > bp5) {
            setPitchResult(AtBatResult.HOME_RUN);
        } else if (random > bp4) {
            setPitchResult(AtBatResult.TRIPLE);
        } else if (random > bp3) {
            setPitchResult(AtBatResult.DOUBLE);
        } else if (random > bp2) {
            setPitchResult(AtBatResult.SINGLE);
        } else if (random > bp1) {
            setPitchResult(AtBatResult.HIT_BY_PITCH);
        } else {
            setPitchResult(AtBatResult.WALK);
        }
    }

    public AtBatResult getPitchResult() {
        return pitchResult;
    }

    private void setPitchResult(AtBatResult pitchResult) {
        this.pitchResult = pitchResult;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }
}

package Baseball;

class Season {
    private float leagueProbWalk, leagueProbSingle, leagueProbDouble, leagueProbTriple, leagueProbHomeRun, leagueProbStrikeOut;

    public Season(float leagueProbWalk, float leagueProbSingle, float leagueProbDouble, float leagueProbTriple, float leagueProbHomeRun, float leagueProbStrikeOut) {
        this.leagueProbWalk = leagueProbWalk;
        this.leagueProbSingle = leagueProbSingle;
        this.leagueProbDouble = leagueProbDouble;
        this.leagueProbTriple = leagueProbTriple;
        this.leagueProbHomeRun = leagueProbHomeRun;
        this.leagueProbStrikeOut = leagueProbStrikeOut;
    }

    public float getLeagueProbWalk() {
        return leagueProbWalk;
    }

    public void setLeagueProbWalk(float leagueProbWalk) {
        this.leagueProbWalk = leagueProbWalk;
    }

    public float getLeagueProbSingle() {
        return leagueProbSingle;
    }

    public void setLeagueProbSingle(float leagueProbSingle) {
        this.leagueProbSingle = leagueProbSingle;
    }

    public float getLeagueProbDouble() {
        return leagueProbDouble;
    }

    public void setLeagueProbDouble(float leagueProbDouble) {
        this.leagueProbDouble = leagueProbDouble;
    }

    public float getLeagueProbTriple() {
        return leagueProbTriple;
    }

    public void setLeagueProbTriple(float leagueProbTriple) {
        this.leagueProbTriple = leagueProbTriple;
    }

    public float getLeagueProbHomeRun() {
        return leagueProbHomeRun;
    }

    public void setLeagueProbHomeRun(float leagueProbHomeRun) {
        this.leagueProbHomeRun = leagueProbHomeRun;
    }

    public float getLeagueProbStrikeOut() {
        return leagueProbStrikeOut;
    }

    public void setLeagueProbStrikeOut(float leagueProbStrikeOut) {
        this.leagueProbStrikeOut = leagueProbStrikeOut;
    }
}

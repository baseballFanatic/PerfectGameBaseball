package Baseball;


import java.util.HashMap;

class FielderStats {
    private int gameErrors, gameAssists, gamePutOuts, gameDoublePlay, gameRunnersThrownOut, gameRunnersSuccessful,
    gamesPlayed, gamesStarted, inningOuts, putOuts, assists, errors, doublePlays, passedBalls, stolenBases,
    caughtStealing, zoneRating, wildPitches, gameGamePlayed;
    private double fieldingPercentage;

    FielderStats() {
    }

    public int getGameGamePlayed() {
        return gameGamePlayed;
    }

    public void setGameGamePlayed(int gameGamePlayed) {
        this.gameGamePlayed = gameGamePlayed;
    }

    public int getWildPitches() {
        return wildPitches;
    }

    public void setWildPitches(int wildPitches) {
        this.wildPitches = wildPitches;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(int gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public int getInningOuts() {
        return inningOuts;
    }

    public void setInningOuts(int inningOuts) {
        this.inningOuts = inningOuts;
    }

    public int getPutOuts() {
        return putOuts;
    }

    public void setPutOuts(int putOuts) {
        this.putOuts = putOuts;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getDoublePlays() {
        return doublePlays;
    }

    public void setDoublePlays(int doublePlays) {
        this.doublePlays = doublePlays;
    }

    public int getPassedBalls() {
        return passedBalls;
    }

    public void setPassedBalls(int passedBalls) {
        this.passedBalls = passedBalls;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(int stolenBases) {
        this.stolenBases = stolenBases;
    }

    public int getCaughtStealing() {
        return caughtStealing;
    }

    public void setCaughtStealing(int caughtStealing) {
        this.caughtStealing = caughtStealing;
    }

    public int getZoneRating() {
        return zoneRating;
    }

    public void setZoneRating(int zoneRating) {
        this.zoneRating = zoneRating;
    }

    int getGameRunnersThrownOut() {
        return gameRunnersThrownOut;
    }

    void setGameRunnersThrownOut(int gameRunnersThrownOut) {
        this.gameRunnersThrownOut = gameRunnersThrownOut;
    }

    int getGameRunnersSuccessful() {
        return gameRunnersSuccessful;
    }

    void setGameRunnersSuccessful(int gameRunnersSuccessful) {
        this.gameRunnersSuccessful = gameRunnersSuccessful;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    int getGameErrors() {
        return gameErrors;
    }

    void setGameErrors(int gameErrors) {
        this.gameErrors = gameErrors;
    }

    double getFieldingPercentage() {
        return fieldingPercentage;
    }

    void setFieldingPercentage(double fieldingPercentage) {
        this.fieldingPercentage = fieldingPercentage;
    }

    int getGameAssists() {
        return gameAssists;
    }

    void setGameAssists(int gameAssists) {
        this.gameAssists = gameAssists;
    }

    int getGamePutOuts() {
        return gamePutOuts;
    }

    void setGamePutOuts(int gamePutOuts) {
        this.gamePutOuts = gamePutOuts;
    }

    int getGameDoublePlay() {
        return gameDoublePlay;
    }

    private void setGameDoublePlay(int gameDoublePlay) {
        this.gameDoublePlay = gameDoublePlay;
    }

    void updateStandardDoublePlay(Fielder currentFielder, HashMap<Integer, Fielder> fielderList, InPlayPosition positionStart,
                                  InPlayPosition positionMiddle, InPlayPosition positionEnd) {
        Fielder infielderDoublePlayStart = currentFielder.getCurrentFielder(positionStart, fielderList);
        infielderDoublePlayStart.getFielderStats().setGameDoublePlay(infielderDoublePlayStart.getFielderStats().getGameDoublePlay() + 1);
        infielderDoublePlayStart.getFielderStats().setGameAssists(infielderDoublePlayStart.getFielderStats().getGameAssists() + 1);
        Fielder infielderDoublePlayMiddle = currentFielder.getCurrentFielder(positionMiddle, fielderList);
        infielderDoublePlayMiddle.getFielderStats().setGameDoublePlay(infielderDoublePlayMiddle.getFielderStats().getGameDoublePlay() + 1);
        infielderDoublePlayMiddle.getFielderStats().setGameAssists(infielderDoublePlayMiddle.getFielderStats().getGameAssists() + 1);
        infielderDoublePlayMiddle.getFielderStats().setGamePutOuts(infielderDoublePlayMiddle.getFielderStats().getGamePutOuts() + 1);
        Fielder infielderDoublePlayEnd = currentFielder.getCurrentFielder(positionEnd, fielderList);
        infielderDoublePlayEnd.getFielderStats().setGameDoublePlay(infielderDoublePlayEnd.getFielderStats().getGameDoublePlay() + 1);
        infielderDoublePlayEnd.getFielderStats().setGamePutOuts(infielderDoublePlayEnd.getFielderStats().getGamePutOuts() + 1);
        System.out.printf("Batter hits into a double play %s-%s-%s.%n",
                currentFielder.getNameLast(), infielderDoublePlayMiddle.getNameLast(), infielderDoublePlayEnd.getNameLast());
        System.out.printf("Assist: %s(%d)%nAssist: %s(%d)%nPut Out: %s(%d)%nPut Out: %s(%d)", infielderDoublePlayStart.getNameLast(),
                infielderDoublePlayStart.getFielderStats().getGameAssists(), infielderDoublePlayMiddle.getNameLast(),
                infielderDoublePlayMiddle.getFielderStats().getGameAssists(), infielderDoublePlayMiddle.getNameLast(),
                infielderDoublePlayMiddle.getFielderStats().getGamePutOuts(), infielderDoublePlayEnd.getNameLast(),
                infielderDoublePlayEnd.getFielderStats().getGamePutOuts());
    }

    void updateUnassistedDoublePlay(Fielder currentFielder, HashMap<Integer, Fielder> fielderList, InPlayPosition positionStart,
                                    InPlayPosition positionEnd) {
        Fielder infielderDoublePlayStart = currentFielder.getCurrentFielder(positionStart, fielderList);
        infielderDoublePlayStart.getFielderStats().setGameDoublePlay(infielderDoublePlayStart.getFielderStats().getGameDoublePlay() + 1);
        infielderDoublePlayStart.getFielderStats().setGamePutOuts(infielderDoublePlayStart.getFielderStats().getGamePutOuts() + 1);
        infielderDoublePlayStart.getFielderStats().setGameAssists(infielderDoublePlayStart.getFielderStats().getGameAssists() + 1);
        Fielder infielderDoublePlayEnd = currentFielder.getCurrentFielder(positionEnd, fielderList);
        infielderDoublePlayEnd.getFielderStats().setGameDoublePlay(infielderDoublePlayEnd.getFielderStats().getGameDoublePlay() + 1);
        infielderDoublePlayEnd.getFielderStats().setGamePutOuts(infielderDoublePlayEnd.getFielderStats().getGamePutOuts() + 1);
        System.out.printf("Batter hits into double play - %s-%s!%n", currentFielder.getNameLast(), infielderDoublePlayEnd.getNameLast());
        System.out.printf("Assist: %s(%d)%nPut Out: %s(%d)%nPut Out: %s(%d)%n", infielderDoublePlayStart.getNameLast(),
                infielderDoublePlayStart.getFielderStats().getGameAssists(), infielderDoublePlayStart.getNameLast(),
                infielderDoublePlayStart.getFielderStats().getGamePutOuts(),
                infielderDoublePlayEnd.getNameLast(),infielderDoublePlayEnd.getFielderStats().getGamePutOuts());
    }

    void updateOutfieldAssist(Fielder currentFielder, InPlayPosition tagPosition, HashMap<Integer, Fielder> fielderList) {
        Fielder infielderWithPutOut = currentFielder.getCurrentFielder(tagPosition, fielderList);
        infielderWithPutOut.getFielderStats().setGamePutOuts(infielderWithPutOut.getFielderStats().getGamePutOuts() + 1);
        currentFielder.getFielderStats().setGameAssists(currentFielder.getFielderStats().getGameAssists() + 1);
        System.out.printf("Assist: %s(%d)%nPut out: %s(%d)%n", currentFielder.getNameLast(), currentFielder.getFielderStats().getGameAssists(),
                infielderWithPutOut.getNameLast(), infielderWithPutOut.getFielderStats().getGamePutOuts());
    }
}

package Baseball;


import java.util.HashMap;
import java.util.List;

class FielderStats {
    private int gameErrors, gameAssists, gamePutOuts, gameDoublePlay, gameRunnersThrownOut, gameRunnersSuccessful,
    gamesPlayed, gamesStarted, inningOuts, putOuts, assists, errors, doublePlays, passedBalls, stolenBases,
    caughtStealing, zoneRating, wildPitches, gameGamePlayed, gameGameStarted, sErrors, sAssists, sPutOuts, sRunnersThrownOut,
    sRunnersSuccessful, sGamesStarted, sGamesPlayed;
    private double fieldingPercentage, actualPlayerPercentage, histPlayerPercentage;

    FielderStats() {
    }

    public double getActualPlayerPercentage() {
        return actualPlayerPercentage;
    }

    public void setActualPlayerPercentage(double actualPlayerPercentage) {
        this.actualPlayerPercentage = actualPlayerPercentage;
    }

    public double getHistPlayerPercentage() {
        return histPlayerPercentage;
    }

    public void setHistPlayerPercentage(double histPlayerPercentage) {
        this.histPlayerPercentage = histPlayerPercentage;
    }

    public int getGameGameStarted() {
        return gameGameStarted;
    }

    public void setGameGameStarted(int gameGameStarted) {
        this.gameGameStarted = gameGameStarted;
    }

    public int getsErrors() {
        return sErrors;
    }

    public void setsErrors(int sErrors) {
        this.sErrors = sErrors;
    }

    public int getsAssists() {
        return sAssists;
    }

    public void setsAssists(int sAssists) {
        this.sAssists = sAssists;
    }

    public int getsPutOuts() {
        return sPutOuts;
    }

    public void setsPutOuts(int sPutOuts) {
        this.sPutOuts = sPutOuts;
    }

    public int getsRunnersThrownOut() {
        return sRunnersThrownOut;
    }

    public void setsRunnersThrownOut(int sRunnersThrownOut) {
        this.sRunnersThrownOut = sRunnersThrownOut;
    }

    public int getsRunnersSuccessful() {
        return sRunnersSuccessful;
    }

    public void setsRunnersSuccessful(int sRunnersSuccessful) {
        this.sRunnersSuccessful = sRunnersSuccessful;
    }

    public int getsGamesStarted() {
        return sGamesStarted;
    }

    public void setsGamesStarted(int sGamesStarted) {
        this.sGamesStarted = sGamesStarted;
    }

    public int getsGamesPlayed() {
        return sGamesPlayed;
    }

    public void setsGamesPlayed(int sGamesPlayed) {
        this.sGamesPlayed = sGamesPlayed;
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

    void updateFielderGameStats(List<Fielder> fielderList)
    {
        for (Fielder fielder : fielderList)
        {
            fielder.getFielderStats().setsGamesPlayed(fielder.getFielderStats().getsGamesPlayed() + fielder.getFielderStats().getGameGamePlayed());
            fielder.getFielderStats().setsGamesStarted(fielder.getFielderStats().getsGamesStarted() + fielder.getFielderStats().getGameGameStarted());
            fielder.getFielderStats().setsErrors(fielder.getFielderStats().getsErrors() + fielder.getFielderStats().getGameErrors());
            fielder.getFielderStats().setsAssists(fielder.getFielderStats().getsAssists() + fielder.getFielderStats().getGameAssists());
            fielder.getFielderStats().setsPutOuts(fielder.getFielderStats().getsPutOuts() + fielder.getFielderStats().getGamePutOuts());
            fielder.getFielderStats().setsRunnersThrownOut(fielder.getFielderStats().getsRunnersThrownOut() + fielder.getFielderStats().getGameRunnersThrownOut());
            fielder.getFielderStats().setsRunnersSuccessful(fielder.getFielderStats().getsRunnersSuccessful() + fielder.getFielderStats().getGameRunnersThrownOut());
        }
    }
}

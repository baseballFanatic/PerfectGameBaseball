package Baseball;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.StringTokenizer;

public class Schedule {
    private String gameDayName, visitingTeamId, visitingLgId, homeTeamId, homeLgId, lengthOuts, dayNight,
        completionInfo, forfeitInfo, protestInfo, parkId, visitingLineScore, homeLineScore, homePlateUmpireId,
        homePlateUmpireName, firstBaseUmpireId, firstBaseUmpireName, secondBaseUmpireId, secondBaseUmpireName,
        thirdBaseUmpireId, thirdBaseUmpireName, leftFieldUmpireId, leftFieldUmpireName, rightFieldUmpireId,
        rightFieldUmpireName, visitingManagerId, visitingManagerName, homeManagerId, homeManagerName,
        winningPitcherId, winningPitcherName, losingPitcherId, losingPitcherName, savingPitcherId, savingPitcherName,
        gameWinningRbiId, gameWinningRbiName, visitingStartingPitcherId, visitingStartingPitcherName,
        homeStartingPitcherId, homeStartingPitcherName, visitingBatter1Id, visitingBatter1Name,
        visitingBatter2Id, visitingBatter2Name, visitingBatter3Id, visitingBatter3Name,
        visitingBatter4Id, visitingBatter4Name, visitingBatter5Id, visitingBatter5Name,
        visitingBatter6Id, visitingBatter6Name, visitingBatter7Id, visitingBatter7Name,
        visitingBatter8Id, visitingBatter8Name, visitingBatter9Id, visitingBatter9Name,
        homeBatter1Id, homeBatter1Name, homeBatter2Id, homeBatter2Name, homeBatter3Id,
        homeBatter3Name, homeBatter4Id, homeBatter4Name, homeBatter5Id, homeBatter5Name,
        homeBatter6Id, homeBatter6Name, homeBatter7Id, homeBatter7Name,
        homeBatter8Id, homeBatter8Name, homeBatter9Id, homeBatter9Name, acquisitionInfo,
        additionalInfo, gameCompleted, visitingBatter1Position, visitingBatter2Position,
        visitingBatter3Position, visitingBatter4Position, visitingBatter5Position, visitingBatter6Position,
        visitingBatter7Position, visitingBatter8Position, visitingBatter9Position, homeBatter1Position,
        homeBatter2Position, homeBatter3Position, homeBatter4Position, homeBatter5Position,
        homeBatter6Position, homeBatter7Position, homeBatter8Position, homeBatter9Position, gameField ;
    private int gameYear, gameDay, gameMonth, visitingGameNumber, homeGameNumber, visitingScore, homeScore, attendance, timeInMinutes,
        visitingAtBats, visitingHits, visitingDoubles, visitingTriples, visitingHomeRuns, visitingRbi, visitingSacrificeHits,
        visitingSacrificeFlies, visitingHitByPitch, visitingWalks, visitingIntentionalWalks, visitingStrikeOuts,
        visitingStolenBases, visitingCaughtStealing, visitingGroundedIntoDoublePlays, visitingAwardCatchersInterference,
        visitingLeftOnBase, visitingPitchersUsed, visitingIndividualEarnedRuns, visitingTeamEarnedRuns, visitingWildPitches,
        visitingBalks, visitingPutOuts, visitingAssists, visitingErrors, visitingPassedBalls, visitingDoublePlays,
        visitingTriplePlays, homeAtBats, homeHits, homeDoubles, homeTriples, homeHomeRuns, homeRbi, homeSacrificeHits,
        homeSacrificeFlies, homeHitByPitch, homeWalks, homeIntentionalWalks, homeStrikeOuts, homeStolenBases,
        homeCaughtStealing, homeGroundedIntoDoublePlays, homeAwardCatchersInterference, homeLeftOnBase, homePitchersUsed,
        homeIndividualEarnedRuns, homeTeamEarnedRuns, homeWildPitches, homeBalks, homePutOuts, homeAssists, homeErrors,
        homePassedBalls, homeDoublePlays, homeTriplePlays, gameKey, gameNumber, homeWins, homeLosses, awayWins, awayLosses,
        winningPitcherWins, winningPitcherLosses, losingPitcherWins, losingPitcherLosses;
    private LocalDate gameDate;

    public Schedule() {
    }

    public int getWinningPitcherWins()
    {
        return winningPitcherWins;
    }

    public void setWinningPitcherWins( int winningPitcherWins )
    {
        this.winningPitcherWins = winningPitcherWins;
    }

    public int getWinningPitcherLosses()
    {
        return winningPitcherLosses;
    }

    public void setWinningPitcherLosses( int winningPitcherLosses )
    {
        this.winningPitcherLosses = winningPitcherLosses;
    }

    public int getLosingPitcherWins()
    {
        return losingPitcherWins;
    }

    public void setLosingPitcherWins( int losingPitcherWins )
    {
        this.losingPitcherWins = losingPitcherWins;
    }

    public int getLosingPitcherLosses()
    {
        return losingPitcherLosses;
    }

    public void setLosingPitcherLosses( int losingPitcherLosses )
    {
        this.losingPitcherLosses = losingPitcherLosses;
    }

    public int getHomeWins()
    {
        return homeWins;
    }

    public void setHomeWins( int homeWins )
    {
        this.homeWins = homeWins;
    }

    public int getHomeLosses()
    {
        return homeLosses;
    }

    public void setHomeLosses( int homeLosses )
    {
        this.homeLosses = homeLosses;
    }

    public int getAwayWins()
    {
        return awayWins;
    }

    public void setAwayWins( int awayWins )
    {
        this.awayWins = awayWins;
    }

    public int getAwayLosses()
    {
        return awayLosses;
    }

    public void setAwayLosses( int awayLosses )
    {
        this.awayLosses = awayLosses;
    }

    public String getGameField()
    {
        return gameField;
    }

    public void setGameField( String gameField )
    {
        this.gameField = gameField;
    }

    public int getGameYear()
    {
        return gameYear;
    }

    public void setGameYear( int gameYear )
    {
        this.gameYear = gameYear;
    }

    public int getGameDay()
    {
        return gameDay;
    }

    public String getGameDayName()
    {
        return gameDayName;
    }

    public void setGameDayName( String gameDayName )
    {
        this.gameDayName = gameDayName;
    }

    public void setGameDay( int gameDay )
    {
        this.gameDay = gameDay;
    }

    public int getGameMonth()
    {
        return gameMonth;
    }

    public void setGameMonth( int gameMonth )
    {
        this.gameMonth = gameMonth;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getVisitingTeamId() {
        return visitingTeamId;
    }

    public void setVisitingTeamId(String visitingTeamId) {
        this.visitingTeamId = visitingTeamId;
    }

    public String getVisitingLgId() {
        return visitingLgId;
    }

    void setVisitingLgId(String visitingTeamLgId) {
        this.visitingLgId = visitingTeamLgId;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeLgId() {
        return homeLgId;
    }

    public void setHomeLgId(String homeLgId) {
        this.homeLgId = homeLgId;
    }

    public String getLengthOuts() {
        return lengthOuts;
    }

    void setLengthOuts(String lengthOuts) {
        this.lengthOuts = lengthOuts;
    }

    public String getDayNight() {
        return dayNight;
    }

    void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }

    public String getCompletionInfo() {
        return completionInfo;
    }

    void setCompletionInfo(String completionInfo) {
        this.completionInfo = completionInfo;
    }

    public String getForfeitInfo() {
        return forfeitInfo;
    }

    void setForfeitInfo(String forfeitInfo) {
        this.forfeitInfo = forfeitInfo;
    }

    public String getProtestInfo() {
        return protestInfo;
    }

    void setProtestInfo(String protestInfo) {
        this.protestInfo = protestInfo;
    }

    public String getParkId() {
        return parkId;
    }

    void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getVisitingLineScore() {
        return visitingLineScore;
    }

    public void setVisitingLineScore(String visitingLineScore) {
        this.visitingLineScore = visitingLineScore;
    }

    public String getHomeLineScore() {
        return homeLineScore;
    }

    public void setHomeLineScore(String homeLineScore) {
        this.homeLineScore = homeLineScore;
    }

    public String getHomePlateUmpireId() {
        return homePlateUmpireId;
    }

    public void setHomePlateUmpireId(String homePlateUmpireId) {
        this.homePlateUmpireId = homePlateUmpireId;
    }

    public String getHomePlateUmpireName() {
        return homePlateUmpireName;
    }

    public void setHomePlateUmpireName(String homePlateUmpireName) {
        this.homePlateUmpireName = homePlateUmpireName;
    }

    public String getFirstBaseUmpireId() {
        return firstBaseUmpireId;
    }

    public void setFirstBaseUmpireId(String firstBaseUmpireId) {
        this.firstBaseUmpireId = firstBaseUmpireId;
    }

    public String getFirstBaseUmpireName() {
        return firstBaseUmpireName;
    }

    void setFirstBaseUmpireName(String firstBaseUmpireName) {
        this.firstBaseUmpireName = firstBaseUmpireName;
    }

    public String getSecondBaseUmpireId() {
        return secondBaseUmpireId;
    }

    void setSecondBaseUmpireId(String secondBaseUmpireId) {
        this.secondBaseUmpireId = secondBaseUmpireId;
    }

    public String getSecondBaseUmpireName() {
        return secondBaseUmpireName;
    }

    void setSecondBaseUmpireName(String secondBaseUmpireName) {
        this.secondBaseUmpireName = secondBaseUmpireName;
    }

    public String getThirdBaseUmpireId() {
        return thirdBaseUmpireId;
    }

    void setThirdBaseUmpireId(String thirdBaseUmpireId) {
        this.thirdBaseUmpireId = thirdBaseUmpireId;
    }

    public String getThirdBaseUmpireName() {
        return thirdBaseUmpireName;
    }

    void setThirdBaseUmpireName(String thirdBaseUmpireName) {
        this.thirdBaseUmpireName = thirdBaseUmpireName;
    }

    public String getLeftFieldUmpireId() {
        return leftFieldUmpireId;
    }

    void setLeftFieldUmpireId(String leftFieldUmpireId) {
        this.leftFieldUmpireId = leftFieldUmpireId;
    }

    public String getLeftFieldUmpireName() {
        return leftFieldUmpireName;
    }

    void setLeftFieldUmpireName(String leftFieldUmpireName) {
        this.leftFieldUmpireName = leftFieldUmpireName;
    }

    public String getRightFieldUmpireId() {
        return rightFieldUmpireId;
    }

    void setRightFieldUmpireId(String rightFieldUmpireId) {
        this.rightFieldUmpireId = rightFieldUmpireId;
    }

    public String getRightFieldUmpireName() {
        return rightFieldUmpireName;
    }

    void setRightFieldUmpireName(String rightFieldUmpireName) {
        this.rightFieldUmpireName = rightFieldUmpireName;
    }

    public String getVisitingManagerId() {
        return visitingManagerId;
    }

    void setVisitingManagerId(String visitingManagerId) {
        this.visitingManagerId = visitingManagerId;
    }

    public String getVisitingManagerName() {
        return visitingManagerName;
    }

    void setVisitingManagerName(String visitingManagerName) {
        this.visitingManagerName = visitingManagerName;
    }

    public String getHomeManagerId() {
        return homeManagerId;
    }

    void setHomeManagerId(String homeManagerId) {
        this.homeManagerId = homeManagerId;
    }

    public String getHomeManagerName() {
        return homeManagerName;
    }

    void setHomeManagerName(String homeManagerName) {
        this.homeManagerName = homeManagerName;
    }

    public String getWinningPitcherId() {
        return winningPitcherId;
    }

    void setWinningPitcherId(String winningPitcherId) {
        this.winningPitcherId = winningPitcherId;
    }

    public String getWinningPitcherName() {
        return winningPitcherName;
    }

    public void setWinningPitcherName(String winningPitcherName) {
        this.winningPitcherName = winningPitcherName;
    }

    public String getLosingPitcherId() {
        return losingPitcherId;
    }

    void setLosingPitcherId(String losingPitcherId) {
        this.losingPitcherId = losingPitcherId;
    }

    public String getLosingPitcherName() {
        return losingPitcherName;
    }

    public void setLosingPitcherName(String losingPitcherName) {
        this.losingPitcherName = losingPitcherName;
    }

    public String getSavingPitcherId() {
        return savingPitcherId;
    }

    void setSavingPitcherId(String savingPitcherId) {
        this.savingPitcherId = savingPitcherId;
    }

    public String getSavingPitcherName() {
        return savingPitcherName;
    }

    public void setSavingPitcherName(String savingPitcherName) {
        this.savingPitcherName = savingPitcherName;
    }

    public String getGameWinningRbiId() {
        return gameWinningRbiId;
    }

    void setGameWinningRbiId(String gameWinningRbiId) {
        this.gameWinningRbiId = gameWinningRbiId;
    }

    public String getGameWinningRbiName() {
        return gameWinningRbiName;
    }

    void setGameWinningRbiName(String gameWinningRbiName) {
        this.gameWinningRbiName = gameWinningRbiName;
    }

    public String getVisitingStartingPitcherId() {
        return visitingStartingPitcherId;
    }

    void setVisitingStartingPitcherId(String visitingStartingPitcherId) {
        this.visitingStartingPitcherId = visitingStartingPitcherId;
    }

    public String getVisitingStartingPitcherName() {
        return visitingStartingPitcherName;
    }

    public void setVisitingStartingPitcherName(String visitingStartingPitcherName) {
        this.visitingStartingPitcherName = visitingStartingPitcherName;
    }

    public String getHomeStartingPitcherId() {
        return homeStartingPitcherId;
    }

    void setHomeStartingPitcherId(String homeStartingPitcherId) {
        this.homeStartingPitcherId = homeStartingPitcherId;
    }

    public String getHomeStartingPitcherName() {
        return homeStartingPitcherName;
    }

    public void setHomeStartingPitcherName(String homeStartingPitcherName) {
        this.homeStartingPitcherName = homeStartingPitcherName;
    }

    public String getVisitingBatter1Id() {
        return visitingBatter1Id;
    }

    public void setVisitingBatter1Id(String visitingBatter1Id) {
        this.visitingBatter1Id = visitingBatter1Id;
    }

    public String getVisitingBatter1Name() {
        return visitingBatter1Name;
    }

    public void setVisitingBatter1Name(String visitingBatter1Name) {
        this.visitingBatter1Name = visitingBatter1Name;
    }

    public String getVisitingBatter2Id() {
        return visitingBatter2Id;
    }

    public void setVisitingBatter2Id(String visitingBatter2Id) {
        this.visitingBatter2Id = visitingBatter2Id;
    }

    public String getVisitingBatter2Name() {
        return visitingBatter2Name;
    }

    public void setVisitingBatter2Name(String visitingBatter2Name) {
        this.visitingBatter2Name = visitingBatter2Name;
    }

    public String getVisitingBatter3Id() {
        return visitingBatter3Id;
    }

    public void setVisitingBatter3Id(String visitingBatter3Id) {
        this.visitingBatter3Id = visitingBatter3Id;
    }

    public String getVisitingBatter3Name() {
        return visitingBatter3Name;
    }

    public void setVisitingBatter3Name(String visitingBatter3Name) {
        this.visitingBatter3Name = visitingBatter3Name;
    }

    public String getVisitingBatter4Id() {
        return visitingBatter4Id;
    }

    public void setVisitingBatter4Id(String visitingBatter4Id) {
        this.visitingBatter4Id = visitingBatter4Id;
    }

    public String getVisitingBatter4Name() {
        return visitingBatter4Name;
    }

    public void setVisitingBatter4Name(String visitingBatter4Name) {
        this.visitingBatter4Name = visitingBatter4Name;
    }

    public String getVisitingBatter5Id() {
        return visitingBatter5Id;
    }

    public void setVisitingBatter5Id(String visitingBatter5Id) {
        this.visitingBatter5Id = visitingBatter5Id;
    }

    public String getVisitingBatter5Name() {
        return visitingBatter5Name;
    }

    public void setVisitingBatter5Name(String visitingBatter5Name) {
        this.visitingBatter5Name = visitingBatter5Name;
    }

    public String getVisitingBatter6Id() {
        return visitingBatter6Id;
    }

    public void setVisitingBatter6Id(String visitingBatter6Id) {
        this.visitingBatter6Id = visitingBatter6Id;
    }

    public String getVisitingBatter6Name() {
        return visitingBatter6Name;
    }

    public void setVisitingBatter6Name(String visitingBatter6Name) {
        this.visitingBatter6Name = visitingBatter6Name;
    }

    public String getVisitingBatter7Id() {
        return visitingBatter7Id;
    }

    public void setVisitingBatter7Id(String visitingBatter7Id) {
        this.visitingBatter7Id = visitingBatter7Id;
    }

    public String getVisitingBatter7Name() {
        return visitingBatter7Name;
    }

    public void setVisitingBatter7Name(String visitingBatter7Name) {
        this.visitingBatter7Name = visitingBatter7Name;
    }

    public String getVisitingBatter8Id() {
        return visitingBatter8Id;
    }

    public void setVisitingBatter8Id(String visitingBatter8Id) {
        this.visitingBatter8Id = visitingBatter8Id;
    }

    public String getVisitingBatter8Name() {
        return visitingBatter8Name;
    }

    public void setVisitingBatter8Name(String visitingBatter8Name) {
        this.visitingBatter8Name = visitingBatter8Name;
    }

    public String getVisitingBatter9Id() {
        return visitingBatter9Id;
    }

    public void setVisitingBatter9Id(String visitingBatter9Id) {
        this.visitingBatter9Id = visitingBatter9Id;
    }

    public String getVisitingBatter9Name() {
        return visitingBatter9Name;
    }

    public void setVisitingBatter9Name(String visitingBatter9Name) {
        this.visitingBatter9Name = visitingBatter9Name;
    }

    public String getHomeBatter1Id() {
        return homeBatter1Id;
    }

    public void setHomeBatter1Id(String homeBatter1Id) {
        this.homeBatter1Id = homeBatter1Id;
    }

    public String getHomeBatter1Name() {
        return homeBatter1Name;
    }

    public void setHomeBatter1Name(String homeBatter1Name) {
        this.homeBatter1Name = homeBatter1Name;
    }

    public String getHomeBatter2Id() {
        return homeBatter2Id;
    }

    public void setHomeBatter2Id(String homeBatter2Id) {
        this.homeBatter2Id = homeBatter2Id;
    }

    public String getHomeBatter2Name() {
        return homeBatter2Name;
    }

    public void setHomeBatter2Name(String homeBatter2Name) {
        this.homeBatter2Name = homeBatter2Name;
    }

    public String getHomeBatter3Id() {
        return homeBatter3Id;
    }

    public void setHomeBatter3Id(String homeBatter3Id) {
        this.homeBatter3Id = homeBatter3Id;
    }

    public String getHomeBatter3Name() {
        return homeBatter3Name;
    }

    public void setHomeBatter3Name(String homeBatter3Name) {
        this.homeBatter3Name = homeBatter3Name;
    }

    public String getHomeBatter4Id() {
        return homeBatter4Id;
    }

    public void setHomeBatter4Id(String homeBatter4Id) {
        this.homeBatter4Id = homeBatter4Id;
    }

    public String getHomeBatter4Name() {
        return homeBatter4Name;
    }

    public void setHomeBatter4Name(String homeBatter4Name) {
        this.homeBatter4Name = homeBatter4Name;
    }

    public String getHomeBatter5Id() {
        return homeBatter5Id;
    }

    public void setHomeBatter5Id(String homeBatter5Id) {
        this.homeBatter5Id = homeBatter5Id;
    }

    public String getHomeBatter5Name() {
        return homeBatter5Name;
    }

    public void setHomeBatter5Name(String homeBatter5Name) {
        this.homeBatter5Name = homeBatter5Name;
    }

    public String getHomeBatter6Id() {
        return homeBatter6Id;
    }

    public void setHomeBatter6Id(String homeBatter6Id) {
        this.homeBatter6Id = homeBatter6Id;
    }

    public String getHomeBatter6Name() {
        return homeBatter6Name;
    }

    public void setHomeBatter6Name(String homeBatter6Name) {
        this.homeBatter6Name = homeBatter6Name;
    }

    public String getHomeBatter7Id() {
        return homeBatter7Id;
    }

    public void setHomeBatter7Id(String homeBatter7Id) {
        this.homeBatter7Id = homeBatter7Id;
    }

    public String getHomeBatter7Name() {
        return homeBatter7Name;
    }

    public void setHomeBatter7Name(String homeBatter7Name) {
        this.homeBatter7Name = homeBatter7Name;
    }

    public String getHomeBatter8Id() {
        return homeBatter8Id;
    }

    public void setHomeBatter8Id(String homeBatter8Id) {
        this.homeBatter8Id = homeBatter8Id;
    }

    public String getHomeBatter8Name() {
        return homeBatter8Name;
    }

    public void setHomeBatter8Name(String homeBatter8Name) {
        this.homeBatter8Name = homeBatter8Name;
    }

    public String getHomeBatter9Id() {
        return homeBatter9Id;
    }

    public void setHomeBatter9Id(String homeBatter9Id) {
        this.homeBatter9Id = homeBatter9Id;
    }

    public String getHomeBatter9Name() {
        return homeBatter9Name;
    }

    public void setHomeBatter9Name(String homeBatter9Name) {
        this.homeBatter9Name = homeBatter9Name;
    }

    public String getAcquisitionInfo() {
        return acquisitionInfo;
    }

    public void setAcquisitionInfo(String acquisitionInfo) {
        this.acquisitionInfo = acquisitionInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getGameCompleted() {
        return gameCompleted;
    }

    public void setGameCompleted(String gameCompleted) {
        this.gameCompleted = gameCompleted;
    }

    public int getVisitingGameNumber() {
        return visitingGameNumber;
    }

    void setVisitingGameNumber(int visitingGameNumber) {
        this.visitingGameNumber = visitingGameNumber;
    }

    public int getHomeGameNumber() {
        return homeGameNumber;
    }

    void setHomeGameNumber(int homeGameNumber) {
        this.homeGameNumber = homeGameNumber;
    }

    public int getVisitingScore() {
        return visitingScore;
    }

    public void setVisitingScore(int visitingScore) {
        this.visitingScore = visitingScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAttendance() {
        return attendance;
    }

    void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public int getVisitingAtBats() {
        return visitingAtBats;
    }

    public void setVisitingAtBats(int visitingAtBats) {
        this.visitingAtBats = visitingAtBats;
    }

    public int getVisitingHits() {
        return visitingHits;
    }

    public void setVisitingHits(int visitingHits) {
        this.visitingHits = visitingHits;
    }

    public int getVisitingDoubles() {
        return visitingDoubles;
    }

    public void setVisitingDoubles(int visitingDoubles) {
        this.visitingDoubles = visitingDoubles;
    }

    public int getVisitingTriples() {
        return visitingTriples;
    }

    public void setVisitingTriples(int visitingTriples) {
        this.visitingTriples = visitingTriples;
    }

    public int getVisitingHomeRuns() {
        return visitingHomeRuns;
    }

    public void setVisitingHomeRuns(int visitingHomeRuns) {
        this.visitingHomeRuns = visitingHomeRuns;
    }

    public int getVisitingRbi() {
        return visitingRbi;
    }

    public void setVisitingRbi(int visitingRbi) {
        this.visitingRbi = visitingRbi;
    }

    public int getVisitingSacrificeHits() {
        return visitingSacrificeHits;
    }

    public void setVisitingSacrificeHits(int visitingSacrificeHits) {
        this.visitingSacrificeHits = visitingSacrificeHits;
    }

    public int getVisitingSacrificeFlies() {
        return visitingSacrificeFlies;
    }

    public void setVisitingSacrificeFlies(int visitingSacrificeFlies) {
        this.visitingSacrificeFlies = visitingSacrificeFlies;
    }

    public int getVisitingHitByPitch() {
        return visitingHitByPitch;
    }

    public void setVisitingHitByPitch(int visitingHitByPitch) {
        this.visitingHitByPitch = visitingHitByPitch;
    }

    public int getVisitingWalks() {
        return visitingWalks;
    }

    public void setVisitingWalks(int visitingWalks) {
        this.visitingWalks = visitingWalks;
    }

    public int getVisitingIntentionalWalks() {
        return visitingIntentionalWalks;
    }

    public void setVisitingIntentionalWalks(int visitingIntentionalWalks) {
        this.visitingIntentionalWalks = visitingIntentionalWalks;
    }

    public int getVisitingStrikeOuts() {
        return visitingStrikeOuts;
    }

    public void setVisitingStrikeOuts(int visitingStrikeOuts) {
        this.visitingStrikeOuts = visitingStrikeOuts;
    }

    public int getVisitingStolenBases() {
        return visitingStolenBases;
    }

    public void setVisitingStolenBases(int visitingStolenBases) {
        this.visitingStolenBases = visitingStolenBases;
    }

    public int getVisitingCaughtStealing() {
        return visitingCaughtStealing;
    }

    public void setVisitingCaughtStealing(int visitingCaughtStealing) {
        this.visitingCaughtStealing = visitingCaughtStealing;
    }

    public int getVisitingGroundedIntoDoublePlays() {
        return visitingGroundedIntoDoublePlays;
    }

    public void setVisitingGroundedIntoDoublePlays(int visitingGroundedIntoDoublePlays) {
        this.visitingGroundedIntoDoublePlays = visitingGroundedIntoDoublePlays;
    }

    public int getVisitingAwardCatchersInterference() {
        return visitingAwardCatchersInterference;
    }

    public void setVisitingAwardCatchersInterference(int visitingAwardCatchersInterference) {
        this.visitingAwardCatchersInterference = visitingAwardCatchersInterference;
    }

    public int getVisitingLeftOnBase() {
        return visitingLeftOnBase;
    }

    public void setVisitingLeftOnBase(int visitingLeftOnBase) {
        this.visitingLeftOnBase = visitingLeftOnBase;
    }

    public int getVisitingPitchersUsed() {
        return visitingPitchersUsed;
    }

    public void setVisitingPitchersUsed(int visitingPitchersUsed) {
        this.visitingPitchersUsed = visitingPitchersUsed;
    }

    public int getVisitingIndividualEarnedRuns() {
        return visitingIndividualEarnedRuns;
    }

    public void setVisitingIndividualEarnedRuns(int visitingIndividualEarnedRuns) {
        this.visitingIndividualEarnedRuns = visitingIndividualEarnedRuns;
    }

    public int getVisitingTeamEarnedRuns() {
        return visitingTeamEarnedRuns;
    }

    public void setVisitingTeamEarnedRuns(int visitingTeamEarnedRuns) {
        this.visitingTeamEarnedRuns = visitingTeamEarnedRuns;
    }

    public int getVisitingWildPitches() {
        return visitingWildPitches;
    }

    public void setVisitingWildPitches(int visitingWildPitches) {
        this.visitingWildPitches = visitingWildPitches;
    }

    public int getVisitingBalks() {
        return visitingBalks;
    }

    public void setVisitingBalks(int visitingBalks) {
        this.visitingBalks = visitingBalks;
    }

    public int getVisitingPutOuts() {
        return visitingPutOuts;
    }

    public void setVisitingPutOuts(int visitingPutOuts) {
        this.visitingPutOuts = visitingPutOuts;
    }

    public int getVisitingAssists() {
        return visitingAssists;
    }

    public void setVisitingAssists(int visitingAssists) {
        this.visitingAssists = visitingAssists;
    }

    public int getVisitingErrors() {
        return visitingErrors;
    }

    public void setVisitingErrors(int visitingErrors) {
        this.visitingErrors = visitingErrors;
    }

    public int getVisitingPassedBalls() {
        return visitingPassedBalls;
    }

    public void setVisitingPassedBalls(int visitingPassedBalls) {
        this.visitingPassedBalls = visitingPassedBalls;
    }

    public int getVisitingDoublePlays() {
        return visitingDoublePlays;
    }

    public void setVisitingDoublePlays(int visitingDoublePlays) {
        this.visitingDoublePlays = visitingDoublePlays;
    }

    public int getVisitingTriplePlays() {
        return visitingTriplePlays;
    }

    public void setVisitingTriplePlays(int visitingTriplePlays) {
        this.visitingTriplePlays = visitingTriplePlays;
    }

    public int getHomeAtBats() {
        return homeAtBats;
    }

    public void setHomeAtBats(int homeAtBats) {
        this.homeAtBats = homeAtBats;
    }

    public int getHomeHits() {
        return homeHits;
    }

    public void setHomeHits(int homeHits) {
        this.homeHits = homeHits;
    }

    public int getHomeDoubles() {
        return homeDoubles;
    }

    public void setHomeDoubles(int homeDoubles) {
        this.homeDoubles = homeDoubles;
    }

    public int getHomeTriples() {
        return homeTriples;
    }

    public void setHomeTriples(int homeTriples) {
        this.homeTriples = homeTriples;
    }

    public int getHomeHomeRuns() {
        return homeHomeRuns;
    }

    public void setHomeHomeRuns(int homeHomeRuns) {
        this.homeHomeRuns = homeHomeRuns;
    }

    public int getHomeRbi() {
        return homeRbi;
    }

    public void setHomeRbi(int homeRbi) {
        this.homeRbi = homeRbi;
    }

    public int getHomeSacrificeHits() {
        return homeSacrificeHits;
    }

    public void setHomeSacrificeHits(int homeSacrificeHits) {
        this.homeSacrificeHits = homeSacrificeHits;
    }

    public int getHomeSacrificeFlies() {
        return homeSacrificeFlies;
    }

    public void setHomeSacrificeFlies(int homeSacrificeFlies) {
        this.homeSacrificeFlies = homeSacrificeFlies;
    }

    public int getHomeHitByPitch() {
        return homeHitByPitch;
    }

    public void setHomeHitByPitch(int homeHitByPitch) {
        this.homeHitByPitch = homeHitByPitch;
    }

    public int getHomeWalks() {
        return homeWalks;
    }

    public void setHomeWalks(int homeWalks) {
        this.homeWalks = homeWalks;
    }

    public int getHomeIntentionalWalks() {
        return homeIntentionalWalks;
    }

    public void setHomeIntentionalWalks(int homeIntentionalWalks) {
        this.homeIntentionalWalks = homeIntentionalWalks;
    }

    public int getHomeStrikeOuts() {
        return homeStrikeOuts;
    }

    public void setHomeStrikeOuts(int homeStrikeOuts) {
        this.homeStrikeOuts = homeStrikeOuts;
    }

    public int getHomeStolenBases() {
        return homeStolenBases;
    }

    public void setHomeStolenBases(int homeStolenBases) {
        this.homeStolenBases = homeStolenBases;
    }

    public int getHomeCaughtStealing() {
        return homeCaughtStealing;
    }

    public void setHomeCaughtStealing(int homeCaughtStealing) {
        this.homeCaughtStealing = homeCaughtStealing;
    }

    public int getHomeGroundedIntoDoublePlays() {
        return homeGroundedIntoDoublePlays;
    }

    public void setHomeGroundedIntoDoublePlays(int homeGroundedIntoDoublePlays) {
        this.homeGroundedIntoDoublePlays = homeGroundedIntoDoublePlays;
    }

    public int getHomeAwardCatchersInterference() {
        return homeAwardCatchersInterference;
    }

    public void setHomeAwardCatchersInterference(int homeAwardCatchersInterference) {
        this.homeAwardCatchersInterference = homeAwardCatchersInterference;
    }

    public int getHomeLeftOnBase() {
        return homeLeftOnBase;
    }

    public void setHomeLeftOnBase(int homeLeftOnBase) {
        this.homeLeftOnBase = homeLeftOnBase;
    }

    public int getHomePitchersUsed() {
        return homePitchersUsed;
    }

    public void setHomePitchersUsed(int homePitchersUsed) {
        this.homePitchersUsed = homePitchersUsed;
    }

    public int getHomeIndividualEarnedRuns() {
        return homeIndividualEarnedRuns;
    }

    public void setHomeIndividualEarnedRuns(int homeIndividualEarnedRuns) {
        this.homeIndividualEarnedRuns = homeIndividualEarnedRuns;
    }

    public int getHomeTeamEarnedRuns() {
        return homeTeamEarnedRuns;
    }

    public void setHomeTeamEarnedRuns(int homeTeamEarnedRuns) {
        this.homeTeamEarnedRuns = homeTeamEarnedRuns;
    }

    public int getHomeWildPitches() {
        return homeWildPitches;
    }

    public void setHomeWildPitches(int homeWildPitches) {
        this.homeWildPitches = homeWildPitches;
    }

    public int getHomeBalks() {
        return homeBalks;
    }

    public void setHomeBalks(int homeBalks) {
        this.homeBalks = homeBalks;
    }

    public int getHomePutOuts() {
        return homePutOuts;
    }

    public void setHomePutOuts(int homePutOuts) {
        this.homePutOuts = homePutOuts;
    }

    public int getHomeAssists() {
        return homeAssists;
    }

    public void setHomeAssists(int homeAssists) {
        this.homeAssists = homeAssists;
    }

    public int getHomeErrors() {
        return homeErrors;
    }

    public void setHomeErrors(int homeErrors) {
        this.homeErrors = homeErrors;
    }

    public int getHomePassedBalls() {
        return homePassedBalls;
    }

    public void setHomePassedBalls(int homePassedBalls) {
        this.homePassedBalls = homePassedBalls;
    }

    public int getHomeDoublePlays() {
        return homeDoublePlays;
    }

    public void setHomeDoublePlays(int homeDoublePlays) {
        this.homeDoublePlays = homeDoublePlays;
    }

    public int getHomeTriplePlays() {
        return homeTriplePlays;
    }

    public void setHomeTriplePlays(int homeTriplePlays) {
        this.homeTriplePlays = homeTriplePlays;
    }

    public String getVisitingBatter1Position() {
        return visitingBatter1Position;
    }

    public void setVisitingBatter1Position(String visitingBatter1Position) {
        this.visitingBatter1Position = visitingBatter1Position;
    }

    public String getVisitingBatter2Position() {
        return visitingBatter2Position;
    }

    public void setVisitingBatter2Position(String visitingBatter2Position) {
        this.visitingBatter2Position = visitingBatter2Position;
    }

    public String getVisitingBatter3Position() {
        return visitingBatter3Position;
    }

    public void setVisitingBatter3Position(String visitingBatter3Position) {
        this.visitingBatter3Position = visitingBatter3Position;
    }

    public String getVisitingBatter4Position() {
        return visitingBatter4Position;
    }

    public void setVisitingBatter4Position(String visitingBatter4Position) {
        this.visitingBatter4Position = visitingBatter4Position;
    }

    public String getVisitingBatter5Position() {
        return visitingBatter5Position;
    }

    public void setVisitingBatter5Position(String visitingBatter5Position) {
        this.visitingBatter5Position = visitingBatter5Position;
    }

    public String getVisitingBatter6Position() {
        return visitingBatter6Position;
    }

    public void setVisitingBatter6Position(String visitingBatter6Position) {
        this.visitingBatter6Position = visitingBatter6Position;
    }

    public String getVisitingBatter7Position() {
        return visitingBatter7Position;
    }

    public void setVisitingBatter7Position(String visitingBatter7Position) {
        this.visitingBatter7Position = visitingBatter7Position;
    }

    public String getVisitingBatter8Position() {
        return visitingBatter8Position;
    }

    public void setVisitingBatter8Position(String visitingBatter8Position) {
        this.visitingBatter8Position = visitingBatter8Position;
    }

    public String getVisitingBatter9Position() {
        return visitingBatter9Position;
    }

    public void setVisitingBatter9Position(String visitingBatter9Position) {
        this.visitingBatter9Position = visitingBatter9Position;
    }

    public String getHomeBatter1Position() {
        return homeBatter1Position;
    }

    public void setHomeBatter1Position(String homeBatter1Position) {
        this.homeBatter1Position = homeBatter1Position;
    }

    public String getHomeBatter2Position() {
        return homeBatter2Position;
    }

    public void setHomeBatter2Position(String homeBatter2Position) {
        this.homeBatter2Position = homeBatter2Position;
    }

    public String getHomeBatter3Position() {
        return homeBatter3Position;
    }

    public void setHomeBatter3Position(String homeBatter3Position) {
        this.homeBatter3Position = homeBatter3Position;
    }

    public String getHomeBatter4Position() {
        return homeBatter4Position;
    }

    public void setHomeBatter4Position(String homeBatter4Position) {
        this.homeBatter4Position = homeBatter4Position;
    }

    public String getHomeBatter5Position() {
        return homeBatter5Position;
    }

    public void setHomeBatter5Position(String homeBatter5Position) {
        this.homeBatter5Position = homeBatter5Position;
    }

    public String getHomeBatter6Position() {
        return homeBatter6Position;
    }

    public void setHomeBatter6Position(String homeBatter6Position) {
        this.homeBatter6Position = homeBatter6Position;
    }

    public String getHomeBatter7Position() {
        return homeBatter7Position;
    }

    public void setHomeBatter7Position(String homeBatter7Position) {
        this.homeBatter7Position = homeBatter7Position;
    }

    public String getHomeBatter8Position() {
        return homeBatter8Position;
    }

    public void setHomeBatter8Position(String homeBatter8Position) {
        this.homeBatter8Position = homeBatter8Position;
    }

    public String getHomeBatter9Position() {
        return homeBatter9Position;
    }

    public void setHomeBatter9Position(String homeBatter9Position) {
        this.homeBatter9Position = homeBatter9Position;
    }

    public int getGameKey() {
        return gameKey;
    }

    public void setGameKey(int gameKey) {
        this.gameKey = gameKey;
    }

/*    List<Schedule> getSchedule(int yearID, String lgID, Schedule schedule) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Schedule> scheduleList;

        scheduleList = Database.selectSchedule(yearID, lgID, schedule);

        return scheduleList;
    }*/
}

package Baseball;

import org.apache.tomcat.jni.Local;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

class Database {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/lahman2016";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute query
            stmt = conn.createStatement();
            //createPgbsBatters(stmt);
            //createPgbsPitchers(stmt);
            createPgbsFielders(stmt);
            //createPgbsSeasons(stmt);
            //createPgbsTeams(stmt);
            //createPgbsSchedule(stmt);
            //createPgbsLineUp(stmt);

            int yearID = 1913;
            String lgID="AL";
            //insertPgbsBatters(conn, yearID);
            //insertPgbsPitchers(conn, yearID);
            insertPgbsFielders(conn, yearID);
            /*insertPgbsTeams(conn, yearID);
            insertPgbsSchedule(conn, yearID);
            Schedule schedule = new Schedule();
            insertPgbsLineUp(conn);
            insertPgbsSeasons(conn, yearID);*/

            // Clean-up environment
            //rs.close();
            //stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    private static void createPgbsBatters(Statement stmt) throws SQLException {
        String batters;
        batters = "CREATE table pgbs_batters " +
                "(nameFirst varchar(255)," +
                "nameLast varchar(255)," +
                "bats varchar(255)," +
                " retroId varchar(255), " +
                "playerID varchar(255), " +
                "yearID int(11), " +
                "stint int(11), " +
                "teamID varchar(255)," +
                "lgID varchar(255), " +
                "G int(11), " +
                "AB int(11), " +
                "R int(11), " +
                "H int(11), " +
                "2B int(11), " +
                "3B int(11), " +
                "HR int(11)," +
                "RBI int(11), " +
                "SB int(11), " +
                "CS int(11), " +
                "BB int(11), " +
                "SO int(11), " +
                "IBB varchar(255), " +
                "HBP varchar(255)," +
                "SH varchar(255), " +
                "SF varchar(255), " +
                "GIDP varchar(255), " +
                "round varchar(255), " +
                "availability varchar(255)," +
                "awardPoints int(11), " +
                "speedRating int(11), " +
                "sGamesPlayed int(11), " +
                "sGamesStarted int(11), " +
                "sAtBats int(11), " +
                "sHits int(11)," +
                "sRuns int(11), " +
                "sDoubles int(11), " +
                "sTriples int(11), " +
                "sHomeRuns int(11), " +
                "sRbi int(11), " +
                "sWalks int(11)," +
                "sStrikeOuts int(11), " +
                "sHitByPitch int(11), " +
                "sPlateAppearances int(11), " +
                "sSacrificeHits int(11), " +
                "sSacrificeFlies int(11), " +
                "sStolenBases int(11), " +
                "sCaughtStealing int(11), " +
                "gameDate varchar(255)," +
                "histPercentPlayed int(11), " +
                "actualPlayPercent int(11), " +
                "pinchAtBat int(11), " +
                "pinchHit int(11)," +
                "pinchRbi int(11), " +
                "rispAtBat int(11), " +
                "rispHit int(11), " +
                "rispRbi int(11), " +
                "rispSingle int(11)," +
                "rispDouble int(11), " +
                "rispTriple int(11), " +
                "rispHomeRun int(11), " +
                "rispWalk int(11), " +
                "rispStrikeOut int(11)," +
                "rispGroundedIntoDp int(11), " +
                "rispHitByPitch int(11), " +
                "leftOnBase int(11), " +
                "simName varchar(255)," +
                "playerKey int(11) not null auto_increment primary key)";
        stmt.executeUpdate(batters);
    }

    private static void createPgbsPitchers(Statement stmt) throws SQLException {
        String pitchers;
        pitchers = "CREATE TABLE pgbs_pitchers " +
                " (nameFirst varchar(255)," +
                " nameLast varchar(255)," +
                " throws varchar(255)," +
                " retroId varchar(255), " +
                " playerID varchar(255), " +
                " yearID int(11), " +
                " stint int(11), " +
                " teamID varchar(255), " +
                " lgID varchar(255), " +
                " W int(11), " +
                " L int(11), " +
                " G int(11), " +
                " GS int(11), " +
                " CG int(11), " +
                " SHO int(11), " +
                " SV int(11), " +
                " IPouts int(11), " +
                " H int(11), " +
                " ER int(11), " +
                " HR int(11), " +
                " BB int(11), " +
                " SO int(11), " +
                " BAOpp varchar(255), " +
                " ERA double, " +
                " IBB varchar(255)," +
                " WP varchar(255)," +
                " HBP varchar(255)," +
                " BK int(11)," +
                " BFP varchar(255)," +
                " GF varchar(255)," +
                " R int(11)," +
                " SH varchar(255)," +
                " SF varchar(255)," +
                " GIDP varchar(255), " +
                " sGamesPlayed int(11), " +
                " sGamesStarted int(11), " +
                " sBattersFaced int(11)," +
                " sHitsAllowed int(11)," +
                " sHitBatters int(11)," +
                " sEarnedRuns int(11)," +
                " sRunsAllowed int(11)," +
                " sStrikeOutsAllowed int(11)," +
                " sWalksAllowed int(11)," +
                " sHomeRunsAllowed int(11)," +
                " sInningsPitchedOuts int(11)," +
                " sShutOuts int(11), " +
                " sCompleteGames int(11), " +
                " sWins int(11), " +
                " sLosses int(11), " +
                " sSaves int(11), " +
                " simName varchar(255), " +
                " playerKey int(11) not null auto_increment primary key)";

        stmt.executeUpdate(pitchers);
    }

    private static void createPgbsFielders(Statement stmt) throws SQLException {
        String fielders;
        fielders = "CREATE TABLE pgbs_fielders" +
                "( nameFirst varchar(255), " +
                " nameLast varchar(255), " +
                " retroID varchar(255), " +
                " playerID varchar(255)," +
                " yearID int(11)," +
                " stint int(11)," +
                " teamID varchar(255)," +
                " lgID varchar(255)," +
                " POS varchar(255)," +
                " G int(11)," +
                " GS varchar(255)," +
                " innOuts varchar(255)," +
                " PO int(11)," +
                " A int(11)," +
                " E int(11)," +
                " DP int(11)," +
                " PB varchar(255)," +
                " WP varchar(255)," +
                " SB varchar(255)," +
                " CS varchar(255)," +
                " ZR varchar(255)," +
                " sGamesStarted int(11), " +
                " sGamesPlayed int(11), " +
                " sErrors int(11)," +
                " sAssists int(11)," +
                " sPutOuts int(11)," +
                " sRunnersThrownOut int(11)," +
                " sRunnersSuccessful int(11)," +
                " fieldingPercentage double," +
                " simName varchar(255)," +
                " playerKey int(11) not null auto_increment primary key)";

        stmt.executeUpdate(fielders);
    }

    private static void createPgbsSchedule (Statement stmt) throws SQLException
    {
        String games;
        games = "CREATE TABLE pgbs_schedule " +
                " (gameDate date, " +
                " gameNumber int(11), " +
                " gameDay varchar(255), " +
                " visitingTeamId varchar(255), " +
                " visitingLgId varchar(255), " +
                " visitingGameNumber int(11), " +
                " homeTeamId varchar(255), " +
                " homeLgId varchar(255), " +
                " homeGameNumber int(11), " +
                " visitingScore int (11), " +
                " homeScore int(11), " +
                " lengthOuts varchar(255), " +
                " dayNight varchar(255), " +
                " completionInfo varchar(255), " +
                " forfeitInfo varchar(255), " +
                " parkId varchar(255), " +
                " attendance int(11), " +
                " timeInMinutes int(11), " +
                " visitingLineScore varchar(255), " +
                " homeLineScore varchar(255), " +
                " homePlateUmpireId varchar(255), " +
                " homePlateUmpireName varchar(255), " +
                " firstBaseUmpireId varchar(255), " +
                " firstBaseUmpireName varchar(255), " +
                " secondBaseUmpireId varchar(255), " +
                " secondBaseUmpireName varchar(255), " +
                " thirdBaseUmpireId varchar(255), " +
                " thirdBaseUmpireName varchar(255), " +
                " leftFieldUmpireId varchar(255), " +
                " leftFieldUmpireName varchar(255), " +
                " rightFieldUmpireId varchar(255), " +
                " rightFieldUmpireName varchar(255), " +
                " visitingManagerId varchar(255), " +
                " visitingManagerName varchar(255), " +
                " homeManagerId varchar(255), " +
                " homeManagerName varchar(255), " +
                " winningPitcherId varchar(255), " +
                " winningPitcherName varchar(255), " +
                " losingPitcherId varchar(255), " +
                " losingPitcherName varchar(255), " +
                " savingPitcherId varchar(255), " +
                " savingPitcherName varchar(255), " +
                " visitingStartingPitcherId varchar(255), " +
                " visitingStartingPitcherName varchar(255), " +
                " homeStartingPitcherId varchar(255), " +
                " homeStartingPitcherName varchar(255), " +
                " additionalInfo varchar(255), " +
                " acquisitionInfo varchar(255), " +
                " gameCompleted varchar(255), " +
                " gameKey int(11) not null auto_increment primary key)";

        stmt.executeUpdate(games);
    }

    private static void createPgbsSeasons(Statement stmt) throws SQLException {
        String seasons;
        seasons = "CREATE TABLE pgbs_season_reference" +
                "(yearID int(11)," +
                "alEastChamp varchar(255)," +
                "alCentralChamp varchar(255)," +
                "alWestChamp varchar(255)," +
                "alWildCard varchar(255)," +
                "alDivisionSeries1 varchar(255)," +
                "alDivisionSeries2 varchar(255)," +
                "alChampion varchar(255)," +
                "alMvp varchar(255)," +
                "alCyYoung varchar(255)," +
                "nlEastChamp varchar(255)," +
                "nlCentralChamp varchar(255)," +
                "nlWestChamp varchar(255)," +
                "nlWildCard varchar(255)," +
                "nlDivisionSeries1 varchar(255)," +
                "nlDivisionSeries2 varchar(255)," +
                "nlChampion varchar(255)," +
                "nlMvp varchar(255)," +
                "nlCyYoung varchar(255)," +
                "worldSeriesChamp varchar(255)," +
                "al1bSilver varchar(255)," +
                "al2bSilver varchar(255)," +
                "al3bSilver varchar(255)," +
                "alSsSilver varchar(255)," +
                "alCsilver varchar(255)," +
                "alDhSilver varchar(255)," +
                "alLfSilver varchar(255)," +
                "alCfSilver varchar(255)," +
                "alRfSilver varchar(255)," +
                "nl1bSilver varchar(255)," +
                "nl2bSilver varchar(255)," +
                "nl3bSilver varchar(255)," +
                "nlSsSilver varchar(255)," +
                "nlCsilver varchar(255)," +
                "nlPsilver varchar(255)," +
                "nlLfSilver varchar(255)," +
                "nlCfSilver varchar(255)," +
                "nlRfSilver varchar(255)," +
                "simName varchar(255)," +
                "seasonKey int(11) not null auto_increment primary key)";

        stmt.executeUpdate(seasons);
    }

    private static void createPgbsTeams(Statement stmt) throws SQLException {
        String teams;
        teams = "CREATE TABLE pgbs_teams" +
                " (yearID int(11)," +
                " lgID varchar(255)," +
                " teamID varchar(255)," +
                " franchID varchar(255)," +
                " divID varchar(255)," +
                " Rank int(11)," +
                " G int(11)," +
                " Ghome int(11)," +
                " W int(11)," +
                " L int(11)," +
                " DivWin varchar(255)," +
                " WCWin varchar(255)," +
                " LgWin varchar(255)," +
                " WSWin varchar(255)," +
                " R int(11)," +
                " AB int(11)," +
                " H int(11)," +
                " 2B int(11)," +
                " 3B int(11)," +
                " HR int(11)," +
                " BB int(11)," +
                " SO int(11)," +
                " SB int(11)," +
                " CS varchar(255)," +
                " HBP varchar(255)," +
                " SF varchar(255)," +
                " RA int(11)," +
                " ER int(11)," +
                " ERA double," +
                " CG int(11)," +
                " SHO int(11)," +
                " SV int(11)," +
                " IPouts int(11)," +
                " HA int(11)," +
                " HRA int(11)," +
                " BBA int(11)," +
                " SOA int(11)," +
                " E int(11)," +
                " DP varchar(255)," +
                " FP double," +
                " name varchar(255)," +
                " park varchar(255), " +
                " attendance varchar(255), " +
                " BPF int(11), " +
                " PPF int(11), " +
                " teamIDBR varchar(255), " +
                " teamIDlahman45 varchar(255)," +
                " teamIDretro varchar(255)," +
                " currentWinStreak int(11)," +
                " currentLosingStreak int(11)," +
                " longestWinStreak int(11)," +
                " longestLosingStreak int(11)," +
                " lastGameDate date," +
                " teamLeftOnBase int(11)," +
                " sTeamDoublePlaysTurned int(11)," +
                " sLeftOnBase int(11)," +
                " sAtBats int(11)," +
                " sRunsScored int(11)," +
                " sHits int(11)," +
                " sRbi int(11)," +
                " sDoubles int(11)," +
                " sTriples int(11)," +
                " sHomeRuns int(11)," +
                " sStrikeOuts int(11)," +
                " sWalks int(11)," +
                " sStolenBases int(11)," +
                " sCaughtStealing int(11)," +
                " sHitByPitch int(11)," +
                " sAssists int(11)," +
                " sErrors int(11)," +
                " sPutOuts int(11)," +
                " sDoublePlays int(11)," +
                " sRunnersCaught int(11)," +
                " sPlateAppearances int(11)," +
                " sInningsPitched int(11)," +
                " sHitsAllowed int(11)," +
                " sHomeRunsAllowed int(11)," +
                " sWalksAllowed int(11)," +
                " sStrikeOutsAllowed int(11)," +
                " sSaves int(11)," +
                " sShutOuts int(11)," +
                " sCompleteGames int(11)," +
                " sHitBatters int(11)," +
                " sRunsAllowed int(11)," +
                " seasonWins int(11)," +
                " seasonLosses int(11)," +
                " seasonGames int(11)," +
                " homeWins int(11)," +
                " homeLosses int(11)," +
                " awayWins int(11)," +
                " awayLosses int(11)," +
                " simName varchar(255)," +
                " lgProbWalk double," +
                " lgProbSingle double," +
                " lgProbDouble double," +
                " lgProbTriple double," +
                " lgProbHomeRun double," +
                " lgProbStrikeOut double," +
                " teamKey int(11) not null auto_increment primary key)";
        stmt.executeUpdate(teams);
    }

    private static void createPgbsLineUp(Statement stmt) throws SQLException
    {
        String games;
        games = "CREATE TABLE pgbs_lineUps" +
                " (gameDate date," +
                " lgID varchar(255)," +
                " teamID varchar(255)," +
                " retroID varchar(255)," +
                " playerName varchar(255), " +
                " playerPosition varchar(255), " +
                " playerOrder int(11), " +
                " gameNumber int(11))";
        stmt.executeUpdate(games);
    }


    private static void insertPgbsSchedule(Connection conn, int yearID) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ClintR/PerfectGameBaseball/src/main/resources/schedules/GL1913.csv"));
        //String line = null;
        String line = reader.readLine();

        List<Schedule> scheduleList = new ArrayList<>();

        while (line != null)
        {
            Schedule game = new Schedule();
            String[] split = line.split(",");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate localDate = LocalDate.parse(split[0], formatter);
            game.setGameDate(localDate);
            game.setGameNumber(Integer.parseInt(split[1]));
            game.setGameDay(split[2]);
            game.setVisitingTeamId(split[3]);
            game.setVisitingLgId(split[4]);
            game.setVisitingGameNumber(Integer.parseInt(split[5]));
            game.setHomeTeamId(split[6]);
            game.setHomeLgId(split[7]);
            game.setHomeGameNumber(Integer.parseInt(split[8]));
            game.setVisitingScore(Integer.parseInt(split[9]));
            game.setHomeScore(Integer.parseInt(split[10]));
            game.setLengthOuts(split[11]);
            game.setDayNight(split[12]);
            game.setCompletionInfo(split[13]);
            game.setForfeitInfo(split[14]);
            game.setParkId(split[16]);
            if (split[17].isEmpty())
            {
                game.setAttendance(0);
            } else
            {
                game.setAttendance(Integer.parseInt(split[17]));
            }
            if (split[18].isEmpty())
            {
                game.setAttendance(0);
            } else
            {
                game.setTimeInMinutes(Integer.parseInt(split[18]));
            }
            game.setVisitingLineScore(split[19]);
            game.setHomeLineScore(split[20]);
            game.setHomePlateUmpireId(split[77]);
            game.setHomePlateUmpireName(split[78]);
            game.setFirstBaseUmpireId(split[79]);
            game.setFirstBaseUmpireName(split[80]);
            game.setSecondBaseUmpireId(split[81]);
            game.setSecondBaseUmpireName(split[82]);
            game.setThirdBaseUmpireId(split[83]);
            game.setThirdBaseUmpireName(split[84]);
            game.setLeftFieldUmpireId(split[85]);
            game.setLeftFieldUmpireName(split[86]);
            game.setRightFieldUmpireId(split[87]);
            game.setRightFieldUmpireName(split[88]);
            game.setVisitingManagerId(split[89]);
            game.setVisitingManagerName(split[90]);
            game.setHomeManagerId(split[91]);
            game.setHomeManagerName(split[92]);
            game.setWinningPitcherId(split[93]);
            game.setWinningPitcherName(split[94]);
            game.setLosingPitcherId(split[95]);
            game.setLosingPitcherName(split[96]);
            game.setSavingPitcherId(split[97]);
            game.setSavingPitcherName(split[98]);
            game.setVisitingStartingPitcherId(split[101]);
            game.setVisitingStartingPitcherName(split[102]);
            game.setHomeStartingPitcherId(split[103]);
            game.setHomeStartingPitcherName(split[104]);
            game.setAdditionalInfo(split[159]);
            game.setAcquisitionInfo(split[160]);
            game.setGameCompleted(split[161]);

            scheduleList.add(game);
            split = null;

            line = reader.readLine();

            }

        String query = " insert into pgbs_schedule (gameDate, gameNumber, gameDay, visitingTeamId, visitingLgId, " +
                " visitingGameNumber, homeTeamId, homeLgId, homeGameNumber, visitingScore, homeScore, lengthOuts, " +
                " dayNight, completionInfo, forfeitInfo, parkId, attendance, timeInMinutes, visitingLineScore, " +
                " homeLineScore, homePlateUmpireId, homePlateUmpireName, firstBaseUmpireId, firstBaseUmpireName, " +
                " secondBaseUmpireId, secondBaseUmpireName, thirdBaseUmpireId, thirdBaseUmpireName, leftFieldUmpireId, " +
                " leftFieldUmpireName, rightFieldUmpireId, rightFieldUmpireName, visitingManagerId, visitingManagerName, " +
                " homeManagerId, homeManagerName, winningPitcherId, winningPitcherName, losingPitcherId, losingPitcherName, " +
                " savingPitcherId, savingPitcherName, visitingStartingPitcherId, visitingStartingPitcherName, " +
                " homeStartingPitcherId, homeStartingPitcherName, additionalInfo, acquisitionInfo, gameCompleted) " +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = null;

        try
        {
            preparedStmt = conn.prepareStatement(query);

            for (Schedule gameRow : scheduleList)
            {
                preparedStmt.setDate(1, java.sql.Date.valueOf(gameRow.getGameDate()));
                preparedStmt.setInt(2, gameRow.getGameNumber());
                preparedStmt.setString(3, gameRow.getGameDay());
                preparedStmt.setString(4, gameRow.getVisitingTeamId());
                preparedStmt.setString(5, gameRow.getVisitingLgId());
                preparedStmt.setInt(6, gameRow.getVisitingGameNumber());
                preparedStmt.setString(7, gameRow.getHomeTeamId());
                preparedStmt.setString(8, gameRow.getHomeLgId());
                preparedStmt.setInt(9, gameRow.getHomeGameNumber());
                preparedStmt.setInt(10, gameRow.getVisitingScore());
                preparedStmt.setInt(11, gameRow.getHomeScore());
                preparedStmt.setString(12, gameRow.getLengthOuts());
                preparedStmt.setString(13, gameRow.getDayNight());
                preparedStmt.setString(14, gameRow.getCompletionInfo());
                preparedStmt.setString(15, gameRow.getForfeitInfo());
                preparedStmt.setString(16, gameRow.getParkId());
                preparedStmt.setInt(17, gameRow.getAttendance());
                preparedStmt.setInt(18, gameRow.getTimeInMinutes());
                preparedStmt.setString(19, gameRow.getVisitingLineScore());
                preparedStmt.setString(20, gameRow.getHomeLineScore());
                preparedStmt.setString(21, gameRow.getHomePlateUmpireId());
                preparedStmt.setString(22, gameRow.getHomePlateUmpireName());
                preparedStmt.setString(23, gameRow.getFirstBaseUmpireId());
                preparedStmt.setString(24, gameRow.getFirstBaseUmpireName());
                preparedStmt.setString(25, gameRow.getSecondBaseUmpireId());
                preparedStmt.setString(26, gameRow.getSecondBaseUmpireName());
                preparedStmt.setString(27, gameRow.getThirdBaseUmpireId());
                preparedStmt.setString(28, gameRow.getThirdBaseUmpireName());
                preparedStmt.setString(29, gameRow.getLeftFieldUmpireId());
                preparedStmt.setString(30, gameRow.getLeftFieldUmpireName());
                preparedStmt.setString(31, gameRow.getRightFieldUmpireId());
                preparedStmt.setString(32, gameRow.getRightFieldUmpireName());
                preparedStmt.setString(33, gameRow.getVisitingManagerId());
                preparedStmt.setString(34, gameRow.getVisitingManagerName());
                preparedStmt.setString(35, gameRow.getHomeManagerId());
                preparedStmt.setString(36, gameRow.getHomeManagerName());
                preparedStmt.setString(37, gameRow.getWinningPitcherId());
                preparedStmt.setString(38, gameRow.getWinningPitcherName());
                preparedStmt.setString(39, gameRow.getLosingPitcherId());
                preparedStmt.setString(40, gameRow.getLosingPitcherName());
                preparedStmt.setString(41, gameRow.getSavingPitcherId());
                preparedStmt.setString(42, gameRow.getSavingPitcherName());
                preparedStmt.setString(43, gameRow.getVisitingStartingPitcherId());
                preparedStmt.setString(44, gameRow.getVisitingStartingPitcherName());
                preparedStmt.setString(45, gameRow.getHomeStartingPitcherId());
                preparedStmt.setString(46, gameRow.getHomeStartingPitcherName());
                preparedStmt.setString(47, gameRow.getAdditionalInfo());
                preparedStmt.setString(48, gameRow.getAcquisitionInfo());
                preparedStmt.setString(49, gameRow.getGameCompleted());
                preparedStmt.executeUpdate();
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
            throw se;
        }
        finally
        {
            preparedStmt.close();
        }
        System.out.println("stop");
        }

    private static void insertPgbsBatters(Connection conn, int yearID) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("insert into pgbs_batters (nameFirst," +
                " nameLast," +
                "    bats," +
                " retroId, " +
                "    playerID," +
                "    yearID," +
                "    stint," +
                "    teamID," +
                "    lgID," +
                "    G," +
                "    AB," +
                "    R," +
                "    H," +
                "    2B," +
                "    3B," +
                "    HR," +
                "    RBI," +
                "    SB," +
                "    CS," +
                "    BB," +
                "    SO," +
                "    IBB," +
                "    HBP," +
                "    SH," +
                "    SF," +
                "    GIDP) " +
                " select m.nameFirst, m.nameLast, m.bats, m.retroID, b.* " +
                " from batting as b " +
                " join master as m on b.playerID = m.playerID " +
                " where b.yearID=?");
        statement.setInt(1, yearID);
        statement.executeUpdate();
    }

    private static void insertPgbsPitchers(Connection conn, int yearID) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO pgbs_pitchers (" +
                " nameFirst, " +
                " nameLast, " +
                " throws, " +
                " retroId, " +
                " playerID, " +
                " yearID, " +
                " stint, " +
                " teamID, " +
                " lgID," +
                " W, " +
                " L, " +
                " G, " +
                " GS, " +
                " CG, " +
                " SHO, " +
                " SV, " +
                " IPouts, " +
                " H, " +
                " ER, " +
                " HR, " +
                " BB, " +
                " SO, " +
                " BAopp, " +
                " ERA, " +
                " IBB, " +
                " WP, " +
                " HBP, " +
                " BK, " +
                " BFP, " +
                " GF, " +
                " R, " +
                " SH, " +
                " SF, " +
                " GIDP) " +
                " SELECT m.nameFirst," +
                " m.nameLast, " +
                " m.throws, " +
                " m.retroId, " +
                " p.* " +
                " FROM pitching as p " +
                " JOIN master as m on p.playerID = m.playerID " +
                " WHERE p.yearID=?");
        statement.setInt(1, yearID);
        statement.executeUpdate();
    }

    private static void insertPgbsFielders(Connection conn, int yearID) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO pgbs_fielders (" +
                " nameFirst, " +
                " nameLast, " +
                " retroID, " +
                " playerID, " +
                " yearID, " +
                " stint, " +
                " teamID, " +
                " lgID, " +
                " POS, " +
                " G, " +
                " GS, " +
                " innOuts, " +
                " PO, " +
                " A, " +
                " E, " +
                " DP, " +
                " PB, " +
                " WP, " +
                " SB, " +
                " CS, " +
                " ZR) " +
                " SELECT m.nameFirst, " +
                " m.nameLast, " +
                " m.retroID, " +
                " f.* " +
                " FROM fielding as f " +
                " JOIN master as m on f.playerID = m.playerID " +
                " WHERE f.yearID=?");
        statement.setInt(1, yearID);
        statement.executeUpdate();
    }

    private static void insertPgbsSeasons(Connection conn, int yearID) throws SQLException {
        String query = "INSERT INTO pgbs_season_reference (" +
                " yearID, " +
                " alEastChamp, " +
                " alCentralChamp, " +
                " alWestChamp, " +
                " alWildCard, " +
                " alDivisionSeries1, " +
                " alDivisionSeries2, " +
                " alChampion, " +
                " alMvp, " +
                " alCyYoung, " +
                " nlEastChamp, " +
                " nlCentralChamp, " +
                " nlWestChamp, " +
                " nlWildCard, " +
                " nlDivisionSeries1, " +
                " nlDivisionSeries2, " +
                " nlChampion, " +
                " nlMvp, " +
                " nlCyYoung, " +
                " worldSeriesChamp, " +
                " al1bSilver, " +
                " al2bSilver, " +
                " al3bSilver," +
                " alSsSilver, " +
                " alCsilver, " +
                " alDhSilver, " +
                " alLfSilver," +
                " alCfSilver, " +
                " alRfSilver," +
                " nl1bSilver, " +
                " nl2bSilver, " +
                " nl3bSilver, " +
                " nlSsSilver, " +
                " nlCsilver, " +
                " nlPsilver, " +
                " nlLfSilver, " +
                " nlCfSilver, " +
                " nlRfSilver, " +
                " simName ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setInt(1, yearID);
        for (int i = 2; i < 39; i++)
        {
            statement.setString(i, "NONE");
        }

        statement.setString(39, "clint");
        statement.execute();
    }

    private static void insertPgbsTeams(Connection conn, int yearID) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO pgbs_teams " +
                " (yearID, " +
                " lgID, " +
                " teamID, " +
                " franchID, " +
                " divID, " +
                " Rank, " +
                " G, " +
                " Ghome, " +
                " W, " +
                " L, " +
                " DivWin, " +
                " WCWin, " +
                " LgWin, " +
                " WSWin, " +
                " R, " +
                " AB, " +
                " H, " +
                " 2B, " +
                " 3B, " +
                " HR, " +
                " BB, " +
                " SO, " +
                " SB, " +
                " CS, " +
                " HBP, " +
                " SF, " +
                " RA, " +
                " ER, " +
                " ERA, " +
                " CG, " +
                " SHO, " +
                " SV, " +
                " IPouts, " +
                " HA, " +
                " HRA, " +
                " BBA, " +
                " SOA, " +
                " E, " +
                " DP, " +
                " FP, " +
                " name, " +
                " park, " +
                " attendance, " +
                " BPF, " +
                " PPF, " +
                " teamIDBR, " +
                " teamIDlahman45, " +
                " teamIDretro) " +
                " SELECT * " +
                " FROM teams " +
                " WHERE yearID=?");
        statement.setInt(1, yearID);

        statement.executeUpdate();
    }

    private static void insertPgbsLineUp(Connection conn) throws SQLException, IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ClintR/PerfectGameBaseball/src/main/resources/schedules/GL1913.csv"));
        String line = reader.readLine();
        int playerOrder = 1;
        List<LineUp> lineUpOrder = new ArrayList<>();
        LineUp game = new LineUp();

        while (line != null)
        {
            String[] split = line.split( "," );
            for ( int index = 0; index < split.length; index++ )
            {

                if (index == 105 || index == 108 || index == 111 || index == 114 || index == 117 || index == 120
                        || index == 123 || index == 126 || index == 129 || index == 132 || index == 135
                        || index == 138 || index == 141 || index == 144 || index == 147 || index == 150
                        || index == 153 || index == 156) {
                    game.setRetroID(split[index]);
                }

                if (index == 106 || index == 109 || index == 112 || index == 115 || index == 118 || index == 121
                        || index == 124 || index == 127 || index == 130 || index == 133 || index == 136
                        || index == 139 || index == 142 || index == 145 || index == 148 || index == 151
                        || index == 154 || index == 157) {
                    game.setPlayerName(split[index]);
                }

                if (index == 107 || index == 110 || index == 113 || index == 116 || index == 119 || index == 122
                        || index == 125 || index == 128 || index == 131 || index == 134 || index == 137
                        || index == 140 || index == 143 || index == 146 || index == 149 || index == 152
                        || index == 155 || index == 158) {

                    if (playerOrder < 10)
                    {
                        game.setPlayerOrder(playerOrder);
                        playerOrder++;
                    }
                    if (playerOrder == 10)
                    {
                        playerOrder = 1;
                    }
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                    LocalDate localDate = LocalDate.parse(split[0], formatter);
                    game.setGameDate(localDate);

                    game.setPlayerPosition(split[index]);
                    switch (game.getPlayerPosition()) {
                        case "1":
                            game.setPlayerPosition("P");
                            break;
                        case "2":
                            game.setPlayerPosition("C");
                            break;
                        case "3":
                            game.setPlayerPosition("1B");
                            break;
                        case "4":
                            game.setPlayerPosition("2B");
                            break;
                        case "5":
                            game.setPlayerPosition("3B");
                            break;
                        case "6":
                            game.setPlayerPosition("SS");
                            break;
                        case "7":
                            game.setPlayerPosition("LF");
                            break;
                        case "8":
                            game.setPlayerPosition("CF");
                            break;
                        case "9":
                            game.setPlayerPosition("RF");
                            break;
                    }

                    if (index > 105 && index < 132)
                    {
                        game.setTeamID(split[3]);
                        game.setGameNumber(Integer.parseInt(split[5]));
                    } else if (index > 131 && index < 159)
                    {
                        game.setTeamID(split[6]);
                        game.setGameNumber(Integer.parseInt(split[8]));
                    }
                    game.setLgID(split[7]);
                    lineUpOrder.add(game);
                    game = new LineUp();
                }
            }
            split = null;

            line = reader.readLine();
        }
        System.out.println("Finished creating lineup");

        String query = " insert into pgbs_lineups (gameDate, lgID, teamID, retroID, playerName," +
                " playerPosition, playerOrder, gameNumber) values (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = null;

        try
        {
            preparedStmt = conn.prepareStatement(query);

            for (LineUp gameRow : lineUpOrder)
            {
                preparedStmt.setDate(1, java.sql.Date.valueOf(gameRow.getGameDate()));
                preparedStmt.setString(2, gameRow.getLgID());
                preparedStmt.setString(3, gameRow.getTeamID());
                preparedStmt.setString(4, gameRow.getRetroID());
                preparedStmt.setString(5, gameRow.getPlayerName());
                preparedStmt.setString(6, gameRow.getPlayerPosition());
                preparedStmt.setInt(7, gameRow.getPlayerOrder());
                preparedStmt.setInt(8, gameRow.getGameNumber());
                preparedStmt.executeUpdate();
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
            throw se;
        }
        finally
        {
            preparedStmt.close();
        }

        System.out.println("stop");

    }

    static List<Batter> selectBatters(String teamID, int yearID) throws SQLException,
            InstantiationException, ClassNotFoundException
    {
        Connection conn;

        List<Batter> batters = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_batters " +
                    " where teamID=? " +
                    " and yearID=? " +
                   // " and AB > 10 " +
                    " order by AB desc");
            stmt.setString(1, teamID);
            stmt.setInt(2, yearID);

            ResultSet rs = stmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                Batter batter = new Batter();
                // Retrieve by column name
                batter.setNameFirst(rs.getString("nameFirst"));
                batter.setNameLast(rs.getString("nameLast"));
                // Sets Hands based on bats
                if (Objects.equals(rs.getString("bats"), "R"))
                {
                    batter.setBats(Hands.RIGHT);
                } else if (Objects.equals(rs.getString("bats"), "L"))
                {
                    batter.setBats(Hands.LEFT);
                } else
                {
                    batter.setBats(Hands.BOTH);
                }
                batter.setPlayerId(rs.getString("playerID"));
                batter.getBatterStats().setYearID(rs.getInt("yearID"));
                batter.setStint(rs.getInt("stint"));
                batter.setTeamID(rs.getString("teamID"));
                batter.setLgID(rs.getString("lgID"));
                batter.getBatterStats().setGamesPlayed(rs.getInt("G"));
                batter.getBatterStats().setAtBats(rs.getInt("AB"));
                batter.getBatterStats().setRuns(rs.getInt("R"));
                batter.getBatterStats().setHits(rs.getInt("H"));
                batter.getBatterStats().setDoubles(rs.getInt("2B"));
                batter.getBatterStats().setTriples(rs.getInt("3B"));
                batter.getBatterStats().setHomeRuns(rs.getInt("HR"));
                batter.getBatterStats().setRbi(rs.getInt("RBI"));
                batter.getBatterStats().setStolenBases(rs.getInt("SB"));
                batter.getBatterStats().setCaughtStealing(rs.getInt("CS"));
                batter.getBatterStats().setWalks(rs.getInt("BB"));
                batter.getBatterStats().setStrikeOuts(rs.getInt("SO"));
                batter.getBatterStats().setsGamesPlayed(rs.getInt("sGamesPlayed"));
                batter.getBatterStats().setsGamesStarted(rs.getInt("sGamesStarted"));
                batter.getBatterStats().setsAtBats(rs.getInt("sAtBats"));
                batter.getBatterStats().setsHits(rs.getInt("sHits"));
                batter.getBatterStats().setsRuns(rs.getInt("sRuns"));
                batter.getBatterStats().setsDoubles(rs.getInt("sDoubles"));
                batter.getBatterStats().setsTriples(rs.getInt("sTriples"));
                batter.getBatterStats().setsHomeRuns(rs.getInt("sHomeRuns"));
                batter.getBatterStats().setsRbi(rs.getInt("sRbi"));
                batter.getBatterStats().setsWalks(rs.getInt("sWalks"));
                batter.getBatterStats().setsStrikeOuts(rs.getInt("sStrikeOuts"));
                batter.getBatterStats().setsHitByPitch(rs.getInt("sHitByPitch"));
                batter.getBatterStats().setsPlateAppearances(rs.getInt("sPlateAppearances"));
                batter.getBatterStats().setSacrificeHits(rs.getInt("sSacrificeHits"));
                batter.getBatterStats().setSacrificeFlies(rs.getInt("sSacrificeFlies"));
                batter.getBatterStats().setsStolenBases(rs.getInt("sStolenBases"));
                batter.getBatterStats().setsCaughtStealing(rs.getInt("sCaughtStealing"));
                batter.getBatterStats().setPinchAtBat(rs.getInt("pinchAtBat"));
                batter.getBatterStats().setPinchHit(rs.getInt("pinchHit"));
                batter.getBatterStats().setPinchRbi(rs.getInt("pinchRbi"));
                batter.getBatterStats().setRispAtBat(rs.getInt("rispAtBat"));
                batter.getBatterStats().setRispHit(rs.getInt("rispHit"));
                batter.getBatterStats().setRispRbi(rs.getInt("rispRbi"));
                batter.getBatterStats().setRispSingle(rs.getInt("rispSingle"));
                batter.getBatterStats().setRispDouble(rs.getInt("rispDouble"));
                batter.getBatterStats().setRispTriple(rs.getInt("rispTriple"));
                batter.getBatterStats().setRispHomeRun(rs.getInt("rispHomeRun"));
                batter.getBatterStats().setRispWalk(rs.getInt("rispWalk"));
                batter.getBatterStats().setRispStrikeOut(rs.getInt("rispStrikeOut"));
                batter.getBatterStats().setRispGroundedIntoDp(rs.getInt("rispGroundedIntoDp"));
                batter.getBatterStats().setRispHitByPitch(rs.getInt("rispHitByPitch"));
                batter.getBatterStats().setLeftOnBase(rs.getInt("leftOnBase"));
                batter.setPlayerKey(rs.getInt("playerKey"));

/*                batter.getBatterStats().setIntentionalWalks(Integer.parseInt(rs.getString("IBB")));
                batter.getBatterStats().setHitByPitch(Integer.parseInt(rs.getString("HBP")));
                batter.getBatterStats().setSacrificeHits(Integer.parseInt(rs.getString("SH")));
                batter.getBatterStats().setSacrificeFlies(Integer.parseInt(rs.getString("RS")));
                batter.getBatterStats().setGroundedIntoDp(Integer.parseInt(rs.getString("GIDP")));*/

                batter.getBatterStats().setSpeedRating(rs.getInt("speedRating"));
                batter.getBatterStats().calculateBatterProbabilities();

                batters.add(batter);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return batters;
    }

    static List<Pitcher> selectPitchers(String teamID, int yearID) throws InstantiationException,
            SQLException, ClassNotFoundException
    {
        Connection conn;

        List<Pitcher> pitchers = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_pitchers " +
                    " where teamID=? " +
                    " and yearID=?" +
                    " order by GS desc");
            stmt.setString(1, teamID);
            stmt.setInt(2, yearID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pitcher pitcher = new Pitcher();
                // Retrieve by column name
                pitcher.setNameFirst(rs.getString("nameFirst"));
                pitcher.setNameLast(rs.getString("nameLast"));
                // Sets Hands based on bats
                if (Objects.equals(rs.getString("throws"), "R"))
                {
                    pitcher.setPitchingArm("R");
                } else if (Objects.equals(rs.getString("throws"), "L"))
                {
                    pitcher.setPitchingArm("L");
                }

                pitcher.setPlayerId(rs.getString("playerID"));
                pitcher.setYearID(rs.getInt("yearID"));
                pitcher.setRetroId(rs.getString("retroId"));
                pitcher.setStint(rs.getInt("stint"));
                pitcher.setTeamID(rs.getString("teamID"));
                pitcher.getPitcherStats().setWins(rs.getInt("W"));
                pitcher.getPitcherStats().setLosses(rs.getInt("L"));
                pitcher.getPitcherStats().setGamesPlayed(rs.getInt("G"));
                pitcher.getPitcherStats().setGamesStarted(rs.getInt("GS"));
                pitcher.getPitcherStats().setCompleteGames(rs.getInt("CG"));
                pitcher.getPitcherStats().setShutOuts(rs.getInt("SHO"));
                pitcher.getPitcherStats().setSaves(rs.getInt("SV"));
                pitcher.getPitcherStats().setiPouts(rs.getInt("IPouts"));
                pitcher.getPitcherStats().setHitsAllowed(rs.getInt("H"));
                pitcher.getPitcherStats().setEarnedRuns(rs.getInt("ER"));
                pitcher.getPitcherStats().setHomeRunsAllowed(rs.getInt("HR"));
                pitcher.getPitcherStats().setWalksAllowed(rs.getInt("BB"));
                pitcher.getPitcherStats().setStrikeOutsAllowed(rs.getInt("SO"));
                pitcher.getPitcherStats().setEra(rs.getInt("ERA"));
                pitcher.getPitcherStats().setsGamesPlayed(rs.getInt("sGamesPlayed"));
                pitcher.getPitcherStats().setsGamesStarted(rs.getInt("sGamesStarted"));
                pitcher.getPitcherStats().setsBattersFaced(rs.getInt("sBattersFaced"));
                pitcher.getPitcherStats().setsHitsAllowed(rs.getInt("sHitsAllowed"));
                pitcher.getPitcherStats().setsHitBatters(rs.getInt("sHitBatters"));
                pitcher.getPitcherStats().setsHitsAllowed(rs.getInt("sHitsAllowed"));
                pitcher.getPitcherStats().setsEarnedRuns(rs.getInt("sEarnedRuns"));
                pitcher.getPitcherStats().setsRunsAllowed(rs.getInt("sRunsAllowed"));
                pitcher.getPitcherStats().setsStrikeOutAllowed(rs.getInt("sStrikeOutsAllowed"));
                pitcher.getPitcherStats().setsWalksAllowed(rs.getInt("sWalksAllowed"));
                pitcher.getPitcherStats().setsHomeRunsAllowed(rs.getInt("sHomeRunsAllowed"));
                pitcher.getPitcherStats().setsInningsPitchedOuts(rs.getInt("sInningsPitchedOuts"));
                pitcher.getPitcherStats().setsShutOuts(rs.getInt("sShutOuts"));
                pitcher.getPitcherStats().setsCompleteGames(rs.getInt("sCompleteGames"));
                pitcher.getPitcherStats().setsWins(rs.getInt("sWins"));
                pitcher.getPitcherStats().setsLosses(rs.getInt("sLosses"));
                pitcher.getPitcherStats().setsSaves(rs.getInt("sSaves"));
                if (Objects.equals(rs.getString("IBB"), ""))
                {
                    pitcher.getPitcherStats().setIntentionalWalksAllowed(0);
                } else
                {
                    pitcher.getPitcherStats().setIntentionalWalksAllowed(Integer.parseInt(rs.getString("IBB")));
                }
                if (Objects.equals(rs.getString("WP"), ""))
                {
                    pitcher.getPitcherStats().setWildPitches(0);
                } else
                {
                    pitcher.getPitcherStats().setWildPitches(Integer.parseInt(rs.getString("WP")));
                }
                if (Objects.equals(rs.getString("HBP"), ""))
                {
                    pitcher.getPitcherStats().setHitBatters(0);
                } else
                {
                    pitcher.getPitcherStats().setHitBatters(Integer.parseInt(rs.getString("HBP")));
                }
                pitcher.getPitcherStats().setBalks(rs.getInt("BK"));
                if (Objects.equals(rs.getString("BFP"), ""))
                {
                    pitcher.getPitcherStats().setBattersFaced(0);
                } else
                {
                    pitcher.getPitcherStats().setBattersFaced(Integer.parseInt(rs.getString("BFP")));
                }
                if (Objects.equals(rs.getString("GF"), ""))
                {
                    pitcher.getPitcherStats().setGamesFinished(0);
                } else
                {
                    pitcher.getPitcherStats().setGamesFinished(Integer.parseInt(rs.getString("GF")));
                }
                pitcher.getPitcherStats().setRuns(rs.getInt("R"));
                if (Objects.equals(rs.getString("SH"), ""))
                {
                    pitcher.getPitcherStats().setSacrificeFlies(0);
                } else
                {
                    pitcher.getPitcherStats().setSacrificeFlies(Integer.parseInt(rs.getString("SF")));
                }
                if (Objects.equals(rs.getString("SF"), ""))
                {
                    pitcher.getPitcherStats().setSacrificeFlies(0);
                } else
                {
                    pitcher.getPitcherStats().setSacrificeFlies(Integer.parseInt(rs.getString("SF")));
                }
                if (Objects.equals(rs.getString("GIDP"), ""))
                {
                    pitcher.getPitcherStats().setGroundedIntoDoublePlays(0);
                } else {
                    pitcher.getPitcherStats().setGroundedIntoDoublePlays(Integer.parseInt(rs.getString("GIDP")));
                }

                pitcher.setPlayerKey(rs.getInt("playerKey"));
                pitcher.getPitcherStats().calculatePitcherProbabilities();
                pitchers.add(pitcher);
            }
            rs.close();
            stmt.close();
            conn.close();

            for (Pitcher hurler : pitchers)
            {
                if (hurler.getPitcherStats().getSaves() > 10)
                {
                    hurler.setPitcherRole(PitcherRole.CLOSER);
                } else if (hurler.getPitcherStats().getGamesStarted() > 5)
                {
                    hurler.setPitcherRole(PitcherRole.STARTER);
                } else
                {
                    hurler.setPitcherRole(PitcherRole.RELIEVER);
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return pitchers;
    }

    static List<Fielder> selectFielders(String teamID, int yearID) throws InstantiationException,
            SQLException, ClassNotFoundException
    {
        Connection conn;

        List<Fielder> fielders = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_fielders " +
                    " where teamID=? " +
                    " and yearID=?" +
                    " order by G desc");
            stmt.setString(1, teamID);
            stmt.setInt(2, yearID);

            ResultSet rs = stmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                Fielder fielder = new Fielder();
                // Retrieve by column name
                fielder.setNameFirst(rs.getString("nameFirst"));
                fielder.setNameLast(rs.getString("nameLast"));
                fielder.setRetroId(rs.getString("retroID"));
                fielder.setTeamID(rs.getString("teamID"));
                fielder.setPlayerId(rs.getString("playerID"));
                fielder.setYearID(rs.getInt("yearID"));
                fielder.getFielderStats().setGamesPlayed(rs.getInt("G"));
                if (Objects.equals(rs.getString("GS"), ""))
                {
                    fielder.getFielderStats().setGamesStarted(0);
                } else
                {
                    fielder.getFielderStats().setGamesStarted(Integer.parseInt(rs.getString("GS")));

                }
                if (Objects.equals(rs.getString("innOuts"), ""))
                {
                    fielder.getFielderStats().setInningOuts(0);
                } else
                {
                    fielder.getFielderStats().setInningOuts(Integer.parseInt(rs.getString("innOuts")));

                }
                fielder.getFielderStats().setPutOuts(rs.getInt("PO"));
                fielder.getFielderStats().setAssists(rs.getInt("A"));
                fielder.getFielderStats().setErrors(rs.getInt("E"));
                fielder.getFielderStats().setDoublePlays(rs.getInt("DP"));
                fielder.getFielderStats().setsGamesPlayed(rs.getInt("sGamesPlayed"));
                fielder.getFielderStats().setsGamesStarted(rs.getInt("sGamesStarted"));
                fielder.getFielderStats().setsErrors(rs.getInt("sErrors"));
                fielder.getFielderStats().setsAssists(rs.getInt("sAssists"));
                fielder.getFielderStats().setsPutOuts(rs.getInt("sPutOuts"));
                fielder.getFielderStats().setsRunnersSuccessful(rs.getInt("sRunnersSuccessful"));
                fielder.getFielderStats().setsRunnersThrownOut(rs.getInt("sRunnersThrownOut"));
                if (Objects.equals(rs.getString("PB"), ""))
                {
                    fielder.getFielderStats().setPassedBalls(0);
                } else
                {
                    fielder.getFielderStats().setPassedBalls(Integer.parseInt(rs.getString("PB")));

                }
                if (Objects.equals(rs.getString("WP"), ""))
                {
                    fielder.getFielderStats().setWildPitches(0);
                } else
                {
                    fielder.getFielderStats().setWildPitches(Integer.parseInt(rs.getString("WP")));

                }
                if (Objects.equals(rs.getString("SB"), ""))
                {
                    fielder.getFielderStats().setStolenBases(0);
                } else
                {
                    fielder.getFielderStats().setStolenBases(Integer.parseInt(rs.getString("SB")));

                }
                if (Objects.equals(rs.getString("CS"), ""))
                {
                    fielder.getFielderStats().setCaughtStealing(0);
                } else
                {
                    fielder.getFielderStats().setCaughtStealing(Integer.parseInt(rs.getString("CS")));

                }
                if (Objects.equals(rs.getString("ZR"), ""))
                {
                    fielder.getFielderStats().setZoneRating(0);
                } else
                {
                    fielder.getFielderStats().setZoneRating(Integer.parseInt(rs.getString("ZR")));

                }
                fielder.setPlayerKey(rs.getInt("playerKey"));

                fielder.setPosition(InPlayPosition.get(rs.getString("POS")));
                fielder.setAvailable(true);

                fielders.add(fielder);

            }
            rs.close();
            conn.close();
            stmt.close();

            } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return fielders;
    }

    static Schedule selectSchedule(int yearID, String lgID) throws InstantiationException, SQLException,
            ClassNotFoundException
    {
        Connection conn;
        Schedule schedule = new Schedule();
        List<Schedule> scheduleList = new ArrayList<>();

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * FROM pgbs_schedule" +
                    " where gameCompleted='N' and homeLgId='AL' " +
                    " order by gameKey " +
                    " limit 1");
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                schedule = new Schedule();
                Date date = rs.getDate("gameDate");
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                String text = df.format(date);
                LocalDate gameDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyyMMdd"));
                schedule.setGameDate(gameDate);
                schedule.setGameNumber(Integer.parseInt(rs.getString("gameNumber")));
                schedule.setGameDay(rs.getString("gameDay"));
                schedule.setVisitingTeamId(rs.getString("visitingTeamId"));
                schedule.setVisitingLgId(rs.getString("visitingLgId"));
                schedule.setVisitingGameNumber(rs.getInt("visitingGameNumber"));
                schedule.setHomeTeamId(rs.getString("homeTeamId"));
                schedule.setHomeLgId(rs.getString("homeLgId"));
                schedule.setHomeGameNumber(rs.getInt("homeGameNumber"));
                schedule.setVisitingScore(rs.getInt("visitingScore"));
                schedule.setHomeScore(rs.getInt("homeScore"));
                schedule.setLengthOuts(rs.getString("lengthOuts"));
                schedule.setDayNight(rs.getString("dayNight"));
                schedule.setCompletionInfo(rs.getString("completionInfo"));
                schedule.setForfeitInfo(rs.getString("forfeitInfo"));
                schedule.setParkId(rs.getString("parkId"));
                schedule.setAttendance(rs.getInt("attendance"));
                schedule.setTimeInMinutes(rs.getInt("timeInMinutes"));
                schedule.setVisitingLineScore(rs.getString("visitingLineScore"));
                schedule.setHomeLineScore(rs.getString("homeLineScore"));
                schedule.setHomePlateUmpireId(rs.getString("homePlateUmpireId"));
                schedule.setHomePlateUmpireName(rs.getString("homePlateUmpireName"));
                schedule.setFirstBaseUmpireId(rs.getString("firstBaseUmpireId"));
                schedule.setFirstBaseUmpireName(rs.getString("firstBaseUmpireName"));
                schedule.setSecondBaseUmpireId(rs.getString("secondBaseUmpireId"));
                schedule.setSecondBaseUmpireName(rs.getString("secondBaseUmpireName"));
                schedule.setThirdBaseUmpireId(rs.getString("thirdBaseUmpireId"));
                schedule.setThirdBaseUmpireName(rs.getString("thirdBaseUmpireName"));
                schedule.setLeftFieldUmpireId(rs.getString("leftFieldUmpireId"));
                schedule.setLeftFieldUmpireName(rs.getString("leftFieldUmpireName"));
                schedule.setRightFieldUmpireId(rs.getString("rightFieldUmpireId"));
                schedule.setRightFieldUmpireName(rs.getString("rightFieldUmpireName"));
                schedule.setVisitingManagerId(rs.getString("visitingManagerId"));
                schedule.setVisitingManagerName(rs.getString("visitingManagerName"));
                schedule.setHomeManagerId(rs.getString("homeManagerId"));
                schedule.setHomeManagerName(rs.getString("homeManagerName"));
                schedule.setWinningPitcherId(rs.getString("winningPitcherId"));
                schedule.setWinningPitcherName(rs.getString("winningPitcherName"));
                schedule.setLosingPitcherId(rs.getString("losingPitcherId"));
                schedule.setLosingPitcherName(rs.getString("losingPitcherName"));
                schedule.setSavingPitcherId(rs.getString("savingPitcherId"));
                schedule.setSavingPitcherName(rs.getString("savingPitcherName"));
                schedule.setVisitingStartingPitcherId(rs.getString("visitingStartingPitcherId"));
                schedule.setVisitingStartingPitcherName(rs.getString("visitingStartingPitcherName"));
                schedule.setHomeStartingPitcherId(rs.getString("homeStartingPitcherId"));
                schedule.setHomeStartingPitcherName(rs.getString("homeStartingPitcherName"));
                schedule.setAdditionalInfo(rs.getString("additionalInfo"));
                schedule.setAcquisitionInfo(rs.getString("acquisitionInfo"));
                schedule.setGameCompleted(rs.getString("gameCompleted"));
                schedule.setGameKey(rs.getInt("gameKey"));
                //return schedule;
                //scheduleList.add(schedule);
            }
            rs.close();
            conn.close();
            stmt.close();

        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return schedule;
    }

    static League selectTeamStats(int yearID, String lgID, League league) throws InstantiationException, SQLException,
            ClassNotFoundException
    {
        Connection conn;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT sum(AB) as abcnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int teamAb = rs.getInt("abcnt");
                league.getLeagueStats().setAtBats(teamAb);
            }

            stmt = conn.prepareStatement("SELECT sum(H) as hcnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            rs = stmt.executeQuery();

            while(rs.next()) {
                int teamHits = rs.getInt("hcnt");
                league.getLeagueStats().setHits(teamHits);
            }

            stmt = conn.prepareStatement("SELECT sum(2B) as dbcnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            rs = stmt.executeQuery();

            while(rs.next()) {
                int teamDoubles = rs.getInt("dbcnt");
                league.getLeagueStats().setDoubles(teamDoubles);

            }

            stmt = conn.prepareStatement("SELECT sum(3B) as tcnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            rs = stmt.executeQuery();

            while(rs.next()) {
                int teamTriples = rs.getInt("tcnt");

                league.getLeagueStats().setTriples(teamTriples);
            }

            stmt = conn.prepareStatement("SELECT sum(HR) as hrcnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            rs = stmt.executeQuery();

            while(rs.next()) {
                int teamHr = rs.getInt("hrcnt");

                league.getLeagueStats().setHomeRuns(teamHr);
            }

            stmt = conn.prepareStatement("SELECT sum(BB) as bbcnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            rs = stmt.executeQuery();

            while(rs.next()) {
                int teamBb = rs.getInt("bbcnt");

                league.getLeagueStats().setWalks(teamBb);
            }

            stmt = conn.prepareStatement("SELECT sum(SO) as socnt from teams" +
                    " where yearID=? and lgID=?");
            stmt.setInt(1, yearID);
            stmt.setString(2, lgID);

            rs = stmt.executeQuery();

            while(rs.next()) {
                int teamSo = rs.getInt("socnt");

                league.getLeagueStats().setStrikeOuts(teamSo);
            }
            rs.close();
            stmt.close();
            conn.close();

            double leagueSingles = league.getLeagueStats().getHits() - league.getLeagueStats().getDoubles() -
                    league.getLeagueStats().getTriples() - league.getLeagueStats().getHomeRuns();

            league.getLeagueStats().setSingles(leagueSingles);
            league.getLeagueStats().setSinglePercentage(league.getLeagueStats().getSingles() / league.getLeagueStats().getAtBats());
            league.getLeagueStats().setDoublePercentage(league.getLeagueStats().getDoubles() / league.getLeagueStats().getAtBats());
            league.getLeagueStats().setTriplePercentage(league.getLeagueStats().getTriples() / league.getLeagueStats().getAtBats());
            league.getLeagueStats().setHomeRunPercentage(league.getLeagueStats().getHomeRuns() / league.getLeagueStats().getAtBats());
            league.getLeagueStats().setWalkPercentage(league.getLeagueStats().getWalks() / league.getLeagueStats().getAtBats());
            league.getLeagueStats().setStrikeOutPercentage(league.getLeagueStats().getStrikeOuts() / league.getLeagueStats().getAtBats());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return league;
    }

    static List<LineUp> selectStartingFielders (String teamID, LocalDate gameDate, int gameNumber) throws SQLException,
            InstantiationException, ClassNotFoundException
    {
        Connection conn;

        List<LineUp> lineUp = new ArrayList<>();

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt;
            stmt = conn.prepareStatement("SELECT * from pgbs_lineups " +
                    " where teamID=? " +
                    " and gameDate=? " +
                    " and gameNumber=?");
            stmt.setString(1, teamID);
            stmt.setDate(2, java.sql.Date.valueOf(gameDate));
            stmt.setInt(3, gameNumber);

            ResultSet rs = stmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                LineUp starter = new LineUp();
                // Retrieve by column name
                starter.setGameDate(rs.getDate("gameDate"));
                starter.setLgID(rs.getString("lgID"));
                starter.setTeamID(rs.getString("teamID"));
                starter.setRetroID(rs.getString("retroID"));
                starter.setPlayerName(rs.getString("playerName"));
                starter.setPlayerPosition(rs.getString("playerPosition"));
                starter.setPlayerOrder(rs.getInt("playerOrder"));
                starter.setGameNumber(rs.getInt("gameNumber"));
                lineUp.add(starter);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return lineUp;
    }

    void updateBatters(List<Batter> batterList) throws SQLException, InstantiationException, ClassNotFoundException,
            IllegalAccessException {
        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/lahman2016";

        // Database credentials
        String USER = "root";
        String PASS = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute query
            //TODO need to add in a sGamesStarted - also in create
            String query = "UPDATE pgbs_batters set sGamesPlayed = ?,  sAtBats = ?, sHits = ?, sRuns = ?, sDoubles = ?," +
                    " sTriples = ?, sHomeRuns = ?, sRbi = ?, sWalks = ?, sStrikeOuts = ?, sHitByPitch = ?, " +
                    " sPlateAppearances = ?, sSacrificeHits = ?, sSacrificeFlies = ?, sStolenBases = ?, sCaughtStealing = ?, " +
                    " rispAtBat = ?, rispHit = ?, rispRbi = ?, " +
                    " rispSingle = ?, rispDouble = ?, rispTriple = ?, rispHomeRun = ?, rispWalk = ?, rispStrikeOut = ?, " +
                    " rispGroundedIntoDp = ?, leftOnBase = ? where yearID = ? and playerID = ?";

            for (Batter batter : batterList)
            {
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, batter.getBatterStats().getsGamesPlayed());
                statement.setInt(2, batter.getBatterStats().getsAtBats());
                statement.setInt(3, batter.getBatterStats().getsHits());
                statement.setInt(4, batter.getBatterStats().getsRuns());
                statement.setInt(5, batter.getBatterStats().getsDoubles());
                statement.setInt(6, batter.getBatterStats().getsTriples());
                statement.setInt(7, batter.getBatterStats().getsHomeRuns());
                statement.setInt(8, batter.getBatterStats().getsRbi());
                statement.setInt(9, batter.getBatterStats().getsWalks());
                statement.setInt(10, batter.getBatterStats().getsStrikeOuts());
                statement.setInt(11, batter.getBatterStats().getsHitByPitch());
                statement.setInt(12, batter.getBatterStats().getsPlateAppearances());
                statement.setInt(13, batter.getBatterStats().getsSacrificeHits());
                statement.setInt(14, batter.getBatterStats().getsSacrificeFlies());
                statement.setInt(15, batter.getBatterStats().getsStolenBases());
                statement.setInt(16, batter.getBatterStats().getsCaughtStealing());
                //TODO Need to add in pinch hit stats
                statement.setInt(17, batter.getBatterStats().getRispAtBat());
                statement.setInt(18, batter.getBatterStats().getRispHit());
                statement.setInt(19, batter.getBatterStats().getRispRbi());
                statement.setInt(20, batter.getBatterStats().getRispSingle());
                statement.setInt(21, batter.getBatterStats().getRispDouble());
                statement.setInt(22, batter.getBatterStats().getRispTriple());
                statement.setInt(23, batter.getBatterStats().getRispHomeRun());
                statement.setInt(24, batter.getBatterStats().getRispWalk());
                statement.setInt(25, batter.getBatterStats().getRispStrikeOut());
                statement.setInt(26, batter.getBatterStats().getRispGroundedIntoDp());
                //TODO Need to add in risp HBP
                statement.setInt(27, batter.getBatterStats().getLeftOnBase());
                statement.setInt(28, batter.getBatterStats().getYearID());
                statement.setString(29, batter.getPlayerId());

                statement.executeUpdate();
            }

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    void updatePitchers(List<Pitcher> pitcherList) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/lahman2016";

        // Database credentials
        String USER = "root";
        String PASS = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute query
            String query = "UPDATE pgbs_pitchers set sGamesPlayed = ?,  sGamesStarted = ?, sBattersFaced = ?, " +
                    " sHitsAllowed = ?, sHitBatters = ?, sEarnedRuns = ?, sRunsAllowed = ?, sStrikeOutsAllowed = ?, " +
                    " sWalksAllowed = ?, sHomeRunsAllowed = ?, sInningsPitchedOuts = ?, sShutOuts = ?, sCompleteGames = ?," +
                    " sWins = ?, " +
                    " sLosses = ?, sSaves = ? where yearID = ? and playerID = ?";

            for (Pitcher pitcher : pitcherList)
            {
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, pitcher.getPitcherStats().getsGamesPlayed());
                statement.setInt(2, pitcher.getPitcherStats().getsGamesStarted());
                statement.setInt(3, pitcher.getPitcherStats().getsBattersFaced());
                statement.setInt(4, pitcher.getPitcherStats().getsHitsAllowed());
                statement.setInt(5, pitcher.getPitcherStats().getsHitBatters());
                statement.setInt(6, pitcher.getPitcherStats().getsEarnedRuns());
                statement.setInt(7, pitcher.getPitcherStats().getsRunsAllowed());
                statement.setInt(8, pitcher.getPitcherStats().getsStrikeOutAllowed());
                statement.setInt(9, pitcher.getPitcherStats().getsWalksAllowed());
                statement.setInt(10, pitcher.getPitcherStats().getsHomeRunsAllowed());
                statement.setInt(11, pitcher.getPitcherStats().getsInningsPitchedOuts());
                statement.setInt(12, pitcher.getPitcherStats().getsShutOuts());
                statement.setInt(13, pitcher.getPitcherStats().getsCompleteGames());
                statement.setInt(14, pitcher.getPitcherStats().getsWins());
                statement.setInt(15, pitcher.getPitcherStats().getsLosses());
                statement.setInt(16, pitcher.getPitcherStats().getsSaves());
                statement.setInt(17, pitcher.getYearID());
                statement.setString(18, pitcher.getPlayerId());

                statement.executeUpdate();
            }

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    void updateFielders(List<Fielder> fielderList) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/lahman2016";

        // Database credentials
        String USER = "root";
        String PASS = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute query
            String query = "UPDATE pgbs_fielders set sGamesPlayed = ?, sGamesStarted = ?, sErrors = ?,  sAssists = ?, sPutOuts = ?, " +
                    " sRunnersThrownOut = ?, sRunnersSuccessful = ? where yearID = ? and playerID = ?";

            for (Fielder fielder : fielderList)
            {
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, fielder.getFielderStats().getsGamesPlayed());
                statement.setInt(2, fielder.getFielderStats().getsGamesStarted());
                statement.setInt(3, fielder.getFielderStats().getsErrors());
                statement.setInt(4, fielder.getFielderStats().getsAssists());
                statement.setInt(5, fielder.getFielderStats().getsPutOuts());
                statement.setInt(6, fielder.getFielderStats().getsRunnersThrownOut());
                statement.setInt(7, fielder.getFielderStats().getsRunnersSuccessful());
                statement.setInt(8, fielder.getYearID());
                statement.setString(9, fielder.getPlayerId());

                statement.executeUpdate();
            }

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}





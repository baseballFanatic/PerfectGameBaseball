package Baseball;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/lahman2016";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute query
            stmt = conn.createStatement();
            createPgbsBatters(stmt);
            createPgbsPitchers(stmt);
            createPgbsFielders(stmt);
            createPgbsSeasons(stmt);
            createPgbsTeams(stmt);

            int yearID = 1927;
            String lgID="AL";
            insertPgbsBatters(conn, yearID);
            insertPgbsPitchers(conn, yearID);
            insertPgbsFielders(conn, yearID);
            insertPgbsTeams(conn, yearID);
//            insertPgbsSeasons(conn, yearID);

            // Clean-up environment
            //rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                try {
                    if (conn != null)
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
                " GIDP varchar(255)," +
                " sBattersFaced int(11)," +
                " sHitsAllowed int(11)," +
                " sHitBatters int(11)," +
                " sEarnedRuns int(11)," +
                " sRunsAllowed int(11)," +
                " sStrikeOutsAllowed int(11)," +
                " sWalksAllowed int(11)," +
                " sHomeRunsAllowed int(11)," +
                " sInningsPitchedOuts int(11)," +
                " simName varchar(255)," +
                " playerKey int(11) not null auto_increment primary key)";

        stmt.executeUpdate(pitchers);
    }

    private static void createPgbsFielders(Statement stmt) throws SQLException {
        String fielders;
        fielders = "CREATE TABLE pgbs_fielders" +
                "( nameFirst varchar(255), " +
                " nameLast varchar(255), " +
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
                "nl1Silver varchar(255)," +
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

    private static void insertPgbsBatters(Connection conn, int yearID) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("insert into pgbs_batters (nameFirst," +
                " nameLast," +
                "    bats," +
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
                " select m.nameFirst, m.nameLast, m.bats, b.* " +
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
                " f.* " +
                " FROM fielding as f " +
                " JOIN master as m on f.playerID = m.playerID " +
                " WHERE f.yearID=?");
        statement.setInt(1, yearID);
        statement.executeUpdate();
    }

    private static void insertPgbsSeasons(Connection conn, int yearID) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO pgbs_seasons " +
                " (yearID=?, " +
                " alEastChamp=?, " +
                " alCentralChamp=?, " +
                " alWestChamp=?, " +
                " alWildCard=?, " +
                " alDivisionSeries1=?, " +
                " alDivisionSeries2=?, " +
                " alChampion=?, " +
                " alMvp=?, " +
                " alCyYoung=?, " +
                " nlEastChamp=?, " +
                " nlCentralChamp=?, " +
                " nlWestChamp=?, " +
                " nlWildCard=?, " +
                " nlDivisionSeries1=?, " +
                " nlDivisionsSeries2=?, " +
                " nlChampion=?, " +
                " nlMvp=?, " +
                " nlCyYoung=?, " +
                " worldSeriesChamp=?, " +
                " al1bSilver=?, " +
                " al2bSilver=?, " +
                " al3bSilver=?," +
                " alSsSilver=?, " +
                " alCsilver=?, " +
                " alDhSilver=?, " +
                " alLfSilver=?," +
                " alCfSilver=?, " +
                " alRfSilver=?," +
                " nl1bSilver=?, " +
                " nl2bSilver=?, " +
                " nl3bSilver=?, " +
                " nlSsSilver=?, " +
                " nlCsilver=?, " +
                " nlPsilver=?, " +
                " nlLfSilver=?, " +
                " nlCfSilver=?, " +
                " nlRfSilver=?, " +
                " simName=?')");
        statement.setInt(1, yearID);
        statement.setString(2, "NONE");
        statement.setString(3, "NONE");
        statement.setString(4, "NONE");
        statement.setString(5, "NONE");
        statement.setString(6, "NONE");
        statement.setString(7, "NONE");
        statement.setString(8, "NONE");
        statement.setString(9, "NONE");
        statement.setString(10, "NONE");
        statement.setString(11, "NONE");
        statement.setString(12, "NONE");
        statement.setString(13, "NONE");
        statement.setString(14, "NONE");
        statement.setString(15, "NONE");
        statement.setString(16, "NONE");
        statement.setString(17, "NONE");
        statement.setString(18, "NONE");
        statement.setString(19, "NONE");
        statement.setString(20, "NONE");
        statement.setString(21, "NONE");
        statement.setString(22, "NONE");
        statement.setString(23, "NONE");
        statement.setString(24, "NONE");
        statement.setString(25, "NONE");
        statement.setString(26, "NONE");
        statement.setString(27, "NONE");
        statement.setString(28, "NONE");
        statement.setString(29, "NONE");
        statement.setString(30, "NONE");
        statement.setString(31, "NONE");
        statement.setString(32, "NONE");
        statement.setString(33, "NONE");
        statement.setString(34, "NONE");
        statement.setString(35, "NONE");
        statement.setString(36, "NONE");
        statement.setString(37, "NONE");
        statement.setString(38, "NONE");
        statement.setString(39, "clint");
        statement.executeUpdate();
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

    static List<Batter> selectBatters(String teamID, int yearID, Batter batter) throws SQLException,
            InstantiationException, ClassNotFoundException
    {
        Connection conn = null;

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
                    " and AB > 10" +
                    " order by AB desc");
            stmt.setString(1, teamID);
            stmt.setInt(2, yearID);

            ResultSet rs = stmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                batter = new Batter();
                // Retrieve by column name
                batter.setNameFirst(rs.getString("nameFirst"));
                batter.setNameLast(rs.getString("nameLast"));
                // Sets Hands based on bats
                if (rs.getString("bats") == "R")
                {
                    batter.setBats(Hands.RIGHT);
                } else if (rs.getString("bats") == "L")
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
                batter.setPlayerKey(rs.getInt("playerKey"));

/*                batter.getBatterStats().setIntentionalWalks(Integer.parseInt(rs.getString("IBB")));
                batter.getBatterStats().setHitByPitch(Integer.parseInt(rs.getString("HBP")));
                batter.getBatterStats().setSacrificeHits(Integer.parseInt(rs.getString("SH")));
                batter.getBatterStats().setSacrificeFlies(Integer.parseInt(rs.getString("RS")));
                batter.getBatterStats().setGroundedIntoDp(Integer.parseInt(rs.getString("GIDP")));*/

                batter.getBatterStats().setSpeedRating(7);
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

    static List<Pitcher> selectPitchers(String teamID, int yearID, Pitcher pitcher) throws InstantiationException,
            SQLException, ClassNotFoundException
    {
        Connection conn = null;

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
                    " order by IPouts desc");
            stmt.setString(1, teamID);
            stmt.setInt(2, yearID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                pitcher = new Pitcher();
                // Retrieve by column name
                pitcher.setNameFirst(rs.getString("nameFirst"));
                pitcher.setNameLast(rs.getString("nameLast"));
                // Sets Hands based on bats
                if (rs.getString("throws") == "R")
                {
                    pitcher.setPitchingArm("R");
                } else if (rs.getString("throws") == "L")
                {
                    pitcher.setPitchingArm("L");
                }

                pitcher.setPlayerId(rs.getString("playerID"));
                pitcher.setYearID(rs.getInt("yearID"));
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

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return pitchers;
    }

    static List<Fielder> selectFielders(String teamID, int yearID, Fielder fielder) throws InstantiationException,
            SQLException, ClassNotFoundException
    {
        Connection conn = null;

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
                fielder = new Fielder();
                // Retrieve by column name
                fielder.setNameFirst(rs.getString("nameFirst"));
                fielder.setNameLast(rs.getString("nameLast"));
                fielder.setTeamID(rs.getString("teamID"));
                fielder.setPlayerId(rs.getString("playerID"));
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

    static League selectTeamStats(int yearID, String lgID, League league) throws InstantiationException, SQLException,
            ClassNotFoundException
    {
        Connection conn = null;
       // String lgID="AL";

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
}


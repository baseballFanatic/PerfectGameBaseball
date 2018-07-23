package Baseball.repositories;

import Baseball.BoxScore;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoxScoreDaoImpl implements BoxScoreDao
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lahman2016?useSSL=false";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public List<BoxScore> getBoxScoreByYearIdByGameKeyByTeamID( int yearID, int gameKey, String teamID )
    {
        Connection connection;

        List<BoxScore> boxScores = new ArrayList<>(  );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            connection = DriverManager.getConnection( DB_URL, USER, PASS );

            PreparedStatement statement;
            statement = connection.prepareStatement( "SELECT * " +
                    "FROM pgbs_box_score WHERE yearID = ? and gameKey = ? and teamID = ? " +
                    "ORDER BY battingOrder ASC" );
            statement.setInt( 1, yearID );
            statement.setInt( 2, gameKey );
            statement.setString( 3, teamID );

            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() )
            {
                BoxScore boxScore = new BoxScore();

                boxScore.setGameKey( resultSet.getInt( "gameKey" ) );
                boxScore.setGameStarted( resultSet.getInt( "gameStarted" ) );
                boxScore.setGamePlayed( resultSet.getInt( "gamePlayed" ) );
                boxScore.setTeamID( resultSet.getString( "teamID" ) );
                boxScore.setNameFirst( resultSet.getString( "nameFirst" ) );
                boxScore.setGameAtBats( resultSet.getInt( "gameAtBats" ) );
                boxScore.setGameHits( resultSet.getInt( "gameHits" ) );
                boxScore.setNameLast( resultSet.getString( "nameLast" ) );
                boxScore.setGameRuns( resultSet.getInt( "gameRuns" ) );
                boxScore.setGameRbi( resultSet.getInt( "gameRbi" ) );
                boxScore.setGameStolenBases( resultSet.getInt( "gameStolenBases" ) );
                boxScore.setGameCaughtStealing( resultSet.getInt( "gameCaughtStealing" ) );
                boxScore.setGameErrors( resultSet.getInt( "gameErrors" ) );
                boxScore.setGamePutOuts( resultSet.getInt( "gamePutOuts" ) );
                boxScore.setGameAssists( resultSet.getInt( "gameAssists" ) );
                boxScore.setGameDoubles( resultSet.getInt( "gameDoubles" ) );
                boxScore.setGameTriples( resultSet.getInt( "gameTriples" ) );
                boxScore.setGameHomeRuns( resultSet.getInt( "gameHomeRuns" ) );
                boxScore.setGameWalks( resultSet.getInt( "gameWalks" ) );
                boxScore.setGameStrikeOuts( resultSet.getInt( "gameStrikeOuts" ));
                boxScore.setGameGdp( resultSet.getInt( "gameGdp" ) );
                boxScore.setGameSacFly( resultSet.getInt( "gameSacFly" ) );
                boxScore.setGameHitByPitch( resultSet.getInt( "gameHitByPitch" ) );
                boxScore.setGameHitsAllowed( resultSet.getInt( "gameHitsAllowed" ) );
                boxScore.setGameWalksAllowed( resultSet.getInt( "gameWalksAllowed" ) );
                boxScore.setGameRunsAllowed( resultSet.getInt( "gameRunsAllowed" ) );
                boxScore.setGameUnearnedRunsAllowed( resultSet.getInt( "gameUnearnedRunsAllowed" ) );
                boxScore.setGameHomeRunsAllowed( resultSet.getInt( "gameHomeRunsAllowed" ) );
                boxScore.setGameHitBatters( resultSet.getInt( "gameHitBatters" ) );
                boxScore.setGameInningsPitched( resultSet.getDouble( "gameInningsPitched" ) );
                boxScore.setGameStrikeOutsAllowed( resultSet.getInt( "gameStrikeOutsAllowed" ) );
                boxScore.setGameBatterOuts( resultSet.getInt( "gameBatterOuts" ) );
                boxScore.setGameWin( resultSet.getInt( "gameWin" ) );
                boxScore.setGameLoss( resultSet.getInt( "gameLoss" ) );
                boxScore.setGameSave( resultSet.getInt( "gameSave" ) );
                boxScore.setGameShutOut( resultSet.getInt( "gameShutOut" ) );
                boxScore.setGameCompleteGame( resultSet.getInt( "gameCompleteGame" ) );
                boxScore.setGameDoublePlaysStarted( resultSet.getInt( "gameDoublePlaysStarted" ) );
                boxScore.setGameCatcherRunnersThrownOut( resultSet.getInt( "gameCatcherRunnersThrownOut" ) );
                boxScore.setGameCatcherRunnersSuccessful( resultSet.getInt( "gameCatcherRunnersSuccessful" ) );
                boxScore.setGameRispAtBat( resultSet.getInt( "gameRispAtBat" ) );
                boxScore.setGameRispHit( resultSet.getInt( "gameRispHit" ) );
                boxScore.setGameRispRbi( resultSet.getInt( "gameRispRbi" ) );
                boxScore.setGameRispSingle( resultSet.getInt( "gameRispSingle" ) );
                boxScore.setGameRispDouble( resultSet.getInt( "gameRispDouble" ) );
                boxScore.setGameRispTriple( resultSet.getInt( "gameRispTriple" ) );
                boxScore.setGameRispHomeRun( resultSet.getInt( "gameRispHomeRun" ) );
                boxScore.setGameRispGdp( resultSet.getInt( "gameRispGdp" ) );
                boxScore.setGameRispWalk( resultSet.getInt( "gameRispWalk" ) );
                boxScore.setGameRispStrikeOut( resultSet.getInt( "gameRispStrikeOut" ) );
                boxScore.setGameRispHitByPitch( resultSet.getInt( "gameRispHitByPitch" ) );
                boxScore.setGameLeftOnBase( resultSet.getInt( "gameLeftOnBase" ) );
                boxScore.setGamePinchAtBat( resultSet.getInt( "gamePinchAtBat" ) );
                boxScore.setGamePinchHitHit( resultSet.getInt( "gamePinchHitHit" ) );
                boxScore.setGamePinchHitRbi( resultSet.getInt( "gamePinchHitRbi" ) );
                boxScore.setGamePinchHitSingle( resultSet.getInt( "gamePinchHitSingle" ) );
                boxScore.setGamePinchHitDouble( resultSet.getInt( "gamePinchHitDouble" ) );
                boxScore.setGamePinchHitTriple( resultSet.getInt( "gamePinchHitTriple" ) );
                boxScore.setGamePinchHitHomeRun( resultSet.getInt( "gamePinchHitHomeRun" ) );
                boxScore.setGamePinchHitGdp( resultSet.getInt( "gamePinchHitGdp" ) );
                boxScore.setGamePinchHitWalk( resultSet.getInt( "gamePinchHitWalk" ) );
                boxScore.setGamePinchHitStrikeOut( resultSet.getInt( "gamePinchHitStrikeOut" ) );
                boxScore.setRound( resultSet.getString( "round" ) );
                boxScore.setBattingOrder( resultSet.getInt( "battingOrder" ) );
                boxScore.setSimNumber( resultSet.getInt( "simNumber" ) );
                boxScore.setSimName( resultSet.getString( "simName" ) );
                boxScore.setYearID( resultSet.getInt( "yearID" ) );
                boxScore.setGameField( resultSet.getString( "gameField" ) );
                boxScore.setLgID( resultSet.getString( "lgID" ) );
                boxScore.setPlayerID( resultSet.getString( "playerID" ) );
                boxScore.setPosition( resultSet.getString( "position" ) );

                boxScores.add( boxScore );
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch ( IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return boxScores;
    }
}

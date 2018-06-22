package Baseball;

public class BoxScore
{
    private String gameNumber, teamID, nameFirst, nameLast, position, round, simName, gameField, lgID, playerID;
    private int simNumber, yearID;

    private BatterStats batterStats = new BatterStats();
    private PitcherStats pitcherStats = new PitcherStats();
/*    private BoxScoreStatsBatter boxScoreStatsBatter = new BoxScoreStatsBatter();
    private BoxScoreStatsPitcher boxScoreStatsPitcher = new BoxScoreStatsPitcher();*/

    public BoxScore()
    {
    }

    public BoxScore( String gameNumber, String teamID, String nameFirst, String nameLast, String position,
                     String round, String simName, String gameField, String lgID, int simNumber, int yearID,
                     String playerID)
    {
        this.gameNumber = gameNumber;
        this.teamID = teamID;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
        this.round = round;
        this.simName = simName;
        this.gameField = gameField;
        this.lgID = lgID;
        this.simNumber = simNumber;
        this.yearID = yearID;
        this.playerID = playerID;
    }

/*    public BoxScoreStatsBatter getBoxScoreStatsBatter()
    {
        return boxScoreStatsBatter;
    }

    public void setBoxScoreStatsBatter( BoxScoreStatsBatter boxScoreStatsBatter )
    {
        this.boxScoreStatsBatter = boxScoreStatsBatter;
    }

    public BoxScoreStatsPitcher getBoxScoreStatsPitcher()
    {
        return boxScoreStatsPitcher;
    }

    public void setBoxScoreStatsPitcher( BoxScoreStatsPitcher boxScoreStatsPitcher )
    {
        this.boxScoreStatsPitcher = boxScoreStatsPitcher;
    }*/

    public String getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID( String playerID )
    {
        this.playerID = playerID;
    }

    public String getGameNumber()
    {
        return gameNumber;
    }

    public void setGameNumber( String gameNumber )
    {
        this.gameNumber = gameNumber;
    }

    public String getTeamID()
    {
        return teamID;
    }

    public void setTeamID( String teamID )
    {
        this.teamID = teamID;
    }

    public String getNameFirst()
    {
        return nameFirst;
    }

    public void setNameFirst( String nameFirst )
    {
        this.nameFirst = nameFirst;
    }

    public String getNameLast()
    {
        return nameLast;
    }

    public void setNameLast( String nameLast )
    {
        this.nameLast = nameLast;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition( String position )
    {
        this.position = position;
    }

    public String getRound()
    {
        return round;
    }

    public void setRound( String round )
    {
        this.round = round;
    }

    public String getSimName()
    {
        return simName;
    }

    public void setSimName( String simName )
    {
        this.simName = simName;
    }

    public String getGameField()
    {
        return gameField;
    }

    public void setGameField( String gameField )
    {
        this.gameField = gameField;
    }

    public String getLgID()
    {
        return lgID;
    }

    public void setLgID( String lgID )
    {
        this.lgID = lgID;
    }

    public int getSimNumber()
    {
        return simNumber;
    }

    public void setSimNumber( int simNumber )
    {
        this.simNumber = simNumber;
    }

    public int getYearID()
    {
        return yearID;
    }

    public void setYearID( int yearID )
    {
        this.yearID = yearID;
    }
}

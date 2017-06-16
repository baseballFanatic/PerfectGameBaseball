package Baseball;

import javax.sound.sampled.Line;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.random;

public class Fielder extends Player {
    private final FielderStats fielderStats = new FielderStats();
    private InPlayPosition position;
    private String teamID, pos;
    private int playerKey, battingOrder;
    private boolean leftField, centerField, rightField;

    Fielder() {
    }

    private Fielder(String nameFirst, String nameLast, InPlayPosition position) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    private boolean isLeftField() {
        return leftField;
    }

    private void setLeftField(boolean leftField) {
        this.leftField = leftField;
    }

    private boolean isCenterField() {
        return centerField;
    }

    private void setCenterField(boolean centerField) {
        this.centerField = centerField;
    }

    private boolean isRightField() {
        return rightField;
    }

    private void setRightField(boolean rightField) {
        this.rightField = rightField;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTeamID() {
        return teamID;
    }

    void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public int getPlayerKey() {
        return playerKey;
    }

    void setPlayerKey(int playerKey) {
        this.playerKey = playerKey;
    }

    private InPlayPosition getFielderPosition() {
        return position;
    }

    public void setFielderPosition (InPlayPosition position) {
        this.position = position;
    }

    Fielder getCurrentFielder(InPlayPosition fielderPosition, List<Fielder> fielderList) {
        Fielder currentFielder = null;
        for (Fielder fielder : fielderList) {
            if (fielderPosition == fielder.getPosition()) {
                currentFielder = fielder;
                break;
            }
        }
        return currentFielder;
    }

    Fielder getBuntFielder(List<Fielder> fielderList) {
        double randomFielderPosition = random();
        if (randomFielderPosition < .30) {
            Fielder buntFielder;
            for (Fielder fielder : fielderList) {
                if (fielder.position == InPlayPosition.THIRD_BASE) {
                    buntFielder = fielder;
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < .6) {
            Fielder buntFielder;
            for (Fielder fielder : fielderList) {
                if (fielder.position == InPlayPosition.PITCHER) {
                    buntFielder = fielder;
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < .9) {
            Fielder buntFielder;
            for (Fielder fielder : fielderList) {
                if (fielder.position == InPlayPosition.CATCHER) {
                    buntFielder = fielder;
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < 1) {
            Fielder buntFielder;
            for (Fielder fielder : fielderList) {
                if (fielder.position == InPlayPosition.FIRST_BASE) {
                    buntFielder = fielder;
                    return buntFielder;
                }
            }
        }
        return null;
    }

    public Fielder getFielderByPosition(InPlayPosition fielderPosition, List<Fielder> fielderList) {
        Fielder currentFielder = null;
        for (Fielder fielder : fielderList) {
            if (fielderPosition == fielder.getPosition()) {
                currentFielder = fielder;
                break;
            }
        }
        return currentFielder;
    }


    FielderStats getFielderStats() {
        return fielderStats;
    }

    InPlayPosition getPosition() {
        return position;
    }

    public void setPosition(InPlayPosition position) {
        this.position = position;
    }

    void updateOutfielderAssist(Fielder currentFielder, List<Fielder> fielderList, InPlayPosition position) {
        Bases bases = new Bases();
        Fielder outfielderWithAssist = bases.determineOutfieldPosition(currentFielder, fielderList);
        outfielderWithAssist.getFielderStats().setGameAssists(outfielderWithAssist.getFielderStats().getGameAssists() + 1);
        Fielder infielderWithPutOut = currentFielder.getCurrentFielder(position, fielderList);
        infielderWithPutOut.getFielderStats().setGamePutOuts(infielderWithPutOut.getFielderStats().getGamePutOuts() + 1);
    }

    List<Fielder> getFielderList(boolean visitors, Schedule schedule) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Fielder> fielderList;
        Fielder fielder = new Fielder();

        if (visitors) {
            int yearID=1927;
            String teamID = schedule.getVisitingTeamId();
            // Selects all fielders for the visitor team and orders by games played desc.
            fielderList = Database.selectFielders(teamID, yearID);

        } else {
            int yearID=1927;
            String teamID = schedule.getHomeTeamId();
            // Selects all fielders for the home team and orders by games played desc.
            fielderList = Database.selectFielders(teamID, yearID);
        }

        for (Fielder player : fielderList) {
            player.getFielderStats().setFieldingPercentage(.950);
        }
        return fielderList;
    }

    List<Fielder> getFieldersStartersList(List<LineUp> team, List<Fielder> fielderList)
    {
        List<Fielder> starters = new ArrayList<>();
        for (LineUp player : team)
        {
            for (Fielder fielder : fielderList)
            {
                if (Objects.equals(player.getRetroID(), fielder.getRetroId()))
                {
                    switch(player.getPlayerPosition())
                    {
                        case("RF"):
                            if (fielder.getPosition().equals(InPlayPosition.OUTFIELD))
                            {
                                fielder.setPosition(InPlayPosition.RIGHT_FIELD);
                                fielder.setBattingOrder(player.getPlayerOrder());
                                if (player.getGamePlayed() != 1)
                                {
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        case ("LF"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.OUTFIELD))
                            {
                                fielder.setPosition(InPlayPosition.LEFT_FIELD);
                                fielder.setBattingOrder(player.getPlayerOrder());
                                if (player.getGamePlayed() != 1)
                                {
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("CF"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.OUTFIELD))
                            {
                                fielder.setPosition(InPlayPosition.CENTER_FIELD);
                                fielder.setBattingOrder(player.getPlayerOrder());
                                if (player.getGamePlayed() != 1)
                                {
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("1B"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.FIRST_BASE))
                            {
                                if (player.getGamePlayed() != 1)
                                {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("2B"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.SECOND_BASE))
                            {
                                if (player.getGamePlayed() != 1)
                                {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("3B"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.THIRD_BASE))
                            {
                                if (player.getGamePlayed() != 1)
                                {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("SS"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.SHORTSTOP))
                            {
                                if (player.getGamePlayed() != 1)
                                {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("P"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.PITCHER))
                            {
                                if (player.getGamePlayed() != 1)
                                {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                        case ("C"):
                        {
                            if (fielder.getPosition().equals(InPlayPosition.CATCHER))
                            {
                                if (player.getGamePlayed() != 1)
                                {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    starters.add(fielder);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return starters;
    }

    List<Fielder> addPitcherToFielders(List<Fielder> fielderReserves, Pitcher pitcher, List<Fielder> starters)
    {
        for (Fielder fielder : fielderReserves) {
            if (fielder.getPlayerId().equals(pitcher.getPlayerId()))
            {
                starters.add(fielder);
                break;
            }
        }
        return starters;
    }

}

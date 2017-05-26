package Baseball;

import org.thymeleaf.util.ArrayUtils;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.random;

public class Fielder extends Player {
    private final FielderStats fielderStats = new FielderStats();
    private InPlayPosition position;
    private String teamID, pos;
    private int playerKey;
    private boolean leftField, centerField, rightField;

    Fielder() {
    }

    private Fielder(String nameFirst, String nameLast, InPlayPosition position) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
    }

    public boolean isLeftField() {
        return leftField;
    }

    public void setLeftField(boolean leftField) {
        this.leftField = leftField;
    }

    public boolean isCenterField() {
        return centerField;
    }

    public void setCenterField(boolean centerField) {
        this.centerField = centerField;
    }

    public boolean isRightField() {
        return rightField;
    }

    public void setRightField(boolean rightField) {
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

    InPlayPosition getFielderPosition() {
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
            Fielder buntFielder = null;
            for (Fielder fielder : fielderList) {
                if (fielder.position == InPlayPosition.PITCHER) {
                    buntFielder = fielder;
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < .9) {
            Fielder buntFielder = null;
            for (Fielder fielder : fielderList) {
                if (fielder.position == InPlayPosition.CATCHER) {
                    buntFielder = fielder;
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < 1) {
            Fielder buntFielder = null;
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

    List<Fielder> getFielderList(boolean visitors) throws ClassNotFoundException, SQLException, InstantiationException {
        List<Fielder> fielderList = new ArrayList<>();
        Fielder fielder = new Fielder();

        if (visitors) {
            int yearID=1927;
            String teamID="NYA";
            fielderList = Database.selectFielders(teamID, yearID, fielder);
/*
            fielderList.add(new Fielder("Ty", "Cobb", InPlayPosition.CENTER_FIELD));
            fielderList.add(new Fielder("Rickey", "Henderson", InPlayPosition.LEFT_FIELD));
            fielderList.add(new Fielder("Babe", "Ruth", InPlayPosition.RIGHT_FIELD));
            fielderList.add(new Fielder("Lou", "Gehrig", InPlayPosition.FIRST_BASE));
            fielderList.add(new Fielder("Ozzie", "Smith", InPlayPosition.SHORTSTOP));
            fielderList.add(new Fielder("Mike", "Schmidt", InPlayPosition.THIRD_BASE));
            fielderList.add(new Fielder("Napoleon", "Lajoie", InPlayPosition.SECOND_BASE));
            fielderList.add(new Fielder("Yogi", "Berra", InPlayPosition.CATCHER));
            fielderList.add(new Fielder("Christy", "Mathewson", InPlayPosition.PITCHER));*/
        } else {
            int yearID=1927;
            String teamID="PHA";
            fielderList = Database.selectFielders(teamID, yearID, fielder);

/*            fielderList.add(new Fielder ("Tris", "Speaker", InPlayPosition.CENTER_FIELD));
            fielderList.add(new Fielder ("Charlie", "Gehringer", InPlayPosition.SECOND_BASE));
            fielderList.add(new Fielder ("Johnny", "Bench", InPlayPosition.CATCHER));
            fielderList.add(new Fielder ("Mel", "Ott", InPlayPosition.RIGHT_FIELD));
            fielderList.add(new Fielder ("Harry", "Heilman", InPlayPosition.LEFT_FIELD));
            fielderList.add(new Fielder ("Hank", "Greenberg", InPlayPosition.FIRST_BASE));
            fielderList.add(new Fielder ("Joe", "Cronin", InPlayPosition.SHORTSTOP));
            fielderList.add(new Fielder ("Brooks", "Robinson", InPlayPosition.THIRD_BASE));
            fielderList.add(new Fielder ("Cy", "Young", InPlayPosition.PITCHER));*/
        }

        for (Fielder player : fielderList) {
            player.getFielderStats().setFieldingPercentage(.950);
        }
        return fielderList;
    }
    List<Fielder> getFieldersStartersList(List<Fielder> team)
    {
        List<InPlayPosition> positionsNeeded = InPlayPosition.getList();
        positionsNeeded.remove(InPlayPosition.DESIGNATED_HITTER);
        positionsNeeded.remove(InPlayPosition.OUTFIELD);
        positionsNeeded.remove(InPlayPosition.PITCHER);

        List<Fielder> starters = new ArrayList<>();
        for (Fielder fielder : team)
        {
            if (fielder.position.equals(InPlayPosition.OUTFIELD))
            {
                if (!isLeftField())
                {
                    fielder.setPosition(InPlayPosition.LEFT_FIELD);
                    setLeftField(true);
                } else if (!isCenterField())
                {
                    fielder.setPosition(InPlayPosition.CENTER_FIELD);
                    setCenterField(true);
                } else if (!isRightField())
                {
                    fielder.setPosition(InPlayPosition.RIGHT_FIELD);
                    setRightField(true);
                }
            }
            if (positionsNeeded.contains(fielder.getFielderPosition()))
            {
                starters.add(fielder);
                positionsNeeded.remove(fielder.getFielderPosition());
            }
        }
        setLeftField(false);
        setCenterField(false);
        setRightField(false);
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

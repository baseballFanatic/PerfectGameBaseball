package Baseball;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    List<Fielder> getFieldersStartersList(List<Fielder> team)
    {
/*    List<Fielder> getFieldersStartersList(boolean visitors, Schedule schedule, List<Fielder> team)
            throws NoSuchMethodException, SecurityException, InvocationTargetException, IllegalAccessException {*/
        List<Fielder> starters = new ArrayList<>();

/*        if (visitors)
        {
            for (int a = 1; a < 10; a++)
            {
                String batterId = "getVisitingBatter" + a + "Id";
                try {
                    Method method = schedule.getClass().getMethod(batterId, String.class);
                    method.invoke(schedule, batterId);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
 //               String retroID = schedule.
            }
        }*/
        List<InPlayPosition> positionsNeeded = InPlayPosition.getList();
        positionsNeeded.remove(InPlayPosition.DESIGNATED_HITTER);
        positionsNeeded.remove(InPlayPosition.OUTFIELD);
        positionsNeeded.remove(InPlayPosition.PITCHER);

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

package Baseball;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Fielder extends Player {
    private final FielderStats fielderStats = new FielderStats();
    private InPlayPosition position;

    Fielder() {
    }

    private Fielder(String nameFirst, String nameLast, InPlayPosition position) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
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

    List<Fielder> getFielderList(boolean visitors) {
        List<Fielder> fielderList = new ArrayList<>();

        if (visitors) {
            fielderList.add(new Fielder("Ty", "Cobb", InPlayPosition.CENTER_FIELD));
            fielderList.add(new Fielder("Rickey", "Henderson", InPlayPosition.LEFT_FIELD));
            fielderList.add(new Fielder("Babe", "Ruth", InPlayPosition.RIGHT_FIELD));
            fielderList.add(new Fielder("Lou", "Gehrig", InPlayPosition.FIRST_BASE));
            fielderList.add(new Fielder("Ozzie", "Smith", InPlayPosition.SHORTSTOP));
            fielderList.add(new Fielder("Mike", "Schmidt", InPlayPosition.THIRD_BASE));
            fielderList.add(new Fielder("Napoleon", "Lajoie", InPlayPosition.SECOND_BASE));
            fielderList.add(new Fielder("Yogi", "Berra", InPlayPosition.CATCHER));
            fielderList.add(new Fielder("Christy", "Mathewson", InPlayPosition.PITCHER));
        } else {
            fielderList.add(new Fielder ("Tris", "Speaker", InPlayPosition.CENTER_FIELD));
            fielderList.add(new Fielder ("Charlie", "Gehringer", InPlayPosition.SECOND_BASE));
            fielderList.add(new Fielder ("Johnny", "Bench", InPlayPosition.CATCHER));
            fielderList.add(new Fielder ("Mel", "Ott", InPlayPosition.RIGHT_FIELD));
            fielderList.add(new Fielder ("Harry", "Heilman", InPlayPosition.LEFT_FIELD));
            fielderList.add(new Fielder ("Hank", "Greenberg", InPlayPosition.FIRST_BASE));
            fielderList.add(new Fielder ("Joe", "Cronin", InPlayPosition.SHORTSTOP));
            fielderList.add(new Fielder ("Brooks", "Robinson", InPlayPosition.THIRD_BASE));
            fielderList.add(new Fielder ("Cy", "Young", InPlayPosition.PITCHER));
        }

        for (Fielder fielder : fielderList) {
            fielder.getFielderStats().setFieldingPercentage(.950);
        }
        return fielderList;
    }

}

package Baseball;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.random;

public class Fielder extends Player {
    private final FielderStats fielderStats = new FielderStats();
    private InPlayPosition position;
    private String teamID, pos;
    private int playerKey, battingOrder, yearID;
    private boolean leftField, centerField, rightField, available, fielderMatched;

    Fielder() {
    }

    private Fielder(String nameFirst, String nameLast, InPlayPosition position) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.position = position;
    }

    public boolean isFielderMatched() {
        return fielderMatched;
    }

    void setFielderMatched(boolean fielderMatched) {
        this.fielderMatched = fielderMatched;
    }

    public int getYearID() {
        return yearID;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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

    public void setFielderPosition(InPlayPosition position) {
        this.position = position;
    }

    Fielder getCurrentFielder(InPlayPosition fielderPosition, HashMap<Integer, Fielder> fielderList) {
        Fielder currentFielder = null;
        for (Integer integer : fielderList.keySet()) {
            if(Objects.equals(fielderList.get(integer).getPosition(), fielderPosition) ) {
                currentFielder = fielderList.get(integer);
                break;
            }
        }
        return currentFielder;
    }

    Fielder getBuntFielder(HashMap<Integer, Fielder> fielderList) {
        double randomFielderPosition = random();
        if (randomFielderPosition < .30) {
            Fielder buntFielder;
            for (Integer integer : fielderList.keySet()) {
                if (fielderList.get(integer).getPosition().equals(InPlayPosition.THIRD_BASE)) {
                    buntFielder = fielderList.get(integer);
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < .6) {
            Fielder buntFielder;
            for (Integer integer : fielderList.keySet()) {
                if (fielderList.get(integer).getPosition().equals(InPlayPosition.PITCHER)) {
                    buntFielder = fielderList.get(integer);
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < .9) {
            Fielder buntFielder;
            for (Integer integer : fielderList.keySet()) {
                if (fielderList.get(integer).getPosition().equals(InPlayPosition.CATCHER)) {
                    buntFielder = fielderList.get(integer);
                    return buntFielder;
                }
            }
        } else if (randomFielderPosition < 1) {
            Fielder buntFielder;
            for (Integer integer : fielderList.keySet()) {
                if (fielderList.get(integer).getPosition().equals(InPlayPosition.FIRST_BASE)) {
                    buntFielder = fielderList.get(integer);
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

    void updateOutfielderAssist(Fielder currentFielder, HashMap<Integer, Fielder> fielderList, InPlayPosition position) {
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
            //TODO Take out the hard coded year
            int yearID = schedule.getGameYear();
            int gameKey = schedule.getGameKey();
            String teamID = schedule.getVisitingTeamId();
            // Selects all fielders for the visitor team and orders by games played desc.
            fielderList = Database.selectFielders(teamID, yearID, gameKey);

        } else {
            int yearID = schedule.getGameYear();
            int gameKey = schedule.getGameKey();
            String teamID = schedule.getHomeTeamId();
            // Selects all fielders for the home team and orders by games played desc.
            fielderList = Database.selectFielders(teamID, yearID, gameKey);
        }

        for (Fielder player : fielderList) {
            player.getFielderStats().setFieldingPercentage(.950);
        }
        return fielderList;
    }

    HashMap<Integer, Fielder> getFieldersStartersList(List<LineUp> team, List<Fielder> fielderList) {
        HashMap<Integer, Fielder> starters = new HashMap<>();
        setFielderMatched(false);

        for (LineUp player : team) {
            for (Fielder fielder : fielderList) {
                if (Objects.equals(player.getRetroID(), fielder.getRetroId())) {
                    switch (player.getPlayerPosition()) {
                        case ("RF"):
                            if (fielder.getPosition().equals(InPlayPosition.OUTFIELD)) {
                                fielder.setPosition(InPlayPosition.RIGHT_FIELD);
                                fielder.setBattingOrder(player.getPlayerOrder());
                                if (player.getGamePlayed() != 1) {
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("LF"):
                            if (fielder.getPosition().equals(InPlayPosition.OUTFIELD)) {
                                fielder.setPosition(InPlayPosition.LEFT_FIELD);
                                fielder.setBattingOrder(player.getPlayerOrder());
                                if (player.getGamePlayed() != 1) {
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("CF"):
                            if (fielder.getPosition().equals(InPlayPosition.OUTFIELD)) {
                                fielder.setPosition(InPlayPosition.CENTER_FIELD);
                                fielder.setBattingOrder(player.getPlayerOrder());
                                if (player.getGamePlayed() != 1) {
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("1B"):
                            if (fielder.getPosition().equals(InPlayPosition.FIRST_BASE)) {
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("2B"):
                            if (fielder.getPosition().equals(InPlayPosition.SECOND_BASE)) {
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("3B"):
                            if (fielder.getPosition().equals(InPlayPosition.THIRD_BASE)) {
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("SS"):
                            if (fielder.getPosition().equals(InPlayPosition.SHORTSTOP)) {
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("P"):
                            if (fielder.getPosition().equals(InPlayPosition.PITCHER)) {
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                        case ("C"):
                            if (fielder.getPosition().equals(InPlayPosition.CATCHER)) {
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.setAvailable(false);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            }
                            break;
                    }
                }
            }

            while (!fielderMatched) {
                for (Fielder fielder : fielderList) {
                    if (Objects.equals(player.getRetroID(), fielder.getRetroId())) {
                        switch (player.getPlayerPosition()) {
                            case ("LF"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.977);
                                    fielder.setPosition(InPlayPosition.LEFT_FIELD);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("CF"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.984);
                                    fielder.setPosition(InPlayPosition.CENTER_FIELD);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("RF"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.981);
                                    fielder.setPosition(InPlayPosition.RIGHT_FIELD);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("1B"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.993);
                                    fielder.setPosition(InPlayPosition.FIRST_BASE);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("2B"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.981);
                                    fielder.setPosition(InPlayPosition.SECOND_BASE);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("3B"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.953);
                                    fielder.setPosition(InPlayPosition.THIRD_BASE);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("SS"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.967);
                                    fielder.setPosition(InPlayPosition.SHORTSTOP);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("C"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.990);
                                    fielder.setPosition(InPlayPosition.CATCHER);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                                break;
                            case ("P"):
                                if (player.getGamePlayed() != 1) {
                                    fielder.setBattingOrder(player.getPlayerOrder());
                                    player.setGamePlayed(1);
                                    fielder.getFielderStats().setGameGameStarted(1);
                                    fielder.getFielderStats().setGameGamePlayed(1);
                                    fielder.setAvailable(false);
                                    fielder.getFielderStats().setFieldingPercentage(.952);
                                    fielder.setPosition(InPlayPosition.PITCHER);
                                    starters.put(player.getPlayerOrder(), fielder);
                                    setFielderMatched(true);
                                }
                        }
                    }
                }
            }
            for (Integer integer : starters.keySet()) {
                for (Fielder fielder : fielderList) {
                    if (Objects.equals(starters.get(integer).getPlayerId(), fielder.getPlayerId())) {
                        fielder.setAvailable(false);
                    }
                }
            }
            setFielderMatched(false);
        }
        return starters;
    }

    public void addPitcherToFielders(List<Fielder> fielderReserves, Pitcher pitcher, HashMap<Integer, Fielder> starters) {
        Fielder fielder = new Fielder();

        for (Fielder fielder1 : fielderReserves)
        {
            if (fielder1.getPlayerId().equals(pitcher.getPlayerId()))
            {
                fielder1.setBattingOrder(pitcher.getBattingOrder());
                fielder1.getFielderStats().setGameGamePlayed(1);
                fielder1.setPosition(InPlayPosition.PITCHER);
                System.out.printf("Set %s batting order to %s and position to %s%n",
                        fielder1.getNameLast(), fielder1.getBattingOrder(), fielder1.getPosition());
                fielder = fielder1;
            }
        }

        starters.put(fielder.getBattingOrder(), fielder);
    }

    public void removePitcherFromFielders(HashMap<Integer, Fielder> fielderList, Pitcher pitcher) {
        Integer indexToDelete = null;

        for (Integer integer : fielderList.keySet()) {
            if(Objects.equals(fielderList.get(integer).getPlayerId(), pitcher.getPlayerId()) )
            {
                pitcher.setBattingOrder(fielderList.get(integer).getBattingOrder());
                System.out.printf("Set %s fielder batting order to %s and removed from fielder starter list.%n",
                        pitcher.getNameLast(), pitcher.getBattingOrder());
                indexToDelete = integer;
                break;
            }
        }

        fielderList.remove(indexToDelete);
    }

    public boolean isFielderAvailable(List<Fielder> fielderReserves, Batter batter) {
        for (Fielder fielder : fielderReserves)
        {
            if (fielder.isAvailable() && fielder.getPosition().equals(batter.getPosition()))
            {
                return true;
            }
        }
        return false;
    }

    public void removeFielderFromFielders(HashMap<Integer, Fielder> fielderList, Batter currentBatter) {
        Integer indexToDelete = null;

        for (Integer integer : fielderList.keySet())
            if (Objects.equals(fielderList.get(integer).getPlayerId(), currentBatter.getPlayerId())) {
                indexToDelete = integer;
                break;
            }
        fielderList.remove(indexToDelete);
    }

    Fielder getPinchHitterFielder(List<Fielder> fielderReserves, Batter currentBatter) {
        for (Fielder fielder : fielderReserves)
        {
            if (fielder.isAvailable() && fielder.getPosition().equals(currentBatter.getPosition()))
            {
                return fielder;
            }
        }
        return null;
    }

    void addFielderToFielderStarters(HashMap<Integer, Fielder> fielderList, Fielder fielder,
                                     Batter batter, Inning inning) {
        batter.setBattingOrder(batter.getBattingOrder() - inning.getInning());
        fielder.setBattingOrder(batter.getBattingOrder());
        fielder.getFielderStats().setGameGamePlayed(1);
        fielderList.put(batter.getBattingOrder(), fielder);
        System.out.printf("%s comes in to pinch hit for %s%n", fielder.getNameLast(), batter.getNameLast());
    }
}


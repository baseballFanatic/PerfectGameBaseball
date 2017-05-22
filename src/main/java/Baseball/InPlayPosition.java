package Baseball;

public enum InPlayPosition {
    PITCHER, CATCHER, FIRST_BASE, SECOND_BASE, THIRD_BASE, SHORTSTOP, LEFT_FIELD, CENTER_FIELD, RIGHT_FIELD, OUTFIELD,
    DESIGNATED_HITTER;

    public InPlayPosition get(String value) {
        InPlayPosition result = null;

        for ( InPlayPosition fielderPosition : values()) {
            if(fielderPosition.name().equals(value))
                result = fielderPosition;
            break;
        }
        return result;
    }
}
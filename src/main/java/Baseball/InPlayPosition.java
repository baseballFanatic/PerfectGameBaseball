package Baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum InPlayPosition {
    PITCHER("P"), CATCHER("C"), FIRST_BASE("1B"), SECOND_BASE("2B"), THIRD_BASE("3B"), SHORTSTOP("SS"),
    LEFT_FIELD("LF"), CENTER_FIELD("CF"), RIGHT_FIELD("RF"), OUTFIELD("OF"),
    DESIGNATED_HITTER("DH"), PINCH_HITTER("PH");

    private String positionCode;

    InPlayPosition(String positionCode) {
        this.positionCode = positionCode;
    }

    private String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public static InPlayPosition get(String value) {
        InPlayPosition result = null;

        for ( InPlayPosition fielderPosition : values()) {
            if(fielderPosition.name().equals(value) || fielderPosition.getPositionCode().equals(value)) {
                result = fielderPosition;
                break;
            }
        }
        return result;
    }

    public static List<InPlayPosition> getList()
    {
        List<InPlayPosition> result = new ArrayList<>();
        Collections.addAll(result, values());
        return result;
    }
}
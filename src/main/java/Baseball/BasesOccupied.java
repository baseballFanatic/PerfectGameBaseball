package Baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum BasesOccupied {
    BASES_LOADED, SECOND_THIRD, FIRST_THIRD, SECOND_FIRST, THIRD_BASE, SECOND_BASE, FIRST_BASE, EMPTY;

    BasesOccupied() {
    }

    public static BasesOccupied get(String value) {
        BasesOccupied result = null;

        for ( BasesOccupied bases : values()) {
            if(bases.name().equals(value)) {
                result = bases;
                break;
            }
        }
        return result;
    }

    public static List<BasesOccupied> getList()
    {
        List<BasesOccupied> result = new ArrayList<>();
        Collections.addAll(result, values());
        return result;
    }
}

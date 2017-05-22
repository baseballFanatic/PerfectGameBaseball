package Baseball;

public enum OutfieldDepth {
    SHORT, MEDIUM, LONG;

    public OutfieldDepth get(String value) {
        OutfieldDepth result = null;

        for ( OutfieldDepth outfieldDepth : values()) {
            if(outfieldDepth.name().equals(value))
                result = outfieldDepth;
            break;
        }
        return result;
    }
}
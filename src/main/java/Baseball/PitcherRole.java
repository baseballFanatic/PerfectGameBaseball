package Baseball;

public enum PitcherRole {
    STARTER, RELIEVER, CLOSER;

    public PitcherRole get(String value) {
        PitcherRole result = null;

        for ( PitcherRole pitcherRole : values()) {
            if(pitcherRole.name().equals(value))
                result = pitcherRole;
            break;
        }
        return result;
    }
}

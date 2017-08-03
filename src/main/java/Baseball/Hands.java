package Baseball;

public enum Hands {
    LEFT("L"), RIGHT("R"), BOTH("B");

    String handCode;

    Hands(String handCode){this.handCode = handCode;}

    String getHandCode() {
        return handCode;
    }

    public void setHandCode(String handCode) {
        this.handCode = handCode;
    }

    public static Hands get(String value) {
        Hands result = null;

        for ( Hands hands : values()) {
            if(hands.name().equals(value) || hands.getHandCode().equals(value)) {
                result = hands;
                break;
            }
        }
        return result;
    }
}

package Baseball;

class LineUp {
    private int battingOrder;
    private int visitorBattingNumber;
    private int homeBattingNumber;

    LineUp() {
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    int getVisitorBattingNumber() {
        return visitorBattingNumber;
    }

    void setVisitorBattingNumber(int visitorBattingNumber) {
        this.visitorBattingNumber = visitorBattingNumber;
    }

    int getHomeBattingNumber() {
        return homeBattingNumber;
    }

    void setHomeBattingNumber(int homeBattingNumber) {
        this.homeBattingNumber = homeBattingNumber;
    }
}





package Baseball;

public class Reliever {
    private Long id;
    private String playerId;
    private String yearId;
    private String teamId;
    private String lgId;
    private String hands;
    private String round;
    private String pos;
    private int award_points;
    private int wins;
    private int losses;
    private int saves;
    private int games;
    private int gamesStarted;
    private int hitsAgainst;
    private String nameGiven;

    public Reliever() {}

    public Reliever(String playerId) {
        this.playerId = playerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getLgId() {
        return lgId;
    }

    public void setLgId(String lgId) {
        this.lgId = lgId;
    }

    public String getHands() {
        return hands;
    }

    public void setHands(String hands) {
        this.hands = hands;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getAward_points() {
        return award_points;
    }

    public void setAward_points(int award_points) {
        this.award_points = award_points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(int gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public int getHitsAgainst() {
        return hitsAgainst;
    }

    public void setHitsAgainst(int hitsAgainst) {
        this.hitsAgainst = hitsAgainst;
    }

    @Override
    public String toString() {
        return "Reliever{" +
                "playerId='" + playerId + '\'' +
                ", yearId='" + yearId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", lgId='" + lgId + '\'' +
                ", hands='" + hands + '\'' +
                ", round='" + round + '\'' +
                ", pos='" + pos + '\'' +
                ", award_points=" + award_points +
                ", wins=" + wins +
                ", losses=" + losses +
                ", saves=" + saves +
                ", games=" + games +
                ", gamesStarted=" + gamesStarted +
                ", hitsAgainst=" + hitsAgainst +
                '}';
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}


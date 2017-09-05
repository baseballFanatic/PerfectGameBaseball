package Baseball;

import java.util.List;

public class Player {
    String nameFirst;
    String nameLast;
    private String playerId;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private String deathYear;
    private String deathMonth;
    private String deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameGiven;
    private String debut;
    private String finalGame;
    private String retroId;
    private String bbrefId;
    String simName;
    private int weight;
    private int height;
    int simNumber;

    public Player() {}

    public Player(String nameFirst, String nameLast, String playerId) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.playerId = playerId;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public String getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(String deathMonth) {
        this.deathMonth = deathMonth;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(String finalGame) {
        this.finalGame = finalGame;
    }

    public String getRetroId() {
        return retroId;
    }

    public void setRetroId(String retroId) {
        this.retroId = retroId;
    }

    public String getBbrefId() {
        return bbrefId;
    }

    public void setBbrefId(String bbrefId) {
        this.bbrefId = bbrefId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void updatePlayPercent(List<Batter> batterList, List<Pitcher> pitcherList, List<Fielder> fielderList,
                                  Team team) {
        if (team.getTeamStats().getSeasonGames() > 0) {
            for (Batter batter : batterList) {
                if (batter.getBatterStats().getsGamesPlayed() > 0) {
                    batter.getBatterStats().setActualPlayPercent((double)batter.getBatterStats().getsGamesPlayed() / team.getTeamStats().getSeasonGames());
                } else {
                    batter.getBatterStats().setActualPlayPercent(0.00);
                }

                if (batter.getBatterStats().getGamesPlayed() > 0) {
                    batter.getBatterStats().setHistPercentPlayed((double)batter.getBatterStats().getGamesPlayed() / team.getTeamStats().getGames());
                } else {
                    batter.getBatterStats().setHistPercentPlayed(0.00);
                }
            }

            for (Pitcher pitcher : pitcherList) {
                if (pitcher.getPitcherStats().getsGamesPlayed() > 0) {
                    pitcher.getPitcherStats().setActualPlayPercent((double)pitcher.getPitcherStats().getsGamesPlayed() / team.getTeamStats().getSeasonGames());
                } else {
                    pitcher.getPitcherStats().setActualPlayPercent(0.00);
                }

                if (pitcher.getPitcherStats().getGamesPlayed() > 0) {
                    pitcher.getPitcherStats().setHistPercentPlayed((double)pitcher.getPitcherStats().getGamesPlayed() / team.getTeamStats().getGames());
                } else {
                    pitcher.getPitcherStats().setHistPercentPlayed(0.00);
                }
            }

            for (Fielder fielder : fielderList) {
                if (fielder.getFielderStats().getsGamesPlayed() > 0) {
                    fielder.getFielderStats().setActualPlayerPercentage((double)fielder.getFielderStats().getsGamesPlayed() /
                            team.getTeamStats().getSeasonGames());
                } else {
                    fielder.getFielderStats().setActualPlayerPercentage(0.00);
                }

                if (fielder.getFielderStats().getGamesPlayed() > 0) {
                    fielder.getFielderStats().setHistPlayerPercentage((double)fielder.getFielderStats().getGamesPlayed() /
                            team.getTeamStats().getGames());
                } else {
                    fielder.getFielderStats().setHistPlayerPercentage(0.00);
                }
            }
        }
    }
}


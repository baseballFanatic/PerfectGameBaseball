package Baseball;

public class Season {
    private float leagueProbWalk, leagueProbSingle, leagueProbDouble, leagueProbTriple, leagueProbHomeRun,
            leagueProbStrikeOut;

    private int yearID, seasonKey;

    private String alEastChamp, alCentralChamp, alWestChamp, alWildCard, alDivisionSeries1, alDivisionSeries2, alChampion,
        alMvp, alCyYoung, nlEastChamp, nlCentralChamp, nlWestChamp, nlWildCard, nlDivisionSeries1, nlDivisionSeries2,
        nlChampion, nlMvp, nlCyYoung, worldSeriesChamp, al1bSilver, al2bSilver, al3bSilver, alSsSilver, alCsilver,
        alDhSilver, alLfSilver, alCfSilver, alRfSilver, nl1bSilver, nl2bSilver, nl3bSilver, nlSsSilver, nlCsilver,
        nlPsilver, nlLfSilver, nlCfSilver, nlRfSilver, simName;

    public Season(float leagueProbWalk, float leagueProbSingle, float leagueProbDouble, float leagueProbTriple, float leagueProbHomeRun, float leagueProbStrikeOut) {
        this.leagueProbWalk = leagueProbWalk;
        this.leagueProbSingle = leagueProbSingle;
        this.leagueProbDouble = leagueProbDouble;
        this.leagueProbTriple = leagueProbTriple;
        this.leagueProbHomeRun = leagueProbHomeRun;
        this.leagueProbStrikeOut = leagueProbStrikeOut;
    }

    public Season(int yearID) {
        this.yearID = yearID;
    }

    public Season(int yearID, int seasonKey, String alEastChamp, String alCentralChamp, String alWestChamp,
                  String alWildCard, String alDivisionSeries1, String alDivisionSeries2, String alChampion,
                  String alMvp, String alCyYoung, String nlEastChamp, String nlCentralChamp, String nlWestChamp,
                  String nlWildCard, String nlDivisionSeries1, String nlDivisionSeries2, String nlChampion,
                  String nlMvp, String nlCyYoung, String wordSeriesChamp, String al1bSilver, String al2bSilver,
                  String al3bSilver, String alSsSilver, String alCsilver, String alDhSilver, String alLfSilver,
                  String alCfSilver, String alRfSilver, String nl1bSilver, String nl2bSilver, String nl3bSilver,
                  String nlSsSilver, String nlCsilver, String nlPsilver, String nlLfSilver, String nlCfSilver,
                  String nlRfSilver, String simName) {
        this.yearID = yearID;
        this.seasonKey = seasonKey;
        this.alEastChamp = alEastChamp;
        this.alCentralChamp = alCentralChamp;
        this.alWestChamp = alWestChamp;
        this.alWildCard = alWildCard;
        this.alDivisionSeries1 = alDivisionSeries1;
        this.alDivisionSeries2 = alDivisionSeries2;
        this.alChampion = alChampion;
        this.alMvp = alMvp;
        this.alCyYoung = alCyYoung;
        this.nlEastChamp = nlEastChamp;
        this.nlCentralChamp = nlCentralChamp;
        this.nlWestChamp = nlWestChamp;
        this.nlWildCard = nlWildCard;
        this.nlDivisionSeries1 = nlDivisionSeries1;
        this.nlDivisionSeries2 = nlDivisionSeries2;
        this.nlChampion = nlChampion;
        this.nlMvp = nlMvp;
        this.nlCyYoung = nlCyYoung;
        this.worldSeriesChamp = wordSeriesChamp;
        this.al1bSilver = al1bSilver;
        this.al2bSilver = al2bSilver;
        this.al3bSilver = al3bSilver;
        this.alSsSilver = alSsSilver;
        this.alCsilver = alCsilver;
        this.alDhSilver = alDhSilver;
        this.alLfSilver = alLfSilver;
        this.alCfSilver = alCfSilver;
        this.alRfSilver = alRfSilver;
        this.nl1bSilver = nl1bSilver;
        this.nl2bSilver = nl2bSilver;
        this.nl3bSilver = nl3bSilver;
        this.nlSsSilver = nlSsSilver;
        this.nlCsilver = nlCsilver;
        this.nlPsilver = nlPsilver;
        this.nlLfSilver = nlLfSilver;
        this.nlCfSilver = nlCfSilver;
        this.nlRfSilver = nlRfSilver;
        this.simName = simName;
    }

    public Season() {
    }

    public int getYearID() {
        return yearID;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    public int getSeasonKey() {
        return seasonKey;
    }

    public void setSeasonKey(int seasonKey) {
        this.seasonKey = seasonKey;
    }

    public String getAlEastChamp() {
        return alEastChamp;
    }

    public void setAlEastChamp(String alEastChamp) {
        this.alEastChamp = alEastChamp;
    }

    public String getAlCentralChamp() {
        return alCentralChamp;
    }

    public void setAlCentralChamp(String alCentralChamp) {
        this.alCentralChamp = alCentralChamp;
    }

    public String getAlWestChamp() {
        return alWestChamp;
    }

    public void setAlWestChamp(String alWestChamp) {
        this.alWestChamp = alWestChamp;
    }

    public String getAlWildCard() {
        return alWildCard;
    }

    public void setAlWildCard(String alWildCard) {
        this.alWildCard = alWildCard;
    }

    public String getAlDivisionSeries1() {
        return alDivisionSeries1;
    }

    public void setAlDivisionSeries1(String alDivisionSeries1) {
        this.alDivisionSeries1 = alDivisionSeries1;
    }

    public String getAlDivisionSeries2() {
        return alDivisionSeries2;
    }

    public void setAlDivisionSeries2(String alDivisionSeries2) {
        this.alDivisionSeries2 = alDivisionSeries2;
    }

    public String getAlChampion() {
        return alChampion;
    }

    public void setAlChampion(String alChampion) {
        this.alChampion = alChampion;
    }

    public String getAlMvp() {
        return alMvp;
    }

    public void setAlMvp(String alMvp) {
        this.alMvp = alMvp;
    }

    public String getAlCyYoung() {
        return alCyYoung;
    }

    public void setAlCyYoung(String alCyYoung) {
        this.alCyYoung = alCyYoung;
    }

    public String getNlEastChamp() {
        return nlEastChamp;
    }

    public void setNlEastChamp(String nlEastChamp) {
        this.nlEastChamp = nlEastChamp;
    }

    public String getNlCentralChamp() {
        return nlCentralChamp;
    }

    public void setNlCentralChamp(String nlCentralChamp) {
        this.nlCentralChamp = nlCentralChamp;
    }

    public String getNlWestChamp() {
        return nlWestChamp;
    }

    public void setNlWestChamp(String nlWestChamp) {
        this.nlWestChamp = nlWestChamp;
    }

    public String getNlWildCard() {
        return nlWildCard;
    }

    public void setNlWildCard(String nlWildCard) {
        this.nlWildCard = nlWildCard;
    }

    public String getNlDivisionSeries1() {
        return nlDivisionSeries1;
    }

    public void setNlDivisionSeries1(String nlDivisionSeries1) {
        this.nlDivisionSeries1 = nlDivisionSeries1;
    }

    public String getNlDivisionSeries2() {
        return nlDivisionSeries2;
    }

    public void setNlDivisionSeries2(String nlDivisionSeries2) {
        this.nlDivisionSeries2 = nlDivisionSeries2;
    }

    public String getNlChampion() {
        return nlChampion;
    }

    public void setNlChampion(String nlChampion) {
        this.nlChampion = nlChampion;
    }

    public String getNlMvp() {
        return nlMvp;
    }

    public void setNlMvp(String nlMvp) {
        this.nlMvp = nlMvp;
    }

    public String getNlCyYoung() {
        return nlCyYoung;
    }

    public void setNlCyYoung(String nlCyYoung) {
        this.nlCyYoung = nlCyYoung;
    }

    public String getWorldSeriesChamp() {
        return worldSeriesChamp;
    }

    public void setWorldSeriesChamp(String wordSeriesChamp) {
        this.worldSeriesChamp = wordSeriesChamp;
    }

    public String getAl1bSilver() {
        return al1bSilver;
    }

    public void setAl1bSilver(String al1bSiler) {
        this.al1bSilver = al1bSiler;
    }

    public String getAl2bSilver() {
        return al2bSilver;
    }

    public void setAl2bSilver(String al2bSilver) {
        this.al2bSilver = al2bSilver;
    }

    public String getAl3bSilver() {
        return al3bSilver;
    }

    public void setAl3bSilver(String al3bSilver) {
        this.al3bSilver = al3bSilver;
    }

    public String getAlSsSilver() {
        return alSsSilver;
    }

    public void setAlSsSilver(String alSsSilver) {
        this.alSsSilver = alSsSilver;
    }

    public String getAlCsilver() {
        return alCsilver;
    }

    public void setAlCsilver(String alCsilver) {
        this.alCsilver = alCsilver;
    }

    public String getAlDhSilver() {
        return alDhSilver;
    }

    public void setAlDhSilver(String alDhSilver) {
        this.alDhSilver = alDhSilver;
    }

    public String getAlLfSilver() {
        return alLfSilver;
    }

    public void setAlLfSilver(String alLfSilver) {
        this.alLfSilver = alLfSilver;
    }

    public String getAlCfSilver() {
        return alCfSilver;
    }

    public void setAlCfSilver(String alCfSilver) {
        this.alCfSilver = alCfSilver;
    }

    public String getAlRfSilver() {
        return alRfSilver;
    }

    public void setAlRfSilver(String alRfSiler) {
        this.alRfSilver = alRfSiler;
    }

    public String getNl1bSilver() {
        return nl1bSilver;
    }

    public void setNl1bSilver(String nl1bSilver) {
        this.nl1bSilver = nl1bSilver;
    }

    public String getNl2bSilver() {
        return nl2bSilver;
    }

    public void setNl2bSilver(String nl2bSilver) {
        this.nl2bSilver = nl2bSilver;
    }

    public String getNl3bSilver() {
        return nl3bSilver;
    }

    public void setNl3bSilver(String nl3bSilver) {
        this.nl3bSilver = nl3bSilver;
    }

    public String getNlSsSilver() {
        return nlSsSilver;
    }

    public void setNlSsSilver(String nlSsSilver) {
        this.nlSsSilver = nlSsSilver;
    }

    public String getNlCsilver() {
        return nlCsilver;
    }

    public void setNlCsilver(String nlCsilver) {
        this.nlCsilver = nlCsilver;
    }

    public String getNlPsilver() {
        return nlPsilver;
    }

    public void setNlPsilver(String nlPsilver) {
        this.nlPsilver = nlPsilver;
    }

    public String getNlLfSilver() {
        return nlLfSilver;
    }

    public void setNlLfSilver(String nlLfSilver) {
        this.nlLfSilver = nlLfSilver;
    }

    public String getNlCfSilver() {
        return nlCfSilver;
    }

    public void setNlCfSilver(String nlCfSilver) {
        this.nlCfSilver = nlCfSilver;
    }

    public String getNlRfSilver() {
        return nlRfSilver;
    }

    public void setNlRfSilver(String nlRfSilver) {
        this.nlRfSilver = nlRfSilver;
    }

    public String getSimName() {
        return simName;
    }

    public void setSimName(String simName) {
        this.simName = simName;
    }

    public float getLeagueProbWalk() {
        return leagueProbWalk;
    }

    public void setLeagueProbWalk(float leagueProbWalk) {
        this.leagueProbWalk = leagueProbWalk;
    }

    public float getLeagueProbSingle() {
        return leagueProbSingle;
    }

    public void setLeagueProbSingle(float leagueProbSingle) {
        this.leagueProbSingle = leagueProbSingle;
    }

    public float getLeagueProbDouble() {
        return leagueProbDouble;
    }

    public void setLeagueProbDouble(float leagueProbDouble) {
        this.leagueProbDouble = leagueProbDouble;
    }

    public float getLeagueProbTriple() {
        return leagueProbTriple;
    }

    public void setLeagueProbTriple(float leagueProbTriple) {
        this.leagueProbTriple = leagueProbTriple;
    }

    public float getLeagueProbHomeRun() {
        return leagueProbHomeRun;
    }

    public void setLeagueProbHomeRun(float leagueProbHomeRun) {
        this.leagueProbHomeRun = leagueProbHomeRun;
    }

    public float getLeagueProbStrikeOut() {
        return leagueProbStrikeOut;
    }

    public void setLeagueProbStrikeOut(float leagueProbStrikeOut) {
        this.leagueProbStrikeOut = leagueProbStrikeOut;
    }
}

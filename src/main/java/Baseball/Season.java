package Baseball;

public class Season {
    private float leagueProbWalk, leagueProbSingle, leagueProbDouble, leagueProbTriple, leagueProbHomeRun, leagueProbStrikeOut;
    private int yearID;
    private String alEastChamp, alCentralChamp, alWestChamp, alWildCard, alDivisionSeries1, alDivisionSeries2, alChampion,
    alMvp, alCyYoung, nlEastChamp, nlCentralChamp, nlWestChamp, nlWildCard, nlDivisionSeries1, nlDivisionSeries2,
    nlChampion, worldSeriesChamp, al1bSilver, al2bSilver, al3bSilver, alSsSilver, alCsilver, alDhSilver, alLfSilver,
    alCfSilver, alRfSilver, nl1bSilver, nl2b,Silver, nl3bSilver, nlSsSilver, nlCsilver, nlPsilver, nlLfSilver, nlCfSilver,
    nlRfSilver;

    public Season() {}

    public Season( float leagueProbWalk, float leagueProbSingle, float leagueProbDouble, float leagueProbTriple, float leagueProbHomeRun, float leagueProbStrikeOut) {
        this.leagueProbWalk = leagueProbWalk;
        this.leagueProbSingle = leagueProbSingle;
        this.leagueProbDouble = leagueProbDouble;
        this.leagueProbTriple = leagueProbTriple;
        this.leagueProbHomeRun = leagueProbHomeRun;
        this.leagueProbStrikeOut = leagueProbStrikeOut;
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

    public int getYearID()
    {
        return yearID;
    }

    public void setYearID( int yearID )
    {
        this.yearID = yearID;
    }

    public String getAlEastChamp()
    {
        return alEastChamp;
    }

    public void setAlEastChamp( String alEastChamp )
    {
        this.alEastChamp = alEastChamp;
    }

    public String getAlCentralChamp()
    {
        return alCentralChamp;
    }

    public void setAlCentralChamp( String alCentralChamp )
    {
        this.alCentralChamp = alCentralChamp;
    }

    public String getAlWestChamp()
    {
        return alWestChamp;
    }

    public void setAlWestChamp( String alWestChamp )
    {
        this.alWestChamp = alWestChamp;
    }

    public String getAlWildCard()
    {
        return alWildCard;
    }

    public void setAlWildCard( String alWildCard )
    {
        this.alWildCard = alWildCard;
    }

    public String getAlDivisionSeries1()
    {
        return alDivisionSeries1;
    }

    public void setAlDivisionSeries1( String alDivisionSeries1 )
    {
        this.alDivisionSeries1 = alDivisionSeries1;
    }

    public String getAlDivisionSeries2()
    {
        return alDivisionSeries2;
    }

    public void setAlDivisionSeries2( String alDivisionSeries2 )
    {
        this.alDivisionSeries2 = alDivisionSeries2;
    }

    public String getAlChampion()
    {
        return alChampion;
    }

    public void setAlChampion( String alChampion )
    {
        this.alChampion = alChampion;
    }

    public String getAlMvp()
    {
        return alMvp;
    }

    public void setAlMvp( String alMvp )
    {
        this.alMvp = alMvp;
    }

    public String getAlCyYoung()
    {
        return alCyYoung;
    }

    public void setAlCyYoung( String alCyYoung )
    {
        this.alCyYoung = alCyYoung;
    }

    public String getNlEastChamp()
    {
        return nlEastChamp;
    }

    public void setNlEastChamp( String nlEastChamp )
    {
        this.nlEastChamp = nlEastChamp;
    }

    public String getNlCentralChamp()
    {
        return nlCentralChamp;
    }

    public void setNlCentralChamp( String nlCentralChamp )
    {
        this.nlCentralChamp = nlCentralChamp;
    }

    public String getNlWestChamp()
    {
        return nlWestChamp;
    }

    public void setNlWestChamp( String nlWestChamp )
    {
        this.nlWestChamp = nlWestChamp;
    }

    public String getNlWildCard()
    {
        return nlWildCard;
    }

    public void setNlWildCard( String nlWildCard )
    {
        this.nlWildCard = nlWildCard;
    }

    public String getNlDivisionSeries1()
    {
        return nlDivisionSeries1;
    }

    public void setNlDivisionSeries1( String nlDivisionSeries1 )
    {
        this.nlDivisionSeries1 = nlDivisionSeries1;
    }

    public String getNlDivisionSeries2()
    {
        return nlDivisionSeries2;
    }

    public void setNlDivisionSeries2( String nlDivisionSeries2 )
    {
        this.nlDivisionSeries2 = nlDivisionSeries2;
    }

    public String getNlChampion()
    {
        return nlChampion;
    }

    public void setNlChampion( String nlChampion )
    {
        this.nlChampion = nlChampion;
    }

    public String getWorldSeriesChamp()
    {
        return worldSeriesChamp;
    }

    public void setWorldSeriesChamp( String worldSeriesChamp )
    {
        this.worldSeriesChamp = worldSeriesChamp;
    }

    public String getAl1bSilver()
    {
        return al1bSilver;
    }

    public void setAl1bSilver( String al1bSilver )
    {
        this.al1bSilver = al1bSilver;
    }

    public String getAl2bSilver()
    {
        return al2bSilver;
    }

    public void setAl2bSilver( String al2bSilver )
    {
        this.al2bSilver = al2bSilver;
    }

    public String getAl3bSilver()
    {
        return al3bSilver;
    }

    public void setAl3bSilver( String al3bSilver )
    {
        this.al3bSilver = al3bSilver;
    }

    public String getAlSsSilver()
    {
        return alSsSilver;
    }

    public void setAlSsSilver( String alSsSilver )
    {
        this.alSsSilver = alSsSilver;
    }

    public String getAlCsilver()
    {
        return alCsilver;
    }

    public void setAlCsilver( String alCsilver )
    {
        this.alCsilver = alCsilver;
    }

    public String getAlDhSilver()
    {
        return alDhSilver;
    }

    public void setAlDhSilver( String alDhSilver )
    {
        this.alDhSilver = alDhSilver;
    }

    public String getAlLfSilver()
    {
        return alLfSilver;
    }

    public void setAlLfSilver( String alLfSilver )
    {
        this.alLfSilver = alLfSilver;
    }

    public String getAlCfSilver()
    {
        return alCfSilver;
    }

    public void setAlCfSilver( String alCfSilver )
    {
        this.alCfSilver = alCfSilver;
    }

    public String getAlRfSilver()
    {
        return alRfSilver;
    }

    public void setAlRfSilver( String alRfSilver )
    {
        this.alRfSilver = alRfSilver;
    }

    public String getNl1bSilver()
    {
        return nl1bSilver;
    }

    public void setNl1bSilver( String nl1bSilver )
    {
        this.nl1bSilver = nl1bSilver;
    }

    public String getNl2b()
    {
        return nl2b;
    }

    public void setNl2b( String nl2b )
    {
        this.nl2b = nl2b;
    }

    public String getSilver()
    {
        return Silver;
    }

    public void setSilver( String silver )
    {
        Silver = silver;
    }

    public String getNl3bSilver()
    {
        return nl3bSilver;
    }

    public void setNl3bSilver( String nl3bSilver )
    {
        this.nl3bSilver = nl3bSilver;
    }

    public String getNlSsSilver()
    {
        return nlSsSilver;
    }

    public void setNlSsSilver( String nlSsSilver )
    {
        this.nlSsSilver = nlSsSilver;
    }

    public String getNlCsilver()
    {
        return nlCsilver;
    }

    public void setNlCsilver( String nlCsilver )
    {
        this.nlCsilver = nlCsilver;
    }

    public String getNlPsilver()
    {
        return nlPsilver;
    }

    public void setNlPsilver( String nlPsilver )
    {
        this.nlPsilver = nlPsilver;
    }

    public String getNlLfSilver()
    {
        return nlLfSilver;
    }

    public void setNlLfSilver( String nlLfSilver )
    {
        this.nlLfSilver = nlLfSilver;
    }

    public String getNlCfSilver()
    {
        return nlCfSilver;
    }

    public void setNlCfSilver( String nlCfSilver )
    {
        this.nlCfSilver = nlCfSilver;
    }

    public String getNlRfSilver()
    {
        return nlRfSilver;
    }

    public void setNlRfSilver( String nlRfSilver )
    {
        this.nlRfSilver = nlRfSilver;
    }
}

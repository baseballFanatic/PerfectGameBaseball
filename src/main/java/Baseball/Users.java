package Baseball;

public class Users
{
    private String username;
    private int recentYear;
    private String displayName;

    public Users()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public int getRecentYear()
    {
        return recentYear;
    }

    public void setRecentYear( int season )
    {
        this.recentYear = season;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }
}

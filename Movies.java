public class Movies
{
    private final String title;
    private static int ID = 800000; //Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Movie Rating
    private String description;
    private String status = "Planned";
    private int durationinmins;

    //Constructor Methods here
    public Movies(String title, String studio, int durationinmins)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        ID++;
    }
    public Movies(String title, String studio, int durationinmins, String status)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        this.status = status;
        ID++;
    }
    public Movies(String title, String studio,String status)
    {
        this.title = title;
        this.studio = studio;
        this.status = status;
        ID++;
    }
    //Getter Methods here
    public String getStatus()
    {
        return status;
    }
    public String getDescription()
    {
        return description;
    }
    public int getID()
    {
        return ID;
    }
    public String getTitle()
    {
        return title;
    }
    public String getStudio()
    {
        return studio;
    }
    public Rating getRating()
    {
        return rating;
    }
    public int getDurationinmins()
    {
        return durationinmins;
    }
}


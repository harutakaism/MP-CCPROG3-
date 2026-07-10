public class Anime
{
    private final String title;
    private int ID = 100000; //Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Anime Rating
    private int episodes;
    private String[] episodedescription;
    private String status = "Planned";
    private int durationinmins;

    //Constructor Methods here
    public Anime(String title, String studio, String status)
    {
        this.title = title;
        this.studio = studio;
        this.status = status;
        ID++;
    }
    public Anime(String title, String studio)
    {
        this.title = title;
        this.studio = studio;
        ID++;
    }
    public Anime(String title, String studio, int episodes)
    {
        this.title = title;
        this.studio = studio;
        this.episodes = episodes;
        ID++;
    }
    public Anime(String title, String studio, int episodes, String status)
    {
        this.title = title;
        this.studio = studio;
        this.episodes = episodes;
        this.status = status;
        ID++;
    }
    //Getter Methods here
    public String getStatus()
    {
        return status;
    }
    public String[] getEpisodedescription()
    {
        return episodedescription;
    }
    public int getEpisodes()
    {
        return episodes;
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

// test

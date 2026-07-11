public class Anime
{
    private final String title;
    private int id = 100000;
    private static int incre = 0; //Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Anime Rating
    private String description;
    private String status = "Planned";
    private int durationinmins;
    private int season;
    private int[] episodes = new int[season];

    //Constructor Methods here
    public Anime(String title, String studio, String status)
    {
        this.title = title;
        this.studio = studio;
        this.status = status;
        incre++;
        this.id = id + incre;
    }
    public Anime(String title, String studio)
    {
        this.title = title;
        this.studio = studio;
        incre++;
        this.id = id + incre;
    }
    public Anime(String title, String studio, int[] episodes, int season, String status)
    {
        this.title = title;
        this.studio = studio;
        this.episodes = episodes;
        this.status = status;
        this.season = season;
        incre++;
        this.id = id + incre;
    }
    //Getter Methods here
    public String getStatus()
    {
        return status;
    }
    public String getEpisodedescription()
    {
        return description;
    }
    public int[] getEpisodes()
    {
        return episodes;
    }
    public int getID()
    {
        return id;
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
    public int getSeason()
    {
        return season;
    }
    public void displayInfo()
    {
        System.out.println(title);
        System.out.println("Production Studio: " + studio);
        System.out.println("Rating: " + rating.GetOverallrating());
        System.out.println("Season: " + season);
        for(int i = 0; i < season; i++)
        {
            System.out.println("Season " + (i+1) + ": ");
            System.out.println("Episodes: " + episodes[i]);
        }

        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id );
    }
}

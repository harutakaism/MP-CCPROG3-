public class Anime
{
    private final String title;
    private int id = 100000; //Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Anime Rating
    private int episodes;
    private String description;
    private String status = "Planned";
    private int durationinmins;
    private int season;

    //Constructor Methods here
    public Anime(String title, String studio, String status)
    {
        this.title = title;
        this.studio = studio;
        this.status = status;
        id++;
    }
    public Anime(String title, String studio)
    {
        this.title = title;
        this.studio = studio;
        id++;
    }
    public Anime(String title, String studio, int episodes)
    {
        this.title = title;
        this.studio = studio;
        this.episodes = episodes;
        id++;
    }
    public Anime(String title, String studio, int episodes, String status)
    {
        this.title = title;
        this.studio = studio;
        this.episodes = episodes;
        this.status = status;
        id++;
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
    public int getEpisodes()
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
        System.out.println("Episodes: " + episodes);
        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id );
    }
}

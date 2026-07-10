public class ManhwaToMangaDesu 
{
  public class ManhwaToMangaDesu
{
    private final String title;
    private static int ID = 100000; //Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Anime Rating
    private int volume;
    private String[] episodedescription;
    private String status;
    private int season;

    //Constructor Methods here
    public ManhwaToMangaDesu(String title, String studio)
    {
        this.title = title;
        this.studio = studio;
        ID++;
    }
    public ManhwaToMangaDesu(String title, String studio, int volume)
    {
        this.title = title;
        this.studio = studio;
        this.volume = volume;
        ID++;
    }
    public ManhwaToMangaDesu(String title, String studio, int volume, String status)
    {
        this.title = title;
        this.studio = studio;
        this.volume = volume;
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
    public int getVolume()
    {
        return volume;
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
    public int getSeason()
    {
        return season;
    }
}

}

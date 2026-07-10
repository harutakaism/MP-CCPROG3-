public class Anime
{
    private final String title;
    private static int ID = 100000;
    private final String studio;
    private Rating rating; //Anime Rating

    //Constructor Methods here
    public Anime(String title, String studio)
    {
        this.title = title;
        this.studio = studio;
        ID++;
    }
    //Getter Methods here
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

}

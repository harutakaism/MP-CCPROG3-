public class MediaMultiple extends MediaSingle
{

    private int season;
    private int[] episodes;
    private int sum;
    private Rating[] rating = new Rating[256]; //Movie Rating
    public int i;


    //Constructor Methods here
    public MediaMultiple(String title, String studio, String status)
    {
        super(title, studio, status);
    }
    public MediaMultiple(String title, String studio, int[] episodes, int season, String status)
    {
        super(title, studio, status);
        this.episodes = episodes;
        this.status = status;
        this.season = season;
    }
    //Getter Methods here
    public String getEpisodedescription()
    {
        return description;
    }
    public int[] getEpisodes()
    {
        return episodes;
    }
    public int getSeason()
    {
        return season;
    }
    public void displayMultiInfo()
    {
        System.out.println(title);
        System.out.println("Production Studio: " + studio);
        System.out.println("Rating: " + rating[0].GetOverallrating());
        System.out.println("Seasons: " + season);
        for(i = 0; i < season; i++)
        {
            System.out.println("Season " + (i+1) + ":" + episodes[i] + " Episode/s");
            sum += episodes[i];
        }
        for(i = 0; i < season; i++)
        {
            for(int j = 0;  j < episodes[i]; j++)
            {
                System.out.println("Season [" + i + "]: Episode #" + j + ": " +rating[(i+1) * (j+1)]);
            }
        }
        System.out.println("Total Episodes: " + sum );
        System.out.println();
        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id );
    }
}

public class Anime extends MediaEntry {
    private final String title;
    private int id = 100000;
    private static int incre = 0; //Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Anime Rating
    private String description;
    private String status;
    private int season;
    private int[] episodes;
    private int sum;

    /**
     * Anime is a constructor with 5 parameters that instantiate a new object of type Anime
     * @param title is the title/name of the Anime
     * @param studio is the studio/production that made or produced the Anime
     * @param episodes is the number of episodes stored in an array, dependent on the number of seasons
     * @param season is the number of seasons an Anime contains
     * @param status is the status of the Anime (Planned, Completed, In Progress)
     */
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
    /**
     * getDescription is a getter method that returns the description of the Anime
     * @return the string containing description of the Anime
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * getStatus is a getter method that returns the status of the Anime
     * @return the string containing the status of the Anime (planned, in progress or completed)
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * getEpisodes is a getter method that returns the number of episodes per season (in fixed array form)
     * @return the array of integers containing the number of episodes per season
     */
    public int[] getEpisodes()
    {
        return episodes;
    }

    /**
     * getID is a getter method that returns the ID of the Anime
     * @return the ID number
     */
    public int getID()
    {
        return id;
    }

    /**
     * getTitle is a getter method that returns the title name of the Anime
     * @return the title name of the Anime
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * getStudio is a getter method that returns the studio/production that created the Anime
     * @return the studio/production of the Anime
     */
    public String getStudio()
    {
        return studio;
    }
    /**
     * getRating is a getter method that returns the rating (as an object)
     * @return the object Rating for rating-related information
     */
    public Rating getRating()
    {
        return rating;
    }

    /**
     *  getSeason is a getter method that returns the number of seasons
     * @return the number of seasons an Anime contains
     */
    public int getSeason()
    {
        return season;
    }
    /**
     * getMediaType is a getter method that returns the type of media (Anime)
     * @return "Anime" since media type of the objects under this class are anime
     */
    public String getMediaType()
    {
        return "Anime";
    }
    /**
     * displayInfo is a method that displays the overall information of an Anime
     */
    public void displayInfo() {
        System.out.println(title);
        System.out.println("Production Studio: " + studio);
        System.out.println("Rating: " + rating.GetOverallrating());
        System.out.println("Seasons: " + season);
        System.out.println();
        for (int i = 0; i < season; i++) {
            System.out.println("Season " + (i + 1) + ":" + episodes[i] + " Episode/s");
            sum += episodes[i];
        }
        System.out.println("Total Episodes: " + sum);
        System.out.println();
        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id);
    }
    /**
     * setDescription is a setter Method that sets the description of an Anime
     * @param strNewdescription is the new description to be set
     */
    public void setDescription(String strNewdescription)
    {
        this.description = strNewdescription;
    }
}

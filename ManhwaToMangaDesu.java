public class ManhwaToMangaDesu extends MediaEntry {
    private final String title;
    private int id = 100000;
    private static int incre = 1;//Static to generate unique ID
    private final String studio;
    private Rating rating = new Rating(); //Anime Rating
    private int volume;
    private String description;
    private String status;
    private int[] chapter;

    /**
     * ManhwaToMangaDesu is a constructor with 5 parameters (title, studio, volume, status, chapter)
     * that is used to instantiate a new object of ManhwaToMangaDesu
     * @param title is a string that contains the title of the Manga
     * @param studio is a string that contains the name of the studio/production of the Manga
     * @param volume is an integer containing the number of volumes a Manga has
     * @param status is a string containing the status (planned, in progress or completed)
     * @param chapter is an array of integers that contain the number of chapters per volume  
     */
    public ManhwaToMangaDesu(String title, String studio, int volume, String status, int[] chapter) 
    {
        this.title = title;
        this.studio = studio;
        this.volume = volume;
        this.status = status;
        this.chapter = chapter;
        incre++;
        this.id = id + incre;
    }
    /**
     * getStatus is a getter method that returns the status of the Manga
     * @return the string containing the status of the Manga (planned, in progress or completed)
     */
    public String getStatus() 
    {
        return status;
    }
    /**
     * getDescription is a getter method that gets description
     * @return the string containing the description of the Manga
     */
    public String getDescription() 
    {
        return description;
    }
    /**
     * getVolume is a getter method that returns the volume
     * @return the integer number containing the number of volumes a Manga contains
     */
    public int getVolume() 
    {
        return volume;
    }
    /**
     * getID is a getter method that returns the ID of the Manga
     * @return the integer number containing the ID of the Manga
     */
    public int getID() 
    {
        return id;
    }
    /**
     * getTitle is a getter method that returns the String of the title of the Manga
     * @return the string containing the title of the Manga
     */
    public String getTitle() 
    {
        return title;
    }
    /**
     * getStudio is a getter method that returns the String containing the studio/production
     * @return the string containing the studio/production of the Manga
     */
    public String getStudio()
    {
        return studio;
    }
    /**
     * getRating is a getter method that returns the rating (as an object) of the Manga
     * @return the object of Rating of the Manga
     */
    public Rating getRating()
    {
        return rating;
    }
    /**
     * getChapter is a getter method that returns the array of chapters per volume
     * @return the integer array containing the number of chapters per volume
     */
    public int[] getChapter()
    {
        return chapter;
    }
    /**
     * getMediaType is a getter method that returns the type of media (Manga/Manhwa)
     * @return the String "Manga/Manhwa" as the media type of the object is a Manga/Manhwa
     */
    public String getMediaType()
    {
        return "Manga/Manhwa";
    }

    /**
     * displayInfo is a method that is used for displaying information of a Manga
     */
    public void displayInfo()
    {
        System.out.println(title);
        System.out.println("Production Studio: " + studio);
        System.out.println("Rating: " + rating.GetOverallrating());
        System.out.println("Volumes: " + volume);
        for(int i = 0; i < volume; i++)
        {
            System.out.println("Number of Chapters in Volume " + (i+1) + ": " + chapter[i]);
        }

        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id );
    }
    /**
     * setDescription is a setter method that updates the description using the parameter
     * @param strNewdescription is a string containing the new description to be used
     */
    public void setDescription(String strNewdescription)
    {
        this.description = strNewdescription;
    }
}

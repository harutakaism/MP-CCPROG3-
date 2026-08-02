public class EpisodeChapter
{
    private String title;
    private String description;

    /**
     * EpisodeChapter is a constructor with 2 parameters that contain a title and description
     * @param title is the string containing the title of the episode
     * @param desc is the string containing the description of the episode
     */
    public EpisodeChapter(String title, String desc, int length)
    {
        this.title = title;
        this.description = desc;
        this.length = length;
    }

    /**
     * setDescription is a setter method that updates the description of an episode
     * @param desc is the new description to be setted
     */
    public void setDescription(String desc)
    {
        this.description = desc;
    }

    /**
     * setTitle is a setter method that updates the title of an episode
     * @param title is the new title to be setted
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * setLength is a setter method that updates the length of an episode or chapter.
     * For anime episodes, the length represents minutes. For manga/manhwa chapters,
     * the length may represent pages or chapter length.
     * @param length is the new length value to be set
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * getTitle is a getter method that returns the title of the episode
     * @return the string containing the title of the episode
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * getDescription is a getter method that returns the description of the episode
     * @return the string containing the description of the episode
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * getLength is a getter method that returns the length of an episode or chapter.
     * @return the integer value containing the episode length in minutes or the chapter length/pages
     */
     public int getLength()
    {
        return length;
    }
}

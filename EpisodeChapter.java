public class EpisodeChapter 
{
    private String title;
    private String description;
    private int length;
    
    public EpisodeChapter(String title, String desc, int length)
    {
        this.title = title;
        this.description = desc;
        this.length = length;
    }
    public void setDescription(String desc)
    {
        this.description = desc;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setLength(int length)
    {
        this.length = length;
    }
    public String getTitle()
    {
        return title;
    }
    public String getDescription()
    {
        return description;
    }
    public int getLength()
    {
        return length;
    }
}

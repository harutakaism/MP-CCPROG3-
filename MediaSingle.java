public class MediaSingle  //Movie
{
    protected final String title;
    protected int id = 800000;
    protected static int incre = 0;
    protected final String studio;
    protected String description;
    protected String status = "Planned";
    private int durationinmins;
    private Rating rating = new Rating(); //Movie Rating

    //Constructor Methods here
    public MediaSingle(String title, String studio, int durationinmins)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        incre++;
        this.id = id + incre;

    }
    public MediaSingle(String title, String studio, int durationinmins, String status)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        this.status = status;
        incre++;
        this.id = id + incre;
    }
    public MediaSingle(String title, String studio,String status)
    {
        this.title = title;
        this.studio = studio;
        this.status = status;
        incre++;
        this.id = id + incre;

    }
    //Getter Methods here
    public String getStatus()
    {
        return status;
    }
    public String getDescription()
    {
        return description;
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
    public void displayInfo()
    {
        System.out.println(title);
        System.out.println("Production Studio: " + studio);
        System.out.println("Rating: " + rating.GetOverallrating());
        System.out.println("Duration: ");
        if(durationinmins < 60)
        {
            System.out.println( durationinmins +" Minutes ");
        }
        else
        {
            if(durationinmins < 120)
            {
                System.out.print("1 Hour ");
            }
            else
            {
                System.out.print( durationinmins / 60 + " Hours ");
            }
        }
        if(durationinmins % 60 != 0 && durationinmins > 60)
        {
            if(durationinmins % 60 == 1)
            {
                System.out.print(", 1 Minute");
            }
            else
            {
                System.out.print(", " + durationinmins % 60 + " Minutes");
            }
        }
        if(durationinmins == 0)
        {
            System.out.println("N/A");
        }
        System.out.println();
        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id );
    }
    public void setStatus(String strNewstatus)
    {
        this.status = strNewstatus;
    }
    public void setDescription(String strNewdescription)
    {
        this.description = strNewdescription;
    }
    public void rateMedia(int UserRate)
    {
        if(status.equals("Completed"))
        {
            rating.Rate(UserRate);
        }
        else
        {
            System.out.println("Only completed entries can be rated.");
        }
    }
    public void addReview(String review)
    {
        if(status.equals("Completed"))
        {
            rating.setReview(review);
        }
        else
        {
            System.out.println("Only completed entries can have reviews.");
        }
    }
}

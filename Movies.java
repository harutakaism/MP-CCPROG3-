public class Movies
{
    private final String title;
    private int id = 800000;
    private static int incre = 0;
    private final String studio;
    private Rating rating = new Rating(); //Movie Rating
    private String description;
    private String status = "Planned";
    private int durationinmins;

    //Constructor Methods here
    public Movies(String title, String studio, int durationinmins)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        incre++;
        this.id = id + incre;

    }
    public Movies(String title, String studio, int durationinmins, String status)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        this.status = status;
        incre++;
        this.id = id + incre;
    }
    public Movies(String title, String studio,String status)
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
}




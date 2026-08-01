public class Movies extends MediaEntry
{
    private final String title;
    private int id = 800000;
    private static int incre = 0;
    private final String studio;
    private Rating rating = new Rating(); //Movie Rating
    private String description;
    private String status = "Planned";
    private int durationinmins;

    /**
     * Movies is a constructor with three parameters (title, studio, duration) and
     * Constructs the Movie Object given its title, studio and duration
     * @param title the name of a movie
     * @param studio the name of the studio
     * @param durationinmins the duration of a movie
     */
    public Movies(String title, String studio, int durationinmins)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        incre++;
        this.id = id + incre;

    }
    /**
     * Movies is a constructor with four parameters (title, studio, duration, status) and Constructs the Movie 
     * Object given its title, studio and duration, and status
     * @param title the name of a movie
     * @param studio the name of the studio
     * @param durationinmins the duration of a movie
     * @param status is the progress of the movie
     */
    public Movies(String title, String studio, int durationinmins, String status)
    {
        this.title = title;
        this.studio = studio;
        this.durationinmins = durationinmins;
        this.status = status;
        incre++;
        this.id = id + incre;
    }
    /**
     * Movies is a constructor with three parameters (title, studio, status) and Constructs the Movie Object given 
     * its title, studio and duration, and status
     * @param title the name of a movie
     * @param studio the name of the studio
     * @param status is the progress of the movie
     */
    public Movies(String title, String studio,String status)
    {
        this.title = title;
        this.studio = studio;
        this.status = status;
        incre++;
        this.id = id + incre;

    }
    /**
     * getStatus is a getter method that returns the status
     * @return the watch status or progress of a movie.
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * getDescription is a getter method that returns the description
     * @return the string of the description of the movie.
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * getID is a getter method that returns the ID
     * @return the ID value
     */
    public int getID()
    {
        return id;
    }
    /**
     * getTitle is a getter method that returns the title
     * @return the string of the name/title of movie
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * getStudio is a getter method that returns the name of studio/production
     * @return the name of the studio/production
     */
    public String getStudio()
    {
        return studio;
    }
    /**
     * getRating is a getter method that returns the rating
     * @return the rating (not the integer).
     */
    public Rating getRating()
    {
        return rating;
    }
    /**
     * getDurationinmins is a Getter Method that returns the duration of a movie in minutes
     * @return the int duration in minutes.
     */
    public int getDurationinmins()
    {
        return durationinmins;
    }

    /**
     * getMediaType is a Getter method that returns the type of media
     * @return "movies" since the class falls under movie.
     */
    public String getMediaType()
    {
        return "Movie";
    }
    /**
     * displayInfo is a Method that displays all the info of a movie film
     */
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

    /**
     * strNewstatus is a Setter Method that sets the Status
     * @param strNewstatus is the new status/progress of the watching of the movie.
     */
    public void setStatus(String strNewstatus)
    {
        this.status = strNewstatus;
    }
    /**
     * setDescription is a setter Method that sets the description
     * @param strNewdescription is the new description to place
     */
    public void setDescription(String strNewdescription)
    {
        this.description = strNewdescription;
    }
    /**
     * rateMedia is a function that allows the user to give a rating given it is valid
     * @param UserRate is the rating of user (in integer form)
     */
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
    /**
     * addReview is a Setter Method that sets the review of a movie
     * @param review is the review in string form to set.
     */
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





public class Rating
{
    private int numberofratings;
    private float overallrating;
    private int sum;
    private int recentrate;
    private String review;
    
    /**
     * Constructor that creates the ratings to be used for the media types
     *
     */
    public Rating()
    {
        numberofratings = 0;
        overallrating = 0.0f;
        sum = 0;
        recentrate = 0;
        review = "";
    }
    /**
     * Getter Method that returns the number of ratings
     *
     * @return ther number of ratings a piece has recieved.
     */
    public int getNumberOfRatings()
    {
        return numberofratings;
    }
    /**
     * Getter Method that returns the average rating
     *
     * @return the average rating of a piece.
     */
    public float GetOverallrating()
    {
        return overallrating;
    }
    /**
     * Getter Method that returns the rating score recently
     *
     * @return the recently given rating
     */
    public int getRecentrate()
    {
        return recentrate;
    }
    /**
     * Getter Method that returns the review of a piece.
     *
     * @return the string that contains the review of a piece.
     */
    public String getReview()
    {
        return review;
    }

    /**
     * Method that checks if a media piece has a rating or not.
     *
     * @return the boolean value whether it has a rating or not.
     */
    public boolean hasRating()
    {
        return numberofratings > 0;
    }

    /**
     * Setter Method that sets the string for review
     *
     * @param review the review to add to the media piece during rating period.
     */
    public void setReview(String review)
    {
        this.review = review;
        System.out.println("Review added!");
    }

     /**
     * Allows the user to rate a specific media piece by passing its rating as a parameter and contribute it to
     * the overall rating of the media piece.
     * 
     * @param UserRate the users given rating on a specific media piece
     */
    public void Rate(int UserRate)
    {
        if(UserRate > 10 || UserRate < 1)
        {
            System.out.println("Rating voided: Please rate from 1-10");
        }
        else
        {
            recentrate = UserRate;
            numberofratings++;
            sum += UserRate;
            overallrating = (float)sum / numberofratings;
            System.out.println("Rating added!");
        }
    }

}

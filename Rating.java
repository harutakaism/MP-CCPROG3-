public class Rating
{
    private int numberofratings;
    private float overallrating;
    private int sum;
    private int recentrate;
    private String review;


    //Default Constructor can only be used
    public Rating()
    {
        numberofratings = 0;
        overallrating = 0.0f;
        sum = 0;
        recentrate = 0;
        review = "";
    }

    //Getter Methods

    public int getNumberOfRatings()
    {
        return numberofratings;
    }
    public float GetOverallrating()
    {
        return overallrating;
    }
    public int getRecentrate()
    {
        return recentrate;
    }
    public String getReview()
    {
        return review;
    }
    public boolean hasRating()
    {
        return numberofratings > 0;
    }
    public void setReview(String review)
    {
        this.review = review;
        System.out.println("Review added!");
    }

    //Setter Methods??? 
    
    public void Rate(int UserRate)
    {
        if(UserRate > 10 || UserRate < 0)
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

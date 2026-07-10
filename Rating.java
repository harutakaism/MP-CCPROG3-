public class Rating
{
    private int numberofratings;
    private float overallrating;
    private int sum;
    private int recentrate;


    //Default Constructor can only be used
    
    //Getter Methods

    public float GetOverallrating()
    {
        return overallrating;
    }
    public int getRecentrate()
    {
        return recentrate;
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

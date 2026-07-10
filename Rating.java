public class Rating
{
    private int numberofratings;
    private float overallrating;
    private int sum;


    public void Rate(int UserRate)
    {
        if(UserRate > 10 || UserRate < 0)
        {
            System.out.println("Rating voided: Please rate from 1-10");
        }
        else
        {
            numberofratings++;
            sum += UserRate;
            overallrating = (float)sum / numberofratings;
            System.out.println("Rating added!");
        }
    }
    public float GetOverallrating()
    {
        return overallrating;
    }

}

public abstract class MediaEntry
{
    public abstract int getID();

    public abstract String getTitle();

    public abstract String getStatus();

    public abstract void setStatus(String strNewstatus);

    public abstract void rateMedia(int UserRate);

    public abstract void addReview(String review);

    public abstract void displayInfo();

    public abstract String getMediaType();
}
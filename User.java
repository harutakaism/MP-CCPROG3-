public class User
{
    private int id = 100000000;
    private static int incre = 0;
    private String username;
    private Library library = new Library();
    private String password;
    private String bio;

    //Constructors here
    User(String username, String password)
    {
        this.username = username;
        this.password = password;
        incre++;
        this.id = id + incre;
    }
    //Getters here
    public int getId()
    {
        return id;
    }
    public String getUsername()
    {
        return username;
    }
    public Library getLibrary()
    {
        return library;
    }
    public String getPassword()
    {
        return password;
    }
    public String getBio()
    {
        return bio;
    }

}

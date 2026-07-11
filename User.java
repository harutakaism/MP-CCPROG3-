public class User
{
    private static int id = 100000000;
    private String username;
    private Library library = new Library();
    private String password;
    private String bio;

    //Constructors here
    User(String username, String password)
    {
        this.username = username;
        this.password = password;
        id++;
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


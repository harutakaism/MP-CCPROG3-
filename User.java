public class User
{
    private int id = 100000000;
    private static int incre = 0;
    private String username;
    private Library library = new Library();
    private String password;
    private String bio;

    /**
     * Creates a new User with username and password as parameter.
     *
     * @param username is user's chosen username
     * @param password is user's chosen password
     */
    User(String username, String password)
    {
        this.username = username;
        this.password = password;
        incre++;
        this.id = id + incre;
    }

    /**
     * Getter Method that returns the ID
     *
     * @return the number for the ID of a User
     */
    public int getId()
    {
        return id;
    }
    /**
     * Getter Method that returns the Username
     *
     * @return the string of the user's Username
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * Getter Method that returns the Library
     *
     * @return the library of the user that holds its saved media pieces.
     */
    public Library getLibrary()
    {
        return library;
    }
    /**
     * Getter Method that returns the Password
     *
     * @return the String password of a user
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * Getter Method that returns the Biography of a user
     *
     * @return the string of a user's Bio
     */
    public String getBio()
    {
        return bio;
    }

}

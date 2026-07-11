import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
void main()
{
    int numchoice, builds, i;
    String tempo1, tempo2;
    Anime anime;
    Movies movie;
    ManhwaToMangaDesu manga;
    String[] builder = new String[5];
    Scanner sc = new Scanner(System.in);
    ArrayList<User> a = new ArrayList<>();
    User currentuser = null;
    boolean loggedin = false;
    boolean exist = false;
    System.out.println("Welcome to OtakuVault!");
    while (!loggedin)
    {
        System.out.println("[1] Log In | [2] Create Account");
        do
        {
            numchoice = sc.nextInt();
        }
        while (numchoice != 1 && numchoice != 2);

        if (numchoice == 2)
        {
            System.out.println("[New Account] Enter Username: ");
            tempo1 = sc.next();
            System.out.println("[New Account] Enter Password: ");
            tempo2 = sc.next();
            a.add(new User(tempo1, tempo2));
        }
        else
        {
            System.out.println("[Log In] Enter Username: ");
            tempo1 = sc.next();
            System.out.println("[Log In] Enter Password: ");
            tempo2 = sc.next();
            for (User user : a)
            {
                if (user.getUsername().contentEquals(tempo1) && user.getPassword().contentEquals(tempo2))
                {
                    currentuser = user;
                    loggedin = true;
                    System.out.println("Successful login, welcome " + currentuser.getUsername() + "!");
                }
            }
            if(!loggedin)
            {
                System.out.println("Login Failed: Username/Password does not match.");
            }
        }
    }
    //User Interface
    do
    {
        System.out.println("Hai Hai " + currentuser.getUsername() + "! What would you like to do today?");
        System.out.println("[1] View Library | [2] Add to Library | [3] View Stats | ");
        System.out.print("[4] Rate Completed Entry | [5] Log Out ");
        do
        {
            numchoice = sc.nextInt();
        }
        while (numchoice < 1 || numchoice > 5);
        switch (numchoice) {
            case 1:
                System.out.println("[View Library]");
                System.out.println("[1] View All | [2] View by Movies | [3] View by Anime | [4] View by Manga/Manhwa");
                do
                {
                    numchoice = sc.nextInt();
                }
                while(numchoice < 1 || numchoice > 4);
                if(numchoice == 1)
                {
                    currentuser.getLibrary().displayAllEntries();
                }
                if(numchoice == 2)
                {
                    currentuser.getLibrary().displayMovies();
                }
                if(numchoice == 3)
                {
                    currentuser.getLibrary().displayAnime();
                }
                if(numchoice == 4)
                {
                    currentuser.getLibrary().displayManga();
                }
                break;
            case 2:
                System.out.println("[Add to Library]");
                System.out.println("[1] Movie | [2] Anime | [3] Manga");
                System.out.println("Enter Type: ");
                do
                {
                    numchoice = sc.nextInt();
                }
                while (numchoice < 1 || numchoice > 3);

                if (numchoice == 1) {
                    System.out.println("Enter Title: ");
                    builder[0] = sc.next();
                    System.out.println("Enter Studio: ");
                    builder[1] = sc.next();
                    System.out.println("Status on the Movie?");
                    System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                    do {
                        numchoice = sc.nextInt();
                        if (numchoice < 1 || numchoice > 3) {
                            System.out.println("Please Choose a number from 1-3!");
                        }
                    }
                    while (numchoice < 1 || numchoice > 3);
                    if (numchoice == 1) {
                        builder[2] = "Planned";
                    } else if (numchoice == 2) {
                        builder[2] = "In Progress";
                    } else {
                        builder[2] = "Completed";
                    }
                    System.out.println("Do you know the Duration of the Movie?");
                    System.out.println("[1] Yes | [2] No");
                    do {
                        numchoice = sc.nextInt();
                        if (numchoice != 1 && numchoice != 2) {
                            System.out.println("Error: Invalid Input!");
                        }
                    }
                    while (numchoice != 1 && numchoice != 2);
                    if (numchoice == 1) {
                        System.out.println("Enter the Duration of the Movie (in Minutes Form)");
                        builds = sc.nextInt();
                        movie = new Movies(builder[0], builder[1], builds, builder[2]);
                    } else {
                        movie = new Movies(builder[0], builder[1], builder[2]);
                    }

                    for(i = 0; i < currentuser.getLibrary().getMovieList().size(); i++)
                    {
                        if(currentuser.getLibrary().getMovieList().get(i).getStudio().contentEquals(movie.getStudio())
                                && currentuser.getLibrary().getMovieList().get(i).getTitle().contentEquals(movie.getTitle()))
                        {
                            exist = true;
                            System.out.println("Movie exists in your library!");
                        }

                    }
                    if(!exist)
                    {
                        System.out.println("Adding Movie : " + movie.getTitle() + " by " + movie.getStudio());
                        currentuser.getLibrary().addMovie(new Movies(builder[0], builder[1], builder[2]));
                     }
                    exist = false;
                }
                break;
            case 3:
                System.out.println("[View Stats]");
                break;
            case 4:
                System.out.println("[Rate Completed Entry]");
                break;
            case 5:
                System.out.println("Logging out...");
                loggedin = false;
                break;
            default:
                break;
        }


    }
    while (loggedin);
    sc.close();

}

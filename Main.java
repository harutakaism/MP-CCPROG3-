import java.util.ArrayList;
import java.util.Scanner;

    public static void main (String[] args)
    {
        int numchoice, numchoice2 ,builds, i;
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
        boolean exists = false;
        int[] maka = new int[100];


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
                for(i = 0; i < a.size(); i++)
                {
                    if(a.get(i).getUsername().contentEquals(tempo1))
                    {
                        exists = true;
                    }
                }
                if(exists)
                {
                    System.out.println("Username already exists!");
                }
                else
                {
                    a.add(new User(tempo1, tempo2));
                }

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
            System.out.print("[4] Rate Completed Entry | [5] Modify a Media | [6] Log Out");
            do
            {
                numchoice = sc.nextInt();
            }
            while (numchoice < 1 || numchoice > 6);
            switch (numchoice) {
                case 1:
                    do
                    {
                    System.out.println("[View Library]");
                    System.out.println("[1] View All | [2] View by Movies | [3] View by Anime | [4] View by Manga/Manhwa");
                    System.out.println("[5] View by Completion | [6] Back");
                    do {
                        numchoice = sc.nextInt();
                        if(numchoice < 1 || numchoice > 6)
                        {
                            System.out.println("Invalid Input: Choose a Number within 1-6!");
                        }
                    }
                    while (numchoice < 1 || numchoice > 6);
                        if (numchoice == 1) {
                            currentuser.getLibrary().displayAllEntries();
                        }
                        if (numchoice == 2) {
                            currentuser.getLibrary().displayMovies();
                        }
                        if (numchoice == 3) {
                            currentuser.getLibrary().displayAnime();
                        }
                        if (numchoice == 4) {
                            currentuser.getLibrary().displayManga();
                        }
                        if (numchoice == 5) {
                            System.out.println("[Select Status to Filter by]");
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
                            for (i = 0; i < currentuser.getLibrary().getMovieList().size(); i++) {
                                if (currentuser.getLibrary().getMovieList().get(i).getStatus().contentEquals(builder[2])) {
                                    currentuser.getLibrary().getMovieList().get(i).displayInfo();
                                }
                            }
                            for (i = 0; i < currentuser.getLibrary().getAnimeList().size(); i++) {
                                if (currentuser.getLibrary().getAnimeList().get(i).getStatus().contentEquals(builder[2])) {
                                    currentuser.getLibrary().getAnimeList().get(i).displayInfo();
                                }
                            }
                            for (i = 0; i < currentuser.getLibrary().getMangaList().size(); i++) {
                                if (currentuser.getLibrary().getMangaList().get(i).getStatus().contentEquals(builder[2])) {
                                    currentuser.getLibrary().getMangaList().get(i).displayInfo();
                                }
                            }
                            System.out.println();
                            System.out.println("(Anddd... that's pretty much it!)");
                        }
                    }
                    while (numchoice != 6);

                    break;
                case 2:
                    System.out.println("[Add to Library]");
                    System.out.println("[1] Movie | [2] Anime | [3] Manga");
                    System.out.println("Enter Type: ");
                    do {
                        numchoice = sc.nextInt();
                    }
                    while (numchoice < 1 || numchoice > 3);

                    if (numchoice == 1) {
                        System.out.println();
                        System.out.println("Enter Title: ");
                        builder[4] = sc.nextLine();
                        builder[0] = sc.nextLine();
                        System.out.println("Enter Studio: ");
                        builder[1] = sc.nextLine();
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

                        for (i = 0; i < currentuser.getLibrary().getMovieList().size(); i++) {
                            if (currentuser.getLibrary().getMovieList().get(i).getStudio().contentEquals(movie.getStudio())
                                    && currentuser.getLibrary().getMovieList().get(i).getTitle().contentEquals(movie.getTitle())) {
                                exist = true;
                                System.out.println("Movie exists in your library!");
                            }

                        }
                        if (!exist) {
                            System.out.println("Adding Movie : " + movie.getTitle() + " by " + movie.getStudio());
                            currentuser.getLibrary().addMovie(movie);
                        }
                        exist = false;
                        numchoice = 1;
                    }
                    if (numchoice == 2) {
                        System.out.println();
                        System.out.println("Enter Title: ");
                        builder[4] = sc.nextLine();
                        builder[0] = sc.nextLine();
                        System.out.println("Enter Studio: ");
                        builder[1] = sc.nextLine();
                        System.out.println("Status on the Anime?");
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
                        System.out.println("Do you know the number of Seasons/Episodes?");
                        System.out.println("[1] Yes | [2] No");
                        do {
                            numchoice = sc.nextInt();
                            if (numchoice != 1 && numchoice != 2) {
                                System.out.println("Error: Invalid Input!");
                            }
                        }
                        while (numchoice != 1 && numchoice != 2);
                        if (numchoice == 1) {
                            System.out.println("Enter number of Seasons: ");
                            do {
                                builds = sc.nextInt();
                                if (builds <= 0) {
                                    System.out.println("Invalid Input: Number can't be 0 and below");
                                }
                            }
                            while (builds < 0);

                            for (i = 0; i < builds; i++) {
                                System.out.println("Enter Number of Episodes in Season " + (i + 1) + ": ");
                                maka[i] = sc.nextInt();
                            }

                            anime = new Anime(builder[0], builder[1], maka, builds, builder[2]);
                        } else {
                            anime = new Anime(builder[0], builder[1], builder[2]);
                        }
                        for (i = 0; i < currentuser.getLibrary().getAnimeList().size(); i++) {
                            if (currentuser.getLibrary().getAnimeList().get(i).getStudio().contentEquals(anime.getStudio())
                                    && currentuser.getLibrary().getAnimeList().get(i).getTitle().contentEquals(anime.getTitle())) {
                                exist = true;
                                System.out.println("Anime exists in your library!");
                            }

                        }
                        if (!exist) {
                            System.out.println("Adding Anime : " + anime.getTitle() + " by " + anime.getStudio());
                            currentuser.getLibrary().addAnime(anime);
                        }
                        exist = false;
                        numchoice = 2;
                    }
                    if (numchoice == 3) {
                        System.out.println();
                        System.out.println("Enter Title: ");
                        builder[4] = sc.nextLine();
                        builder[0] = sc.nextLine();
                        System.out.println("Enter Studio: ");
                        builder[1] = sc.nextLine();
                        System.out.println("Status on the Manga/Manhwa?");
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
                        System.out.println("Do you know the number of Volumes/Chapters?");
                        System.out.println("[1] Yes | [2] No");
                        do {
                            numchoice = sc.nextInt();
                            if (numchoice != 1 && numchoice != 2) {
                                System.out.println("Error: Invalid Input!");
                            }
                        }
                        while (numchoice != 1 && numchoice != 2);
                        if (numchoice == 1) {
                            System.out.println("Enter number of Volume: ");
                            do {
                                builds = sc.nextInt();
                                if (builds <= 0) {
                                    System.out.println("Invalid Input: Number can't be 0 and below");
                                }
                            }
                            while (builds <= 0);

                            for (i = 0; i < builds; i++) {
                                System.out.println("Enter Number of Chapters in Volume " + (i + 1) + ": ");
                                maka[i] = sc.nextInt();
                            }

                            manga = new ManhwaToMangaDesu(builder[0], builder[1], builds, builder[2], maka);
                        } else {
                            manga = new ManhwaToMangaDesu(builder[0], builder[1], builder[2]);
                        }
                        for (i = 0; i < currentuser.getLibrary().getMangaList().size(); i++) {
                            if (currentuser.getLibrary().getMangaList().get(i).getStudio().contentEquals(manga.getStudio())
                                    && currentuser.getLibrary().getMangaList().get(i).getTitle().contentEquals(manga.getTitle())) {
                                exist = true;
                                System.out.println("Manga/Manhwa exists in your library!");
                            }

                        }
                        if (!exist) {
                            System.out.println("Adding Manga/Manhwa : " + manga.getTitle() + " by " + manga.getStudio());
                            currentuser.getLibrary().addManga(manga);
                        }
                        exist = false;
                        numchoice = 3;
                    }

                    break;
                case 3:
                    System.out.println("[View Stats]");
                    currentuser.getLibrary().displaySummary();
                    break;
                case 4:
                    System.out.println("[Rate Completed Entry]");
                    System.out.println("[1] Movie | [2] Anime | [3] Manga/Manhwa");
                    System.out.println("Enter Type: ");

                    do
                    {
                        numchoice = sc.nextInt();
                    }
                    while(numchoice < 1 || numchoice > 3);

                    System.out.println("Enter ID of entry to rate: ");
                    int searchID = sc.nextInt();

                    System.out.println("Enter rating from 1-10: ");
                    int userRating = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter review: ");
                    String userReview = sc.nextLine();

                    if(numchoice == 1)
                    {
                        Movies selectedMovie = currentuser.getLibrary().findMovieByID(searchID);

                        if(selectedMovie == null)
                        {
                            System.out.println("Movie not found.");
                        }
                        else
                        {
                            selectedMovie.rateMedia(userRating);
                            selectedMovie.addReview(userReview);
                        }
                    }
                    else if(numchoice == 2)
                    {
                        Anime selectedAnime = currentuser.getLibrary().findAnimeByID(searchID);

                        if(selectedAnime == null)
                        {
                            System.out.println("Anime not found.");
                        }
                        else
                        {
                            selectedAnime.rateMedia(userRating);
                            selectedAnime.addReview(userReview);
                        }
                    }
                    else if(numchoice == 3)
                    {
                        ManhwaToMangaDesu selectedManga = currentuser.getLibrary().findMangaByID(searchID);

                        if(selectedManga == null)
                        {
                            System.out.println("Manhwa/Manga/Webtoon not found.");
                        }
                        else
                        {
                            selectedManga.rateMedia(userRating);
                            selectedManga.addReview(userReview);
                        }
                    }
                    break;
                case 5:
                    System.out.println("[1] Remove Media | [2] Change Status");
                    numchoice = sc.nextInt();
                    if (numchoice == 1) {
                        System.out.println("[1] Remove a Movie | [2] Remove an Anime | [3] Remove a Manga/Manhwa");
                        numchoice = sc.nextInt();
                        if (numchoice == 1) {
                            if (currentuser.getLibrary().getMovieList().isEmpty()) {
                                System.out.println("Nothing to remove...");
                            } else {
                                for (i = 0; i < currentuser.getLibrary().getMovieList().size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " +
                                            currentuser.getLibrary().getMovieList().get(i).getTitle() + " - " +
                                            currentuser.getLibrary().getMovieList().get(i).getStudio());

                                }
                                System.out.println("Enter number of Movie to Delete: ");
                                do {
                                    {
                                        numchoice = sc.nextInt();
                                        if (numchoice < 1 || numchoice > currentuser.getLibrary().getMovieList().size()) {
                                            System.out.println("Error: Input out of bounds");
                                        }
                                    }
                                }
                                while (numchoice < 1 || numchoice > currentuser.getLibrary().getMovieList().size());
                                System.out.println("You will be deleting: " +
                                        currentuser.getLibrary().getMovieList().get(numchoice - 1).getTitle() + " - " +
                                        currentuser.getLibrary().getMovieList().get(numchoice - 1).getStudio() + ", Continue?");
                                System.out.println("[1] Yes | [2] No");
                                do {
                                    numchoice2 = sc.nextInt();
                                    if (numchoice2 != 1 && numchoice2 != 2) {
                                        System.out.println("Error: Invalid Input!");
                                    }
                                }
                                while (numchoice2 != 1 && numchoice2 != 2);
                                currentuser.getLibrary().getMovieList().remove(numchoice - 1);
                                System.out.println("Successfully Deleted.");
                                numchoice = 1;
                            }

                        }
                        if (numchoice == 2) {
                            if (currentuser.getLibrary().getAnimeList().isEmpty()) {
                                System.out.println("Nothing to remove...");
                            } else {
                                for (i = 0; i < currentuser.getLibrary().getAnimeList().size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " +
                                            currentuser.getLibrary().getAnimeList().get(i).getTitle() + " - " +
                                            currentuser.getLibrary().getAnimeList().get(i).getStudio());

                                }
                                System.out.println("Enter number of Anime to Delete: ");
                                do {
                                    {
                                        numchoice = sc.nextInt();
                                        if (numchoice < 1 || numchoice > currentuser.getLibrary().getAnimeList().size()) {
                                            System.out.println("Error: Input out of bounds");
                                        }
                                    }
                                }
                                while (numchoice < 1 || numchoice > currentuser.getLibrary().getAnimeList().size());
                                System.out.println("You will be deleting: " +
                                        currentuser.getLibrary().getAnimeList().get(numchoice - 1).getTitle() + " - " +
                                        currentuser.getLibrary().getAnimeList().get(numchoice - 1).getStudio() + ", Continue?");
                                System.out.println("[1] Yes | [2] No");
                                do {
                                    numchoice2 = sc.nextInt();
                                    if (numchoice2 != 1 && numchoice2 != 2) {
                                        System.out.println("Error: Invalid Input!");
                                    }
                                }
                                while (numchoice2 != 1 && numchoice2 != 2);
                                currentuser.getLibrary().getAnimeList().remove(numchoice - 1);
                                System.out.println("Successfully Deleted.");
                                numchoice = 1;
                            }


                        }
                        if (numchoice == 3) {
                            if (currentuser.getLibrary().getMangaList().isEmpty()) {
                                System.out.println("Nothing to remove...");
                            } else {
                                for (i = 0; i < currentuser.getLibrary().getMangaList().size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " +
                                            currentuser.getLibrary().getMangaList().get(i).getTitle() + " - " +
                                            currentuser.getLibrary().getMangaList().get(i).getStudio());

                                }
                                System.out.println("Enter number of Anime to Delete: ");
                                do {
                                    numchoice = sc.nextInt();
                                    if (numchoice < 1 || numchoice > currentuser.getLibrary().getMangaList().size()) {
                                        System.out.println("Error: Input out of bounds");
                                    }
                                }
                                while (numchoice < 1 || numchoice > currentuser.getLibrary().getMangaList().size());
                                System.out.println("You will be deleting: " +
                                        currentuser.getLibrary().getMangaList().get(numchoice - 1).getTitle() + " - " +
                                        currentuser.getLibrary().getMangaList().get(numchoice - 1).getStudio() + ", Continue?");
                                System.out.println("[1] Yes | [2] No");
                                do {
                                    numchoice2 = sc.nextInt();
                                    if (numchoice2 != 1 && numchoice2 != 2) {
                                        System.out.println("Error: Invalid Input!");
                                    }
                                }
                                while (numchoice2 != 1 && numchoice2 != 2);

                                currentuser.getLibrary().getMangaList().remove(numchoice - 1);
                                System.out.println("Successfully Deleted.");
                                numchoice = 3;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("What is the media type of the one you will update?");
                        System.out.println("[1] Movie | [2] Anime | [3] Manga/Manhwa");
                        do {
                            numchoice = sc.nextInt();
                            if (numchoice < 1 || numchoice > 3) {
                                System.out.println("Please Choose a number from 1-3!");
                            }
                        }
                        while (numchoice < 1 || numchoice > 3);
                        if(numchoice == 1)
                        {
                            for(i = 0; i < currentuser.getLibrary().getMovieList().size(); i++)
                            {
                                System.out.println( "["+ (i+1) +"] "+ currentuser.getLibrary().getMovieList().get(i).getTitle() + " - " +
                                        currentuser.getLibrary().getMovieList().get(i).getStudio());
                            }
                            System.out.println("Enter number of Movie to Update");
                            do {
                                numchoice = sc.nextInt();
                                if (numchoice < 1 || numchoice > currentuser.getLibrary().getMovieList().size()) {
                                    System.out.println("Error: Input out of bounds");
                                }
                            }
                            while (numchoice < 1 || numchoice > currentuser.getLibrary().getMovieList().size());
                            System.out.println("You will be updating: " +
                                    currentuser.getLibrary().getMovieList().get(numchoice - 1).getTitle() + " - " +
                                    currentuser.getLibrary().getMovieList().get(numchoice - 1).getStudio() + ", Continue?");
                            System.out.println("[1] Yes | [2] No");
                            do {
                                numchoice2 = sc.nextInt();
                                if (numchoice2 != 1 && numchoice2 != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (numchoice2 != 1 && numchoice2 != 2);
                            System.out.println("What to Update?");
                            System.out.println("[1] Status | [2] Description");
                            do {
                                numchoice2 = sc.nextInt();
                                if (numchoice2 != 1 && numchoice2 != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (numchoice2 != 1 && numchoice2 != 2);
                            if(numchoice2 == 1)
                            {
                                System.out.println("Enter Number Corresponding to the Status");
                                System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                                do {
                                    numchoice2 = sc.nextInt();
                                    if (numchoice2 < 1 || numchoice2 > 3) {
                                        System.out.println("Please Choose a number from 1-3!");
                                    }
                                }
                                while (numchoice2 < 1 || numchoice2 > 3);
                                if (numchoice2 == 1)
                                {
                                    builder[2] = "Planned";
                                } else if (numchoice2 == 2)
                                {
                                    builder[2] = "In Progress";
                                } else
                                {
                                    builder[2] = "Completed";
                                }
                                currentuser.getLibrary().getMovieList().get(numchoice-1).setStatus(builder[2]);
                            }
                            else
                            {
                                System.out.println("Enter New Description: ");
                                builder[2] = sc.nextLine();
                                builder[2] = sc.nextLine();
                                currentuser.getLibrary().getMovieList().get(numchoice-1).setDescription(builder[2]);
                                System.out.println("New Description: " +
                                        currentuser.getLibrary().getMovieList().get(numchoice-1).getDescription());
                            }


                        }
                        if(numchoice == 2) {
                            for (i = 0; i < currentuser.getLibrary().getAnimeList().size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + currentuser.getLibrary().getAnimeList().get(i).getTitle() + " - " +
                                        currentuser.getLibrary().getAnimeList().get(i).getStudio());
                            }
                            System.out.println("Enter number of Movie to Update");
                            do {
                                numchoice = sc.nextInt();
                                if (numchoice < 1 || numchoice > currentuser.getLibrary().getAnimeList().size()) {
                                    System.out.println("Error: Input out of bounds");
                                }
                            }
                            while (numchoice < 1 || numchoice > currentuser.getLibrary().getAnimeList().size());
                            System.out.println("You will be updating: " +
                                    currentuser.getLibrary().getAnimeList().get(numchoice - 1).getTitle() + " - " +
                                    currentuser.getLibrary().getAnimeList().get(numchoice - 1).getStudio() + ", Continue?");
                            System.out.println("[1] Yes | [2] No");
                            do {
                                numchoice2 = sc.nextInt();
                                if (numchoice2 != 1 && numchoice2 != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (numchoice2 != 1 && numchoice2 != 2);
                            System.out.println("What to Update?");
                            System.out.println("[1] Status | [2] Description");
                            do {
                                numchoice2 = sc.nextInt();
                                if (numchoice2 != 1 && numchoice2 != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (numchoice2 != 1 && numchoice2 != 2);
                            if (numchoice2 == 1) {
                                System.out.println("Enter Number Corresponding to the Status");
                                System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                                do {
                                    numchoice2 = sc.nextInt();
                                    if (numchoice2 < 1 || numchoice2 > 3) {
                                        System.out.println("Please Choose a number from 1-3!");
                                    }
                                }
                                while (numchoice2 < 1 || numchoice2 > 3);
                                if (numchoice2 == 1) {
                                    builder[2] = "Planned";
                                } else if (numchoice2 == 2) {
                                    builder[2] = "In Progress";
                                } else {
                                    builder[2] = "Completed";
                                }
                                currentuser.getLibrary().getAnimeList().get(numchoice - 1).setStatus(builder[2]);
                            } else {
                                System.out.println("Enter New Description: ");
                                builder[2] = sc.nextLine();
                                builder[2] = sc.nextLine();
                                currentuser.getLibrary().getAnimeList().get(numchoice - 1).setDescription(builder[2]);
                                System.out.println("New Description: " +
                                        currentuser.getLibrary().getAnimeList().get(numchoice - 1).getDescription());
                            }
                        }
                        if(numchoice == 3)
                        {
                            for(i = 0; i < currentuser.getLibrary().getMangaList().size(); i++)
                            {
                                System.out.println( "["+ (i+1) +"] "+ currentuser.getLibrary().getMangaList().get(i).getTitle() + " - " +
                                        currentuser.getLibrary().getMangaList().get(i).getStudio());
                            }
                            System.out.println("Enter number of Movie to Update");
                            do {
                                numchoice = sc.nextInt();
                                if (numchoice < 1 || numchoice > currentuser.getLibrary().getMangaList().size()) {
                                    System.out.println("Error: Input out of bounds");
                                }
                            }
                            while (numchoice < 1 || numchoice > currentuser.getLibrary().getMangaList().size());
                            System.out.println("You will be updating: " +
                                    currentuser.getLibrary().getMangaList().get(numchoice - 1).getTitle() + " - " +
                                    currentuser.getLibrary().getMangaList().get(numchoice - 1).getStudio() + ", Continue?");
                            System.out.println("[1] Yes | [2] No");
                            do {
                                numchoice2 = sc.nextInt();
                                if (numchoice2 != 1 && numchoice2 != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (numchoice2 != 1 && numchoice2 != 2);
                            System.out.println("What to Update?");
                            System.out.println("[1] Status | [2] Description");
                            do {
                                numchoice2 = sc.nextInt();
                                if (numchoice2 != 1 && numchoice2 != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (numchoice2 != 1 && numchoice2 != 2);
                            if(numchoice2 == 1)
                            {
                                System.out.println("Enter Number Corresponding to the Status");
                                System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                                do {
                                    numchoice2 = sc.nextInt();
                                    if (numchoice2 < 1 || numchoice2 > 3) {
                                        System.out.println("Please Choose a number from 1-3!");
                                    }
                                }
                                while (numchoice2 < 1 || numchoice2 > 3);
                                if (numchoice2 == 1)
                                {
                                    builder[2] = "Planned";
                                } else if (numchoice2 == 2)
                                {
                                    builder[2] = "In Progress";
                                } else
                                {
                                    builder[2] = "Completed";
                                }
                                currentuser.getLibrary().getMangaList().get(numchoice-1).setStatus(builder[2]);
                            }
                            else
                            {
                                System.out.println("Enter New Description: ");
                                builder[2] = sc.nextLine();
                                builder[2] = sc.nextLine();
                                currentuser.getLibrary().getMangaList().get(numchoice-1).setDescription(builder[2]);
                                System.out.println("New Description: " +
                                        currentuser.getLibrary().getMangaList().get(numchoice-1).getDescription());
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Logging out...");
                    loggedin = false;
                default:
                    break;
            }


        }
        while (loggedin);
        sc.close();
    }


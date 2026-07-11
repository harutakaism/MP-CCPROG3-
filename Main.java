import java.util.ArrayList;
import java.util.Scanner;

    public static void main (String[] args)
    {
        //Objects
        Anime anime;
        Movies movie;
        ManhwaToMangaDesu manga;

        //Created Variables (Primitive)
        int nScanNumberChoice, nScanNumberChoice2nd ,nCapacitor, nIteration;
        boolean isLoggedin = false;
        boolean isExistv1 = false;
        boolean isExistv2 = false;

        //Created Variables (Reference)
        String strTemp, strTemp2;
        String[] strConstructBuilder = new String[5];
        Scanner sc = new Scanner(System.in);
        ArrayList<User> arrUserRegistered = new ArrayList<>();
        User currentuser = null;
        int[] arrInts = new int[100];


        System.out.println("Welcome to OtakuVault!");
        while (!isLoggedin)
        {
            System.out.println("[1] Log In | [2] Create Account");
            do
            {
                nScanNumberChoice = sc.nextInt();
            }
            while (nScanNumberChoice != 1 && nScanNumberChoice != 2);

            if (nScanNumberChoice == 2)
            {
                System.out.println("[New Account] Enter Username: ");
                strTemp = sc.next();
                System.out.println("[New Account] Enter Password: ");
                strTemp2 = sc.next();
                for(nIteration = 0; nIteration < arrUserRegistered.size(); nIteration++)
                {
                    if(arrUserRegistered.get(nIteration).getUsername().contentEquals(strTemp))
                    {
                        isExistv2 = true;
                    }
                }
                if(isExistv2)
                {
                    System.out.println("Username already exists!");
                }
                else
                {
                    arrUserRegistered.add(new User(strTemp, strTemp2));
                }

            }
            else
            {
                System.out.println("[Log In] Enter Username: ");
                strTemp = sc.next();
                System.out.println("[Log In] Enter Password: ");
                strTemp2 = sc.next();
                for (User user : arrUserRegistered)
                {
                    if (user.getUsername().contentEquals(strTemp) && user.getPassword().contentEquals(strTemp2))
                    {
                        currentuser = user;
                        isLoggedin = true;
                        System.out.println("Successful login, welcome " + currentuser.getUsername() + "!");
                    }
                }
                if(!isLoggedin)
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
                nScanNumberChoice = sc.nextInt();
            }
            while (nScanNumberChoice < 1 || nScanNumberChoice > 6);
            switch (nScanNumberChoice) {
                case 1:
                    do
                    {
                    System.out.println("[View Library]");
                    System.out.println("[1] View All | [2] View by Movies | [3] View by Anime | [4] View by Manga/Manhwa");
                    System.out.println("[5] View by Completion | [6] Back");
                    do {
                        nScanNumberChoice = sc.nextInt();
                        if(nScanNumberChoice < 1 || nScanNumberChoice > 6)
                        {
                            System.out.println("Invalid Input: Choose a Number within 1-6!");
                        }
                    }
                    while (nScanNumberChoice < 1 || nScanNumberChoice > 6);
                        if (nScanNumberChoice == 1) {
                            currentuser.getLibrary().displayAllEntries();
                        }
                        if (nScanNumberChoice == 2) {
                            currentuser.getLibrary().displayMovies();
                        }
                        if (nScanNumberChoice == 3) {
                            currentuser.getLibrary().displayAnime();
                        }
                        if (nScanNumberChoice == 4) {
                            currentuser.getLibrary().displayManga();
                        }
                        if (nScanNumberChoice == 5) {
                            System.out.println("[Select Status to Filter by]");
                            System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                            do {
                                nScanNumberChoice = sc.nextInt();
                                if (nScanNumberChoice < 1 || nScanNumberChoice > 3) {
                                    System.out.println("Please Choose a number from 1-3!");
                                }
                            }
                            while (nScanNumberChoice < 1 || nScanNumberChoice > 3);
                            if (nScanNumberChoice == 1) {
                                strConstructBuilder[2] = "Planned";
                            } else if (nScanNumberChoice == 2) {
                                strConstructBuilder[2] = "In Progress";
                            } else {
                                strConstructBuilder[2] = "Completed";
                            }
                            for (nIteration = 0; nIteration < currentuser.getLibrary().getMovieList().size(); nIteration++) {
                                if (currentuser.getLibrary().getMovieList().get(nIteration).getStatus().contentEquals(strConstructBuilder[2])) {
                                    currentuser.getLibrary().getMovieList().get(nIteration).displayInfo();
                                }
                            }
                            for (nIteration = 0; nIteration < currentuser.getLibrary().getAnimeList().size(); nIteration++) {
                                if (currentuser.getLibrary().getAnimeList().get(nIteration).getStatus().contentEquals(strConstructBuilder[2])) {
                                    currentuser.getLibrary().getAnimeList().get(nIteration).displayInfo();
                                }
                            }
                            for (nIteration = 0; nIteration < currentuser.getLibrary().getMangaList().size(); nIteration++) {
                                if (currentuser.getLibrary().getMangaList().get(nIteration).getStatus().contentEquals(strConstructBuilder[2])) {
                                    currentuser.getLibrary().getMangaList().get(nIteration).displayInfo();
                                }
                            }
                            System.out.println();
                            System.out.println("(Anddd... that's pretty much it!)");
                        }
                    }
                    while (nScanNumberChoice != 6);

                    break;
                case 2:
                    System.out.println("[Add to Library]");
                    System.out.println("[1] Movie | [2] Anime | [3] Manga");
                    System.out.println("Enter Type: ");
                    do {
                        nScanNumberChoice = sc.nextInt();
                    }
                    while (nScanNumberChoice < 1 || nScanNumberChoice > 3);

                    if (nScanNumberChoice == 1) {
                        System.out.println();
                        System.out.println("Enter Title: ");
                        strConstructBuilder[4] = sc.nextLine();
                        strConstructBuilder[0] = sc.nextLine();
                        System.out.println("Enter Studio: ");
                        strConstructBuilder[1] = sc.nextLine();
                        System.out.println("Status on the Movie?");
                        System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice < 1 || nScanNumberChoice > 3) {
                                System.out.println("Please Choose a number from 1-3!");
                            }
                        }
                        while (nScanNumberChoice < 1 || nScanNumberChoice > 3);
                        if (nScanNumberChoice == 1) {
                            strConstructBuilder[2] = "Planned";
                        } else if (nScanNumberChoice == 2) {
                            strConstructBuilder[2] = "In Progress";
                        } else {
                            strConstructBuilder[2] = "Completed";
                        }
                        System.out.println("Do you know the Duration of the Movie?");
                        System.out.println("[1] Yes | [2] No");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice != 1 && nScanNumberChoice != 2) {
                                System.out.println("Error: Invalid Input!");
                            }
                        }
                        while (nScanNumberChoice != 1 && nScanNumberChoice != 2);
                        if (nScanNumberChoice == 1) {
                            System.out.println("Enter the Duration of the Movie (in Minutes Form)");
                            nCapacitor = sc.nextInt();
                            movie = new Movies(strConstructBuilder[0], strConstructBuilder[1], nCapacitor, strConstructBuilder[2]);
                        } else {
                            movie = new Movies(strConstructBuilder[0], strConstructBuilder[1], strConstructBuilder[2]);
                        }

                        for (nIteration = 0; nIteration < currentuser.getLibrary().getMovieList().size(); nIteration++) {
                            if (currentuser.getLibrary().getMovieList().get(nIteration).getStudio().contentEquals(movie.getStudio())
                                    && currentuser.getLibrary().getMovieList().get(nIteration).getTitle().contentEquals(movie.getTitle())) {
                                isExistv1 = true;
                                System.out.println("Movie exists in your library!");
                            }

                        }
                        if (!isExistv1) {
                            System.out.println("Adding Movie : " + movie.getTitle() + " by " + movie.getStudio());
                            currentuser.getLibrary().addMovie(movie);
                        }
                        isExistv1 = false;
                        nScanNumberChoice = 1;
                    }
                    if (nScanNumberChoice == 2) {
                        System.out.println();
                        System.out.println("Enter Title: ");
                        strConstructBuilder[4] = sc.nextLine();
                        strConstructBuilder[0] = sc.nextLine();
                        System.out.println("Enter Studio: ");
                        strConstructBuilder[1] = sc.nextLine();
                        System.out.println("Status on the Anime?");
                        System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice < 1 || nScanNumberChoice > 3) {
                                System.out.println("Please Choose a number from 1-3!");
                            }
                        }
                        while (nScanNumberChoice < 1 || nScanNumberChoice > 3);
                        if (nScanNumberChoice == 1) {
                            strConstructBuilder[2] = "Planned";
                        } else if (nScanNumberChoice == 2) {
                            strConstructBuilder[2] = "In Progress";
                        } else {
                            strConstructBuilder[2] = "Completed";
                        }
                        System.out.println("Do you know the number of Seasons/Episodes?");
                        System.out.println("[1] Yes | [2] No");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice != 1 && nScanNumberChoice != 2) {
                                System.out.println("Error: Invalid Input!");
                            }
                        }
                        while (nScanNumberChoice != 1 && nScanNumberChoice != 2);
                        if (nScanNumberChoice == 1) {
                            System.out.println("Enter number of Seasons: ");
                            do {
                                nCapacitor = sc.nextInt();
                                if (nCapacitor <= 0) {
                                    System.out.println("Invalid Input: Number can't be 0 and below");
                                }
                            }
                            while (nCapacitor < 0);

                            for (nIteration = 0; nIteration < nCapacitor; nIteration++) {
                                System.out.println("Enter Number of Episodes in Season " + (nIteration + 1) + ": ");
                                arrInts[nIteration] = sc.nextInt();
                            }

                            anime = new Anime(strConstructBuilder[0], strConstructBuilder[1], arrInts, nCapacitor, strConstructBuilder[2]);
                        } else {
                            anime = new Anime(strConstructBuilder[0], strConstructBuilder[1], strConstructBuilder[2]);
                        }
                        for (nIteration = 0; nIteration < currentuser.getLibrary().getAnimeList().size(); nIteration++) {
                            if (currentuser.getLibrary().getAnimeList().get(nIteration).getStudio().contentEquals(anime.getStudio())
                                    && currentuser.getLibrary().getAnimeList().get(nIteration).getTitle().contentEquals(anime.getTitle())) {
                                isExistv1 = true;
                                System.out.println("Anime exists in your library!");
                            }

                        }
                        if (!isExistv1) {
                            System.out.println("Adding Anime : " + anime.getTitle() + " by " + anime.getStudio());
                            currentuser.getLibrary().addAnime(anime);
                        }
                        isExistv1 = false;
                        nScanNumberChoice = 2;
                    }
                    if (nScanNumberChoice == 3) {
                        System.out.println();
                        System.out.println("Enter Title: ");
                        strConstructBuilder[4] = sc.nextLine();
                        strConstructBuilder[0] = sc.nextLine();
                        System.out.println("Enter Studio: ");
                        strConstructBuilder[1] = sc.nextLine();
                        System.out.println("Status on the Manga/Manhwa?");
                        System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice < 1 || nScanNumberChoice > 3) {
                                System.out.println("Please Choose a number from 1-3!");
                            }
                        }
                        while (nScanNumberChoice < 1 || nScanNumberChoice > 3);
                        if (nScanNumberChoice == 1) {
                            strConstructBuilder[2] = "Planned";
                        } else if (nScanNumberChoice == 2) {
                            strConstructBuilder[2] = "In Progress";
                        } else {
                            strConstructBuilder[2] = "Completed";
                        }
                        System.out.println("Do you know the number of Volumes/Chapters?");
                        System.out.println("[1] Yes | [2] No");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice != 1 && nScanNumberChoice != 2) {
                                System.out.println("Error: Invalid Input!");
                            }
                        }
                        while (nScanNumberChoice != 1 && nScanNumberChoice != 2);
                        if (nScanNumberChoice == 1) {
                            System.out.println("Enter number of Volume: ");
                            do {
                                nCapacitor = sc.nextInt();
                                if (nCapacitor <= 0) {
                                    System.out.println("Invalid Input: Number can't be 0 and below");
                                }
                            }
                            while (nCapacitor <= 0);

                            for (nIteration = 0; nIteration < nCapacitor; nIteration++) {
                                System.out.println("Enter Number of Chapters in Volume " + (nIteration + 1) + ": ");
                                arrInts[nIteration] = sc.nextInt();
                            }

                            manga = new ManhwaToMangaDesu(strConstructBuilder[0], strConstructBuilder[1], nCapacitor, strConstructBuilder[2], arrInts);
                        } else {
                            manga = new ManhwaToMangaDesu(strConstructBuilder[0], strConstructBuilder[1], strConstructBuilder[2]);
                        }
                        for (nIteration = 0; nIteration < currentuser.getLibrary().getMangaList().size(); nIteration++) {
                            if (currentuser.getLibrary().getMangaList().get(nIteration).getStudio().contentEquals(manga.getStudio())
                                    && currentuser.getLibrary().getMangaList().get(nIteration).getTitle().contentEquals(manga.getTitle())) {
                                isExistv1 = true;
                                System.out.println("Manga/Manhwa exists in your library!");
                            }

                        }
                        if (!isExistv1) {
                            System.out.println("Adding Manga/Manhwa : " + manga.getTitle() + " by " + manga.getStudio());
                            currentuser.getLibrary().addManga(manga);
                        }
                        isExistv1 = false;
                        nScanNumberChoice = 3;
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
                        nScanNumberChoice = sc.nextInt();
                    }
                    while(nScanNumberChoice < 1 || nScanNumberChoice > 3);

                    System.out.println("Enter ID of entry to rate: ");
                    int searchID = sc.nextInt();

                    System.out.println("Enter rating from 1-10: ");
                    int userRating = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter review: ");
                    String userReview = sc.nextLine();

                    if(nScanNumberChoice == 1)
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
                    else if(nScanNumberChoice == 2)
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
                    else if(nScanNumberChoice == 3)
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
                    nScanNumberChoice = sc.nextInt();
                    if (nScanNumberChoice == 1) {
                        System.out.println("[1] Remove a Movie | [2] Remove an Anime | [3] Remove a Manga/Manhwa");
                        nScanNumberChoice = sc.nextInt();
                        if (nScanNumberChoice == 1) {
                            if (currentuser.getLibrary().getMovieList().isEmpty()) {
                                System.out.println("Nothing to remove...");
                            } else {
                                for (nIteration = 0; nIteration < currentuser.getLibrary().getMovieList().size(); nIteration++) {
                                    System.out.println("[" + (nIteration + 1) + "] " +
                                            currentuser.getLibrary().getMovieList().get(nIteration).getTitle() + " - " +
                                            currentuser.getLibrary().getMovieList().get(nIteration).getStudio());

                                }
                                System.out.println("Enter number of Movie to Delete: ");
                                do {
                                    {
                                        nScanNumberChoice = sc.nextInt();
                                        if (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMovieList().size()) {
                                            System.out.println("Error: Input out of bounds");
                                        }
                                    }
                                }
                                while (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMovieList().size());
                                System.out.println("You will be deleting: " +
                                        currentuser.getLibrary().getMovieList().get(nScanNumberChoice - 1).getTitle() + " - " +
                                        currentuser.getLibrary().getMovieList().get(nScanNumberChoice - 1).getStudio() + ", Continue?");
                                System.out.println("[1] Yes | [2] No");
                                do {
                                    nScanNumberChoice2nd = sc.nextInt();
                                    if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                        System.out.println("Error: Invalid Input!");
                                    }
                                }
                                while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                                currentuser.getLibrary().getMovieList().remove(nScanNumberChoice - 1);
                                System.out.println("Successfully Deleted.");
                                nScanNumberChoice = 1;
                            }

                        }
                        if (nScanNumberChoice == 2) {
                            if (currentuser.getLibrary().getAnimeList().isEmpty()) {
                                System.out.println("Nothing to remove...");
                            } else {
                                for (nIteration = 0; nIteration < currentuser.getLibrary().getAnimeList().size(); nIteration++) {
                                    System.out.println("[" + (nIteration + 1) + "] " +
                                            currentuser.getLibrary().getAnimeList().get(nIteration).getTitle() + " - " +
                                            currentuser.getLibrary().getAnimeList().get(nIteration).getStudio());

                                }
                                System.out.println("Enter number of Anime to Delete: ");
                                do {
                                    {
                                        nScanNumberChoice = sc.nextInt();
                                        if (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getAnimeList().size()) {
                                            System.out.println("Error: Input out of bounds");
                                        }
                                    }
                                }
                                while (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getAnimeList().size());
                                System.out.println("You will be deleting: " +
                                        currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).getTitle() + " - " +
                                        currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).getStudio() + ", Continue?");
                                System.out.println("[1] Yes | [2] No");
                                do {
                                    nScanNumberChoice2nd = sc.nextInt();
                                    if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                        System.out.println("Error: Invalid Input!");
                                    }
                                }
                                while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                                currentuser.getLibrary().getAnimeList().remove(nScanNumberChoice - 1);
                                System.out.println("Successfully Deleted.");
                                nScanNumberChoice = 1;
                            }


                        }
                        if (nScanNumberChoice == 3) {
                            if (currentuser.getLibrary().getMangaList().isEmpty()) {
                                System.out.println("Nothing to remove...");
                            } else {
                                for (nIteration = 0; nIteration < currentuser.getLibrary().getMangaList().size(); nIteration++) {
                                    System.out.println("[" + (nIteration + 1) + "] " +
                                            currentuser.getLibrary().getMangaList().get(nIteration).getTitle() + " - " +
                                            currentuser.getLibrary().getMangaList().get(nIteration).getStudio());

                                }
                                System.out.println("Enter number of Anime to Delete: ");
                                do {
                                    nScanNumberChoice = sc.nextInt();
                                    if (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMangaList().size()) {
                                        System.out.println("Error: Input out of bounds");
                                    }
                                }
                                while (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMangaList().size());
                                System.out.println("You will be deleting: " +
                                        currentuser.getLibrary().getMangaList().get(nScanNumberChoice - 1).getTitle() + " - " +
                                        currentuser.getLibrary().getMangaList().get(nScanNumberChoice - 1).getStudio() + ", Continue?");
                                System.out.println("[1] Yes | [2] No");
                                do {
                                    nScanNumberChoice2nd = sc.nextInt();
                                    if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                        System.out.println("Error: Invalid Input!");
                                    }
                                }
                                while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);

                                currentuser.getLibrary().getMangaList().remove(nScanNumberChoice - 1);
                                System.out.println("Successfully Deleted.");
                                nScanNumberChoice = 3;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("What is the media type of the one you will update?");
                        System.out.println("[1] Movie | [2] Anime | [3] Manga/Manhwa");
                        do {
                            nScanNumberChoice = sc.nextInt();
                            if (nScanNumberChoice < 1 || nScanNumberChoice > 3) {
                                System.out.println("Please Choose a number from 1-3!");
                            }
                        }
                        while (nScanNumberChoice < 1 || nScanNumberChoice > 3);
                        if(nScanNumberChoice == 1)
                        {
                            for(nIteration = 0; nIteration < currentuser.getLibrary().getMovieList().size(); nIteration++)
                            {
                                System.out.println( "["+ (nIteration+1) +"] "+ currentuser.getLibrary().getMovieList().get(nIteration).getTitle() + " - " +
                                        currentuser.getLibrary().getMovieList().get(nIteration).getStudio());
                            }
                            System.out.println("Enter number of Movie to Update");
                            do {
                                nScanNumberChoice = sc.nextInt();
                                if (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMovieList().size()) {
                                    System.out.println("Error: Input out of bounds");
                                }
                            }
                            while (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMovieList().size());
                            System.out.println("You will be updating: " +
                                    currentuser.getLibrary().getMovieList().get(nScanNumberChoice - 1).getTitle() + " - " +
                                    currentuser.getLibrary().getMovieList().get(nScanNumberChoice - 1).getStudio() + ", Continue?");
                            System.out.println("[1] Yes | [2] No");
                            do {
                                nScanNumberChoice2nd = sc.nextInt();
                                if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                            System.out.println("What to Update?");
                            System.out.println("[1] Status | [2] Description");
                            do {
                                nScanNumberChoice2nd = sc.nextInt();
                                if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                            if(nScanNumberChoice2nd == 1)
                            {
                                System.out.println("Enter Number Corresponding to the Status");
                                System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                                do {
                                    nScanNumberChoice2nd = sc.nextInt();
                                    if (nScanNumberChoice2nd < 1 || nScanNumberChoice2nd > 3) {
                                        System.out.println("Please Choose a number from 1-3!");
                                    }
                                }
                                while (nScanNumberChoice2nd < 1 || nScanNumberChoice2nd > 3);
                                if (nScanNumberChoice2nd == 1)
                                {
                                    strConstructBuilder[2] = "Planned";
                                } else if (nScanNumberChoice2nd == 2)
                                {
                                    strConstructBuilder[2] = "In Progress";
                                } else
                                {
                                    strConstructBuilder[2] = "Completed";
                                }
                                currentuser.getLibrary().getMovieList().get(nScanNumberChoice-1).setStatus(strConstructBuilder[2]);
                            }
                            else
                            {
                                System.out.println("Enter New Description: ");
                                strConstructBuilder[2] = sc.nextLine();
                                strConstructBuilder[2] = sc.nextLine();
                                currentuser.getLibrary().getMovieList().get(nScanNumberChoice-1).setDescription(strConstructBuilder[2]);
                                System.out.println("New Description: " +
                                        currentuser.getLibrary().getMovieList().get(nScanNumberChoice-1).getDescription());
                            }


                        }
                        if(nScanNumberChoice == 2) {
                            for (nIteration = 0; nIteration < currentuser.getLibrary().getAnimeList().size(); nIteration++) {
                                System.out.println("[" + (nIteration + 1) + "] " + currentuser.getLibrary().getAnimeList().get(nIteration).getTitle() + " - " +
                                        currentuser.getLibrary().getAnimeList().get(nIteration).getStudio());
                            }
                            System.out.println("Enter number of Movie to Update");
                            do {
                                nScanNumberChoice = sc.nextInt();
                                if (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getAnimeList().size()) {
                                    System.out.println("Error: Input out of bounds");
                                }
                            }
                            while (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getAnimeList().size());
                            System.out.println("You will be updating: " +
                                    currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).getTitle() + " - " +
                                    currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).getStudio() + ", Continue?");
                            System.out.println("[1] Yes | [2] No");
                            do {
                                nScanNumberChoice2nd = sc.nextInt();
                                if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                            System.out.println("What to Update?");
                            System.out.println("[1] Status | [2] Description");
                            do {
                                nScanNumberChoice2nd = sc.nextInt();
                                if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                            if (nScanNumberChoice2nd == 1) {
                                System.out.println("Enter Number Corresponding to the Status");
                                System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                                do {
                                    nScanNumberChoice2nd = sc.nextInt();
                                    if (nScanNumberChoice2nd < 1 || nScanNumberChoice2nd > 3) {
                                        System.out.println("Please Choose a number from 1-3!");
                                    }
                                }
                                while (nScanNumberChoice2nd < 1 || nScanNumberChoice2nd > 3);
                                if (nScanNumberChoice2nd == 1) {
                                    strConstructBuilder[2] = "Planned";
                                } else if (nScanNumberChoice2nd == 2) {
                                    strConstructBuilder[2] = "In Progress";
                                } else {
                                    strConstructBuilder[2] = "Completed";
                                }
                                currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).setStatus(strConstructBuilder[2]);
                            } else {
                                System.out.println("Enter New Description: ");
                                strConstructBuilder[2] = sc.nextLine();
                                strConstructBuilder[2] = sc.nextLine();
                                currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).setDescription(strConstructBuilder[2]);
                                System.out.println("New Description: " +
                                        currentuser.getLibrary().getAnimeList().get(nScanNumberChoice - 1).getDescription());
                            }
                        }
                        if(nScanNumberChoice == 3)
                        {
                            for(nIteration = 0; nIteration < currentuser.getLibrary().getMangaList().size(); nIteration++)
                            {
                                System.out.println( "["+ (nIteration+1) +"] "+ currentuser.getLibrary().getMangaList().get(nIteration).getTitle() + " - " +
                                        currentuser.getLibrary().getMangaList().get(nIteration).getStudio());
                            }
                            System.out.println("Enter number of Movie to Update");
                            do {
                                nScanNumberChoice = sc.nextInt();
                                if (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMangaList().size()) {
                                    System.out.println("Error: Input out of bounds");
                                }
                            }
                            while (nScanNumberChoice < 1 || nScanNumberChoice > currentuser.getLibrary().getMangaList().size());
                            System.out.println("You will be updating: " +
                                    currentuser.getLibrary().getMangaList().get(nScanNumberChoice - 1).getTitle() + " - " +
                                    currentuser.getLibrary().getMangaList().get(nScanNumberChoice - 1).getStudio() + ", Continue?");
                            System.out.println("[1] Yes | [2] No");
                            do {
                                nScanNumberChoice2nd = sc.nextInt();
                                if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                            System.out.println("What to Update?");
                            System.out.println("[1] Status | [2] Description");
                            do {
                                nScanNumberChoice2nd = sc.nextInt();
                                if (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2) {
                                    System.out.println("Error: Invalid Input!");
                                }
                            }
                            while (nScanNumberChoice2nd != 1 && nScanNumberChoice2nd != 2);
                            if(nScanNumberChoice2nd == 1)
                            {
                                System.out.println("Enter Number Corresponding to the Status");
                                System.out.println("[1] Planned | [2] In Progress | [3] Completed");
                                do {
                                    nScanNumberChoice2nd = sc.nextInt();
                                    if (nScanNumberChoice2nd < 1 || nScanNumberChoice2nd > 3) {
                                        System.out.println("Please Choose a number from 1-3!");
                                    }
                                }
                                while (nScanNumberChoice2nd < 1 || nScanNumberChoice2nd > 3);
                                if (nScanNumberChoice2nd == 1)
                                {
                                    strConstructBuilder[2] = "Planned";
                                } else if (nScanNumberChoice2nd == 2)
                                {
                                    strConstructBuilder[2] = "In Progress";
                                } else
                                {
                                    strConstructBuilder[2] = "Completed";
                                }
                                currentuser.getLibrary().getMangaList().get(nScanNumberChoice-1).setStatus(strConstructBuilder[2]);
                            }
                            else
                            {
                                System.out.println("Enter New Description: ");
                                strConstructBuilder[2] = sc.nextLine();
                                strConstructBuilder[2] = sc.nextLine();
                                currentuser.getLibrary().getMangaList().get(nScanNumberChoice-1).setDescription(strConstructBuilder[2]);
                                System.out.println("New Description: " +
                                        currentuser.getLibrary().getMangaList().get(nScanNumberChoice-1).getDescription());
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Logging out...");
                    isLoggedin = false;
                default:
                    break;
            }


        }
        while (isLoggedin);
        sc.close();
    }



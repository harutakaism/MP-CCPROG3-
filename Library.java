import java.util.ArrayList;

public class Library
{
    private ArrayList<Anime> anime = new ArrayList<>();
    private ArrayList<ManhwaToMangaDesu> mangadesho = new ArrayList<>();
    private ArrayList<Movies> movies = new ArrayList<>();

    //Use default constructor for this

    //Methods(Adding)
    public void addAnime(Anime anime)
    {
        this.anime.add(anime);
    }
    public void addManga(ManhwaToMangaDesu manga)
    {
        this.mangadesho.add(manga);
    }
    public void addMovie(Movies movie)
    {
        this.movies.add(movie);
    }
    //Methods(Deleting)
    public void deleteAnime(Anime anime)
    {
        this.anime.remove(anime);
    }
    public void deleteManga(ManhwaToMangaDesu manga)
    {
        this.mangadesho.remove(manga);
    }
    public void deleteMovie(Movies movie)
    {
        this.movies.remove(movie);
    }
    public ArrayList<Anime> getAnimeList()
    {
        return anime;
    }
    public ArrayList<ManhwaToMangaDesu> getMangaList()
    {
        return mangadesho;
    }
    public ArrayList<Movies> getMovieList()
    {
        return movies;
    }
    public void displayAllEntries()
    {
        System.out.println("ALL LIBRARY ENTRIES");

        System.out.println();
        System.out.println("Anime");
        if (anime.isEmpty())
        {
            System.out.println("No anime entries.");
        } else {
            for (Anime animes : anime) {
                animes.displayInfo();
            }
        }


        System.out.println();
        System.out.println("Manga/Manhwa/Webtoon");
        if (mangadesho.isEmpty())
        {
            System.out.println("No manga/manhwa/webtoon entries.");
        } else {
            for (ManhwaToMangaDesu manga : mangadesho) {
                manga.displayInfo();
            }
            System.out.println("Total Entries: " + mangadesho.size());
        }

        System.out.println();
        System.out.println("Movies");
        if (movies.isEmpty())
        {
            System.out.println("No movie entries.");
        } else {
            for (Movies movie : movies) {
                movie.displayInfo();
            }
        }
    }
    public void displayAnime()
    {
        System.out.println("Anime");
        if (anime.isEmpty())
        {
            System.out.println("No anime entries.");
        }
        else
        {
            for (Anime animes : anime)
            {
                animes.displayInfo();
            }
        }
    }
    public void displayMovies()
    {
        System.out.println("Movies");
        if (movies.isEmpty())
        {
            System.out.println("No movie entries.");
        }
        else
        {
            for (Movies movie : movies) {
                movie.displayInfo();
            }
        }
    }
    public void displayManga()
    {
        System.out.println("Manga/Manhwa/Webtoon");
        if (mangadesho.isEmpty())
        {
            System.out.println("No manga/manhwa/webtoon entries.");
        }
        else
        {
            for (ManhwaToMangaDesu manga : mangadesho)
            {
                manga.displayInfo();
            }
            System.out.println("Total Entries: " + mangadesho.size());
        }
    }
    public void displaySummary()
    {
        int total = anime.size() + mangadesho.size() + movies.size();
        int planned = 0;
        int inProgress = 0;
        int completed = 0;
        float ratingSum = 0;
        int ratedCompleted = 0;

        for(Anime item : anime)
        {
            if(item.getStatus().equals("Planned"))
                planned++;
            else if(item.getStatus().equals("In Progress"))
                inProgress++;
            else if(item.getStatus().equals("Completed"))
            {
                completed++;
                if(item.getRating().hasRating())
                {
                    ratingSum += item.getRating().GetOverallrating();
                    ratedCompleted++;
                }
            }
        }

        for(ManhwaToMangaDesu item : mangadesho)
        {
            if(item.getStatus().equals("Planned"))
                planned++;
            else if(item.getStatus().equals("In Progress"))
                inProgress++;
            else if(item.getStatus().equals("Completed"))
            {
                completed++;
                if(item.getRating().hasRating())
                {
                    ratingSum += item.getRating().GetOverallrating();
                    ratedCompleted++;
                }
            }
        }

        for(Movies item : movies)
        {
            if(item.getStatus().equals("Planned"))
                planned++;
            else if(item.getStatus().equals("In Progress"))
                inProgress++;
            else if(item.getStatus().equals("Completed"))
            {
                completed++;
                if(item.getRating().hasRating())
                {
                    ratingSum += item.getRating().GetOverallrating();
                    ratedCompleted++;
                }
            }
        }

        System.out.println("LIBRARY SUMMARY");
        System.out.println("Total Entries: " + total);
        System.out.println("Anime Entries: " + anime.size());
        System.out.println("Manga/Manhwa/Webtoon Entries: " + mangadesho.size());
        System.out.println("Movie Entries: " + movies.size());
        System.out.println("Planned: " + planned);
        System.out.println("In Progress: " + inProgress);
        System.out.println("Completed: " + completed);

        if(ratedCompleted > 0)
        {
            System.out.println("Average Rating of Completed Entries: " + (ratingSum / ratedCompleted));
        }
        else
        {
            System.out.println("Average Rating of Completed Entries: No ratings yet.");
        }
    }
    public Anime findAnimeByID(int id)
    {
        for (Anime item : anime)
        {
            if (item.getID() == id)
            {
                return item;
            }
        }
        return null;
    }
    public ManhwaToMangaDesu findMangaByID(int id)
    {
        for (ManhwaToMangaDesu item : mangadesho)
        {
            if (item.getID() == id)
            {
                return item;
            }
        }
        return null;
    }
    public Movies findMovieByID(int id)
    {
        for (Movies item : movies)
        {
            if (item.getID() == id)
            {
                return item;
            }
        }
        return null;
    }
    public String getAllEntriesAsText()
    {
        String output = "ALL LIBRARY ENTRIES\n\n";

        output += getAnimeAsText() + "\n";
        output += getMangaAsText() + "\n";
        output += getMoviesAsText();

        return output;
    }

    public String getAnimeAsText()
    {
        String output = "ANIME\n\n";

        if(anime.isEmpty())
        {
            output += "No anime entries.\n";
        }
        else
        {
            for(Anime item : anime)
            {
                output += animeToText(item) + "\n";
            }
        }

        return output;
    }

    public String getMoviesAsText()
    {
        String output = "MOVIES\n\n";

        if(movies.isEmpty())
        {
            output += "No movie entries.\n";
        }
        else
        {
            for(Movies item : movies)
            {
                output += movieToText(item) + "\n";
            }
        }

        return output;
    }

    public String getMangaAsText()
    {
        String output = "MANGA / MANHWA / WEBTOON\n\n";

        if(mangadesho.isEmpty())
        {
            output += "No manga/manhwa/webtoon entries.\n";
        }
        else
        {
            for(ManhwaToMangaDesu item : mangadesho)
            {
                output += mangaToText(item) + "\n";
            }
        }

        return output;
    }

    public String getSummaryText()
    {
        int total = anime.size() + mangadesho.size() + movies.size();
        int planned = 0;
        int inProgress = 0;
        int completed = 0;
        float ratingSum = 0;
        int ratedCompleted = 0;

        for(Anime item : anime)
        {
            if(item.getStatus().equals("Planned"))
            {
                planned++;
            }
            else if(item.getStatus().equals("In Progress"))
            {
                inProgress++;
            }
            else if(item.getStatus().equals("Completed"))
            {
                completed++;

                if(item.getRating().hasRating())
                {
                    ratingSum += item.getRating().GetOverallrating();
                    ratedCompleted++;
                }
            }
        }

        for(ManhwaToMangaDesu item : mangadesho)
        {
            if(item.getStatus().equals("Planned"))
            {
                planned++;
            }
            else if(item.getStatus().equals("In Progress"))
            {
                inProgress++;
            }
            else if(item.getStatus().equals("Completed"))
            {
                completed++;

                if(item.getRating().hasRating())
                {
                    ratingSum += item.getRating().GetOverallrating();
                    ratedCompleted++;
                }
            }
        }

        for(Movies item : movies)
        {
            if(item.getStatus().equals("Planned"))
            {
                planned++;
            }
            else if(item.getStatus().equals("In Progress"))
            {
                inProgress++;
            }
            else if(item.getStatus().equals("Completed"))
            {
                completed++;

                if(item.getRating().hasRating())
                {
                    ratingSum += item.getRating().GetOverallrating();
                    ratedCompleted++;
                }
            }
        }

        String output = "LIBRARY SUMMARY\n\n";
        output += "Total Entries: " + total + "\n";
        output += "Anime Entries: " + anime.size() + "\n";
        output += "Manga/Manhwa/Webtoon Entries: " + mangadesho.size() + "\n";
        output += "Movie Entries: " + movies.size() + "\n";
        output += "Planned: " + planned + "\n";
        output += "In Progress: " + inProgress + "\n";
        output += "Completed: " + completed + "\n";

        if(ratedCompleted > 0)
        {
            output += "Average Rating of Completed Entries: " + (ratingSum / ratedCompleted) + "\n";
        }
        else
        {
            output += "Average Rating of Completed Entries: No ratings yet.\n";
        }

        return output;
    }

    private String movieToText(Movies movie)
    {
        String output = "";

        output += "Title: " + movie.getTitle() + "\n";
        output += "Studio: " + movie.getStudio() + "\n";
        output += "Status: " + movie.getStatus() + "\n";
        output += "Duration: " + movie.getDurationinmins() + " minutes\n";
        output += "Rating: " + movie.getRating().GetOverallrating() + "\n";
        output += "Description: " + movie.getDescription() + "\n";
        output += "ID: " + movie.getID() + "\n";

        return output;
    }

    private String animeToText(Anime animeEntry)
    {
        String output = "";

        output += "Title: " + animeEntry.getTitle() + "\n";
        output += "Studio: " + animeEntry.getStudio() + "\n";
        output += "Status: " + animeEntry.getStatus() + "\n";
        output += "Seasons: " + animeEntry.getSeason() + "\n";

        int[] episodes = animeEntry.getEpisodes();

        if(episodes != null)
        {
            for(int i = 0; i < animeEntry.getSeason(); i++)
            {
                output += "Season " + (i + 1) + ": " + episodes[i] + " episode/s\n";
            }
        }

        output += "Rating: " + animeEntry.getRating().GetOverallrating() + "\n";
        output += "Description: " + animeEntry.getDescription() + "\n";
        output += "ID: " + animeEntry.getID() + "\n";

        return output;
    }

    private String mangaToText(ManhwaToMangaDesu manga)
    {
        String output = "";

        output += "Title: " + manga.getTitle() + "\n";
        output += "Studio/Publisher: " + manga.getStudio() + "\n";
        output += "Status: " + manga.getStatus() + "\n";
        output += "Volumes: " + manga.getVolume() + "\n";

        int[] chapters = manga.getChapter();

        if(chapters != null)
        {
            for(int i = 0; i < manga.getVolume(); i++)
            {
                output += "Volume " + (i + 1) + ": " + chapters[i] + " chapter/s\n";
            }
        }

        output += "Rating: " + manga.getRating().GetOverallrating() + "\n";
        output += "Description: " + manga.getDescription() + "\n";
        output += "ID: " + manga.getID() + "\n";

        return output;
    }
}


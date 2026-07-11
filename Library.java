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
}


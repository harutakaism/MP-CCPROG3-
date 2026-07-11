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
}


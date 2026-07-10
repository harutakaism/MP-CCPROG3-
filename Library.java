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
        return animeList;
    }
    public ArrayList<ManhwaToMangaDesu> getMangaList()
    {
        return mangaList;
    }
    public ArrayList<Movies> getMovieList()
    {
        return movieList;
    }
    public void displayAllEntries()
    {
        System.out.println("ALL LIBRARY ENTRIES");

        System.out.println("Anime");
        if (animeList.isEmpty())
        {
            System.out.println("No anime entries.");
        } else {
            for (Anime anime : animeList) {
                anime.DisplayInfo();
            }
        }

        System.out.println("Manga/Manhwa/Webtoon");
        if (mangaList.isEmpty())
        {
            System.out.println("No manga/manhwa/webtoon entries.");
        } else {
            for (ManhwaToMangaDesu manga : mangaList) {
                manga.displayInfo();
            }
        }

        System.out.println("Movies");
        if (movieList.isEmpty())
        {
            System.out.println("No movie entries.");
        } else {
            for (Movies movie : movieList) {
                movie.displayInfo();
            }
        }
    }
}

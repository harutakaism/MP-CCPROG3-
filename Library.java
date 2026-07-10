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
}

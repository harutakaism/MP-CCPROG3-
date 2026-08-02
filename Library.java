import java.util.ArrayList;

public class Library
{
    private ArrayList<Anime> anime = new ArrayList<>();
    private ArrayList<ManhwaToMangaDesu> mangadesho = new ArrayList<>();
    private ArrayList<Movies> movies = new ArrayList<>();

    /**
     * addAnime is a method that adds an anime object
     * @param anime is the anime object type
     */
    public void addAnime(Anime anime)
    {
        this.anime.add(anime);
    }

    /**
     * addManga is a method that adds a manga object
     * @param manga is the manga object type
     */
    public void addManga(ManhwaToMangaDesu manga)
    {
        this.mangadesho.add(manga);
    }

    /**
     * addMovie is a method that adds a movie object
     * @param movie is the movie object type
     */
    public void addMovie(Movies movie)
    {
        this.movies.add(movie);
    }
    /**
     * getAllEntriesAsText is a getter method that returns a string with a format of viewing and the data of every
     * media type. It is the combination of the getAnimeAsText, getMoviesAsText, getMangaAsText
     * @return the String containing the format of the viewing and it's data
     */
    public String getAllEntriesAsText()
    {
        String output = "ALL LIBRARY ENTRIES\n\n";

        output += getAnimeAsText() + "\n";
        output += getMangaAsText() + "\n";
        output += getMoviesAsText();

        return output;
    }
    /**
     * getAnimeAsText is a getter method that returns a string with a format of viewing and the data of the anime.
     * @return the String containing the format of the viewing and it's data
     */
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
    /**
     * getMoviesAsText is a getter method that returns a string with a format of viewing and the data of the movies.
     * @return the String containing the format of the viewing and it's data
     */
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

    /**
     * getMangaAsText is a getter method that returns a string with a format of viewing and the data of the manga.
     * @return the String containing the format of the viewing and it's data
     */

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

    /**
     * getSummaryText is a getter method that is used when displaying the stats of a user (i.e the number of
     * their stored medias, progress towards the media, completed ratings, etc.)
     * @return the string that contains all the data to be displayed when user wants to view stats.
     */
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
    /**
     * movieToText is a method that returns the necessary info of
     * the movie media type, which will be used to be displayed when viewed.
     * @param movie is the object for Movies that the user wants to display info about
     * @return output returns all the necessary info of the movie media type being tackled.
     */
    private String movieToText(Movies movie)
    {
        String output = "";

        output += "Title: " + movie.getTitle() + "\n";
        output += "Studio: " + movie.getStudio() + "\n";
        output += "Status: " + movie.getStatus() + "\n";
        output += "Duration: " + movie.getDurationinmins() + " minutes\n";
        output += "Rating: " + movie.getRating().GetOverallrating() + "\n";

        if(movie.getRating().getReview() == null || movie.getRating().getReview().trim().isEmpty())
        {
            output += "Review: No review yet\n";
        }
        else
        {
            output += "Review: " + movie.getRating().getReview() + "\n";
        }

        output += "Description: " + movie.getDescription() + "\n";
        output += "ID: " + movie.getID() + "\n";

        return output;
    }

    /**
     * animeToText is a method that returns the necessary info of
     * the anime media type, which will be used to be displayed when viewed.
     * @param animeEntry is the object for anime that the user wants to display info about
     * @return output returns all the necessary info of the anime media type being tackled.
     */
    private String animeToText(Anime animeEntry)
    {
        String output = "";

        output += "Title: " + animeEntry.getTitle() + "\n";
        output += "Studio: " + animeEntry.getStudio() + "\n";
        output += "Status: " + animeEntry.getStatus() + "\n";
        output += "Seasons: " + animeEntry.getSeason() + "\n";

        int[] episodes = animeEntry.getEpisodes();
        ArrayList<EpisodeChapter> episodeList = animeEntry.getEpisodeList();
        int episodeIndex = 0;

        if(episodes != null)
        {
            for(int i = 0; i < animeEntry.getSeason(); i++)
            {
                output += "Season " + (i + 1) + ": " + episodes[i] + " episode/s\n";

                for(int j = 0; j < episodes[i] && episodeIndex < episodeList.size(); j++)
                {
                    EpisodeChapter episode = episodeList.get(episodeIndex);

                    output += "  Episode " + (j + 1) + ": " + episode.getTitle() + "\n";
                    output += "  Description: " + episode.getDescription() + "\n";
                    output += "  Length: " + episode.getLength() + " minutes\n";

                    episodeIndex++;
                }
            }
        }

        output += "Rating: " + animeEntry.getRating().GetOverallrating() + "\n";

        if(animeEntry.getRating().getReview() == null || animeEntry.getRating().getReview().trim().isEmpty())
        {
            output += "Review: No review yet\n";
        }
        else
        {
            output += "Review: " + animeEntry.getRating().getReview() + "\n";
        }

        output += "Description: " + animeEntry.getDescription() + "\n";
        output += "ID: " + animeEntry.getID() + "\n";

        return output;
    }

    /**
     * mangaToText is a method that returns the necessary info of
     * the manga media type, which will be used to be displayed when viewed.
     * @param manga is the object for manga that the user wants to display info about
     * @return all the necessary info of the manga media type being tackled.
     */
    private String mangaToText(ManhwaToMangaDesu manga)
    {
        String output = "";

        output += "Title: " + manga.getTitle() + "\n";
        output += "Studio/Publisher: " + manga.getStudio() + "\n";
        output += "Status: " + manga.getStatus() + "\n";
        output += "Volumes: " + manga.getVolume() + "\n";

        int[] chapters = manga.getChapter();
        ArrayList<EpisodeChapter> chapterList = manga.getChapterList();
        int chapterIndex = 0;

        if(chapters != null)
        {
            for(int i = 0; i < manga.getVolume(); i++)
            {
                output += "Volume " + (i + 1) + ": " + chapters[i] + " chapter/s\n";

                for(int j = 0; j < chapters[i] && chapterIndex < chapterList.size(); j++)
                {
                    EpisodeChapter chapterInfo = chapterList.get(chapterIndex);

                    output += "  Chapter " + (j + 1) + ": " + chapterInfo.getTitle() + "\n";
                    output += "  Description: " + chapterInfo.getDescription() + "\n";
                    output += "  Length/Pages: " + chapterInfo.getLength() + "\n";

                    chapterIndex++;
                }
            }
        }

        output += "Rating: " + manga.getRating().GetOverallrating() + "\n";

        if(manga.getRating().getReview() == null || manga.getRating().getReview().trim().isEmpty())
        {
            output += "Review: No review yet\n";
        }
        else
        {
            output += "Review: " + manga.getRating().getReview() + "\n";
        }

        output += "Description: " + manga.getDescription() + "\n";
        output += "ID: " + manga.getID() + "\n";

        return output;
    }

    /**
     * findEntryByID is a method that has an ID as a parameter to search for the media entry being searched by the user
     * @param id is the integer value of the media entry ID
     * @return the media entry with the same ID being searched for
     */
    public MediaEntry findEntryByID(int id)
    {
        for(Movies item : movies)
        {
            if(item.getID() == id)
            {
                return item;
            }
        }

        for(Anime item : anime)
        {
            if(item.getID() == id)
            {
                return item;
            }
        }

        for(ManhwaToMangaDesu item : mangadesho)
        {
            if(item.getID() == id)
            {
                return item;
            }
        }

        return null;
    }

    /**
     * deleteEntryByID is a method that returns true or false on the status of the deletion of a media, whether if a 
     * media exists with the parameter ID. If a media matches the ID in the parameter, the media gets deleted
     * @param id is the integer value of the ID of a media
     * @return true if media being deleted was found and removed, false if not found.
     */
    public boolean deleteEntryByID(int id)
    {
        for(int i = 0; i < movies.size(); i++)
        {
            if(movies.get(i).getID() == id)
            {
                movies.remove(i);
                return true;
            }
        }

        for(int i = 0; i < anime.size(); i++)
        {
            if(anime.get(i).getID() == id)
            {
                anime.remove(i);
                return true;
            }
        }

        for(int i = 0; i < mangadesho.size(); i++)
        {
            if(mangadesho.get(i).getID() == id)
            {
                mangadesho.remove(i);
                return true;
            }
        }

        return false;
    }
}

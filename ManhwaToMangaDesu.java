public class ManhwaToMangaDesu {
        private final String title;
        private int id = 100000;
        private static int incre = 1;//Static to generate unique ID
        private final String studio;
        private Rating rating = new Rating(); //Anime Rating
        private int volume;
        private String description;
        private String status = "Planned";
        private int[] chapter;

        //Constructor Methods here
        public ManhwaToMangaDesu(String title, String studio) {
            this.title = title;
            this.studio = studio;
            incre++;
            this.id = id + incre;
        }

        public ManhwaToMangaDesu(String title, String studio, String status) {
            this.title = title;
            this.studio = studio;
            this.status = status;
            incre++;
            this.id = id + incre;
        }

        public ManhwaToMangaDesu(String title, String studio, int volume) {
            this.title = title;
            this.studio = studio;
            this.volume = volume;
            incre++;
            this.id = id + incre;
        }

        public ManhwaToMangaDesu(String title, String studio, int volume, String status, int[] chapter) {
            this.title = title;
            this.studio = studio;
            this.volume = volume;
            this.status = status;
            this.chapter = chapter;
            incre++;
            this.id = id + incre;
        }

        //Getter Methods here
        public String getStatus() {
            return status;
        }

        public String getDescription() {
            return description;
        }

        public int getVolume() {
            return volume;
        }

        public int getID() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getStudio() {
            return studio;
        }

        public Rating getRating() {
            return rating;
        }

        public int[] getChapter() {
            return chapter;
        }

        public void displayInfo()
        {
            System.out.println(title);
            System.out.println("Production Studio: " + studio);
            System.out.println("Rating: " + rating.GetOverallrating());
            System.out.println("Volumes: " + volume);
            for(int i = 0; i < volume; i++)
            {
                System.out.println("Number of Chapters in Volume " + (i+1) + ": " + chapter[i]);
            }

            System.out.println("Status: " + status);
            System.out.println("Description: " + description);
            System.out.println("ID: " + id );
        }
}

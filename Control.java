import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Control implements ActionListener
{
    private JLayeredPane panel1;
    private JLabel[] label;
    private JButton[] button;
    private JTextField[] textFields;
    private String UserInput, UserInput2;
    private JPasswordField passwordField;
    private int i;
    private ArrayList<User> users = new ArrayList<>();
    boolean isTrue;
    User loginUser;
    GUI guiFace;

    /**
     * Control() is a no-parameter constructor that creates the class that acts as a communicator between the frontend and the
     * backend. This is also where the button actions are placed. This function/constructor creates a new
     * object of the Control class.
     */
    Control()
    {
        this.guiFace = new GUI();
        this.button = guiFace.getButton();
        this.label = guiFace.getLabel();
        this.textFields = guiFace.getTextFields();
        this.passwordField = guiFace.getPasswordField();
        this.panel1 = guiFace.getPanel1();
        for(i = 0;i < button.length; i++)
        {
            button[i].addActionListener(this);
        }
    }
    /**
     * hasLoggedInUser is a function that checks whether a user is currently logged-in
     * @return true if there is a logged-in user, otherwise return false.
     */
    private boolean hasLoggedInUser()
    {
        if(loginUser == null)
        {
            JOptionPane.showMessageDialog(guiFace, "Please log in first.");
            return false;
        }

        return true;
    }
    /**
     * showLargeMessage is a function that displays a tab that is often used for the viewing of media.
     * @param title is the name of the action to be done by the user
     * @param message is the string containing all the information to display
     */
    private void showLargeMessage(String title, String message)
    {
        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(guiFace, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * addMovieThroughDialog is a method that adds a Movie via a dialog that processes what the user wants to add by
     * including the details necessary to create a Movie object, can only perform when a specific button is pressed.
     */
    private void addMovieThroughDialog()
    {
        if(!hasLoggedInUser())
        {
            return;
        }

        try
        {
            String title = JOptionPane.showInputDialog(guiFace, "Enter movie title:");

            if(title == null || title.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Movie title cannot be blank.");
                return;
            }

            String studio = JOptionPane.showInputDialog(guiFace, "Enter studio/production:");

            if(studio == null || studio.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Studio cannot be blank.");
                return;
            }

            String durationText = JOptionPane.showInputDialog(guiFace, "Enter duration in minutes:");

            if(durationText == null || durationText.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Duration cannot be blank.");
                return;
            }

            int duration = Integer.parseInt(durationText);

            if(duration < 0)
            {
                JOptionPane.showMessageDialog(guiFace, "Duration cannot be negative.");
                return;
            }

            String[] statusChoices = {"Planned", "In Progress", "Completed"};

            String status = (String) JOptionPane.showInputDialog(
                    guiFace,
                    "Choose status:",
                    "Movie Status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    statusChoices,
                    statusChoices[0]
            );

            if(status == null)
            {
                return;
            }

            String description = JOptionPane.showInputDialog(guiFace, "Enter description:");

            Movies movie = new Movies(title, studio, duration, status);

            if(description != null)
            {
                movie.setDescription(description);
            }

            loginUser.getLibrary().addMovie(movie);

            JOptionPane.showMessageDialog(guiFace, "Movie added successfully!\nMovie ID: " + movie.getID());
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(guiFace, "Invalid duration. Please enter a number.");
        }
    }
    /**
     * addAnimeThroughDialog is a method that adds a Anime via a dialog that processes what the user wants to add by
     * including the details necessary to create a Anime object, can only perform when a specific button is pressed.
     */
    private void addAnimeThroughDialog()
    {
        if(!hasLoggedInUser())
        {
            return;
        }

        try
        {
            String title = JOptionPane.showInputDialog(guiFace, "Enter anime title:");

            if(title == null || title.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Anime title cannot be blank.");
                return;
            }

            String studio = JOptionPane.showInputDialog(guiFace, "Enter studio:");

            if(studio == null || studio.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Studio cannot be blank.");
                return;
            }

            String seasonText = JOptionPane.showInputDialog(guiFace, "Enter number of seasons:");

            if(seasonText == null || seasonText.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Number of seasons cannot be blank.");
                return;
            }

            int season = Integer.parseInt(seasonText);

            if(season < 0)
            {
                JOptionPane.showMessageDialog(guiFace, "Number of seasons cannot be negative.");
                return;
            }

            int[] episodes = new int[season];

            for(int i = 0; i < season; i++)
            {
                String episodeText = JOptionPane.showInputDialog(guiFace, "Enter episodes for Season " + (i + 1) + ":");

                if(episodeText == null || episodeText.trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(guiFace, "Episode count cannot be blank.");
                    return;
                }

                episodes[i] = Integer.parseInt(episodeText);

                if(episodes[i] < 0)
                {
                    JOptionPane.showMessageDialog(guiFace, "Episode count cannot be negative.");
                    return;
                }
            }

            String[] statusChoices = {"Planned", "In Progress", "Completed"};

            String status = (String) JOptionPane.showInputDialog(
                    guiFace,
                    "Choose status:",
                    "Anime Status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    statusChoices,
                    statusChoices[0]
            );

            if(status == null)
            {
                return;
            }

            String description = JOptionPane.showInputDialog(guiFace, "Enter description:");

            Anime anime = new Anime(title, studio, episodes, season, status);

            if(description != null)
            {
                anime.setDescription(description);
            }

            loginUser.getLibrary().addAnime(anime);

            JOptionPane.showMessageDialog(guiFace, "Anime added successfully!\nAnime ID: " + anime.getID());
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(guiFace, "Invalid number. Please enter numbers only.");
        }
    }
    /**
     * addMangaThroughDialog is a method that adds a Manga via a dialog that processes what the user wants to add by
     * including the details necessary to create a Manga object, can only perform when a specific button is pressed.
     */
    private void addMangaThroughDialog()
    {
        if(!hasLoggedInUser())
        {
            return;
        }

        try
        {
            String title = JOptionPane.showInputDialog(guiFace, "Enter manga/manhwa/webtoon title:");

            if(title == null || title.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Title cannot be blank.");
                return;
            }

            String studio = JOptionPane.showInputDialog(guiFace, "Enter publisher/studio:");

            if(studio == null || studio.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Publisher/studio cannot be blank.");
                return;
            }

            String volumeText = JOptionPane.showInputDialog(guiFace, "Enter number of volumes:");

            if(volumeText == null || volumeText.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Number of volumes cannot be blank.");
                return;
            }

            int volume = Integer.parseInt(volumeText);

            if(volume < 0)
            {
                JOptionPane.showMessageDialog(guiFace, "Number of volumes cannot be negative.");
                return;
            }

            int[] chapters = new int[volume];

            for(int i = 0; i < volume; i++)
            {
                String chapterText = JOptionPane.showInputDialog(guiFace, "Enter chapters for Volume " + (i + 1) + ":");

                if(chapterText == null || chapterText.trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(guiFace, "Chapter count cannot be blank.");
                    return;
                }

                chapters[i] = Integer.parseInt(chapterText);

                if(chapters[i] < 0)
                {
                    JOptionPane.showMessageDialog(guiFace, "Chapter count cannot be negative.");
                    return;
                }
            }

            String[] statusChoices = {"Planned", "In Progress", "Completed"};

            String status = (String) JOptionPane.showInputDialog(
                    guiFace,
                    "Choose status:",
                    "Manga/Manhwa Status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    statusChoices,
                    statusChoices[0]
            );

            if(status == null)
            {
                return;
            }

            String description = JOptionPane.showInputDialog(guiFace, "Enter description:");

            ManhwaToMangaDesu manga = new ManhwaToMangaDesu(title, studio, volume, status, chapters);

            if(description != null)
            {
                manga.setDescription(description);
            }

            loginUser.getLibrary().addManga(manga);

            JOptionPane.showMessageDialog(guiFace, "Manga/Manhwa added successfully!\nEntry ID: " + manga.getID());
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(guiFace, "Invalid number. Please enter numbers only.");
        }
    }

    private void rateEntryThroughDialog(String expectedType)
    {
        if(!hasLoggedInUser())
        {
            return;
        }

        try
        {
            String idText = JOptionPane.showInputDialog(guiFace, "Enter the ID of the entry you want to rate:");

            if(idText == null || idText.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "ID cannot be blank.");
                return;
            }

            int id = Integer.parseInt(idText);

            MediaEntry entry = loginUser.getLibrary().findEntryByID(id);

            if(entry == null)
            {
                JOptionPane.showMessageDialog(guiFace, "No entry found with that ID.");
                return;
            }

            if(!entry.getMediaType().equalsIgnoreCase(expectedType))
            {
                JOptionPane.showMessageDialog(guiFace, "That ID is for a " + entry.getMediaType() + ", not " + expectedType + ".");
                return;
            }

            if(!entry.getStatus().equals("Completed"))
            {
                JOptionPane.showMessageDialog(guiFace, "Only completed entries can be rated or reviewed.");
                return;
            }

            String ratingText = JOptionPane.showInputDialog(guiFace, "Enter rating from 1 to 10:");

            if(ratingText == null || ratingText.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "Rating cannot be blank.");
                return;
            }

            int rating = Integer.parseInt(ratingText);

            if(rating < 1 || rating > 10)
            {
                JOptionPane.showMessageDialog(guiFace, "Rating must be from 1 to 10.");
                return;
            }

            String review = JOptionPane.showInputDialog(guiFace, "Enter review:");

            entry.rateMedia(rating);

            if(review != null)
            {
                entry.addReview(review);
            }

            JOptionPane.showMessageDialog(guiFace, expectedType + " rated successfully!");
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(guiFace, "Invalid input. Please enter numbers only for ID and rating.");
        }
    }

    private void removeEntryThroughDialog()
    {
        if(!hasLoggedInUser())
        {
            return;
        }

        try
        {
            String idText = JOptionPane.showInputDialog(guiFace, "Enter the ID of the entry you want to remove:");

            if(idText == null || idText.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(guiFace, "ID cannot be blank.");
                return;
            }

            int id = Integer.parseInt(idText);

            MediaEntry entry = loginUser.getLibrary().findEntryByID(id);

            if(entry == null)
            {
                JOptionPane.showMessageDialog(guiFace, "No entry found with that ID.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    guiFace,
                    "Remove this entry?\n\n" + entry.getTitle() + " (" + entry.getMediaType() + ")",
                    "Confirm Remove",
                    JOptionPane.YES_NO_OPTION
            );

            if(confirm == JOptionPane.YES_OPTION)
            {
                boolean removed = loginUser.getLibrary().deleteEntryByID(id);

                if(removed)
                {
                    JOptionPane.showMessageDialog(guiFace, "Entry removed successfully.");
                }
                else
                {
                    JOptionPane.showMessageDialog(guiFace, "Entry could not be removed.");
                }
            }
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(guiFace, "Invalid ID. Please enter numbers only.");
        }
    }

    private void changeStatusThroughDialog()
        {
            if(!hasLoggedInUser())
            {
                return;
            }

            try
            {
                String idText = JOptionPane.showInputDialog(guiFace, "Enter the ID of the entry you want to update:");

                if(idText == null || idText.trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(guiFace, "ID cannot be blank.");
                    return;
                }

                int id = Integer.parseInt(idText);

                MediaEntry entry = loginUser.getLibrary().findEntryByID(id);

                if(entry == null)
                {
                    JOptionPane.showMessageDialog(guiFace, "No entry found with that ID.");
                    return;
                }

                String[] statusChoices = {"Planned", "In Progress", "Completed"};

                String status = (String) JOptionPane.showInputDialog(
                        guiFace,
                        "Choose new status for: " + entry.getTitle(),
                        "Change Status",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        statusChoices,
                        entry.getStatus()
                );

                if(status == null)
                {
                    return;
                }

                entry.setStatus(status);

                JOptionPane.showMessageDialog(guiFace, "Status updated successfully to: " + status);
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(guiFace, "Invalid ID. Please enter numbers only.");
            }
        }

    /**
     * actionPerformed is a method that performs specific actions depending on the button pressed by the user
     * @param e the event to be processed through a button object
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0]) //TO LOGIN
        {
            label[3].setText("");
            button[5].setVisible(false);
            button[4].setVisible(true);
            button[1].setVisible(false);
            button[0].setVisible(false);
            button[3].setVisible(true);
            textFields[0].setVisible(true);
            passwordField.setVisible(true);
            label[1].setVisible(true);
            label[2].setVisible(true);
            label[3].setVisible(true);
        }
        if (e.getSource() == button[1]) //TO CREATE ACCOUNT
        {
            label[3].setText("");
            button[5].setVisible(false);
            button[4].setVisible(true);
            button[2].setVisible(true);
            button[1].setVisible(false);
            button[0].setVisible(false);
            textFields[0].setVisible(true);
            textFields[1].setVisible(true);
            label[0].setIcon(new ImageIcon("titlepage.jpg"));
            label[1].setVisible(true);
            label[2].setVisible(true);
            label[3].setVisible(true);
        }
        if (e.getSource() == button[2]) //CREATE ACCOUNT
        {
            label[3].setFont(new Font("Gothic", Font.PLAIN, 11));
            label[3].setForeground(Color.decode("#C82909"));
            UserInput = textFields[0].getText();
            UserInput2 = textFields[1].getText();

            textFields[0].setText("");
            textFields[1].setText("");

            for (i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(UserInput)) {
                    isTrue = true;
                }
            }

            if (UserInput.isEmpty() && UserInput2.isEmpty()) {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 8));
                label[3].setText("Error: Username and Password cannot be blank!");

            } else if (UserInput.isEmpty()) {
                label[3].setText("Error: Username cannot be blank!");

            } else if (UserInput2.isEmpty()) {
                label[3].setText("Error: Password cannot be blank!");
            } else if (UserInput.contains(" ")) {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 9));
                label[3].setText("Error: Username cannot contain spaces!");
            } else if (UserInput2.length() < 8) {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 9));
                label[3].setText("Error: Password must be 8 characters above");
            } else if (isTrue) {
                isTrue = false;
                label[3].setText("Error: User already exists!");
            } else {
                users.add(new User(UserInput, UserInput2));
                label[3].setForeground(Color.decode("#219100"));
                label[3].setText("Success: Created Account!");
            }


        }
        if (e.getSource() == button[3]) //LOGIN
        {
            label[3].setFont(new Font("Gothic", Font.PLAIN, 11));
            label[3].setForeground(Color.decode("#C82909"));
            UserInput = textFields[0].getText();
            UserInput2 = String.valueOf(passwordField.getPassword());

            textFields[0].setText("");
            passwordField.setText("");

            for (i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(UserInput) && users.get(i).getPassword().equals(UserInput2)) {
                    loginUser = users.get(i);
                    isTrue = true;
                }
            }

            if (UserInput.isEmpty() && UserInput2.isEmpty()) {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 8));
                label[3].setText("Error: Username and Password cannot be blank!");

            } else if (UserInput.isEmpty()) {
                label[3].setText("Error: Username cannot be blank!");

            } else if (UserInput2.isEmpty()) {
                label[3].setText("Error: Password cannot be blank!");
            } else if (isTrue) {
                label[3].setForeground(Color.decode("#219100"));
                label[3].setText("Success: Logging in!");
                label[4].setText("");
                for (i = 1; i < label.length; i++) {
                    if (i == 3) {
                        label[i].setVisible(true);
                    } else {
                        label[i].setVisible(false);
                    }
                }

                textFields[0].setVisible(false);
                passwordField.setVisible(false);

                for (i = 0; i < button.length; i++) {
                    if (i == 6) {
                        button[6].setVisible(true);
                    } else {
                        button[i].setVisible(false);
                    }
                }
            } else {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 8));
                label[3].setText("Error: Password/Username does not match!");
            }


        }
        if (e.getSource() == button[4]) //BACK
        {
            for (i = 0; i < button.length; i++) {
                if (i == 0 || i == 1 || i == 5) {
                    button[i].setVisible(true);
                } else {
                    button[i].setVisible(false);
                }
            }
            textFields[0].setVisible(false);
            textFields[1].setVisible(false);
            passwordField.setVisible(false);
            label[0].setIcon(new ImageIcon("createaccount.jpg"));
            for (i = 1; i < label.length; i++) {
                label[i].setVisible(false);
            }
        }
        if (e.getSource() == button[5]) //RETURN TO DESKTOP
        {
            System.exit(0);
        }
        if (e.getSource() == button[6]) //TO MENU
        {
            for (i = 1; i < label.length; i++) //Text
            {
                if (i == 4) {
                    label[i].setVisible(true);
                } else {
                    label[i].setVisible(false);
                }
            }
            for (i = 0; i < button.length; i++) //Button
            {
                if (i == 7 || (i < 15 && i > 9)) {
                    button[i].setVisible(true);
                } else {
                    button[i].setVisible(false);
                }

            }
            textFields[0].setVisible(false);
            textFields[1].setVisible(false);
            passwordField.setVisible(false);
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));

        }
        if (e.getSource() == button[7])//LOG OUT BUTTON
        {
            label[0].setIcon(new ImageIcon("LogOut.jpg"));
            for (i = 0; i < button.length; i++) //Buttons
            {
                if (i == 8 || i == 9) {
                    button[i].setVisible(true);
                } else {
                    button[i].setVisible(false);
                }
            }
            for (i = 1; i < label.length; i++) {
                if (i == 5) {
                    label[5].setVisible(true);
                } else {
                    label[i].setVisible(false);
                }
            }

        }
        if (e.getSource() == button[8]) //LOG OUT
        {
            label[0].setIcon(new ImageIcon("createaccount.jpg"));
            textFields[0].setVisible(false);
            textFields[1].setVisible(false);
            passwordField.setVisible(false);
            for(i = 0; i < button.length; i++)
            {
                if(i == 0 || i == 1 || i == 5)
                {
                    button[i].setVisible(true);
                }
                else
                {
                    button[i].setVisible(false);
                }
            }
            for(i = 1; i < label.length; i++)
            {
                label[i].setVisible(false);
            }
        }
        if (e.getSource() == button[9]) //CANCEL
        {
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));
            for (i = 1; i < label.length; i++) //Text
            {
                if (i == 4) {
                    label[i].setVisible(true);
                } else {
                    label[i].setVisible(false);
                }
            }
            for (i = 0; i < button.length; i++) //Button
            {
                if (i == 7 || (i < 15 && i > 9))
                {
                    button[i].setVisible(true);
                }
                else
                {
                    button[i].setVisible(false);
                }

            }
            textFields[0].setVisible(false);
            textFields[1].setVisible(false);
            passwordField.setVisible(false);
        }
        if(e.getSource()==button[10]) //VIEW LIBRARY
        {
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));
            label[6].setText("View Library");
            label[6].setVisible(true);
            for(i = 0; i < button.length; i++)
            {
                if(i >= 15 && i <= 18)
                {
                    button[i].setVisible(true);
                }
            }


        }
        if(e.getSource()==button[11]) //ADD LIBRARY
        {
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));
            label[6].setText("Add Library");
            label[6].setVisible(true);
            for(i = 0; i < button.length; i++)
            {
                if((i >= 19 && i <= 21) || (i < 15 && i > 9) || i == 7)
                {
                    button[i].setVisible(true);
                }
                else
                {
                    button[i].setVisible(false);
                }
            }
        }
        if(e.getSource()==button[12]) //VIEW STATS
        {
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));
            label[6].setText("View Stats");
            label[6].setVisible(true);
            for(i = 0; i < button.length; i++)
            {
                if((i < 15 && i > 9) || i == 7)
                {
                    button[i].setVisible(true);
                }
                else
                {
                    button[i].setVisible(false);
                }
            }
            if(hasLoggedInUser())
            {
                showLargeMessage("Library Stats", loginUser.getLibrary().getSummaryText());
            }

        }
        if(e.getSource()==button[13]) //RATE COMPLETED ENTRY
        {
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));
            label[6].setText("Rate Completed Entry");
            label[6].setVisible(true);
            for(i = 0; i < button.length; i++)
            {
                if((i >= 22 && i <= 24) || (i < 15 && i > 9) || i == 7)
                {
                    button[i].setVisible(true);
                }
                else
                {
                    button[i].setVisible(false);
                }
            }
        }
        if(e.getSource()==button[14]) //MODIFY MEDIA
        {
            label[0].setIcon(new ImageIcon("MenuPage.jpg"));
            label[6].setText("Modify Media");
            label[6].setVisible(true);
            for(i = 0; i < button.length; i++)
            {
                if(i == 25 || i == 26 || (i < 15 && i > 9) || i == 7)
                {
                    button[i].setVisible(true);
                }
                else
                {
                    button[i].setVisible(false);
                }
            }
        }
        if(e.getSource()==button[15]) //VIEW LIBRARY: VIEW ALL
        {
            label[0].setIcon(new ImageIcon("ViewAll.jpg"));

            if(hasLoggedInUser())
            {
                showLargeMessage("View All Entries", loginUser.getLibrary().getAllEntriesAsText());
            }
        }
        if(e.getSource()==button[16]) //VIEW LIBRARY: VIEW BY MOVIES
        {
            label[0].setIcon(new ImageIcon("ViewMovie.jpg"));

            if(hasLoggedInUser())
            {
                showLargeMessage("View Movies", loginUser.getLibrary().getMoviesAsText());
            }
        }
        if(e.getSource()==button[17]) //VIEW LIBRARY: VIEW BY ANIME
        {
            label[0].setIcon(new ImageIcon("ViewAnime.jpg"));

            if(hasLoggedInUser())
            {
                showLargeMessage("View Anime", loginUser.getLibrary().getAnimeAsText());
            }
        }
        if(e.getSource()==button[18]) //VIEW LIBRARY: VIEW BY MANGA
        {
            label[0].setIcon(new ImageIcon("ViewManga.jpg"));

            if(hasLoggedInUser())
            {
                showLargeMessage("View Manga/Manhwa", loginUser.getLibrary().getMangaAsText());
            }
        }
        if(e.getSource()==button[19]) //ADD TO LIBRARY: ADD MOVIE
        {
            label[0].setIcon(new ImageIcon("AddMedia.jpg"));
            addMovieThroughDialog();
        }
        if(e.getSource()==button[20]) //ADD TO LIBRARY: ADD ANIME
        {
            label[0].setIcon(new ImageIcon("AddMedia.jpg"));
            addAnimeThroughDialog();
        }
        if(e.getSource()==button[21]) //ADD TO LIBRARY: ADD MANGA
        {
            label[0].setIcon(new ImageIcon("AddMedia.jpg"));
            addMangaThroughDialog();
        }
        if(e.getSource()==button[22]) //RATE COMPLETED ENTRY: RATE MOVIE
        {
            label[0].setIcon(new ImageIcon("AddTo.jpg"));
            rateEntryThroughDialog("Movie");
        }
        if(e.getSource()==button[23]) //RATE COMPLETED ENTRY: RATE ANIME
        {
            label[0].setIcon(new ImageIcon("AddTo.jpg"));
            rateEntryThroughDialog("Anime");
        }
        if(e.getSource()==button[24]) //RATE COMPLETED ENTRY: RATE MANGA
        {
            label[0].setIcon(new ImageIcon("AddTo.jpg"));
            rateEntryThroughDialog("Manga/Manhwa");
        }
        if(e.getSource()==button[25]) //MODIFY MEDIA: REMOVE MEDIA
        {
            label[0].setIcon(new ImageIcon("Modify.jpg"));
             removeEntryThroughDialog();
        }
        if(e.getSource()==button[26]) //MODIFY MEDIA: CHANGE STATUS
        {
            label[0].setIcon(new ImageIcon("Modify.jpg"));
            changeStatusThroughDialog();
        }

    }
}

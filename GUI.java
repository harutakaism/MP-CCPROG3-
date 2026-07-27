import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    JLayeredPane panel, panel1;
    JLabel[] label = new JLabel[6];
    ImageIcon picture;
    JButton[] button = new JButton[15];
    JTextField[] textFields = new JTextField[10];
    JPasswordField passwordField;
    int i;

    GUI()
    {
        picture = new ImageIcon("src/createaccount.jpg");

        label[0] = new JLabel();
        label[0].setIcon(picture);
        label[0].setBounds(0,0, picture.getIconWidth(), picture.getIconHeight());

        textFields[0] = new JTextField();
        textFields[0].setEditable(true);
        textFields[0].setFont(new Font("Gothic", Font.PLAIN, 14));
        textFields[0].setBounds(412,384,200,50);
        textFields[0].setVisible(false);

        textFields[1] = new JTextField();
        textFields[1].setEditable(true);
        textFields[1].setFont(new Font("Gothic", Font.PLAIN, 14));
        textFields[1].setBounds(412,484,200,50);
        textFields[1].setVisible(false);

        passwordField = new JPasswordField();
        passwordField.setEditable(true);
        passwordField.setFont(new Font("Gothic", Font.PLAIN, 14));
        passwordField.setBounds(412,484,200,50);
        passwordField.setVisible(false);

        //LOGIN PAGE
        button[0] = new JButton("Log In");
        button[0].setBounds(412,384,200,50);

        //CREATE ACCOUNT PAGE
        button[1] = new JButton("Create Account");
        button[1].setBounds(412,484,200,50);

        //CREATE THE USER
        button[2] = new JButton("Create User");
        button[2].setBounds(412,584,200,50);
        button[2].setVisible(false);

        //LOG IN
        button[3] = new JButton("Log In");
        button[3].setBounds(412,584,200,50);
        button[3].setVisible(false);

        //RETURN TO START PAGE
        button[4] = new JButton("Back");
        button[4].setBounds(462,684,100,25);
        button[4].setVisible(false);

        button[5] = new JButton("Exit to Desktop");
        button[5].setBounds(412,584,200,25);

        label[1] = new JLabel("Username");
        label[1].setFont(new Font("Gothic", Font.PLAIN, 14));
        label[1].setBounds(477,354,200,25);
        label[1].setVisible(false);

        label[2] = new JLabel("Password");
        label[2].setFont(new Font("Gothic", Font.PLAIN, 14));
        label[2].setBounds(477,454,200,25);
        label[2].setVisible(false);

        label[3] = new JLabel();
        label[3].setFont(new Font("Gothic", Font.PLAIN, 11));
        label[3].setForeground(Color.decode("#C82909"));
        label[3].setBounds(412,324,200,25);
        label[3].setVisible(false);

        label[4] = new JLabel("Welcome Back!");
        label[4].setFont(new Font("Gothic", Font.PLAIN, 11));
        label[4].setForeground(Color.decode("#C82909"));
        label[4].setBounds(412,324,200,25);
        label[4].setVisible(false);

        button[6] = new JButton("Alright, im in!");
        button[6].setBounds(412,384,200,50);
        button[6].setVisible(false);

        //BUTTONS IN MENU PAGE: LOG OUT

        button[7] = new JButton("Log Out");
        button[7].setBounds(800,684,200,50);
        button[7].setVisible(false);

        button[8] = new JButton("Log Out");
        button[8].setBounds(412,484,200,50);
        button[8].setVisible(false);

        button[9] = new JButton("Cancel");
        button[9].setBounds(412,584,200,50);
        button[9].setVisible(false);

        // BUTTONS IN MENU PAGE
        button[10] = new JButton("View to Library");
        button[10].setBounds(800,434,200,50);
        button[10].setVisible(false);

        button[11] = new JButton("Add to Library");
        button[11].setBounds(800,484,200,50);
        button[11].setVisible(false);

        button[12] = new JButton("View Stats");
        button[12].setBounds(800,534,200,50);
        button[12].setVisible(false);

        button[13] = new JButton("Rate Completed Entry");
        button[13].setBounds(800,584,200,50);
        button[13].setVisible(false);

        button[14] = new JButton("Modify Media");
        button[14].setBounds(800,634,200,50);
        button[14].setVisible(false);


        //LABELS IN MENU PAGE
        label[4] = new JLabel("Yon!");
        label[4].setBounds(412,324,200,25);
        label[4].setVisible(false);

        label[5] = new JLabel("Are chuu sure you wanna log out?");
        label[5].setFont(new Font("Gothic", Font.PLAIN, 11));
        label[5].setBounds(412,424,200,25);
        label[5].setVisible(false);

        panel = new JLayeredPane();
        panel.setLayout(null);
        panel.add(textFields[0]);
        panel.add(textFields[1]);
        panel.add(passwordField);
        for(i = 0; i < button.length; i++)
        {
            panel.add(button[i]);
        }
        panel.add(label[0], JLayeredPane.DEFAULT_LAYER);
        for(i = 1; i < label.length; i++)
        {
            panel.add(label[i], JLayeredPane.PALETTE_LAYER);
        }


        //MAIN PAGE PANEL

        this.setTitle("OtakuVaulto");
        this.setSize(1024,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);




    }
    public JButton[] getButton()
    {
        return button;
    }
    public JLabel[] getLabel(){ return label;}
    public JTextField[] getTextFields(){ return textFields; }
    public JPasswordField getPasswordField(){return passwordField; }
    public JLayeredPane getPanel1(){return panel1;}
}

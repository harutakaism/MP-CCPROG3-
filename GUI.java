import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener
{
    JLayeredPane panel;
    JLabel[] label = new JLabel[10];
    ImageIcon picture;
    JButton[] button = new JButton[10];
    JTextField[] textFields = new JTextField[10];
    String UserInput, UserInput2;
    JPasswordField passwordField;
    int i;
    ArrayList<User> users = new ArrayList<>();
    boolean isTrue;


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
        button[0].addActionListener(this);

        //CREATE ACCOUNT PAGE
        button[1] = new JButton("Create Account");
        button[1].setBounds(412,484,200,50);
        button[1].addActionListener(this);

        //CREATE THE USER
        button[2] = new JButton("Create User");
        button[2].setBounds(412,584,200,50);
        button[2].addActionListener(this);
        button[2].setVisible(false);

        //LOG IN
        button[3] = new JButton("Log In");
        button[3].setBounds(412,584,200,50);
        button[3].addActionListener(this);
        button[3].setVisible(false);

        //RETURN TO START PAGE
        button[4] = new JButton("Back");
        button[4].setBounds(462,684,100,25);
        button[4].addActionListener(this);
        button[4].setVisible(false);

        button[5] = new JButton("Exit to Desktop");
        button[5].setBounds(412,584,200,25);
        button[5].addActionListener(this);

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

        panel = new JLayeredPane();
        panel.setLayout(null);
        panel.add(textFields[0]);
        panel.add(textFields[1]);
        panel.add(passwordField);
        panel.add(button[0]);
        panel.add(button[1]);
        panel.add(button[2]);
        panel.add(button[3]);
        panel.add(button[4]);
        panel.add(button[5]);
        panel.add(label[0], JLayeredPane.DEFAULT_LAYER);
        panel.add(label[1], JLayeredPane.PALETTE_LAYER);
        panel.add(label[2], JLayeredPane.PALETTE_LAYER);
        panel.add(label[3], JLayeredPane.PALETTE_LAYER);


        this.setTitle("OtakuVaulto");
        this.setSize(1024,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);




    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button[0]) //TO LOGIN
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
        if(e.getSource()==button[1]) //TO CREATE ACCOUNT
        {
            label[3].setText("");
            button[5].setVisible(false);
            button[4].setVisible(true);
            button[2].setVisible(true);
            button[1].setVisible(false);
            button[0].setVisible(false);
            textFields[0].setVisible(true);
            textFields[1].setVisible(true);
            label[0].setIcon(new ImageIcon("src/titlepage.jpg"));
            label[1].setVisible(true);
            label[2].setVisible(true);
            label[3].setVisible(true);
        }
        if(e.getSource()==button[2]) //CREATE ACCOUNT
        {
            label[3].setFont(new Font("Gothic", Font.PLAIN, 11));
            label[3].setForeground(Color.decode("#C82909"));
            UserInput = textFields[0].getText();
            UserInput2 = textFields[1].getText();
            System.out.println(UserInput);
            System.out.println(UserInput2);

            textFields[0].setText("");
            textFields[1].setText("");

            for(i = 0; i < users.size() ; i++)
            {
                if(users.get(i).getUsername().equals(UserInput))
                {
                    isTrue = true;
                }
            }

            if(UserInput.isEmpty() && UserInput2.isEmpty())
            {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 8));
                label[3].setText("Error: Username and Password cannot be blank!");

            }
            else if(UserInput.isEmpty())
            {
                label[3].setText("Error: Username cannot be blank!");

            }
            else if(UserInput2.isEmpty())
            {
                label[3].setText("Error: Password cannot be blank!");
            }
            else if(UserInput2.length() < 8)
            {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 9));
                label[3].setText("Error: Password must be 8 characters above");
            }
            else if(isTrue)
            {
                isTrue = false;
                label[3].setText("Error: User already exists!");
            }
            else
            {
                label[3].setForeground(Color.decode("#219100"));
                label[3].setText("Success: Created Account!");
            }



        }
        if(e.getSource()==button[3]) //LOGIN
        {
            label[3].setFont(new Font("Gothic", Font.PLAIN, 11));
            label[3].setForeground(Color.decode("#C82909"));
            UserInput = textFields[0].getText();
            UserInput2 = String.valueOf(passwordField.getPassword());
            System.out.println(UserInput);
            System.out.println(UserInput2);

            textFields[0].setText("");
            passwordField.setText("");

            for(i = 0; i < users.size() ; i++)
            {
                if(users.get(i).getUsername().equals(UserInput) && users.get(i).getPassword().equals(UserInput2))
                {
                    isTrue = true;
                }
            }

            if(UserInput.isEmpty() && UserInput2.isEmpty())
            {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 8));
                label[3].setText("Error: Username and Password cannot be blank!");

            }
            else if(UserInput.isEmpty())
            {
                label[3].setText("Error: Username cannot be blank!");

            }
            else if(UserInput2.isEmpty())
            {
                label[3].setText("Error: Password cannot be blank!");
            }
            else if(isTrue)
            {
                label[3].setForeground(Color.decode("#219100"));
                label[3].setText("Success: Logging in!");
            }
            else
            {
                label[3].setFont(new Font("Gothic", Font.PLAIN, 8));
                label[3].setText("Error: Password/Username does not match!");
            }



        }
        if(e.getSource()==button[4])
        {
            button[0].setVisible(true);
            button[1].setVisible(true);
            button[2].setVisible(false);
            button[3].setVisible(false);
            button[4].setVisible(false);
            button[5].setVisible(true);
            textFields[0].setVisible(false);
            textFields[1].setVisible(false);
            passwordField.setVisible(false);
            label[0].setIcon(new ImageIcon("src/createaccount.jpg"));
            label[1].setVisible(false);
            label[2].setVisible(false);
            label[3].setVisible(false);
        }
        if(e.getSource()==button[5])
        {
            System.exit(0);
        }

    }

}

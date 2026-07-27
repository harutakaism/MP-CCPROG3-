import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Control implements ActionListener
{
    private JLayeredPane panel, panel1;
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
    public void setLayeredPanel(JLayeredPane panelold, JLayeredPane panelnew)
    {
        guiFace.remove(panelold);
        guiFace.add(panelnew);
        panelnew.setVisible(true);
    }
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
            label[0].setIcon(new ImageIcon("src/titlepage.jpg"));
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
        if (e.getSource() == button[4]) {
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
            label[0].setIcon(new ImageIcon("src/createaccount.jpg"));
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

        }
        if (e.getSource() == button[7])//LOG OUT BUTTON
        {
            label[0].setIcon(new ImageIcon("src/LogOut.jpg"));
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
            label[0].setIcon(new ImageIcon("src/createaccount.jpg"));
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
            label[0].setIcon(new ImageIcon("src/createaccount.jpg"));
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
    }

    }
}

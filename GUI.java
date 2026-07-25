import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
    JPanel panel;
    JLabel label;
    ImageIcon picture;
    JButton button, button0, button1;

    GUI()
    {
        picture = new ImageIcon("src/createaccount.jpg");

        label = new JLabel();
        label.setIcon(picture);
        label.setBounds(0,0, picture.getIconWidth(), picture.getIconHeight());

        button = new JButton("Log In");
        button.setBounds(412,384,200,50);
        button.addActionListener(this);

        button0 = new JButton("Create Account");
        button0.setBounds(412,584,200,50);
        button0.addActionListener(this);

        button1 = new JButton("Create Account");
        button1.setBounds(412,584,200,50);
        button1.addActionListener(this);
        button1.setVisible(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.add(button);
        panel.add(button0);
        panel.add(button1);
        panel.add(label);

        this.setTitle("OtakuVaulto");
        this.setSize(1024,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(e.getSource()==button)
        {
            System.out.println("success");

        }
        else if(e.getSource()==button0)
        {
            button1.setVisible(true);
            button0.setVisible(false);
            button.setVisible(false);
            label.setIcon(new ImageIcon("src/titlepage.jpg"));

        }

    }

}

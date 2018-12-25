package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creator: Ayca Begum Tascioglu
 */

/**
 * a panel to create a screen for credits screen for the game
 * it extends the simple panel which is a JPanel with additional features such as
 * selection: int
 * theme: int
 * type: String
 */
public class CreditsScreen extends SimplePanel{
    JButton returnPrev = new JButton("Back");

    /**
     * CreditsScreen constructor to construct a credits panel which user can see the developers of the game
     */
    public CreditsScreen() {
        super();
        type = "credits";
        JLabel title = new JLabel("Credits");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        JLabel dev1 = new JLabel("Ayça Begum Tascioglu");
        dev1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev1.setForeground(Color.GREEN);
        JLabel dev2 = new JLabel("Erdem Ege Marasli");
        dev2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev2.setForeground(Color.GREEN);
        JLabel dev3 = new JLabel("Ensar Kaya");
        dev3.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev3.setForeground(Color.GREEN);
        JLabel dev4 = new JLabel("Hammad Malik");
        dev4.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev4.setForeground(Color.GREEN);
        JLabel dev5 = new JLabel("Alperen Koca");
        dev5.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev5.setForeground(Color.GREEN);
        returnPrev.addActionListener(buttonListen);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        this.add(dev1);
        this.add(dev2);
        this.add(dev3);
        this.add(dev4);
        this.add(dev5);
        this.add(returnPrev);
    }

    /**
     * getSelection method to get the selection of the panel
     * @return selection: int to change the current panel which is shown to the user
     */
    public int getSelection(){
        return selection;
    }

    /**
     * ButtonListener class a class which is created to take which button is clicked
     * based on this information it sets the selection and helps to change the current panel on the screen
     * if returnPrev button is clicked then selection = 0
     * if button1 is clicked selection = 1
     * if button2 is clicked selection = 2
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
        }
    }
}

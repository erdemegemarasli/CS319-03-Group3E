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
 * a panel to create a screen for campaign selection
 * it extends the simple panel which is a JPanel with additional features such as
 * selection: int
 * theme: int
 * type: String
 * user can select the harry potter campaign or game of thrones campaign
 */

public class campaignSelectionPanel extends SimplePanel{
    JButton returnPrev = new JButton("Back");
    JButton button1 = new JButton("Harry Potter Campaign");
    JButton button2 = new JButton("Game of Thrones Campaign");

    /**
     * campaignSelectionPanel to construct a panel for user to select a campaign for the game
     */
    public campaignSelectionPanel() {
        super();
        type = "campaignSelectionPanel";
        JLabel title = new JLabel("Select a Campaign to Play");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        button1.addActionListener(buttonListen);
        button1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        button2.addActionListener(buttonListen);
        button2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));


        returnPrev.addActionListener(buttonListen);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        this.add(button1);
        this.add(button2);

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
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }

            else if(event.getSource() == button1) {
                selection = 1;
            }

            else if(event.getSource() == button2) {
                selection = 2;
            }
        }
    }
}

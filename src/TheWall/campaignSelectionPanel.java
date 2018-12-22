package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class campaignSelectionPanel extends SimplePanel{
    JButton returnPrev = new JButton("Back");
    JButton button1 = new JButton("Harry Potter Campaign");
    JButton button2 = new JButton("Game of Thrones Campaign");
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
    public int getSelection(){
        return selection;
    }
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

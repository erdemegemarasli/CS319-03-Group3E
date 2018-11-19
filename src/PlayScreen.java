package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayScreen extends SimplePanel
{
    JButton button1 = new JButton("Classical Mode");
    JButton button2 = new JButton("Developer Mode");
    JButton button3 = new JButton("Challenge Mode");
    JButton button4 = new JButton("Campaign Mode");
    JButton returnPrev = new JButton("RETURN MAIN MENU");
    public PlayScreen()
    {
        super();
        type = "playScreen";
        JLabel title = new JLabel("Choose a Mode to Play!");
        this.add(title);
        ButtonListener listener = new ButtonListener();
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        returnPrev.addActionListener(listener);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(returnPrev);

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            if( event.getSource() == button1){
                selection = 1;
            }
            else if( event.getSource() == button2){
                selection = 2;
            }
            else if( event.getSource() == button3){
                selection = 3;
            }
            else if( event.getSource() == button4){
                selection = 4;
            }
            else if(event.getSource() == returnPrev) {
                selection = 0;
            }
        }
    }

}
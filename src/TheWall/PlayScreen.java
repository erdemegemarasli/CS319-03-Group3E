package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Creator: Erdem Ege Marasli and Ayca Begum Tascioglu
 */
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

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        button1.addActionListener(buttonListen);
        button2.addActionListener(buttonListen);
        button3.addActionListener(buttonListen);
        button4.addActionListener(buttonListen);
        returnPrev.addActionListener(buttonListen);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(returnPrev);

    }
    public int getSelection(){
        return selection;
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
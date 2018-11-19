package TheWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class MainMenu extends SimplePanel
{

    JButton button1 = new JButton("Play Game");
    JButton button2 = new JButton("Credits");
    JButton button3 = new JButton("Settings");
    JButton button4 = new JButton("How to Play");
    public MainMenu()
    {
        super();
        type = "playScreen";
        type = "mainScreen";
        JLabel wallString = new JLabel("The Wall");
        this.add(wallString);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        button1.addActionListener(buttonListen);
        button2.addActionListener(buttonListen);
        button3.addActionListener(buttonListen);
        button4.addActionListener(buttonListen);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == button1)
                selection = 1;
            else if(event.getSource() == button2)
                selection = 2;
            else if(event.getSource() == button3)
                selection = 3;
            else if(event.getSource() == button4)
                selection = 4;
        }
    }

}

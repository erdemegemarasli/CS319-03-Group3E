package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends SimplePanel{
    JButton returnPrev = new JButton("Back");
    JLabel backgroundtitle = new JLabel("Background:");
    JButton c1 = new JButton("Pink");
    JButton c2 = new JButton("Blue");
    JButton c3 = new JButton("Red");
    public Settings() {
        super();
        type = "settings";
        JLabel title = new JLabel("Settings");
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        c1.addActionListener(buttonListen);
        c2.addActionListener(buttonListen);
        c3.addActionListener(buttonListen);
        returnPrev.addActionListener(buttonListen);
        this.add(backgroundtitle);
        this.add(c1);
        this.add(c2);
        this.add(c3);

        this.add(returnPrev);

    }
    public int getSelection(){
        return selection;
    }
    public void setBG(Color color){

        setBackgroundofPanel(color);
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
            else if(event.getSource() == c1) {
                setBG(Color.PINK);
            }
            else if(event.getSource() == c2) {
                setBG(Color.blue);
            }
            else if(event.getSource() == c3) {
                setBG(Color.RED);
            }
        }
    }
}


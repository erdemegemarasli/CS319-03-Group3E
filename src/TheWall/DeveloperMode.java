package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeveloperMode extends SimplePanel{
    public static final Color VERY_LIGHT_BLUE = new Color(51,204,255);
    public static final Color MY_GREEN = new Color(89,180,100);
    JButton returnPrev = new JButton("Back");
    JButton play = new JButton("Play with already designed maps");
    JButton create = new JButton("Create a new Map");
    public DeveloperMode() {
        super();
        type = "developerMode";
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        JLabel title = new JLabel("Developer Mode");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);

        ButtonListener buttonListen = new ButtonListener();
        returnPrev.addActionListener(buttonListen);

        play.addActionListener(buttonListen);
        play.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        create.addActionListener(buttonListen);
        create.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        this.add(play);
        this.add(create);

        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
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
            if(event.getSource() == play) {
                selection = 1;
            }
            if(event.getSource() == create) {
                selection = 2;
            }
        }
    }
}

package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayScreen extends SimplePanel {
    JButton returnPrev = new JButton("Back");
    public HowToPlayScreen() {
        super();
        type = "howToPlay";
        JLabel title = new JLabel("HowToPlay");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        JLabel info = new JLabel("Choose a challenge. ");
        JLabel info1 = new JLabel("Place the red knights,the blue knights and high towers");
        JLabel info2 = new JLabel( "with blue rooftops on the game board as indicated.");
        JLabel info3 = new JLabel("The red knights are kept outside, ");
        JLabel info4 = new JLabel( "the blue knights and high towers remain ");
        JLabel info41 = new JLabel("within the ramparts.");
        JLabel info5 = new JLabel("There is only one solution per challenge.");

        JLabel texts[] = {info, info1,info2,info3, info4,info41};
        for ( int i = 0; i < texts.length; i++){
            texts[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            this.add(texts[i]);
        }
        info5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(info5);
        returnPrev.addActionListener(buttonListen);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));


        this.add(returnPrev);
    }

    public int getSelection(){
        return selection;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
        }
    }
}
